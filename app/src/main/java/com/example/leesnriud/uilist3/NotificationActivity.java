package com.example.leesnriud.uilist3;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * android notification 状态栏通知
 * <p>
 * Icon/Photo：大图标
 * Title/Name：标题
 * Message：内容信息
 * Timestamp：通知时间，默认是系统发出通知的时间，也可以通过setWhen()来设置
 * Secondary Icon：小图标
 * 内容文字，在小图标的左手边的一个文字
 * <p>
 * Notification：通知信息类，它里面对应了通知栏的各个属性
 * NotificationManager：是状态栏通知的管理类，负责发通知、清除通知等操作。
 * 使用的基本流程：
 * Step 1. 获得NotificationManager对象： NotificationManager mNManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
 * Step 2. 创建一个通知栏的Builder构造类： Notification.Builder mBuilder = new Notification.Builder(this);
 * Step 3. 对Builder进行相关的设置，比如标题，内容，图标，动作等！
 * Step 4.调用Builder的build()方法为notification赋值
 * Step 5.调用NotificationManager的notify()方法发送通知！
 * PS:另外我们还可以调用NotificationManager的cancel()方法取消通知
 */
public class NotificationActivity extends AppCompatActivity {

    private NotificationManager mNManager;
    private Notification notify1;
    Bitmap LargeBitmap = null;
    private static final int NOTIFYID_1 = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        ButterKnife.bind(this);
        //创建大图标的Bitmap
        LargeBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
        mNManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
    }

    @OnClick({R.id.bt_show, R.id.bt_close})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_show:
                //定义一个PendingIntent点击Notification后启动一个Activity
                Intent it = new Intent(NotificationActivity.this, SpinnerActivity.class);
                PendingIntent pit = PendingIntent.getActivity(NotificationActivity.this, 0, it, 0);

                //设置图片,通知标题,发送时间,提示方式等属性
                Notification.Builder mBuilder = new Notification.Builder(this);
                mBuilder.setContentTitle("title")                        //标题
                        .setContentText("查看你的飞车段位")      //内容
                        .setSubText("——来自飞车")                    //内容下面的一小段文字
                        .setTicker("收到飞车信息")             //收到信息后状态栏显示的文字信息
                        .setWhen(System.currentTimeMillis())           //设置通知时间
                        .setSmallIcon(R.mipmap.loading_01)            //设置小图标
                        .setLargeIcon(LargeBitmap)                     //设置大图标
                        .setDefaults(Notification.DEFAULT_LIGHTS | Notification.DEFAULT_VIBRATE)    //设置默认的三色灯与振动器
                        .setSound(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.biaobiao))  //设置自定义的提示音
                        .setAutoCancel(true)                           //设置点击后取消Notification
                        .setContentIntent(pit);                        //设置PendingIntent
                notify1 = mBuilder.build();
                mNManager.notify(NOTIFYID_1, notify1);
                break;
            case R.id.bt_close:
                //除了可以根据ID来取消Notification外,还可以调用cancelAll();关闭该应用产生的所有通知
                mNManager.cancel(NOTIFYID_1);                          //取消Notification
                break;
        }
    }
}
