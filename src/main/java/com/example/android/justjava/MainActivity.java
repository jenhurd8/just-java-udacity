package com.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
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
//    int price = 5;

    private String createOrderSummary(int price){
        String priceMessage = "Name: Kaptain Kunal";
         priceMessage +=  "\nQuantity: " + quantity;
         priceMessage += "\nTotal: $" + price;
        priceMessage +=  "\nThank you!";
        return priceMessage;
    }

    public void submitOrder(View view) {
        int price = calculatePrice();
        String priceMessage = createOrderSummary(price);
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
     * @return total price
     */

    private int calculatePrice() {
       int price = quantity * 5;
       return price;
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int numberOfCoffees) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + numberOfCoffees);
    }

    /**
     * This method displays the given price on the screen.
     */
//    private void displayPrice(int number) {
////        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
////        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
////    }


    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }
    }