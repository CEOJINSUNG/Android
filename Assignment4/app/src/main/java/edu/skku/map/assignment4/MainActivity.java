package edu.skku.map.assignment4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private void putInteger(int range) {
        ListView firstList = findViewById(R.id.firstListview);
        ArrayList<Integer> firstData = new ArrayList<>();
        for(int i=0; i<range+1; i++) {
            firstData.add(i);
        }
        ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_list_item_1, firstData);
        firstList.setAdapter(adapter);
    }

    private void putSquare(int range) {
        ListView secondList = findViewById(R.id.secondListview);
        ArrayList<Integer> secondData = new ArrayList<>();
        for (int i=1; i<range+1; i++){
            int num = (int) Math.pow(2, i);
            secondData.add(num);
        }
        ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_list_item_1, secondData);
        secondList.setAdapter(adapter);
    }

    private void myInfo(String number, String name, String department, String college, String university) {
        ListView thirdList = findViewById(R.id.thirdListview);
        ArrayList<String> thirdData = new ArrayList<>();
        thirdData.add(number);
        thirdData.add(name);
        thirdData.add(department);
        thirdData.add(college);
        thirdData.add(university);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, thirdData);
        thirdList.setAdapter(adapter);
    }

    private void changeView(int index) {
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        FrameLayout container = (FrameLayout) findViewById(R.id.container) ;
        if (container.getChildCount() > 0) {
            container.removeViewAt(0);
        }

        View view = null ;
        switch (index) {
            case 0 :
                view = inflater.inflate(R.layout.sub_first, container, false) ;
                break ;
            case 1 :
                view = inflater.inflate(R.layout.sub_second, container, false) ;
                break ;
            case 2 :
                view = inflater.inflate(R.layout.sub_third, container, false) ;
                break ;
        }

        if (view != null) {
            container.addView(view) ;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        changeView(0);
        putInteger(10);

        Button firstButton  = (Button)findViewById(R.id.first_page);
        firstButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeView(0);
                putInteger(10);
            }
        });

        Button secondButton  = (Button)findViewById(R.id.second_page);
        secondButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeView(1);
                putSquare(10);
            }
        });

        Button thirdButton  = (Button)findViewById(R.id.third_page);
        thirdButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeView(2);
                myInfo("2016311902", "Jinsung Kim", "Department of Software", "College of Software", "Sungkyunkwan University");
            }
        });

    }
}