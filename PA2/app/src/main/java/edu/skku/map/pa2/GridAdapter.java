package edu.skku.map.pa2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import static edu.skku.map.pa2.MainActivity.entireArray;
import static edu.skku.map.pa2.MainActivity.getLeftArray;
import static edu.skku.map.pa2.MainActivity.getTopArray;
import static edu.skku.map.pa2.MainActivity.leftAdapter1;
import static edu.skku.map.pa2.MainActivity.leftAdapter10;
import static edu.skku.map.pa2.MainActivity.leftAdapter11;
import static edu.skku.map.pa2.MainActivity.leftAdapter12;
import static edu.skku.map.pa2.MainActivity.leftAdapter13;
import static edu.skku.map.pa2.MainActivity.leftAdapter14;
import static edu.skku.map.pa2.MainActivity.leftAdapter15;
import static edu.skku.map.pa2.MainActivity.leftAdapter16;
import static edu.skku.map.pa2.MainActivity.leftAdapter17;
import static edu.skku.map.pa2.MainActivity.leftAdapter18;
import static edu.skku.map.pa2.MainActivity.leftAdapter19;
import static edu.skku.map.pa2.MainActivity.leftAdapter2;
import static edu.skku.map.pa2.MainActivity.leftAdapter20;
import static edu.skku.map.pa2.MainActivity.leftAdapter3;
import static edu.skku.map.pa2.MainActivity.leftAdapter4;
import static edu.skku.map.pa2.MainActivity.leftAdapter5;
import static edu.skku.map.pa2.MainActivity.leftAdapter6;
import static edu.skku.map.pa2.MainActivity.leftAdapter7;
import static edu.skku.map.pa2.MainActivity.leftAdapter8;
import static edu.skku.map.pa2.MainActivity.leftAdapter9;
import static edu.skku.map.pa2.MainActivity.leftArray;
import static edu.skku.map.pa2.MainActivity.topArray;

public class GridAdapter extends BaseAdapter {

    ArrayList<IntegerList> arrayList;
    Context context;
    Activity activity;
    ArrayList<ArrayList> copyList;
    ArrayList<ArrayList> copyListR;

    public GridAdapter(ArrayList<IntegerList> arrayList, Context context, Activity activity) {
        this.arrayList = arrayList;
        this.context = context;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.row_layout, viewGroup, false);
        }

        ImageView oneImage = view.findViewById(R.id.one);
        ImageView twoImage = view.findViewById(R.id.two);
        ImageView threeImage = view.findViewById(R.id.three);
        ImageView fourImage = view.findViewById(R.id.four);
        ImageView fiveImage = view.findViewById(R.id.five);
        ImageView sixImage = view.findViewById(R.id.six);
        ImageView sevenImage = view.findViewById(R.id.seven);
        ImageView eightImage = view.findViewById(R.id.eight);
        ImageView nineImage = view.findViewById(R.id.nine);
        ImageView tenImage = view.findViewById(R.id.ten);
        ImageView elevenImage = view.findViewById(R.id.eleven);
        ImageView twelveImage = view.findViewById(R.id.twelve);
        ImageView thirteenImage = view.findViewById(R.id.thirteen);
        ImageView fourteenImage = view.findViewById(R.id.fourteen);
        ImageView fifteenImage = view.findViewById(R.id.fifteen);
        ImageView sixteenImage = view.findViewById(R.id.sixteen);
        ImageView seventeenImage = view.findViewById(R.id.seventeen);
        ImageView eighteenImage = view.findViewById(R.id.eighteen);
        ImageView nineteenImage = view.findViewById(R.id.nineteen);
        ImageView twentyImage = view.findViewById(R.id.twenty);

        oneImage.setBackgroundColor(Color.parseColor("#ffffff"));
        twoImage.setBackgroundColor(Color.parseColor("#ffffff"));
        threeImage.setBackgroundColor(Color.parseColor("#ffffff"));
        fourImage.setBackgroundColor(Color.parseColor("#ffffff"));
        fiveImage.setBackgroundColor(Color.parseColor("#ffffff"));
        sixImage.setBackgroundColor(Color.parseColor("#ffffff"));
        sevenImage.setBackgroundColor(Color.parseColor("#ffffff"));
        eightImage.setBackgroundColor(Color.parseColor("#ffffff"));
        nineImage.setBackgroundColor(Color.parseColor("#ffffff"));
        tenImage.setBackgroundColor(Color.parseColor("#ffffff"));
        elevenImage.setBackgroundColor(Color.parseColor("#ffffff"));
        twelveImage.setBackgroundColor(Color.parseColor("#ffffff"));
        thirteenImage.setBackgroundColor(Color.parseColor("#ffffff"));
        fourteenImage.setBackgroundColor(Color.parseColor("#ffffff"));
        fifteenImage.setBackgroundColor(Color.parseColor("#ffffff"));
        sixteenImage.setBackgroundColor(Color.parseColor("#ffffff"));
        seventeenImage.setBackgroundColor(Color.parseColor("#ffffff"));
        eighteenImage.setBackgroundColor(Color.parseColor("#ffffff"));
        nineteenImage.setBackgroundColor(Color.parseColor("#ffffff"));
        twentyImage.setBackgroundColor(Color.parseColor("#ffffff"));

        copyList = new ArrayList<>();
        copyList = Deep_Copy(entireArray);
        copyListR = new ArrayList<>();
        copyListR = Deep_Copy(topArray);

        oneImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<ArrayList> temp = new ArrayList<>();
                ArrayList<ArrayList> tempR = new ArrayList<>();
                if (arrayList.get(i).one == 0) {
                    copyList.clear();
                    temp = getLeftArray(entireArray);
                    leftListView(temp);

                    tempR = getLeftArray(topArray);
                    topListView(tempR);
                    notifyDataSetChanged();
                } else if (arrayList.get(i).one == 1){
                    copyList.get(i).set(0, 0);
                    temp = getLeftArray(copyList);
                    leftListView(temp);

                    tempR = getTopArray(copyList);
                    topListView(tempR);
                    Log.d("check", copyList.toString());
                    oneImage.setBackgroundColor(Color.parseColor("#000000"));
                    check(copyList);
                }
            }
        });
        twoImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<ArrayList> temp = new ArrayList<>();
                ArrayList<ArrayList> tempR = new ArrayList<>();
                if (arrayList.get(i).two == 0) {
                    copyList.clear();
                    temp = getLeftArray(entireArray);
                    leftListView(temp);

                    tempR = getLeftArray(topArray);
                    topListView(tempR);
                    notifyDataSetChanged();
                } else if(arrayList.get(i).two == 1) {
                    copyList.get(i).set(1, 0);
                    temp = getLeftArray(copyList);
                    leftListView(temp);

                    tempR = getTopArray(copyList);
                    topListView(tempR);
                    Log.d("check", copyList.toString());
                    twoImage.setBackgroundColor(Color.parseColor("#000000"));
                    check(copyList);
                }
            }
        });

        threeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<ArrayList> temp = new ArrayList<>();
                ArrayList<ArrayList> tempR = new ArrayList<>();
                if (arrayList.get(i).three == 0) {
                    temp = getLeftArray(entireArray);
                    leftListView(temp);

                    tempR = getLeftArray(topArray);
                    topListView(tempR);
                    notifyDataSetChanged();
                } else if (arrayList.get(i).three == 1) {
                    copyList.get(i).set(2, 0);
                    temp = getLeftArray(copyList);
                    leftListView(temp);

                    tempR = getTopArray(copyList);
                    topListView(tempR);
                    Log.d("check", copyList.toString());
                    threeImage.setBackgroundColor(Color.parseColor("#000000"));
                    check(copyList);
                }
            }
        });
        fourImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<ArrayList> temp = new ArrayList<>();
                ArrayList<ArrayList> tempR = new ArrayList<>();
                if (arrayList.get(i).four == 0) {
                    temp = getLeftArray(entireArray);
                    leftListView(temp);

                    tempR = getLeftArray(topArray);
                    topListView(tempR);
                    notifyDataSetChanged();
                } else if (arrayList.get(i).four == 1) {
                    copyList.get(i).set(3, 0);
                    temp = getLeftArray(copyList);
                    leftListView(temp);

                    tempR = getTopArray(copyList);
                    topListView(tempR);
                    Log.d("check", copyList.toString());
                    fourImage.setBackgroundColor(Color.parseColor("#000000"));
                    check(copyList);
                }
            }
        });
        fiveImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<ArrayList> temp = new ArrayList<>();
                ArrayList<ArrayList> tempR = new ArrayList<>();
                if (arrayList.get(i).five == 0) {
                    copyList.clear();
                    temp = getLeftArray(entireArray);
                    leftListView(temp);

                    tempR = getLeftArray(topArray);
                    topListView(tempR);
                    notifyDataSetChanged();
                } else if (arrayList.get(i).five == 1) {
                    copyList.get(i).set(4, 0);
                    temp = getLeftArray(copyList);
                    leftListView(temp);

                    tempR = getTopArray(copyList);
                    topListView(tempR);
                    Log.d("check", copyList.toString());
                    fiveImage.setBackgroundColor(Color.parseColor("#000000"));
                    check(copyList);
                }
            }
        });
        sixImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<ArrayList> temp = new ArrayList<>();
                ArrayList<ArrayList> tempR = new ArrayList<>();
                if (arrayList.get(i).six == 0) {
                    copyList.clear();
                    temp = getLeftArray(entireArray);
                    leftListView(temp);

                    tempR = getLeftArray(topArray);
                    topListView(tempR);
                    notifyDataSetChanged();
                } else if (arrayList.get(i).six == 1) {
                    copyList.get(i).set(5, 0);
                    temp = getLeftArray(copyList);
                    leftListView(temp);

                    tempR = getTopArray(copyList);
                    topListView(tempR);
                    Log.d("check", copyList.toString());
                    sixImage.setBackgroundColor(Color.parseColor("#000000"));
                    check(copyList);
                }
            }
        });
        sevenImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<ArrayList> tempR = new ArrayList<>();
                if (arrayList.get(i).seven == 0) {
                    copyList.clear();
                    ArrayList<ArrayList> temp = getLeftArray(entireArray);
                    leftListView(temp);

                    tempR = getLeftArray(topArray);
                    topListView(tempR);
                    notifyDataSetChanged();
                } else if (arrayList.get(i).seven == 1) {
                    copyList.get(i).set(6, 0);
                    ArrayList<ArrayList> temp = getLeftArray(copyList);
                    leftListView(temp);

                    tempR = getTopArray(copyList);
                    topListView(tempR);
                    Log.d("check", copyList.toString());
                    sevenImage.setBackgroundColor(Color.parseColor("#000000"));
                    check(copyList);
                }
            }
        });
        eightImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<ArrayList> tempR = new ArrayList<>();
                if (arrayList.get(i).eight == 0) {
                    copyList.clear();
                    ArrayList<ArrayList> temp = getLeftArray(entireArray);
                    leftListView(temp);

                    tempR = getLeftArray(topArray);
                    topListView(tempR);
                    notifyDataSetChanged();
                } else if (arrayList.get(i).eight == 1) {
                    copyList.get(i).set(7, 0);
                    ArrayList<ArrayList> temp = getLeftArray(copyList);
                    leftListView(temp);

                    tempR = getTopArray(copyList);
                    topListView(tempR);
                    Log.d("check", copyList.toString());
                    eightImage.setBackgroundColor(Color.parseColor("#000000"));
                    check(copyList);
                }
            }
        });
        nineImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<ArrayList> tempR = new ArrayList<>();
                if (arrayList.get(i).nine == 0) {
                    copyList.clear();
                    ArrayList<ArrayList> temp = getLeftArray(entireArray);
                    leftListView(temp);

                    tempR = getLeftArray(topArray);
                    topListView(tempR);
                    notifyDataSetChanged();
                } else if (arrayList.get(i).nine == 1) {
                    copyList.get(i).set(8, 0);
                    ArrayList<ArrayList> temp = getLeftArray(copyList);
                    leftListView(temp);

                    tempR = getTopArray(copyList);
                    topListView(tempR);
                    Log.d("check", copyList.toString());
                    nineImage.setBackgroundColor(Color.parseColor("#000000"));
                    check(copyList);
                }
            }
        });
        tenImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<ArrayList> tempR = new ArrayList<>();
                if (arrayList.get(i).ten == 0) {
                    copyList.clear();
                    ArrayList<ArrayList> temp = getLeftArray(entireArray);
                    leftListView(temp);

                    tempR = getLeftArray(topArray);
                    topListView(tempR);
                    notifyDataSetChanged();
                } else if (arrayList.get(i).ten == 1) {
                    copyList.get(i).set(9, 0);
                    ArrayList<ArrayList> temp = getLeftArray(copyList);
                    leftListView(temp);

                    tempR = getTopArray(copyList);
                    topListView(tempR);
                    Log.d("check", copyList.toString());
                    tenImage.setBackgroundColor(Color.parseColor("#000000"));
                    check(copyList);
                }
            }
        });
        elevenImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<ArrayList> tempR = new ArrayList<>();
                if (arrayList.get(i).eleven == 0) {
                    copyList.clear();
                    ArrayList<ArrayList> temp = getLeftArray(entireArray);
                    leftListView(temp);

                    tempR = getLeftArray(topArray);
                    topListView(tempR);
                    notifyDataSetChanged();
                } else if (arrayList.get(i).eleven == 1) {
                    copyList.get(i).set(10, 0);
                    ArrayList<ArrayList> temp = getLeftArray(copyList);
                    leftListView(temp);

                    tempR = getTopArray(copyList);
                    topListView(tempR);
                    Log.d("check", copyList.toString());
                    elevenImage.setBackgroundColor(Color.parseColor("#000000"));
                    check(copyList);
                }
            }
        });
        twelveImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<ArrayList> tempR = new ArrayList<>();
                if (arrayList.get(i).twelve == 0) {
                    copyList.clear();
                    ArrayList<ArrayList> temp = getLeftArray(entireArray);
                    leftListView(temp);

                    tempR = getLeftArray(topArray);
                    topListView(tempR);
                    notifyDataSetChanged();
                } else if (arrayList.get(i).twelve == 1) {
                    copyList.get(i).set(11, 0);
                    ArrayList<ArrayList> temp = getLeftArray(copyList);
                    leftListView(temp);

                    tempR = getTopArray(copyList);
                    topListView(tempR);
                    Log.d("check", copyList.toString());
                    twelveImage.setBackgroundColor(Color.parseColor("#000000"));
                    check(copyList);
                }
            }
        });
        thirteenImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<ArrayList> tempR = new ArrayList<>();
                if (arrayList.get(i).thirteen == 0) {
                    copyList.clear();
                    ArrayList<ArrayList> temp = getLeftArray(entireArray);
                    leftListView(temp);

                    tempR = getLeftArray(topArray);
                    topListView(tempR);
                    notifyDataSetChanged();
                } else if (arrayList.get(i).thirteen == 1) {
                    copyList.get(i).set(12, 0);
                    ArrayList<ArrayList> temp = getLeftArray(copyList);
                    leftListView(temp);

                    tempR = getTopArray(copyList);
                    topListView(tempR);
                    Log.d("check", copyList.toString());
                    thirteenImage.setBackgroundColor(Color.parseColor("#000000"));
                    check(copyList);
                }
            }
        });
        fourteenImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<ArrayList> tempR = new ArrayList<>();
                if (arrayList.get(i).fourteen == 0) {
                    copyList.clear();
                    ArrayList<ArrayList> temp = getLeftArray(entireArray);
                    leftListView(temp);

                    tempR = getLeftArray(topArray);
                    topListView(tempR);
                    notifyDataSetChanged();
                } else if (arrayList.get(i).fourteen == 1) {
                    copyList.get(i).set(13, 0);
                    ArrayList<ArrayList> temp = getLeftArray(copyList);
                    leftListView(temp);

                    tempR = getTopArray(copyList);
                    topListView(tempR);
                    Log.d("check", copyList.toString());
                    fourteenImage.setBackgroundColor(Color.parseColor("#000000"));
                    check(copyList);
                }
            }
        });
        fifteenImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<ArrayList> tempR = new ArrayList<>();
                if (arrayList.get(i).fifteen == 0) {
                    copyList.clear();
                    ArrayList<ArrayList> temp = getLeftArray(entireArray);
                    leftListView(temp);

                    tempR = getLeftArray(topArray);
                    topListView(tempR);
                    notifyDataSetChanged();
                } else if (arrayList.get(i).fifteen == 1) {
                    copyList.get(i).set(14, 0);
                    ArrayList<ArrayList> temp = getLeftArray(copyList);
                    leftListView(temp);

                    tempR = getTopArray(copyList);
                    topListView(tempR);
                    Log.d("check", copyList.toString());
                    fifteenImage.setBackgroundColor(Color.parseColor("#000000"));
                    check(copyList);
                }
            }
        });
        sixteenImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<ArrayList> tempR = new ArrayList<>();
                if (arrayList.get(i).sixteen == 0) {
                    copyList.clear();
                    ArrayList<ArrayList> temp = getLeftArray(entireArray);
                    leftListView(temp);

                    tempR = getLeftArray(topArray);
                    topListView(tempR);
                    notifyDataSetChanged();
                } else if (arrayList.get(i).sixteen == 1) {
                    copyList.get(i).set(15, 0);
                    ArrayList<ArrayList> temp = getLeftArray(copyList);
                    leftListView(temp);

                    tempR = getTopArray(copyList);
                    topListView(tempR);
                    Log.d("check", copyList.toString());
                    sixteenImage.setBackgroundColor(Color.parseColor("#000000"));
                }
            }
        });
        seventeenImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<ArrayList> tempR = new ArrayList<>();
                if (arrayList.get(i).seventeen == 0) {
                    copyList.clear();
                    ArrayList<ArrayList> temp = getLeftArray(entireArray);
                    leftListView(temp);

                    tempR = getLeftArray(topArray);
                    topListView(tempR);
                    notifyDataSetChanged();
                } else if (arrayList.get(i).seventeen == 1) {
                    copyList.get(i).set(16, 0);
                    ArrayList<ArrayList> temp = getLeftArray(copyList);
                    leftListView(temp);

                    tempR = getTopArray(copyList);
                    topListView(tempR);
                    Log.d("check", copyList.toString());
                    seventeenImage.setBackgroundColor(Color.parseColor("#000000"));
                    check(copyList);
                }
            }
        });
        eighteenImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<ArrayList> tempR = new ArrayList<>();
                if (arrayList.get(i).eighteen == 0) {
                    copyList.clear();
                    ArrayList<ArrayList> temp = getLeftArray(entireArray);
                    leftListView(temp);

                    tempR = getLeftArray(topArray);
                    topListView(tempR);
                    notifyDataSetChanged();
                } else if (arrayList.get(i).eighteen == 1) {
                    copyList.get(i).set(17, 0);
                    ArrayList<ArrayList> temp = getLeftArray(copyList);
                    leftListView(temp);

                    tempR = getTopArray(copyList);
                    topListView(tempR);
                    Log.d("check", copyList.toString());
                    eighteenImage.setBackgroundColor(Color.parseColor("#000000"));
                    check(copyList);
                }
            }
        });
        nineteenImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<ArrayList> tempR = new ArrayList<>();
                if (arrayList.get(i).nineteen == 0) {
                    copyList.clear();
                    ArrayList<ArrayList> temp = getLeftArray(entireArray);
                    leftListView(temp);

                    tempR = getLeftArray(topArray);
                    topListView(tempR);
                    notifyDataSetChanged();
                } else if (arrayList.get(i).nineteen == 1) {
                    copyList.get(i).set(18, 0);
                    ArrayList<ArrayList> temp = getLeftArray(copyList);
                    leftListView(temp);

                    tempR = getTopArray(copyList);
                    topListView(tempR);
                    Log.d("check", copyList.toString());
                    nineteenImage.setBackgroundColor(Color.parseColor("#000000"));
                    check(copyList);
                }
            }
        });
        twentyImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<ArrayList> tempR = new ArrayList<>();
                if (arrayList.get(i).twenty == 0) {
                    copyList.clear();
                    ArrayList<ArrayList> temp = getLeftArray(entireArray);
                    leftListView(temp);

                    tempR = getLeftArray(topArray);
                    topListView(tempR);
                    notifyDataSetChanged();
                } else if (arrayList.get(i).twenty == 1) {
                    copyList.get(i).set(19, 0);
                    ArrayList<ArrayList> temp = getLeftArray(copyList);
                    leftListView(temp);

                    tempR = getTopArray(copyList);
                    topListView(tempR);
                    Log.d("check", copyList.toString());
                    twentyImage.setBackgroundColor(Color.parseColor("#000000"));
                    check(copyList);
                }
            }
        });

        return view;
    }

    public void check(ArrayList<ArrayList> copyList) {
        int total = 0;
        for (int i=0; i<20; i++) {
            ArrayList<Integer> integerArrayList = copyList.get(i);
            if (copyList.contains(1)) {
                total++;
            }
        }
        if (total == 0) {
            Toast.makeText(context, "FINISH", Toast.LENGTH_LONG);
        }
    }

    public void leftListView(ArrayList<ArrayList> partOne) {
        int maxWidth = 0;
        for (int i=0; i<20; i++) {
            int temp = partOne.get(i).size();
            if (temp >= maxWidth) {
                maxWidth = temp;
            }
        }

        LinearLayout topView = activity.findViewById(R.id.top_view);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) topView.getLayoutParams();
        layoutParams.leftMargin = dpPx(maxWidth * 11);
        topView.setLayoutParams(layoutParams);

            GridView leftView1 = activity.findViewById(R.id.left_one);
            leftView1.setNumColumns(partOne.get(0).size());
            leftView1.invalidateViews();
            LinearLayout linearLayout1 = activity.findViewById(R.id.wrap_one);
            LinearLayout.LayoutParams layoutParams1 = (LinearLayout.LayoutParams) linearLayout1.getLayoutParams();
            layoutParams1.width = dpPx(partOne.get(0).size() * 11);
            linearLayout1.setLayoutParams(layoutParams1);
            leftAdapter1 = new LeftAdapter(partOne.get(0), activity.getApplicationContext());
            leftView1.setAdapter(leftAdapter1);

            GridView leftView2 = activity.findViewById(R.id.left_two);
            leftView2.setNumColumns(partOne.get(1).size());
            leftView2.invalidateViews();
            LinearLayout linearLayout2 = activity.findViewById(R.id.wrap_two);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) linearLayout2.getLayoutParams();
            layoutParams2.width = dpPx(partOne.get(1).size() * 11);
            linearLayout2.setLayoutParams(layoutParams2);
            leftAdapter2 = new LeftAdapter(partOne.get(1), activity.getApplicationContext());
            leftView2.setAdapter(leftAdapter2);

            GridView leftView3 = activity.findViewById(R.id.left_three);
            leftView3.setNumColumns(partOne.get(2).size());
            leftView3.invalidateViews();
            LinearLayout linearLayout3 = activity.findViewById(R.id.wrap_three);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) linearLayout3.getLayoutParams();
            layoutParams3.width = dpPx(partOne.get(2).size() * 11);
            linearLayout3.setLayoutParams(layoutParams3);
            leftAdapter3 = new LeftAdapter(partOne.get(2), activity.getApplicationContext());
            leftView3.setAdapter(leftAdapter3);

            GridView leftView4 = activity.findViewById(R.id.left_four);
            leftView4.setNumColumns(partOne.get(3).size());
            leftView4.invalidateViews();
            LinearLayout linearLayout4 = activity.findViewById(R.id.wrap_four);
            LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) linearLayout4.getLayoutParams();
            layoutParams4.width = dpPx(partOne.get(3).size() * 11);
            linearLayout4.setLayoutParams(layoutParams4);
            leftAdapter4 = new LeftAdapter(partOne.get(3), activity.getApplicationContext());
            leftView4.setAdapter(leftAdapter4);

            GridView leftView5 = activity.findViewById(R.id.left_five);
            leftView5.setNumColumns(partOne.get(4).size());
            leftView5.invalidateViews();
            LinearLayout linearLayout5 = activity.findViewById(R.id.wrap_five);
            LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) linearLayout5.getLayoutParams();
            layoutParams5.width = dpPx(partOne.get(4).size() * 11);
            linearLayout5.setLayoutParams(layoutParams5);
            leftAdapter5 = new LeftAdapter(partOne.get(4), activity.getApplicationContext());
            leftView5.setAdapter(leftAdapter5);

            GridView leftView6 = activity.findViewById(R.id.left_six);
            leftView6.setNumColumns(partOne.get(5).size());
            leftView6.invalidateViews();
            LinearLayout linearLayout6 = activity.findViewById(R.id.wrap_six);
            LinearLayout.LayoutParams layoutParams6 = (LinearLayout.LayoutParams) linearLayout6.getLayoutParams();
            layoutParams6.width = dpPx(partOne.get(5).size() * 11);
            linearLayout6.setLayoutParams(layoutParams6);
            leftAdapter6 = new LeftAdapter(partOne.get(5), activity.getApplicationContext());
            leftView6.setAdapter(leftAdapter6);

            GridView leftView7 = activity.findViewById(R.id.left_seven);
            leftView7.setNumColumns(partOne.get(6).size());
            leftView7.invalidateViews();
            LinearLayout linearLayout7 = activity.findViewById(R.id.wrap_seven);
            LinearLayout.LayoutParams layoutParams7 = (LinearLayout.LayoutParams) linearLayout7.getLayoutParams();
            layoutParams7.width = dpPx(partOne.get(6).size() * 11);
            linearLayout7.setLayoutParams(layoutParams7);
            leftAdapter7 = new LeftAdapter(partOne.get(6), activity.getApplicationContext());
            leftView7.setAdapter(leftAdapter7);

            GridView leftView8 = activity.findViewById(R.id.left_eight);
            leftView8.setNumColumns(partOne.get(7).size());
            leftView8.invalidateViews();
            LinearLayout linearLayout8 = activity.findViewById(R.id.wrap_eight);
            LinearLayout.LayoutParams layoutParams8 = (LinearLayout.LayoutParams) linearLayout8.getLayoutParams();
            layoutParams8.width = dpPx(partOne.get(7).size() * 11);
            linearLayout8.setLayoutParams(layoutParams8);
            leftAdapter8 = new LeftAdapter(partOne.get(7), activity.getApplicationContext());
            leftView8.setAdapter(leftAdapter8);

            GridView leftView9 = activity.findViewById(R.id.left_nine);
            leftView9.setNumColumns(partOne.get(8).size());
            leftView9.invalidateViews();
            LinearLayout linearLayout9 = activity.findViewById(R.id.wrap_nine);
            LinearLayout.LayoutParams layoutParams9 = (LinearLayout.LayoutParams) linearLayout9.getLayoutParams();
            layoutParams9.width = dpPx(partOne.get(8).size() * 11);
            linearLayout9.setLayoutParams(layoutParams9);
            leftAdapter9 = new LeftAdapter(partOne.get(8), activity.getApplicationContext());
            leftView9.setAdapter(leftAdapter9);

            GridView leftView10 = activity.findViewById(R.id.left_ten);
            leftView10.setNumColumns(partOne.get(9).size());
            leftView10.invalidateViews();
            LinearLayout linearLayout10 = activity.findViewById(R.id.wrap_ten);
            LinearLayout.LayoutParams layoutParams10 = (LinearLayout.LayoutParams) linearLayout10.getLayoutParams();
            layoutParams10.width = dpPx(partOne.get(9).size() * 11);
            linearLayout10.setLayoutParams(layoutParams10);
            leftAdapter10 = new LeftAdapter(partOne.get(9), activity.getApplicationContext());
            leftView10.setAdapter(leftAdapter10);

            GridView leftView11 = activity.findViewById(R.id.left_eleven);
            leftView11.setNumColumns(partOne.get(10).size());
            LinearLayout linearLayout11 = activity.findViewById(R.id.wrap_eleven);
            LinearLayout.LayoutParams layoutParams11 = (LinearLayout.LayoutParams) linearLayout11.getLayoutParams();
            layoutParams11.width = dpPx(partOne.get(10).size() * 11);
            linearLayout11.setLayoutParams(layoutParams11);
            leftAdapter11 = new LeftAdapter(partOne.get(10), activity.getApplicationContext());
            leftView11.setAdapter(leftAdapter11);

            GridView leftView12 = activity.findViewById(R.id.left_twelve);
            leftView12.setNumColumns(partOne.get(11).size());
            LinearLayout linearLayout12 = activity.findViewById(R.id.wrap_twelve);
            LinearLayout.LayoutParams layoutParams12 = (LinearLayout.LayoutParams) linearLayout12.getLayoutParams();
            layoutParams12.width = dpPx(partOne.get(11).size() * 11);
            linearLayout12.setLayoutParams(layoutParams12);
            leftAdapter12 = new LeftAdapter(partOne.get(11), activity.getApplicationContext());
            leftView12.setAdapter(leftAdapter12);

            GridView leftView13 = activity.findViewById(R.id.left_thirteen);
            leftView13.setNumColumns(partOne.get(12).size());
            LinearLayout linearLayout13 = activity.findViewById(R.id.wrap_thirteen);
            LinearLayout.LayoutParams layoutParams13 = (LinearLayout.LayoutParams) linearLayout13.getLayoutParams();
            layoutParams13.width = dpPx(partOne.get(12).size() * 11);
            linearLayout13.setLayoutParams(layoutParams13);
            leftAdapter13 = new LeftAdapter(partOne.get(12), activity.getApplicationContext());
            leftView13.setAdapter(leftAdapter13);

            GridView leftView14 = activity.findViewById(R.id.left_fourteen);
            leftView14.setNumColumns(partOne.get(13).size());
            LinearLayout linearLayout14 = activity.findViewById(R.id.wrap_fourteen);
            LinearLayout.LayoutParams layoutParams14 = (LinearLayout.LayoutParams) linearLayout14.getLayoutParams();
            layoutParams14.width = dpPx(partOne.get(13).size() * 11);
            linearLayout14.setLayoutParams(layoutParams14);
            leftAdapter14 = new LeftAdapter(partOne.get(13), activity.getApplicationContext());
            leftView14.setAdapter(leftAdapter14);

            GridView leftView15 = activity.findViewById(R.id.left_fifteen);
            leftView15.setNumColumns(partOne.get(14).size());
            LinearLayout linearLayout15 = activity.findViewById(R.id.wrap_fifteen);
            LinearLayout.LayoutParams layoutParams15 = (LinearLayout.LayoutParams) linearLayout15.getLayoutParams();
            layoutParams15.width = dpPx(partOne.get(14).size() * 11);
            linearLayout15.setLayoutParams(layoutParams15);
            leftAdapter15 = new LeftAdapter(partOne.get(14), activity.getApplicationContext());
            leftView15.setAdapter(leftAdapter15);

            GridView leftView16 = activity.findViewById(R.id.left_sixteen);
            leftView16.setNumColumns(partOne.get(15).size());
            LinearLayout linearLayout16 = activity.findViewById(R.id.wrap_sixteen);
            LinearLayout.LayoutParams layoutParams16 = (LinearLayout.LayoutParams) linearLayout16.getLayoutParams();
            layoutParams16.width = dpPx(partOne.get(15).size() * 11);
            linearLayout16.setLayoutParams(layoutParams16);
            leftAdapter16 = new LeftAdapter(partOne.get(15), activity.getApplicationContext());
            leftView16.setAdapter(leftAdapter16);

            GridView leftView17 = activity.findViewById(R.id.left_seventeen);
            leftView17.setNumColumns(partOne.get(16).size());
            LinearLayout linearLayout17 = activity.findViewById(R.id.wrap_seventeen);
            LinearLayout.LayoutParams layoutParams17 = (LinearLayout.LayoutParams) linearLayout17.getLayoutParams();
            layoutParams17.width = dpPx(partOne.get(16).size() * 11);
            linearLayout17.setLayoutParams(layoutParams17);
            leftAdapter17 = new LeftAdapter(partOne.get(16), activity.getApplicationContext());
            leftView17.setAdapter(leftAdapter17);

            GridView leftView18 = activity.findViewById(R.id.left_eighteen);
            leftView18.setNumColumns(partOne.get(17).size());
            LinearLayout linearLayout18 = activity.findViewById(R.id.wrap_eighteen);
            LinearLayout.LayoutParams layoutParams18 = (LinearLayout.LayoutParams) linearLayout18.getLayoutParams();
            layoutParams18.width = dpPx(partOne.get(17).size() * 11);
            linearLayout18.setLayoutParams(layoutParams18);
            leftAdapter18 = new LeftAdapter(partOne.get(17), activity.getApplicationContext());
            leftView18.setAdapter(leftAdapter18);

            GridView leftView19 = activity.findViewById(R.id.left_nineteen);
            leftView19.setNumColumns(partOne.get(18).size());
            LinearLayout linearLayout19 = activity.findViewById(R.id.wrap_nineteen);
            LinearLayout.LayoutParams layoutParams19 = (LinearLayout.LayoutParams) linearLayout19.getLayoutParams();
            layoutParams19.width = dpPx(partOne.get(18).size() * 11);
            linearLayout19.setLayoutParams(layoutParams19);
            leftAdapter19 = new LeftAdapter(partOne.get(18), activity.getApplicationContext());
            leftView19.setAdapter(leftAdapter19);

            GridView leftView20 = activity.findViewById(R.id.left_twenty);
            leftView20.setNumColumns(partOne.get(19).size());
            LinearLayout linearLayout20 = activity.findViewById(R.id.wrap_twenty);
            LinearLayout.LayoutParams layoutParams20 = (LinearLayout.LayoutParams) linearLayout20.getLayoutParams();
            layoutParams20.width = dpPx(partOne.get(19).size() * 11);
            linearLayout20.setLayoutParams(layoutParams20);
            leftAdapter20 = new LeftAdapter(partOne.get(19), activity.getApplicationContext());
            leftView20.setAdapter(leftAdapter20);
    }

    public void topListView (ArrayList<ArrayList> partTwo) {
            ListView listView1 = activity.findViewById(R.id.top_one);
            TopAdapter topAdapter1 = new TopAdapter(partTwo.get(0), activity.getApplicationContext());
            listView1.setAdapter(topAdapter1);

        ListView listView2 = activity.findViewById(R.id.top_two);
            TopAdapter topAdapter2 = new TopAdapter(partTwo.get(1), activity.getApplicationContext());
            listView2.setAdapter(topAdapter2);

        ListView listView3 = activity.findViewById(R.id.top_three);
            TopAdapter topAdapter3 = new TopAdapter(partTwo.get(2), activity.getApplicationContext());
            listView3.setAdapter(topAdapter3);

        ListView listView4 = activity.findViewById(R.id.top_four);
            TopAdapter topAdapter4 = new TopAdapter(partTwo.get(3), activity.getApplicationContext());
            listView4.setAdapter(topAdapter4);

        ListView listView5 = activity.findViewById(R.id.top_five);
            TopAdapter topAdapter5 = new TopAdapter(partTwo.get(4), activity.getApplicationContext());
            listView5.setAdapter(topAdapter5);

        ListView listView6 = activity.findViewById(R.id.top_six);
            TopAdapter topAdapter6 = new TopAdapter(partTwo.get(5), activity.getApplicationContext());
            listView6.setAdapter(topAdapter6);

        ListView listView7 = activity.findViewById(R.id.top_seven);
            TopAdapter topAdapter7 = new TopAdapter(partTwo.get(6), activity.getApplicationContext());
            listView7.setAdapter(topAdapter7);

        ListView listView8 = activity.findViewById(R.id.top_eight);
            TopAdapter topAdapter8 = new TopAdapter(partTwo.get(7), activity.getApplicationContext());
            listView8.setAdapter(topAdapter8);

        ListView listView9 = activity.findViewById(R.id.top_nine);
            TopAdapter topAdapter9 = new TopAdapter(partTwo.get(8), activity.getApplicationContext());
            listView9.setAdapter(topAdapter9);

        ListView listView10 = activity.findViewById(R.id.top_ten);
            TopAdapter topAdapter10 = new TopAdapter(partTwo.get(9), activity.getApplicationContext());
            listView10.setAdapter(topAdapter10);

        ListView listView11 = activity.findViewById(R.id.top_eleven);
            TopAdapter topAdapter11 = new TopAdapter(partTwo.get(10), activity.getApplicationContext());
            listView11.setAdapter(topAdapter11);

        ListView listView12 = activity.findViewById(R.id.top_twelve);
            TopAdapter topAdapter12 = new TopAdapter(partTwo.get(11), activity.getApplicationContext());
            listView12.setAdapter(topAdapter12);

        ListView listView13 = activity.findViewById(R.id.top_thirteen);
            TopAdapter topAdapter13 = new TopAdapter(partTwo.get(12), activity.getApplicationContext());
            listView13.setAdapter(topAdapter13);

        ListView listView14 = activity.findViewById(R.id.top_fourteen);
            TopAdapter topAdapter14 = new TopAdapter(partTwo.get(13), activity.getApplicationContext());
            listView14.setAdapter(topAdapter14);

        ListView listView15 = activity.findViewById(R.id.top_fifteen);
            TopAdapter topAdapter15 = new TopAdapter(partTwo.get(14), activity.getApplicationContext());
            listView15.setAdapter(topAdapter15);

        ListView listView16 = activity.findViewById(R.id.top_sixteen);
        TopAdapter topAdapter16 = new TopAdapter(partTwo.get(15), activity.getApplicationContext());
        listView16.setAdapter(topAdapter16);

        ListView listView17 = activity.findViewById(R.id.top_seventeen);
        TopAdapter topAdapter17 = new TopAdapter(partTwo.get(16), activity.getApplicationContext());
        listView17.setAdapter(topAdapter17);

        ListView listView18 = activity.findViewById(R.id.top_eighteen);
        TopAdapter topAdapter18 = new TopAdapter(partTwo.get(17), activity.getApplicationContext());
        listView18.setAdapter(topAdapter18);

        ListView listView19 = activity.findViewById(R.id.top_nineteen);
        TopAdapter topAdapter19 = new TopAdapter(partTwo.get(18), activity.getApplicationContext());
        listView19.setAdapter(topAdapter19);

        ListView listView20 = activity.findViewById(R.id.top_twenty);
        TopAdapter topAdapter20 = new TopAdapter(partTwo.get(19), activity.getApplicationContext());
        listView20.setAdapter(topAdapter20);
    }

    public int dpPx(int dp) {
        float density = activity.getResources().getDisplayMetrics().density;
        return Math.round((float) dp * density);
    }

    public static ArrayList<ArrayList> Deep_Copy(ArrayList<ArrayList> list){
        ArrayList<ArrayList> temp = new ArrayList<ArrayList>();
        for(ArrayList list_item: list){
            temp.add((ArrayList) list_item.clone());
        }
        return temp;
    }
}
