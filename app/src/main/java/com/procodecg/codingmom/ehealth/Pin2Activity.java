package com.procodecg.codingmom.ehealth;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import com.goodiebag.pinview.Pinview;

public class Pin2Activity extends AppCompatActivity {

    public static void hideKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        //Find the currently focused view, so we can grab the correct window token from it.
        View view = activity.getCurrentFocus();
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = new View(activity);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pin2);

        Pinview pinview = (Pinview) findViewById(R.id.pinView);
        pinview.setPinViewEventListener(new Pinview.PinViewEventListener() {
            @Override
            public void onDataEntered(Pinview pinview, boolean b) {
                //Toast.makeText(Pin2Activity.this, "" + pinview.getValue(), Toast.LENGTH_SHORT).show();
                Toast.makeText(Pin2Activity.this, "Password benar", Toast.LENGTH_SHORT).show();

                hideKeyboard(Pin2Activity.this);

                Intent activity = new Intent(Pin2Activity.this, PasiensyncActivity.class);
                startActivity(activity);
                finish();
            }
        });
    }
    public void goToPasien(View v){
        Intent activity = new Intent(this, PasiensyncActivity.class);
        startActivity(activity);
        finish();
    }


}
