package com.procodecg.codingmom.ehealth;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

/**
 * Created by macbookpro on 7/27/17.
 */

public class PasiensyncActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_pasiensync);
    }

    public void goToProfil(View v){
        Intent activity = new Intent(this, BottombarActivity.class);
        startActivity(activity);
        finish();
//        Toast.makeText(PasiensyncActivity.this, "Data pasien tidak ditemukan, masukkan kartu lain",
//                Toast.LENGTH_LONG).show();
    }
}
