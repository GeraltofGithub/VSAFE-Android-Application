package com.example.vscan1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    TextView detname,detphone;
    ImageView detimg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        detname = findViewById(R.id.namedet);
        detphone = findViewById(R.id.contactnumdet);
        detimg = findViewById(R.id.detailImage);

        Bundle bundle = getIntent().getExtras();
        if(bundle!=null){
            detname.setText(bundle.getString("Name"));
            detphone.setText(bundle.getString("Contact No."));
            Glide.with(this).load(bundle.getString("Image")).into(detimg);
        }
    }
}