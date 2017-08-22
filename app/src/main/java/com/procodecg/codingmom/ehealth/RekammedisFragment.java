package com.procodecg.codingmom.ehealth;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

/**
 * Created by macbookpro on 7/30/17.
 */


public class RekammedisFragment extends Fragment {
        public static RekammedisFragment newInstance() {
                RekammedisFragment fragment = new RekammedisFragment();
                return fragment;
        }

        boolean buka = false;

        @Override
        public void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);

        }


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {



           final View view = inflater.inflate(R.layout.fragment_rekammedis, container, false);
            ((BottombarActivity) getActivity()).setTitleText("Rekam Medis");



                Button btnStatis = (Button) view.findViewById(R.id.btnStatis);
                final LinearLayout contentStatis = (LinearLayout) view.findViewById(R.id.contentStatis);

                btnStatis.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                                if(buka == false){
                                        contentStatis.setVisibility(View.VISIBLE);
                                        buka = true;
                                }else{
                                        contentStatis.setVisibility(View.GONE);
                                        buka = false;
                                }
                        }
                });

                Button btnDinamis = (Button) view.findViewById(R.id.btnDinamis);
                final LinearLayout contentDinamis = (LinearLayout) view.findViewById(R.id.contentDinamis);

                btnDinamis.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(buka == false){
                            contentDinamis.setVisibility(View.VISIBLE);
                            buka = true;
                            }else{
                            contentDinamis.setVisibility(View.GONE);
                            buka = false;
                            }
                        }
                });

            Button btnTambah = (Button)view.findViewById(R.id.btnTambah);
            btnTambah.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent activity = new Intent(getActivity(), IsirekammedisActivity.class);
                    startActivity(activity);

                }

            });


            return view;
        }

}