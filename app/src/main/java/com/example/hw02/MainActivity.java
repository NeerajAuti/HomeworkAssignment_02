package com.example.hw02;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button button_add;
    Button button_checkout;
    String[] toppingsList = {"Bacon","Cheese","Garlic","Green Pepper","Mushroom","Olives","Onions","Red Pepper"};
    ArrayList<String> selectedToppings = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Pizza Store");

        button_add = findViewById(R.id.button_add);
        button_checkout = findViewById(R.id.button_checkout);

        button_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Choose a Topping");

                builder.setItems(toppingsList, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int topping) {
                        switch (topping) {
                            case 0:
                                selectedToppings.add("Bacon");
                                break;
                            case 1:
                                selectedToppings.add("Cheese");
                                break;
                            case 2:
                                selectedToppings.add("Garlic");
                                break;
                            case 3:
                                selectedToppings.add("Green Pepper");
                                break;
                            case 4:
                                selectedToppings.add("Mushroom");
                                break;
                            case 5:
                                selectedToppings.add("Olives");
                                break;
                            case 6:
                                selectedToppings.add("Onions");
                                break;
                            case 7:
                                selectedToppings.add("Red Pepper");
                                break;
                            default:
                                break;
                        }
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
                Log.d("alert",selectedToppings.toString());
            }
        });

        button_checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent displayOrder = new Intent(MainActivity.this, OrderActivity.class);
                startActivity(displayOrder);
            }
        });
    }
}
