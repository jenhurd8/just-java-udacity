package com.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    int quantity = 1;

    //int price = 5;
/*
Create summary of the order
*
*@param addWhippedCream is whether or not the user wants whipped cream
*@param addChocolate is where or not the user wants chocolate topping
*@param price of the order
*@return text summary
*/

    private String createOrderSummary(int price, boolean addWhippedCream, boolean addChocolate){
        String priceMessage = "Name: Kaptain Kunal";
        priceMessage += "\nAdd whipped cream? " + addWhippedCream;
        priceMessage += "\nAdd chocolate? " + addChocolate;
         priceMessage +=  "\nQuantity: " + quantity;
         priceMessage += "\nTotal: $" + price;
        priceMessage +=  "\nThank you!";
        return priceMessage;
    }

    public void submitOrder(View view) {
        CheckBox whippedCreamCheckBox = (CheckBox)findViewById(R.id.whipped_cream_checkbox);
        CheckBox hasChocolateCheckBox = (CheckBox)findViewById(R.id.has_chocolate_checkbox);

        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();
        boolean hasChocolate = hasChocolateCheckBox.isChecked();
        Log.v("MainActivity", "Has whipped cream: " + hasWhippedCream);

        int price = calculatePrice(hasWhippedCream, hasChocolate);
        String priceMessage = createOrderSummary(price, hasWhippedCream, hasChocolate);
        displayMessage(priceMessage);
    }

    public void increment(View view) {
        quantity++;
        display(quantity);
    }

    public void decrement(View view) {
        quantity--;
        display(quantity);
    }

    /**
     * Calculates the price of the order.
     *
     *@param addWhippedCream is whether or not the user wants whipped cream topping
     *@param addChocolate is where or not the user wants chocolate topping
     *@return total price
     */

    private int calculatePrice(boolean addWhippedCream, boolean addChocolate) {
        int basePrice = 5;
        if(addWhippedCream){
            basePrice = basePrice++;
        }
        if(addChocolate){
            basePrice += 2;
        }

       return quantity * basePrice;

    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int numberOfCoffees) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + numberOfCoffees);
    }


    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }
    }