package com.procodecg.codingmom.ehealth.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.procodecg.codingmom.ehealth.pasien.KeluargaActivity;
import com.procodecg.codingmom.ehealth.pasien.PasiendetailActivity;
import com.procodecg.codingmom.ehealth.R;

/**
 * Created by macbookpro on 7/30/17.
 */

public class ProfilpasienFragment extends Fragment {

    public static Fragment newInstance() {
            ProfilpasienFragment fragment = new ProfilpasienFragment();
            return fragment;
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {

            final View view = inflater.inflate(R.layout.fragment_profilpasien, container, false);
            ((BottombarActivity) getActivity()).setTitleText("Profil Pasien");
            ((BottombarActivity) getActivity()).setSubTitleText();
//            ((AppCompatActivity) getActivity()).getSupportActionBar().setSubtitle("dr X");

            FloatingActionButton fabDetail = (FloatingActionButton) view.findViewById(R.id.fabDetail);
                View.OnClickListener listener = new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent activity = new Intent(getActivity(), PasiendetailActivity.class);
                    startActivity(activity);

               }
            };
            fabDetail.setOnClickListener(listener);

            FloatingActionButton fabKeluarga = (FloatingActionButton) view.findViewById(R.id.fabKeluarga);
            View.OnClickListener listenerKel = new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent activity = new Intent(getActivity(), KeluargaActivity.class);
                    startActivity(activity);

                }
            };
            fabKeluarga.setOnClickListener(listenerKel);

            return view;
        }



}