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


    //PIN BENAR
  }
    public void goToPasien(View v){
        Intent activity = new Intent(this, PasiensyncActivity.class);
        startActivity(activity);
        finish();
   }
}

//    //PIN SALAH
//    Button mShowDialog = (Button) findViewById(R.id.btnShowDialog);
//        mShowDialog.setOnClickListener(new View.OnClickListener() {
//    @Override
//        public void onClick(View view) {
//        AlertDialog.Builder mBuilder = new AlertDialog.Builder(PinActivity.this);
//        mBuilder.setIcon(R.drawable.logo2);
//        mBuilder.setTitle("Pin yang Anda masukkan salah");
////        mBuilder.setMessage("Silahkan coba lagi");
//        mBuilder.setMessage("Anda sudah 3 kali salah memasukkan PIN, silahkan mencabut kartu dan ulangi prosedur dari awal");
//        mBuilder.setCancelable(false);
//        mBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//    @Override
//    public void onClick(DialogInterface dialogInterface, int i) {
//        dialogInterface.dismiss();
//        }
//        });
//        AlertDialog alertDialog = mBuilder.create();
//        alertDialog.show();
//        }
//        });
//        }
//        }