package com.example.yeapp.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.service.controls.actions.FloatAction;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.example.yeapp.R;
import com.example.yeapp.Adapter.CategoryAdaptor;
import com.example.yeapp.Adapter.PopularAdaptor;
import com.example.yeapp.Domain.CategoryDomain;
import com.example.yeapp.Domain.FoodDomain;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapter, adapter2;
    private RecyclerView recyclerViewCategoryList, recyclerViewPopularList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewCategory();
        recyclerViewPopular();
        bottomNavigation();

    }
    private void bottomNavigation(){
        FloatingActionButton cartBtn = findViewById(R.id.cartBtn);
        LinearLayout homeBtn=findViewById(R.id.startBtn);
        LinearLayout profileBtn = findViewById(R.id.profileBtn);
        LinearLayout supportBtn = findViewById(R.id.supportBtn);

        cartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,CartListActivity.class));
            }
        });
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,MainActivity.class));
            }
        });
        profileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,ProfileActivity.class));
            }
        });
        supportBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,SupportActivity.class));
            }
        });
    }

    private void recyclerViewCategory() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewCategoryList = findViewById(R.id.recyclerView);
        recyclerViewCategoryList.setLayoutManager(linearLayoutManager);


        ArrayList<CategoryDomain> category = new ArrayList<>();
        category.add(new CategoryDomain("Pizza", "cat_1"));
        category.add(new CategoryDomain("Burger", "cat_2"));
        category.add(new CategoryDomain("Sosisli", "cat_3"));
        category.add(new CategoryDomain("İçecek", "cat_4"));
        category.add(new CategoryDomain("Donut", "cat_5"));

        adapter= new CategoryAdaptor(category);
        recyclerViewCategoryList.setAdapter(adapter);
    }
    private void recyclerViewPopular(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerViewPopularList=findViewById(R.id.recyclerView2);
        recyclerViewPopularList.setLayoutManager(linearLayoutManager);


        ArrayList<FoodDomain> foodList = new ArrayList<>();
        foodList.add(new FoodDomain("Pepperoni Pizza", "pop_1", "Dilim Pepperoni, Mozzarella Peyniri, Taze Kekik, Karabiber, Pizza Sosu", 9.76));
        foodList.add(new FoodDomain("Cheese Burger", "pop_2","Dana Eti, Gouda Peyniri, Özel Sos, Marul, Domates", 8.79));
        foodList.add(new FoodDomain("Sebzeli Pizza", "pop_3", "Zeytinyağı, Bitkisel Yağ, Çekirdeksiz Kalamata, Çeri Domates, Taze Kekik, Fesleğen", 8.5));

        adapter2=new PopularAdaptor(foodList);
        recyclerViewPopularList.setAdapter(adapter2);
    }
}