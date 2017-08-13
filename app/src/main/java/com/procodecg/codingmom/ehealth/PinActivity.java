package com.procodecg.codingmom.ehealth;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

/**
 * Created by macbookpro on 7/27/17.
 */

public class PinActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_pin);
}

    public void goToPasien(View v){
        Intent activity = new Intent(this, PasiensyncActivity.class);
        startActivity(activity);
        finish();
//        Toast.makeText(PinActivity.this, "PIN yang Anda masukkan salah, masukkan PIN lagi",
//                Toast.LENGTH_LONG).show();
    }
}
