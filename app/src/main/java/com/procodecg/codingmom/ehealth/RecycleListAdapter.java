package com.procodecg.codingmom.ehealth;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by macbookpro on 9/4/17.
 */

public class RecycleListAdapter extends RecyclerView.Adapter<RecycleListAdapter.ViewHolder> {
    private ArrayList<String> listTanggal;
    private ArrayList<String> listNamaDokter;
    private Activity activity;
    private int[] ic;

//    public void setOnCardClickListener(RekmedDinamisFragment onCardClickListener) {
//        this.onCardClickListener = onCardClickListener;
//    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mTextView1;
        private TextView mTextView2;
        private ImageView mImage;

        public ViewHolder(View v) {
            super(v);
            mTextView1=(TextView)v.findViewById(R.id.txt_tanggal);
            mTextView2=(TextView)v.findViewById(R.id.txt_namaDokter);
            mImage=(ImageView)v.findViewById(R.id.img_card);
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
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mTextView1.setText(listTanggal.get(position));
        holder.mTextView2.setText(listNamaDokter.get(position));
        Bitmap icon = BitmapFactory.decodeResource(activity.getResources(),ic[position]);
        holder.mImage.setImageBitmap(icon);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(activity, "Test",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(activity, RekmedlamaActivity.class);
//                intent.putExtra("",);
                activity.startActivity(intent);
            }

        });
    }
}
