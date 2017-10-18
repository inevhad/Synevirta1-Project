package com.procodecg.codingmom.ehealth;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.procodecg.codingmom.ehealth.main.SetConfig;

import java.util.HashMap;

public class SettingActivity extends AppCompatActivity {

    private SetConfig setConfig;
    private EditText idpuskes,namapuskes;
    private Button simpan,hapus;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        setConfig = new SetConfig(getApplicationContext() );
        idpuskes = (EditText) findViewById(R.id.idpuskes);
        namapuskes = (EditText) findViewById(R.id.namapuskes);
        simpan = (Button) findViewById(R.id.simpan);
        hapus = (Button) findViewById(R.id.hapus);


        HashMap<String, String> setting = setConfig.getDetail();
        idpuskes.setText(setting.get(setConfig.KEY_IDPUSKES));
        namapuskes.setText(setting.get(setConfig.KEY_NAMAPUSKES));

       simpan.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view){
               setConfig.createSetConfig(
                       idpuskes.getText().toString(),
                       namapuskes.getText().toString());
           }
       });


    }
}