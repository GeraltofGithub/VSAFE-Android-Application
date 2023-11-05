package com.example.vscan1;

import androidx.recyclerview.widget.RecyclerView;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import java.util.ArrayList;
import java.util.List;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
    private Context context;
    private List<DataClass> dataList;
    public MyAdapter(Context context, List<DataClass> dataList) {
        this.context = context;
        this.dataList = dataList;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyler_item, parent, false);
        return new MyViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Glide.with(context).load(dataList.get(position).getDataimg()).into(holder.Image);
        holder.name.setText(dataList.get(position).getDataname());
        holder.phone.setText(dataList.get(position).getDataphoneno());
        holder.recCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("Image", dataList.get(holder.getAdapterPosition()).getDataimg());
                intent.putExtra("Contact No.", dataList.get(holder.getAdapterPosition()).getDataphoneno());
                intent.putExtra("Name", dataList.get(holder.getAdapterPosition()).getDataname());
                intent.putExtra("Key",dataList.get(holder.getAdapterPosition()).getKey());
                context.startActivity(intent);
            }
        });
    }
    @Override
    public int getItemCount() {
        return dataList.size();
    }
    public void searchDataList(ArrayList<DataClass> searchList){
        dataList = searchList;
        notifyDataSetChanged();
    }

}
class MyViewHolder extends RecyclerView.ViewHolder {
    ImageView Image;
    TextView name,phone;
    CardView recCard;
    public MyViewHolder(View itemView){
        super(itemView);
        Image = itemView.findViewById(R.id.recImage);
        recCard = itemView.findViewById(R.id.recCard);
        name = itemView.findViewById(R.id.recName);
        phone = itemView.findViewById(R.id.recNum);
}
}
