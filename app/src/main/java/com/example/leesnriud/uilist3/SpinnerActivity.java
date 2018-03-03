package com.example.leesnriud.uilist3;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * android spinner
 * <p>
 * android:dropDownHorizontalOffset：设置列表框的水平偏移距离
 * android:dropDownVerticalOffset：设置列表框的水平竖直距离
 * android:dropDownSelector：列表框被选中时的背景
 * android:dropDownWidth：设置下拉列表框的宽度
 * android:gravity：设置里面组件的对其方式
 * android:popupBackground：设置列表框的背景
 * android:prompt：设置对话框模式的列表框的提示信息(标题)，只能够引用string.xml 中的资源id,而不能直接写字符串
 * android:spinnerMode：列表框的模式，有两个可选值： dialog：对话框风格的窗口 dropdown：下拉菜单风格的窗口(默认)
 * 可选属性：android:entries：使用数组资源设置下拉列表框的列表项目
 */
public class SpinnerActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    private Context mContext;
    //判断是否为刚进去时触发onItemSelected的标志
    private boolean one_selected = false;
    private boolean two_selected = false;
    private ArrayList<Track> mData = null;
    private MyAdapter myAdadpter = null;

    @BindView(R.id.spin_one)
    Spinner spinOne;
    @BindView(R.id.spin_two)
    Spinner spinTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);
        ButterKnife.bind(this);
        mContext = SpinnerActivity.this;
        mData = new ArrayList<Track>();
        bindViews();
    }

    private void bindViews() {
        spinOne = (Spinner) findViewById(R.id.spin_one);
        spinTwo = (Spinner) findViewById(R.id.spin_two);

        mData.add(new Track(R.mipmap.loading_01,"霍比特之旅"));
        mData.add(new Track(R.mipmap.loading_02,"亚特兰蒂斯"));
        mData.add(new Track(R.mipmap.loading_03,"反向亚特兰蒂斯"));
        mData.add(new Track(R.mipmap.loading_04,"西部矿山"));
        mData.add(new Track(R.mipmap.loading_05,"秋名山"));
        mData.add(new Track(R.mipmap.loading_06,"美洲大峡谷"));

        myAdadpter = new MyAdapter<Track>(mData,R.layout.track) {
            @Override
            public void bindView(ViewHolder holder, Track obj) {
                holder.setImageResource(R.id.iv_track_icon,obj.getTrack_icon());
                holder.setText(R.id.tv_track_name, obj.getTrack_name());
            }
        };
        spinTwo.setAdapter(myAdadpter);
        spinOne.setOnItemSelectedListener(this);
        spinTwo.setOnItemSelectedListener(this);

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getId()){
            case R.id.spin_one:
                if(one_selected){
                    Toast.makeText(mContext,"分段 ：" + parent.getItemAtPosition(position).toString(),
                            Toast.LENGTH_SHORT).show();
                }else one_selected = true;
                break;
            case R.id.spin_two:
                if(two_selected){
                    TextView txt_name = view.findViewById(R.id.tv_track_name);
                    Toast.makeText(mContext,"拿手赛道 ：" + txt_name.getText().toString(),
                            Toast.LENGTH_SHORT).show();
                }else two_selected = true;
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
