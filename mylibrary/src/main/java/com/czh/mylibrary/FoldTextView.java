package com.czh.mylibrary;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created  on 2018/5/26.
 * @author czh
 */
public class FoldTextView extends LinearLayout implements View.OnClickListener {

    /**
     * default text show max lines
     */
    public int lines = 2;

    private static final int COLLAPSIBLE_STATE_NONE = 0;
    private static final int COLLAPSIBLE_STATE_SHRINKUP = 1;
    private static final int COLLAPSIBLE_STATE_SPREAD = 2;
    public TextView desc;
    private TextView descOp;

    private String shrinkUp;
    private String spread;
    private int mState;
    private boolean flag;

    public FoldTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        shrinkUp = "收起";
        spread = "查看更多";
        View view = inflate(context, R.layout.fold_textview, this);
        desc = view.findViewById(R.id.tv_desc);
        descOp = view.findViewById(R.id.tv_desc_fold);
        descOp.setOnClickListener(this);
    }

    public FoldTextView(Context context) {
        this(context, null);
    }


    /**
     * 1.
     * 2. 对外提供暴漏的方法，为文本提供数据
     * 3. @param charSequence  文本内容是什么
     * 4. @param bufferType
     */
    public final void setDesc(CharSequence charSequence) {
        desc.setText(charSequence, TextView.BufferType.NORMAL);
        mState = COLLAPSIBLE_STATE_SPREAD;
        requestLayout();
    }

    @Override
    public void onClick(View v) {
        flag = false;
        requestLayout();
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        if (!flag) {
            flag = true;
            if (desc.getLineCount() <= lines) {
                mState = COLLAPSIBLE_STATE_NONE;
                descOp.setVisibility(View.GONE);
                desc.setMaxLines(lines + 1);
            } else {
                post(new InnerRunnable());
            }
        }
    }

    class InnerRunnable implements Runnable {
        @Override
        public void run() {
            if (mState == COLLAPSIBLE_STATE_SPREAD) {
                //收缩中
                Drawable downDrawable = getResources().getDrawable(R.mipmap.icon_arrow_down);
                downDrawable.setBounds(0, 0, downDrawable.getMinimumWidth(), downDrawable
                        .getMinimumHeight());
                desc.setMaxLines(lines);
                descOp.setVisibility(View.VISIBLE);
                descOp.setText(spread);
                descOp.setCompoundDrawables(null, null, null, downDrawable);
                mState = COLLAPSIBLE_STATE_SHRINKUP;
            } else if (mState == COLLAPSIBLE_STATE_SHRINKUP) {
                //已经展开
                Drawable upDrawable = getResources().getDrawable(R.mipmap.icon_arrow_up);
                upDrawable.setBounds(0, 0, upDrawable.getMinimumWidth(), upDrawable
                        .getMinimumHeight());
                desc.setMaxLines(Integer.MAX_VALUE);
                descOp.setVisibility(View.VISIBLE);
                descOp.setText(shrinkUp);
                descOp.setCompoundDrawables(null, upDrawable, null, null);
                mState = COLLAPSIBLE_STATE_SPREAD;
            }
        }
    }
}