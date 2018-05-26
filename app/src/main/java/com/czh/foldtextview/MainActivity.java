package com.czh.foldtextview;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;

import com.czh.mylibrary.FoldTextView;

/**
 * Created  on 2018/5/26.
 * @author czh
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FoldTextView ftv = findViewById(R.id.ftv);
        ftv.setDesc("内容文本内容文本内容文本内容文本内容文本内容文本内容文本内容文本内容文本内容文本内容文本内容文本内容文本内容文本内容文本内容文本内容文本内容文本内容文本内容文本内容文本内容文本内容文本内容文本内容文本内容文本内容文本内容文本内容文本内容文本内容文本内容文本内容文本内容文本内容文本内容文本内容文本内容文本");
        //设置展开前最大行数
        ftv.lines = 3;
        ftv.desc.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
        ftv.desc.setTextColor(ContextCompat.getColor(this,R.color.colorAccent));
    }
}
