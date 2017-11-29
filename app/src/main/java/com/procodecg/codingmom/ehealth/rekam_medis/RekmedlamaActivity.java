package com.procodecg.codingmom.ehealth.rekam_medis;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.procodecg.codingmom.ehealth.data.EhealthContract;
import com.procodecg.codingmom.ehealth.data.EhealthDbHelper;
import com.procodecg.codingmom.ehealth.fragment.BottombarActivity;
import com.procodecg.codingmom.ehealth.R;
import com.procodecg.codingmom.ehealth.fragment.RecycleListAdapter;

/**
 * Created by macbookpro on 8/30/17.
 */

public class RekmedlamaActivity extends AppCompatActivity {

    private TextView txtTitle;
    private EhealthDbHelper mDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //MENGHILANGKAN TOOLBAR
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_rekmedlama);

        txtTitle = (TextView) findViewById(R.id.txt_title);
        txtTitle.setText("Rekam Medis");

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
        final TextView textIDPuskesmas = (TextView) findViewById(R.id.showIDPuskesmas);
        mDbHelper = new EhealthDbHelper(this);
        SQLiteDatabase db = mDbHelper.getReadableDatabase();
        String[] projection = {
                EhealthContract.RekamMedisEntry._ID,
                EhealthContract.RekamMedisEntry.COLUMN_ID_PUSKESMAS
        };

        String whereClause = EhealthContract.RekamMedisEntry._ID + " = ? ";
        String[] whereArgs = new String[]{RecycleListAdapter.getCurrentPosition()};

        Cursor cursor = db.query(EhealthContract.RekamMedisEntry.TABLE_NAME,projection, whereClause,whereArgs,null,null,null);

        try{
            int idColumnIndex = cursor.getColumnIndex(EhealthContract.RekamMedisEntry._ID);
            int idPuskesmasIndex = cursor.getColumnIndex(EhealthContract.RekamMedisEntry.COLUMN_ID_PUSKESMAS);

            while (cursor.moveToNext()){
                int currentID = cursor.getInt(idColumnIndex);
                String currentName = cursor.getString(idPuskesmasIndex);
                textIDPuskesmas.setText(currentName);
            }
        } finally {
            cursor.close();
        }

        //TextView displayView = (TextView) findViewById(R.id.text_view_pet);
        Toast.makeText(this, RecycleListAdapter.getCurrentPosition(), Toast.LENGTH_SHORT).show();
        //Toast.makeText(this, getIntent().getStringExtra("dokter"), Toast.LENGTH_SHORT).show();
    }

}