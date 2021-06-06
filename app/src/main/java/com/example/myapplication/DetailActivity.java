package com.example.myapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedInputStream;
import java.net.URL;
import java.net.URLConnection;

public class DetailActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_detail);

        //데이터 받기
        Intent intent = getIntent();
        String image = intent.getStringExtra("Image");
        String Date = intent.getStringExtra("Date");
        String Kind = intent.getStringExtra("Kind");
        String Age = intent.getStringExtra("Age");
        String State = intent.getStringExtra("State");
        String Color = intent.getStringExtra("Color");
        String HappenPlace = intent.getStringExtra("HappenPlace");
        String CareNm = intent.getStringExtra("Care");
        String CareTel = intent.getStringExtra("Caretel");
        String Sex = intent.getStringExtra("Sex");
        String Neuter = intent.getStringExtra("Neuter");

        //레이아웃 변수 선언
        ImageView imgDetailAnimal = (ImageView)findViewById(R.id.imgDetailAnimal);
        ImageView imgDetailSex = (ImageView)findViewById(R.id.imgDetailSex);
        TextView DateValue = (TextView)findViewById(R.id.txtDetailDateValue);
        TextView FeatureValue = (TextView)findViewById(R.id.txtDetailFeatureValue);
        TextView StateValue = (TextView)findViewById(R.id.txtDetailStateValue);
        TextView PlaceValue = (TextView)findViewById(R.id.txtDetailHappenPlaceValue);
        TextView CareValue = (TextView)findViewById(R.id.txtDetailInfoProtectValue);
        TextView NeuterValue = (TextView)findViewById(R.id.txtDetailNeutValue);
        Button btnFinish = (Button)findViewById(R.id.btnDetailFinish);

        //특징 / 보호소 텍스트 설정
        String Feature = Kind + " " + Age + " " + Color;
        String CareInfo = CareNm + " [" + CareTel + "]";


        try{
            //이미지 세팅
            URL url1 = new URL(image);
            URLConnection conn1 = url1.openConnection();
            BufferedInputStream bis1 = new BufferedInputStream(conn1.getInputStream());
            Bitmap bm1 = BitmapFactory.decodeStream(bis1);
            bis1.close();
            imgDetailAnimal.setImageBitmap(bm1);

            //텍스트 세팅
            DateValue.setText(Date);
            FeatureValue.setText(Feature);
            StateValue.setText(State);
            PlaceValue.setText(HappenPlace);
            CareValue.setText(CareInfo);
            NeuterValue.setText(Neuter);

            //성별에 따른 이미지 설정
            switch(Sex)
            {
                case "M":
                    imgDetailSex.setImageResource(R.drawable.male);;
                    break;
                case "F":
                    imgDetailSex.setImageResource(R.drawable.female);
                    break;
                case "Q":
                    imgDetailSex.setImageResource(R.drawable.none);;
                    break;
            }

        }catch(Exception e){

        }

        //닫기버튼 시 종료
        btnFinish.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                finish();
            }
        });

    }
}
