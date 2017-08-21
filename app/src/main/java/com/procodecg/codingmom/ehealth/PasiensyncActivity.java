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


    //SINKRONISASI BERHASIL
    }
    public void goToProfil(View v){
        Intent activity = new Intent(this, BottombarActivity.class);
        startActivity(activity);
        finish();
    }
}

//    //SINKRONISASI TIDAK BERHASIL
//    Button mShowDialog = (Button) findViewById(R.id.btnShowDialog);
//        mShowDialog.setOnClickListener(new View.OnClickListener() {
//        @Override
//        public void onClick(View view) {
//            AlertDialog.Builder mBuilder = new AlertDialog.Builder(PasiensyncActivity.this);
//            mBuilder.setIcon(R.drawable.logo2);
//            mBuilder.setTitle("Kartu pasien tidak dapat diakses");
//            mBuilder.setMessage("Silahkan coba lagi");
//            mBuilder.setCancelable(false);
//            mBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//        @Override
//        public void onClick(DialogInterface dialogInterface, int i) {
//            dialogInterface.dismiss();
//            }
//            });
//            AlertDialog alertDialog = mBuilder.create();
//            alertDialog.show();
//        }
//        });
//        }
//        }