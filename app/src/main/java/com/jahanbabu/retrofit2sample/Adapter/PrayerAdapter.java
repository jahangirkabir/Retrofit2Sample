package com.jahanbabu.retrofit2sample.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.jahanbabu.retrofit2sample.Model.Item;
import com.jahanbabu.retrofit2sample.R;

import java.util.ArrayList;

public class PrayerAdapter extends RecyclerView.Adapter<PrayerAdapter.MyViewHolder> {

    private ArrayList<Item> Items;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView nameTextView, descriptionTextView;
        private ImageView pImageView;

        public MyViewHolder(View view) {
            super(view);
            nameTextView = (TextView) view.findViewById(R.id.dateTextView);
            descriptionTextView = (TextView) view.findViewById(R.id.descriptionTextView);
        }
    }

    public PrayerAdapter(ArrayList<Item> productList) {
        this.Items = productList;
    }
 
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_row, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Item p = Items.get(position);
        holder.nameTextView.setText("Date : " + p.getDateFor());
        holder.descriptionTextView.setText("Fajr - " + p.getFajr()
                + "\nDhuhr - " + p.getDhuhr()
                + "\nAsr - " + p.getAsr()
                + "\nMagrib - " + p.getMaghrib()
                + "\nIsha - " + p.getIsha());

    }


    @Override
    public int getItemCount() {
        return Items.size();
    }
}
