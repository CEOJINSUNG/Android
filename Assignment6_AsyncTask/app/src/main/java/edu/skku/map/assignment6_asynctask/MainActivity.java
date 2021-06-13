package edu.skku.map.assignment6_asynctask;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView textView = findViewById(R.id.textView);
        final Context context = this;

        @SuppressLint("StaticFieldLeak") AsyncTask<Integer, Double, String> asyncTask = new AsyncTask<Integer, Double, String>() {
            @SuppressLint("StaticFieldLeak")
            @Override
            protected void onPreExecute() {
                super.onPreExecute();

                Toast.makeText(context, "Start AsyncTask", Toast.LENGTH_SHORT).show();
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);

                Toast.makeText(context, "End AsyncTask", Toast.LENGTH_SHORT).show();
            }

            @Override
            protected void onProgressUpdate(Double... values) {
                super.onProgressUpdate(values);

                textView.setText(Double.toString(values[0]));
            }

            @Override
            protected String doInBackground(Integer... integers) {
                for (int i = 1; i < integers[0]; i++) {
                    try {
                        Thread.sleep(1000);
                        double value = i + 3;
                        publishProgress(value);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                return null;
            }
        };
        asyncTask.execute(10);
    }
}