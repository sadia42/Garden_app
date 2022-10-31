package com.example.lakes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;

public class MainActivity3 extends AppCompatActivity {
    TextView tvp,ttp,tvc,ttc,tvph,ttph,tvs,tts,tvzn,ttzn,tvb,ttb,tve,tte,svp,stp,svc,
            stc,svph,stph,svs,sts,svzn,stzn,svb,stb,sve,ste,fvp,ftp,fvc,
            ftc,fvph,ftph,fvs,fts,fvzn,ftzn,fvb,ftb,fve,fte,n1;
    int r,t,k;
    String pl1,pl2,pl3;
    String[] fg={"Mango","Lemon","JackFruit","Guava","Coconut","Litchi","Orange"};

    double[] euria ={280,225,300,230,180,230,236};
    double[] phos={100,180,130,100,40,100,113};
    double[] potash={180,200,300,250,400,100,113};
    double [] sulfer={24,30,30,15,36,18,27};
    double [] zn={5,8,0,0,13,0,4};
    double [] B={ 3.0, 2.5,1,0, 2.6,5,1.5};
    double [] cd={40,20,30,25,15,15,18};

    int g,h,j;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        tvp=(TextView) findViewById(R.id.vp);ttp=(TextView) findViewById(R.id.tp);
        tvc=(TextView) findViewById(R.id.vc);ttc=(TextView) findViewById(R.id.tc);
      tvph=(TextView) findViewById(R.id.vph);ttph=(TextView) findViewById(R.id.tph);
        tvs=(TextView) findViewById(R.id.vs);tts=(TextView) findViewById(R.id.ts);
       tvzn=(TextView) findViewById(R.id.vz);ttzn=(TextView) findViewById(R.id.tz);
       tvb=(TextView) findViewById(R.id.vb);ttb=(TextView) findViewById(R.id.tb);
        tve=(TextView) findViewById(R.id.ve);tte=(TextView) findViewById(R.id.te);
        svp=(TextView) findViewById(R.id.svp);stp=(TextView) findViewById(R.id.stp);
        svc=(TextView) findViewById(R.id.svc);stc=(TextView) findViewById(R.id.stc);
        svph=(TextView) findViewById(R.id.svph);stph=(TextView) findViewById(R.id.stph);
        svs=(TextView) findViewById(R.id.svs);sts=(TextView) findViewById(R.id.sts);
        svzn=(TextView) findViewById(R.id.svz);stzn=(TextView) findViewById(R.id.stz);
        svb=(TextView) findViewById(R.id.svb);stb=(TextView) findViewById(R.id.stb);
       sve=(TextView) findViewById(R.id.sve);ste=(TextView) findViewById(R.id.ste);
       fvp=(TextView) findViewById(R.id.fvp);ftp=(TextView) findViewById(R.id.ftp);
        fvc=(TextView) findViewById(R.id.fvc);ftc=(TextView) findViewById(R.id.ftc);
        fvph=(TextView) findViewById(R.id.fvph);ftph=(TextView) findViewById(R.id.ftph);
        fvs=(TextView) findViewById(R.id.fvs);fts=(TextView) findViewById(R.id.fts);
        fvzn=(TextView) findViewById(R.id.fvz);ftzn=(TextView) findViewById(R.id.ftz);
       fvb=(TextView) findViewById(R.id.fvb);ftb=(TextView) findViewById(R.id.ftb);
       fve=(TextView) findViewById(R.id.fve);fte=(TextView) findViewById(R.id.fte);
       n1=(TextView) findViewById(R.id.ne);
        Bundle bundle=getIntent().getExtras();
        if(bundle!=null)
        {
            r=bundle.getInt("y");
            t=bundle.getInt("te");
            k=bundle.getInt("ry");

            g=bundle.getInt("a");
            h=bundle.getInt("b");
            j=bundle.getInt("c");


        }
        double tr1,tr2,tr3,t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,q1,q2,q3,q4,q5,q6,q7,q8,q9,q10,w1;
        tr1=Double.parseDouble(String.valueOf(r));
        tr2=Double.parseDouble(String.valueOf(t));
        tr3=Double.parseDouble(String.valueOf(k));
        n1.setText(pl1);
        tr1=tr1+1;
        t1=tr1*euria[g];
        t2=tr1*phos[g];
        t3=tr1*B[g];
        t4= tr1*potash[g];
        t5=tr1*cd[g];
        t6=tr1*zn[g];
        t7=tr1*sulfer[g];
        String euriacost =String.valueOf(t1);
        tte.setText(euriacost);
        String cdcost =String.valueOf(t5);
        ttc.setText(cdcost);
        String phoscost =String.valueOf(t2);
        ttph.setText(phoscost);
        String bcost =String.valueOf(t3);
        ttb.setText(bcost);
        String potcost =String.valueOf(t4);
        ttp.setText(potcost);
        String zncost =String.valueOf(t6);
        ttzn.setText(zncost);
        String sulcost =String.valueOf(t7);
        tts.setText(sulcost);

        String euriaamo =String.valueOf(euria[g]);
        tve.setText(euriaamo);
        String cdamo =String.valueOf(cd[g]);
        tvc.setText(cdamo);
        String phosamo =String.valueOf(phos[g]);
        tvph.setText(phosamo);
        String bamo =String.valueOf(B[g]);
        tvb.setText(bamo);
        String potamo =String.valueOf(potash[g]);
        tvp.setText(potamo);
        String znamo =String.valueOf(zn[g]);
        tvzn.setText(znamo);
        String sulamo =String.valueOf(sulfer[g]);
        tvs.setText(sulamo);

        sve.setText(String.valueOf(euria[h]));
        svc.setText(String.valueOf(phos[h]));   svph.setText(String.valueOf(B[h]));   svb.setText(String.valueOf(potash[h]));
        svp.setText(String.valueOf(cd[h]));    svzn.setText(String.valueOf(zn[h]));    svs.setText(String.valueOf(sulfer[h]));

        tr2=tr2+1;
        t8=tr2*euria[h];
        t9=tr2*phos[h];
        t10=tr2*B[h];
        q1= tr2*potash[h];
        q2=tr2*cd[h];
        q3=tr2*zn[h];
        q4=tr2*sulfer[h];
        ste.setText(String.valueOf(t8));
        stc.setText(String.valueOf(t9));   stph.setText(String.valueOf(t10));   stb.setText(String.valueOf(q1));
        stp.setText(String.valueOf(q2));    stzn.setText(String.valueOf(q3));    sts.setText(String.valueOf(q4));



    }
}