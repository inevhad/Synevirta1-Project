package com.procodecg.codingmom.ehealth;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * Created by macbookpro on 9/4/17.
 */

public class RekmedbaruActivity extends AppCompatActivity {

    private TextView txtTitle;

//    LayoutInflater inflater = null;
//    EditText edit_text;
//    Button btn_clear;
//    public RekmedbaruActivity(Context context, AttributeSet attrs, int defStyle)
//    {
//        super(context, attrs, defStyle);
//// TODO Auto-generated constructor stub
//        initViews();
//    }
//    public RekmedbaruActivity(Context context, AttributeSet attrs)
//    {
//        super(context, attrs);
//// TODO Auto-generated constructor stub
//        initViews();
//    }
//    public RekmedbaruActivity(Context context)
//    {
//        super(context);
//// TODO Auto-generated constructor stub
//        initViews();
//    }
//    void initViews()
//    {
//        inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        inflater.inflate(R.layout.activity_rekmedbaru, this, true);
//        edit_text = (EditText) findViewById(R.id.namaPuskesmas);
//        btn_clear = (Button) findViewById(R.id.clearable_button_clear);
//        btn_clear.setVisibility(RelativeLayout.INVISIBLE);
//        clearText();
//        showHideClearButton();
//    }
//    void clearText()
//    {
//        btn_clear.setOnClickListener(new View.OnClickListener()
//        {
//            @Override
//            public void onClick(View v)
//            {
//// TODO Auto-generated method stub
//                edit_text.setText("");
//            }
//        });
//    }
//    void showHideClearButton()
//    {
//        edit_text.addTextChangedListener(new TextWatcher()
//        {
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count)
//            {
//// TODO Auto-generated method stub
//                if (s.length() > 0)
//                    btn_clear.setVisibility(RelativeLayout.VISIBLE);
//                else
//                    btn_clear.setVisibility(RelativeLayout.INVISIBLE);
//            }
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after)
//            {
//// TODO Auto-generated method stub
//            }
//            @Override
//            public void afterTextChanged(Editable s)
//            {
//// TODO Auto-generated method stub
//            }
//        });
//    }
//    public Editable getText()
//    {
//        Editable text = edit_text.getText();
//        return text;
//    }

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

        toolbar.setNavigationIcon(R.drawable.xgreen);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),BottombarActivity.class));
            }
        });

        //spinner skala nyeri
        Spinner spinnerNyeri = (Spinner) findViewById(R.id.nyeri_spinner);
        ArrayAdapter<CharSequence> adapterNyeri = ArrayAdapter.createFromResource(this,
                R.array.skala_nyeri, android.R.layout.simple_spinner_item);
        adapterNyeri.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerNyeri.setAdapter(adapterNyeri);

        //spinner kesadaran
        Spinner spinnerKesadaran = (Spinner) findViewById(R.id.kesadaran_spinner);
        ArrayAdapter<CharSequence> adapterKesadaran = ArrayAdapter.createFromResource(this,
                R.array.kesadaran, android.R.layout.simple_spinner_item);
        adapterKesadaran.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerKesadaran.setAdapter(adapterKesadaran);

        //spinner icd
        Spinner spinnerIcd = (Spinner) findViewById(R.id.icd_spinner);
        ArrayAdapter<CharSequence> adapterIcd = ArrayAdapter.createFromResource(this,
                R.array.icd_status, android.R.layout.simple_spinner_item);
        adapterIcd.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerIcd.setAdapter(adapterIcd);



    //PIN SALAH
    Button mShowDialog = (Button) findViewById(R.id.btnShowDialog);
        mShowDialog.setOnClickListener(new View.OnClickListener() {
    @Override
        public void onClick(View view) {
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(RekmedbaruActivity.this);
        mBuilder.setIcon(R.drawable.logo2);
        mBuilder.setTitle("Data yang Anda masukkan tidak dapat dirubah lagi");
//        mBuilder.setMessage("Silahkan coba lagi");
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
        }
}