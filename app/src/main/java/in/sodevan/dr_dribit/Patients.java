package in.sodevan.dr_dribit;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Patients extends AppCompatActivity {

    FirebaseDatabase database ;
    DatabaseReference reference ;
    private ArrayList<FireObject> al  ;
    Lvadapter adapter ;
    RecyclerView rv ;





    public void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patients);

        rv= (RecyclerView)findViewById(R.id.rv);

        al = new ArrayList<>() ;
        adapter = new Lvadapter(al , getApplication()) ;
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        rv.setLayoutManager(mLayoutManager);
        rv.setAdapter(adapter);

        database  = FirebaseDatabase.getInstance();
        reference = database.getReference("doctor").child("Dr Rajeev Bhatt").child("patients");


        ValueEventListener postListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot dfg : dataSnapshot.getChildren()){

                     String Name =dfg.getKey() ;
                    FireObject ju = dfg.getValue(FireObject.class) ;
                    Log.d("TAG",ju.getWeight().toString());

                    al.add(ju);
                    adapter.notifyDataSetChanged();


                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };



        reference.addValueEventListener(postListener);

    }






    public class Lvadapter extends RecyclerView.Adapter<Lvadapter.ViewHolder>{

        private ArrayList<FireObject> al  ;
        Context c;

        public class ViewHolder extends RecyclerView.ViewHolder {

            public TextView name  , agen , suffer ;



            public ViewHolder(View itemView) {
                super(itemView);
                name = (TextView) itemView.findViewById(R.id.name) ;
                agen = (TextView) itemView.findViewById(R.id.gender) ;
                suffer = (TextView)itemView.findViewById(R.id.suffer);


            }
        }

        public Lvadapter(ArrayList<FireObject> al , Context c) {
            this.c= c;
            this.al = al;
        }



        @Override
        public Lvadapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_child , parent  , false) ;
            return new Lvadapter.ViewHolder(v);
        }



        @Override
        public void onBindViewHolder(final Lvadapter.ViewHolder holder, final int position) {
            final  FireObject o = al.get(position) ;
            holder.name.setText("Piyush Gupta");
            holder.agen.setText(o.getGender()+" (" +o.getAge()+" )");

            if (o.getAge()==20) {
                holder.name.setText("Ronak Sakhuja");
                holder.suffer.setText("Acute Pyraxia");
            }

            holder.name.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                  showinfo( o ) ;

                }
            });

        }

        @Override
        public int getItemCount() {
            return al.size();
        }

        private void setScaleAnimation(View view) {
            ScaleAnimation anim = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
            anim.setDuration(260);
            view.startAnimation(anim);
        }

    }

    void showinfo(FireObject o ){
        Intent change = new Intent(getApplicationContext() ,patientinfo.class );
        change.putExtra("name" , "Piyush Gupta") ;
        change.putExtra("Gender" , o.getGender()) ;
        change.putExtra("age" , o.getAge()) ;
        change.putExtra("DailySteps" , o.getDailySteps()) ;
        change.putExtra("weight" , o.getWeight()) ;
        change.putExtra("water-unit" , o.getWaterUnit()) ;
        change.putExtra("map",o.getHeartbeat());
        startActivity(change);
    }


}