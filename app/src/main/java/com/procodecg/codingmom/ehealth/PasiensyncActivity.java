package com.procodecg.codingmom.ehealth;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

/**
 * Created by macbookpro on 7/27/17.
 */

public class PasiensyncActivity extends Activity {

    public static final int SELECTED_PICTURE =1;
    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_pasiensync);



    //SINKRONISASI BERHASIL
    }
    public void goToProfil(View v){
        Intent activity = new Intent(this, BottombarActivity.class);
        startActivity(activity);
        finish();
    }

    public void imgClick (View v) {
        Intent i = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(i, SELECTED_PICTURE);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case SELECTED_PICTURE :
                if(resultCode==RESULT_OK){
                    Uri uri=data.getData();
                    String[]projection={MediaStore.Images.Media.DATA};

                    Cursor cursor=getContentResolver().query(uri,projection,null,null,null);
                    cursor.moveToFirst();

                    int columnIndex=cursor.getColumnIndex(projection[0]);
                    String filePath=cursor.getString(columnIndex);
                    cursor.close();

                    ImageView iv=(ImageView) findViewById(R.id.imageView);

                    Bitmap yourSelectedImage= BitmapFactory.decodeFile(filePath);
                    Drawable d= new BitmapDrawable(yourSelectedImage);
                    iv.setBackground(d);
                }
        }
    };


}

//    //SINKRONISASI TIDAK BERHASIL
//    Button mShowDialog = (Button) findViewById(R.id.btnShowDialog);
//        mShowDialog.setOnClickListener(new View.OnClickListener() {
//        @Override
//        public void onClick(View view) {
//            AlertDialog.Builder mBuilder = new AlertDialog.Builder(PasiensyncActivity.this);
//            mBuilder.setIcon(R.drawable.logo2);
//            mBuilder.setTitle("Kartu pasien tidak dapat diakses");
//            mBuilder.setMessage("Silahkan coba lagi");
//            mBuilder.setCancelable(false);
//            mBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//        @Override
//        public void onClick(DialogInterface dialogInterface, int i) {
//            dialogInterface.dismiss();
//            }
//            });
//            AlertDialog alertDialog = mBuilder.create();
//            alertDialog.show();
//        }
//        });
//        }
//        }