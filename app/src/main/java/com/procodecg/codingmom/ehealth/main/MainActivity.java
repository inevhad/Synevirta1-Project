package com.procodecg.codingmom.ehealth.main;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.procodecg.codingmom.ehealth.R;
import com.procodecg.codingmom.ehealth.data.CopyDBHelper;

import com.procodecg.codingmom.ehealth.data.EhealthContract.KartuEntry;

/**
 * Created by macbookpro on 7/25/17.
 */

public class MainActivity extends AppCompatActivity {
    private CopyDBHelper mDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        getHPCdata();
        //KARTU BENAR
    }
    public void goToPin(View v){
        Intent activity = new Intent(this, Pin2Activity.class);
        startActivity(activity);
        finish();
    }

    /** mengambil data dari kartu HPC
     *
     */

    public void getHPCdata() {
        // Read from input fields
        // Use trim to eliminate leading or trailing white space
        Boolean statusKartuHPC = true;
        String HPCnumberString = "D12345";
        String namaDokterString = "dr. Sinta";
        String PIN_HPC = "12345";

        if (statusKartuHPC != false) {

            //Toast.makeText(this, "true ", Toast.LENGTH_SHORT).show();
            // Create database helper
            CopyDBHelper mDbHelper = new CopyDBHelper(this);
            //mDbHelper.deleteAll();
            // Gets the database in write mode
            SQLiteDatabase db = mDbHelper.getWritableDatabase();

            // Create a ContentValues object where column names are the keys,
            // and pet attributes from the editor are the values.
            ContentValues values = new ContentValues();
//            values.put(KartuEntry.COLUMN_HPC_NUMBER, HPCnumberString);
//            values.put(KartuEntry.COLUMN_PIN_HPC, PIN_HPC);
//            values.put(KartuEntry.COLUMN_NAMA_DOKTER, namaDokterString);

            // Insert a new row in the database, returning the ID of that new row.
            long newRowId = db.insert(KartuEntry.TABLE_NAME, null, values);

            // Show a toast message depending on whether or not the insertion was successful
            if (newRowId == -1) {
             // If the row ID is -1, then there was an error with insertion.
             Toast.makeText(this, "Sinkronisasi kartu HPC BERHASIL!", Toast.LENGTH_SHORT).show();
             } else {
             // Otherwise, the insertion was successful and we can display a toast with the row ID.
             Toast.makeText(this, "Sinkronisasi kartu HPC GAGAL! ", Toast.LENGTH_SHORT).show();
//                Intent activity = new Intent(this, Pin2Activity.class);
//                startActivity(activity);
//                finish();
             }
        } else
        {

            AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);
            mBuilder.setIcon(R.drawable.logo2);
            mBuilder.setTitle("Kartu yang Anda masukkan tidak dapat diakses");
            mBuilder.setMessage("Silahkan coba lagi atau masukkan kartu lain");
            mBuilder.setCancelable(false);
            mBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                  @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });

                AlertDialog alertDialog = mBuilder.create();
                alertDialog.show();

            }
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



