package com.foodwood;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.Console;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;

public class Frag1 extends androidx.fragment.app.Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_1, container, false);

        //Chinese

        CardView v = (CardView) view.findViewById(R.id.Chinese);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(),ListReceipeActivity.class);
                i.putExtra("category","Chinese");
               startActivity(i);
            }
        });

        //Breakfast

        CardView w = (CardView) view.findViewById(R.id.Breakfast);
        w.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View w) {
                Intent i = new Intent(getContext(),ListReceipeActivity.class);
                i.putExtra("category","Breakfast");
                startActivity(i);
            }
        });

        //Curry

        CardView x = (CardView) view.findViewById(R.id.Curry);
        x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View x) {
                Intent i = new Intent(getContext(),ListReceipeActivity.class);
                i.putExtra("category","Curry");
                startActivity(i);
            }
        });

        //Salad

        CardView y = (CardView) view.findViewById(R.id.Salad);
        y.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View y) {
                Intent i = new Intent(getContext(),ListReceipeActivity.class);
                i.putExtra("category","Salad");
                startActivity(i);
            }
        });

        //Non_Veg

        CardView z = (CardView) view.findViewById(R.id.Non_Veg);
        z.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View z) {
                Intent i = new Intent(getContext(),ListReceipeActivity.class);
                i.putExtra("category","Non-Veg");
                startActivity(i);
            }
        });

        //Snacks

        CardView z1 = (CardView) view.findViewById(R.id.Snacks);
        z1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View z1) {
                Intent i = new Intent(getContext(),ListReceipeActivity.class);
                i.putExtra("category","Snacks");
                startActivity(i);
            }
        });

        //Desert

        CardView z2 = (CardView) view.findViewById(R.id.Desert);
        z2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View z2) {
                Intent i = new Intent(getContext(),ListReceipeActivity.class);
                i.putExtra("category","Desert");
                startActivity(i);
            }
        });

        //Biryani

        CardView z3 = (CardView) view.findViewById(R.id.Biryani);
        z3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View z3) {
                Intent i = new Intent(getContext(),ListReceipeActivity.class);
                i.putExtra("category","Biryani");
                startActivity(i);
            }
        });

        //South

        CardView z4 = (CardView) view.findViewById(R.id.South);
        z4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View z4) {
                Intent i = new Intent(getContext(),ListReceipeActivity.class);
                i.putExtra("category","South");
                startActivity(i);
            }
        });

        // Drinks---


        CardView z5 = (CardView) view.findViewById(R.id.Drinks);
        z5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View z4) {
                Intent i = new Intent(getContext(),ListReceipeActivity.class);
                i.putExtra("category","Drinks");
                startActivity(i);
            }
        });

        // North---


        CardView z6= (CardView) view.findViewById(R.id.North);
        z6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View z6) {
                Intent i = new Intent(getContext(),ListReceipeActivity.class);
                i.putExtra("category","North");
                startActivity(i);
            }
        });

        // Desert---


        CardView z7= (CardView) view.findViewById(R.id.Other);
        z7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View z7) {
                Intent i = new Intent(getContext(),ListReceipeActivity.class);
                i.putExtra("category","Other");
                startActivity(i);
            }
        });
        return view;
    }


}
