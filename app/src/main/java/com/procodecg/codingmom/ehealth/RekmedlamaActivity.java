package com.procodecg.codingmom.ehealth;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

/**
 * Created by macbookpro on 8/30/17.
 */

public class RekmedlamaActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_rekmedlama);
    }
}
