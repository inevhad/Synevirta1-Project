package com.procodecg.codingmom.ehealth.main;

import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.procodecg.codingmom.ehealth.R;
import com.procodecg.codingmom.ehealth.data.DatabaseHelper;
import com.procodecg.codingmom.ehealth.data.EhealthContract;

import java.io.IOException;

public class MainVer2Activity extends AppCompatActivity {


    private SetConfigVer2 setConfig;
    private EditText idPuskesmas,namaPuskesmas;
    private Button simpan, hapus;
    private TextView txtIdPuskesmas;
    private TextView txtNamaPuskesmas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_ver2);

        copyDBEhealth();


        txtIdPuskesmas = (TextView) findViewById(R.id.txt_idPuskesmas);
        txtIdPuskesmas.setText("12121121");

        txtNamaPuskesmas = (TextView) findViewById(R.id.txt_namaPuskesmas);
        txtNamaPuskesmas.setText("Sarijadi");

        ImageButton settingButton = (ImageButton) findViewById(R.id.btnSetting);
        settingButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainVer2Activity.this);
                View mView = getLayoutInflater().inflate(R.layout.dialog_puskesmas,null);

                setConfig = new SetConfigVer2(getApplicationContext() );
                idPuskesmas = (EditText) findViewById(R.id.idPuskesmas);
                namaPuskesmas= (EditText) findViewById(R.id.namaPuskesmas);
                simpan = (Button) mView.findViewById(R.id.btnSimpan);

//                HashMap<String, String> setTexting = setConfig.getDetail();
//                idPuskesmas.setText(setTexting.get(setConfig.KEY_IDPUSKES));
//                namaPuskesmas.setText(setTexting.get(setConfig.KEY_NAMAPUSKES));

                simpan.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view){
//                        setConfig.createSetConfig(
//                                idPuskesmas.getText().toString(),
//                                namaPuskesmas.getText().toString()
//                        );

                        Toast.makeText(MainVer2Activity.this, "Data berhasil disimpan",Toast.LENGTH_SHORT).show();

//                        finish();
//                        return;
                    }
                });

                mBuilder.setView(mView);
                AlertDialog dialog = mBuilder.create();
                dialog.show();

            }
        });

//        HashMap<String, String> setTexting = setConfig.getDetail();
//        idPuskesmas.setText(setTexting.get(setConfig.KEY_IDPUSKES));
//        namaPuskesmas.setText(setTexting.get(setConfig.KEY_NAMAPUSKES));

//        if (setting.get(SetConfig.KEY_IDPUSKES) !=null){
//            simpan.setText("UPDATE");
//        }
//        else{
//            simpan.setText("SIMPAN");
//        }
//
//        simpan.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                setConfig.createSetConfig(
//                idPuskesmas.getText().toString(),
//                namaPuskesmas.getText().toString());
//
//                Toast.makeText(MainVer2Activity.this, "Data Berhasil Disimpan!", Toast.LENGTH_SHORT).show();
//            }
//        });

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


