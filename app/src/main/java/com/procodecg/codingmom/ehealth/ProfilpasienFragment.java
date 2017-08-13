package com.procodecg.codingmom.ehealth;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by macbookpro on 7/30/17.
 */

public class ProfilpasienFragment extends Fragment {

    public static android.support.v4.app.Fragment newInstance() {
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

            FloatingActionButton fabDetail = (FloatingActionButton) view.findViewById(R.id.fabDetail);
                View.OnClickListener listener = new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent activity = new Intent(getActivity(), PasiendetailActivity.class);
                    startActivity(activity);

//                    Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                            .setAction("Action", null).show();
                }
            };
            fabDetail.setOnClickListener(listener);

            FloatingActionButton fabKeluarga = (FloatingActionButton) view.findViewById(R.id.fabKeluarga);
            View.OnClickListener listenerKel = new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent activity = new Intent(getActivity(), KeluargaActivity.class);
                    startActivity(activity);

//                    Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                            .setAction("Action", null).show();



                }
            };
            fabKeluarga.setOnClickListener(listenerKel);

            return view;
        }



}