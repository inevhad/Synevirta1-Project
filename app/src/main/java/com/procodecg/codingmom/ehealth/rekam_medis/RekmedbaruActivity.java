package com.procodecg.codingmom.ehealth.rekam_medis;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.procodecg.codingmom.ehealth.R;
import com.procodecg.codingmom.ehealth.data.EhealthDbHelper;
import com.procodecg.codingmom.ehealth.data.EhealthContract.RekamMedisEntry;
import com.procodecg.codingmom.ehealth.fragment.BottombarActivity;
import com.procodecg.codingmom.ehealth.utils.NothingSelectedSpinnerAdapter;

import java.util.List;

import static android.support.constraint.R.id.parent;


/**
 * Created by macbookpro on 9/4/17.
 */

public class RekmedbaruActivity extends AppCompatActivity {

    private TextView txtTitle;
    private int mPoli = RekamMedisEntry.POLI_UMUM;
    private int mKesadaran = RekamMedisEntry.KESADARAN_COMPOSMENTIS;
    private int mStatusLabRadio = RekamMedisEntry.LABRADIO_DILAYANIPENUH;
    private int mStatusResep = RekamMedisEntry.RESEP_DILAYANI_PENUH;
    private RadioGroup radioGroup;
    private int mRepetisiResep = RekamMedisEntry.RESEP_REPETISI_TIDAK;
    private int mAdVitam = RekamMedisEntry.VITAM_ADBONAM;
    private int mAdFunctionam = RekamMedisEntry.FUNCTIONAM_ADBONAM;
    private int mAdSanationam = RekamMedisEntry.SANATIONAM_ADBONAM;

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

        ScrollView scrollView = (ScrollView) findViewById(R.id.scrollView);
        scrollView.setScrollbarFadingEnabled(false);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationIcon(R.drawable.ic_xclose);
//        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
//        View logo = getLayoutInflater().inflate(R.layout.activity_rekmedbaru, null);
//        mToolbar.addView(logo, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        toolbar.setContentInsetsAbsolute(0,0);
//        getSupportActionBar().setDisplayShowTitleEnabled(false);
//        TextView txt = (TextView) findViewById(R.id.txt_title);
//        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(txt.getLayoutParams());
//        lp.setMargins(0, 0, 0, 0);
//        txt.setLayoutParams(lp);
//        toolbar.setTitleMarginStart(0);
//        Toolbar.LayoutParams layoutParams = (Toolbar.LayoutParams) toolbar.getLayoutParams();
//        layoutParams.setMargins(0, 0, 0, 0);
//        toolbar.setLayoutParams(layoutParams);
//        getResources().getDimension(R.dimen.toolbar_right);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),BottombarActivity.class));
            }
        });
        EhealthDbHelper db = new EhealthDbHelper(this);
        db.openDB();
        //db.createTableKartu();
        db.createTableRekMed();
        setupSpinner();
        setupAutoComplete();



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
                simpanData();
            }
        });
        AlertDialog alertDialog = mBuilder.create();
        alertDialog.show();
        }
        });




//menampilkan nama puskesmas
/*
        HashMap<String, String> setting = setconfig.getDetail();
        idpuskes.setText(setting.get(SetConfig.KEY_IDPUSKES));
        namapuskes.setText(setting.get(SetConfig.KEY_NAMAPUSKES));
*/
        }

        private void setupSpinner(){

            //spinner poli
            Spinner spinnerPoli = (Spinner) findViewById(R.id.poli_spinner);
            ArrayAdapter<CharSequence> adapterPoli = ArrayAdapter.createFromResource(this,
                    R.array.poli, android.R.layout.simple_spinner_item);
            adapterPoli.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerPoli.setPrompt("Pilih poli tujuan");
            spinnerPoli.setAdapter(new NothingSelectedSpinnerAdapter(
                    adapterPoli,
                    R.layout.contact_spinner_row_nothing_selected,
                    // R.layout.contact_spinner_nothing_selected_dropdown, // Optional
                    this));
            spinnerPoli.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    String selection = (String) parent.getItemAtPosition(position);
                    if (!TextUtils.isEmpty(selection)) {
                        if (selection.equals("Gigi")) {
                            mPoli = RekamMedisEntry.POLI_GIGI;
                        } else {
                            mPoli = RekamMedisEntry.POLI_UMUM;
                        }
                    }
                }
                // Because AdapterView is an abstract class, onNothingSelected must be defined
                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                    mPoli = RekamMedisEntry.POLI_UMUM;
                }
            });


            //spinner kesadaran
            Spinner spinnerKesadaran = (Spinner) findViewById(R.id.kesadaran_spinner);
            ArrayAdapter<CharSequence> adapterKesadaran = ArrayAdapter.createFromResource(this,
                    R.array.kesadaran, android.R.layout.simple_spinner_item);
            adapterKesadaran.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerKesadaran.setPrompt("Pilih tingkat kesadaran");
            spinnerKesadaran.setAdapter(new NothingSelectedSpinnerAdapter(
                    adapterKesadaran,
                    R.layout.contact_spinner_row_nothing_selected,
                    // R.layout.contact_spinner_nothing_selected_dropdown, // Optional
                    this));
            spinnerKesadaran.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    String selection = (String) parent.getItemAtPosition(position);
                    if (!TextUtils.isEmpty(selection)) {
                        if (selection.equals("Apatis")) {
                            mKesadaran = RekamMedisEntry.KESADARAN_APATIS;
                        } else if (selection.equals("Delirium")){
                            mKesadaran = RekamMedisEntry.KESADARAN_DELIRIUM;
                        } else if (selection.equals("Somnolen")){
                            mKesadaran = RekamMedisEntry.KESADARAN_SOMNOLEN;
                        } else if (selection.equals("Sopor")){
                            mKesadaran = RekamMedisEntry.KESADARAN_SOPOR;
                        } else if (selection.equals("Semi-coma")){
                            mKesadaran = RekamMedisEntry.KESADARAN_SEMICOMA;
                        } else if (selection.equalsIgnoreCase("Coma")){
                            mKesadaran = RekamMedisEntry.KESADARAN_COMA;
                        } else {
                            mPoli = RekamMedisEntry.KESADARAN_COMPOSMENTIS;
                        }
                    }
                }
                // Because AdapterView is an abstract class, onNothingSelected must be defined
                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                    mKesadaran = RekamMedisEntry.KESADARAN_COMPOSMENTIS;
                }
            });

            //spinner status Laboratorium Radiologi
            Spinner spinnerLabRadio = (Spinner) findViewById(R.id.statusLabRadio);
            ArrayAdapter<CharSequence> adapterLabRadio = ArrayAdapter.createFromResource(this,
                    R.array.status_labradio, android.R.layout.simple_spinner_item);
            adapterLabRadio.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerLabRadio.setPrompt("Pilih status Laboratorium Radiologi");
            spinnerLabRadio.setAdapter(new NothingSelectedSpinnerAdapter(
                    adapterLabRadio,
                    R.layout.contact_spinner_row_nothing_selected,
                    // R.layout.contact_spinner_nothing_selected_dropdown, // Optional
                    this));
            spinnerLabRadio.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    String selection = (String) parent.getItemAtPosition(position);
                    if (!TextUtils.isEmpty(selection)) {
                        if (selection.equals("Dilayani sebagian")) {
                            mStatusLabRadio = RekamMedisEntry.LABRADIO_DILAYANISEBAGIAN;
                        } else if (selection.equals("Tidak dilayani sama sekali")){
                            mStatusLabRadio = RekamMedisEntry.LABRADIO_TIDAKDILAYANI;
                        } else {
                            mStatusLabRadio = RekamMedisEntry.LABRADIO_DILAYANIPENUH;
                        }
                    }
                }
                // Because AdapterView is an abstract class, onNothingSelected must be defined
                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                    mStatusLabRadio = RekamMedisEntry.LABRADIO_DILAYANIPENUH;
                }
            });

            //spinner status resep
            Spinner spinnerResep = (Spinner) findViewById(R.id.statusResep);
            ArrayAdapter<CharSequence> adapterResep = ArrayAdapter.createFromResource(this,
                    R.array.status_resep, android.R.layout.simple_spinner_item);
            adapterResep.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerResep.setPrompt("Pilih status resep");
            spinnerResep.setAdapter(new NothingSelectedSpinnerAdapter(
                    adapterResep,
                    R.layout.contact_spinner_row_nothing_selected,
                    // R.layout.contact_spinner_nothing_selected_dropdown, // Optional
                    this));
            spinnerResep.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    String selection = (String) parent.getItemAtPosition(position);
                    if (!TextUtils.isEmpty(selection)) {
                        if (selection.equals("Dilayani sebagian")) {
                            mStatusResep = RekamMedisEntry.RESEP_DILAYANI_SEBAGIAN;
                        } else if (selection.equals("Dilayani ada penggantian")){
                            mStatusResep = RekamMedisEntry.RESEP_DILAYANI_PENGGANTIAN;
                        } else if (selection.equals("Dilayani sebagian dan ada penggantian")){
                            mStatusResep = RekamMedisEntry.RESEP_DILAYANI_SEBAGIAN_PENGGANTIAN;
                        } else if (selection.equals("Tidak dilayani sama sekali")){
                            mStatusResep = RekamMedisEntry.RESEP_TIDAK_DILAYANI;
                        } else {
                            mStatusResep = RekamMedisEntry.RESEP_DILAYANI_PENUH;
                        }
                    }
                }
                // Because AdapterView is an abstract class, onNothingSelected must be defined
                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                    mStatusResep = RekamMedisEntry.RESEP_DILAYANI_PENUH;
                }
            });

            //Radio button repetisi resep
            radioGroup = (RadioGroup) findViewById(R.id.repetisiResep);
            radioGroup.clearCheck();

            radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    RadioButton rb = (RadioButton) group.findViewById(checkedId);
                    if (null != rb && checkedId > -1) {
                        if (checkedId != 0) {
                            mRepetisiResep = RekamMedisEntry.RESEP_REPETISI_YA;
                        } else {
                            mRepetisiResep = RekamMedisEntry.RESEP_REPETISI_TIDAK;
                        }
                    }

                }
            });


            //spinner status prognosis ad vitam
            Spinner spinnerAdVitam = (Spinner) findViewById(R.id.adVitam);
            ArrayAdapter<CharSequence> adapterAdVitam = ArrayAdapter.createFromResource(this,
                    R.array.ad_vitam, android.R.layout.simple_spinner_item);
            adapterAdVitam.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerAdVitam.setPrompt("Pilih");
            spinnerAdVitam.setAdapter(new NothingSelectedSpinnerAdapter(
                    adapterAdVitam,
                    R.layout.contact_spinner_row_nothing_selected,
                    // R.layout.contact_spinner_nothing_selected_dropdown, // Optional
                    this));
            spinnerAdVitam.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    String selection = (String) parent.getItemAtPosition(position);
                    if (!TextUtils.isEmpty(selection)) {
                        if (selection.equals("Dubia ad bonam")) {
                            mAdVitam = RekamMedisEntry.VITAM_DUBIAADBONAM;
                        } else if (selection.equals("Dubia ad malam")){
                            mAdVitam = RekamMedisEntry.VITAM_DUBIAADMALAM;
                        } else if (selection.equals("Ad malam")){
                            mAdVitam = RekamMedisEntry.VITAM_ADMALAM;
                        } else {
                            mAdVitam = RekamMedisEntry.VITAM_ADBONAM;
                        }
                    }
                }
                // Because AdapterView is an abstract class, onNothingSelected must be defined
                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                    mAdVitam = RekamMedisEntry.VITAM_ADBONAM;
                }
            });


            //spinner status prognosis ad functionam
            Spinner spinnerAdFunctionam = (Spinner) findViewById(R.id.adFunctionam);
            ArrayAdapter<CharSequence> adapterAdFunctionam = ArrayAdapter.createFromResource(this,
                    R.array.ad_functionam, android.R.layout.simple_spinner_item);
            adapterAdFunctionam.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerAdFunctionam.setPrompt("Pilih");
            spinnerAdFunctionam.setAdapter(new NothingSelectedSpinnerAdapter(
                    adapterAdFunctionam,
                    R.layout.contact_spinner_row_nothing_selected,
                    // R.layout.contact_spinner_nothing_selected_dropdown, // Optional
                    this));
            spinnerAdFunctionam.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    String selection = (String) parent.getItemAtPosition(position);
                    if (!TextUtils.isEmpty(selection)) {
                        if (selection.equals("Dubia ad bonam")) {
                            mAdFunctionam = RekamMedisEntry.FUNCTIONAM_DUBIAADBONAM;
                        } else if (selection.equals("Dubia ad malam")){
                            mAdFunctionam = RekamMedisEntry.FUNCTIONAM_DUBIAADMALAM;
                        } else if (selection.equals("Ad malam")){
                            mAdFunctionam = RekamMedisEntry.FUNCTIONAM_ADMALAM;
                        } else {
                            mAdVitam = RekamMedisEntry.FUNCTIONAM_ADBONAM;
                        }
                    }
                }
                // Because AdapterView is an abstract class, onNothingSelected must be defined
                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                    mAdFunctionam = RekamMedisEntry.FUNCTIONAM_ADBONAM;
                }
            });
            //spinner status prognosis ad sanationam
            Spinner spinnerAdSanationam = (Spinner) findViewById(R.id.adSanationam);
            ArrayAdapter<CharSequence> adapterAdSanationam = ArrayAdapter.createFromResource(this,
                    R.array.ad_sanationam, android.R.layout.simple_spinner_item);
            adapterAdSanationam.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerAdSanationam.setPrompt("Pilih");
            spinnerAdSanationam.setAdapter(new NothingSelectedSpinnerAdapter(
                    adapterAdSanationam,
                    R.layout.contact_spinner_row_nothing_selected,
                    // R.layout.contact_spinner_nothing_selected_dropdown, // Optional
                    this));
            spinnerAdSanationam.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    String selection = (String) parent.getItemAtPosition(position);
                    if (!TextUtils.isEmpty(selection)) {
                        if (selection.equals("Dubia ad bonam")) {
                            mAdSanationam = RekamMedisEntry.SANATIONAM_DUBIAADBONAM;
                        } else if (selection.equals("Dubia ad malam")){
                            mAdSanationam = RekamMedisEntry.SANATIONAM_DUBIAADMALAM;
                        } else if (selection.equals("Ad malam")){
                            mAdSanationam = RekamMedisEntry.SANATIONAM_ADMALAM;
                        } else {
                            mAdSanationam = RekamMedisEntry.SANATIONAM_ADBONAM;
                        }
                    }
                }
                // Because AdapterView is an abstract class, onNothingSelected must be defined
                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                    mAdSanationam = RekamMedisEntry.VITAM_ADBONAM;
                }
            });
        }

        private void setupAutoComplete(){
            AutoCompleteTextView textView = (AutoCompleteTextView) findViewById(R.id.statusDiagnosis);
            EhealthDbHelper dbHelper = new EhealthDbHelper(getApplicationContext());
            dbHelper.openDB();
            //String pencarian = getIntent().getStringExtra("hasil");
            String[] diagnosa = dbHelper.getAllDiagnosa();
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_item, diagnosa);
            textView.setAdapter(adapter);
            dbHelper.closeDB();
        }

        private void simpanData(){
            // DatabaseHelper dbHelper = new DatabaseHelper(getApplicationContext());
            // membuat tabel rekam medis
            // dbHelper.createTableRekMed();

            // Read from input fields
            // Use trim to eliminate leading or trailing white space
            //String nameString = mNameEditText.getText().toString().trim();
            //String breedString = mBreedEditText.getText().toString().trim();
            //String weightString = mWeightEditText.getText().toString().trim();
            //int weight = Integer.parseInt(weightString);
        }

}