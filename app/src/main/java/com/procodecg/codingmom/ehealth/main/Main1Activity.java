package com.procodecg.codingmom.ehealth.main;

import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.procodecg.codingmom.ehealth.R;
import com.procodecg.codingmom.ehealth.data.DatabaseHelper;
import com.procodecg.codingmom.ehealth.data.EhealthContract;

import java.io.IOException;
import java.util.HashMap;

public class Main1Activity extends AppCompatActivity {


    private SetConfig setConfig;
    private EditText idpuskes,namapuskes;
    private Button simpan, hapus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

        copyDBEhealth();

        setConfig = new SetConfig(getApplicationContext() );
        idpuskes = (EditText) findViewById(R.id.idpuskes);
        namapuskes= (EditText) findViewById(R.id.namapuskes);
        simpan = (Button) findViewById(R.id.btnSimpan);


        HashMap<String, String> setting = setConfig.getDetail();
        idpuskes.setText(setting.get(setConfig.KEY_IDPUSKES));
        namapuskes.setText(setting.get(setConfig.KEY_NAMAPUSKES));

        if (setting.get(SetConfig.KEY_IDPUSKES) !=null){
            simpan.setText("UPDATE");
        }
        else{
            simpan.setText("SIMPAN");
        }

        simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setConfig.createSetConfig(
                idpuskes.getText().toString(),
                namapuskes.getText().toString());

                Toast.makeText(Main1Activity.this, "Data Berhasil Disimpan!", Toast.LENGTH_SHORT).show();
            }
        });

        //getHPCdata();
    }


    public void goToPin(View v){
        Intent activity = new Intent(this, Pin2Activity.class);
        startActivity(activity);
        finish();
    }

    public void copyDBEhealth(){

        DatabaseHelper mDBHelper = new DatabaseHelper(this);

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
        String SQL_CREATE_KARTU_TABLE =  "CREATE TABLE " + EhealthContract.KartuEntry.TABLE_NAME + " ("
                + EhealthContract.KartuEntry.COLUMN_HPCNUMBER + " TEXT NOT NULL, "
                + EhealthContract.KartuEntry.COLUMN_DOKTER + " TEXT NOT NULL, "
                + EhealthContract.KartuEntry.COLUMN_PDCNUMBER + "TEXT NOT NULL, "
                + EhealthContract.KartuEntry.COLUMN_NAMAPASIEN + "TEXT NOT NULL);";

        // Execute the SQL statement
        SQLiteDatabase mDb = mDBHelper.getWritableDatabase();
        mDb.execSQL(SQL_CREATE_KARTU_TABLE);
    }


}


