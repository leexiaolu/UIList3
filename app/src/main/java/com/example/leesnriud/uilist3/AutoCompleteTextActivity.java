package com.example.leesnriud.uilist3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * android autocompletetextview
 * <p>
 * android:completionHint：设置下拉菜单中的提示标题
 * android:completionHintView：定义提示视图中显示下拉菜单
 * android:completionThreshold：指定用户至少输入多少个字符才会显示提示
 * android:dropDownAnchor：设置下拉菜单的定位"锚点"组件，如果没有指定改属性， 将使用该TextView作为定位"锚点"组件
 * android:dropDownHeight：设置下拉菜单的高度
 * android:dropDownWidth：设置下拉菜单的宽度
 * android:dropDownHorizontalOffset：指定下拉菜单与文本之间的水平间距
 * android:dropDownVerticalOffset：指定下拉菜单与文本之间的竖直间距
 * android:dropDownSelector：设置下拉菜单点击效果
 * android:popupBackground：设置下拉菜单的背景
 */
public class AutoCompleteTextActivity extends AppCompatActivity {

    private static final String[] data = new String[]{
            "张一一", "张三三", "张柳柳", "张张", "张战士"
    };

    @BindView(R.id.atv_content)
    AutoCompleteTextView atvContent;
    @BindView(R.id.matv_content)
    MultiAutoCompleteTextView matvContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_complete_text);
        ButterKnife.bind(this);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(AutoCompleteTextActivity.
                this, android.R.layout.simple_dropdown_item_1line, data);
        atvContent.setAdapter(adapter);

        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_dropdown_item_1line, data);
        matvContent.setAdapter(adapter);
        matvContent.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
    }
}
