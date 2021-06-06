package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

import java.net.URL;

public class Info2Activity extends AppCompatActivity{

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info2);

        TextView txtDog1 = (TextView)findViewById(R.id.txtInfo2Text);
        TextView txtDog2 = (TextView)findViewById(R.id.txtInfo2Text2);
        TextView txtDog3 = (TextView)findViewById(R.id.txtInfo2Text3);
        TextView txtDog4 = (TextView)findViewById(R.id.txtInfo2Text4);
        TextView txtDog5 = (TextView)findViewById(R.id.txtInfo2Text5);

        TextView txtCat1 = (TextView)findViewById(R.id.txtInfo2Cat1);
        TextView txtCat2 = (TextView)findViewById(R.id.txtInfo2Cat2);
        TextView txtCat3 = (TextView)findViewById(R.id.txtInfo2Cat3);
        TextView txtCat4 = (TextView)findViewById(R.id.txtInfo2Cat4);
        TextView txtCat5 = (TextView)findViewById(R.id.txtInfo2Cat5);

        Button Back = (Button)findViewById(R.id.btnInfo2Back);

        //예방접종
        txtDog1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String url = "https://mypetlife.co.kr/102248/";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }
        });

        //입양 후 해야할 10가지
        txtDog2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String url = "https://mypetlife.co.kr/44186/";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }
        });

        //간식 고르는법
        txtDog3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String url = "https://mypetlife.co.kr/28871/";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }
        });

        //밥그릇 고르는법
        txtDog4.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String url = "https://mypetlife.co.kr/27174/";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }
        });

        //반려견이 아플때 보이는 행동
        txtDog5.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String url = "https://mypetlife.co.kr/18201/";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }
        });

        //고양이를 잘 키우는 5가지 방법
        txtCat1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String url = "https://mypetlife.co.kr/87071/";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }
        });

        //고양이를 스트레스 받게하는 12가지 행동
        txtCat2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String url = "https://mypetlife.co.kr/84677/";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }
        });

        //고양이 화장실 모래
        txtCat3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String url = "https://mypetlife.co.kr/78851/";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }
        });

        //새끼고양이 입양 시 8가지 팁
        txtCat4.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String url = "https://mypetlife.co.kr/47410/";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }
        });

        //고양이 사료 적정 급여
        txtCat5.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String url = "https://mypetlife.co.kr/37814/";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }
        });

        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), InfoActivity.class);
                startActivity(intent);
                finish();
            }
        });
    } // onCreate 닫기

}
