package com.example.bimzz.resepmakanan;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

/**
 * Created by bimzz on 25/11/17.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.myOwnHolder> {
    String data1[],data2[];
    int img[];
    Context ctx;
    JSONArray arrayMasak;
    Intent resepLengkap;
    public Adapter(Context ct, String s1[], String s2[], int i1[], JSONArray arrayResep){
        data1 = s1;
        data2 = s2;
        img = i1;
        ctx=ct;
        arrayMasak=arrayResep;

    }
    @Override
    public myOwnHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater myInflater = LayoutInflater.from(ctx);
        View myOwnView = myInflater.inflate(R.layout.list,parent,false);
        return new myOwnHolder(myOwnView);
    }

    @Override
    public void onBindViewHolder(final myOwnHolder holder, final int position) {

        try {
            JSONObject resep = arrayMasak.getJSONObject(position);
            String nama= resep.get("nama").toString();
            String kategori = resep.getString("kategori");
            holder.t1.setText(nama);
            holder.t2.setText(kategori);
            holder.myImage.setImageResource(img[position]);
        } catch (JSONException e) {
            e.printStackTrace();
        }



        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resepLengkap = new Intent("com.example.bimzz.resepmakanan.Resep");
                try {
                    JSONObject resep = arrayMasak.getJSONObject(position);

                    String bumbu = resep.get("bahan").toString();
                    String cara = resep.getString("cara");
                    resepLengkap.putExtra("cara",cara);
                    resepLengkap.putExtra("bumbu",bumbu );
                    resepLengkap.putExtra("nama",resep.getString("nama"));

                } catch (JSONException e) {
                    e.printStackTrace();
                }
                ctx.startActivity(resepLengkap);

            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayMasak.length();
    }

    public class myOwnHolder extends RecyclerView.ViewHolder{

        TextView t1,t2;
        ImageView myImage;
        public RelativeLayout relativeLayout;
        public myOwnHolder(View itemView) {
            super(itemView);
            t1 = (TextView)itemView.findViewById(R.id.Nama);
            t2 = (TextView) itemView.findViewById(R.id.jenis);
            myImage = (ImageView)itemView.findViewById(R.id.myImage);
            relativeLayout = (RelativeLayout)itemView.findViewById(R.id.relativeLayout);
        }

    }
}