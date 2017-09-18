package com.procodecg.codingmom.ehealth.data;

/**
 * Created by neo on 8/16/17.
 */

import android.content.Context;
import android.database.Cursor;
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
    public EhealthDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * This is called when the database is created for the first time.
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create a String that contains the SQL statement to create the table
        String SQL_CREATE_REKAMMEDIS_TABLE =  "CREATE TABLE " + RekamMedisEntry.TABLE_NAME + " ("
                + RekamMedisEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + RekamMedisEntry.COLUMN_TGL_PERIKSA + " DATE, "
                + RekamMedisEntry.COLUMN_KELUHANUTAMA + " TEXT, "
                + RekamMedisEntry.COLUMN_ANAMNESA + " TEXT, "
                + RekamMedisEntry.COLUMN_PENYAKIT_DULU + " TEXT, "
                + RekamMedisEntry.COLUMN_PENYAKIT_KEL + " TEXT, "
                + RekamMedisEntry.COLUMN_FISIK + " TEXT, "
                + RekamMedisEntry.COLUMN_TINGGI + " INTEGER, "
                + RekamMedisEntry.COLUMN_BERAT + " INTEGER, "
                + RekamMedisEntry.COLUMN_SYSTOLE+ " INTEGER, "
                + RekamMedisEntry.COLUMN_DIASTOLE + " INTEGER, "
                + RekamMedisEntry.COLUMN_NADI + " INTEGER, "
                + RekamMedisEntry.COLUMN_KESADARAN + " INTEGER, "
                + RekamMedisEntry.COLUMN_SUHU + " FLOAT, "
                + RekamMedisEntry.COLUMN_RESPIRASI + " INTEGER, "
                + RekamMedisEntry.COLUMN_LAINLAIN + " TEXT, "
                + RekamMedisEntry.COLUMN_LABFLAG + " INTEGER, "
                + RekamMedisEntry.COLUMN_LABRADIO + " TEXT, "
                + RekamMedisEntry.COLUMN_CATTLAB + " TEXT, "
                + RekamMedisEntry.COLUMN_TERAPI + " TEXT, "
                + RekamMedisEntry.COLUMN_RESEP + " TEXT, "
                + RekamMedisEntry.COLUMN_CATTRESEP + " TEXT, "
                + RekamMedisEntry.COLUMN_EKSEKUSIRESEP + " INTEGER, "
                + RekamMedisEntry.COLUMN_REPETISIRESEP + " INTEGER, "
                + RekamMedisEntry.COLUMN_PROGNOSA + " INTEGER, "
               // + RekamMedisEntry.COLUMN_KELUHANUTAMA + " TEXT, "
                + RekamMedisEntry.COLUMN_ANAMNESA + " TEXT, "
                + RekamMedisEntry.COLUMN_KODE_PENYAKIT + " TEXT, "
               // + RekamMedisEntry.COLUMN_KODE_PENYAKIT_ICD_2 + " TEXT, "
                //+ RekamMedisEntry.COLUMN_KODE_PENYAKIT_ICD_3 + " TEXT, "
               // + RekamMedisEntry.COLUMN_KODE_PENYAKIT_ICD_4 + " TEXT, "
               // + RekamMedisEntry.COLUMN_KODE_PENYAKIT_ICD_5 + " TEXT, "
               // + RekamMedisEntry.COLUMN_KODE_PENYAKIT_ICD_6 + " TEXT, "
               // + RekamMedisEntry.COLUMN_KODE_PENYAKIT_ICD_7 + " TEXT, "
               // + RekamMedisEntry.COLUMN_KODE_PENYAKIT_ICD_8 + " TEXT, "
               // + RekamMedisEntry.COLUMN_KODE_PENYAKIT_ICD_9 + " TEXT, "
               // + RekamMedisEntry.COLUMN_KODE_PENYAKIT_ICD_10 + " TEXT, "
               // + RekamMedisEntry.COLUMN_KODE_PENYAKIT_ICD_1_STATUS + " TEXT, "
               // + RekamMedisEntry.COLUMN_KODE_PENYAKIT_ICD_2_STATUS + " TEXT, "
               // + RekamMedisEntry.COLUMN_KODE_PENYAKIT_ICD_3_STATUS + " TEXT, "
               // + RekamMedisEntry.COLUMN_KODE_PENYAKIT_ICD_4_STATUS + " TEXT, "
               // + RekamMedisEntry.COLUMN_KODE_PENYAKIT_ICD_5_STATUS + " TEXT, "
               // + RekamMedisEntry.COLUMN_KODE_PENYAKIT_ICD_6_STATUS + " TEXT, "
               // + RekamMedisEntry.COLUMN_KODE_PENYAKIT_ICD_7_STATUS + " TEXT, "
               // + RekamMedisEntry.COLUMN_KODE_PENYAKIT_ICD_8_STATUS + " TEXT, "
               // + RekamMedisEntry.COLUMN_KODE_PENYAKIT_ICD_9_STATUS + " TEXT, "
               // + RekamMedisEntry.COLUMN_KODE_PENYAKIT_ICD_10_STATUS + " TEXT, "
                + RekamMedisEntry.COLUMN_POLI + " TEXT, "
                + RekamMedisEntry.COLUMN_RUJUKAN + " TEXT, "
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
                + KartuEntry.COLUMN_HPCNUMBER + " TEXT NOT NULL, "
                + KartuEntry.COLUMN_PINHPC + " TEXT NOT NULL, "
                + KartuEntry.COLUMN_DOKTER + " TEXT NOT NULL, "
                + KartuEntry.COLUMN_PDCNUMBER + "TEXT NOT NULL, "
                + KartuEntry.COLUMN_NAMAPASIEN + "TEXT NOT NULL);";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_KARTU_TABLE);

        // Execute the SQL statement
        //db.execSQL(SQL_CREATE_REKAMMEDIS_TABLE);

        String SQL_CREATE_TABEL_DIAGNOSA = "CREATE TABLE " + EhealthContract.DiagnosaEntry.TABLE_NAME + " ( "
                + EhealthContract.DiagnosaEntry._ID + " TEXT PRIMARY KEY, "
                + EhealthContract.DiagnosaEntry.COLUMN_DIAGNOSA + " TEXT);";
        db.execSQL(SQL_CREATE_TABEL_DIAGNOSA);

        String INSERT_DIAGNOSA = "INSERT INTO " + EhealthContract.DiagnosaEntry.TABLE_NAME + " ( "
                + EhealthContract.DiagnosaEntry._ID + ", " + EhealthContract.DiagnosaEntry.COLUMN_DIAGNOSA + ") "
                + "VALUES ('A00', 'Cholera')";
        String INSERT_DIAGNOSA1 = "INSERT INTO " + EhealthContract.DiagnosaEntry.TABLE_NAME + " ( "
                + EhealthContract.DiagnosaEntry._ID + ", " + EhealthContract.DiagnosaEntry.COLUMN_DIAGNOSA + ") "
                + "VALUES ('A01', 'Typhoid and paratyphoid fevers')";
        String INSERT_DIAGNOSA2 = "INSERT INTO " + EhealthContract.DiagnosaEntry.TABLE_NAME + " ( "
                + EhealthContract.DiagnosaEntry._ID + ", " + EhealthContract.DiagnosaEntry.COLUMN_DIAGNOSA + ") "
                + "VALUES ('A02', 'Other salmonella infections')";
        String INSERT_DIAGNOSA3 = "INSERT INTO " + EhealthContract.DiagnosaEntry.TABLE_NAME + " ( "
                + EhealthContract.DiagnosaEntry._ID + ", " + EhealthContract.DiagnosaEntry.COLUMN_DIAGNOSA + ") "
                + "VALUES ('A03', 'Shigellosis')";
        String INSERT_DIAGNOSA4 = "INSERT INTO " + EhealthContract.DiagnosaEntry.TABLE_NAME + " ( "
                + EhealthContract.DiagnosaEntry._ID + ", " + EhealthContract.DiagnosaEntry.COLUMN_DIAGNOSA + ") "
                + "VALUES ('A04', 'Other bacterial intestinal infections')";
        String INSERT_DIAGNOSA5 = "INSERT INTO " + EhealthContract.DiagnosaEntry.TABLE_NAME + " ( "
                + EhealthContract.DiagnosaEntry._ID + ", " + EhealthContract.DiagnosaEntry.COLUMN_DIAGNOSA + ") "
                + "VALUES ('A05', 'Other bacterial foodborne intoxications, not elsewhere classified')";
        String INSERT_DIAGNOSA6 = "INSERT INTO " + EhealthContract.DiagnosaEntry.TABLE_NAME + " ( "
                + EhealthContract.DiagnosaEntry._ID + ", " + EhealthContract.DiagnosaEntry.COLUMN_DIAGNOSA + ") "
                + "VALUES ('A06', 'Amoebiasis')";
        String INSERT_DIAGNOSA7 = "INSERT INTO " + EhealthContract.DiagnosaEntry.TABLE_NAME + " ( "
                + EhealthContract.DiagnosaEntry._ID + ", " + EhealthContract.DiagnosaEntry.COLUMN_DIAGNOSA + ") "
                + "VALUES ('A07', 'Other protozoal intestinal diseases')";
        String INSERT_DIAGNOSA8 = "INSERT INTO " + EhealthContract.DiagnosaEntry.TABLE_NAME + " ( "
                + EhealthContract.DiagnosaEntry._ID + ", " + EhealthContract.DiagnosaEntry.COLUMN_DIAGNOSA + ") "
                + "VALUES ('A08', 'Viral and other specified intestinal infections')";
        String INSERT_DIAGNOSA9 = "INSERT INTO " + EhealthContract.DiagnosaEntry.TABLE_NAME + " ( "
                + EhealthContract.DiagnosaEntry._ID + ", " + EhealthContract.DiagnosaEntry.COLUMN_DIAGNOSA + ") "
                + "VALUES ('A09', 'Other gastroenteritis and colitis of infectious and unspecified origin')";
        String INSERT_DIAGNOSA10 = "INSERT INTO " + EhealthContract.DiagnosaEntry.TABLE_NAME + " ( "
                + EhealthContract.DiagnosaEntry._ID + ", " + EhealthContract.DiagnosaEntry.COLUMN_DIAGNOSA + ") "
                + "VALUES ('A00.0', 'Cholera due to Vibrio cholerae 01, biovar cholerae')";
        String INSERT_DIAGNOSA11 = "INSERT INTO " + EhealthContract.DiagnosaEntry.TABLE_NAME + " ( "
                + EhealthContract.DiagnosaEntry._ID + ", " + EhealthContract.DiagnosaEntry.COLUMN_DIAGNOSA + ") "
                + "VALUES ('A00.1', 'Cholera due to Vibrio cholerae 01, biovar eltor')";
        String INSERT_DIAGNOSA12 = "INSERT INTO " + EhealthContract.DiagnosaEntry.TABLE_NAME + " ( "
                + EhealthContract.DiagnosaEntry._ID + ", " + EhealthContract.DiagnosaEntry.COLUMN_DIAGNOSA + ") "
                + "VALUES ('A00.9', 'Cholera, unspecified')";
        String INSERT_DIAGNOSA13 = "INSERT INTO " + EhealthContract.DiagnosaEntry.TABLE_NAME + " ( "
                + EhealthContract.DiagnosaEntry._ID + ", " + EhealthContract.DiagnosaEntry.COLUMN_DIAGNOSA + ") "
                + "VALUES ('A01.0', 'Typhoid fever')";
        String INSERT_DIAGNOSA14 = "INSERT INTO " + EhealthContract.DiagnosaEntry.TABLE_NAME + " ( "
                + EhealthContract.DiagnosaEntry._ID + ", " + EhealthContract.DiagnosaEntry.COLUMN_DIAGNOSA + ") "
                + "VALUES ('A01.1', 'Paratyphoid fever A')";
        String INSERT_DIAGNOSA15 = "INSERT INTO " + EhealthContract.DiagnosaEntry.TABLE_NAME + " ( "
                + EhealthContract.DiagnosaEntry._ID + ", " + EhealthContract.DiagnosaEntry.COLUMN_DIAGNOSA + ") "
                + "VALUES ('A01.2', 'Paratyphoid fever B')";
        String INSERT_DIAGNOSA16 = "INSERT INTO " + EhealthContract.DiagnosaEntry.TABLE_NAME + " ( "
                + EhealthContract.DiagnosaEntry._ID + ", " + EhealthContract.DiagnosaEntry.COLUMN_DIAGNOSA + ") "
                + "VALUES ('A01.3', 'Paratyphoid fever C')";
        String INSERT_DIAGNOSA17 = "INSERT INTO " + EhealthContract.DiagnosaEntry.TABLE_NAME + " ( "
                + EhealthContract.DiagnosaEntry._ID + ", " + EhealthContract.DiagnosaEntry.COLUMN_DIAGNOSA + ") "
                + "VALUES ('A01.4', 'Paratyphoid fever, unspecified')";

        db.execSQL(INSERT_DIAGNOSA);
        db.execSQL(INSERT_DIAGNOSA1);
        db.execSQL(INSERT_DIAGNOSA2);
        db.execSQL(INSERT_DIAGNOSA3);
        db.execSQL(INSERT_DIAGNOSA4);
        db.execSQL(INSERT_DIAGNOSA5);
        db.execSQL(INSERT_DIAGNOSA6);
        db.execSQL(INSERT_DIAGNOSA7);
        db.execSQL(INSERT_DIAGNOSA8);
        db.execSQL(INSERT_DIAGNOSA9);
        db.execSQL(INSERT_DIAGNOSA10);
        db.execSQL(INSERT_DIAGNOSA11);
        db.execSQL(INSERT_DIAGNOSA12);
        db.execSQL(INSERT_DIAGNOSA13);
        db.execSQL(INSERT_DIAGNOSA14);
        db.execSQL(INSERT_DIAGNOSA15);
        db.execSQL(INSERT_DIAGNOSA16);
        db.execSQL(INSERT_DIAGNOSA17);

    }

    /**
     * This is called when the database needs to be upgraded.
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // The database is still at version 1, so there's nothing to do be done here.
        db.execSQL("DROP TABLE IF EXISTS " + EhealthContract.DiagnosaEntry.TABLE_NAME);
        onCreate(db);
    }

    public void deleteAll(){
        if (db == null || !db.isOpen())
            db = getWritableDatabase();
        db.execSQL("DELETE FROM " + KartuEntry.TABLE_NAME);
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
}