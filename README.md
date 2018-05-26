## FoldTextView
可折叠TextView


use Gradle:

```

dependencies {
   implementation 'com.github.czh235285:FoldTextView:1.0'
}

```

in Xml:

```
    <com.czh.mylibrary.FoldTextView
        android:id="@+id/ftv"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"/>

```

in java:

```
 FoldTextView ftv = findViewById(R.id.ftv);
        ftv.setDesc("内容文本内容文本内容文本内容文本内容文本内容文本内容文本内容文本内容文本内容文本内容文本内容文本内容文本内容文本内容文本内容文本内容文本内容文本内容文本内容文本内容文本内容文本内容文本内容文本内容文本内容文本内容文本内容文本内容文本内容文本内容文本内容文本内容文本内容文本内容文本内容文本内容文本内容文本");
        //设置展开前最大行数,默认为2
        ftv.lines = 3;
        //ftv.desc.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
        //ftv.desc.setTextColor(ContextCompat.getColor(this,R.color.colorAccent));

```