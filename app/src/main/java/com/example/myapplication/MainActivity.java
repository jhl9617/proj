package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.icu.text.DateFormat;
import android.icu.text.SimpleDateFormat;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.BufferedInputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //검색화면으로 이동
        Button btnMainGoSearch = (Button)findViewById(R.id.btnMainGoSearch);
        btnMainGoSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SubActivity.class);
                startActivity(intent);
                finish();
            }
        });

        Button btnMainGoInfo = (Button)findViewById(R.id.btnMainGoInfo);
        btnMainGoInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), InfoActivity.class);
                startActivity(intent);
            }
        });
        ImageView imgMainAnimal = (ImageView)findViewById(R.id.imgMainAnimal);
        TextView txtMainDate = (TextView)findViewById(R.id.txtMainDate);
        TextView txtMainKind = (TextView)findViewById(R.id.txtMainKind);
        TextView txtMainAge = (TextView)findViewById(R.id.txtMainAge);

        StrictMode.enableDefaults();

        boolean isFilename = false, isNoticeEdt = false, isKindCd = false, isAge= false;
        String filename = null;
        String noticeEdt = null;
        String kindCd = null;
        String age = null;

        //오늘 날짜를 default로 검색
        Calendar cal = Calendar.getInstance();
        Date today = new Date();
        SimpleDateFormat date = new SimpleDateFormat("yyyyMMdd");
        cal.setTime(today);
        cal.add(Calendar.DATE, -20);
        String DeadDate = String.valueOf(date.format(cal.getTime()));

        String defaultDate = date.format(today); //오늘 날짜
        String kotoshi = defaultDate.substring(0,3); // 올해연도인 2021을 가짐


        //안락사 예정 마리수 구현
        String deadCount = null;
        boolean isdeadCount = false;

        TextView txtDeadCount = (TextView)findViewById(R.id.txtMainDeadCount);

        try{
            URL url = new URL("http://openapi.animal.go.kr/openapi/service/rest/abandonmentPublicSrvc/abandonmentPublic?bgnde=" + DeadDate + "&endde=" + DeadDate + "&pageNo=1&numOfRows=10&ServiceKey=yNSywHmSDzLWzmZfiXeGNkoJ7k8FEf%2BmaGkUW4A9caeiJDuEckp%2B7NPmuCc1iVfguBQCau25vanKExLXSZsB4Q%3D%3D");

            XmlPullParserFactory parserCreator = XmlPullParserFactory.newInstance();
            XmlPullParser parser = parserCreator.newPullParser();

            parser.setInput(url.openStream(), null);

            int parserEvent = parser.getEventType();

            while(parserEvent != XmlPullParser.END_DOCUMENT){
                switch(parserEvent)
                {
                    case XmlPullParser.START_TAG:
                        if(parser.getName().equals("totalCount"))
                            isdeadCount = true;
                        if(parser.getName().equals("filename"))
                            isFilename = true;
                        if(parser.getName().equals("kindCd"))
                            isKindCd = true;
                        if(parser.getName().equals("age"))
                            isAge = true;
                        if(parser.getName().equals("noticeEdt"))
                            isNoticeEdt = true;
                        break;

                    case XmlPullParser.TEXT:
                        if(isdeadCount)
                        {
                            deadCount = parser.getText();
                            isdeadCount = false;
                        }
                        if(isFilename)
                        {
                            filename = parser.getText();
                            isFilename = false;
                        }

                        if(isNoticeEdt)
                        {
                            noticeEdt = parser.getText();
                            isNoticeEdt = false;
                        }

                        if(isKindCd)
                        {
                            kindCd = parser.getText();
                            isKindCd = false;
                        }

                        if(isAge)
                        {
                            age = parser.getText();
                            age = age.substring(0,3);
                            isAge = false;
                        }
                        break;

                    case XmlPullParser.END_TAG:
                        if(parser.getName().equals("item")){
                            //이미지 삽입
                            URL url1 = new URL(filename);
                            URLConnection conn1 = url1.openConnection();
                            BufferedInputStream bis1 = new BufferedInputStream(conn1.getInputStream());
                            Bitmap bm1 = BitmapFactory.decodeStream(bis1);
                            bis1.close();
                            imgMainAnimal.setImageBitmap(bm1);


                            //안락사 예정일 공고
                            String notice = noticeEdt.substring(4, 6) + "월 " + noticeEdt.substring(6, 8) + "일";
                            txtMainDate.setText(notice);

                            //나이
                            Integer realAge = Integer.parseInt(kotoshi) - Integer.parseInt(age) + 1;
                            String rAge = "나이 : " + String.valueOf(realAge) + "세";
                            txtMainAge.setText(rAge);

                            //품종
                            Integer idx = kindCd.indexOf("]");
                            txtMainKind.setText(kindCd.substring(idx + 1));

                        }

                        if(parser.getName().equals("body")){
                            String abc = deadCount + "마리";
                            txtDeadCount.setText(abc);
                        }
                        break;
                }
                parserEvent = parser.next();
            }

        }catch(Exception e){

        }

    }
}