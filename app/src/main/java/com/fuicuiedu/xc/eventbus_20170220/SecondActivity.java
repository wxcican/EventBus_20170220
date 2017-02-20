package com.fuicuiedu.xc.eventbus_20170220;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.greenrobot.eventbus.EventBus;

public class SecondActivity extends AppCompatActivity {

    Button button_first;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        button_first = (Button) findViewById(R.id.btn_first_event);

        button_first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //发送一条消息（快递）
                EventBus.getDefault().post(new MessageEvent("面对疾风吧！"));
            }
        });
    }
}
