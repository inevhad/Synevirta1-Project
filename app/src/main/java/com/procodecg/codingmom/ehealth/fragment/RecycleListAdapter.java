package com.procodecg.codingmom.ehealth.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.procodecg.codingmom.ehealth.R;
import com.procodecg.codingmom.ehealth.data.EhealthContract;
import com.procodecg.codingmom.ehealth.data.EhealthDbHelper;
import com.procodecg.codingmom.ehealth.rekam_medis.RekmedlamaActivity;

import java.util.ArrayList;

import static com.procodecg.codingmom.ehealth.data.EhealthContract.RekamMedisEntry._ID;

/**
 * Created by macbookpro on 9/4/17.
 */

public class RecycleListAdapter extends RecyclerView.Adapter<RecycleListAdapter.ViewHolder> {
    private ArrayList<String> listTanggal;
    private ArrayList<String> listNamaDokter;
    private Activity activity;
    public static String currentPosition;

    private int[] ic;


//    public void setOnCardClickListener(RekmedDinamisFragment onCardClickListener) {
//        this.onCardClickListener = onCardClickListener;
//    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mTextView1;
        private TextView mTextView2;
        private ImageView mImage;
        private RelativeLayout rootLayout;

        public ViewHolder(View v) {
            super(v);
            mTextView1=(TextView)v.findViewById(R.id.txt_tanggal);
            mTextView2=(TextView)v.findViewById(R.id.txt_namaDokter);
            mImage=(ImageView)v.findViewById(R.id.img_card);
            rootLayout=(RelativeLayout)v.findViewById(R.id.rootLayout);
        }
    }

    public RecycleListAdapter(Activity activity, ArrayList<String> listTanggal, ArrayList<String> listNamaDokter, int[] icons) {
        this.listTanggal = listTanggal;
        this.listNamaDokter = listNamaDokter;
        this.activity = activity;
        this.ic = icons;
    }

    @Override
    public int getItemCount() {
        listTanggal.size();
        return listNamaDokter.size();
    }

    @Override
    public RecycleListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_recycle_list, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.mTextView1.setText(listTanggal.get(position));
        holder.mTextView2.setText(listNamaDokter.get(position));
        Bitmap icon = BitmapFactory.decodeResource(activity.getResources(),ic[position]);
        holder.mImage.setImageBitmap(icon);
        holder.rootLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentPosition = String.valueOf(position+1);
                Toast.makeText(activity, currentPosition, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(activity, RekmedlamaActivity.class);
                activity.startActivity(intent);



                /*
                switch (position){
                    case 0:
                        Toast.makeText(activity, "Posisi 1", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(activity, RekmedlamaActivity.class);
                activity.startActivity(intent);

                        break;

                    case 1:
                        Toast.makeText(activity, "Posisi 2", Toast.LENGTH_SHORT).show();
                        break;
                }
                */
                /*
                Intent intent = new Intent(activity, RekmedlamaActivity.class);
                intent.putExtra("dokter", listNamaDokter.get(position));
                activity.startActivity(intent);*/


            }

        });
    }

    public static String getCurrentPosition(){
        return currentPosition;
    }
}
