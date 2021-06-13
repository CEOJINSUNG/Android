package edu.skku.map.pa1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    //요소 구분
    int number;
    int threeWhite;
    int fourWhite;
    BitmapDrawable threeWhiteBit;
    BitmapDrawable fourWhiteBit;

    GridView gridView;
    GridView gridTwoView;
    GridView gridThreeView;
    GridOneAdapterThree gridOneAdapterThree;
    GridOneAdapterThree gridOneAdapter2;
    GridOneAdapterThree gridOneAdapter3;
    ArrayList<BitmapOneArray> itemsOne;
    ArrayList<BitmapDrawable> threeStorage;
    ArrayList<BitmapDrawable> threeCopy;

    GridView grifOneView;
    GridView grifTwoView;
    GridView grifThreeView;
    GridView grifFourView;

    ArrayList<BitmapDrawable> fourStorage;
    ArrayList<BitmapDrawable> fourCopy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.grid_one_view);
        gridTwoView = findViewById(R.id.grid_two_view);
        gridThreeView =findViewById(R.id.grid_three_view);

        gridThree();

        // 3X3, 4X4, shuffle 버튼
        Button threeBtn = findViewById(R.id.three_button);
        Button fourBtn = findViewById(R.id.four_button);
        Button shuffleBtn = findViewById(R.id.shuffle_button);

        threeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gridThree();
            }
        });

        fourBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gridFour();
            }
        });

        shuffleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(number == 3) {
                    threeShuffle();
                } else {
                    fourShuffle();
                }
            }
        });

    }

    //FrameLayout에서 화면 바꾸기
    private void changeView(int index) {
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        FrameLayout container = (FrameLayout) findViewById(R.id.container) ;
        if (container.getChildCount() > 0) {
            container.removeViewAt(0);
        }

        View view = null ;
        switch (index) {
            case 0 :
                view = inflater.inflate(R.layout.activity_three, container, false) ;
                break ;
            case 1 :
                view = inflater.inflate(R.layout.activity_four, container, false) ;
                break ;
        }

        if (view != null) {
            container.addView(view) ;
        }
    }

    //3X3 생성
    public ArrayList<BitmapDrawable> getThree() {
        ArrayList<BitmapDrawable> bitmapDrawable = new ArrayList<BitmapDrawable>();

        //이미지 자르기
        Bitmap muyahoPicture = BitmapFactory.decodeResource(getResources(), R.mipmap.muyaho_foreground);
        Bitmap muyahoPic = Bitmap.createScaledBitmap(muyahoPicture, 300, 300, true);

        Bitmap threeOnePic = Bitmap.createBitmap(muyahoPic, 0, 0, 100, 100);
        Bitmap threeTwoPic = Bitmap.createBitmap(muyahoPic, 0, 100, 100, 100);
        Bitmap threeThreePic = Bitmap.createBitmap(muyahoPic, 0, 200, 100, 100);
        Bitmap threeFourPic = Bitmap.createBitmap(muyahoPic, 100, 0, 100, 100);
        Bitmap threeFivePic = Bitmap.createBitmap(muyahoPic, 100, 100, 100, 100);
        Bitmap threeSixPic = Bitmap.createBitmap(muyahoPic, 100, 200, 100, 100);
        Bitmap threeSevenPic = Bitmap.createBitmap(muyahoPic, 200, 0, 100, 100);
        Bitmap threeEightPic = Bitmap.createBitmap(muyahoPic, 200, 100, 100, 100);
        Bitmap white = BitmapFactory.decodeResource(getResources(), R.drawable.white);

        bitmapDrawable.add(new BitmapDrawable(getResources(), threeOnePic));
        bitmapDrawable.add(new BitmapDrawable(getResources(), threeTwoPic));
        bitmapDrawable.add(new BitmapDrawable(getResources(), threeThreePic));
        bitmapDrawable.add(new BitmapDrawable(getResources(), threeFourPic));
        bitmapDrawable.add(new BitmapDrawable(getResources(), threeFivePic));
        bitmapDrawable.add(new BitmapDrawable(getResources(), threeSixPic));
        bitmapDrawable.add(new BitmapDrawable(getResources(), threeSevenPic));
        bitmapDrawable.add(new BitmapDrawable(getResources(), threeEightPic));
        bitmapDrawable.add(new BitmapDrawable(getResources(), white));

        Log.d("text", bitmapDrawable.toString());

        return bitmapDrawable;
    }

    //4X4 생성
    public ArrayList<BitmapDrawable> getFour() {
        ArrayList<BitmapDrawable> bitmapFDrawable = new ArrayList<BitmapDrawable>();

        //이미지 자르기
        Bitmap muyahoPicture = BitmapFactory.decodeResource(getResources(), R.mipmap.muyaho_foreground);
        Bitmap muyahoPic = Bitmap.createScaledBitmap(muyahoPicture, 300, 300, true);

        Bitmap threeOnePic = Bitmap.createBitmap(muyahoPic, 0, 0, 75, 75);
        Bitmap threeTwoPic = Bitmap.createBitmap(muyahoPic, 0, 75, 75, 75);
        Bitmap threeThreePic = Bitmap.createBitmap(muyahoPic, 0, 150, 75, 75);
        Bitmap threeFourPic = Bitmap.createBitmap(muyahoPic, 0, 225, 75, 75);
        Bitmap threeFivePic = Bitmap.createBitmap(muyahoPic, 75, 0, 75, 75);
        Bitmap threeSixPic = Bitmap.createBitmap(muyahoPic, 75, 75, 75, 75);
        Bitmap threeSevenPic = Bitmap.createBitmap(muyahoPic, 75, 150, 75, 75);
        Bitmap threeEightPic = Bitmap.createBitmap(muyahoPic, 75, 225, 75, 75);
        Bitmap threeNinePic = Bitmap.createBitmap(muyahoPic, 150, 0, 75, 75);
        Bitmap threeTenPic = Bitmap.createBitmap(muyahoPic, 150, 75, 75, 75);
        Bitmap threeElePic = Bitmap.createBitmap(muyahoPic, 150, 150, 75, 75);
        Bitmap threeTwelPic = Bitmap.createBitmap(muyahoPic, 150, 225, 75, 75);
        Bitmap threeThirPic = Bitmap.createBitmap(muyahoPic, 225, 0, 75, 75);
        Bitmap threeFourteenPic = Bitmap.createBitmap(muyahoPic, 225, 75, 75, 75);
        Bitmap threeFifteenPic = Bitmap.createBitmap(muyahoPic, 225, 150, 75, 75);
        Bitmap white = BitmapFactory.decodeResource(getResources(), R.drawable.white);

        BitmapDrawable a = new BitmapDrawable(getResources(), threeOnePic);

        bitmapFDrawable.add(a);
        bitmapFDrawable.add(new BitmapDrawable(getResources(), threeTwoPic));
        bitmapFDrawable.add(new BitmapDrawable(getResources(), threeThreePic));
        bitmapFDrawable.add(new BitmapDrawable(getResources(), threeFourPic));
        bitmapFDrawable.add(new BitmapDrawable(getResources(), threeFivePic));
        bitmapFDrawable.add(new BitmapDrawable(getResources(), threeSixPic));
        bitmapFDrawable.add(new BitmapDrawable(getResources(), threeSevenPic));
        bitmapFDrawable.add(new BitmapDrawable(getResources(), threeEightPic));
        bitmapFDrawable.add(new BitmapDrawable(getResources(), threeNinePic));
        bitmapFDrawable.add(new BitmapDrawable(getResources(), threeTenPic));
        bitmapFDrawable.add(new BitmapDrawable(getResources(), threeElePic));
        bitmapFDrawable.add(new BitmapDrawable(getResources(), threeTwelPic));
        bitmapFDrawable.add(new BitmapDrawable(getResources(), threeThirPic));
        bitmapFDrawable.add(new BitmapDrawable(getResources(), threeFourteenPic));
        bitmapFDrawable.add(new BitmapDrawable(getResources(), threeFifteenPic));
        bitmapFDrawable.add(new BitmapDrawable(getResources(), white));

        Log.d("text", bitmapFDrawable.toString());

        return bitmapFDrawable;
    }

    //3X3 출력
    public void gridThree() {
        changeView(0);
        number = 3;

        gridView = findViewById(R.id.grid_one_view);
        gridTwoView = findViewById(R.id.grid_two_view);
        gridThreeView =findViewById(R.id.grid_three_view);

        itemsOne = new ArrayList<BitmapOneArray>();
        ArrayList<BitmapOneArray> itemsTwo = new ArrayList<BitmapOneArray>();
        ArrayList<BitmapOneArray> itemsThree = new ArrayList<BitmapOneArray>();

        //3X3 Array 선언, 복사, white 위치 설정
        threeStorage = getThree();
        threeCopy = (ArrayList<BitmapDrawable>) threeStorage.clone();
        threeWhite = 8;
        threeWhiteBit = threeStorage.get(8);
        Log.d("text", threeWhiteBit.toString());

        for (int i=0; i<threeStorage.size(); i+=1) {
            if (i < 3) {
                itemsOne.add(new BitmapOneArray(threeStorage.get(i)));
            } else if (i < 6) {
                itemsTwo.add(new BitmapOneArray(threeStorage.get(i)));
            } else {
                itemsThree.add(new BitmapOneArray(threeStorage.get(i)));
            }
        }

        gridOneAdapterThree = new GridOneAdapterThree(itemsOne, getApplicationContext());
        gridOneAdapter2 = new GridOneAdapterThree(itemsTwo, getApplicationContext());
        gridOneAdapter3 = new GridOneAdapterThree(itemsThree, getApplicationContext());

        gridView.setAdapter(gridOneAdapterThree);
        gridTwoView.setAdapter(gridOneAdapter2);
        gridThreeView.setAdapter(gridOneAdapter3);
    }

    //4X4 출력
    public void gridFour() {
        changeView(1);
        number = 4;
        grifOneView = findViewById(R.id.grif_one_view);
        grifTwoView = findViewById(R.id.grif_two_view);
        grifThreeView = findViewById(R.id.grif_three_view);
        grifFourView = findViewById(R.id.grif_four_view);

        ArrayList<BitmapOneArray> itemFOne = new ArrayList<BitmapOneArray>();
        ArrayList<BitmapOneArray> itemFTwo = new ArrayList<BitmapOneArray>();
        ArrayList<BitmapOneArray> itemFThree = new ArrayList<BitmapOneArray>();
        ArrayList<BitmapOneArray> itemFFour = new ArrayList<BitmapOneArray>();

        //4X4 Array 선언, 복사, white 위치 설정
        fourStorage = getFour();
        fourCopy = (ArrayList<BitmapDrawable>)fourStorage.clone();
        fourWhite = 15;
        fourWhiteBit = fourStorage.get(15);

        for (int i=0; i<fourStorage.size(); i+=1) {
            if (i < 4) {
                itemFOne.add(new BitmapOneArray(fourStorage.get(i)));
            } else if (i < 8) {
                itemFTwo.add(new BitmapOneArray(fourStorage.get(i)));
            } else if (i < 12) {
                itemFThree.add(new BitmapOneArray(fourStorage.get(i)));
            } else {
                itemFFour.add(new BitmapOneArray(fourStorage.get(i)));
            }
        }

        GridOneAdapterFour gridFOneAdapter = new GridOneAdapterFour(itemFOne, getApplicationContext());
        GridOneAdapterFour gridFOneAdapter2 = new GridOneAdapterFour(itemFTwo, getApplicationContext());
        GridOneAdapterFour gridFOneAdapter3 = new GridOneAdapterFour(itemFThree, getApplicationContext());
        GridOneAdapterFour gridFOneAdapter4 = new GridOneAdapterFour(itemFFour, getApplicationContext());

        grifOneView.setAdapter(gridFOneAdapter);
        grifTwoView.setAdapter(gridFOneAdapter2);
        grifThreeView.setAdapter(gridFOneAdapter3);
        grifFourView.setAdapter(gridFOneAdapter4);
    }

    //3X3 셔플
    public void threeShuffle() {
        changeView(0);
        number = 3;
        gridView = findViewById(R.id.grid_one_view);
        gridTwoView = findViewById(R.id.grid_two_view);
        gridThreeView =findViewById(R.id.grid_three_view);

        itemsOne = new ArrayList<BitmapOneArray>();
        ArrayList<BitmapOneArray> itemsTwo = new ArrayList<BitmapOneArray>();
        ArrayList<BitmapOneArray> itemsThree = new ArrayList<BitmapOneArray>();

        long seed = System.nanoTime();
        Collections.shuffle(threeStorage, new Random(seed));

        //셔플 이후 threeStorage Update 확인
        Log.d("text", threeStorage.toString());

        //셔플 이후 threeWhite 위치 찾고 위치 출
        threeWhite = threeStorage.indexOf(threeWhiteBit);
        Log.d("text", Integer.toString(threeWhite));

        boolean result = completeCheck(threeCopy, threeStorage);
        Log.d("text", Boolean.toString(result));

        for (int i=0; i<threeStorage.size(); i+=1) {
            if (i < 3) {
                itemsOne.add(new BitmapOneArray(threeStorage.get(i)));
            } else if (i < 6) {
                itemsTwo.add(new BitmapOneArray(threeStorage.get(i)));
            } else {
                itemsThree.add(new BitmapOneArray(threeStorage.get(i)));
            }
        }

        gridOneAdapterThree = new GridOneAdapterThree(itemsOne, this);
        gridOneAdapter2 = new GridOneAdapterThree(itemsTwo, this);
        gridOneAdapter3 = new GridOneAdapterThree(itemsThree, this);

        gridView.setAdapter(gridOneAdapterThree);
        gridTwoView.setAdapter(gridOneAdapter2);
        gridThreeView.setAdapter(gridOneAdapter3);

        transferThree();
    }

    //4X4 셔플
    public void fourShuffle() {
        changeView(1);
        number = 4;
        grifOneView = findViewById(R.id.grif_one_view);
        grifTwoView = findViewById(R.id.grif_two_view);
        grifThreeView = findViewById(R.id.grif_three_view);
        grifFourView = findViewById(R.id.grif_four_view);

        ArrayList<BitmapOneArray> itemsOne = new ArrayList<BitmapOneArray>();
        ArrayList<BitmapOneArray> itemsTwo = new ArrayList<BitmapOneArray>();
        ArrayList<BitmapOneArray> itemsThree = new ArrayList<BitmapOneArray>();
        ArrayList<BitmapOneArray> itemsFour = new ArrayList<BitmapOneArray>();

        long seed = System.nanoTime();
        Collections.shuffle(fourStorage, new Random(seed));

        //셔플 이후 fourStorage Update 확인
        Log.d("text", fourStorage.toString());

        //셔플 이후 fourWhite 위치 찾고 위치 출
        fourWhite = fourStorage.indexOf(fourWhiteBit);
        Log.d("text", Integer.toString(fourWhite));

        for (int i=0; i<fourStorage.size(); i+=1) {
            if (i < 4) {
                itemsOne.add(new BitmapOneArray(fourStorage.get(i)));
            } else if (i < 8) {
                itemsTwo.add(new BitmapOneArray(fourStorage.get(i)));
            } else if (i < 12) {
                itemsThree.add(new BitmapOneArray(fourStorage.get(i)));
            } else {
                itemsFour.add(new BitmapOneArray(fourStorage.get(i)));
            }
        }

        GridOneAdapterFour gridOneAdapter = new GridOneAdapterFour(itemsOne, this);
        GridOneAdapterFour gridOneAdapter2 = new GridOneAdapterFour(itemsTwo, this);
        GridOneAdapterFour gridOneAdapter3 = new GridOneAdapterFour(itemsThree, this);
        GridOneAdapterFour gridOneAdapter4 = new GridOneAdapterFour(itemsFour, this);

        grifOneView.setAdapter(gridOneAdapter);
        grifTwoView.setAdapter(gridOneAdapter2);
        grifThreeView.setAdapter(gridOneAdapter3);
        grifFourView.setAdapter(gridOneAdapter4);

        transferFour();
    }

    //퍼즐이 완성되어 있는지 확인하기
    public Boolean completeCheck(ArrayList<BitmapDrawable> copy, ArrayList<BitmapDrawable> storage) {
        boolean result = Arrays.equals(copy.toArray(), storage.toArray());
        return result;
    }

    //퍼즐 3X3 GridView 클릭하고 옮기기
    public void transferThree() {
        ArrayList<Integer> action = new ArrayList<Integer>();
        //먼저 완성되었는지 체크하기
        boolean result = completeCheck(threeCopy, threeStorage);
        if (!result) {
            GridLayout gridThreeLayout = findViewById(R.id.grid_three_layout);
            if (threeWhite == 0) {
                action.add(1);
                action.add(3);
            } else if (threeWhite == 1) {
                action.add(0);
                action.add(2);
                action.add(4);
            } else if (threeWhite == 2) {
                action.add(1);
                action.add(5);
            } else if (threeWhite == 3) {
                action.add(0);
                action.add(4);
                action.add(6);
            } else if (threeWhite == 4) {
                action.add(1);
                action.add(3);
                action.add(5);
                action.add(7);
            } else if (threeWhite == 5) {
                action.add(2);
                action.add(4);
                action.add(8);
            } else if (threeWhite == 6) {
                action.add(3);
                action.add(7);
            } else if (threeWhite == 7) {
                action.add(4);
                action.add(6);
                action.add(8);
            } else if (threeWhite == 8) {
                action.add(5);
                action.add(7);
            }

            GridView gridThreeOne = (GridView) gridThreeLayout.getChildAt(0);
            gridThreeOne.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    int clickNumber = i;
                    if (action.contains(clickNumber)) {
                        threeChange(clickNumber);
                    }
                }
            });

            GridView gridThreeTwo = (GridView) gridThreeLayout.getChildAt(1);
            gridThreeTwo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    int clickNumber = i + 3;
                    if (action.contains(clickNumber)) {
                        threeChange(clickNumber);
                    }
                }
            });

            GridView gridThreeThree = (GridView) gridThreeLayout.getChildAt(2);
            gridThreeThree.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    int clickNumber = i + 6;
                    if (action.contains(clickNumber)) {
                        threeChange(clickNumber);
                    }
                }
            });
        } else {
            Toast.makeText(getApplicationContext(), "FINISHED!", Toast.LENGTH_LONG).show();
        }
    }

    //3X3 옮기기
    public void threeChange(int clickNumber) {
        changeView(0);
        number = 3;
        gridView = findViewById(R.id.grid_one_view);
        gridTwoView = findViewById(R.id.grid_two_view);
        gridThreeView =findViewById(R.id.grid_three_view);

        itemsOne = new ArrayList<BitmapOneArray>();
        ArrayList<BitmapOneArray> itemsTwo = new ArrayList<BitmapOneArray>();
        ArrayList<BitmapOneArray> itemsThree = new ArrayList<BitmapOneArray>();

        Collections.swap(threeStorage, clickNumber, threeWhite);

        //셔플 이후 threeStorage Update 확인
        Log.d("text", threeStorage.toString());

        //셔플 이후 threeWhite 위치 찾고 위치 출
        threeWhite = threeStorage.indexOf(threeWhiteBit);
        Log.d("text", Integer.toString(threeWhite));

        boolean result = completeCheck(threeCopy, threeStorage);
        Log.d("text", Boolean.toString(result));

        for (int i=0; i<threeStorage.size(); i+=1) {
            if (i < 3) {
                itemsOne.add(new BitmapOneArray(threeStorage.get(i)));
            } else if (i < 6) {
                itemsTwo.add(new BitmapOneArray(threeStorage.get(i)));
            } else {
                itemsThree.add(new BitmapOneArray(threeStorage.get(i)));
            }
        }

        gridOneAdapterThree = new GridOneAdapterThree(itemsOne, this);
        gridOneAdapter2 = new GridOneAdapterThree(itemsTwo, this);
        gridOneAdapter3 = new GridOneAdapterThree(itemsThree, this);

        gridView.setAdapter(gridOneAdapterThree);
        gridTwoView.setAdapter(gridOneAdapter2);
        gridThreeView.setAdapter(gridOneAdapter3);

        transferThree();
    }

    //퍼즐 4X4 GridView 클릭하고 옮기기
    public void transferFour() {
        ArrayList<Integer> actionFour = new ArrayList<Integer>();
        //먼저 완성되었는지 체크하기
        boolean result = completeCheck(fourCopy, fourStorage);
        if (!result) {
            GridLayout gridFourLayout = (GridLayout) findViewById(R.id.grid_four_layout);
            if (fourWhite == 0) {
                actionFour.add(1);
                actionFour.add(4);
            } else if (fourWhite == 1) {
                actionFour.add(0);
                actionFour.add(2);
                actionFour.add(5);
            } else if (fourWhite == 2) {
                actionFour.add(1);
                actionFour.add(3);
                actionFour.add(6);
            } else if (fourWhite == 3) {
                actionFour.add(2);
                actionFour.add(7);
            } else if (fourWhite == 4) {
                actionFour.add(0);
                actionFour.add(5);
                actionFour.add(8);
            } else if (fourWhite == 5) {
                actionFour.add(4);
                actionFour.add(6);
                actionFour.add(1);
                actionFour.add(9);
            } else if (fourWhite == 6) {
                actionFour.add(5);
                actionFour.add(7);
                actionFour.add(2);
                actionFour.add(10);
            } else if (fourWhite == 7) {
                actionFour.add(6);
                actionFour.add(3);
                actionFour.add(11);
            } else if (fourWhite == 8) {
                actionFour.add(4);
                actionFour.add(9);
                actionFour.add(12);
            } else if (fourWhite == 9) {
                actionFour.add(8);
                actionFour.add(10);
                actionFour.add(5);
                actionFour.add(13);
            } else if (fourWhite == 10) {
                actionFour.add(9);
                actionFour.add(11);
                actionFour.add(6);
                actionFour.add(14);
            } else if (fourWhite == 11) {
                actionFour.add(10);
                actionFour.add(15);
                actionFour.add(7);
            } else if (fourWhite == 12) {
                actionFour.add(8);
                actionFour.add(13);
            } else if (fourWhite == 13) {
                actionFour.add(12);
                actionFour.add(14);
                actionFour.add(9);
            } else if (fourWhite == 14) {
                actionFour.add(13);
                actionFour.add(15);
                actionFour.add(10);
            } else if (fourWhite == 15) {
                actionFour.add(14);
                actionFour.add(11);
            }

            GridView gridFourOne = (GridView) findViewById(R.id.grif_one_view);
            gridFourOne.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Log.d("text", Integer.toString(i));
                    int clickNumber = i;
                    if (actionFour.contains(clickNumber)) {
                        fourChange(clickNumber);
                    }
                }
            });

            GridView gridFourTwo = (GridView) findViewById(R.id.grif_two_view);
            gridFourTwo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    int clickNumber = i + 4;
                    if (actionFour.contains(clickNumber)) {
                        fourChange(clickNumber);
                    }
                }
            });

            GridView gridFourThree = (GridView) findViewById(R.id.grif_three_view);
            gridFourThree.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    int clickNumber = i + 8;
                    if (actionFour.contains(clickNumber)) {
                        fourChange(clickNumber);
                    }
                }
            });

            GridView gridFourFour = (GridView) findViewById(R.id.grif_four_view);
            gridFourFour.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    int clickNumber = i + 12;
                    if (actionFour.contains(clickNumber)) {
                        fourChange(clickNumber);
                    }
                }
            });
        } else {
            Toast.makeText(getApplicationContext(), "FINISHED!", Toast.LENGTH_LONG).show();
        }
    }

    //4X4 옮기기
    public void fourChange(int clickNumber) {
        changeView(1);
        number = 4;
        grifOneView = findViewById(R.id.grif_one_view);
        grifTwoView = findViewById(R.id.grif_two_view);
        grifThreeView = findViewById(R.id.grif_three_view);
        grifFourView = findViewById(R.id.grif_four_view);

        ArrayList<BitmapOneArray> itemsOne = new ArrayList<BitmapOneArray>();
        ArrayList<BitmapOneArray> itemsTwo = new ArrayList<BitmapOneArray>();
        ArrayList<BitmapOneArray> itemsThree = new ArrayList<BitmapOneArray>();
        ArrayList<BitmapOneArray> itemsFour = new ArrayList<BitmapOneArray>();

        Collections.swap(fourStorage, clickNumber, fourWhite);

        //셔플 이후 fourStorage Update 확인
        Log.d("text", fourStorage.toString());

        //셔플 이후 fourWhite 위치 찾고 위치 출
        fourWhite = fourStorage.indexOf(fourWhiteBit);
        Log.d("text", Integer.toString(fourWhite));

        for (int i=0; i<fourStorage.size(); i+=1) {
            if (i < 4) {
                itemsOne.add(new BitmapOneArray(fourStorage.get(i)));
            } else if (i < 8) {
                itemsTwo.add(new BitmapOneArray(fourStorage.get(i)));
            } else if (i < 12) {
                itemsThree.add(new BitmapOneArray(fourStorage.get(i)));
            } else {
                itemsFour.add(new BitmapOneArray(fourStorage.get(i)));
            }
        }

        GridOneAdapterFour gridOneAdapter = new GridOneAdapterFour(itemsOne, this);
        GridOneAdapterFour gridOneAdapter2 = new GridOneAdapterFour(itemsTwo, this);
        GridOneAdapterFour gridOneAdapter3 = new GridOneAdapterFour(itemsThree, this);
        GridOneAdapterFour gridOneAdapter4 = new GridOneAdapterFour(itemsFour, this);

        grifOneView.setAdapter(gridOneAdapter);
        grifTwoView.setAdapter(gridOneAdapter2);
        grifThreeView.setAdapter(gridOneAdapter3);
        grifFourView.setAdapter(gridOneAdapter4);

        transferFour();
    }
}