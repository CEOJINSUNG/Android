package edu.skku.MAP.myFirstSWPLab3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int i = 0;
    int j = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView text = (TextView) findViewById(R.id.textView);
        Button btn1 = (Button)findViewById(R.id.button_name);
        Button btn2 = (Button)findViewById(R.id.button_soccer);
        final ImageView image1 = (ImageView) findViewById(R.id.imageView);

        btn1.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                j = 1 - j;
                if (j == 0) {
                    text.setText("Jinsung Kim");
                }
                if (j == 1) {
                    text.setText("2016311902");
                }
            }
        });


        btn2.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                i = i + 1;
                if (i%3 == 0) {
                    image1.setImageResource(R.drawable.son);
                }
                if (i%3 == 1) {
                    image1.setImageResource(R.drawable.mourinou);
                }
                if(i%3 == 2) {
                    image1.setImageResource(R.drawable.loris);
                }
            }
        });
    }
}