package edu.skku.map.pa1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

public class GridOneAdapterFour extends BaseAdapter {

    ArrayList<BitmapOneArray> bitmapOneArrays;
    Context context;

    public GridOneAdapterFour(ArrayList<BitmapOneArray> bitmapOneArrays, Context context){
        this.bitmapOneArrays = bitmapOneArrays;
        this.context = context;
    }

    @Override
    public int getCount() {
        return bitmapOneArrays.size();
    }

    @Override
    public Object getItem(int i) {
        return bitmapOneArrays.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.one_layout_four, viewGroup, false);
        }

        ImageView one_left = view.findViewById(R.id.one_left_four);
        one_left.setImageDrawable(null);
        one_left.setImageDrawable(bitmapOneArrays.get(i).bitmapDrawableOne);
        one_left.setClickable(false);

        return view;
    }
}
