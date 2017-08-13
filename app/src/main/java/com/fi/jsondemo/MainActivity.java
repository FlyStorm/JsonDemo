package com.fi.jsondemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //声明控件
    private TextView tv_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initListener();

    }

    private void initListener(){
        //省略
    }

    private void initView() {
        tv_title= (TextView) findViewById(R.id.tv_title);

        tv_title.setText("Json解析");
    }

    public void click01(View view){
        startActivity(new Intent(this,NativeJsonActivity.class));
    }
    public void click02(View view){

    }
    public void click03(View view){

    }
}
