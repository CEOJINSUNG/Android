package edu.skku.map.assignment5;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //인터넷 연결
        Button buttonSearch = findViewById(R.id.button_search);
        buttonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText putSearch = findViewById(R.id.put_search);

                Intent webIntent = new Intent(Intent.ACTION_WEB_SEARCH);
                webIntent.putExtra(SearchManager.QUERY, putSearch.getText().toString());
                if (webIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(webIntent);
                }
            }
        });

        //전화 연
        Button buttonCalling = findViewById(R.id.button_calling);
        buttonCalling.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText putPhone = findViewById(R.id.put_phone);
                String phoneNumber = putPhone.getText().toString();

                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:" + phoneNumber));
                if (callIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(callIntent);
                }
            }
        });
    }
}