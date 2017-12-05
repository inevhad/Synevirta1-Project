package com.procodecg.codingmom.ehealth;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.procodecg.codingmom.ehealth.main.MainVer2Activity;

public class Edit extends AppCompatActivity {

    private EditText idPuskesmas;
    private EditText namaPuskesmas;
    private SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        prefs = getSharedPreferences("DATAPUSKES", MODE_PRIVATE);
        String idpuskes= prefs.getString("IDPUSKES","");
        String namapuskes= prefs.getString("NAMAPUSKES","");

        idPuskesmas=(EditText)findViewById(R.id.inputId);
        namaPuskesmas=(EditText)findViewById(R.id.inputNama);

    }
    
    public void SimpanData(View view){
        //input data
        String idpuskes = idPuskesmas.getText().toString();
        String namapuskes = namaPuskesmas.getText().toString();

        //simpan data
        SharedPreferences.Editor editor =prefs.edit();
        editor.putString("IDPUSKES",idpuskes);
        editor.putString("NAMAPUSKES",namapuskes);
        editor.apply();

        //kembali ke mainVer2
        startActivity(new Intent(getApplicationContext(), MainVer2Activity.class));

    }


}


