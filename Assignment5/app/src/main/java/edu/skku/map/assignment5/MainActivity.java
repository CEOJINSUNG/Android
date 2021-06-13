package edu.skku.map.assignment5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public String id = "MAP";
    public String password = "weloveprofessor";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //로그인 방법
        Button buttonLogin = findViewById(R.id.button_login);
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText putId = findViewById(R.id.put_id);
                EditText putPassword = findViewById(R.id.put_password);

                if ((putId.getText().toString()).equals(id) && (putPassword.getText().toString()).equals(password)) {
                    Intent loginIntent = new Intent(getApplicationContext(), SecondActivity.class);
                    startActivity(loginIntent);
                } else {
                    Toast wrongMessage = Toast.makeText(getApplicationContext(), "wrong", Toast.LENGTH_LONG);
                    wrongMessage.show();
                }
            }
        });
    }
}