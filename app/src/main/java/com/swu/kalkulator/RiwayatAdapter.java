package com.swu.kalkulator;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RiwayatAdapter
        extends RecyclerView.Adapter<RiwayatAdapter.ViewHolder> {

    private final ArrayList<Riwayat> listRiwayat;

    public RiwayatAdapter(ArrayList<Riwayat> listRiwayat) {
        this.listRiwayat = listRiwayat;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvPerhitungan;
        TextView tvHasil;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvPerhitungan = itemView.findViewById(R.id.tvPerhitungan);
            tvHasil = itemView.findViewById(R.id.tvHasil);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(
            @NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_riwayat, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(
            @NonNull ViewHolder holder, int position) {

        Riwayat riwayat = listRiwayat.get(position);

        holder.tvPerhitungan.setText(riwayat.getPerhitungan());
        holder.tvHasil.setText("Hasil: " + riwayat.getHasil());
    }

    @Override
    public int getItemCount() {
        return listRiwayat.size();
    }
}
