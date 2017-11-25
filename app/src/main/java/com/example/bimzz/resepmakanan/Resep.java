package com.example.bimzz.resepmakanan;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by bimzz on 25/11/17.
 */

public class Resep extends AppCompatActivity {

    Intent resep;
    String nama;
    String cara;
    String bumbu;
    TextView namaResep;
    TextView caraTxt;
    TextView bumbuTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resep_lengkap);
        namaResep = (TextView)findViewById(R.id.namaResep);
        bumbuTxt = (TextView)findViewById(R.id.bumbuResep);
        caraTxt = (TextView)findViewById(R.id.caraResep);
        resep = getIntent();
        bumbu = resep.getStringExtra("bumbu");
        nama = resep.getStringExtra("nama");
        cara= resep.getStringExtra("cara");
        caraTxt.setText(cara);
        bumbuTxt.setText(bumbu);
        namaResep.setText(nama);

    }
}