package com.procodecg.codingmom.ehealth.main;

import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.procodecg.codingmom.ehealth.utils.Edit;
import com.procodecg.codingmom.ehealth.R;
import com.procodecg.codingmom.ehealth.data.CopyDBHelper;
import com.procodecg.codingmom.ehealth.data.EhealthContract;
import com.procodecg.codingmom.ehealth.data.EhealthDbHelper;

import java.io.File;
import java.io.IOException;

public class MainVer2Activity extends AppCompatActivity {

    Typeface font;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_ver2);


        //deklarasi KEY untuk SP
        SharedPreferences prefs = getSharedPreferences("DATAPUSKES", MODE_PRIVATE);
        //default values
        String idpuskes = prefs.getString("IDPUSKES", "________");
        String namapuskes = prefs.getString("NAMAPUSKES", "________");

        //set values
        ((TextView) findViewById(R.id.txt_idPuskesmas)).setText(idpuskes);
        ((TextView) findViewById(R.id.txt_namaPuskesmas)).setText(namapuskes);

        font = Typeface.createFromAsset(getAssets(), "font1.ttf");
        TextView tv1 = (TextView) findViewById(R.id.textView1);
        TextView tv2 = (TextView) findViewById(R.id.textView2);
        TextView tv3 = (TextView) findViewById(R.id.textIdPuskes);
        TextView tv4 = (TextView) findViewById(R.id.textNamaPuskes);
        tv1.setTypeface(font);
        tv2.setTypeface(font);
        tv3.setTypeface(font);
        tv4.setTypeface(font);

        if (doesDatabaseExist(getApplicationContext(),"ehealth.db"))
        {
            //Toast.makeText(this, "DB ada", Toast.LENGTH_SHORT).show();
        }
        else
        {
            copyDBEhealth();
        }
        getHPCdata();
    }

      public void showEdit(View view) {
      startActivity(new Intent(getApplicationContext(),Edit.class));

// dikomen k irfan
    //copyDBEhealth();
        //getHPCdata();

    }

    private static boolean doesDatabaseExist(Context context, String dbName) {
        File dbFile = context.getDatabasePath(dbName);
        return dbFile.exists();
    }


    public void goToPin(View v){
        Intent activity = new Intent(this, Pin2Activity.class);
        startActivity(activity);
        finish();
    }

    public void copyDBEhealth(){

        CopyDBHelper mDBHelper = new CopyDBHelper(this);

        try {
            mDBHelper.updateDataBase();
        } catch (IOException mIOException) {
            throw new Error("UnableToUpdateDatabase");
        }

        try {
            SQLiteDatabase mDb = mDBHelper.getWritableDatabase();
        } catch (SQLException mSQLException) {
            throw mSQLException;
        }
        //mDBHelper.createTableKartu();
        mDBHelper.close();
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

        if (statusKartuHPC != false) {

            //Toast.makeText(this, "true ", Toast.LENGTH_SHORT).show();
            // Create database helper
            EhealthDbHelper db = new EhealthDbHelper(getApplicationContext());
            db.openDB();
            db.createTableKartu();
            //db.createTableRekMed();
            //mDbHelper.deleteAll();
            // Gets the database in write mode
            SQLiteDatabase mDbHelper = db.getWritableDatabase();

            // Create a ContentValues object where column names are the keys
            ContentValues values = new ContentValues();
            values.put(EhealthContract.KartuEntry.COLUMN_HPCNUMBER, HPCnumberString);
//            values.put(KartuEntry.COLUMN_PIN_HPC, PIN_HPC);
            values.put(EhealthContract.KartuEntry.COLUMN_DOKTER, namaDokterString);

            // Insert a new row in the database, returning the ID of that new row.
            long newRowId = mDbHelper.insert(EhealthContract.KartuEntry.TABLE_NAME, null, values);
            mDbHelper.close();
            // Show a toast message depending on whether or not the insertion was successful
            if (newRowId == -1) {
                // If the row ID is -1, then there was an error with insertion.
                Toast.makeText(this, "Sinkronisasi kartu HPC GAGAL!", Toast.LENGTH_SHORT).show();
            } else {
                // Otherwise, the insertion was successful and we can display a toast with the row ID.
                Toast.makeText(this, "Sinkronisasi kartu HPC BERHASIL! ", Toast.LENGTH_SHORT).show();
//                Intent activity = new Intent(this, Pin2Activity.class);
//                startActivity(activity);
//                finish();
            }
        } else
        {

            AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainVer2Activity.this);
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


