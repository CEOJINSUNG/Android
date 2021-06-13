package edu.skku.map.pa2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    MainActivity mainActivity;

    EditText editText;
    Button searchButton, galleryButton;
    ImageView imageView;

    //Grid
    GridView gridView;
    GridAdapter gridAdapter;

    //arrayLists means answer array
    static ArrayList <IntegerList> arrayLists;

    //leftArray means left Element
    static ArrayList <ArrayList> leftArray;

    //entireArray is used for finding top-down Element
    static ArrayList<ArrayList> entireArray;
    static ArrayList<ArrayList> arrayCopyList;

    //topArray means top Element
    static ArrayList <ArrayList> topArray;

    //finalArray consist of 0 : arrayLists, 1 : leftArray, 2 : topArray
    static ArrayList <ArrayList> finalArray;

    //Top_List
    LinearLayout topView;

    //Top_List
    ListView listView1;
    ListView listView2;
    ListView listView3;
    ListView listView4;
    ListView listView5;
    ListView listView6;
    ListView listView7;
    ListView listView8;
    ListView listView9;
    ListView listView10;
    ListView listView11;
    ListView listView12;
    ListView listView13;
    ListView listView14;
    ListView listView15;
    ListView listView16;
    ListView listView17;
    ListView listView18;
    ListView listView19;
    ListView listView20;
    TopAdapter topAdapter1;
    TopAdapter topAdapter2;
    TopAdapter topAdapter3;
    TopAdapter topAdapter4;
    TopAdapter topAdapter5;
    TopAdapter topAdapter6;
    TopAdapter topAdapter7;
    TopAdapter topAdapter8;
    TopAdapter topAdapter9;
    TopAdapter topAdapter10;
    TopAdapter topAdapter11;
    TopAdapter topAdapter12;
    TopAdapter topAdapter13;
    TopAdapter topAdapter14;
    TopAdapter topAdapter15;
    TopAdapter topAdapter16;
    TopAdapter topAdapter17;
    TopAdapter topAdapter18;
    TopAdapter topAdapter19;
    TopAdapter topAdapter20;

    //Left_List
    GridView leftView1;
    GridView leftView2;
    GridView leftView3;
    GridView leftView4;
    GridView leftView5;
    GridView leftView6;
    GridView leftView7;
    GridView leftView8;
    GridView leftView9;
    GridView leftView10;
    GridView leftView11;
    GridView leftView12;
    GridView leftView13;
    GridView leftView14;
    GridView leftView15;
    GridView leftView16;
    GridView leftView17;
    GridView leftView18;
    GridView leftView19;
    GridView leftView20;
    static LeftAdapter leftAdapter1;
    static LeftAdapter leftAdapter2;
    static LeftAdapter leftAdapter3;
    static LeftAdapter leftAdapter4;
    static LeftAdapter leftAdapter5;
    static LeftAdapter leftAdapter6;
    static LeftAdapter leftAdapter7;
    static LeftAdapter leftAdapter8;
    static LeftAdapter leftAdapter9;
    static LeftAdapter leftAdapter10;
    static LeftAdapter leftAdapter11;
    static LeftAdapter leftAdapter12;
    static LeftAdapter leftAdapter13;
    static LeftAdapter leftAdapter14;
    static LeftAdapter leftAdapter15;
    static LeftAdapter leftAdapter16;
    static LeftAdapter leftAdapter17;
    static LeftAdapter leftAdapter18;
    static LeftAdapter leftAdapter19;
    static LeftAdapter leftAdapter20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.search_keyword);

        //Gallery Use
        galleryButton = findViewById(R.id.gallery_button);
        galleryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_PICK);
                startActivityForResult(intent, 0);
            }
        });

        //Naver API Use
        searchButton = findViewById(R.id.search_button);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OkHttpClient client = new OkHttpClient();
                String keyword = editText.getText().toString();
                HttpUrl.Builder urlBuilder = HttpUrl.parse("https://openapi.naver.com/v1/search/image").newBuilder();
                urlBuilder.addQueryParameter("query", keyword);
                urlBuilder.addQueryParameter("display", "1");

                String url = urlBuilder.build().toString();

                Request req = new Request.Builder().url(url).addHeader("X-Naver-Client-Id", "KlkHy_4ydIcFdYRSRARA").addHeader("X-Naver-Client-Secret", "oIs6yiVgih").build();

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
                            //JSON Format Change
                            JSONObject jsonObject = new JSONObject(myResponse);
                            //JSON[items] is array so get array
                            JSONArray jsonArray =  jsonObject.getJSONArray("items");
                            JSONObject jsonItems = jsonArray.getJSONObject(0);

                            //Get Url in jsonItems by using link tag and connect ImageView
                            String url = jsonItems.getString("link");
                            if (url != null) {
                                ImageModel imageModel = new ImageModel();
                                imageModel.setLink(url);
                                Log.d("link", imageModel.getLink());

                                URL urlImage = new URL(imageModel.getLink());
                                try {
                                    URLConnection urlConnection = urlImage.openConnection();
                                    BufferedInputStream bufferedInputStream = new BufferedInputStream(urlConnection.getInputStream(), urlConnection.getContentLength());
                                    Bitmap image = BitmapFactory.decodeStream(bufferedInputStream);
                                    bufferedInputStream.close();
                                    Bitmap resizeImg = Bitmap.createScaledBitmap(image, 300, 300, false);
                                    Bitmap changeImg = changeColor(resizeImg);

                                    //finalArrays
                                    getAnswer(changeImg);

                                    runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            //leftArrays
                                            ArrayList<ArrayList> partLeft = getLeftArray(arrayCopyList);
                                            leftListView(partLeft);

                                            //topArrays
                                            ArrayList<ArrayList> partTop = getTopArray(arrayCopyList);
                                            topListView(partTop);

                                            gridView = findViewById(R.id.grid_view);
                                            gridAdapter = new GridAdapter(arrayLists, getApplicationContext(), MainActivity.this);
                                            gridView.setAdapter(gridAdapter);
                                        }
                                    });
                                } catch (IllegalArgumentException e) {
                                    e.printStackTrace();
                                }
                            } else {
                                Toast.makeText(MainActivity.this, "Input Again", Toast.LENGTH_SHORT);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0) {
            if (resultCode == RESULT_OK) {
                try {
                    InputStream inputStream = getContentResolver().openInputStream(data.getData());
                    Bitmap img = BitmapFactory.decodeStream(inputStream);
                    inputStream.close();
                    Bitmap resizeImg = Bitmap.createScaledBitmap(img, 300, 300, false);
                    Bitmap changeImg = changeColor(resizeImg);

                    //finalArrays
                    getAnswer(changeImg);

                    //leftArrays
                    ArrayList <ArrayList> partLeft = getLeftArray(arrayCopyList);
                    leftListView(partLeft);

                    //topArrays
                    ArrayList <ArrayList> partTop = getTopArray(arrayCopyList);
                    topListView(partTop);

                    gridView = findViewById(R.id.grid_view);
                    gridAdapter = new GridAdapter(arrayLists, getApplicationContext(), this);
                    gridView.setAdapter(gridAdapter);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //This Function role is to change color into white&black;
    public Bitmap changeColor(Bitmap bitmap) {
        Bitmap grayBitmap = Bitmap.createBitmap(300, 300, bitmap.getConfig());
        int R, G, B, A;
        int getContent;
        for (int i = 0; i < 300; ++i) {
            for (int j = 0; j < 300; ++j) {
                getContent = bitmap.getPixel(i, j);
                R = Color.red(getContent);
                G = Color.green(getContent);
                B = Color.blue(getContent);
                A = Color.alpha(getContent);
                int gray = (int) (0.298 * R + 0.587 * G + 0.114 * B);
                if (gray > 128) {
                    gray = 255;
                }
                else{
                    gray = 0;
                }
                grayBitmap.setPixel(i, j, Color.argb(A, gray, gray, gray));
            }
        }
        return grayBitmap;
    }

    //This Function role is to get 0(white) or 1(black) Array
    public ArrayList<ArrayList> getAnswer(Bitmap bitmap) {
        Bitmap[][] bitmaps = new Bitmap[20][20];
        //arrayLists means answer array
        arrayLists = new ArrayList<>();

        //leftArray means left Element
        leftArray = new ArrayList<>();

        //entireArray is used for finding top-down Element
        entireArray = new ArrayList<>();

        //topArray means top Element
        topArray = new ArrayList<>();

        //finalArray consist of 0 : arrayLists, 1 : leftArray, 2 : topArray
        finalArray = new ArrayList<>();

        int R, G, B;
        int getContent;
        for(int i = 0; i < 20; ++i) {
            ArrayList <Integer> rowInteger = new ArrayList<Integer>();
            for(int j = 0; j < 20; ++j) {
                bitmaps[i][j] = Bitmap.createBitmap(bitmap, i * 15, j * 15, 15, 15);
                int totalColor = 0;
                for (int k = 0; k < 15; ++k) {
                    for (int l = 0; l < 15; ++l) {
                        getContent = bitmaps[i][j].getPixel(k, l);
                        R = Color.red(getContent);
                        G = Color.green(getContent);
                        B = Color.blue(getContent);
                        int standard = (int) (0.298 * R + 0.587 * G + 0.114 * B);
                        if (standard > 128) {
                            standard = 255;
                        } else {
                            standard = 0;
                        }
                        totalColor += standard;
                    }
                }
                int averageColor = totalColor / 225;
                if (averageColor > 128) {
                    //white add
                    rowInteger.add(0);
                } else {
                    //black add
                    rowInteger.add(1);
                }
            }
            Log.d("test", rowInteger.toString());

            //grid_view add
            arrayLists.add(new IntegerList(
                    rowInteger.get(0),
                    rowInteger.get(1),
                    rowInteger.get(2),
                    rowInteger.get(3),
                    rowInteger.get(4),
                    rowInteger.get(5),
                    rowInteger.get(6),
                    rowInteger.get(7),
                    rowInteger.get(8),
                    rowInteger.get(9),
                    rowInteger.get(10),
                    rowInteger.get(11),
                    rowInteger.get(12),
                    rowInteger.get(13),
                    rowInteger.get(14),
                    rowInteger.get(15),
                    rowInteger.get(16),
                    rowInteger.get(17),
                    rowInteger.get(18),
                    rowInteger.get(19)
            ));

            //entireArray add
            entireArray.add(rowInteger);
        }

        for (int a = 0; a < 20; a++) {
            ArrayList<Integer> columnInteger = new ArrayList<>();
            for (int b = 0; b < 20; b++) {
                ArrayList<Integer> temp = entireArray.get(b);
                columnInteger.add(temp.get(a));
            }
            topArray.add(columnInteger);
        }

        arrayCopyList = new ArrayList<>();
        arrayCopyList = (ArrayList<ArrayList>) entireArray.clone();

        finalArray.add(arrayLists);
        finalArray.add(leftArray);
        finalArray.add(topArray);
        return finalArray;
    }

    static ArrayList<ArrayList> getLeftArray(ArrayList<ArrayList> sampleArray) {
        ArrayList <ArrayList> resultArray = new ArrayList<>();
        for(int i = 0; i < 20; ++i) {
            int total = 0;
            ArrayList <Integer> rowArray = new ArrayList<>();
            if (sampleArray.get(i).contains(1)) {
                ArrayList<Integer> integerArrayList = sampleArray.get(i);
                for (int value : integerArrayList) {
                    if (value == 1) {
                        total++;
                    } else {
                        if (total > 0) {
                            rowArray.add(total);
                            total = 0;
                        }
                    }
                }
            } else {
                rowArray.add(0);
            }

            if (rowArray.size() < 2) {
                rowArray.add(0);
            }
            resultArray.add(rowArray);
        }
        return resultArray;
    }

    static ArrayList<ArrayList> getTopArray(ArrayList<ArrayList> sampleArray) {
        ArrayList <ArrayList> resultArray = new ArrayList<>();
        for (int a = 0; a < 20; a++) {
            ArrayList <Integer> columnArray = new ArrayList<>();
            ArrayList <Integer> columnInteger = new ArrayList<>();
            for (int b = 0; b < 20; b++) {
                ArrayList <Integer> temp = sampleArray.get(b);
                columnInteger.add(temp.get(a));
            }
            int total = 0;
            if (columnInteger.contains(1)) {
                for (int value : columnInteger) {
                    if (value == 1) {
                        total++;
                    } else {
                        if (total > 0) {
                            columnArray.add(total);
                            total = 0;
                        }
                    }
                }
            } else {
                columnArray.add(0);
            }

            if (columnArray.size() < 2) {
                columnArray.add(0);
            }

            resultArray.add(columnArray);
        }
        return resultArray;
    }

    public void leftListView(ArrayList<ArrayList> partOne) {
        int maxWidth = 0;
        for (int i=0; i<20; i++) {
            int temp = partOne.get(i).size();
            if (temp >= maxWidth) {
                maxWidth = temp;
            }
        }

        LinearLayout topView = findViewById(R.id.top_view);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) topView.getLayoutParams();
        layoutParams.leftMargin = dpPx(maxWidth * 11);
        topView.setLayoutParams(layoutParams);

        leftView1 = findViewById(R.id.left_one);
        leftView1.setNumColumns(partOne.get(0).size());
        leftView1.invalidateViews();
        LinearLayout linearLayout1 = findViewById(R.id.wrap_one);
        LinearLayout.LayoutParams layoutParams1 = (LinearLayout.LayoutParams) linearLayout1.getLayoutParams();
        layoutParams1.width = dpPx(partOne.get(0).size()*11);
        linearLayout1.setLayoutParams(layoutParams1);
        leftAdapter1 = new LeftAdapter(partOne.get(0), getApplicationContext());
        leftView1.setAdapter(leftAdapter1);

        leftView2 = findViewById(R.id.left_two);
        leftView2.setNumColumns(partOne.get(1).size());
        leftView2.invalidateViews();
        LinearLayout linearLayout2 = findViewById(R.id.wrap_two);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) linearLayout2.getLayoutParams();
        layoutParams2.width = dpPx(partOne.get(1).size()*11);
        linearLayout2.setLayoutParams(layoutParams2);
        leftAdapter2 = new LeftAdapter(partOne.get(1), getApplicationContext());
        leftView2.setAdapter(leftAdapter2);

        leftView3 = findViewById(R.id.left_three);
        leftView3.setNumColumns(partOne.get(2).size());
        leftView3.invalidateViews();
        LinearLayout linearLayout3 = findViewById(R.id.wrap_three);
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) linearLayout3.getLayoutParams();
        layoutParams3.width = dpPx(partOne.get(2).size()*11);
        linearLayout3.setLayoutParams(layoutParams3);
        leftAdapter3 = new LeftAdapter(partOne.get(2), getApplicationContext());
        leftView3.setAdapter(leftAdapter3);

        leftView4 = findViewById(R.id.left_four);
        leftView4.setNumColumns(partOne.get(3).size());
        leftView4.invalidateViews();
        LinearLayout linearLayout4 = findViewById(R.id.wrap_four);
        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) linearLayout4.getLayoutParams();
        layoutParams4.width = dpPx(partOne.get(3).size()*11);
        linearLayout4.setLayoutParams(layoutParams4);
        leftAdapter4 = new LeftAdapter(partOne.get(3), getApplicationContext());
        leftView4.setAdapter(leftAdapter4);

        leftView5 = findViewById(R.id.left_five);
        leftView5.setNumColumns(partOne.get(4).size());
        leftView5.invalidateViews();
        LinearLayout linearLayout5 = findViewById(R.id.wrap_five);
        LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) linearLayout5.getLayoutParams();
        layoutParams5.width = dpPx(partOne.get(4).size()*11);
        linearLayout5.setLayoutParams(layoutParams5);
        leftAdapter5 = new LeftAdapter(partOne.get(4), getApplicationContext());
        leftView5.setAdapter(leftAdapter5);

        leftView6 = findViewById(R.id.left_six);
        leftView6.setNumColumns(partOne.get(5).size());
        leftView6.invalidateViews();
        LinearLayout linearLayout6 = findViewById(R.id.wrap_six);
        LinearLayout.LayoutParams layoutParams6 = (LinearLayout.LayoutParams) linearLayout6.getLayoutParams();
        layoutParams6.width = dpPx(partOne.get(5).size()*11);
        linearLayout6.setLayoutParams(layoutParams6);
        leftAdapter6 = new LeftAdapter(partOne.get(5), getApplicationContext());
        leftView6.setAdapter(leftAdapter6);

        leftView7 = findViewById(R.id.left_seven);
        leftView7.setNumColumns(partOne.get(6).size());
        leftView7.invalidateViews();
        LinearLayout linearLayout7 = findViewById(R.id.wrap_seven);
        LinearLayout.LayoutParams layoutParams7 = (LinearLayout.LayoutParams) linearLayout7.getLayoutParams();
        layoutParams7.width = dpPx(partOne.get(6).size()*11);
        linearLayout7.setLayoutParams(layoutParams7);
        leftAdapter7 = new LeftAdapter(partOne.get(6), getApplicationContext());
        leftView7.setAdapter(leftAdapter7);

        leftView8 = findViewById(R.id.left_eight);
        leftView8.setNumColumns(partOne.get(7).size());
        leftView8.invalidateViews();
        LinearLayout linearLayout8 = findViewById(R.id.wrap_eight);
        LinearLayout.LayoutParams layoutParams8 = (LinearLayout.LayoutParams) linearLayout8.getLayoutParams();
        layoutParams8.width = dpPx(partOne.get(7).size()*11);
        linearLayout8.setLayoutParams(layoutParams8);
        leftAdapter8= new LeftAdapter(partOne.get(7), getApplicationContext());
        leftView8.setAdapter(leftAdapter8);

        leftView9 = findViewById(R.id.left_nine);
        leftView9.setNumColumns(partOne.get(8).size());
        leftView9.invalidateViews();
        LinearLayout linearLayout9 = findViewById(R.id.wrap_nine);
        LinearLayout.LayoutParams layoutParams9 = (LinearLayout.LayoutParams) linearLayout9.getLayoutParams();
        layoutParams9.width = dpPx(partOne.get(8).size()*11);
        linearLayout9.setLayoutParams(layoutParams9);
        leftAdapter9 = new LeftAdapter(partOne.get(8), getApplicationContext());
        leftView9.setAdapter(leftAdapter9);

        leftView10 = findViewById(R.id.left_ten);
        leftView10.setNumColumns(partOne.get(9).size());
        leftView10.invalidateViews();
        LinearLayout linearLayout10 = findViewById(R.id.wrap_ten);
        LinearLayout.LayoutParams layoutParams10 = (LinearLayout.LayoutParams) linearLayout10.getLayoutParams();
        layoutParams10.width = dpPx(partOne.get(9).size()*11);
        linearLayout10.setLayoutParams(layoutParams10);
        leftAdapter10 = new LeftAdapter(partOne.get(9), getApplicationContext());
        leftView10.setAdapter(leftAdapter10);

        leftView11 = findViewById(R.id.left_eleven);
        leftView11.setNumColumns(partOne.get(10).size());
        LinearLayout linearLayout11 = findViewById(R.id.wrap_eleven);
        LinearLayout.LayoutParams layoutParams11 = (LinearLayout.LayoutParams) linearLayout11.getLayoutParams();
        layoutParams11.width = dpPx(partOne.get(10).size()*11);
        linearLayout11.setLayoutParams(layoutParams11);
        leftAdapter11 = new LeftAdapter(partOne.get(10), getApplicationContext());
        leftView11.setAdapter(leftAdapter11);

        leftView12 = findViewById(R.id.left_twelve);
        leftView12.setNumColumns(partOne.get(11).size());
        LinearLayout linearLayout12 = findViewById(R.id.wrap_twelve);
        LinearLayout.LayoutParams layoutParams12 = (LinearLayout.LayoutParams) linearLayout12.getLayoutParams();
        layoutParams12.width = dpPx(partOne.get(11).size()*11);
        linearLayout12.setLayoutParams(layoutParams12);
        leftAdapter12 = new LeftAdapter(partOne.get(11), getApplicationContext());
        leftView12.setAdapter(leftAdapter12);

        leftView13 = findViewById(R.id.left_thirteen);
        leftView13.setNumColumns(partOne.get(12).size());
        LinearLayout linearLayout13 = findViewById(R.id.wrap_thirteen);
        LinearLayout.LayoutParams layoutParams13 = (LinearLayout.LayoutParams) linearLayout13.getLayoutParams();
        layoutParams13.width = dpPx(partOne.get(12).size()*11);
        linearLayout13.setLayoutParams(layoutParams13);
        leftAdapter13 = new LeftAdapter(partOne.get(12), getApplicationContext());
        leftView13.setAdapter(leftAdapter13);

        leftView14 = findViewById(R.id.left_fourteen);
        leftView14.setNumColumns(partOne.get(13).size());
        LinearLayout linearLayout14 = findViewById(R.id.wrap_fourteen);
        LinearLayout.LayoutParams layoutParams14 = (LinearLayout.LayoutParams) linearLayout14.getLayoutParams();
        layoutParams14.width = dpPx(partOne.get(13).size()*11);
        linearLayout14.setLayoutParams(layoutParams14);
        leftAdapter14 = new LeftAdapter(partOne.get(13), getApplicationContext());
        leftView14.setAdapter(leftAdapter14);

        leftView15 = findViewById(R.id.left_fifteen);
        leftView15.setNumColumns(partOne.get(14).size());
        LinearLayout linearLayout15 = findViewById(R.id.wrap_fifteen);
        LinearLayout.LayoutParams layoutParams15 = (LinearLayout.LayoutParams) linearLayout15.getLayoutParams();
        layoutParams15.width = dpPx(partOne.get(14).size()*11);
        linearLayout15.setLayoutParams(layoutParams15);
        leftAdapter15 = new LeftAdapter(partOne.get(14), getApplicationContext());
        leftView15.setAdapter(leftAdapter15);

        leftView16 = findViewById(R.id.left_sixteen);
        leftView16.setNumColumns(partOne.get(15).size());
        LinearLayout linearLayout16 = findViewById(R.id.wrap_sixteen);
        LinearLayout.LayoutParams layoutParams16 = (LinearLayout.LayoutParams) linearLayout16.getLayoutParams();
        layoutParams16.width = dpPx(partOne.get(15).size()*11);
        linearLayout16.setLayoutParams(layoutParams16);
        leftAdapter16 = new LeftAdapter(partOne.get(15), getApplicationContext());
        leftView16.setAdapter(leftAdapter16);

        leftView17 = findViewById(R.id.left_seventeen);
        leftView17.setNumColumns(partOne.get(16).size());
        LinearLayout linearLayout17 = findViewById(R.id.wrap_seventeen);
        LinearLayout.LayoutParams layoutParams17 = (LinearLayout.LayoutParams) linearLayout17.getLayoutParams();
        layoutParams17.width = dpPx(partOne.get(16).size()*11);
        linearLayout17.setLayoutParams(layoutParams17);
        leftAdapter17 = new LeftAdapter(partOne.get(16), getApplicationContext());
        leftView17.setAdapter(leftAdapter17);

        leftView18 = findViewById(R.id.left_eighteen);
        leftView18.setNumColumns(partOne.get(17).size());
        LinearLayout linearLayout18 = findViewById(R.id.wrap_eighteen);
        LinearLayout.LayoutParams layoutParams18 = (LinearLayout.LayoutParams) linearLayout18.getLayoutParams();
        layoutParams18.width = dpPx(partOne.get(17).size()*11);
        linearLayout18.setLayoutParams(layoutParams18);
        leftAdapter18 = new LeftAdapter(partOne.get(17), getApplicationContext());
        leftView18.setAdapter(leftAdapter18);

        leftView19 = findViewById(R.id.left_nineteen);
        leftView19.setNumColumns(partOne.get(18).size());
        LinearLayout linearLayout19 = findViewById(R.id.wrap_nineteen);
        LinearLayout.LayoutParams layoutParams19 = (LinearLayout.LayoutParams) linearLayout19.getLayoutParams();
        layoutParams19.width = dpPx(partOne.get(18).size()*11);
        linearLayout19.setLayoutParams(layoutParams19);
        leftAdapter19 = new LeftAdapter(partOne.get(18), getApplicationContext());
        leftView19.setAdapter(leftAdapter19);

        leftView20 = findViewById(R.id.left_twenty);
        leftView20.setNumColumns(partOne.get(19).size());
        LinearLayout linearLayout20 = findViewById(R.id.wrap_twenty);
        LinearLayout.LayoutParams layoutParams20 = (LinearLayout.LayoutParams) linearLayout20.getLayoutParams();
        layoutParams20.width = dpPx(partOne.get(19).size()*11);
        linearLayout20.setLayoutParams(layoutParams20);
        leftAdapter20 = new LeftAdapter(partOne.get(19), getApplicationContext());
        leftView20.setAdapter(leftAdapter20);
    }

    public void topListView (ArrayList<ArrayList> partTwo) {
        listView1 = findViewById(R.id.top_one);
        topAdapter1 = new TopAdapter(partTwo.get(0), getApplicationContext());
        listView1.setAdapter(topAdapter1);

        listView2 = findViewById(R.id.top_two);
        topAdapter2 = new TopAdapter(partTwo.get(1), getApplicationContext());
        listView2.setAdapter(topAdapter2);

        listView3 = findViewById(R.id.top_three);
        topAdapter3 = new TopAdapter(partTwo.get(2), getApplicationContext());
        listView3.setAdapter(topAdapter3);

        listView4 = findViewById(R.id.top_four);
        topAdapter4 = new TopAdapter(partTwo.get(3), getApplicationContext());
        listView4.setAdapter(topAdapter4);

        listView5 = findViewById(R.id.top_five);
        topAdapter5 = new TopAdapter(partTwo.get(4), getApplicationContext());
        listView5.setAdapter(topAdapter5);

        listView6 = findViewById(R.id.top_six);
        topAdapter6 = new TopAdapter(partTwo.get(5), getApplicationContext());
        listView6.setAdapter(topAdapter6);

        listView7 = findViewById(R.id.top_seven);
        topAdapter7 = new TopAdapter(partTwo.get(6), getApplicationContext());
        listView7.setAdapter(topAdapter7);

        listView8 = findViewById(R.id.top_eight);
        topAdapter8 = new TopAdapter(partTwo.get(7), getApplicationContext());
        listView8.setAdapter(topAdapter8);

        listView9 = findViewById(R.id.top_nine);
        topAdapter9 = new TopAdapter(partTwo.get(8), getApplicationContext());
        listView9.setAdapter(topAdapter9);

        listView10 = findViewById(R.id.top_ten);
        topAdapter10 = new TopAdapter(partTwo.get(9), getApplicationContext());
        listView10.setAdapter(topAdapter10);

        listView11 = findViewById(R.id.top_eleven);
        topAdapter11 = new TopAdapter(partTwo.get(10), getApplicationContext());
        listView11.setAdapter(topAdapter11);

        listView12 = findViewById(R.id.top_twelve);
        topAdapter12 = new TopAdapter(partTwo.get(11), getApplicationContext());
        listView12.setAdapter(topAdapter12);

        listView13 = findViewById(R.id.top_thirteen);
        topAdapter13 = new TopAdapter(partTwo.get(12), getApplicationContext());
        listView13.setAdapter(topAdapter13);

        listView14 = findViewById(R.id.top_fourteen);
        topAdapter14 = new TopAdapter(partTwo.get(13), getApplicationContext());
        listView14.setAdapter(topAdapter14);

        listView15 = findViewById(R.id.top_fifteen);
        topAdapter15 = new TopAdapter(partTwo.get(14), getApplicationContext());
        listView15.setAdapter(topAdapter15);

        listView16 = findViewById(R.id.top_sixteen);
        topAdapter16 = new TopAdapter(partTwo.get(15), getApplicationContext());
        listView16.setAdapter(topAdapter16);

        listView17 = findViewById(R.id.top_seventeen);
        topAdapter17 = new TopAdapter(partTwo.get(16), getApplicationContext());
        listView17.setAdapter(topAdapter17);

        listView18 = findViewById(R.id.top_eighteen);
        topAdapter18 = new TopAdapter(partTwo.get(17), getApplicationContext());
        listView18.setAdapter(topAdapter18);

        listView19 = findViewById(R.id.top_nineteen);
        topAdapter19 = new TopAdapter(partTwo.get(18), getApplicationContext());
        listView19.setAdapter(topAdapter19);

        listView20 = findViewById(R.id.top_twenty);
        topAdapter20 = new TopAdapter(partTwo.get(19), getApplicationContext());
        listView20.setAdapter(topAdapter20);
    }

    public int dpPx(int dp) {
        float density = getResources().getDisplayMetrics().density;
        return Math.round((float) dp * density);
    }

}