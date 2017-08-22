package com.procodecg.codingmom.ehealth;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import static com.procodecg.codingmom.ehealth.Pin2Activity.hideKeyboard;

/**
 * Created by macbookpro on 7/25/17.
 */

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        //KARTU BENAR
    }
    public void goToPin(View v){
        Intent activity = new Intent(this, Pin2Activity.class);
        startActivity(activity);
        finish();
    }
}

        //KARTU SALAH
//        Button mShowDialog = (Button) findViewById(R.id.btnShowDialog);
//        mShowDialog.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);
//                mBuilder.setIcon(R.drawable.logo2);
//                mBuilder.setTitle("Kartu yang Anda masukkan tidak dapat diakses");
//                mBuilder.setMessage("Silahkan coba lagi atau masukkan kartu lain");
//                mBuilder.setCancelable(false);
//                mBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        dialogInterface.dismiss();
//                    }
//                });
//
//                AlertDialog alertDialog = mBuilder.create();
//                alertDialog.show();
//
//            }
//        });
//    }
//}



