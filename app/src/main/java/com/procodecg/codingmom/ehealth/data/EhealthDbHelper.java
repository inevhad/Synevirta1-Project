package com.procodecg.codingmom.ehealth.data;

/**
 * Created by neo on 8/16/17.
 */

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.procodecg.codingmom.ehealth.data.EhealthContract.KartuEntry;
import com.procodecg.codingmom.ehealth.data.EhealthContract.RekamMedisEntry;
/**
 * Database helper for Pets app. Manages database creation and version management.
 */
public class EhealthDbHelper extends SQLiteOpenHelper {
    private SQLiteDatabase db;
    public static final String LOG_TAG = EhealthDbHelper.class.getSimpleName();

    /** Name of the database file */
    private static final String DATABASE_NAME = "ehealth.db";

    /**
     * Database version. If you change the database schema, you must increment the database version.
     */
    private static final int DATABASE_VERSION = 1;

    /**
     * Constructs a new instance of {@link EhealthDbHelper}.
     *
     * @param context of the app
     */
    public EhealthDbHelper(Context context) {super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * This is called when the database is created for the first time.
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create a String that contains the SQL statement to create the table
        String SQL_CREATE_REKAMMEDIS_TABLE =  "CREATE TABLE " + RekamMedisEntry.TABLE_NAME + " ("
                + RekamMedisEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + RekamMedisEntry.COLUMN_TANGGAL_PERIKSA + " DATE, "
                + RekamMedisEntry.COLUMN_KELUHAN_UTAMA + " TEXT, "
                + RekamMedisEntry.COLUMN_ANAMNESA + " TEXT, "
                + RekamMedisEntry.COLUMN_RIWAYAT_PENYAKIT_DULU + " TEXT, "
                + RekamMedisEntry.COLUMN_RIWAYAT_PENYAKIT_KELUARGA + " TEXT, "
                + RekamMedisEntry.COLUMN_PEMERIKSAAN_FISIK + " TEXT, "
                + RekamMedisEntry.COLUMN_TINGGI + " INTEGER, "
                + RekamMedisEntry.COLUMN_BERAT_BADAN + " INTEGER, "
                + RekamMedisEntry.COLUMN_SYSTOLE+ " INTEGER, "
                + RekamMedisEntry.COLUMN_DIASTOLE + " INTEGER, "
                + RekamMedisEntry.COLUMN_NADI + " INTEGER, "
                + RekamMedisEntry.COLUMN_KESADARAN + " INTEGER, "
                + RekamMedisEntry.COLUMN_SUHU + " FLOAT, "
                + RekamMedisEntry.COLUMN_RESPIRASI + " INTEGER, "
                + RekamMedisEntry.COLUMN_LAIN_LAIN + " TEXT, "
                + RekamMedisEntry.COLUMN_LAB_EXECUTE_FLAG + " INTEGER, "
                + RekamMedisEntry.COLUMN_EXPERTISE_LAB_RADIO + " TEXT, "
                + RekamMedisEntry.COLUMN_CATATAN_LAB + " TEXT, "
                + RekamMedisEntry.COLUMN_TERAPI + " TEXT, "
                + RekamMedisEntry.COLUMN_RESEP + " TEXT, "
                + RekamMedisEntry.COLUMN_CATATAN_RESEP + " TEXT, "
                + RekamMedisEntry.COLUMN_EKSEKUSI_RESEP_FLAG + " INTEGER, "
                + RekamMedisEntry.COLUMN_REPETISI_RESEP + " INTEGER, "
                + RekamMedisEntry.COLUMN_PROGNOSA + " INTEGER, "
                + RekamMedisEntry.COLUMN_KELUHAN_UTAMA + " TEXT, "
                + RekamMedisEntry.COLUMN_ANAMNESA + " TEXT, "
                + RekamMedisEntry.COLUMN_KODE_PENYAKIT_ICD_1 + " TEXT, "
                + RekamMedisEntry.COLUMN_KODE_PENYAKIT_ICD_2 + " TEXT, "
                + RekamMedisEntry.COLUMN_KODE_PENYAKIT_ICD_3 + " TEXT, "
                + RekamMedisEntry.COLUMN_KODE_PENYAKIT_ICD_4 + " TEXT, "
                + RekamMedisEntry.COLUMN_KODE_PENYAKIT_ICD_5 + " TEXT, "
                + RekamMedisEntry.COLUMN_KODE_PENYAKIT_ICD_6 + " TEXT, "
                + RekamMedisEntry.COLUMN_KODE_PENYAKIT_ICD_7 + " TEXT, "
                + RekamMedisEntry.COLUMN_KODE_PENYAKIT_ICD_8 + " TEXT, "
                + RekamMedisEntry.COLUMN_KODE_PENYAKIT_ICD_9 + " TEXT, "
                + RekamMedisEntry.COLUMN_KODE_PENYAKIT_ICD_10 + " TEXT, "
                + RekamMedisEntry.COLUMN_KODE_PENYAKIT_ICD_1_STATUS + " TEXT, "
                + RekamMedisEntry.COLUMN_KODE_PENYAKIT_ICD_2_STATUS + " TEXT, "
                + RekamMedisEntry.COLUMN_KODE_PENYAKIT_ICD_3_STATUS + " TEXT, "
                + RekamMedisEntry.COLUMN_KODE_PENYAKIT_ICD_4_STATUS + " TEXT, "
                + RekamMedisEntry.COLUMN_KODE_PENYAKIT_ICD_5_STATUS + " TEXT, "
                + RekamMedisEntry.COLUMN_KODE_PENYAKIT_ICD_6_STATUS + " TEXT, "
                + RekamMedisEntry.COLUMN_KODE_PENYAKIT_ICD_7_STATUS + " TEXT, "
                + RekamMedisEntry.COLUMN_KODE_PENYAKIT_ICD_8_STATUS + " TEXT, "
                + RekamMedisEntry.COLUMN_KODE_PENYAKIT_ICD_9_STATUS + " TEXT, "
                + RekamMedisEntry.COLUMN_KODE_PENYAKIT_ICD_10_STATUS + " TEXT, "
                + RekamMedisEntry.COLUMN_POLI_DITUJU + " TEXT, "
                + RekamMedisEntry.COLUMN_RUJUKAN_PENDERITA + " TEXT, "
                + RekamMedisEntry.COLUMN_ID_PUSKESMAS + " TEXT);";
/*
        String SQL_CREATE_KARTU_TABLE =  "CREATE TABLE " + KartuEntry.TABLE_NAME + " ("
                + KartuEntry.COLUMN_HPC_NUMBER + " TEXT NOT NULL, "
                + KartuEntry.COLUMN_PIN_HPC + " TEXT NOT NULL, "
                + KartuEntry.COLUMN_NAMA_DOKTER + " TEXT NOT NULL, "
                + KartuEntry.COLUMN_PHC_NUMBER + " TEXT, "
                + KartuEntry.COLUMN_NAMA_PASIEN + " TEXT);";
**/
        String SQL_CREATE_KARTU_TABLE =  "CREATE TABLE " + KartuEntry.TABLE_NAME + " ("
                + KartuEntry.COLUMN_HPC_NUMBER + " TEXT NOT NULL, "
                + KartuEntry.COLUMN_PIN_HPC + " TEXT NOT NULL, "
                + KartuEntry.COLUMN_NAMA_DOKTER + " TEXT NOT NULL);";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_KARTU_TABLE);

        // Execute the SQL statement
        //db.execSQL(SQL_CREATE_REKAMMEDIS_TABLE);
    }

    /**
     * This is called when the database needs to be upgraded.
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // The database is still at version 1, so there's nothing to do be done here.
    }

    public void deleteAll(){
        if (db == null || !db.isOpen())
            db = getWritableDatabase();
        db.execSQL("DELETE FROM " + KartuEntry.TABLE_NAME);
    }
}