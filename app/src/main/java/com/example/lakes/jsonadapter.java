package com.example.lakes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class jsonadapter extends RecyclerView.Adapter <RecyclerView.ViewHolder> {
   private static final int TYPE=1;
   private final Context context;
   private final List<Object> listrecycleritem;

    public jsonadapter(Context context,List<Object> listrecycleritem) {
        this.context=context;
        this.listrecycleritem = listrecycleritem;
    }
    public class ItemViewHolder extends RecyclerView.ViewHolder
    {
            private TextView name;
            private TextView info;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            name=(TextView)itemView.findViewById(R.id.name);
            info=(TextView)itemView.findViewById(R.id.info);

        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         switch(viewType)
         {
             case TYPE:
             default:
                 View layoutView= LayoutInflater.from(parent.getContext()).inflate(
                         R.layout.list_item,parent,false);
                 return new ItemViewHolder(layoutView);
         }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
     int viewType=getItemViewType(position);
switch(viewType)
{
    case TYPE:
        default:
            ItemViewHolder itemHolder=(ItemViewHolder) holder;
            rectree RTree = (rectree) listrecycleritem.get(position);

       itemHolder.name.setText(RTree.getName());
       itemHolder.info.setText(RTree.getInfo());

}

    }

    @Override
    public int getItemCount() {

        return listrecycleritem.size();
    }
}
