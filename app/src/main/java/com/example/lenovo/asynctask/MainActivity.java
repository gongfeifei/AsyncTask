package com.example.lenovo.asynctask;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView mTvCounter;
    private Button mBtnStart; //private只能被当前类里的方法所调用
    private View.OnClickListener mylistener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            MyAsyncTask task = new MyAsyncTask(MainActivity.this);
            task.execute(20);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findView();
        setListener();
    }

    private void setListener() {
        mBtnStart.setOnClickListener(mylistener);
    }

    private void findView() {
        mTvCounter = (TextView) findViewById(R.id.tv_counter);
        mBtnStart = (Button) findViewById(R.id.btn_start);
    }
}
