package com.procodecg.codingmom.ehealth.rekam_medis;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.procodecg.codingmom.ehealth.R;
import com.procodecg.codingmom.ehealth.fragment.RecycleListAdapter;
import com.procodecg.codingmom.ehealth.data.EhealthDbHelper;

import java.util.ArrayList;


/**
 * Created by macbookpro on 8/29/17.
 */

public class RekmedDinamisFragment extends Fragment {
    public static RekmedDinamisFragment newInstance() {
        RekmedDinamisFragment fragment = new RekmedDinamisFragment();
        return fragment;
    }

    private RecycleListAdapter rAdapter;

    private ArrayList<String> listTanggal;
    private ArrayList<String> listNamaDokter;


    public static int icons[] = {
            R.drawable.folder3,
            R.drawable.folder3,
//            R.drawable.tips3,
//            R.drawable.tips4,
//            R.drawable.tips5,
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_rekmeddinamis, container, false);


        //aktifkan jika TIDAK menggunakan TabLayout Dinamis-Statis
//        ((BottombarActivity) getActivity()).setTitleText("Rekam Medis Dinamis");
//        ((BottombarActivity) getActivity()).setSubTitleText();


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


        RecyclerView rView = (RecyclerView) view.findViewById(R.id.my_recycler_view);
        rView.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rView.setLayoutManager(llm);

        //list tanggal folder dan nama dokter pemeriksanya
        listTanggal = new ArrayList<>();
        listTanggal.add("25-08-2017");
        listTanggal.add("6-02-2017");

        listNamaDokter = new ArrayList<>();
        listNamaDokter.add("dr Adrian");
        listNamaDokter.add("dr Susan");

        rAdapter=new RecycleListAdapter(getActivity(),listTanggal, listNamaDokter, icons);
        rView.setAdapter(rAdapter);
//        rAdapter.setOnCardClickListener(this);
//
//        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.users_list);
//        UsersAdapter adapter = new UsersAdapter(users, this);
//        recyclerView.setAdapter(adapter);
//        adapter.setOnCardClickListner(this);

        //Floating Action Button
        FloatingActionButton fabRekmedBaru = (FloatingActionButton) view.findViewById(R.id.fabRekmedBaru);
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent activity = new Intent(getActivity(), RekmedbaruActivity.class);
                startActivity(activity);


            }
        };
        fabRekmedBaru.setOnClickListener(listener);

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
