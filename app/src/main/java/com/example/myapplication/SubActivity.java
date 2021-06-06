package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.icu.text.SimpleDateFormat;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.BufferedInputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

public class SubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        StrictMode.enableDefaults();

        TextView txtTest = (TextView)findViewById(R.id.txtTest);
        TextView txtSearchResult = (TextView)findViewById(R.id.txtSearchResult);

        Intent intent = getIntent();
        Boolean dataCheck = intent.getBooleanExtra("Check", false);
        String sido = intent.getStringExtra("upr_cd");
        String gungu = intent.getStringExtra("org_cd");
        String startdate = intent.getStringExtra("noticeSdt");
        String enddate = intent.getStringExtra("noticeEdt");
        String kind = intent.getStringExtra("kindCd");
        String page = intent.getStringExtra("Page"); // 페이지 데이터


        //이미지뷰 ID
        ImageView imgSearchAnimal1 = (ImageView) findViewById(R.id.imgSearchAnimal1);
        ImageView imgSearchAnimal2 = (ImageView) findViewById(R.id.imgSearchAnimal2);
        ImageView imgSearchAnimal3 = (ImageView) findViewById(R.id.imgSearchAnimal3);
        ImageView imgSearchAnimal4 = (ImageView) findViewById(R.id.imgSearchAnimal4);
        ImageView imgSearchAnimal5 = (ImageView) findViewById(R.id.imgSearchAnimal5);
        ImageView imgSearchAnimal6 = (ImageView) findViewById(R.id.imgSearchAnimal6);
        ImageView imgSearchAnimal7 = (ImageView) findViewById(R.id.imgSearchAnimal7);
        ImageView imgSearchAnimal8 = (ImageView) findViewById(R.id.imgSearchAnimal8);
        ImageView imgSearchAnimal9 = (ImageView) findViewById(R.id.imgSearchAnimal9);
        ImageView imgSearchAnimal10 = (ImageView) findViewById(R.id.imgSearchAnimal10);

        TextView txtSearchImgString1 = (TextView) findViewById(R.id.txtSearchImgString1);
        TextView txtSearchImgString2 = (TextView) findViewById(R.id.txtSearchImgString2);
        TextView txtSearchImgString3 = (TextView) findViewById(R.id.txtSearchImgString3);
        TextView txtSearchImgString4 = (TextView) findViewById(R.id.txtSearchImgString4);
        TextView txtSearchImgString5 = (TextView) findViewById(R.id.txtSearchImgString5);
        TextView txtSearchImgString6 = (TextView) findViewById(R.id.txtSearchImgString6);
        TextView txtSearchImgString7 = (TextView) findViewById(R.id.txtSearchImgString7);
        TextView txtSearchImgString8 = (TextView) findViewById(R.id.txtSearchImgString8);
        TextView txtSearchImgString9 = (TextView) findViewById(R.id.txtSearchImgString9);
        TextView txtSearchImgString10 = (TextView) findViewById(R.id.txtSearchImgString10);

        boolean isfilename1 = false, isfilename2 = false, isfilename3 = false, isfilename4 = false, isfilename5 = false, isfilename6 = false, isfilename7 = false, isfilename8 = false, isfilename9 = false, isfilename10 = false;
        String filename1 = null, filename2 = null, filename3 = null, filename4 = null, filename5 = null, filename6 = null, filename7 = null, filename8 = null, filename9 = null, filename10 = null;

        //공고시작일 ID
        TextView txtSearchNoticeSdt1 = (TextView) findViewById(R.id.txtSearchNoticeSdt1);
        TextView txtSearchNoticeSdt2 = (TextView) findViewById(R.id.txtSearchNoticeSdt2);
        TextView txtSearchNoticeSdt3 = (TextView) findViewById(R.id.txtSearchNoticeSdt3);
        TextView txtSearchNoticeSdt4 = (TextView) findViewById(R.id.txtSearchNoticeSdt4);
        TextView txtSearchNoticeSdt5 = (TextView) findViewById(R.id.txtSearchNoticeSdt5);
        TextView txtSearchNoticeSdt6 = (TextView) findViewById(R.id.txtSearchNoticeSdt6);
        TextView txtSearchNoticeSdt7 = (TextView) findViewById(R.id.txtSearchNoticeSdt7);
        TextView txtSearchNoticeSdt8 = (TextView) findViewById(R.id.txtSearchNoticeSdt8);
        TextView txtSearchNoticeSdt9 = (TextView) findViewById(R.id.txtSearchNoticeSdt9);
        TextView txtSearchNoticeSdt10 = (TextView) findViewById(R.id.txtSearchNoticeSdt10);

        boolean isnoticeSdt1 = false, isnoticeSdt2 = false, isnoticeSdt3 = false, isnoticeSdt4 = false, isnoticeSdt5 = false, isnoticeSdt6 = false, isnoticeSdt7 = false, isnoticeSdt8 = false, isnoticeSdt9 = false, isnoticeSdt10 = false;
        String noticeSdt1 = null, noticeSdt2 = null, noticeSdt3 = null, noticeSdt4 = null, noticeSdt5 = null, noticeSdt6 = null, noticeSdt7 = null, noticeSdt8 = null, noticeSdt9 = null, noticeSdt10 = null;

        //공고종료일 Id
        TextView txtSearchNoticeEdt1 = (TextView) findViewById(R.id.txtSearchNoticeEdt1);
        TextView txtSearchNoticeEdt2 = (TextView) findViewById(R.id.txtSearchNoticeEdt2);
        TextView txtSearchNoticeEdt3 = (TextView) findViewById(R.id.txtSearchNoticeEdt3);
        TextView txtSearchNoticeEdt4 = (TextView) findViewById(R.id.txtSearchNoticeEdt4);
        TextView txtSearchNoticeEdt5 = (TextView) findViewById(R.id.txtSearchNoticeEdt5);
        TextView txtSearchNoticeEdt6 = (TextView) findViewById(R.id.txtSearchNoticeEdt6);
        TextView txtSearchNoticeEdt7 = (TextView) findViewById(R.id.txtSearchNoticeEdt7);
        TextView txtSearchNoticeEdt8 = (TextView) findViewById(R.id.txtSearchNoticeEdt8);
        TextView txtSearchNoticeEdt9 = (TextView) findViewById(R.id.txtSearchNoticeEdt9);
        TextView txtSearchNoticeEdt10 = (TextView) findViewById(R.id.txtSearchNoticeEdt10);

        boolean isnoticeEdt1 = false, isnoticeEdt2 = false, isnoticeEdt3 = false, isnoticeEdt4 = false, isnoticeEdt5 = false, isnoticeEdt6 = false, isnoticeEdt7 = false, isnoticeEdt8 = false, isnoticeEdt9 = false, isnoticeEdt10 = false;
        String noticeEdt1 = null, noticeEdt2 = null, noticeEdt3 = null, noticeEdt4 = null, noticeEdt5 = null, noticeEdt6 = null, noticeEdt7 = null, noticeEdt8 = null, noticeEdt9 = null, noticeEdt10 = null;

        //품종 Id
        TextView txtSearchKindCd1 = (TextView) findViewById(R.id.txtSearchKindCd1);
        TextView txtSearchKindCd2 = (TextView) findViewById(R.id.txtSearchKindCd2);
        TextView txtSearchKindCd3 = (TextView) findViewById(R.id.txtSearchKindCd3);
        TextView txtSearchKindCd4 = (TextView) findViewById(R.id.txtSearchKindCd4);
        TextView txtSearchKindCd5 = (TextView) findViewById(R.id.txtSearchKindCd5);
        TextView txtSearchKindCd6 = (TextView) findViewById(R.id.txtSearchKindCd6);
        TextView txtSearchKindCd7 = (TextView) findViewById(R.id.txtSearchKindCd7);
        TextView txtSearchKindCd8 = (TextView) findViewById(R.id.txtSearchKindCd8);
        TextView txtSearchKindCd9 = (TextView) findViewById(R.id.txtSearchKindCd9);
        TextView txtSearchKindCd10 = (TextView) findViewById(R.id.txtSearchKindCd10);

        boolean isKindCd1 = false, isKindCd2 = false, isKindCd3 = false, isKindCd4 = false, isKindCd5 = false, isKindCd6 = false, isKindCd7 = false, isKindCd8 = false, isKindCd9 = false, isKindCd10 = false;
        String kindCd1 = null, kindCd2 = null, kindCd3 = null, kindCd4 = null, kindCd5 = null, kindCd6 = null, kindCd7 = null, kindCd8 = null, kindCd9 = null, kindCd10 = null;

        //나이 Id
        TextView txtSearchAge1 = (TextView) findViewById(R.id.txtSearchAge1);
        TextView txtSearchAge2 = (TextView) findViewById(R.id.txtSearchAge2);
        TextView txtSearchAge3 = (TextView) findViewById(R.id.txtSearchAge3);
        TextView txtSearchAge4 = (TextView) findViewById(R.id.txtSearchAge4);
        TextView txtSearchAge5 = (TextView) findViewById(R.id.txtSearchAge5);
        TextView txtSearchAge6 = (TextView) findViewById(R.id.txtSearchAge6);
        TextView txtSearchAge7 = (TextView) findViewById(R.id.txtSearchAge7);
        TextView txtSearchAge8 = (TextView) findViewById(R.id.txtSearchAge8);
        TextView txtSearchAge9 = (TextView) findViewById(R.id.txtSearchAge9);
        TextView txtSearchAge10 = (TextView) findViewById(R.id.txtSearchAge10);

        boolean isage1 = false, isage2 = false, isage3 = false, isage4 = false, isage5 = false, isage6 = false, isage7 = false, isage8 = false, isage9 = false, isage10 = false;
        String age1 = null, age2 = null, age3 = null, age4 = null, age5 = null, age6 = null, age7 = null, age8 = null, age9 = null, age10 = null;

        //상태
        boolean isprocessState1 = false, isprocessState2 = false, isprocessState3 = false, isprocessState4 = false, isprocessState5 = false, isprocessState6 = false, isprocessState7 = false, isprocessState8 = false, isprocessState9 = false, isprocessState10 = false;
        String processState1 = null, processState2 = null, processState3 = null, processState4 = null, processState5 = null, processState6 = null, processState7 = null, processState8 = null, processState9 = null, processState10 = null;

        //색상
        //상세 정보 데이터표현을 위한 Invisible 속성 데이터 TextView 값들
        TextView txtSearchColor1 = (TextView) findViewById(R.id.txtSearchColor1);
        TextView txtSearchColor2 = (TextView) findViewById(R.id.txtSearchColor2);
        TextView txtSearchColor3 = (TextView) findViewById(R.id.txtSearchColor3);
        TextView txtSearchColor4 = (TextView) findViewById(R.id.txtSearchColor4);
        TextView txtSearchColor5 = (TextView) findViewById(R.id.txtSearchColor5);
        TextView txtSearchColor6 = (TextView) findViewById(R.id.txtSearchColor6);
        TextView txtSearchColor7 = (TextView) findViewById(R.id.txtSearchColor7);
        TextView txtSearchColor8 = (TextView) findViewById(R.id.txtSearchColor8);
        TextView txtSearchColor9 = (TextView) findViewById(R.id.txtSearchColor9);
        TextView txtSearchColor10 = (TextView) findViewById(R.id.txtSearchColor10);

        boolean iscolorCd1 = false, iscolorCd2 = false, iscolorCd3 = false, iscolorCd4 = false, iscolorCd5 = false, iscolorCd6 = false, iscolorCd7 = false, iscolorCd8 = false, iscolorCd9 = false, iscolorCd10 = false;
        String colorCd1 = null, colorCd2 = null, colorCd3 = null, colorCd4 = null, colorCd5 = null, colorCd6 = null, colorCd7 = null, colorCd8 = null, colorCd9 = null, colorCd10 = null;

        //발견장소
        TextView txtSearchHappenPlace1 = (TextView) findViewById(R.id.txtSearchHappenPlace1);
        TextView txtSearchHappenPlace2 = (TextView) findViewById(R.id.txtSearchHappenPlace2);
        TextView txtSearchHappenPlace3 = (TextView) findViewById(R.id.txtSearchHappenPlace3);
        TextView txtSearchHappenPlace4 = (TextView) findViewById(R.id.txtSearchHappenPlace4);
        TextView txtSearchHappenPlace5 = (TextView) findViewById(R.id.txtSearchHappenPlace5);
        TextView txtSearchHappenPlace6 = (TextView) findViewById(R.id.txtSearchHappenPlace6);
        TextView txtSearchHappenPlace7 = (TextView) findViewById(R.id.txtSearchHappenPlace7);
        TextView txtSearchHappenPlace8 = (TextView) findViewById(R.id.txtSearchHappenPlace8);
        TextView txtSearchHappenPlace9 = (TextView) findViewById(R.id.txtSearchHappenPlace9);
        TextView txtSearchHappenPlace10 = (TextView) findViewById(R.id.txtSearchHappenPlace10);
        String happenPlace1 = null, happenPlace2 = null, happenPlace3 = null, happenPlace4 = null, happenPlace5 = null, happenPlace6 = null, happenPlace7 = null, happenPlace8 = null, happenPlace9 = null, happenPlace10 = null;
        boolean ishappenPlace1 = false, ishappenPlace2 = false, ishappenPlace3 = false, ishappenPlace4 = false, ishappenPlace5 = false, ishappenPlace6 = false, ishappenPlace7 = false, ishappenPlace8 = false, ishappenPlace9 = false, ishappenPlace10 = false;

        //보호센터
        TextView txtSearchNmProtect1 = (TextView) findViewById(R.id.txtSearchNmProtect1);
        TextView txtSearchNmProtect2 = (TextView) findViewById(R.id.txtSearchNmProtect2);
        TextView txtSearchNmProtect3 = (TextView) findViewById(R.id.txtSearchNmProtect3);
        TextView txtSearchNmProtect4 = (TextView) findViewById(R.id.txtSearchNmProtect4);
        TextView txtSearchNmProtect5 = (TextView) findViewById(R.id.txtSearchNmProtect5);
        TextView txtSearchNmProtect6 = (TextView) findViewById(R.id.txtSearchNmProtect6);
        TextView txtSearchNmProtect7 = (TextView) findViewById(R.id.txtSearchNmProtect7);
        TextView txtSearchNmProtect8 = (TextView) findViewById(R.id.txtSearchNmProtect8);
        TextView txtSearchNmProtect9 = (TextView) findViewById(R.id.txtSearchNmProtect9);
        TextView txtSearchNmProtect10 = (TextView) findViewById(R.id.txtSearchNmProtect10);

        String careNm1 = null, careNm2 = null, careNm3 = null, careNm4 = null, careNm5 = null, careNm6 = null, careNm7 = null, careNm8 = null, careNm9 = null, careNm10 = null;
        boolean iscareNm1 = false, iscareNm2 = false, iscareNm3 = false, iscareNm4 = false, iscareNm5 = false, iscareNm6 = false, iscareNm7 = false, iscareNm8 = false, iscareNm9 = false, iscareNm10 = false;

        //보호소 전화번호
        TextView txtSearchTelProtect1 = (TextView) findViewById(R.id.txtSearchTelProtect1);
        TextView txtSearchTelProtect2 = (TextView) findViewById(R.id.txtSearchTelProtect2);
        TextView txtSearchTelProtect3 = (TextView) findViewById(R.id.txtSearchTelProtect3);
        TextView txtSearchTelProtect4 = (TextView) findViewById(R.id.txtSearchTelProtect4);
        TextView txtSearchTelProtect5 = (TextView) findViewById(R.id.txtSearchTelProtect5);
        TextView txtSearchTelProtect6 = (TextView) findViewById(R.id.txtSearchTelProtect6);
        TextView txtSearchTelProtect7 = (TextView) findViewById(R.id.txtSearchTelProtect7);
        TextView txtSearchTelProtect8 = (TextView) findViewById(R.id.txtSearchTelProtect8);
        TextView txtSearchTelProtect9 = (TextView) findViewById(R.id.txtSearchTelProtect9);
        TextView txtSearchTelProtect10 = (TextView) findViewById(R.id.txtSearchTelProtect10);

        String careTel1 = null, careTel2 = null, careTel3 = null, careTel4 = null, careTel5 = null, careTel6 = null, careTel7 = null, careTel8 = null, careTel9 = null, careTel10 = null;
        boolean iscareTel1 = false, iscareTel2 = false, iscareTel3 = false, iscareTel4 = false, iscareTel5 = false, iscareTel6 = false, iscareTel7 = false, iscareTel8 = false, iscareTel9 = false, iscareTel10 = false;

        //성별
        TextView txtSearchSex1 = (TextView) findViewById(R.id.txtSearchSex1);
        TextView txtSearchSex2 = (TextView) findViewById(R.id.txtSearchSex2);
        TextView txtSearchSex3 = (TextView) findViewById(R.id.txtSearchSex3);
        TextView txtSearchSex4 = (TextView) findViewById(R.id.txtSearchSex4);
        TextView txtSearchSex5 = (TextView) findViewById(R.id.txtSearchSex5);
        TextView txtSearchSex6 = (TextView) findViewById(R.id.txtSearchSex6);
        TextView txtSearchSex7 = (TextView) findViewById(R.id.txtSearchSex7);
        TextView txtSearchSex8 = (TextView) findViewById(R.id.txtSearchSex8);
        TextView txtSearchSex9 = (TextView) findViewById(R.id.txtSearchSex9);
        TextView txtSearchSex10 = (TextView) findViewById(R.id.txtSearchSex10);

        String sexCd1 = null, sexCd2 = null, sexCd3 = null, sexCd4 = null, sexCd5 = null, sexCd6 = null, sexCd7 = null, sexCd8 = null, sexCd9 = null, sexCd10 = null;
        boolean issexCd1 = false, issexCd2 = false, issexCd3 = false, issexCd4 = false, issexCd5 = false, issexCd6 = false, issexCd7 = false, issexCd8 = false, issexCd9 = false, issexCd10 = false;

        //중성화여부
        TextView txtSearchNeut1 = (TextView) findViewById(R.id.txtSearchNeut1);
        TextView txtSearchNeut2 = (TextView) findViewById(R.id.txtSearchNeut2);
        TextView txtSearchNeut3 = (TextView) findViewById(R.id.txtSearchNeut3);
        TextView txtSearchNeut4 = (TextView) findViewById(R.id.txtSearchNeut4);
        TextView txtSearchNeut5 = (TextView) findViewById(R.id.txtSearchNeut5);
        TextView txtSearchNeut6 = (TextView) findViewById(R.id.txtSearchNeut6);
        TextView txtSearchNeut7 = (TextView) findViewById(R.id.txtSearchNeut7);
        TextView txtSearchNeut8 = (TextView) findViewById(R.id.txtSearchNeut8);
        TextView txtSearchNeut9 = (TextView) findViewById(R.id.txtSearchNeut9);
        TextView txtSearchNeut10 = (TextView) findViewById(R.id.txtSearchNeut10);

        boolean isneuterYn1 = false, isneuterYn2 = false, isneuterYn3 = false, isneuterYn4 = false, isneuterYn5 = false, isneuterYn6 = false, isneuterYn7 = false, isneuterYn8 = false, isneuterYn9 = false, isneuterYn10 = false;
        String neuterYn1 = null, neuterYn2 = null, neuterYn3 = null, neuterYn4 = null, neuterYn5 = null, neuterYn6 = null, neuterYn7 = null, neuterYn8 = null, neuterYn9 = null, neuterYn10 = null;

        //페이지 버튼 선언
        ImageButton btnPageFirst = (ImageButton) findViewById(R.id.btnSearchPageFirst);
        ImageButton btnPageLast = (ImageButton) findViewById(R.id.btnSearchPageLast);

        //페이지가 5개 이상
        Button btnSearchPage5bNum1 = (Button) findViewById(R.id.btnSearchPage5bNum1);
        Button btnSearchPage5bNum2 = (Button) findViewById(R.id.btnSearchPage5bNum2);
        Button btnSearchPage5bNum3 = (Button) findViewById(R.id.btnSearchPage5bNum3);
        Button btnSearchPage5bNum4 = (Button) findViewById(R.id.btnSearchPage5bNum4);
        Button btnSearchPage5bNum5 = (Button) findViewById(R.id.btnSearchPage5bNum5);

        //페이지가 4개
        Button btnSearchPage4bNum1 = (Button) findViewById(R.id.btnSearchPage4bNum1);
        Button btnSearchPage4bNum2 = (Button) findViewById(R.id.btnSearchPage4bNum2);
        Button btnSearchPage4bNum3 = (Button) findViewById(R.id.btnSearchPage4bNum3);
        Button btnSearchPage4bNum4 = (Button) findViewById(R.id.btnSearchPage4bNum4);

        //페이지가 3개
        Button btnSearchPage3bNum1 = (Button) findViewById(R.id.btnSearchPage3bNum1);
        Button btnSearchPage3bNum2 = (Button) findViewById(R.id.btnSearchPage3bNum2);
        Button btnSearchPage3bNum3 = (Button) findViewById(R.id.btnSearchPage3bNum3);

        //페이지가 2개
        Button btnSearchPage2bNum1 = (Button) findViewById(R.id.btnSearchPage2bNum1);
        Button btnSearchPage2bNum2 = (Button) findViewById(R.id.btnSearchPage2bNum2);

        //페이지가 1개
        Button btnSearchPage1bNum1 = (Button) findViewById(R.id.btnSearchPage1bNum1);


        //오늘 날짜를 default로 검색
        Date today = new Date();
        SimpleDateFormat date = new SimpleDateFormat("yyyyMMdd");
        String defaultDate = date.format(today);
        String kotoshi = defaultDate.substring(0,4); // 올해연도인 2021을 가짐

        //데이터 개수
        String totalCount = null;
        Boolean istotalCount = false;

        int count = 1;
        int ageplus =1;


        try{
            URL url = new URL("http://openapi.animal.go.kr/openapi/service/rest/abandonmentPublicSrvc/abandonmentPublic?bgnde=" + defaultDate + "&endde=" + defaultDate + "&pageNo=" + page + "&numOfRows=10&ServiceKey=yNSywHmSDzLWzmZfiXeGNkoJ7k8FEf%2BmaGkUW4A9caeiJDuEckp%2B7NPmuCc1iVfguBQCau25vanKExLXSZsB4Q%3D%3D");
            URL conUrl = new URL("http://openapi.animal.go.kr/openapi/service/rest/abandonmentPublicSrvc/abandonmentPublic?bgnde=" + startdate + "&endde=" + enddate + "&pageNo=" + page + "&numOfRows=10&ServiceKey=yNSywHmSDzLWzmZfiXeGNkoJ7k8FEf%2BmaGkUW4A9caeiJDuEckp%2B7NPmuCc1iVfguBQCau25vanKExLXSZsB4Q%3D%3D&upr_cd=" + sido + "&org_cd=" + gungu + "&upkind=" + kind);


            XmlPullParserFactory parserCreator = XmlPullParserFactory.newInstance();
            XmlPullParser parser = parserCreator.newPullParser();

            parser.setInput(url.openStream(), null);

            int parserEvent = parser.getEventType();

            //조건검색시 사용 datacheck -> 검색조건이 있으면 true 없으면 false
            if (dataCheck)
                parser.setInput(conUrl.openStream(), null);
            else
                parser.setInput(url.openStream(), null);


            while(parserEvent != XmlPullParser.END_DOCUMENT){
                switch(parserEvent){
                    case XmlPullParser.START_TAG:


                        //데이터 개수
                        if(parser.getName().equals("totalCount"))
                            istotalCount = true;

                        //이미지
                        if(parser.getName().equals("filename")){
                            if(count == 1)
                                isfilename1 = true;
                            else if(count == 2)
                                isfilename2 = true;
                            else if(count == 3)
                                isfilename3 = true;
                            else if(count == 4)
                                isfilename4 = true;
                            else if(count == 5)
                                isfilename5 = true;
                            else if(count == 6)
                                isfilename6 = true;
                            else if(count == 7)
                                isfilename7 = true;
                            else if(count == 8)
                                isfilename8 = true;
                            else if(count == 9)
                                isfilename9 = true;
                            else
                                isfilename10 = true;
                        }

                        //공고 시작일
                        if(parser.getName().equals("noticeSdt")){
                            if(count == 1)
                                isnoticeSdt1 = true;
                            else if(count == 2)
                                isnoticeSdt2 = true;
                            else if(count == 3)
                                isnoticeSdt3 = true;
                            else if(count == 4)
                                isnoticeSdt4 = true;
                            else if(count == 5)
                                isnoticeSdt5 = true;
                            else if(count == 6)
                                isnoticeSdt6 = true;
                            else if(count == 7)
                                isnoticeSdt7 = true;
                            else if(count == 8)
                                isnoticeSdt8 = true;
                            else if(count == 9)
                                isnoticeSdt9 = true;
                            else
                                isnoticeSdt10 = true;
                        }

                        //공고 종료일
                        if(parser.getName().equals("noticeEdt"))
                        {
                            if(count == 1)
                                isnoticeEdt1 = true;
                            else if(count == 2)
                                isnoticeEdt2 = true;
                            else if(count == 3)
                                isnoticeEdt3 = true;
                            else if(count == 4)
                                isnoticeEdt4 = true;
                            else if(count == 5)
                                isnoticeEdt5 = true;
                            else if(count == 6)
                                isnoticeEdt6 = true;
                            else if(count == 7)
                                isnoticeEdt7 = true;
                            else if(count == 8)
                                isnoticeEdt8 = true;
                            else if(count == 9)
                                isnoticeEdt9 = true;
                            else
                                isnoticeEdt10 = true;
                        }

                        //품종
                        if(parser.getName().equals("kindCd"))
                        {
                            if(count == 1)
                                isKindCd1 = true;
                            else if(count == 2)
                                isKindCd2 = true;
                            else if(count == 3)
                                isKindCd3 = true;
                            else if(count == 4)
                                isKindCd4 = true;
                            else if(count == 5)
                                isKindCd5 = true;
                            else if(count == 6)
                                isKindCd6 = true;
                            else if(count == 7)
                                isKindCd7 = true;
                            else if(count == 8)
                                isKindCd8 = true;
                            else if(count == 9)
                                isKindCd9 = true;
                            else
                                isKindCd10 = true;
                        }

                        //나이
                        if(parser.getName().equals("age"))
                        {
                            if(count == 1)
                                isage1 = true;
                            else if(count == 2)
                                isage2 = true;
                            else if(count == 3)
                                isage3 = true;
                            else if(count == 4)
                                isage4 = true;
                            else if(count == 5)
                                isage5 = true;
                            else if(count == 6)
                                isage6 = true;
                            else if(count == 7)
                                isage7 = true;
                            else if(count == 8)
                                isage8 = true;
                            else if(count == 9)
                                isage9 = true;
                            else
                                isage10 = true;
                        }

                        //상태
                        if (parser.getName().equals("processState")) {
                            if (count == 1)
                                isprocessState1 = true;
                            else if (count == 2)
                                isprocessState2 = true;
                            else if (count == 3)
                                isprocessState3 = true;
                            else if (count == 4)
                                isprocessState4 = true;
                            else if (count == 5)
                                isprocessState5 = true;
                            else if (count == 6)
                                isprocessState6 = true;
                            else if (count == 7)
                                isprocessState7 = true;
                            else if (count == 8)
                                isprocessState8 = true;
                            else if (count == 9)
                                isprocessState9 = true;
                            else
                                isprocessState10 = true;
                        }

                        //색상
                        if (parser.getName().equals("colorCd")) {
                            if (count == 1)
                                iscolorCd1 = true;
                            else if (count == 2)
                                iscolorCd2 = true;
                            else if (count == 3)
                                iscolorCd3 = true;
                            else if (count == 4)
                                iscolorCd4 = true;
                            else if (count == 5)
                                iscolorCd5 = true;
                            else if (count == 6)
                                iscolorCd6 = true;
                            else if (count == 7)
                                iscolorCd7 = true;
                            else if (count == 8)
                                iscolorCd8 = true;
                            else if (count == 9)
                                iscolorCd9 = true;
                            else
                                iscolorCd10 = true;
                        }

                        //발견장소
                        if (parser.getName().equals("happenPlace")) {
                            if (count == 1)
                                ishappenPlace1 = true;
                            else if (count == 2)
                                ishappenPlace2 = true;
                            else if (count == 3)
                                ishappenPlace3 = true;
                            else if (count == 4)
                                ishappenPlace4 = true;
                            else if (count == 5)
                                ishappenPlace5 = true;
                            else if (count == 6)
                                ishappenPlace6 = true;
                            else if (count == 7)
                                ishappenPlace7 = true;
                            else if (count == 8)
                                ishappenPlace8 = true;
                            else if (count == 9)
                                ishappenPlace9 = true;
                            else
                                ishappenPlace10 = true;
                        }

                        //보호센터
                        if (parser.getName().equals("careNm")) {
                            if (count == 1)
                                iscareNm1 = true;
                            else if (count == 2)
                                iscareNm2 = true;
                            else if (count == 3)
                                iscareNm3 = true;
                            else if (count == 4)
                                iscareNm4 = true;
                            else if (count == 5)
                                iscareNm5 = true;
                            else if (count == 6)
                                iscareNm6 = true;
                            else if (count == 7)
                                iscareNm7 = true;
                            else if (count == 8)
                                iscareNm8 = true;
                            else if (count == 9)
                                iscareNm9 = true;
                            else
                                iscareNm10 = true;
                        }

                        //보호소 전화번호
                        if (parser.getName().equals("careTel")) {
                            if (count == 1)
                                iscareTel1 = true;
                            else if (count == 2)
                                iscareTel2 = true;
                            else if (count == 3)
                                iscareTel3 = true;
                            else if (count == 4)
                                iscareTel4 = true;
                            else if (count == 5)
                                iscareTel5 = true;
                            else if (count == 6)
                                iscareTel6 = true;
                            else if (count == 7)
                                iscareTel7 = true;
                            else if (count == 8)
                                iscareTel8 = true;
                            else if (count == 9)
                                iscareTel9 = true;
                            else
                                iscareTel10 = true;
                        }

                        //성별
                        if (parser.getName().equals("sexCd")) {
                            if (count == 1)
                                issexCd1 = true;
                            else if (count == 2)
                                issexCd2 = true;
                            else if (count == 3)
                                issexCd3 = true;
                            else if (count == 4)
                                issexCd4 = true;
                            else if (count == 5)
                                issexCd5 = true;
                            else if (count == 6)
                                issexCd6 = true;
                            else if (count == 7)
                                issexCd7 = true;
                            else if (count == 8)
                                issexCd8 = true;
                            else if (count == 9)
                                issexCd9 = true;
                            else
                                issexCd10 = true;
                        }

                        //중성화여부
                        if (parser.getName().equals("neuterYn")) {
                            if (count == 1)
                                isneuterYn1 = true;
                            else if (count == 2)
                                isneuterYn2 = true;
                            else if (count == 3)
                                isneuterYn3 = true;
                            else if (count == 4)
                                isneuterYn4 = true;
                            else if (count == 5)
                                isneuterYn5 = true;
                            else if (count == 6)
                                isneuterYn6 = true;
                            else if (count == 7)
                                isneuterYn7 = true;
                            else if (count == 8)
                                isneuterYn8 = true;
                            else if (count == 9)
                                isneuterYn9 = true;
                            else
                                isneuterYn10 = true;
                        }


                        break;

                    case XmlPullParser.TEXT:

                        //데이터개수 파싱
                        if(istotalCount)
                        {
                            totalCount = parser.getText();
                            txtTest.setText(page);
                            istotalCount = false;
                        }


                        //이미지 URL GET
                        if (isfilename1) {
                            filename1 = parser.getText();
                            isfilename1 = false;
                        }
                        if (isfilename2) {
                            filename2 = parser.getText();
                            if(filename2 == null)
                            {
                                imgSearchAnimal2.setVisibility(View.INVISIBLE);
                                txtSearchNoticeSdt2.setVisibility(View.INVISIBLE);
                                txtSearchNoticeEdt2.setVisibility(View.INVISIBLE);
                                txtSearchKindCd1.setVisibility(View.INVISIBLE);
                                txtSearchAge2.setVisibility(View.INVISIBLE);
                            }
                            isfilename2 = false;
                        }
                        if (isfilename3) {
                            filename3 = parser.getText();
                            isfilename3 = false;
                        }
                        if (isfilename4) {
                            filename4 = parser.getText();
                            isfilename4 = false;
                        }
                        if (isfilename5) {
                            filename5 = parser.getText();
                            isfilename5 = false;
                        }
                        if (isfilename6) {
                            filename6 = parser.getText();
                            isfilename6 = false;
                        }
                        if (isfilename7) {
                            filename7 = parser.getText();
                            isfilename7 = false;
                        }
                        if (isfilename8) {
                            filename8 = parser.getText();
                            isfilename8 = false;
                        }
                        if (isfilename9) {
                            filename9 = parser.getText();
                            isfilename9 = false;
                        }
                        if (isfilename10) {
                            filename10 = parser.getText();
                            isfilename10 = false;
                        }

                        if (isnoticeSdt1) {
                            noticeSdt1 = parser.getText();
                            isnoticeSdt1 = false;
                        }
                        if (isnoticeSdt2) {
                            noticeSdt2 = parser.getText();
                            isnoticeSdt2 = false;
                        }
                        if (isnoticeSdt3) {
                            noticeSdt3 = parser.getText();
                            isnoticeSdt3 = false;
                        }
                        if (isnoticeSdt4) {
                            noticeSdt4 = parser.getText();
                            isnoticeSdt4 = false;
                        }
                        if (isnoticeSdt5) {
                            noticeSdt5 = parser.getText();
                            isnoticeSdt5 = false;
                        }
                        if (isnoticeSdt6) {
                            noticeSdt6 = parser.getText();
                            isnoticeSdt6 = false;
                        }
                        if (isnoticeSdt7) {
                            noticeSdt7 = parser.getText();
                            isnoticeSdt7 = false;
                        }
                        if (isnoticeSdt8) {
                            noticeSdt8 = parser.getText();
                            isnoticeSdt8 = false;
                        }
                        if (isnoticeSdt9) {
                            noticeSdt9 = parser.getText();
                            isnoticeSdt9 = false;
                        }
                        if (isnoticeSdt10) {
                            noticeSdt10 = parser.getText();
                            isnoticeSdt10 = false;
                        }

                        //공고종료일
                        if (isnoticeEdt1) {
                            noticeEdt1 = parser.getText();
                            isnoticeEdt1 = false;
                        }
                        if (isnoticeEdt2) {
                            noticeEdt2 = parser.getText();
                            isnoticeEdt2 = false;
                        }
                        if (isnoticeEdt3) {
                            noticeEdt3 = parser.getText();
                            isnoticeEdt3 = false;
                        }
                        if (isnoticeEdt4) {
                            noticeEdt4 = parser.getText();
                            isnoticeEdt4 = false;
                        }
                        if (isnoticeEdt5) {
                            noticeEdt5 = parser.getText();
                            isnoticeEdt5 = false;
                        }
                        if (isnoticeEdt6) {
                            noticeEdt6 = parser.getText();
                            isnoticeEdt6 = false;
                        }
                        if (isnoticeEdt7) {
                            noticeEdt7 = parser.getText();
                            isnoticeEdt7 = false;
                        }
                        if (isnoticeEdt8) {
                            noticeEdt8 = parser.getText();
                            isnoticeEdt8 = false;
                        }
                        if (isnoticeEdt9) {
                            noticeEdt9 = parser.getText();
                            isnoticeEdt9 = false;
                        }
                        if (isnoticeEdt10) {
                            noticeEdt10 = parser.getText();
                            isnoticeEdt10 = false;
                        }

                        //품종
                        if (isKindCd1) {
                            kindCd1 = parser.getText();
                            Integer idx = kindCd1.indexOf("]");
                            kindCd1 = kindCd1.substring(idx + 1);
                            isKindCd1 = false;
                        }

                        if (isKindCd2) {
                            kindCd2 = parser.getText();
                            Integer idx = kindCd2.indexOf("]");
                            kindCd2 = kindCd2.substring(idx + 1);
                            isKindCd2 = false;
                        }

                        if (isKindCd3) {
                            kindCd3 = parser.getText();
                            Integer idx = kindCd3.indexOf("]");
                            kindCd3 = kindCd3.substring(idx + 1);
                            isKindCd3 = false;
                        }

                        if (isKindCd4) {
                            kindCd4 = parser.getText();
                            Integer idx = kindCd4.indexOf("]");
                            kindCd4 = kindCd4.substring(idx + 1);
                            isKindCd4 = false;
                        }

                        if (isKindCd5) {
                            kindCd5 = parser.getText();
                            Integer idx = kindCd5.indexOf("]");
                            kindCd5 = kindCd5.substring(idx + 1);
                            isKindCd5 = false;
                        }

                        if (isKindCd6) {
                            kindCd6 = parser.getText();
                            Integer idx = kindCd6.indexOf("]");
                            kindCd6 = kindCd6.substring(idx + 1);
                            isKindCd6 = false;
                        }

                        if (isKindCd7) {
                            kindCd7 = parser.getText();
                            Integer idx = kindCd7.indexOf("]");
                            kindCd7 = kindCd7.substring(idx + 1);
                            isKindCd7 = false;
                        }

                        if (isKindCd8) {
                            kindCd8 = parser.getText();
                            Integer idx = kindCd8.indexOf("]");
                            kindCd8 = kindCd8.substring(idx + 1);
                            isKindCd8 = false;
                        }

                        if (isKindCd9) {
                            kindCd9 = parser.getText();
                            Integer idx = kindCd9.indexOf("]");
                            kindCd9 = kindCd9.substring(idx + 1);
                            isKindCd9 = false;
                        }

                        if (isKindCd10) {
                            kindCd10 = parser.getText();
                            Integer idx = kindCd10.indexOf("]");
                            kindCd10 = kindCd10.substring(idx + 1);
                            isKindCd10 = false;
                        }

                        //나이
                        if (isage1) {
                            age1 = parser.getText();
                            age1 = age1.substring(0, 4);
                            isage1 = false;
                        }
                        if (isage2) {
                            age2 = parser.getText();
                            age2 = age2.substring(0, 4);
                            isage2 = false;
                        }
                        if (isage3) {
                            age3 = parser.getText();
                            age3 = age3.substring(0, 4);
                            isage3 = false;
                        }
                        if (isage4) {
                            age4 = parser.getText();
                            age4 = age1.substring(0, 4);
                            isage4 = false;
                        }
                        if (isage5) {
                            age5 = parser.getText();
                            age5 = age5.substring(0, 4);
                            isage5 = false;
                        }
                        if (isage6) {
                            age6 = parser.getText();
                            age6 = age6.substring(0, 4);
                            isage6 = false;
                        }
                        if (isage7) {
                            age7 = parser.getText();
                            age7 = age7.substring(0, 4);
                            isage7 = false;
                        }
                        if (isage8) {
                            age8 = parser.getText();
                            age8 = age8.substring(0, 4);
                            isage8 = false;
                        }
                        if (isage9) {
                            age9 = parser.getText();
                            age9 = age9.substring(0, 4);
                            isage9 = false;
                        }
                        if (isage10) {
                            age10 = parser.getText();
                            age10 = age10.substring(0, 4);
                            isage10 = false;
                        }

                        //상태
                        if (isprocessState1) {
                            processState1 = parser.getText();
                            Integer index = processState1.indexOf("(");
                            if (index == -1) {

                            } else {
                                processState1 = processState1.substring(index + 1);
                            }

                            isprocessState1 = false;
                        }
                        if (isprocessState2) {
                            processState2 = parser.getText();
                            Integer index = processState2.indexOf("(");
                            if (index == -1) {

                            } else {
                                processState2 = processState2.substring(index + 1);
                            }

                            isprocessState2 = false;
                        }
                        if (isprocessState3) {
                            processState3 = parser.getText();
                            Integer index = processState3.indexOf("(");
                            if (index == -1) {

                            } else {
                                processState3 = processState3.substring(index + 1);
                            }

                            isprocessState3 = false;
                        }
                        if (isprocessState4) {
                            processState4 = parser.getText();
                            Integer index = processState4.indexOf("(");
                            if (index == -1) {

                            } else {
                                processState4 = processState4.substring(index + 1);
                            }

                            isprocessState4 = false;
                        }
                        if (isprocessState5) {
                            processState5 = parser.getText();
                            Integer index = processState5.indexOf("(");
                            if (index == -1) {

                            } else {
                                processState5 = processState5.substring(index + 1);
                            }

                            isprocessState5 = false;
                        }
                        if (isprocessState6) {
                            processState6 = parser.getText();
                            Integer index = processState6.indexOf("(");
                            if (index == -1) {

                            } else {
                                processState6 = processState6.substring(index + 1);
                            }

                            isprocessState6 = false;
                        }
                        if (isprocessState7) {
                            processState7 = parser.getText();
                            Integer index = processState7.indexOf("(");
                            if (index == -1) {

                            } else {
                                processState7 = processState7.substring(index + 1);
                            }

                            isprocessState7 = false;
                        }
                        if (isprocessState8) {
                            processState8 = parser.getText();
                            Integer index = processState8.indexOf("(");
                            if (index == -1) {

                            } else {
                                processState8 = processState8.substring(index + 1);
                            }

                            isprocessState8 = false;
                        }
                        if (isprocessState9) {
                            processState9 = parser.getText();
                            Integer index = processState9.indexOf("(");
                            if (index == -1) {

                            } else {
                                processState9 = processState9.substring(index + 1);
                            }

                            isprocessState9 = false;
                        }
                        if (isprocessState10) {
                            processState10 = parser.getText();
                            Integer index = processState10.indexOf("(");
                            if (index == -1) {

                            } else {
                                processState10 = processState10.substring(index + 1);
                            }

                            isprocessState10 = false;
                        }

                        //색상
                        if (iscolorCd1) {
                            colorCd1 = parser.getText();
                            iscolorCd1 = false;
                        }

                        if (iscolorCd2) {
                            colorCd2 = parser.getText();
                            iscolorCd2 = false;
                        }

                        if (iscolorCd3) {
                            colorCd3 = parser.getText();
                            iscolorCd3 = false;
                        }

                        if (iscolorCd4) {
                            colorCd4 = parser.getText();
                            iscolorCd4 = false;
                        }

                        if (iscolorCd5) {
                            colorCd5 = parser.getText();
                            iscolorCd5 = false;
                        }

                        if (iscolorCd6) {
                            colorCd6 = parser.getText();
                            iscolorCd6 = false;
                        }

                        if (iscolorCd7) {
                            colorCd7 = parser.getText();
                            iscolorCd7 = false;
                        }

                        if (iscolorCd8) {
                            colorCd8 = parser.getText();
                            iscolorCd8 = false;
                        }

                        if (iscolorCd9) {
                            colorCd9 = parser.getText();
                            iscolorCd9 = false;
                        }

                        if (iscolorCd10) {
                            colorCd10 = parser.getText();
                            iscolorCd10 = false;
                        }


                        //발견장소
                        if (ishappenPlace1) {
                            happenPlace1 = parser.getText();
                            ishappenPlace1 = false;
                        }

                        if (ishappenPlace2) {
                            happenPlace2 = parser.getText();
                            ishappenPlace2 = false;
                        }

                        if (ishappenPlace3) {
                            happenPlace3 = parser.getText();
                            ishappenPlace3 = false;
                        }

                        if (ishappenPlace4) {
                            happenPlace4 = parser.getText();
                            ishappenPlace4 = false;
                        }

                        if (ishappenPlace5) {
                            happenPlace5 = parser.getText();
                            ishappenPlace5 = false;
                        }

                        if (ishappenPlace6) {
                            happenPlace6 = parser.getText();
                            ishappenPlace6 = false;
                        }

                        if (ishappenPlace7) {
                            happenPlace7 = parser.getText();
                            ishappenPlace7 = false;
                        }

                        if (ishappenPlace8) {
                            happenPlace8 = parser.getText();
                            ishappenPlace8 = false;
                        }

                        if (ishappenPlace9) {
                            happenPlace9 = parser.getText();
                            ishappenPlace9 = false;
                        }

                        if (ishappenPlace10) {
                            happenPlace10 = parser.getText();
                            ishappenPlace10 = false;
                        }


                        //보호센터
                        if (iscareNm1) {
                            careNm1 = parser.getText();
                            iscareNm1 = false;
                        }

                        if (iscareNm2) {
                            careNm2 = parser.getText();
                            iscareNm2 = false;
                        }

                        if (iscareNm3) {
                            careNm3 = parser.getText();
                            iscareNm3 = false;
                        }

                        if (iscareNm4) {
                            careNm4 = parser.getText();
                            iscareNm4 = false;
                        }

                        if (iscareNm5) {
                            careNm5 = parser.getText();
                            iscareNm5 = false;
                        }

                        if (iscareNm6) {
                            careNm6 = parser.getText();
                            iscareNm6 = false;
                        }

                        if (iscareNm7) {
                            careNm7 = parser.getText();
                            iscareNm7 = false;
                        }

                        if (iscareNm8) {
                            careNm8 = parser.getText();
                            iscareNm8 = false;
                        }

                        if (iscareNm9) {
                            careNm9 = parser.getText();
                            iscareNm9 = false;
                        }

                        if (iscareNm10) {
                            careNm10 = parser.getText();
                            iscareNm10 = false;
                        }


                        //보호소 전화번호
                        if (iscareTel1) {
                            careTel1 = parser.getText();
                            iscareTel1 = false;
                        }

                        if (iscareTel2) {
                            careTel2 = parser.getText();
                            iscareTel2 = false;
                        }

                        if (iscareTel3) {
                            careTel3 = parser.getText();
                            iscareTel3 = false;
                        }

                        if (iscareTel4) {
                            careTel4 = parser.getText();
                            iscareTel4 = false;
                        }

                        if (iscareTel5) {
                            careTel5 = parser.getText();
                            iscareTel5 = false;
                        }

                        if (iscareTel6) {
                            careTel6 = parser.getText();
                            iscareTel6 = false;
                        }

                        if (iscareTel7) {
                            careTel7 = parser.getText();
                            iscareTel7 = false;
                        }

                        if (iscareTel8) {
                            careTel8 = parser.getText();
                            iscareTel8 = false;
                        }

                        if (iscareTel9) {
                            careTel9 = parser.getText();
                            iscareTel9 = false;
                        }

                        if (iscareTel10) {
                            careTel10 = parser.getText();
                            iscareTel10 = false;
                        }

                        //성별
                        if (issexCd1) {
                            sexCd1 = parser.getText();
                            issexCd1 = false;
                        }

                        if (issexCd2) {
                            sexCd2 = parser.getText();
                            issexCd2 = false;
                        }

                        if (issexCd3) {
                            sexCd3 = parser.getText();
                            issexCd3 = false;
                        }

                        if (issexCd4) {
                            sexCd4 = parser.getText();
                            issexCd4 = false;
                        }

                        if (issexCd5) {
                            sexCd5 = parser.getText();
                            issexCd5 = false;
                        }

                        if (issexCd6) {
                            sexCd6 = parser.getText();
                            issexCd6 = false;
                        }

                        if (issexCd7) {
                            sexCd7 = parser.getText();
                            issexCd7 = false;
                        }

                        if (issexCd8) {
                            sexCd8 = parser.getText();
                            issexCd8 = false;
                        }

                        if (issexCd9) {
                            sexCd9 = parser.getText();
                            issexCd9 = false;
                        }

                        if (issexCd10) {
                            sexCd10 = parser.getText();
                            issexCd10 = false;
                        }

                        //중성화여부
                        if (isneuterYn1) {
                            neuterYn1 = parser.getText();
                            isneuterYn1 = false;
                        }

                        if (isneuterYn2) {
                            neuterYn2 = parser.getText();
                            isneuterYn2 = false;
                        }

                        if (isneuterYn3) {
                            neuterYn3 = parser.getText();
                            isneuterYn3 = false;
                        }

                        if (isneuterYn4) {
                            neuterYn4 = parser.getText();
                            isneuterYn4 = false;
                        }

                        if (isneuterYn5) {
                            neuterYn5 = parser.getText();
                            isneuterYn5 = false;
                        }

                        if (isneuterYn6) {
                            neuterYn6 = parser.getText();
                            isneuterYn6 = false;
                        }

                        if (isneuterYn7) {
                            neuterYn7 = parser.getText();
                            isneuterYn7 = false;
                        }

                        if (isneuterYn8) {
                            neuterYn8 = parser.getText();
                            isneuterYn8 = false;
                        }

                        if (isneuterYn9) {
                            neuterYn9 = parser.getText();
                            isneuterYn9 = false;
                        }

                        if (isneuterYn10) {
                            neuterYn10 = parser.getText();
                            isneuterYn10 = false;
                        }

                        break; // case XmlPullParser.TEXT break

                    case XmlPullParser.END_TAG:
                        if(parser.getName().equals("item")){

                            if(count == 1)
                            {
                                //이미지 삽입
                                URL url1 = new URL(filename1);
                                URLConnection conn1 = url1.openConnection();
                                BufferedInputStream bis1 = new BufferedInputStream(conn1.getInputStream());
                                Bitmap bm1 = BitmapFactory.decodeStream(bis1);
                                bis1.close();
                                imgSearchAnimal1.setImageBitmap(bm1);
                                //텍스트 삽입
                                txtSearchNoticeSdt1.setText(noticeSdt1);
                                txtSearchNoticeEdt1.setText(noticeEdt1);
                                txtSearchKindCd1.setText(kindCd1);

                                //상세 정보를 위한 invisible속성 텍스트 삽입
                                txtSearchColor1.setText(colorCd1);
                                txtSearchSex1.setText(sexCd1);
                                txtSearchHappenPlace1.setText(happenPlace1);
                                txtSearchNeut1.setText(neuterYn1);
                                txtSearchNmProtect1.setText(careNm1);
                                txtSearchTelProtect1.setText(careTel1);
                                txtSearchImgString1.setText(filename1);

                                //나이 계산(나이 데이터가 출생연도로 나와서)
                                String realAge = Integer.parseInt(kotoshi) - Integer.parseInt(age1) + ageplus + "세" + "(" + processState1 + ")";
                                txtSearchAge1.setText(realAge);
                                count++;
                            }
                            else if(count == 2)
                            {
                                //이미지 삽입
                                URL url1 = new URL(filename2);
                                URLConnection conn1 = url1.openConnection();
                                BufferedInputStream bis1 = new BufferedInputStream(conn1.getInputStream());
                                Bitmap bm1 = BitmapFactory.decodeStream(bis1);
                                bis1.close();
                                imgSearchAnimal2.setImageBitmap(bm1);
                                //텍스트 삽입
                                txtSearchNoticeSdt2.setText(noticeSdt2);
                                txtSearchNoticeEdt2.setText(noticeEdt2);
                                txtSearchKindCd2.setText(kindCd2);

                                //상세 정보를 위한 invisible속성 텍스트 삽입
                                txtSearchColor2.setText(colorCd2);
                                txtSearchSex2.setText(sexCd2);
                                txtSearchHappenPlace2.setText(happenPlace2);
                                txtSearchNeut2.setText(neuterYn2);
                                txtSearchNmProtect2.setText(careNm2);
                                txtSearchTelProtect2.setText(careTel2);
                                txtSearchImgString2.setText(filename2);


                                //나이 계산(나이 데이터가 출생연도로 나와서)
                                String realAge = Integer.parseInt(kotoshi) - Integer.parseInt(age2) + ageplus + "세" + "(" + processState2 + ")";
                                txtSearchAge2.setText(realAge);
                                count++;
                            }

                            else if(count == 3)
                            {
                                //이미지 삽입
                                URL url1 = new URL(filename3);
                                URLConnection conn1 = url1.openConnection();
                                BufferedInputStream bis1 = new BufferedInputStream(conn1.getInputStream());
                                Bitmap bm1 = BitmapFactory.decodeStream(bis1);
                                bis1.close();
                                imgSearchAnimal3.setImageBitmap(bm1);
                                //텍스트 삽입
                                txtSearchNoticeSdt3.setText(noticeSdt3);
                                txtSearchNoticeEdt3.setText(noticeEdt3);
                                txtSearchKindCd3.setText(kindCd3);

                                //상세 정보를 위한 invisible속성 텍스트 삽입
                                txtSearchColor3.setText(colorCd3);
                                txtSearchSex3.setText(sexCd3);
                                txtSearchHappenPlace3.setText(happenPlace3);
                                txtSearchNeut3.setText(neuterYn3);
                                txtSearchNmProtect3.setText(careNm3);
                                txtSearchTelProtect3.setText(careTel3);
                                txtSearchImgString3.setText(filename3);

                                //나이 계산(나이 데이터가 출생연도로 나와서)
                                String realAge = Integer.parseInt(kotoshi) - Integer.parseInt(age3) + ageplus + "세" + "(" + processState3 + ")";
                                txtSearchAge3.setText(realAge);
                                count++;
                            }

                            else if(count == 4)
                            {
                                //이미지 삽입
                                URL url1 = new URL(filename4);
                                URLConnection conn1 = url1.openConnection();
                                BufferedInputStream bis1 = new BufferedInputStream(conn1.getInputStream());
                                Bitmap bm1 = BitmapFactory.decodeStream(bis1);
                                bis1.close();
                                imgSearchAnimal4.setImageBitmap(bm1);
                                //텍스트 삽입
                                txtSearchNoticeSdt4.setText(noticeSdt4);
                                txtSearchNoticeEdt4.setText(noticeEdt4);
                                txtSearchKindCd4.setText(kindCd4);

                                //상세 정보를 위한 invisible속성 텍스트 삽입
                                txtSearchColor4.setText(colorCd4);
                                txtSearchSex4.setText(sexCd4);
                                txtSearchHappenPlace4.setText(happenPlace4);
                                txtSearchNeut4.setText(neuterYn4);
                                txtSearchNmProtect4.setText(careNm4);
                                txtSearchTelProtect4.setText(careTel4);
                                txtSearchImgString4.setText(filename4);

                                //나이 계산(나이 데이터가 출생연도로 나와서)
                                String realAge = Integer.parseInt(kotoshi) - Integer.parseInt(age4) + ageplus + "세" + "(" + processState4 + ")";
                                txtSearchAge4.setText(realAge);
                                count++;
                            }

                            else if(count == 5)
                            {
                                //이미지 삽입
                                //이미지 삽입
                                URL url1 = new URL(filename5);
                                URLConnection conn1 = url1.openConnection();
                                BufferedInputStream bis1 = new BufferedInputStream(conn1.getInputStream());
                                Bitmap bm1 = BitmapFactory.decodeStream(bis1);
                                bis1.close();
                                imgSearchAnimal5.setImageBitmap(bm1);
                                //텍스트 삽입
                                txtSearchNoticeSdt5.setText(noticeSdt5);
                                txtSearchNoticeEdt5.setText(noticeEdt5);
                                txtSearchKindCd5.setText(kindCd5);

                                //상세 정보를 위한 invisible속성 텍스트 삽입
                                txtSearchColor5.setText(colorCd5);
                                txtSearchSex5.setText(sexCd5);
                                txtSearchHappenPlace5.setText(happenPlace5);
                                txtSearchNeut5.setText(neuterYn5);
                                txtSearchNmProtect5.setText(careNm5);
                                txtSearchTelProtect5.setText(careTel5);
                                txtSearchImgString5.setText(filename5);

                                //나이 계산(나이 데이터가 출생연도로 나와서)
                                String realAge = Integer.parseInt(kotoshi) - Integer.parseInt(age5) + ageplus + "세" + "(" + processState5 + ")";
                                txtSearchAge5.setText(realAge);
                                count++;
                            }

                            else if(count == 6)
                            {
                                //이미지 삽입
                                URL url1 = new URL(filename6);
                                URLConnection conn1 = url1.openConnection();
                                BufferedInputStream bis1 = new BufferedInputStream(conn1.getInputStream());
                                Bitmap bm1 = BitmapFactory.decodeStream(bis1);
                                bis1.close();
                                imgSearchAnimal6.setImageBitmap(bm1);
                                //텍스트 삽입
                                txtSearchNoticeSdt6.setText(noticeSdt6);
                                txtSearchNoticeEdt6.setText(noticeEdt6);
                                txtSearchKindCd6.setText(kindCd6);

                                //상세 정보를 위한 invisible속성 텍스트 삽입
                                txtSearchColor6.setText(colorCd6);
                                txtSearchSex6.setText(sexCd6);
                                txtSearchHappenPlace6.setText(happenPlace6);
                                txtSearchNeut6.setText(neuterYn6);
                                txtSearchNmProtect6.setText(careNm6);
                                txtSearchTelProtect6.setText(careTel6);
                                txtSearchImgString6.setText(filename6);

                                //나이 계산(나이 데이터가 출생연도로 나와서)
                                String realAge = Integer.parseInt(kotoshi) - Integer.parseInt(age6) + ageplus + "세" + "(" + processState6 + ")";
                                txtSearchAge6.setText(realAge);
                                count++;
                            }

                            else if(count == 7)
                            {
                                //이미지 삽입
                                URL url1 = new URL(filename7);
                                URLConnection conn1 = url1.openConnection();
                                BufferedInputStream bis1 = new BufferedInputStream(conn1.getInputStream());
                                Bitmap bm1 = BitmapFactory.decodeStream(bis1);
                                bis1.close();
                                imgSearchAnimal7.setImageBitmap(bm1);
                                //텍스트 삽입
                                txtSearchNoticeSdt7.setText(noticeSdt7);
                                txtSearchNoticeEdt7.setText(noticeEdt7);
                                txtSearchKindCd7.setText(kindCd7);

                                //상세 정보를 위한 invisible속성 텍스트 삽입
                                txtSearchColor7.setText(colorCd7);
                                txtSearchSex7.setText(sexCd7);
                                txtSearchHappenPlace7.setText(happenPlace7);
                                txtSearchNeut7.setText(neuterYn7);
                                txtSearchNmProtect7.setText(careNm7);
                                txtSearchTelProtect7.setText(careTel7);
                                txtSearchImgString7.setText(filename7);

                                //나이 계산(나이 데이터가 출생연도로 나와서)
                                String realAge = Integer.parseInt(kotoshi) - Integer.parseInt(age7) + ageplus + "세" + "(" + processState7 + ")";
                                txtSearchAge7.setText(realAge);
                                count++;
                            }

                            else if(count == 8)
                            {
                                //이미지 삽입
                                URL url1 = new URL(filename8);
                                URLConnection conn1 = url1.openConnection();
                                BufferedInputStream bis1 = new BufferedInputStream(conn1.getInputStream());
                                Bitmap bm1 = BitmapFactory.decodeStream(bis1);
                                bis1.close();
                                imgSearchAnimal8.setImageBitmap(bm1);
                                //텍스트 삽입
                                txtSearchNoticeSdt8.setText(noticeSdt8);
                                txtSearchNoticeEdt8.setText(noticeEdt8);
                                txtSearchKindCd8.setText(kindCd8);

                                //상세 정보를 위한 invisible속성 텍스트 삽입
                                txtSearchColor8.setText(colorCd8);
                                txtSearchSex8.setText(sexCd8);
                                txtSearchHappenPlace8.setText(happenPlace8);
                                txtSearchNeut8.setText(neuterYn8);
                                txtSearchNmProtect8.setText(careNm8);
                                txtSearchTelProtect8.setText(careTel8);
                                txtSearchImgString8.setText(filename8);

                                //나이 계산(나이 데이터가 출생연도로 나와서)
                                String realAge = Integer.parseInt(kotoshi) - Integer.parseInt(age8) + ageplus + "세" + "(" + processState8 + ")";
                                txtSearchAge8.setText(realAge);
                                count++;
                            }

                            else if(count == 9)
                            {
                                //이미지 삽입
                                URL url1 = new URL(filename9);
                                URLConnection conn1 = url1.openConnection();
                                BufferedInputStream bis1 = new BufferedInputStream(conn1.getInputStream());
                                Bitmap bm1 = BitmapFactory.decodeStream(bis1);
                                bis1.close();
                                imgSearchAnimal9.setImageBitmap(bm1);
                                //텍스트 삽입
                                txtSearchNoticeSdt9.setText(noticeSdt9);
                                txtSearchNoticeEdt9.setText(noticeEdt9);
                                txtSearchKindCd9.setText(kindCd9);

                                //상세 정보를 위한 invisible속성 텍스트 삽입
                                txtSearchColor9.setText(colorCd9);
                                txtSearchSex9.setText(sexCd9);
                                txtSearchHappenPlace9.setText(happenPlace9);
                                txtSearchNeut9.setText(neuterYn9);
                                txtSearchNmProtect9.setText(careNm9);
                                txtSearchTelProtect9.setText(careTel9);
                                txtSearchImgString9.setText(filename9);

                                //나이 계산(나이 데이터가 출생연도로 나와서)
                                String realAge = Integer.parseInt(kotoshi) - Integer.parseInt(age9) + ageplus + "세" + "(" + processState9 + ")";
                                txtSearchAge9.setText(realAge);
                                count++;
                            }

                            else if(count == 10)
                            {
                                //이미지 삽입
                                URL url1 = new URL(filename10);
                                URLConnection conn1 = url1.openConnection();
                                BufferedInputStream bis1 = new BufferedInputStream(conn1.getInputStream());
                                Bitmap bm1 = BitmapFactory.decodeStream(bis1);
                                bis1.close();
                                imgSearchAnimal10.setImageBitmap(bm1);
                                //텍스트 삽입
                                txtSearchNoticeSdt10.setText(noticeSdt7);
                                txtSearchNoticeEdt10.setText(noticeEdt7);
                                txtSearchKindCd10.setText(kindCd7);

                                //상세 정보를 위한 invisible속성 텍스트 삽입
                                txtSearchColor10.setText(colorCd10);
                                txtSearchSex10.setText(sexCd10);
                                txtSearchHappenPlace10.setText(happenPlace10);
                                txtSearchNeut10.setText(neuterYn10);
                                txtSearchNmProtect10.setText(careNm10);
                                txtSearchTelProtect10.setText(careTel10);
                                txtSearchImgString10.setText(filename10);

                                //나이 계산(나이 데이터가 출생연도로 나와서)
                                String realAge = Integer.parseInt(kotoshi) - Integer.parseInt(age10) + ageplus + "세" + "(" + processState10 + ")";
                                txtSearchAge10.setText(realAge);
                                count++;
                            }
                        } // if문닫음

                        if(parser.getName().equals("body"))
                        {
                            //검색 데이터가 없을 경우 Default로 이동
                            Integer los = Integer.parseInt(totalCount);
                            txtSearchResult.setText(totalCount);

                            if(los == 0)
                            {
                                Toast.makeText(getApplicationContext(), "조건에 맞는 데이터가 없습니다 !", Toast.LENGTH_LONG).show();
                                Intent intent2 = new Intent(getApplicationContext(), MainActivity.class);
                                startActivity(intent2);
                                finish();
                            }

                            else
                            {
                                String tempResult = totalCount + "개";
                                txtSearchResult.setText(tempResult);
                            }

                            //버튼 한개
                            if(los < 10)
                            {
                                btnSearchPage5bNum1.setVisibility(View.INVISIBLE);
                                btnSearchPage5bNum2.setVisibility(View.INVISIBLE);
                                btnSearchPage5bNum3.setVisibility(View.INVISIBLE);
                                btnSearchPage5bNum4.setVisibility(View.INVISIBLE);
                                btnSearchPage5bNum5.setVisibility(View.INVISIBLE);

                                btnSearchPage1bNum1.setVisibility(View.VISIBLE);
                                btnSearchPage1bNum1.setTextColor(Color.parseColor("#0000FF"));
                            }

                            //버튼 두개
                            else if(los < 20)
                            {
                                btnSearchPage5bNum1.setVisibility(View.INVISIBLE);
                                btnSearchPage5bNum2.setVisibility(View.INVISIBLE);
                                btnSearchPage5bNum3.setVisibility(View.INVISIBLE);
                                btnSearchPage5bNum4.setVisibility(View.INVISIBLE);
                                btnSearchPage5bNum5.setVisibility(View.INVISIBLE);

                                btnSearchPage2bNum1.setVisibility(View.VISIBLE);
                                btnSearchPage2bNum2.setVisibility(View.VISIBLE);

                                if(page == "2")
                                    btnSearchPage2bNum2.setTextColor(Color.parseColor("#0000FF"));
                                else
                                    btnSearchPage2bNum1.setTextColor(Color.parseColor("#0000FF"));
                            }

                            //버튼 3개
                            else if(los < 30)
                            {
                                btnSearchPage5bNum1.setVisibility(View.INVISIBLE);
                                btnSearchPage5bNum2.setVisibility(View.INVISIBLE);
                                btnSearchPage5bNum3.setVisibility(View.INVISIBLE);
                                btnSearchPage5bNum4.setVisibility(View.INVISIBLE);
                                btnSearchPage5bNum5.setVisibility(View.INVISIBLE);

                                btnSearchPage3bNum1.setVisibility(View.VISIBLE);
                                btnSearchPage3bNum2.setVisibility(View.VISIBLE);
                                btnSearchPage3bNum3.setVisibility(View.VISIBLE);

                                if(page == "3")
                                    btnSearchPage3bNum3.setTextColor(Color.parseColor("#0000FF"));
                                else if(page == "2")
                                    btnSearchPage3bNum2.setTextColor(Color.parseColor("#0000FF"));
                                else
                                    btnSearchPage3bNum1.setTextColor(Color.parseColor("#0000FF"));
                            }

                            //버튼 4개
                            else if(los < 40)
                            {
                                btnSearchPage5bNum1.setVisibility(View.INVISIBLE);
                                btnSearchPage5bNum2.setVisibility(View.INVISIBLE);
                                btnSearchPage5bNum3.setVisibility(View.INVISIBLE);
                                btnSearchPage5bNum4.setVisibility(View.INVISIBLE);
                                btnSearchPage5bNum5.setVisibility(View.INVISIBLE);

                                btnSearchPage4bNum1.setVisibility(View.VISIBLE);
                                btnSearchPage4bNum2.setVisibility(View.VISIBLE);
                                btnSearchPage4bNum3.setVisibility(View.VISIBLE);
                                btnSearchPage4bNum4.setVisibility(View.VISIBLE);

                                if(page == "4")
                                    btnSearchPage4bNum4.setTextColor(Color.parseColor("#0000FF"));
                                else if(page == "3")
                                    btnSearchPage4bNum3.setTextColor(Color.parseColor("#0000FF"));
                                else if(page == "2")
                                    btnSearchPage4bNum2.setTextColor(Color.parseColor("#0000FF"));
                                else
                                    btnSearchPage4bNum1.setTextColor(Color.parseColor("#0000FF"));
                            }
                            else
                            {
                                String one = txtSearchResult.getText().toString();
                                Integer idx = one.indexOf("개");
                                String two = one.substring(0,idx);
                                Integer rPage = (Integer.parseInt(two) / 10) + 1; // 페이지 수
                                String Page = String.valueOf(rPage);

                                String nPage = txtTest.getText().toString();
                                Integer nowPage = Integer.parseInt(nPage); //현재 페이지 int

                                if(page == null || nowPage <= 3)
                                {
                                    btnSearchPage5bNum1.setText("1");
                                    btnSearchPage5bNum2.setText("2");
                                    btnSearchPage5bNum3.setText("3");
                                    btnSearchPage5bNum4.setText("4");
                                    btnSearchPage5bNum5.setText("5");

                                    if(nowPage == 1)
                                        btnSearchPage5bNum1.setTextColor(Color.parseColor("#0000FF"));
                                    else if(nowPage == 2)
                                        btnSearchPage5bNum2.setTextColor(Color.parseColor("#0000FF"));
                                    else
                                        btnSearchPage5bNum3.setTextColor(Color.parseColor("#0000FF"));
                                }
                                else
                                {

                                    if(nowPage > 3 && nowPage <= rPage - 2)
                                    {
                                        Integer num1 = nowPage - 2;
                                        String one1 = String.valueOf(num1);
                                        Integer num2 = nowPage - 1;
                                        String one2 = String.valueOf(num2);
                                        Integer num3 = nowPage;
                                        String one3 = String.valueOf(num3);
                                        Integer num4 = nowPage + 1 ;
                                        String one4 = String.valueOf(num4);
                                        Integer num5 = nowPage + 2;
                                        String one5 = String.valueOf(num5);

                                        btnSearchPage5bNum1.setText(one1);
                                        btnSearchPage5bNum2.setText(one2);
                                        btnSearchPage5bNum3.setText(one3);
                                        btnSearchPage5bNum4.setText(one4);
                                        btnSearchPage5bNum5.setText(one5);

                                        btnSearchPage5bNum3.setTextColor(Color.parseColor("#0000FF"));
                                    }

                                    else if(nowPage == rPage - 1)
                                    {
                                        Integer num1 = nowPage - 3;
                                        String one1 = String.valueOf(num1);
                                        Integer num2 = nowPage - 2;
                                        String one2 = String.valueOf(num2);
                                        Integer num3 = nowPage - 1;
                                        String one3 = String.valueOf(num3);
                                        Integer num4 = nowPage;
                                        String one4 = String.valueOf(num4);
                                        Integer num5 = nowPage + 1;
                                        String one5 = String.valueOf(num5);

                                        btnSearchPage5bNum1.setText(one1);
                                        btnSearchPage5bNum2.setText(one2);
                                        btnSearchPage5bNum3.setText(one3);
                                        btnSearchPage5bNum4.setText(one4);
                                        btnSearchPage5bNum5.setText(one5);

                                        btnSearchPage5bNum4.setTextColor(Color.parseColor("#0000FF"));
                                    }
                                    else
                                    {
                                        Integer num1 = nowPage - 4;
                                        String one1 = String.valueOf(num1);
                                        Integer num2 = nowPage - 3;
                                        String one2 = String.valueOf(num2);
                                        Integer num3 = nowPage - 2;
                                        String one3 = String.valueOf(num3);
                                        Integer num4 = nowPage - 1;
                                        String one4 = String.valueOf(num4);
                                        Integer num5 = nowPage;
                                        String one5 = String.valueOf(num5);

                                        btnSearchPage5bNum1.setText(one1);
                                        btnSearchPage5bNum2.setText(one2);
                                        btnSearchPage5bNum3.setText(one3);
                                        btnSearchPage5bNum4.setText(one4);
                                        btnSearchPage5bNum5.setText(one5);

                                        btnSearchPage5bNum5.setTextColor(Color.parseColor("#0000FF"));
                                    }
                                }
                            }
                        }
                        break;


                }//while in switch문 닫음
                parserEvent = parser.next();
            } // while문 닫음


        }catch(Exception e){
            System.out.println("에러가 발생했습니다.");
        }

        //조건검색창으로 이동
        Button btnSearchCondition = (Button)findViewById(R.id.btnSearchCondition);
        btnSearchCondition.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), SearchCondition.class);
                startActivity(intent);
                finish();
            }
        });



        //1번 자세히
        imgSearchAnimal1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), DetailActivity.class);

                String image = txtSearchImgString1.getText().toString();
                String Sdt = txtSearchNoticeSdt1.getText().toString();
                String Edt = txtSearchNoticeEdt1.getText().toString();
                String Date = Sdt.substring(0,4) + "-" + Sdt.substring(4,6) + "-" + Sdt.substring(6,8) + "  ~  " + Edt.substring(0,4) + "-" + Edt.substring(4,6) + "-" + Edt.substring(6,8);
                String Kind = txtSearchKindCd1.getText().toString();

                //나이와 상태 분리를 위해
                String AgePort = txtSearchAge1.getText().toString();
                Integer idx = AgePort.indexOf("(");
                Integer idx2 = AgePort.indexOf(")");
                String Age = AgePort.substring(0, idx);
                String State = null;
                if(idx == -1)
                {}
                else
                    State = AgePort.substring(idx+1, idx2);
                String Color = txtSearchColor1.getText().toString();
                String HappenPlace = txtSearchHappenPlace1.getText().toString();
                String CareNm = txtSearchNmProtect1.getText().toString();
                String CareTel = txtSearchTelProtect1.getText().toString();
                String Sex = txtSearchSex1.getText().toString();
                String Neuter = txtSearchNeut1.getText().toString();

                intent.putExtra("Image", image);
                intent.putExtra("Date", Date);
                intent.putExtra("Kind", Kind);
                intent.putExtra("Age", Age);
                intent.putExtra("State", State);
                intent.putExtra("Color", Color);
                intent.putExtra("HappenPlace", HappenPlace);
                intent.putExtra("Care", CareNm);
                intent.putExtra("Caretel", CareTel);
                intent.putExtra("Sex", Sex);
                intent.putExtra("Neuter", Neuter);
                startActivity(intent);
            }
        });


        imgSearchAnimal2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), DetailActivity.class);

                String image = txtSearchImgString2.getText().toString();
                String Sdt = txtSearchNoticeSdt2.getText().toString();
                String Edt = txtSearchNoticeEdt2.getText().toString();
                String Date = Sdt.substring(0,4) + "-" + Sdt.substring(4,6) + "-" + Sdt.substring(6,8) + "  ~  " + Edt.substring(0,4) + "-" + Edt.substring(4,6) + "-" + Edt.substring(6,8);
                String Kind = txtSearchKindCd2.getText().toString();

                //나이와 상태 분리를 위해
                String AgePort = txtSearchAge2.getText().toString();
                Integer idx = AgePort.indexOf("(");
                Integer idx2 = AgePort.indexOf(")");
                String Age = AgePort.substring(0, idx);
                String State = null;
                if(idx == -1)
                {}
                else
                    State = AgePort.substring(idx+1, idx2);
                String Color = txtSearchColor2.getText().toString();
                String HappenPlace = txtSearchHappenPlace2.getText().toString();
                String CareNm = txtSearchNmProtect2.getText().toString();
                String CareTel = txtSearchTelProtect2.getText().toString();
                String Sex = txtSearchSex2.getText().toString();
                String Neuter = txtSearchNeut2.getText().toString();

                intent.putExtra("Image", image);
                intent.putExtra("Date", Date);
                intent.putExtra("Kind", Kind);
                intent.putExtra("Age", Age);
                intent.putExtra("State", State);
                intent.putExtra("Color", Color);
                intent.putExtra("HappenPlace", HappenPlace);
                intent.putExtra("Care", CareNm);
                intent.putExtra("Caretel", CareTel);
                intent.putExtra("Sex", Sex);
                intent.putExtra("Neuter", Neuter);
                startActivity(intent);
            }
        });


        imgSearchAnimal3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), DetailActivity.class);

                String image = txtSearchImgString3.getText().toString();
                String Sdt = txtSearchNoticeSdt3.getText().toString();
                String Edt = txtSearchNoticeEdt3.getText().toString();
                String Date = Sdt.substring(0,4) + "-" + Sdt.substring(4,6) + "-" + Sdt.substring(6,8) + "  ~  " + Edt.substring(0,4) + "-" + Edt.substring(4,6) + "-" + Edt.substring(6,8);
                String Kind = txtSearchKindCd3.getText().toString();

                //나이와 상태 분리를 위해
                String AgePort = txtSearchAge3.getText().toString();
                Integer idx = AgePort.indexOf("(");
                Integer idx2 = AgePort.indexOf(")");
                String Age = AgePort.substring(0, idx);
                String State = null;
                if(idx == -1)
                {}
                else
                    State = AgePort.substring(idx+1, idx2);
                String Color = txtSearchColor3.getText().toString();
                String HappenPlace = txtSearchHappenPlace3.getText().toString();
                String CareNm = txtSearchNmProtect3.getText().toString();
                String CareTel = txtSearchTelProtect3.getText().toString();
                String Sex = txtSearchSex3.getText().toString();
                String Neuter = txtSearchNeut3.getText().toString();

                intent.putExtra("Image", image);
                intent.putExtra("Date", Date);
                intent.putExtra("Kind", Kind);
                intent.putExtra("Age", Age);
                intent.putExtra("State", State);
                intent.putExtra("Color", Color);
                intent.putExtra("HappenPlace", HappenPlace);
                intent.putExtra("Care", CareNm);
                intent.putExtra("Caretel", CareTel);
                intent.putExtra("Sex", Sex);
                intent.putExtra("Neuter", Neuter);
                startActivity(intent);
            }
        });


        imgSearchAnimal4.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), DetailActivity.class);

                String image = txtSearchImgString4.getText().toString();
                String Sdt = txtSearchNoticeSdt4.getText().toString();
                String Edt = txtSearchNoticeEdt1.getText().toString();
                String Date = Sdt.substring(0,4) + "-" + Sdt.substring(4,6) + "-" + Sdt.substring(6,8) + "  ~  " + Edt.substring(0,4) + "-" + Edt.substring(4,6) + "-" + Edt.substring(6,8);
                String Kind = txtSearchKindCd1.getText().toString();

                //나이와 상태 분리를 위해
                String AgePort = txtSearchAge4.getText().toString();
                Integer idx = AgePort.indexOf("(");
                Integer idx2 = AgePort.indexOf(")");
                String Age = AgePort.substring(0, idx);
                String State = null;
                if(idx == -1)
                {}
                else
                    State = AgePort.substring(idx+1, idx2);
                String Color = txtSearchColor4.getText().toString();
                String HappenPlace = txtSearchHappenPlace4.getText().toString();
                String CareNm = txtSearchNmProtect4.getText().toString();
                String CareTel = txtSearchTelProtect4.getText().toString();
                String Sex = txtSearchSex4.getText().toString();
                String Neuter = txtSearchNeut4.getText().toString();

                intent.putExtra("Image", image);
                intent.putExtra("Date", Date);
                intent.putExtra("Kind", Kind);
                intent.putExtra("Age", Age);
                intent.putExtra("State", State);
                intent.putExtra("Color", Color);
                intent.putExtra("HappenPlace", HappenPlace);
                intent.putExtra("Care", CareNm);
                intent.putExtra("Caretel", CareTel);
                intent.putExtra("Sex", Sex);
                intent.putExtra("Neuter", Neuter);
                startActivity(intent);
            }
        });


        imgSearchAnimal5.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), DetailActivity.class);

                String image = txtSearchImgString5.getText().toString();
                String Sdt = txtSearchNoticeSdt5.getText().toString();
                String Edt = txtSearchNoticeEdt5.getText().toString();
                String Date = Sdt.substring(0,4) + "-" + Sdt.substring(4,6) + "-" + Sdt.substring(6,8) + "  ~  " + Edt.substring(0,4) + "-" + Edt.substring(4,6) + "-" + Edt.substring(6,8);
                String Kind = txtSearchKindCd5.getText().toString();

                //나이와 상태 분리를 위해
                String AgePort = txtSearchAge5.getText().toString();
                Integer idx = AgePort.indexOf("(");
                Integer idx2 = AgePort.indexOf(")");
                String Age = AgePort.substring(0, idx);
                String State = null;
                if(idx == -1)
                {}
                else
                    State = AgePort.substring(idx+1, idx2);
                String Color = txtSearchColor5.getText().toString();
                String HappenPlace = txtSearchHappenPlace5.getText().toString();
                String CareNm = txtSearchNmProtect5.getText().toString();
                String CareTel = txtSearchTelProtect5.getText().toString();
                String Sex = txtSearchSex5.getText().toString();
                String Neuter = txtSearchNeut5.getText().toString();

                intent.putExtra("Image", image);
                intent.putExtra("Date", Date);
                intent.putExtra("Kind", Kind);
                intent.putExtra("Age", Age);
                intent.putExtra("State", State);
                intent.putExtra("Color", Color);
                intent.putExtra("HappenPlace", HappenPlace);
                intent.putExtra("Care", CareNm);
                intent.putExtra("Caretel", CareTel);
                intent.putExtra("Sex", Sex);
                intent.putExtra("Neuter", Neuter);
                startActivity(intent);
            }
        });


        imgSearchAnimal6.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), DetailActivity.class);

                String image = txtSearchImgString6.getText().toString();
                String Sdt = txtSearchNoticeSdt6.getText().toString();
                String Edt = txtSearchNoticeEdt6.getText().toString();
                String Date = Sdt.substring(0,4) + "-" + Sdt.substring(4,6) + "-" + Sdt.substring(6,8) + "  ~  " + Edt.substring(0,4) + "-" + Edt.substring(4,6) + "-" + Edt.substring(6,8);
                String Kind = txtSearchKindCd6.getText().toString();

                //나이와 상태 분리를 위해
                String AgePort = txtSearchAge6.getText().toString();
                Integer idx = AgePort.indexOf("(");
                Integer idx2 = AgePort.indexOf(")");
                String Age = AgePort.substring(0, idx);
                String State = null;
                if(idx == -1)
                {}
                else
                    State = AgePort.substring(idx+1, idx2);
                String Color = txtSearchColor6.getText().toString();
                String HappenPlace = txtSearchHappenPlace6.getText().toString();
                String CareNm = txtSearchNmProtect6.getText().toString();
                String CareTel = txtSearchTelProtect6.getText().toString();
                String Sex = txtSearchSex6.getText().toString();
                String Neuter = txtSearchNeut6.getText().toString();

                intent.putExtra("Image", image);
                intent.putExtra("Date", Date);
                intent.putExtra("Kind", Kind);
                intent.putExtra("Age", Age);
                intent.putExtra("State", State);
                intent.putExtra("Color", Color);
                intent.putExtra("HappenPlace", HappenPlace);
                intent.putExtra("Care", CareNm);
                intent.putExtra("Caretel", CareTel);
                intent.putExtra("Sex", Sex);
                intent.putExtra("Neuter", Neuter);
                startActivity(intent);
            }
        });


        imgSearchAnimal7.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), DetailActivity.class);

                String image = txtSearchImgString7.getText().toString();
                String Sdt = txtSearchNoticeSdt7.getText().toString();
                String Edt = txtSearchNoticeEdt7.getText().toString();
                String Date = Sdt.substring(0,4) + "-" + Sdt.substring(4,6) + "-" + Sdt.substring(6,8) + "  ~  " + Edt.substring(0,4) + "-" + Edt.substring(4,6) + "-" + Edt.substring(6,8);
                String Kind = txtSearchKindCd7.getText().toString();

                //나이와 상태 분리를 위해
                String AgePort = txtSearchAge7.getText().toString();
                Integer idx = AgePort.indexOf("(");
                Integer idx2 = AgePort.indexOf(")");
                String Age = AgePort.substring(0, idx);
                String State = null;
                if(idx == -1)
                {}
                else
                    State = AgePort.substring(idx+1, idx2);
                String Color = txtSearchColor7.getText().toString();
                String HappenPlace = txtSearchHappenPlace7.getText().toString();
                String CareNm = txtSearchNmProtect7.getText().toString();
                String CareTel = txtSearchTelProtect7.getText().toString();
                String Sex = txtSearchSex7.getText().toString();
                String Neuter = txtSearchNeut7.getText().toString();

                intent.putExtra("Image", image);
                intent.putExtra("Date", Date);
                intent.putExtra("Kind", Kind);
                intent.putExtra("Age", Age);
                intent.putExtra("State", State);
                intent.putExtra("Color", Color);
                intent.putExtra("HappenPlace", HappenPlace);
                intent.putExtra("Care", CareNm);
                intent.putExtra("Caretel", CareTel);
                intent.putExtra("Sex", Sex);
                intent.putExtra("Neuter", Neuter);
                startActivity(intent);
            }
        });


        imgSearchAnimal8.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), DetailActivity.class);

                String image = txtSearchImgString8.getText().toString();
                String Sdt = txtSearchNoticeSdt8.getText().toString();
                String Edt = txtSearchNoticeEdt8.getText().toString();
                String Date = Sdt.substring(0,4) + "-" + Sdt.substring(4,6) + "-" + Sdt.substring(6,8) + "  ~  " + Edt.substring(0,4) + "-" + Edt.substring(4,6) + "-" + Edt.substring(6,8);
                String Kind = txtSearchKindCd1.getText().toString();

                //나이와 상태 분리를 위해
                String AgePort = txtSearchAge8.getText().toString();
                Integer idx = AgePort.indexOf("(");
                Integer idx2 = AgePort.indexOf(")");
                String Age = AgePort.substring(0, idx);
                String State = null;
                if(idx == -1)
                {}
                else
                    State = AgePort.substring(idx+1, idx2);
                String Color = txtSearchColor8.getText().toString();
                String HappenPlace = txtSearchHappenPlace8.getText().toString();
                String CareNm = txtSearchNmProtect8.getText().toString();
                String CareTel = txtSearchTelProtect8.getText().toString();
                String Sex = txtSearchSex8.getText().toString();
                String Neuter = txtSearchNeut8.getText().toString();

                intent.putExtra("Image", image);
                intent.putExtra("Date", Date);
                intent.putExtra("Kind", Kind);
                intent.putExtra("Age", Age);
                intent.putExtra("State", State);
                intent.putExtra("Color", Color);
                intent.putExtra("HappenPlace", HappenPlace);
                intent.putExtra("Care", CareNm);
                intent.putExtra("Caretel", CareTel);
                intent.putExtra("Sex", Sex);
                intent.putExtra("Neuter", Neuter);
                startActivity(intent);
            }
        });


        imgSearchAnimal9.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), DetailActivity.class);

                String image = txtSearchImgString9.getText().toString();
                String Sdt = txtSearchNoticeSdt9.getText().toString();
                String Edt = txtSearchNoticeEdt9.getText().toString();
                String Date = Sdt.substring(0,4) + "-" + Sdt.substring(4,6) + "-" + Sdt.substring(6,8) + "  ~  " + Edt.substring(0,4) + "-" + Edt.substring(4,6) + "-" + Edt.substring(6,8);
                String Kind = txtSearchKindCd9.getText().toString();

                //나이와 상태 분리를 위해
                String AgePort = txtSearchAge9.getText().toString();
                Integer idx = AgePort.indexOf("(");
                Integer idx2 = AgePort.indexOf(")");
                String Age = AgePort.substring(0, idx);
                String State = null;
                if(idx == -1)
                {}
                else
                    State = AgePort.substring(idx+1, idx2);
                String Color = txtSearchColor9.getText().toString();
                String HappenPlace = txtSearchHappenPlace9.getText().toString();
                String CareNm = txtSearchNmProtect9.getText().toString();
                String CareTel = txtSearchTelProtect9.getText().toString();
                String Sex = txtSearchSex9.getText().toString();
                String Neuter = txtSearchNeut9.getText().toString();

                intent.putExtra("Image", image);
                intent.putExtra("Date", Date);
                intent.putExtra("Kind", Kind);
                intent.putExtra("Age", Age);
                intent.putExtra("State", State);
                intent.putExtra("Color", Color);
                intent.putExtra("HappenPlace", HappenPlace);
                intent.putExtra("Care", CareNm);
                intent.putExtra("Caretel", CareTel);
                intent.putExtra("Sex", Sex);
                intent.putExtra("Neuter", Neuter);
                startActivity(intent);
            }
        });


        imgSearchAnimal10.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), DetailActivity.class);

                String image = txtSearchImgString10.getText().toString();
                String Sdt = txtSearchNoticeSdt10.getText().toString();
                String Edt = txtSearchNoticeEdt10.getText().toString();
                String Date = Sdt.substring(0,4) + "-" + Sdt.substring(4,6) + "-" + Sdt.substring(6,8) + "  ~  " + Edt.substring(0,4) + "-" + Edt.substring(4,6) + "-" + Edt.substring(6,8);
                String Kind = txtSearchKindCd10.getText().toString();

                //나이와 상태 분리를 위해
                String AgePort = txtSearchAge10.getText().toString();
                Integer idx = AgePort.indexOf("(");
                Integer idx2 = AgePort.indexOf(")");
                String Age = AgePort.substring(0, idx);
                String State = null;
                if(idx == -1)
                {}
                else
                    State = AgePort.substring(idx+1, idx2);
                String Color = txtSearchColor10.getText().toString();
                String HappenPlace = txtSearchHappenPlace10.getText().toString();
                String CareNm = txtSearchNmProtect10.getText().toString();
                String CareTel = txtSearchTelProtect10.getText().toString();
                String Sex = txtSearchSex10.getText().toString();
                String Neuter = txtSearchNeut10.getText().toString();

                intent.putExtra("Image", image);
                intent.putExtra("Date", Date);
                intent.putExtra("Kind", Kind);
                intent.putExtra("Age", Age);
                intent.putExtra("State", State);
                intent.putExtra("Color", Color);
                intent.putExtra("HappenPlace", HappenPlace);
                intent.putExtra("Care", CareNm);
                intent.putExtra("Caretel", CareTel);
                intent.putExtra("Sex", Sex);
                intent.putExtra("Neuter", Neuter);
                startActivity(intent);
            }
        });

        //처음버튼
        btnPageFirst.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), SubActivity.class);
                intent.putExtra("Check", dataCheck);
                intent.putExtra("upr_cd", sido);
                intent.putExtra("org_cd", gungu);
                intent.putExtra("noticeSdt", startdate);
                intent.putExtra("noticeEdt", enddate);
                intent.putExtra("kindCd", kind);
                intent.putExtra("Page", "1");
                startActivity(intent);
                finish();
            }
        });

        //마지막버튼
        btnPageLast.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String str = txtSearchResult.getText().toString();
                Integer idx = str.indexOf("개");
                Integer maxPage = Integer.parseInt(str.substring(0,idx)) / 10 + 1;
                String mPage = String.valueOf(maxPage);

                Intent intent = new Intent(getApplicationContext(), SubActivity.class);
                intent.putExtra("Check", dataCheck);
                intent.putExtra("upr_cd", sido);
                intent.putExtra("org_cd", gungu);
                intent.putExtra("noticeSdt", startdate);
                intent.putExtra("noticeEdt", enddate);
                intent.putExtra("kindCd", kind);
                intent.putExtra("Page", mPage);
                startActivity(intent);
                finish();
            }
        });

        btnSearchPage2bNum1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String Page = btnSearchPage2bNum1.getText().toString();
                Intent intent = new Intent(getApplicationContext(), SubActivity.class);
                intent.putExtra("Check", dataCheck);
                intent.putExtra("upr_cd", sido);
                intent.putExtra("org_cd", gungu);
                intent.putExtra("noticeSdt", startdate);
                intent.putExtra("noticeEdt", enddate);
                intent.putExtra("kindCd", kind);
                intent.putExtra("Page", Page);
                startActivity(intent);
                finish();

            }
        });

        btnSearchPage2bNum2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String Page = btnSearchPage2bNum2.getText().toString();
                Intent intent = new Intent(getApplicationContext(), SubActivity.class);
                intent.putExtra("Check", dataCheck);
                intent.putExtra("upr_cd", sido);
                intent.putExtra("org_cd", gungu);
                intent.putExtra("noticeSdt", startdate);
                intent.putExtra("noticeEdt", enddate);
                intent.putExtra("kindCd", kind);
                intent.putExtra("Page", Page);
                startActivity(intent);
                finish();

            }
        });

        btnSearchPage3bNum1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String Page = btnSearchPage3bNum1.getText().toString();
                Intent intent = new Intent(getApplicationContext(), SubActivity.class);
                intent.putExtra("Check", dataCheck);
                intent.putExtra("upr_cd", sido);
                intent.putExtra("org_cd", gungu);
                intent.putExtra("noticeSdt", startdate);
                intent.putExtra("noticeEdt", enddate);
                intent.putExtra("kindCd", kind);
                intent.putExtra("Page", Page);
                startActivity(intent);
                finish();

            }
        });

        btnSearchPage3bNum2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String Page = btnSearchPage3bNum2.getText().toString();
                Intent intent = new Intent(getApplicationContext(), SubActivity.class);
                intent.putExtra("Check", dataCheck);
                intent.putExtra("upr_cd", sido);
                intent.putExtra("org_cd", gungu);
                intent.putExtra("noticeSdt", startdate);
                intent.putExtra("noticeEdt", enddate);
                intent.putExtra("kindCd", kind);
                intent.putExtra("Page", Page);
                startActivity(intent);
                finish();

            }
        });

        btnSearchPage3bNum3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String Page = btnSearchPage3bNum3.getText().toString();
                Intent intent = new Intent(getApplicationContext(), SubActivity.class);
                intent.putExtra("Check", dataCheck);
                intent.putExtra("upr_cd", sido);
                intent.putExtra("org_cd", gungu);
                intent.putExtra("noticeSdt", startdate);
                intent.putExtra("noticeEdt", enddate);
                intent.putExtra("kindCd", kind);
                intent.putExtra("Page", Page);
                startActivity(intent);
                finish();

            }
        });

        btnSearchPage4bNum1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String Page = btnSearchPage4bNum1.getText().toString();
                Intent intent = new Intent(getApplicationContext(), SubActivity.class);
                intent.putExtra("Check", dataCheck);
                intent.putExtra("upr_cd", sido);
                intent.putExtra("org_cd", gungu);
                intent.putExtra("noticeSdt", startdate);
                intent.putExtra("noticeEdt", enddate);
                intent.putExtra("kindCd", kind);
                intent.putExtra("Page", Page);
                startActivity(intent);
                finish();

            }
        });

        btnSearchPage4bNum2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String Page = btnSearchPage4bNum2.getText().toString();
                Intent intent = new Intent(getApplicationContext(), SubActivity.class);
                intent.putExtra("Check", dataCheck);
                intent.putExtra("upr_cd", sido);
                intent.putExtra("org_cd", gungu);
                intent.putExtra("noticeSdt", startdate);
                intent.putExtra("noticeEdt", enddate);
                intent.putExtra("kindCd", kind);
                intent.putExtra("Page", Page);
                startActivity(intent);
                finish();

            }
        });

        btnSearchPage4bNum3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String Page = btnSearchPage4bNum3.getText().toString();
                Intent intent = new Intent(getApplicationContext(), SubActivity.class);
                intent.putExtra("Check", dataCheck);
                intent.putExtra("upr_cd", sido);
                intent.putExtra("org_cd", gungu);
                intent.putExtra("noticeSdt", startdate);
                intent.putExtra("noticeEdt", enddate);
                intent.putExtra("kindCd", kind);
                intent.putExtra("Page", Page);
                startActivity(intent);
                finish();

            }
        });

        btnSearchPage4bNum4.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String Page = btnSearchPage4bNum4.getText().toString();
                Intent intent = new Intent(getApplicationContext(), SubActivity.class);
                intent.putExtra("Check", dataCheck);
                intent.putExtra("upr_cd", sido);
                intent.putExtra("org_cd", gungu);
                intent.putExtra("noticeSdt", startdate);
                intent.putExtra("noticeEdt", enddate);
                intent.putExtra("kindCd", kind);
                intent.putExtra("Page", Page);
                startActivity(intent);
                finish();

            }
        });

        btnSearchPage5bNum1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String Page = btnSearchPage5bNum1.getText().toString();
                Intent intent = new Intent(getApplicationContext(), SubActivity.class);
                intent.putExtra("Check", dataCheck);
                intent.putExtra("upr_cd", sido);
                intent.putExtra("org_cd", gungu);
                intent.putExtra("noticeSdt", startdate);
                intent.putExtra("noticeEdt", enddate);
                intent.putExtra("kindCd", kind);
                intent.putExtra("Page", Page);
                startActivity(intent);
                finish();

            }
        });

        btnSearchPage5bNum2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String Page = btnSearchPage5bNum2.getText().toString();
                Intent intent = new Intent(getApplicationContext(), SubActivity.class);
                intent.putExtra("Check", dataCheck);
                intent.putExtra("upr_cd", sido);
                intent.putExtra("org_cd", gungu);
                intent.putExtra("noticeSdt", startdate);
                intent.putExtra("noticeEdt", enddate);
                intent.putExtra("kindCd", kind);
                intent.putExtra("Page", Page);
                startActivity(intent);
                finish();

            }
        });

        btnSearchPage5bNum3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String Page = btnSearchPage5bNum3.getText().toString();
                Intent intent = new Intent(getApplicationContext(), SubActivity.class);
                intent.putExtra("Check", dataCheck);
                intent.putExtra("upr_cd", sido);
                intent.putExtra("org_cd", gungu);
                intent.putExtra("noticeSdt", startdate);
                intent.putExtra("noticeEdt", enddate);
                intent.putExtra("kindCd", kind);
                intent.putExtra("Page", Page);
                startActivity(intent);
                finish();

            }
        });

        btnSearchPage5bNum4.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String Page = btnSearchPage5bNum4.getText().toString();
                Intent intent = new Intent(getApplicationContext(), SubActivity.class);
                intent.putExtra("Check", dataCheck);
                intent.putExtra("upr_cd", sido);
                intent.putExtra("org_cd", gungu);
                intent.putExtra("noticeSdt", startdate);
                intent.putExtra("noticeEdt", enddate);
                intent.putExtra("kindCd", kind);
                intent.putExtra("Page", Page);
                startActivity(intent);
                finish();

            }
        });

        btnSearchPage5bNum5.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String Page = btnSearchPage5bNum5.getText().toString();
                Intent intent = new Intent(getApplicationContext(), SubActivity.class);
                intent.putExtra("Check", dataCheck);
                intent.putExtra("upr_cd", sido);
                intent.putExtra("org_cd", gungu);
                intent.putExtra("noticeSdt", startdate);
                intent.putExtra("noticeEdt", enddate);
                intent.putExtra("kindCd", kind);
                intent.putExtra("Page", Page);
                startActivity(intent);
                finish();

            }
        });

        //메인화면으로 이동
        Button btnSearchBack = (Button)findViewById(R.id.btnSearchBack);
        btnSearchBack.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        if(filename2 == null)
        {
            imgSearchAnimal2.setVisibility(View.GONE);
            txtSearchNoticeSdt2.setVisibility(View.GONE);
            txtSearchNoticeEdt2.setVisibility(View.GONE);
            txtSearchAge2.setVisibility(View.GONE);
            txtSearchKindCd2.setVisibility(View.GONE);
        }

        if(filename3 == null)
        {
            imgSearchAnimal3.setVisibility(View.GONE);
            txtSearchNoticeSdt3.setVisibility(View.GONE);
            txtSearchNoticeEdt3.setVisibility(View.GONE);
            txtSearchAge3.setVisibility(View.GONE);
            txtSearchKindCd3.setVisibility(View.GONE);
        }

        if(filename4 == null)
        {
            imgSearchAnimal4.setVisibility(View.GONE);
            txtSearchNoticeSdt4.setVisibility(View.GONE);
            txtSearchNoticeEdt4.setVisibility(View.GONE);
            txtSearchAge4.setVisibility(View.GONE);
            txtSearchKindCd4.setVisibility(View.GONE);
        }

        if(filename5 == null)
        {
            imgSearchAnimal5.setVisibility(View.GONE);
            txtSearchNoticeSdt5.setVisibility(View.GONE);
            txtSearchNoticeEdt5.setVisibility(View.GONE);
            txtSearchAge5.setVisibility(View.GONE);
            txtSearchKindCd5.setVisibility(View.GONE);
        }

        if(filename6 == null)
        {
            imgSearchAnimal6.setVisibility(View.GONE);
            txtSearchNoticeSdt6.setVisibility(View.GONE);
            txtSearchNoticeEdt6.setVisibility(View.GONE);
            txtSearchAge6.setVisibility(View.GONE);
            txtSearchKindCd6.setVisibility(View.GONE);
        }

        if(filename7 == null)
        {
            imgSearchAnimal7.setVisibility(View.GONE);
            txtSearchNoticeSdt7.setVisibility(View.GONE);
            txtSearchNoticeEdt7.setVisibility(View.GONE);
            txtSearchAge7.setVisibility(View.GONE);
            txtSearchKindCd7.setVisibility(View.GONE);
        }

        if(filename8 == null)
        {
            imgSearchAnimal8.setVisibility(View.GONE);
            txtSearchNoticeSdt8.setVisibility(View.GONE);
            txtSearchNoticeEdt8.setVisibility(View.GONE);
            txtSearchAge8.setVisibility(View.GONE);
            txtSearchKindCd8.setVisibility(View.GONE);
        }

        if(filename9 == null)
        {
            imgSearchAnimal9.setVisibility(View.GONE);
            txtSearchNoticeSdt9.setVisibility(View.GONE);
            txtSearchNoticeEdt9.setVisibility(View.GONE);
            txtSearchAge9.setVisibility(View.GONE);
            txtSearchKindCd9.setVisibility(View.GONE);
        }

        if(filename10 == null)
        {
            imgSearchAnimal10.setVisibility(View.GONE);
            txtSearchNoticeSdt10.setVisibility(View.GONE);
            txtSearchNoticeEdt10.setVisibility(View.GONE);
            txtSearchAge10.setVisibility(View.GONE);
            txtSearchKindCd10.setVisibility(View.GONE);
        }


    } // onCreate문
}
