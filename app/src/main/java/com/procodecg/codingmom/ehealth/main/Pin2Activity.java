package com.procodecg.codingmom.ehealth.main;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.goodiebag.pinview.Pinview;
import com.procodecg.codingmom.ehealth.R;
import com.procodecg.codingmom.ehealth.utils.SessionManagement;

public class Pin2Activity extends SessionManagement {

    Typeface font;
    Typeface fontbold;


    // batas jumlah input pin salah yang diperbolehkan
    private int numberOfRemainingLoginAttempts = 3;

// fungsi sembunyikan keyboard
    public static void hideKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        //Find the currently focused view, so we can grab the correct window token from it.
        View view = activity.getCurrentFocus();
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = new View(activity);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

//  fungsi menghapus pin input yang salah
    private void clearPin(ViewGroup group)
    {
        for (int i = 0, count = group.getChildCount(); i < count; ++i) {
            View view = group.getChildAt(i);
            if (view instanceof EditText) {
                ((EditText) view).getText().clear();
            }
            if(view instanceof ViewGroup && (((ViewGroup)view).getChildCount() > 0))
                clearPin((ViewGroup)view);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pin2);

        final TextView attemptslefttv = (TextView) findViewById(R.id.attemptsLeftTV);
        final TextView numberOfRemainingLoginAttemptstv = (TextView) findViewById(R.id.numberOfRemainingLoginAttemptsTV);
        final TextView textviewkali = (TextView) findViewById(R.id.textViewKali);

        font = Typeface.createFromAsset(getAssets(), "font1.ttf");
        fontbold = Typeface.createFromAsset(getAssets(), "font1bold.ttf");
        TextView tv1 = (TextView) findViewById(R.id.textPin);
        TextView tv2 = (TextView) findViewById(R.id.attemptsLeftTV);
        TextView tv3 = (TextView) findViewById(R.id.numberOfRemainingLoginAttemptsTV);
        TextView tv4 = (TextView) findViewById(R.id.textViewKali);
        tv1.setTypeface(font);
        tv2.setTypeface(fontbold);
        tv3.setTypeface(fontbold);
        tv4.setTypeface(fontbold);

        Pinview pinview = (Pinview) findViewById(R.id.pinView);
        pinview.setPinViewEventListener(new Pinview.PinViewEventListener() {
            @Override
            public void onDataEntered(Pinview pinview, boolean b) {
//          jika pin benar
                if (pinview.getValue().toString().equals("12345")) {
                    Toast.makeText(Pin2Activity.this, "Pin Anda benar", Toast.LENGTH_SHORT).show();
                    hideKeyboard(Pin2Activity.this);
                    Intent activity = new Intent(Pin2Activity.this, PasiensyncActivity.class);
                    startActivity(activity);
                    finish();
//          jika pin salah
                } else {

                    clearPin((ViewGroup) pinview);
                    pinview.clearFocus();
                    Toast.makeText(getApplicationContext(), "PIN yang Anda masukkan salah",
                            Toast.LENGTH_SHORT).show();

                    numberOfRemainingLoginAttempts--;
                    numberOfRemainingLoginAttemptstv.setText(Integer.toString(numberOfRemainingLoginAttempts));

//                  tampilkan text "Kesempatan login : x kali"
                    attemptslefttv.setVisibility(View.VISIBLE);
                    numberOfRemainingLoginAttemptstv.setVisibility(View.VISIBLE);
                    textviewkali.setVisibility(View.VISIBLE);

//                  jika kesempatan login habis
                    if (numberOfRemainingLoginAttempts == 0) {
                        hideKeyboard(Pin2Activity.this);
//                      tampilkan dialog box alert
                        AlertDialog.Builder mBuilder = new AlertDialog.Builder(Pin2Activity.this);
                        mBuilder.setTitle(R.string.dialog_title_pin);
                        mBuilder.setMessage(R.string.dialog_msg_pin);
                        mBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                                Intent activity = new Intent(Pin2Activity.this, Main1Activity.class);
                                startActivity(activity);
                                finish();
                            }
                        });

                        AlertDialog alertDialog = mBuilder.create();
                        alertDialog.show();

                    }
                }


            }
        });
    }

/*    public void goToPasien(View v){
        Intent activity = new Intent(this, PasiensyncActivity.class);
        startActivity(activity);
        finish();
    }
*/

}
