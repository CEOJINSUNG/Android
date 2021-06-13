package edu.skku.map.assignment7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button button1;
    TextView textView1, textView2, textView3, textView4, textView5, textView6, textView7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.keyword);
        textView1 = findViewById(R.id.title);
        textView2 = findViewById(R.id.year);
        textView3 = findViewById(R.id.date);
        textView4 = findViewById(R.id.runtime);
        textView5 = findViewById(R.id.genre);
        textView6 = findViewById(R.id.rate);
        textView7 = findViewById(R.id.metascore);

        button1 = findViewById(R.id.sendingGET);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OkHttpClient client = new OkHttpClient();
                String movie = editText.getText().toString();
                HttpUrl.Builder urlBuilder = HttpUrl.parse("http://www.omdbapi.com/?apikey=fc90ef2e").newBuilder();
                urlBuilder.addQueryParameter("t", movie);

                String url = urlBuilder.build().toString();

                Request req = new Request.Builder().url(url).build();

                client.newCall(req).enqueue(new Callback() {
                    @Override
                    public void onFailure(@NotNull Call call, @NotNull IOException e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                        String myResponse = response.body().string();
                        Log.d("test", myResponse);
                        try {
                            JSONObject jsonObject = new JSONObject(myResponse);
                            DataModel data = new DataModel();
                            data.setTitle(jsonObject.getString("Title"));
                            data.setYear(jsonObject.getString("Year"));
                            data.setReleased(jsonObject.getString("Released"));
                            data.setRuntime(jsonObject.getString("Runtime"));
                            data.setGenre(jsonObject.getString("Genre"));
                            data.setImdbRating(jsonObject.getString("imdbRating"));
                            data.setMetascore(jsonObject.getString("Metascore"));
                            MainActivity.this.runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    textView1.setText("Title:" + data.getTitle());
                                    textView2.setText("Year:" + data.getYear());
                                    textView3.setText("Released Date:" + data.getReleased());
                                    textView4.setText("Runtime:" + data.getRuntime());
                                    textView5.setText("Genre:" + data.getGenre());
                                    textView6.setText("IMDB Rates:" + data.getImdbRating());
                                    textView7.setText("Metascore:" + data.getMetascore());
                                }
                            });
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
    }
}