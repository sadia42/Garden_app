package com.example.lakes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class savedadapter extends RecyclerView.Adapter<savedadapter.MyViewHolder> {
    private Context context;
    private List<Upload> uploadList;

    public savedadapter(Context context,List<Upload> uploadList) {
        this.context=context;
        this.uploadList = uploadList;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view= layoutInflater.inflate(R.layout.listshow,parent,false);
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

Upload upload=uploadList.get(position);
//holder.text.setText(upload.getImagename());
 Glide.with(context).load(upload.getImuri()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return uploadList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView text;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.image);
            //text=itemView.findViewById(R.id.txt_number)
;

        }
    }
}