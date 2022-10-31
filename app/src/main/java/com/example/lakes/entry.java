package com.example.lakes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.text.format.DateFormat.format;

public class entry extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.recycle_view)
    RecyclerView recyclerView;
    // ItemTouchHelper itemTouchHelper;
    //Button  swap_b;//button_id
private List<trees> treelist;

    private List<Object> itemview= new ArrayList<>();
    MyRecyclerAdapter myAdapter;
    CostAdapter  costAadapter;
    String iupd,userid,pl1,pl2,pl3,r,c,path;
    int mCols,indx=0,ho,id,lo,j,hp,mRows, der,re,d1,d2,d3,te,lp,d,in=0,size_arr;
    int a,b,w;
    File imageFile;
    int[] arr=new int[65];
    private Uri uri, imageUri;
    ArrayList<Integer> bArray=new ArrayList<>();
    int[] nArray;
    Button textView,shot,save;
    private static final int IMAGE_REQUEST=1;
    int h,indi=0;
    String[] name ={"Mango","Lemon","JackFruit","Guava","Coconut","Litchi","Orange","WoodApple","Tamarind"};
    private FirebaseAuth mAuth;
    FirebaseUser firebaseUser;
    DatabaseReference databref;
    StorageReference storef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=(Button) findViewById(R.id.txt);
        textView.setOnClickListener(this);
        shot=(Button)findViewById(R.id.keep);
        save=(Button)findViewById(R.id.load);
        verifyStoragePermission(this);

        mAuth=FirebaseAuth.getInstance();
        firebaseUser= mAuth.getCurrentUser();
        userid=firebaseUser.getUid();
        databref = FirebaseDatabase.getInstance().getReference().child("Upload").child(userid);
        storef = FirebaseStorage.getInstance().getReference("Upload");

        shot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

                takeScreenShot(getWindow().getDecorView().getRootView(), "result");
                StorageReference ref = storef.child(path);
                String imageName = "Garden" + indx;
                ref.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        Task<Uri> uriTask=taskSnapshot.getStorage().getDownloadUrl();
                        while(!uriTask.isSuccessful());
                        Uri downloadUrl=uriTask.getResult();
                        Upload upload = new Upload(indi,path, downloadUrl.toString());
                        iupd = databref.push().getKey();
                        databref.child(iupd).setValue(upload);
                        // Toast.makeText(getApplicationContext(),"Image stored")
                        indx++;
                        indi++;
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                    }
                });}  });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inte=new Intent(entry.this,savedgareen.class);
                startActivity(inte);
            }
        });






        Bundle bundle=getIntent().getExtras();


        if(bundle!=null)
        {
            pl1=bundle.getString("key");
            pl2=bundle.getString("tey");
            pl3=bundle.getString("rey");
            r=bundle.getString("row"); c=bundle.getString("column");
           a =bundle.getInt("f");
           b=bundle.getInt("s");
           w=bundle.getInt("t");
           der=bundle.getInt("qw");
        }
        int o = 0;
        ho= Integer.parseInt(c);
        lo= Integer.parseInt(r);
        mCols=ho/der;
        mRows=lo/der;

        init();
        generateItem();
    }
    private void generateItem() {
        id=1;

        for (int i = 0; i < mRows; i++) {
            for (int j = 0; j < mCols; j++) {
                //  nArray[id]=id;
                bArray.add(id);
                id++;

            }}
        // id=1;
        //   for(int i=0;i<h-1;i++)
        //  {
        // nArray[i]=id;
        //  id++;
        //  }
        myAdapter=new MyRecyclerAdapter(this,bArray,pl1,pl2,pl3,a,b,w);
        recyclerView.setAdapter(myAdapter);
        myAdapter.setOnItemClickListener(new MyRecyclerAdapter.ClickListener(){
            @Override
            public void onItemClick ( Intent intent){

                j= intent.getIntExtra("k",100);
                lp= intent.getIntExtra("m",100);
                hp= intent.getIntExtra("de",100);

/* Toast.makeText(getApplicationContext(),"first:"+j,Toast.LENGTH_LONG).show();
                  Toast.makeText(getApplicationContext(),"second:"+lp, Toast.LENGTH_LONG).show();
                     Toast.makeText(getApplicationContext(),"third:"+hp,Toast.LENGTH_LONG).show();*/



                // Toast.makeText(getApplicationContext(), "on item in b_array:" + position, Toast.LENGTH_LONG).show();
            }



            @Override
            public void onItemLongClick ( int position, View v) {

            }
        });

    }
    private void init(){
        ButterKnife.bind(this);
        recyclerView.setHasFixedSize(true);
        GridLayoutManager layoutManager=new GridLayoutManager(this,mCols);
        recyclerView.setLayoutManager(layoutManager);
    }

    @Override
    public void onClick(View v)
    {   for(int i=0;i<8;i++)
    {
        if(pl1.equals(name[i]))
        {
            d1=i;
        }
        else if(pl2.equals(name[i]))
        {
            d2=i;
        }
        else if(pl3.equals(name[i]))
        {
            d3=i;
        }
    }
    Intent th= new Intent (entry.this,trial.class);
    th.putExtra("y",j);
        th.putExtra("te",lp); th.putExtra("ry",hp);
        th.putExtra("a",d1);th.putExtra("b",d2); th.putExtra("c",d3);
        th.putExtra("n",pl1); th.putExtra("e",pl2); th.putExtra("m",pl3);
        startActivity(th);



}
protected void takeScreenShot(View view, String filename)
{
    Date date =new Date();
    CharSequence format= DateFormat.format("yyyy-mm-dd",date);
    try
    {
        String dirPath= Environment.getExternalStorageDirectory().toString()+"/GardenApp";

        File filedir=new File(dirPath);
        if(!filedir.exists()){
            boolean mkdir=filedir.mkdir();
        }
   path=dirPath+"/"+filename+"-"+format + ".jpg";
        view.setDrawingCacheEnabled(true);
        Bitmap bitmap=Bitmap.createBitmap(view.getDrawingCache());
        view.setDrawingCacheEnabled(false);
        File imageFile=new File(path);

        FileOutputStream fileOutputstream = new FileOutputStream(imageFile);
        int quality=100;

        bitmap.compress(Bitmap.CompressFormat.JPEG,quality,fileOutputstream);
       fileOutputstream.flush();
       fileOutputstream.close();
       // return imageFile;
uri=Uri.fromFile(imageFile);

    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
   // return imageFile;
}
private static final int REQUEST_EXTERNAL_STORAGE=1;
    private static String[] PERMISSION_STORAGE={
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE

};
    public static void verifyStoragePermission(Activity activity)
    {
        int permission = ActivityCompat.checkSelfPermission(activity,Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if(permission!= PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(activity,PERMISSION_STORAGE
                    ,REQUEST_EXTERNAL_STORAGE);
        }
    }


}