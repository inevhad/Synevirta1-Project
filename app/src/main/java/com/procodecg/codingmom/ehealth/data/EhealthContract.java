package com.procodecg.codingmom.ehealth.data;

/**
 * Created by neo on 8/16/17.
 */

import android.net.Uri;
import android.provider.BaseColumns;

/**
 * API Contract for the Ehealth app.
 */

public final class EhealthContract {

    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    private EhealthContract() {}

    /**
     * The "Content authority" is a name for the entire content provider, similar to the
     * relationship between a domain name and its website.  A convenient string to use for the
     * content authority is the package name for the app, which is guaranteed to be unique on the
     * device.
     */
    public static final String CONTENT_AUTHORITY = "com.procodecg.codingmom.ehealth";

    /**
     * Use CONTENT_AUTHORITY to create the base of all URI's which apps will use to contact
     * the content provider.
     */
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    /**
     * Possible path (appended to base content URI for possible URI's)
     * For instance, content://com.example.android.pets/pets/ is a valid path for
     * looking at pet data. content://com.example.android.pets/staff/ will fail,
     * as the ContentProvider hasn't been given any information on what to do with "staff".
     */
    public static final String PATH_EHEALTH = "ehealth";
    /**
     * Inner class that defines constant values for the ehealth database table.
     * Each entry in the table represents a single data.
     */

    public static final class KartuEntry implements BaseColumns {


        /** The content URI to access the pet data in the provider */
        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_EHEALTH);

        /** Name of database table */
        public final static String TABLE_NAME = "kartu";

        /**
         * HPC_number.
         *
         * Type: TEXT
         */
        public final static String COLUMN_HPCNUMBER ="hpc_number";

        /**
         * PIN_HPC
         *
         * Type: NUMERIC
         */
        public final static String COLUMN_PINHPC = "pin_hpc";

        /**
         * nama_dokter.
         *
         * Type: TEXT
         */
        public final static String COLUMN_DOKTER = "nama_dokter";

        /**
         * PHC number.
         *
         * Type: TEXT
         */
        public final static String COLUMN_PDCNUMBER = "pdc_number";

        /**
         * nama pasien.
         *
         * Type: TEXT
         */
        public final static String COLUMN_NAMAPASIEN = "nama_pasien";

    }


    public static final class RekamMedisEntry implements BaseColumns {


        /** The content URI to access the data in the provider */
        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_EHEALTH);

        /** Name of database table for ehealth */
        public final static String TABLE_NAME = "rekam_medis";

        /**
         * Unique ID number for the data (only for use in the database table).
         *
         * Type: INTEGER
         */
        public final static String _ID = BaseColumns._ID;

        /**
         * Tanggal Periksa.
         *
         * Type: DATE (4)
         */
        public final static String COLUMN_TGL_PERIKSA ="tgl_periksa";

        /**
         * Keluhan utama.
         *
         * Type: TEXT (50)
         */
        public final static String COLUMN_KELUHANUTAMA = "keluhan_utama";

        /**
         * Anamnesa.
         *
         * Type: TEXT (200)
         */
        public final static String COLUMN_ANAMNESA = "anamnesa";

        /**
         * Riwayat penyakit dahulu.
         *
         * Type: TEXT (100)
         */
        public final static String COLUMN_PENYAKIT_DULU = "rpenyakitdulu";

        /**
         * Riwayat penyakit keluarga.
         *
         * Type: TEXT (100)
         */
        public final static String COLUMN_PENYAKIT_KEL = "rpenyakitkel";

        /**
         * Pemeriksaan fisik.
         *
         * Type: TEXT (100)
         */
        public final static String COLUMN_FISIK = "pemeriksaan_fisik";

        /**
         * Tinggi.
         *
         * Type: NUM (4)
         */
        public final static String COLUMN_TINGGI = "tinggi";

        /**
         * Berat badan.
         *
         * Type: NUM (4)
         */
        public final static String COLUMN_BERAT = "berat";

        /**
         * Systole.
         *
         * Type: NUM (4)
         */
        public final static String COLUMN_SYSTOLE = "systole";

        /**
         * Diastole.
         *
         * Type: NUM (4)
         */
        public final static String COLUMN_DIASTOLE = "diastole";

        /**
         * Nadi.
         *
         * Type: NUM (3)
         */
        public final static String COLUMN_NADI = "nadi";

        /**
         * Kesadaran.
         *
         * Type: NUM (1)
         */
        public final static String COLUMN_KESADARAN = "kesadaran";

        /**
         * Suhu.
         *
         * Type: FLOAT (4)
         */
        public final static String COLUMN_SUHU = "suhu";

        /**
         * Respirasi.
         *
         * Type: NUM (3)
         */
        public final static String COLUMN_RESPIRASI = "respirasi";

        /**
         * Lain-lain.
         *
         * Type: TEXT (250)
         */
        public final static String COLUMN_LAINLAIN = "lain_lain";

        /**
         * Lab execute flag.
         *
         * The only possible values are {@link #LAB_DILAYANI_PENUH}, {@link #LAB_TIDAK_DILAYANI},
         * or {@link #LAB_DILAYANI_SEBAGIAN}.
         *
         * Type: INTEGER (1)
         */
        public final static String COLUMN_LABFLAG = "labflag";
        public static final int LAB_DILAYANI_PENUH = 0;
        public static final int LAB_TIDAK_DILAYANI = 1;
        public static final int LAB_DILAYANI_SEBAGIAN = 2;

        /**
         * Expertise Lab Radio.
         *
         * Type: TEXT (512)
         */
        public final static String COLUMN_LABRADIO = "labradio";

        /**
         * Catatan lab.
         *
         * Type: TEXT (50)
         */
        public final static String COLUMN_CATTLAB = "catt_lab";

        /**
         * Terapi.
         *
         * Type: TEXT (512)
         */
        public final static String COLUMN_TERAPI = "terapi";

        /**
         * Resep.
         *
         * Type: TEXT (200)
         */
        public final static String COLUMN_RESEP = "resep";

        /**
         * Catatan resep.
         *
         * Type: TEXT (50)
         */
        public final static String COLUMN_CATTRESEP = "cattresep";

        /**
         * Eksekusi resep flag.
         * The only possible values are {@link #RESEP_DILAYANI_PENUH}, {@link #RESEP_TIDAK_DILAYANI},
         * {@link #RESEP_DILAYANI_SEBAGIAN}, {@link #RESEP_DILAYANI_PENGGANTIAN} or {@link #RESEP_DILAYANI_SEBAGIAN_PENGGANTIAN}.
         *
         * Type: NUM (1)
         */
        public final static String COLUMN_EKSEKUSIRESEP = "eksekusi_resep";
        public static final int RESEP_DILAYANI_PENUH = 0;
        public static final int RESEP_TIDAK_DILAYANI = 1;
        public static final int RESEP_DILAYANI_SEBAGIAN = 2;
        public static final int RESEP_DILAYANI_PENGGANTIAN = 3;
        public static final int RESEP_DILAYANI_SEBAGIAN_PENGGANTIAN = 4;
        /**
         * Repetisi resep.
         *
         * Type: NUM (1)
         */
        public final static String COLUMN_REPETISIRESEP = "repetisi_resep";

        /**
         * Prognosa.
         *
         * Type: NUM (1)
         */
        public final static String COLUMN_PROGNOSA = "prognosa";

        /**
         * Kode penyakit ICD 1.
         *
         * Type: TEXT (10)
         */
        public final static String COLUMN_KODE_PENYAKIT = "kode_penyakit";

        /**
         * Kode penyakit ICD 2.
         *
         * Type: TEXT (10)
         */
       // public final static String COLUMN_KODE_PENYAKIT_ICD_2 = "kode penyakit ICD 2";

        /**
         * Kode penyakit ICD 3.
         *
         * Type: TEXT (10)
         */
       // public final static String COLUMN_KODE_PENYAKIT_ICD_3 = "kode penyakit ICD 3";

        /**
         * Kode penyakit ICD 4.
         *
         * Type: TEXT (10)
         */
       // public final static String COLUMN_KODE_PENYAKIT_ICD_4 = "kode penyakit ICD 4";

        /**
         * Kode penyakit ICD 5.
         *
         * Type: TEXT (10)
         */
       // public final static String COLUMN_KODE_PENYAKIT_ICD_5 = "kode penyakit ICD 5";

        /**
         * Kode penyakit ICD 6.
         *
         * Type: TEXT (10)
         */
       // public final static String COLUMN_KODE_PENYAKIT_ICD_6 = "kode penyakit ICD 6";

        /**
         * Kode penyakit ICD 7.
         *
         * Type: TEXT (10)
         */
       // public final static String COLUMN_KODE_PENYAKIT_ICD_7 = "kode penyakit ICD 7";

        /**
         * Kode penyakit ICD 8.
         *
         * Type: TEXT (10)
         */
      //  public final static String COLUMN_KODE_PENYAKIT_ICD_8 = "kode penyakit ICD 8";

        /**
         * Kode penyakit ICD 9.
         *
         * Type: TEXT (10)
         */
      //  public final static String COLUMN_KODE_PENYAKIT_ICD_9 = "kode penyakit ICD 9";

        /**
         * Kode penyakit ICD 10.
         *
         * Type: TEXT (10)
         */
       // public final static String COLUMN_KODE_PENYAKIT_ICD_10 = "kode penyakit ICD 10";
        /**
         *The only possible values are {@link #DIAGNOSA_BANDING}, {@link #DIAGNOSA_KERJA},
         * or {@link #DIAGNOSA_BANDING_KERJA}.
         */
        public static final int DIAGNOSA_BANDING = 0;
        public static final int DIAGNOSA_KERJA = 1;
        public static final int DIAGNOSA_BANDING_KERJA = 2;
        /**
         * Kode penyakit ICD 1 status diagnosa.
         *
         * Type: NUM (1)
         */
        public final static String COLUMN_STATUS = "status_diagnosa";

        /**
         * Kode penyakit ICD 2 status diagnosa.
         *
         * Type: NUM (1)
         */
      //  public final static String COLUMN_KODE_PENYAKIT_ICD_2_STATUS = "kode penyakit ICD 2 status diagnosa";

        /**
         * Kode penyakit ICD 3 status diagnosa.
         *
         * Type: NUM (1)
         */
      //  public final static String COLUMN_KODE_PENYAKIT_ICD_3_STATUS = "kode penyakit ICD 3 status diagnosa";

        /**
         * Kode penyakit ICD 4 status diagnosa.
         *
         * Type: NUM (1)
         */
     //   public final static String COLUMN_KODE_PENYAKIT_ICD_4_STATUS = "kode penyakit ICD 4 status diagnosa";

        /**
         * Kode penyakit ICD 5 status diagnosa.
         *
         * Type: NUM (1)
         */
      //  public final static String COLUMN_KODE_PENYAKIT_ICD_5_STATUS = "kode penyakit ICD 5 status diagnosa";

        /**
         * Kode penyakit ICD 6 status diagnosa.
         *
         * Type: NUM (1)
         */
      //  public final static String COLUMN_KODE_PENYAKIT_ICD_6_STATUS = "kode penyakit ICD 6 status diagnosa";

        /**
         * Kode penyakit ICD 7 status diagnosa.
         *
         * Type: NUM (1)
         */
      //  public final static String COLUMN_KODE_PENYAKIT_ICD_7_STATUS = "kode penyakit ICD 7 status diagnosa";

        /**
         * Kode penyakit ICD 8 status diagnosa.
         *
         * Type: NUM (1)
         */
       // public final static String COLUMN_KODE_PENYAKIT_ICD_8_STATUS = "kode penyakit ICD 8 status diagnosa";

        /**
         * Kode penyakit ICD 9 status diagnosa.
         *
         * Type: NUM (1)
         */
      //  public final static String COLUMN_KODE_PENYAKIT_ICD_9_STATUS = "kode penyakit ICD 9 status diagnosa";

        /**
         * Kode penyakit ICD 10 status diagnosa.
         *
         * Type: NUM (1)
         */
      //  public final static String COLUMN_KODE_PENYAKIT_ICD_10_STATUS = "kode penyakit ICD 10 status diagnosa";

        /**
         * Poli yang dituju.
         *
         * Type: TEXT (50)
         */
       public final static String COLUMN_POLI = "poli_tujuan";

        /**
         * Rujukan/Pengirim penderita.
         *
         * Type: TEXT (30)
         */
        public final static String COLUMN_RUJUKAN = "rujukan_penderita";

        /**
         * ID Puskesmas.
         *
         * Type: TEXT (12)
         */
        public final static String COLUMN_ID_PUSKESMAS = "ID_puskesmas";
    }

    public static final class DiagnosaEntry implements BaseColumns{
        public final static String TABLE_NAME = "tbl_diagnosa";

        public final static String COLUMN_DIAGNOSA = "diagnosa";
    }
}