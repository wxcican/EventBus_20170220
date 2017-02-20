package com.fuicuiedu.xc.eventbus_20170220;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;


/**
 * EventBus的使用
 * 首先要有一个消息的类（快递）
 * 1.在需要发消息的页面，执行EventBus发消息的方法（post）
 * 2.在需要接受消息的页面，执行注册EventBus的方法（register）
 * 3.处理消息，在接受的页面处理消息（通过注解的方式）
 * 4.用完之后，执行反注册EventBus的方法（unregister）
 * */

public class MainActivity extends AppCompatActivity {

    Button button;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //注册EventBus
        EventBus.getDefault().register(this);

        button = (Button) findViewById(R.id.btn_try);
        textView = (TextView) findViewById(R.id.tv);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(MessageEvent event){
        String msg = "onEvent收到了消息：" + event.getMessage();

        Toast.makeText(this, event.getMessage(), Toast.LENGTH_SHORT).show();

        textView.setText(msg);
    }
}
