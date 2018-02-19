package com.procodecg.codingmom.ehealth.pasien;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.TextView;

import com.procodecg.codingmom.ehealth.R;
import com.procodecg.codingmom.ehealth.data.EhealthContract;
import com.procodecg.codingmom.ehealth.data.EhealthDbHelper;
import com.procodecg.codingmom.ehealth.fragment.BottombarActivity;

/**
 * Created by macbookpro on 8/9/17.
 */

public class PasiendetailActivity extends AppCompatActivity {

    private TextView txtTitle;
    Typeface fontBold;
    private static String currentPDCNumber;
    public static String currentNamaPasien;
    public static String currentUmurPasien;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //MENGHILANGKAN TOOLBAR
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_pasiendetail);

        txtTitle = (TextView) findViewById(R.id.txt_title);
        txtTitle.setText("Bio Data Pasien");

        fontBold = Typeface.createFromAsset(getAssets(),"font1bold.ttf");
        txtTitle.setTypeface(fontBold);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationIcon(R.drawable.xblue);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),BottombarActivity.class));
            }
        });

        //set popup window
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.92),(int)(height*.88));

        getPDCdata();

    }

    @Override
    protected void onStart() {
        super.onStart();
        displayNamaPasien();
    }


    //SETTING DISPLAY NAMA DAN UMUR PASIEN
    private void displayNamaPasien() {
        // Create and/or open a database to read from it
        EhealthDbHelper mDbHelper = new EhealthDbHelper(this);
        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        final TextView textNamaPasientv = (TextView) findViewById(R.id.textNamaPasien);
        textNamaPasientv.setText(currentNamaPasien);

//        final TextView textUmurPasientv = (TextView) findViewById(R.id.textUmurPasien);

        String[] projection = {
                EhealthContract.KartuEntry.COLUMN_PDCNUMBER,
                EhealthContract.KartuEntry.COLUMN_NAMAPASIEN,
//                EhealthContract.KartuEntry.COLUMN_UMURPASIEN,
                //KartuEntry.COLUMN_PIN_HPC,
        };

        Cursor cursor = db.query(EhealthContract.KartuEntry.TABLE_NAME,projection,null,null,null,null,null);
        // TextView displayView = (TextView) findViewById(R.id.text_view_kartu);
        // Perform this raw SQL query "SELECT * FROM pets"
        // to get a Cursor that contains all rows from the pets table.
        // Cursor cursor = db.rawQuery("SELECT * FROM " + KartuEntry.TABLE_NAME, null);

        try {

            // Figure out the index of each column
            // int idColumnIndex = cursor.getColumnIndex(KartuEntry._ID);
            int PDCnumberColumnIndex = cursor.getColumnIndex(EhealthContract.KartuEntry.COLUMN_PDCNUMBER);
            int namaPasienColumnIndex = cursor.getColumnIndex(EhealthContract.KartuEntry.COLUMN_NAMAPASIEN);
//            int umurPasienColumnIndex = cursor.getColumnIndex(EhealthContract.KartuEntry.COLUMN_UMURPASIEN);

            // Iterate through all the returned rows in the cursor

            while (cursor.moveToNext()) {
                // Use that index to extract the String or Int value of the word
                // at the current row the cursor is on.
                // int currentID = cursor.getInt(idColumnIndex);
                currentPDCNumber= cursor.getString(PDCnumberColumnIndex);
                currentNamaPasien = cursor.getString(namaPasienColumnIndex);
//                currentUmurPasien = cursor.getString(umurPasienColumnIndex);

                //String currentPinHPC = cursor.getString(pinHPCColumnIndex);
                // Menampilkan nama pasien
                textNamaPasientv.setText(currentNamaPasien);
                textNamaPasientv.setVisibility(View.VISIBLE);
                // Menampilkan umur pasien
//                textUmurPasientv.setText(currentUmurPasien);
//                textUmurPasientv.setVisibility(View.VISIBLE);

            }

        } finally {
            // Always close the cursor when you're done reading from it. This releases all its
            // resources and makes it invalid.
            cursor.close();
        }
    }

    public static String getNamaPasien(){
        return currentNamaPasien;
    }


    public void getPDCdata() {

//        pdc = new PDCActivity(getApplicationContext());
        //Boolean statusKartuHPC = true;
        String namaPasienString = "Budi Utomo";
//        String umurPasienString = "30 tahun 8 bulan";

        //Toast.makeText(this, "true ", Toast.LENGTH_SHORT).show();
        // Create database helper
//        EhealthDbHelper db = new EhealthDbHelper(getApplicationContext());
//        db.openDB();
//        db.createTableKartu();
        //db.createTableRekMed();
        //mDbHelper.deleteAll();
        // Gets the database in write mode
//        SQLiteDatabase mDbHelper = db.getWritableDatabase();

        // Create a ContentValues object where column names are the keys
        ContentValues values = new ContentValues();
        values.put(EhealthContract.KartuEntry.COLUMN_NAMAPASIEN, namaPasienString);
//            values.put(KartuEntry.COLUMN_PIN_HPC, PIN_HPC);
//        values.put(EhealthContract.KartuEntry.COLUMN_UMURPASIEN, umurPasienString);

        // Insert a new row in the database, returning the ID of that new row.
//        long newRowId = mDbHelper.insert(EhealthContract.KartuEntry.TABLE_NAME, null, values);
//        mDbHelper.close();

    }

}
