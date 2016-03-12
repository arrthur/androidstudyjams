package com.example.adminjta.myapplication;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends ActionBarActivity {
    int quantity = 0;
    int price = 0;
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

    public void SetCheckBoxs(View view){
        CheckBox chantily = (CheckBox) findViewById(R.id.chantily);
        CheckBox chocolate = (CheckBox) findViewById(R.id.chocolate);
        boolean hasChantily = chantily.isChecked();
        boolean hasChocolate = chocolate.isChecked();
        if (hasChantily){
            ptChantily = "Com chantily";
            price += 2;
        }
        else{
            ptChantily = "Sem chantily";
        }
        if (hasChocolate){
            ptChocolate = "Com Chocolate";
            price += 5;
        }
        else {
            ptChocolate = "Sem chocolate";
        }

    }

    public String createOrderSummary(){
        String summaryMessage = "Nome: " + urName;
        summaryMessage+="\nCom chantily? " + ptChantily;
        summaryMessage+="\nCom chocolate? " + ptChocolate;
        summaryMessage+="\nQuantidade: " + quantity;
        summaryMessage+="\nTotal: " + price;
        summaryMessage+="\nThank you!";

        return summaryMessage;
    }
    /**
     * Calculates the price of the order.
     *
     */
    private void calculatePrice() {
        price = quantity * 5;
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
        quantity = quantity + 1;
        displayQuantatiy(quantity);

    }

    public void decrement(View view) {
        ;
        quantity = quantity - 1;
        displayQuantatiy(quantity);

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