package com.procodecg.codingmom.ehealth;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by macbookpro on 7/30/17.
 */

//public class PencarianFragment extends Activity {
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        getActionBar().setTitle("Pencarian");
//        setContentView(R.layout.fragment_pencarian);
//    }
//}

public class PencarianFragment extends Fragment {

    public static PencarianFragment newInstance() {
        PencarianFragment fragment = new PencarianFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ((BottombarActivity) getActivity()).setTitleText("Pencarian");
        return inflater.inflate(R.layout.fragment_pencarian, container, false);
    }
}