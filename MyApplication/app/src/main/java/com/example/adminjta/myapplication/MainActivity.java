package com.example.adminjta.myapplication;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends ActionBarActivity {
    int quantity = 0;
    int price_coffe = 5;
    int price_total = 0;
    int price_chocolate = 5;
    int price_chantily = 2;
    String ptChocolate = "";
    String ptChantily = "";
    String urName = "";



    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        EditText name = (EditText) findViewById(R.id.urname);
        urName = name.getText().toString();
        calculatePrice();
        SetCheckBoxs(view);
        displayMessage(createOrderSummary());

    }

    public void sendEmail(View view){
        Intent intent = new Intent(Intent.ACTION_SENDTO);

        intent.setData(Uri.parse("mailto: arrthurxd@hotmail.com")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_TEXT, createOrderSummary());
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    }

    public void SetCheckBoxs(View view){
        CheckBox chantily = (CheckBox) findViewById(R.id.chantily);
        CheckBox chocolate = (CheckBox) findViewById(R.id.chocolate);
        boolean hasChantily = chantily.isChecked();
        boolean hasChocolate = chocolate.isChecked();


        if (hasChocolate){
            ptChocolate = "Com Chocolate";
            if (quantity>0){
                price_total += quantity*price_chocolate;
            }

        }
        else {
            ptChocolate = "Sem chocolate";
        }

        if (hasChantily){
            ptChantily = "Com chantily";
            if (quantity>0){
                price_total += quantity*price_chantily;
            }
        }
        else{
            ptChantily = "Sem chantily";
        }

    }
    /**
     * Calculates the price of the order.
     *
     */
    private int calculatePrice() {
        price_total = quantity * price_coffe;
        return price_total;

    }

    public String createOrderSummary(){
        String summaryMessage = "Nome: " + urName;
        summaryMessage+="\nCom chantily? " + ptChantily;
        summaryMessage+="\nCom chocolate? " + ptChocolate;
        summaryMessage+="\nQuantidade: " + quantity;
        summaryMessage+="\nTotal: " + price_total;
        summaryMessage+="\nThank you!";

        return summaryMessage;
    }


    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }


    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantatiy(int numberOfOtherThing) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + numberOfOtherThing);
    }

    /**
     * This method displays the given price on the screen.
     */

    public void increment(View view) {
        ;
        if (quantity<100) {
            quantity = quantity + 1;
            displayQuantatiy(quantity);

        }
        else{
            Toast.makeText(this, "Você não pode pedir mais de 100 cafés", Toast.LENGTH_SHORT).show();

        }
    }

    public void decrement(View view) {
        if (quantity>0) {
            quantity = quantity - 1;
            displayQuantatiy(quantity);

        }
        else{
            Toast.makeText(this, "Você não pode pedir menos de 0 cafés", Toast.LENGTH_SHORT).show();

        }
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.example.adminjta.myapplication/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.example.adminjta.myapplication/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}