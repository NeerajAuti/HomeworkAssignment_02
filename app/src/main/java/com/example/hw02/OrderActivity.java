package com.example.hw02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class OrderActivity extends AppCompatActivity {

    TextView tv_pizzaprice;
    TextView tv_toppingprice;
    TextView tv_toppingslist;
    TextView tv_deliverycharge;
    TextView tv_totalprice;
    Button button_finish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        tv_pizzaprice = findViewById(R.id.tv_pizzaprice);
        tv_toppingprice = findViewById(R.id.tv_toppingprice);
        tv_toppingslist = findViewById(R.id.tv_toppingslist);
        tv_deliverycharge = findViewById(R.id.tv_deliverycharge);
        tv_totalprice = findViewById(R.id.tv_totalprice);
        button_finish = findViewById(R.id.button_finish);

        boolean isDeliveryAvailable;
        Double toppingsPrice = 0.0;
        Double deliveryPrice = 0.0;
        Double total = 0.0;

        Intent intent = getIntent();
        int size = intent.getIntExtra("TotalToppings",0);
        isDeliveryAvailable = intent.getBooleanExtra("Delivery", false);
        Log.d("size", String.valueOf(size));
        Log.d("delivery",String.valueOf(isDeliveryAvailable));

        if(isDeliveryAvailable) {
            deliveryPrice = 4.0;
            tv_deliverycharge.setText(deliveryPrice + " $");
        } else {
            deliveryPrice = 0.0;
            tv_deliverycharge.setText(deliveryPrice + " $");
        }

        toppingsPrice = Double.valueOf(size) * 1.50;
        tv_toppingprice.setText(toppingsPrice.toString() + " $");

        total = 6.50 + toppingsPrice + deliveryPrice;
        tv_totalprice.setText(total.toString() + " $");

        button_finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goMain = new Intent(OrderActivity.this, MainActivity.class);
                finish();
            }
        });



    }
}
