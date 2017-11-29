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
        final TextView textPoli = (TextView) findViewById(R.id.showPoli);
        final TextView textPemberiRujukan = (TextView) findViewById(R.id.showPemberiRujukan);
        final TextView textSystole = (TextView) findViewById(R.id.showSystole);
        final TextView textDiastole = (TextView) findViewById(R.id.showDiastole);
        final TextView textSuhu = (TextView) findViewById(R.id.showSuhu);
        final TextView textNadi = (TextView) findViewById(R.id.showNadi);
        final TextView textRespirasi = (TextView) findViewById(R.id.showRespirasi);
        final TextView textKeluhanUtama = (TextView) findViewById(R.id.showKeluhan);
        final TextView textRiwayatPenyakitSkr = (TextView) findViewById(R.id.showRiwayatPenyakitSkr);
        final TextView textRiwayatPenyakitDulu= (TextView) findViewById(R.id.showRiwayatPenyakitDulu);
        final TextView textRiwayatPenyakitKel= (TextView) findViewById(R.id.showRiwayatPenyakitKel);
        final TextView textTinggi = (TextView) findViewById(R.id.showTinggi);
        final TextView textBerat= (TextView) findViewById(R.id.showBerat);
        final TextView textKesadaran= (TextView) findViewById(R.id.showKesadaran);
        final TextView textKepala = (TextView) findViewById(R.id.showKepala);
        final TextView textThorax= (TextView) findViewById(R.id.showThorax);
        final TextView textAbdomen= (TextView) findViewById(R.id.showAbdomen);
        final TextView textGenitalia = (TextView) findViewById(R.id.showGenitalia);
        final TextView textExtremitas= (TextView) findViewById(R.id.showExtremitas);
        final TextView textKulit= (TextView) findViewById(R.id.showKulit);


        mDbHelper = new EhealthDbHelper(this);
        SQLiteDatabase db = mDbHelper.getReadableDatabase();
        String[] projection = {
                EhealthContract.RekamMedisEntry._ID,
                EhealthContract.RekamMedisEntry.COLUMN_ID_PUSKESMAS,
                EhealthContract.RekamMedisEntry.COLUMN_POLI,
                EhealthContract.RekamMedisEntry.COLUMN_RUJUKAN,
                EhealthContract.RekamMedisEntry.COLUMN_SYSTOLE,
                EhealthContract.RekamMedisEntry.COLUMN_DIASTOLE,
                EhealthContract.RekamMedisEntry.COLUMN_SUHU,
                EhealthContract.RekamMedisEntry.COLUMN_NADI,
                EhealthContract.RekamMedisEntry.COLUMN_RESPIRASI,
                EhealthContract.RekamMedisEntry.COLUMN_KELUHANUTAMA,
                EhealthContract.RekamMedisEntry.COLUMN_PENYAKIT_SEKARANG,
                EhealthContract.RekamMedisEntry.COLUMN_PENYAKIT_DULU,
                EhealthContract.RekamMedisEntry.COLUMN_PENYAKIT_KEL,
                EhealthContract.RekamMedisEntry.COLUMN_TINGGI,
                EhealthContract.RekamMedisEntry.COLUMN_BERAT,
                EhealthContract.RekamMedisEntry.COLUMN_KESADARAN,
                EhealthContract.RekamMedisEntry.COLUMN_KEPALA,
                EhealthContract.RekamMedisEntry.COLUMN_THORAX,
                EhealthContract.RekamMedisEntry.COLUMN_ABDOMEN,
                EhealthContract.RekamMedisEntry.COLUMN_GENITALIA,
                EhealthContract.RekamMedisEntry.COLUMN_EXTREMITAS,
                EhealthContract.RekamMedisEntry.COLUMN_KULIT

        };

        String whereClause = EhealthContract.RekamMedisEntry._ID + " = ? ";
        String[] whereArgs = new String[]{RecycleListAdapter.getCurrentPosition()};

        Cursor cursor = db.query(EhealthContract.RekamMedisEntry.TABLE_NAME,projection, whereClause,whereArgs,null,null,null);

        try{
            int idColumnIndex = cursor.getColumnIndex(EhealthContract.RekamMedisEntry._ID);
            int idPuskesmasIndex = cursor.getColumnIndex(EhealthContract.RekamMedisEntry.COLUMN_ID_PUSKESMAS);
            int idPoliIndex = cursor.getColumnIndex(EhealthContract.RekamMedisEntry.COLUMN_POLI);
            int idRujukanIndex = cursor.getColumnIndex(EhealthContract.RekamMedisEntry.COLUMN_RUJUKAN);
            int idSystoleIndex = cursor.getColumnIndex(EhealthContract.RekamMedisEntry.COLUMN_SYSTOLE);
            int idDiastoleIndex = cursor.getColumnIndex(EhealthContract.RekamMedisEntry.COLUMN_DIASTOLE);
            int idSuhuIndex = cursor.getColumnIndex(EhealthContract.RekamMedisEntry.COLUMN_SUHU);
            int idNadiIndex = cursor.getColumnIndex(EhealthContract.RekamMedisEntry.COLUMN_NADI);
            int idRespirasiIndex = cursor.getColumnIndex(EhealthContract.RekamMedisEntry.COLUMN_RESPIRASI);
            int idKeluhanIndex = cursor.getColumnIndex(EhealthContract.RekamMedisEntry.COLUMN_KELUHANUTAMA);
            int idPenyakitSkrIndex = cursor.getColumnIndex(EhealthContract.RekamMedisEntry.COLUMN_PENYAKIT_SEKARANG);
            int idPenyakitDuluIndex = cursor.getColumnIndex(EhealthContract.RekamMedisEntry.COLUMN_PENYAKIT_DULU);
            int idPenyakitKelIndex = cursor.getColumnIndex(EhealthContract.RekamMedisEntry.COLUMN_PENYAKIT_KEL);
            int idTinggiIndex = cursor.getColumnIndex(EhealthContract.RekamMedisEntry.COLUMN_TINGGI);
            int idBeratIndex = cursor.getColumnIndex(EhealthContract.RekamMedisEntry.COLUMN_BERAT);
            int idKesadaranIndex = cursor.getColumnIndex(EhealthContract.RekamMedisEntry.COLUMN_KESADARAN);
            int idKepalaIndex = cursor.getColumnIndex(EhealthContract.RekamMedisEntry.COLUMN_KEPALA);
            int idThoraxIndex = cursor.getColumnIndex(EhealthContract.RekamMedisEntry.COLUMN_THORAX);
            int idAbdomenIndex = cursor.getColumnIndex(EhealthContract.RekamMedisEntry.COLUMN_ABDOMEN);
            int idGenitaliaIndex = cursor.getColumnIndex(EhealthContract.RekamMedisEntry.COLUMN_GENITALIA);
            int idExtremitasIndex = cursor.getColumnIndex(EhealthContract.RekamMedisEntry.COLUMN_EXTREMITAS);
            int idKulitIndex = cursor.getColumnIndex(EhealthContract.RekamMedisEntry.COLUMN_KULIT);



            while (cursor.moveToNext()){
                int currentID = cursor.getInt(idColumnIndex);

                String currentName = cursor.getString(idPuskesmasIndex);
                textIDPuskesmas.setText(currentName);

                int currentPoli = cursor.getInt(idPoliIndex);
                textPoli.setText(getPoliString(currentPoli));

                String currentRujukan = cursor.getString(idRujukanIndex);
                textPemberiRujukan.setText(currentRujukan);

                String currentSystole = cursor.getString(idSystoleIndex);
                textSystole.setText(currentSystole);

                String currentDiastole = cursor.getString(idDiastoleIndex);
                textDiastole.setText(currentDiastole);

                String currentSuhu = cursor.getString(idSuhuIndex);
                textSuhu.setText(currentSuhu);

                String currentNadi = cursor.getString(idNadiIndex);
                textNadi.setText(currentNadi);

                String currentRespirasi = cursor.getString(idRespirasiIndex);
                textRespirasi.setText(currentRespirasi);

                String currentKeluhan = cursor.getString(idKeluhanIndex);
                textKeluhanUtama.setText(currentKeluhan);

                String currentPenyakitSkr = cursor.getString(idPenyakitSkrIndex);
                textRiwayatPenyakitSkr.setText(currentPenyakitSkr);

                String currentPenyakitDulu = cursor.getString(idPenyakitDuluIndex);
                textRiwayatPenyakitDulu.setText(currentPenyakitDulu);

                String currentPenyakitKel = cursor.getString(idPenyakitKelIndex);
                textRiwayatPenyakitKel.setText(currentPenyakitKel);

                String currentTinggi = cursor.getString(idTinggiIndex);
                textTinggi.setText(currentTinggi);

                String currentBerat = cursor.getString(idBeratIndex);
                textBerat.setText(currentBerat);

                int currentKesadaran = cursor.getInt(idKesadaranIndex);
                textKesadaran.setText(getKesadaranString(currentKesadaran));

                String currentKepala = cursor.getString(idKepalaIndex);
                textKepala.setText(currentKepala);

                String currentThorax = cursor.getString(idThoraxIndex);
                textThorax.setText(currentThorax);

                String currentAbdomen = cursor.getString(idAbdomenIndex);
                textAbdomen.setText(currentAbdomen);

                String currentGenitalia = cursor.getString(idGenitaliaIndex);
                textGenitalia.setText(currentGenitalia);

                String currentExtremitas = cursor.getString(idExtremitasIndex);
                textExtremitas.setText(currentExtremitas);

                String currentKulit = cursor.getString(idKulitIndex);
                textKulit.setText(currentKulit);


            }
        } finally {
            cursor.close();
        }

        //TextView displayView = (TextView) findViewById(R.id.text_view_pet);
        Toast.makeText(this, RecycleListAdapter.getCurrentPosition(), Toast.LENGTH_SHORT).show();
        //Toast.makeText(this, getIntent().getStringExtra("dokter"), Toast.LENGTH_SHORT).show();
    }

    public String getPoliString (int currentPoli){
        String Poli = "";

        if (currentPoli == 0) {
             Poli = "Umum";
        } else {
            Poli = "Gigi";
        }
        return Poli;
    }

    public String getKesadaranString (int currentKesadaran){
        String Kesadaran = "";

        if (currentKesadaran == 0) {
            Kesadaran = "Composmentis";
        } else if (currentKesadaran == 1) {
            Kesadaran = "Apatis";
        } else if (currentKesadaran == 2) {
            Kesadaran = "Delirium";
        } else if (currentKesadaran == 3) {
            Kesadaran = "Somnolen";
        } else if (currentKesadaran == 4) {
            Kesadaran = "Sopor";
        } else if (currentKesadaran == 5) {
            Kesadaran = "Semicoma";
        } else {
            Kesadaran = "Coma";
        }
        return Kesadaran;
    }

}