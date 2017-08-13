package com.procodecg.codingmom.ehealth;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

/**
 * Created by macbookpro on 7/31/17.
 */

public class BottombarActivity extends AppCompatActivity {

//    private void displayFragment(int position) {
//        // update the main content by replacing fragments
//        Fragment fragment = null;
//        String title = "";
//        switch (position) {
//            case 0:
//                fragment = new ProfilpasienFragment();
//                title = "Profil Pasien";
//                break;
//            case 1:
//                fragment = new RekammedisFragment();
//                title = "Rekam Medis";
//                break;
//            case 2:
//                fragment = new PencarianFragment();
//                title = "Pencarian";
//                break;
//
//            default:
//                break;
//        }
//
//        // update selected fragment and title
//        if (fragment != null) {
//            getSupportFragmentManager().beginTransaction()
//                    .replace(R.id.frame_layout, fragment).commit();
//            getSupportActionBar().setTitle(title);
//            // change icon to arrow drawable
//            getSupportActionBar().setHomeAsUpIndicator(R.drawable.logo2);
//        }
//    }
    private Toolbar toolbar;
    private TextView txtTitle;
    public static BottombarActivity instance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottombar);
        BottomNavigationView bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.navigation);
        instance = this;

        txtTitle = (TextView) findViewById(R.id.txt_title);
        //utk title custom action bar
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if(getSupportActionBar()!= null) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }

        bottomNavigationView.setOnNavigationItemSelectedListener
                (new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        Fragment selectedFragment = null;
                        switch (item.getItemId()) {
                            case R.id.profil:
                                selectedFragment = ProfilpasienFragment.newInstance();
                                break;
                            case R.id.rekammedis:
                                selectedFragment = RekammedisFragment.newInstance();
                                break;
                            case R.id.pencarian:
                                selectedFragment = PencarianFragment.newInstance();
                                break;
                        }
                        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.frame_layout, selectedFragment);
                        transaction.commit();
                        return true;
                    }
                });

        //Manually displaying the first fragment - one time only
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout, ProfilpasienFragment.newInstance());
        transaction.commit();

        //Used to select an item programmatically
        //bottomNavigationView.getMenu().getItem(2).setChecked(true);
    }

    public void setTitleText(String title){
        if(title.isEmpty()){
            txtTitle.setText("eHealth");
        }else{
            txtTitle.setText(title);
        }
    }
}