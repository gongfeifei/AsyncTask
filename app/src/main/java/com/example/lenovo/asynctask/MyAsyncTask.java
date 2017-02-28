package com.example.lenovo.asynctask;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

/**
 * Created by lenovo on 2016/10/25.
 */
public class MyAsyncTask extends AsyncTask<Integer, Integer, String> {
    private Context context; //上下文环境

    public MyAsyncTask(Context context) {
        this.context = context;
    }

    /**
     * 必须实现的方法，该方法中执行具体的任务
     * @param params
     * @return
     */
    @Override
    protected String doInBackground(Integer... params) {
        int i = params[0];
        while (i < params[0] + 10) {
            i++;
            publishProgress(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return i + "";
    }

    /**
     * 运行在UI线程中，调用 doInBackground()方法之前执行，可以不实现
     */
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        Toast.makeText(context, "开始执行", Toast.LENGTH_SHORT).show();
    }

    /**
     * 运行在UI线程中，在 doInBackground()方法执行完毕后被调用，可以不实现
     */
    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        Toast.makeText(context, "执行完成" + s, Toast.LENGTH_SHORT).show();
    }

    /**
     * 在异步任务执行过程中，当手动调用了publishProgress() 方法时，回调该方法
     * @param values
     */
    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        MainActivity activity = (MainActivity) context;
        activity.mTvCounter.setText(values[0] + "");
    }
}
