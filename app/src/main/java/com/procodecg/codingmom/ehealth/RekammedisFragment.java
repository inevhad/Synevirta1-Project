package com.procodecg.codingmom.ehealth;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by macbookpro on 7/30/17.
 */

//public class RekammedisFragment extends Activity {
//        @Override
//        protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        getActionBar().setTitle("Rekam Medis");
//        setContentView(R.layout.fragment_rekammedis);
//    }
//}

public class RekammedisFragment extends Fragment {
        public static RekammedisFragment newInstance() {
                RekammedisFragment fragment = new RekammedisFragment();
                return fragment;
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
                ((BottombarActivity) getActivity()).setTitleText("Rekam Medis");
                return inflater.inflate(R.layout.fragment_rekammedis, container, false);
        }
}