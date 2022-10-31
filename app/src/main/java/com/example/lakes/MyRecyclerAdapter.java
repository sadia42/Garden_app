package com.example.lakes;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.mViewHolder> {


    private static ClickListener clickListener;
     //int g;
    Context context;
    DatabaseReference deref;

String pl1,pl2,pl3;
int d1,d2,d3,j=0,m=0,n=0,p=0,pc1=0,pc2=0,pc3=0,a,b,w;
    ArrayList<Integer> bArray;
   // String gm =getIntent().getStringExtra("new");
    int[] first=new int[200];
    String[] second=new String[200];
    int [] third;
    private Uri imageuri;
    int [] image={R.drawable.mango,
            R.drawable.kol ,
            R.drawable.jack,
            R.drawable.guava,
            R.drawable.coco,
            R.drawable.litchi,
            R.drawable.orange,
            R.drawable.wda,
             R.drawable.tam1};
    String[] name ={"Mango","Lemon","JackFruit","Guava","Coconut","Litchi","Orange","WoodApple","Tamarind"};
    int[] id={0,1,2,3,4,5,6};
    int[] distance={20,10,15,17};

    public MyRecyclerAdapter(Context context ,ArrayList<Integer>bArray,String pl1,String pl2,String pl3,int a,int b,int w)
    {
        this.context=context;
        this.bArray=bArray;
        this.pl1=pl1;
        this.pl2=pl2;
        this.pl3=pl3;
        this.a=a;
        this.b=b;
        this.w=w;


    }

    @NonNull
    @Override
    public mViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        View ret= layoutInflater.inflate(R.layout.np,parent,false);
        return new mViewHolder(ret);
    }

    @Override
    public void onBindViewHolder(@NonNull mViewHolder holder, int position) {

    if (position % 2 == 0) {
        holder.txt_number.setText(new StringBuilder().append(pl1));
        for (int i = 0; i < 8; i++) {
            if (pl1.equals(name[i])) {
                holder.img.setImageResource(image[i]);

            }

        }
        first[j]=position;
        second[j]=pl1;
        pc1++;
       j++;
    } else if (position % 3 == 0) {
        holder.txt_number.setText(new StringBuilder().append(pl2));
        for (int i = 0; i < 8; i++) {
            if (pl2.equals(name[i])) {
                holder.img.setImageResource(image[i]);
            }
        }
        first[j]=position;
        second[j]=pl2;
        pc2++;
        j++;
    } else {//holder.img.setImageResource(image[i3]);
        for (int i = 0; i < 8; i++) {
            holder.txt_number.setText(new StringBuilder().append(pl3));
            if (pl3.equals(name[i])) {
                holder.img.setImageResource(image[i]);
            }
        }
        first[j]=position;
        second[j]=pl3;
        pc3++;
        j++;
    }


 //position=0;
        // holder.txt_number.setOnLongClickListener(v -> {
        //    new StringBuilder(" ");
        //return false;});
    }


    @Override
    public int getItemCount() {
        return bArray.size();

    }

    public class mViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,View.OnLongClickListener, com.example.lakes.mViewHolder {

        @BindView(R.id.txt_number)
        TextView txt_number;
        @BindView((R.id.item))
        CardView item;
        @BindView(R.id.image)
        ImageView img;

//@BindView(R.id.input)
//EditText input;

        //  @BindView(R.id.editText)
       // EditText textinput;
        //  @BindView((R.id.empty))
        // TextView empty;
        Unbinder unbinder;
        public mViewHolder(@NonNull View itemView) {
            super(itemView);
            unbinder= ButterKnife.bind(this,itemView);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }


        @Override
        public void onClick(View v) {
            AlertDialog.Builder alert = new AlertDialog.Builder(context);
             EditText input = new EditText(context);
             input.setHint("Enter Text");

             alert.setTitle("Title");
             alert.setMessage("Message");
             alert.setView(input);
             alert.setPositiveButton("Replace", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int whichButton) {
                    String f = input.getText().toString();
                    txt_number.setText(new StringBuilder().append(f));

                    int l = getAdapterPosition();
                    if(f.equals(pl1))
                            { pc1++;
                            second[l]=pl1;
                            }
                            else if(f.equals(pl2)) {
                                pc2++;
                                second[l]=pl2;

                            }
                            else {
                                pc3++;
                                second[l]=pl3;
                            }
                        }});
            alert.setNegativeButton("Remove", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int whichButton) {
                    String gh =txt_number.getText().toString();
                    int l = getAdapterPosition();
                  if(gh.equals(pl1))
                  {
                      pc1--;
                      second[l]=" ";

                  }
                  else if(gh.equals(pl2))
                  {
                      pc2--;
                      second[l]=" ";

                  }
                  else
                  {
                      pc3--;
                      second[l]=" ";

                  }
                  
                       txt_number.setText(new StringBuilder().append(" "));

                }
            });

          Intent intent=new Intent();
          intent.putExtra("k",pc1);
            intent.putExtra("m",pc2);intent.putExtra("de",pc3);
            intent.putExtra("g",second);

           // intent.putExtra("we",c1);


            alert.show();
            clickListener.onItemClick(intent);

             // txt_number.setText(new StringBuilder().append("lemon"));
           }


        @Override
        public boolean onLongClick(View v) {

             //  txt_number.setText(new StringBuilder().append("Pineapple"));


            return false;
        }

    }
    public interface ClickListener{
       void onItemClick(Intent intent);

        void onItemLongClick(int position, View v);
    }

    public void setOnItemClickListener(ClickListener clickListener)
    {
        MyRecyclerAdapter.clickListener=clickListener;

    }

}