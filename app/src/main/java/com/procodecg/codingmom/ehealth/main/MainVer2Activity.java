package com.procodecg.codingmom.ehealth.main;

import android.app.Dialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.procodecg.codingmom.ehealth.R;
import com.procodecg.codingmom.ehealth.data.CopyDBHelper;
import com.procodecg.codingmom.ehealth.data.EhealthContract;
import com.procodecg.codingmom.ehealth.data.EhealthDbHelper;

import java.io.IOException;

public class MainVer2Activity extends AppCompatActivity {

    ImageButton btnSetting, Simpan;
    TextView txt_idPuskesmas;
    TextView txt_namaPuskesmas;
    Dialog ThisDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_ver2);



        btnSetting = (ImageButton) findViewById(R.id.btnSetting);
        txt_idPuskesmas = (TextView) findViewById(R.id.txt_idPuskesmas);
        txt_namaPuskesmas = (TextView) findViewById(R.id.txt_namaPuskesmas);


        btnSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnSetting();
            }
        });

        copyDBEhealth();
        getHPCdata();

    }

    private void btnSetting() {
        LayoutInflater inflater = LayoutInflater.from(MainVer2Activity.this);
        View subView = inflater.inflate(R.layout.dialog_puskesmas, null);
        final EditText subEditText = (EditText) subView.findViewById(R.id.idPuskesmas);
        final EditText subEditText1 = (EditText) subView.findViewById(R.id.namaPuskesmas);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(subView);
        AlertDialog alertDialog = builder.create();

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                txt_idPuskesmas.setText(subEditText.getText().toString());
                txt_namaPuskesmas.setText(subEditText1.getText().toString());
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainVer2Activity.this, "Cancel", Toast.LENGTH_LONG).show();
            }

        });
        builder.show();
    }

//ver2 old
//    private SetConfigVer2 setConfig;
////    private EditText idPuskesmas,namaPuskesmas;
////    private Button simpan, hapus;
////    private TextView txtIdPuskesmas;
////    private TextView txtNamaPuskesmas;
//    ImageButton DialogPuskesmas;
//    Button Show;
//    TextView IDPuskesmas, NamaPuskesmas;
//    Dialog ThisDialog;
//
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main_ver2);
//
//        copyDBEhealth();
//        getHPCdata();
//
//        DialogPuskesmas = (ImageButton) findViewById(R.id.btnSetting);
////*        Show = (Button) findViewById(R.id.btnShow);
//        IDPuskesmas = (TextView) findViewById(R.id.idPuskesmas);
//        NamaPuskesmas = (TextView) findViewById(R.id.namaPuskesmas);
//
//        DialogPuskesmas.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                ThisDialog = new Dialog(MainVer2Activity.this);
//                ThisDialog.setContentView(R.layout.dialog_puskesmas);
//
//                final EditText WriteId = (EditText)ThisDialog.findViewById(R.id.idPuskesmas);
//                final EditText WriteNama = (EditText)ThisDialog.findViewById(R.id.namaPuskesmas);
//                Button Simpan = (Button)ThisDialog.findViewById(R.id.btnSimpan);
//
//                WriteId.setEnabled(true);
//                WriteNama.setEnabled(true);
//                Simpan.setEnabled(true);
//
//                Simpan.setOnClickListener(new View.OnClickListener(){
//                    @Override
//                    public void onClick(View v){
////*                        SharedPrefesSimpan(WriteId.getText().toString());
////*                        SharedPrefesSimpan(WriteNama.getText().toString());
//                        ThisDialog.cancel();
//
//                        Toast.makeText(MainVer2Activity.this, "Data berhasil disimpan",Toast.LENGTH_SHORT).show();
//
//
//                    }
//                });
//
//
////        txtIdPuskesmas = (TextView) findViewById(R.id.txt_idPuskesmas);
////        txtIdPuskesmas.setText("12121121");
////
////        txtNamaPuskesmas = (TextView) findViewById(R.id.txt_namaPuskesmas);
////        txtNamaPuskesmas.setText("Sarijadi");
//
////        ImageButton settingButton = (ImageButton) findViewById(R.id.btnSetting);
////        settingButton.setOnClickListener(new View.OnClickListener(){
////            @Override
////            public void onClick(View view) {
////                AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainVer2Activity.this);
////                View mView = getLayoutInflater().inflate(R.layout.dialog_puskesmas,null);
////
////                setConfig = new SetConfigVer2(getApplicationContext() );
////                idPuskesmas = (EditText) findViewById(R.id.idPuskesmas);
////                namaPuskesmas= (EditText) findViewById(R.id.namaPuskesmas);
////                simpan = (Button) mView.findViewById(R.id.btnSimpan);
////
////                HashMap<String, String> setTexting = setConfig.getDetail();
////                idPuskesmas.setText(setTexting.get(setConfig.KEY_IDPUSKES));
////                namaPuskesmas.setText(setTexting.get(setConfig.KEY_NAMAPUSKES));
////
////                simpan.setOnClickListener(new View.OnClickListener() {
////                    @Override
////                    public void onClick(View view){
//////                        setConfig.createSetConfig(
//////                                idPuskesmas.getText().toString(),
//////                                namaPuskesmas.getText().toString()
//////                        );
////
////                        Toast.makeText(MainVer2Activity.this, "Data berhasil disimpan",Toast.LENGTH_SHORT).show();
////
//////                        finish();
//////                        return;
////                    }
////                });
////
////                mBuilder.setView(mView);
////                AlertDialog dialog = mBuilder.create();
////                dialog.show();
//                ThisDialog.show();
//
//            }
//        });
//
////        if (setting.get(SetConfig.KEY_IDPUSKES) !=null){
////            simpan.setText("UPDATE");
////        }
////        else{
////            simpan.setText("SIMPAN");
////        }
////
////        simpan.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View view) {
////                setConfig.createSetConfig(
////                idPuskesmas.getText().toString(),
////                namaPuskesmas.getText().toString());
////
////                Toast.makeText(MainVer2Activity.this, "Data Berhasil Disimpan!", Toast.LENGTH_SHORT).show();
////            }
////        });
//
//        //getHPCdata();
////    }
//
//        //*SHOW ID DAN NAMA PUSKESMAS
////        Show.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                SharedPreferences SimpanID = getApplicationContext().getSharedPreferences("IDPUSKESMAS", 0);
////                IDPuskesmas.setText(SimpanID.getString("IDPuskesmas", null));
////
////
////            }
////        });
//        //*
//    }
////*
////    public void SharedPrefesSimpan(String IdPuskesmas){
////        SharedPreferences prefs = getApplicationContext().getSharedPreferences("IDPUSKESMAS", 0);
////        SharedPreferences.Editor prefEDIT = prefs.edit();
////        prefEDIT.putString("IDPuskesmas", IdPuskesmas);
////        prefEDIT.commit();
////    }
////*
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
            //EhealthDBHelper mDbHelper = new EhealthDBHelper(getApplicationContext());
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


