package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class InfoActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);


        EditText edtInfoKind = (EditText)findViewById(R.id.edtInfoKind);
        Button btnInfoSearch = (Button)findViewById(R.id.btnInfoSearch);
        ImageButton btnInfoOpenSite = (ImageButton)findViewById(R.id.btnInfoOpenSite);
        ImageButton btnInfoOpenVideo = (ImageButton)findViewById(R.id.btnInfoOpenVideo);
        TextView txtMoreInfo = (TextView)findViewById(R.id.txtInfo2More);

        btnInfoSearch.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String url = "https://mypetlife.co.kr/wiki/" + edtInfoKind.getText().toString() + "/";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }
        });

        btnInfoOpenSite.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), Info2Activity.class);
                startActivity(intent);
            }
        });

        btnInfoOpenVideo.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String url = "https://www.youtube.com/watch?v=pvjr0h2-HnE";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }
        });

        txtMoreInfo.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String url = "https://mypetlife.co.kr/";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }
        });

    }
}
