package com.procodecg.codingmom.ehealth;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import com.procodecg.codingmom.ehealth.data.EhealthDbHelper;

/**
 * Created by apandhis on 16/09/17.
 */

public class AutoComplete extends AppCompatActivity {

    EhealthDbHelper dbHelper;
    AutoCompleteTextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.auto_complete);

        textView = (AutoCompleteTextView) findViewById(R.id.autocompleteText);
        dbHelper = new EhealthDbHelper(getApplicationContext());
        dbHelper.openDB();

        String pencarian = getIntent().getStringExtra("hasil");
        String[] diagnosa = dbHelper.getAllDiagnosa();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_item, diagnosa);
        textView.setAdapter(adapter);

        Toast.makeText(this, getIntent().getStringExtra("hasil"), Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dbHelper.closeDB();
    }
}
