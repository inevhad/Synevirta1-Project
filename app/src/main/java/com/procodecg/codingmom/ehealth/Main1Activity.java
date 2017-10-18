package com.procodecg.codingmom.ehealth;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.procodecg.codingmom.ehealth.data.EhealthContract;
import com.procodecg.codingmom.ehealth.data.EhealthDbHelper;
import com.procodecg.codingmom.ehealth.main.MainActivity;
import com.procodecg.codingmom.ehealth.main.Pin2Activity;
import com.procodecg.codingmom.ehealth.main.SetConfig;

import java.util.HashMap;

public class Main1Activity extends AppCompatActivity {
    private SetConfig setConfig;
    private EditText idpuskes,namapuskes;
    private Button simpan, hapus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

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

        getHPCdata();
    }


    public void goToPin(View v){
        Intent activity = new Intent(this, Pin2Activity.class);
        startActivity(activity);
        finish();
    }

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
            EhealthDbHelper mDbHelper = new EhealthDbHelper(this);
            mDbHelper.deleteAll();
            // Gets the database in write mode
            SQLiteDatabase db = mDbHelper.getWritableDatabase();

            // Create a ContentValues object where column names are the keys,
            // and pet attributes from the editor are the values.
            ContentValues values = new ContentValues();
//            values.put(KartuEntry.COLUMN_HPC_NUMBER, HPCnumberString);
//            values.put(KartuEntry.COLUMN_PIN_HPC, PIN_HPC);
//            values.put(KartuEntry.COLUMN_NAMA_DOKTER, namaDokterString);

            // Insert a new row for pet in the database, returning the ID of that new row.
            long newRowId = db.insert(EhealthContract.KartuEntry.TABLE_NAME, null, values);

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

            AlertDialog.Builder mBuilder = new AlertDialog.Builder(Main1Activity.this);
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


