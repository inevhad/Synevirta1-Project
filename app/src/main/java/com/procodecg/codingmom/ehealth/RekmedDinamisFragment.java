package com.procodecg.codingmom.ehealth;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by macbookpro on 8/29/17.
 */

public class RekmedDinamisFragment extends Fragment {
    public static RekmedDinamisFragment newInstance() {
        RekmedDinamisFragment fragment = new RekmedDinamisFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_rekmeddinamis, container, false);
        ((BottombarActivity) getActivity()).setTitleText("Rekam Medis Dinamis");
        ((BottombarActivity) getActivity()).setSubTitleText();
//        return inflater.inflate(R.layout.fragment_rekmeddinamis, container, false);

//        Spinner spinner = (Spinner) spinner.findViewById(R.id.kesadaran_spinner);
//        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.kesadaran, android.R.layout.simple_spinner_dropdown_item);
//        spinner.setAdapter(adapter);

//        Button btnTambah = (Button)view.findViewById(R.id.btnTambah);
//        btnTambah.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent activity = new Intent(getActivity(), RekmedbaruActivity.class);
//                startActivity(activity);
//            }
//
//        });

        FloatingActionButton fabDetail = (FloatingActionButton) view.findViewById(R.id.fabMedrecBaru);
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent activity = new Intent(getActivity(), RekmedbaruActivity.class);
                startActivity(activity);

            }
        };
        fabDetail.setOnClickListener(listener);

//        Button btnRm1 = (Button)view.findViewById(R.id.btnRm1);
//        btnRm1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent activity = new Intent(getActivity(), RekmedlamaActivity.class);
//                startActivity(activity);
//            }
//
//        });

        return view;


    }



}
