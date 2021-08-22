package com.foodwood;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import androidx.cardview.widget.CardView;


public class adapter extends ArrayAdapter {
    private Context mContext;
    private adapter mAdapter;

    ArrayList<module_list> mod_list;

    public adapter(Context context, ArrayList<module_list> list) {
        super(context, 0, list);
        mContext = context;
        mod_list = list;
    }

    public View getView(int position, View convertView,  ViewGroup parent) {
        View listItem = convertView;
        if(listItem == null)
            listItem = LayoutInflater.from(mContext).inflate(R.layout.activity_single_list,parent,false);
        module_list mod = mod_list.get(position);
        ImageView image_recipe = listItem.findViewById(R.id.imageid);
        String link_main = "https://foodwoodapp.000webhostapp.com/Recipe%20App%20Admin/"+mod.getMlink();
        URL url = null;
        try {
            url = new URL(link_main);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        Glide.with(listItem).load(url).into(image_recipe);

        TextView recipename = listItem.findViewById(R.id.text);
        recipename.setText(mod.getmName());
        listItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView text = v.findViewById(R.id.text);
                if(text!=null) {
                    Log.d("checking", text.getText().toString());
                    Intent intent = new Intent(getContext(), detail.class);
                    intent.putExtra("recipe_name", text.getText().toString());
                    mContext.startActivity(intent);
                }
            }


        });


        return listItem;
    }
}