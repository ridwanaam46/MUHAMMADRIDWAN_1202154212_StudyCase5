package com.example.asusx453sa.muhammadridwan_1202154212_studycase5;

/**
 * Created by ASUS X453SA on 3/24/2018.
 */

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.ViewHolder> {
    private List<Data> userList;
    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tvNama, tvDes,tvJumlah;
        public ViewHolder(View itemView) {
            super(itemView);
            tvNama  = itemView.findViewById(R.id.nama);
            tvDes   = itemView.findViewById(R.id.deskripsi);
            tvJumlah   = itemView.findViewById(R.id.jumlah);
        }
    }
    public TodoAdapter (List<Data> listUser){
        this.userList = listUser;
    }

    @Override
    public TodoAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_data, parent, false);
        return new ViewHolder(view);
    }

    public void add(Data user){
        userList.add(user);
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(TodoAdapter.ViewHolder holder, int position) {
        Data user = userList.get(position);
        holder.tvNama.setText(user.getName());
        holder.tvDes.setText(user.getDeskripsi());
        holder.tvJumlah.setText(user.getJumlah());
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }
}
