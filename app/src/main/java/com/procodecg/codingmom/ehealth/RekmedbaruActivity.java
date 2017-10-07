package com.procodecg.codingmom.ehealth;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.procodecg.codingmom.ehealth.data.EhealthDbHelper;

/**
 * Created by macbookpro on 9/4/17.
 */

public class RekmedbaruActivity extends AppCompatActivity {

    private TextView txtTitle;
    AutoCompleteTextView textView;
    EhealthDbHelper dbHelper;

//    aktivasi tombol x-clear


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //MENGHILANGKAN TOOLBAR
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_rekmedbaru);

        txtTitle = (TextView) findViewById(R.id.txt_title);
        txtTitle.setText("Rekam Medis Baru");

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

        //spinner kesadaran
        Spinner spinnerKesadaran = (Spinner) findViewById(R.id.kesadaran_spinner);
        ArrayAdapter<CharSequence> adapterKesadaran = ArrayAdapter.createFromResource(this,
                R.array.kesadaran, android.R.layout.simple_spinner_item);
        adapterKesadaran.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerKesadaran.setAdapter(adapterKesadaran);

        //spinner status Laboratorium Radiologi
        Spinner spinnerLabRadio = (Spinner) findViewById(R.id.statusLabRadio);
        ArrayAdapter<CharSequence> adapterLabRadio = ArrayAdapter.createFromResource(this,
                R.array.status_labradio, android.R.layout.simple_spinner_item);
        adapterLabRadio.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerLabRadio.setAdapter(adapterLabRadio);

        //spinner status resep
        Spinner spinnerResep = (Spinner) findViewById(R.id.statusResep);
        ArrayAdapter<CharSequence> adapterResep = ArrayAdapter.createFromResource(this,
                R.array.status_resep, android.R.layout.simple_spinner_item);
        adapterResep.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerResep.setAdapter(adapterResep);

        //spinner status prognosis ad vitam
        Spinner spinnerAdVitam = (Spinner) findViewById(R.id.adVitam);
        ArrayAdapter<CharSequence> adapterAdVitam = ArrayAdapter.createFromResource(this,
                R.array.ad_vitam, android.R.layout.simple_spinner_item);
        adapterAdVitam.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerAdVitam.setAdapter(adapterAdVitam);

        //spinner status prognosis ad functionam
        Spinner spinnerAdFunctionam = (Spinner) findViewById(R.id.adFunctionam);
        ArrayAdapter<CharSequence> adapterAdFunctionam = ArrayAdapter.createFromResource(this,
                R.array.ad_functionam, android.R.layout.simple_spinner_item);
        adapterAdFunctionam.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerAdFunctionam.setAdapter(adapterAdFunctionam);

        //spinner status prognosis ad functionam
        Spinner spinnerAdSanationam = (Spinner) findViewById(R.id.adSanationam);
        ArrayAdapter<CharSequence> adapterAdSanationam = ArrayAdapter.createFromResource(this,
                R.array.ad_sanationam, android.R.layout.simple_spinner_item);
        adapterAdSanationam.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerAdSanationam.setAdapter(adapterAdSanationam);

    //BUTTON SAVE
    Button mShowDialog = (Button) findViewById(R.id.btnShowDialog);
        mShowDialog.setOnClickListener(new View.OnClickListener() {
    @Override
        public void onClick(View view) {
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(RekmedbaruActivity.this);
        mBuilder.setIcon(R.drawable.logo2);
        mBuilder.setTitle("Data yang Anda masukkan tidak dapat dirubah lagi");
        mBuilder.setMessage("Apakah Anda akan menyimpan data sekarang?");
        mBuilder.setCancelable(false);
        mBuilder.setPositiveButton("Tidak", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        mBuilder.setNegativeButton("Ya", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        AlertDialog alertDialog = mBuilder.create();
        alertDialog.show();
        }
        });

        // Autocomplete
        textView = (AutoCompleteTextView) findViewById(R.id.statusDiagnosis);
        dbHelper = new EhealthDbHelper(getApplicationContext());
        dbHelper.openDB();
        String pencarian = getIntent().getStringExtra("hasil");
        String[] diagnosa = dbHelper.getAllDiagnosa();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_item, diagnosa);
        textView.setAdapter(adapter);

        }
}