package com.example.yeapp.Activity;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.example.yeapp.R;
import com.example.yeapp.Adapter.CartListAdapter;
import com.example.yeapp.Helper.ManagementCart;
import com.example.yeapp.Interface.ChangeNumberItemsListener;

public class CartListActivity extends AppCompatActivity {

    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerViewList;
    private ManagementCart managementCart;
    private TextView totalFeeTxt,taxTxt,deliveryTxt,totalTxt,emptyTxt;
    private double tax;
    private ScrollView scrollView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_list);

        managementCart= new ManagementCart(this);

        initView();
        initList();
        CalculateCart();
        bottomNavigation();

    }

    private void bottomNavigation(){
        FloatingActionButton floatingActionButton = findViewById(R.id.cartBtn);
        LinearLayout homeBtn=findViewById(R.id.home);
        LinearLayout profileBtn=findViewById(R.id.profileBtn);
        LinearLayout supportBtn=findViewById(R.id.supportBtn);


        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CartListActivity.this,CartListActivity.class));
            }
        });
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CartListActivity.this,MainActivity.class));
            }
        });
        profileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CartListActivity.this,ProfileActivity.class));
            }
        });
        supportBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CartListActivity.this,SupportActivity.class));
            }
        });
    }


    private void initView() {
        recyclerViewList=findViewById(R.id.recyclerView);
        totalFeeTxt=findViewById(R.id.totalFeeTxt);
        taxTxt=findViewById(R.id.taxTxt);
        deliveryTxt=findViewById(R.id.deliveryTxt);
        totalTxt=findViewById(R.id.totalTxt);
        emptyTxt=findViewById(R.id.emptyTxt);
        scrollView=findViewById(R.id.scrollView3);
        recyclerViewList=findViewById(R.id.cartView);

    }
    private void initList(){
        LinearLayoutManager linearLayoutManager= new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerViewList.setLayoutManager(linearLayoutManager);
        adapter=new CartListAdapter(managementCart.getListCart(),this, new ChangeNumberItemsListener() {
            @Override
            public void changed() {
                CalculateCart();
            }
        });

        recyclerViewList.setAdapter(adapter);
        if (managementCart.getListCart().isEmpty()){
            emptyTxt.setVisibility(View.VISIBLE);
            scrollView.setVisibility(View.GONE);
        }else {
            emptyTxt.setVisibility(View.GONE);
            scrollView.setVisibility(View.VISIBLE);
        }
    }

    private void CalculateCart(){
        double percentTax = 0.02;
        double delivery = 10;

        if(managementCart.getTotalFee()==0){
        delivery=0;
        }

        tax= Math.round((managementCart.getTotalFee() * percentTax) * 100) / 100;
        double total = Math.round((managementCart.getTotalFee()+tax+delivery)*100) / 100;
        double itemTotal = Math.round(managementCart.getTotalFee()*100) / 100;
        totalFeeTxt.setText("₺" + itemTotal);
        taxTxt.setText("₺" + tax);
        deliveryTxt.setText("₺" + delivery);
        totalTxt.setText("₺" + total);
    }
}