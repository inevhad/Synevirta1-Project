package com.procodecg.codingmom.ehealth.data;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by neo on 11/21/17.
 */

public class EhealthDbHelper extends SQLiteOpenHelper {
    private SQLiteDatabase db;
    private static final String DATABASE_NAME = "ehealth.db";
    private static final int DATABASE_VERSION = 1;

    /**
     * Constructs a new instance of {@link EhealthDbHelper}.
     *
     * @param context of the app
     */

    public EhealthDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        createTableRekMed();
        createTableKartu();

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }

    public void openDB(){
        db = getWritableDatabase();
    }

    public void closeDB(){
        if(db != null && db.isOpen()){
            db.close();
        }
    }

    public String[] getAllDiagnosa(){
        Cursor cursor = db.query(
                EhealthContract.DiagnosaEntry.TABLE_NAME,
                new String[] {EhealthContract.DiagnosaEntry.COLUMN_DIAGNOSA},
                null,
                null,
                null,
                null,
                null
        );

        if(cursor.getCount() >0) {
            String[] str = new String[cursor.getCount()];
            int i = 0;

            while (cursor.moveToNext()) {
                str[i] = cursor.getString(cursor.getColumnIndex(EhealthContract.DiagnosaEntry.COLUMN_DIAGNOSA));
                i++;
            }
            return str;
        }else {
            return new String[] {};
        }
    }

    public void createTableRekMed(){

        String SQL_CREATE_REKMED_TABLE =  "CREATE TABLE " + EhealthContract.RekamMedisEntry.TABLE_NAME + " ("
                + EhealthContract.RekamMedisEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + EhealthContract.RekamMedisEntry.COLUMN_TGL_PERIKSA + " TEXT, "
                + EhealthContract.RekamMedisEntry.COLUMN_ID_PUSKESMAS + " TEXT, "
                + EhealthContract.RekamMedisEntry.COLUMN_POLI + " INTEGER, "
                + EhealthContract.RekamMedisEntry.COLUMN_RUJUKAN + " TEXT, "
                + EhealthContract.RekamMedisEntry.COLUMN_SYSTOLE + " INTEGER, "
                + EhealthContract.RekamMedisEntry.COLUMN_DIASTOLE + " INTEGER, "
                + EhealthContract.RekamMedisEntry.COLUMN_SUHU + " INTEGER, "
                + EhealthContract.RekamMedisEntry.COLUMN_NADI + " INTEGER, "
                + EhealthContract.RekamMedisEntry.COLUMN_RESPIRASI + " INTEGER, "
                + EhealthContract.RekamMedisEntry.COLUMN_KELUHANUTAMA + " TEXT, "
                + EhealthContract.RekamMedisEntry.COLUMN_PENYAKIT_SEKARANG + " TEXT, "
                + EhealthContract.RekamMedisEntry.COLUMN_PENYAKIT_DULU + " TEXT, "
                + EhealthContract.RekamMedisEntry.COLUMN_PENYAKIT_KEL + " TEXT, "
                + EhealthContract.RekamMedisEntry.COLUMN_TINGGI + " INTEGER, "
                + EhealthContract.RekamMedisEntry.COLUMN_BERAT + " INTEGER, "
                + EhealthContract.RekamMedisEntry.COLUMN_KESADARAN + " INTEGER, "
                + EhealthContract.RekamMedisEntry.COLUMN_KEPALA + " TEXT, "
                + EhealthContract.RekamMedisEntry.COLUMN_THORAX + " TEXT, "
                + EhealthContract.RekamMedisEntry.COLUMN_ABDOMEN + " TEXT, "
                + EhealthContract.RekamMedisEntry.COLUMN_GENITALIA + " TEXT, "
                + EhealthContract.RekamMedisEntry.COLUMN_EXTREMITAS + " TEXT, "
                + EhealthContract.RekamMedisEntry.COLUMN_KULIT + " TEXT, "
                + EhealthContract.RekamMedisEntry.COLUMN_NEUROLOGI + " TEXT, "
                + EhealthContract.RekamMedisEntry.COLUMN_LABORATORIUM + " TEXT, "
                + EhealthContract.RekamMedisEntry.COLUMN_RADIOLOGI + " TEXT, "
                + EhealthContract.RekamMedisEntry.COLUMN_STATUS_LABRADIO + " INTEGER, "
                + EhealthContract.RekamMedisEntry.COLUMN_DIAGNOSIS_KERJA + " TEXT, "
                + EhealthContract.RekamMedisEntry.COLUMN_DIAGNOSIS_BANDING + " TEXT, "
                + EhealthContract.RekamMedisEntry.COLUMN_ICD10_DIAGNOSA + " TEXT, "
                + EhealthContract.RekamMedisEntry.COLUMN_RESEP + " TEXT, "
                + EhealthContract.RekamMedisEntry.COLUMN_CATTRESEP + " TEXT, "
                + EhealthContract.RekamMedisEntry.COLUMN_STATUSRESEP + " INTEGER, "
                + EhealthContract.RekamMedisEntry.COLUMN_REPETISIRESEP + " INTEGER, "
                + EhealthContract.RekamMedisEntry.COLUMN_TINDAKAN + " TEXT, "
                + EhealthContract.RekamMedisEntry.COLUMN_AD_VITAM + " INTEGER, "
                + EhealthContract.RekamMedisEntry.COLUMN_AD_FUNCTIONAM + " INTEGER, "
                + EhealthContract.RekamMedisEntry.COLUMN_AD_SANATIONAM + " INTEGER);";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_REKMED_TABLE);
    }

    public void createTableKartu(){
        String SQL_CREATE_KARTU_TABLE =  "CREATE TABLE " + EhealthContract.KartuEntry.TABLE_NAME + " ("
                + EhealthContract.KartuEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + EhealthContract.KartuEntry.COLUMN_HPCNUMBER + " TEXT, "
                + EhealthContract.KartuEntry.COLUMN_DOKTER + " TEXT, "
                + EhealthContract.KartuEntry.COLUMN_PDCNUMBER + " TEXT, "
                + EhealthContract.KartuEntry.COLUMN_NAMAPASIEN + " TEXT);";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_KARTU_TABLE);
    }
}
