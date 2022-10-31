package com.example.lakes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class CostAdapter extends RecyclerView.Adapter<CostAdapter.mViewHolder> {
    Context context;
    int r,t,k,g,h,j;
    Double tr1,tr2,tr3;
    String pl1,pl2,pl3;
    String[] fg={"Mango","Lemon","JackFruit","Guava","Coconut","Litchi","Orange","WoodApple","Tamarind"};
    int[] er;
    double[] euria ={280,225,300,230,180,230,236,180,200};
    double[] phos={100,180,130,100,40,100,113,80,80};
    double[] potash={180,200,300,250,400,100,113,150,250};
    double [] sulfer={24,30,30,15,36,18,27,18,10};
    double [] zn={5,8,0,0,13,0,4,0,0};
    double [] B={ 3.0,2.5,1,0,2.6,5,1.5,0,0};
    double [] cd={40,20,30,25,15,15,18,18,20};
    double [] cost={0.7,0.5,0.85,0.32,2.25,0.24,5};
    double t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,q1,c1,c2,c3,c4,c5,c6,c7;

   int i;
    public CostAdapter(Context context ,String pl1, String pl2, String pl3,int r,int t,int k,int g,int h,int j,int i )
    {
        this.context=context;
        this.pl1=pl1;
        this.pl2=pl2;
        this.pl3=pl3;

        this.r=r;
        this.t=t;
        this.k=k;
        this.g=g;
        this.h=h;
        this.j=j;
        this.i=i;
    }
        @NonNull
    @Override
    public mViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        View ret= layoutInflater.inflate(R.layout.activity_cost,parent,false);
        return new mViewHolder(ret);
    }

    @Override
    public void onBindViewHolder(@NonNull mViewHolder holder, int position) {
         tr1=Double.parseDouble(String.valueOf(r));

         tr2=Double.parseDouble(String.valueOf(t));
         tr3=Double.parseDouble(String.valueOf(k));
        if(position==0) {

            t1=tr1*euria[g];
            t2=tr1*phos[g];
            t3=tr1*B[g];
            t4= tr1*potash[g];
            t6=tr1*zn[g];
            t7=tr1*sulfer[g];
            t5=tr1*cd[g];
            c1=t1*cost[0];
            c2=t2*cost[1];
            c3=t4*cost[2];
            c4=t7*cost[3];
            c5=t6*cost[4];
            c6=t3*cost[5];
            c7=t5*cost[6];

            double sum=c1+c2+c3+c4+c5+c6+c7;
            holder.name1.setText(new StringBuilder().append(pl1));
            holder.count1.setText(new StringBuilder().append(tr1));
            holder.tte.setText(new StringBuilder().append(String.valueOf(t1)));
            holder.ttph.setText(new StringBuilder().append(String.valueOf(t2)));
            holder.ttb.setText(new StringBuilder().append(String.valueOf(t3)));
            holder.ttp.setText(new StringBuilder().append(String.valueOf(t4)));
            holder.ttc.setText(new StringBuilder().append(String.valueOf(t5)));
            holder.ttzn.setText(new StringBuilder().append(String.valueOf(t6)));
            holder.tts.setText(new StringBuilder().append(String.valueOf(t7)));
            holder.costc.setText(new StringBuilder().append(String.valueOf(c7)));
            holder.coste.setText(new StringBuilder().append(String.valueOf(c1)));
            holder.costph.setText(new StringBuilder().append(String.valueOf(c2)));
            holder.costb.setText(new StringBuilder().append(String.valueOf(c6)));
            holder.costp.setText(new StringBuilder().append(String.valueOf(c3)));
            holder.costzn.setText(new StringBuilder().append(String.valueOf(c5)));
            holder.costs.setText(new StringBuilder().append(String.valueOf(c4)));
            holder.tve.setText(new StringBuilder().append(String.valueOf(euria[g])));
            holder.tvc.setText(new StringBuilder().append(String.valueOf(phos[g])));
            holder.tvph.setText(new StringBuilder().append(String.valueOf(B[g])));
            holder.tvb.setText(new StringBuilder().append(String.valueOf(potash[g])));
            holder.tvp.setText(new StringBuilder().append(String.valueOf(cd[g])));
            holder.tvzn.setText(new StringBuilder().append(String.valueOf(zn[g])));
            holder.tvs.setText(new StringBuilder().append(String.valueOf(sulfer[g])));
            holder.total.setText(new StringBuilder().append(String.valueOf(sum)));


        }
        if(position==1) {

            t1=tr2*euria[h];
            t2=tr2*phos[h];
            t3=tr2*B[h];
            t4= tr2*potash[h];
            t6=tr2*zn[h];
            t7=tr2*sulfer[h];
            t5=tr2*cd[h];
            c1=t1*cost[0];
            c2=t2*cost[1];
            c3=t4*cost[2];
            c4=t7*cost[3];
            c5=t6*cost[4];
            c6=t3*cost[5];
            c7=t5*cost[6];
            double sum=c1+c2+c3+c4+c5+c6+c7;
            holder.count1.setText(new StringBuilder().append(tr2));
            holder.name1.setText(new StringBuilder().append(pl2));
            holder.tte.setText(new StringBuilder().append(String.valueOf(t1)));
            holder.ttph.setText(new StringBuilder().append(String.valueOf(t2)));
            holder.ttb.setText(new StringBuilder().append(String.valueOf(t3)));
            holder.ttp.setText(new StringBuilder().append(String.valueOf(t4)));
            holder.ttc.setText(new StringBuilder().append(String.valueOf(t5)));
            holder.ttzn.setText(new StringBuilder().append(String.valueOf(t6)));
            holder.tts.setText(new StringBuilder().append(String.valueOf(t7)));
            holder.costc.setText(new StringBuilder().append(String.valueOf(c7)));
            holder.coste.setText(new StringBuilder().append(String.valueOf(c1)));
            holder.costph.setText(new StringBuilder().append(String.valueOf(c2)));
            holder.costb.setText(new StringBuilder().append(String.valueOf(c6)));
            holder.costp.setText(new StringBuilder().append(String.valueOf(c3)));
            holder.costzn.setText(new StringBuilder().append(String.valueOf(c5)));
            holder.costs.setText(new StringBuilder().append(String.valueOf(c4)));
            holder.tve.setText(new StringBuilder().append(String.valueOf(euria[h])));
            holder.tvc.setText(new StringBuilder().append(String.valueOf(phos[h])));
            holder.tvph.setText(new StringBuilder().append(String.valueOf(B[h])));
            holder.tvb.setText(new StringBuilder().append(String.valueOf(potash[h])));
            holder.tvp.setText(new StringBuilder().append(String.valueOf(cd[h])));
            holder.tvzn.setText(new StringBuilder().append(String.valueOf(zn[h])));
            holder.tvs.setText(new StringBuilder().append(String.valueOf(sulfer[h])));
            holder.total.setText(new StringBuilder().append(String.valueOf(sum)));
            sum=0;

        }
        if(position==2) {

            t1=tr3*euria[j];
            t2=tr3*phos[j];
            t3=tr3*B[j];
            t4= tr3*potash[j];
            t6=tr3*zn[j];
            t7=tr3*sulfer[j];
            t5=tr3*cd[j];
            c1=t1*cost[0];
            c2=t2*cost[1];
            c3=t4*cost[2];
            c4=t7*cost[3];
            c5=t6*cost[4];
            c6=t3*cost[5];
            c7=t5*cost[6];
            double sum=c1+c2+c3+c4+c5+c6+c7;
            holder.name1.setText(new StringBuilder().append(pl3));
            holder.count1.setText(new StringBuilder().append(tr3));
            holder.tte.setText(new StringBuilder().append(String.valueOf(t1)));
            holder.ttph.setText(new StringBuilder().append(String.valueOf(t2)));
            holder.ttb.setText(new StringBuilder().append(String.valueOf(t3)));
            holder.ttp.setText(new StringBuilder().append(String.valueOf(t4)));
            holder.ttc.setText(new StringBuilder().append(String.valueOf(t5)));
            holder.ttzn.setText(new StringBuilder().append(String.valueOf(t6)));
            holder.tts.setText(new StringBuilder().append(String.valueOf(t7)));
            holder.costc.setText(new StringBuilder().append(String.valueOf(c7)));
            holder.coste.setText(new StringBuilder().append(String.valueOf(c1)));
            holder.costph.setText(new StringBuilder().append(String.valueOf(c2)));
            holder.costb.setText(new StringBuilder().append(String.valueOf(c6)));
            holder.costp.setText(new StringBuilder().append(String.valueOf(c3)));
            holder.costzn.setText(new StringBuilder().append(String.valueOf(c5)));
            holder.costs.setText(new StringBuilder().append(String.valueOf(c4)));
            holder.tve.setText(new StringBuilder().append(String.valueOf(euria[j])));
            holder.tvc.setText(new StringBuilder().append(String.valueOf(phos[j])));
            holder.tvph.setText(new StringBuilder().append(String.valueOf(B[j])));
            holder.tvb.setText(new StringBuilder().append(String.valueOf(potash[j])));
            holder.tvp.setText(new StringBuilder().append(String.valueOf(cd[j])));
            holder.tvzn.setText(new StringBuilder().append(String.valueOf(zn[j])));
            holder.tvs.setText(new StringBuilder().append(String.valueOf(sulfer[j])));
            holder.total.setText(new StringBuilder().append(String.valueOf(sum)));
sum=0;

        }

    }
    @Override
    public int getItemCount() {
        return 3;
    }

    public  class mViewHolder extends RecyclerView.ViewHolder {
       // TextView tvp,ttp,tup,tvc,ttc,tuc,tvph,ttph,tuph,tvs,tts,tus,tvzn,ttzn,tuzn,tvb,ttb,tub,tve,tte,tue;
        @BindView(R.id.tree)
        TextView tree;



        @BindView(R.id.name1)
        TextView name1;
        @BindView(R.id.count1)
        TextView count1;
       @BindView(R.id.vp)
       TextView tvp;
       @BindView(R.id.tp)
        TextView ttp;
        @BindView(R.id.vs)
        TextView tvs;
       @BindView(R.id.tb)
       TextView ttb;
     @BindView(R.id.costc)
  TextView costc;
     @BindView(R.id.costb)
             TextView costb;
     @BindView(R.id.costph)
             TextView costph;
     @BindView(R.id.costzn)
             TextView costzn;
     @BindView(R.id.coste)
     TextView coste;
     @BindView(R.id.costp)
     TextView costp;
        @BindView(R.id.costs)
        TextView costs;

        @BindView(R.id.total)
        TextView total;


     @BindView(R.id.vc)
        TextView tvc;
        @BindView(R.id.tc)
        TextView ttc;

        @BindView(R.id.vph)
        TextView tvph;
        @BindView(R.id.tph)
        TextView ttph;

        @BindView(R.id.ts)
        TextView tts;

        @BindView(R.id.vz)
        TextView tvzn;
        @BindView(R.id.tz)
        TextView ttzn;

        @BindView(R.id.vb)
        TextView tvb;


        @BindView(R.id.ve)
        TextView tve;
        @BindView(R.id.te)
        TextView tte;

        Unbinder unbinder;
        public mViewHolder(@NonNull View itemView) {
            super(itemView);
      unbinder= ButterKnife.bind(this,itemView);
        }
    }
}