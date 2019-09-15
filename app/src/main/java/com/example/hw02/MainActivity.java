package com.example.hw02;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    CheckBox cb_delivery;
    Button button_add;
    Button button_clear;
    Button button_checkout;
    ProgressBar progressBar;
    String[] toppingsList = {"Bacon", "Cheese", "Garlic", "Green Pepper", "Mushroom", "Olives", "Onions", "Red Pepper"};
    ArrayList<String> selectedToppings = new ArrayList<String>();
    boolean isChecked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Pizza Store");

        cb_delivery = findViewById(R.id.cb_delivery);
        button_add = findViewById(R.id.button_add);
        button_clear = findViewById(R.id.button_clear);
        button_checkout = findViewById(R.id.button_checkout);
        progressBar = findViewById(R.id.progressBar);

        button_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Choose a Topping");

                builder.setItems(toppingsList, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int topping) {
                        if (selectedToppings.size() < 10) {
                            switch (topping) {
                                case 0:
                                    selectedToppings.add("Bacon");
                                    progressBar.incrementProgressBy(10);
                                    break;
                                case 1:
                                    selectedToppings.add("Cheese");
                                    progressBar.incrementProgressBy(10);
                                    break;
                                case 2:
                                    selectedToppings.add("Garlic");
                                    progressBar.incrementProgressBy(10);
                                    break;
                                case 3:
                                    selectedToppings.add("Green Pepper");
                                    progressBar.incrementProgressBy(10);
                                    break;
                                case 4:
                                    selectedToppings.add("Mushroom");
                                    progressBar.incrementProgressBy(10);
                                    break;
                                case 5:
                                    selectedToppings.add("Olives");
                                    progressBar.incrementProgressBy(10);
                                    break;
                                case 6:
                                    selectedToppings.add("Onions");
                                    progressBar.incrementProgressBy(10);
                                    break;
                                case 7:
                                    selectedToppings.add("Red Pepper");
                                    progressBar.incrementProgressBy(10);
                                    break;
                                default:
                                    break;
                            }
                        } else {
                            Toast.makeText(getApplicationContext(), "Maximum Topping capacity reached!!", Toast.LENGTH_SHORT);
                            Log.d("Maximum capacity", selectedToppings.toString());
                        }
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
                Log.d("alert", selectedToppings.toString());
            }
        });

        button_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedToppings.removeAll(selectedToppings);
                Log.d("remove",selectedToppings.toString());
                progressBar.setProgress(0);
            }
        });

        button_checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent displayOrder = new Intent(MainActivity.this, OrderActivity.class);
                isChecked = cb_delivery.isChecked();

                displayOrder.putExtra("TotalToppings", selectedToppings.size());
                displayOrder.putExtra("Delivery", isChecked);
                startActivity(displayOrder);
            }
        });
    }
}
