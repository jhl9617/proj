package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;

public class SearchCondition extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_condition);


        EditText edtConditionStartDate= (EditText)findViewById(R.id.edtConditionStartDate); //검색시작일
        EditText edtConditionEndDate = (EditText)findViewById(R.id.edtConditionEndDate); //검색종료일
        Spinner edtConditionSido = (Spinner)findViewById(R.id.edtConditionSido); //시도 스피너
        Spinner edtConditionGungu = (Spinner)findViewById(R.id.edtConditionGungu); // 시군구 스피너
        Spinner edtConditionKind= (Spinner)findViewById(R.id.edtConditionKind); //검색 축종

        //시도 / 시군구 스피너

        String[] busan = getResources().getStringArray(R.array.busan);

        String[] sido = getResources().getStringArray(R.array.sido);

        String[] daegu = getResources().getStringArray(R.array.daegu);
        String[] daejeon = getResources().getStringArray(R.array.daejeon);
        String[] gwangju = getResources().getStringArray(R.array.gwangju);
        String[] incheon = getResources().getStringArray(R.array.incheon);
        String[] jeju = getResources().getStringArray(R.array.jeju);
        String[] kangwon = getResources().getStringArray(R.array.kangwon);
        String[] kyungki = getResources().getStringArray(R.array.kyungki);
        String[] northchun = getResources().getStringArray(R.array.northchun);
        String[] northchung = getResources().getStringArray(R.array.northchung);
        String[] northkyung = getResources().getStringArray(R.array.northkyung);
        String[] sejong = getResources().getStringArray(R.array.sejong);
        String[] seoul = getResources().getStringArray(R.array.seoul);
        String[] southchun = getResources().getStringArray(R.array.southchun);
        String[] southchung = getResources().getStringArray(R.array.southchung);
        String[] southkyung = getResources().getStringArray(R.array.southkyung);
        String[] ulsan = getResources().getStringArray(R.array.ulsan);
        String[] kind = getResources().getStringArray(R.array.kind);


        //시군구별 ArrayAdapter
        ArrayAdapter<String> adapterBusan = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, busan);
        adapterBusan.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item,sido);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        edtConditionSido.setAdapter(adapter);

        ArrayAdapter<String> adapterDaegu = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, daegu);
        adapterDaegu.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        ArrayAdapter<String> adapterDaejeon = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, daejeon);
        adapterDaejeon.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        ArrayAdapter<String> adapterGwangju = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, gwangju);
        adapterGwangju.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        ArrayAdapter<String> adapterIncheon = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, incheon);
        adapterIncheon.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        ArrayAdapter<String> adapterJeju = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, jeju);
        adapterJeju.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        ArrayAdapter<String> adapterKangwon = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, kangwon);
        adapterKangwon.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        ArrayAdapter<String> adapterKyungki = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, kyungki);
        adapterKyungki.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        ArrayAdapter<String> adapterNorthchun = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, northchun);
        adapterNorthchun.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        ArrayAdapter<String> adapterNorthchung = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, northchung);
        adapterNorthchung.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        ArrayAdapter<String> adapterNorthkyung = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, northkyung);
        adapterNorthkyung.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        ArrayAdapter<String> adapterSejong = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, sejong);
        adapterSejong.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        ArrayAdapter<String> adapterSeoul = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, seoul);
        adapterSeoul.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        ArrayAdapter<String> adapterSouthchun = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, southchun);
        adapterSouthchun.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        ArrayAdapter<String> adapterSouthchung = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, southchung);
        adapterSouthchung.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        ArrayAdapter<String> adapterSouthkyung = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, southkyung);
        adapterSouthkyung.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        ArrayAdapter<String> adapterUlsan = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, ulsan);
        adapterUlsan.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);



        //축종선택 스피너
        ArrayAdapter<String> adapterKind = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, kind);
        adapterKind.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        edtConditionKind.setAdapter(adapterKind);
        edtConditionKind.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(edtConditionKind.getSelectedItemPosition() >= 0)
                {
                    Log.v("알림", edtConditionKind.getSelectedItem().toString() + "is selected");
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        //스피너 세팅
        edtConditionSido.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            public void onItemSelected(AdapterView<?> adpaterView, View view, int i, long l)
            {
                if(edtConditionSido.getSelectedItemPosition() >= 0)
                {
                    //시도 선택데이터
                    String choice = edtConditionSido.getSelectedItem().toString();

                    //시도 선택에 따른 시군구 표시
                    switch(choice)
                    {
                        case "서울특별시":
                            edtConditionGungu.setAdapter(adapterSeoul);
                            edtConditionGungu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                    if(edtConditionGungu.getSelectedItemPosition() > 0)
                                    {
                                        Log.v("알림", edtConditionGungu.getSelectedItem().toString() + "is selected");
                                    }
                                }
                                @Override
                                public void onNothingSelected(AdapterView<?> parent) {

                                }
                            });
                            break;

                        case "부산광역시":
                            edtConditionGungu.setAdapter(adapterBusan);
                            edtConditionGungu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                    if(edtConditionGungu.getSelectedItemPosition() > 0)
                                    {
                                        Log.v("알림", edtConditionGungu.getSelectedItem().toString() + "is selected");
                                    }
                                }
                                @Override
                                public void onNothingSelected(AdapterView<?> parent) {

                                }
                            });
                            break;

                        case "대구광역시":
                            edtConditionGungu.setAdapter(adapterDaegu);
                            edtConditionGungu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                    if(edtConditionGungu.getSelectedItemPosition() > 0)
                                    {
                                        Log.v("알림", edtConditionGungu.getSelectedItem().toString() + "is selected");
                                    }
                                }
                                @Override
                                public void onNothingSelected(AdapterView<?> parent) {

                                }
                            });
                            break;

                        case "인천광역시":
                            edtConditionGungu.setAdapter(adapterIncheon);
                            edtConditionGungu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                    if(edtConditionGungu.getSelectedItemPosition() > 0)
                                    {
                                        Log.v("알림", edtConditionGungu.getSelectedItem().toString() + "is selected");
                                    }
                                }
                                @Override
                                public void onNothingSelected(AdapterView<?> parent) {

                                }
                            });
                            break;

                        case "세종특별자치시":
                            edtConditionGungu.setAdapter(adapterSejong);
                            edtConditionGungu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                    if(edtConditionGungu.getSelectedItemPosition() > 0)
                                    {
                                        Log.v("알림", edtConditionGungu.getSelectedItem().toString() + "is selected");
                                    }
                                }
                                @Override
                                public void onNothingSelected(AdapterView<?> parent) {

                                }
                            });
                            break;

                        case "대전광역시":
                            edtConditionGungu.setAdapter(adapterDaejeon);
                            edtConditionGungu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                    if(edtConditionGungu.getSelectedItemPosition() > 0)
                                    {
                                        Log.v("알림", edtConditionGungu.getSelectedItem().toString() + "is selected");
                                    }
                                }
                                @Override
                                public void onNothingSelected(AdapterView<?> parent) {

                                }
                            });
                            break;

                        case "울산광역시":
                            edtConditionGungu.setAdapter(adapterUlsan);
                            edtConditionGungu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                    if(edtConditionGungu.getSelectedItemPosition() > 0)
                                    {
                                        Log.v("알림", edtConditionGungu.getSelectedItem().toString() + "is selected");
                                    }
                                }
                                @Override
                                public void onNothingSelected(AdapterView<?> parent) {

                                }
                            });
                            break;

                        case "경기도":
                            edtConditionGungu.setAdapter(adapterKyungki);
                            edtConditionGungu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                    if(edtConditionGungu.getSelectedItemPosition() > 0)
                                    {
                                        Log.v("알림", edtConditionGungu.getSelectedItem().toString() + "is selected");
                                    }
                                }
                                @Override
                                public void onNothingSelected(AdapterView<?> parent) {

                                }
                            });
                            break;

                        case "강원도":
                            edtConditionGungu.setAdapter(adapterKangwon);
                            edtConditionGungu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                    if(edtConditionGungu.getSelectedItemPosition() > 0)
                                    {
                                        Log.v("알림", edtConditionGungu.getSelectedItem().toString() + "is selected");
                                    }
                                }
                                @Override
                                public void onNothingSelected(AdapterView<?> parent) {

                                }
                            });
                            break;

                        case "충청북도":
                            edtConditionGungu.setAdapter(adapterNorthchung);
                            edtConditionGungu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                    if(edtConditionGungu.getSelectedItemPosition() > 0)
                                    {
                                        Log.v("알림", edtConditionGungu.getSelectedItem().toString() + "is selected");
                                    }
                                }
                                @Override
                                public void onNothingSelected(AdapterView<?> parent) {

                                }
                            });
                            break;

                        case "충청남도":
                            edtConditionGungu.setAdapter(adapterSouthchung);
                            edtConditionGungu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                    if(edtConditionGungu.getSelectedItemPosition() > 0)
                                    {
                                        Log.v("알림", edtConditionGungu.getSelectedItem().toString() + "is selected");
                                    }
                                }
                                @Override
                                public void onNothingSelected(AdapterView<?> parent) {

                                }
                            });
                            break;

                        case "전라북도":
                            edtConditionGungu.setAdapter(adapterNorthchun);
                            edtConditionGungu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                    if(edtConditionGungu.getSelectedItemPosition() > 0)
                                    {
                                        Log.v("알림", edtConditionGungu.getSelectedItem().toString() + "is selected");
                                    }
                                }
                                @Override
                                public void onNothingSelected(AdapterView<?> parent) {

                                }
                            });
                            break;

                        case "전라남도":
                            edtConditionGungu.setAdapter(adapterSouthchun);
                            edtConditionGungu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                    if(edtConditionGungu.getSelectedItemPosition() > 0)
                                    {
                                        Log.v("알림", edtConditionGungu.getSelectedItem().toString() + "is selected");
                                    }
                                }
                                @Override
                                public void onNothingSelected(AdapterView<?> parent) {

                                }
                            });
                            break;

                        case "경상북도":
                            edtConditionGungu.setAdapter(adapterNorthkyung);
                            edtConditionGungu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                    if(edtConditionGungu.getSelectedItemPosition() > 0)
                                    {
                                        Log.v("알림", edtConditionGungu.getSelectedItem().toString() + "is selected");
                                    }
                                }
                                @Override
                                public void onNothingSelected(AdapterView<?> parent) {

                                }
                            });
                            break;

                        case "경상남도":
                            edtConditionGungu.setAdapter(adapterSouthkyung);
                            edtConditionGungu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                    if(edtConditionGungu.getSelectedItemPosition() > 0)
                                    {
                                        Log.v("알림", edtConditionGungu.getSelectedItem().toString() + "is selected");
                                    }
                                }
                                @Override
                                public void onNothingSelected(AdapterView<?> parent) {

                                }
                            });
                            break;

                        case "제주특별자치시":
                            edtConditionGungu.setAdapter(adapterJeju);
                            edtConditionGungu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                    if(edtConditionGungu.getSelectedItemPosition() > 0)
                                    {
                                        Log.v("알림", edtConditionGungu.getSelectedItem().toString() + "is selected");
                                    }
                                }
                                @Override
                                public void onNothingSelected(AdapterView<?> parent) {

                                }
                            });
                            break;

                        case "광주광역시":
                            edtConditionGungu.setAdapter(adapterGwangju);
                            edtConditionGungu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                    if(edtConditionGungu.getSelectedItemPosition() > 0)
                                    {
                                        Log.v("알림", edtConditionGungu.getSelectedItem().toString() + "is selected");
                                    }
                                }
                                @Override
                                public void onNothingSelected(AdapterView<?> parent) {

                                }
                            });
                            break;
                    }
                }
            }
            public void onNothingSelected(AdapterView<?> adapterView)
            {

            }

        });


        //시도,시군구 코드 추출을 위한 해시맵 ~
        HashMap<String, String> mapSido = new HashMap<String, String>();
        mapSido.put("서울특별시", "6110000");
        mapSido.put("부산광역시", "6260000");
        mapSido.put("대구광역시", "6270000");
        mapSido.put("인천광역시", "6280000");
        mapSido.put("광주광역시", "6290000");
        mapSido.put("세종특별자치시", "5690000");
        mapSido.put("대전광역시", "6300000");
        mapSido.put("울산광역시", "6310000");
        mapSido.put("경기도", "6410000");
        mapSido.put("강원도", "6420000");
        mapSido.put("충청북도", "6430000");
        mapSido.put("충청남도", "6440000");
        mapSido.put("전라북도", "6450000");
        mapSido.put("전라남도", "6460000");
        mapSido.put("경상북도", "6470000");
        mapSido.put("경상남도", "6480000");
        mapSido.put("제주특별자치시", "6500000");

        //서울테이블
        HashMap<String, String> mapSeoul = new HashMap<String, String>();
        mapSeoul.put("가정보호", "6119999");
        mapSeoul.put("강남구", "3220000");
        mapSeoul.put("강동구", "3240000");
        mapSeoul.put("강북구", "3080000");
        mapSeoul.put("강서구", "3150000");
        mapSeoul.put("관악구", "3200000");
        mapSeoul.put("광진구", "3040000");
        mapSeoul.put("구로구", "3160000");
        mapSeoul.put("금천구", "3170000");
        mapSeoul.put("노원구", "3100000");
        mapSeoul.put("도봉구", "3090000");
        mapSeoul.put("동대문구", "3050000");
        mapSeoul.put("동작구", "3190000");
        mapSeoul.put("마포구", "3130000");
        mapSeoul.put("서대문구", "3120000");
        mapSeoul.put("서초구", "3210000");
        mapSeoul.put("성동구", "3030000");
        mapSeoul.put("성북구", "3070000");
        mapSeoul.put("송파구", "3230000");
        mapSeoul.put("양천구", "3140000");
        mapSeoul.put("영등포구", "3180000");
        mapSeoul.put("용산구", "3020000");
        mapSeoul.put("은평구", "3110000");
        mapSeoul.put("종로구", "3000000");
        mapSeoul.put("중구", "3010000");
        mapSeoul.put("중랑구", "3060000");

        //부산테이블
        HashMap<String, String> mapBusan = new HashMap<String, String>();
        mapSeoul.put("강서구", "3360000");
        mapSeoul.put("금정구", "3350000");
        mapSeoul.put("기장군", "3400000");
        mapSeoul.put("남구", "3310000");
        mapSeoul.put("동구", "3270000");
        mapSeoul.put("동래구", "3300000");
        mapSeoul.put("부산진구", "3290000");
        mapSeoul.put("북구", "3320000");
        mapSeoul.put("사상구", "3390000");
        mapSeoul.put("사하구", "3340000");
        mapSeoul.put("서구", "3260000");
        mapSeoul.put("수영구", "3380000");
        mapSeoul.put("연제구", "3370000");
        mapSeoul.put("영도구", "3280000");
        mapSeoul.put("중구", "3250000");
        mapSeoul.put("해운대구", "3330000");

        //대구테이블
        HashMap<String, String> mapDaegu = new HashMap<String, String>();
        mapSeoul.put("남구", "3440000");
        mapSeoul.put("달서구", "3470000");
        mapSeoul.put("달성군", "3480000");
        mapSeoul.put("동구", "3420000");
        mapSeoul.put("북구", "3450000");
        mapSeoul.put("서구", "3430000");
        mapSeoul.put("수성군", "3460000");
        mapSeoul.put("중구", "3410000");

        //인천테이블
        HashMap<String, String> mapIncheon = new HashMap<String, String>();
        mapSeoul.put("강화군", "3570000");
        mapSeoul.put("계양구", "3550000");
        mapSeoul.put("남동구", "3530000");
        mapSeoul.put("동구", "3500000");
        mapSeoul.put("미추홀구", "3510500");
        mapSeoul.put("부평구", "3540000");
        mapSeoul.put("서구", "3560000");
        mapSeoul.put("연수구", "3520000");
        mapSeoul.put("옹진군", "3800000");
        mapSeoul.put("중구", "3490000");

        //광주테이블
        HashMap<String, String> mapGwangju = new HashMap<String, String>();
        mapSeoul.put("광산구", "3630000");
        mapSeoul.put("남구", "3610000");
        mapSeoul.put("동구", "3590000");
        mapSeoul.put("북구", "3620000");
        mapSeoul.put("서구", "3600000");

        //대전테이블
        HashMap<String, String> mapDaejeon = new HashMap<String, String>();
        mapSeoul.put("대덕구", "3680000");
        mapSeoul.put("동구", "3640000");
        mapSeoul.put("서구", "3660000");
        mapSeoul.put("유성구", "3670000");
        mapSeoul.put("중구", "3650000");

        //울산테이블
        HashMap<String, String> mapUlsan = new HashMap<String, String>();
        mapSeoul.put("남구", "3700000");
        mapSeoul.put("동구", "3710000");
        mapSeoul.put("북구", "3720000");
        mapSeoul.put("울주군", "3730000");
        mapSeoul.put("중구", "3690000");

        //경기도테이블
        HashMap<String, String> mapKyungki = new HashMap<String, String>();
        mapSeoul.put("가평군", "4160000");
        mapSeoul.put("고양시", "3940000");
        mapSeoul.put("과천시", "3970000");
        mapSeoul.put("광명시", "3900000");
        mapSeoul.put("광주시", "5540000");
        mapSeoul.put("구리시", "3980000");
        mapSeoul.put("군포시", "4020000");
        mapSeoul.put("김포시", "4090000");
        mapSeoul.put("남양주시", "3990000");
        mapSeoul.put("동두천시", "3920000");
        mapSeoul.put("부천시", "3860000");
        mapSeoul.put("성남시", "3780000");
        mapSeoul.put("수원시", "3740000");
        mapSeoul.put("시흥시", "4010000");
        mapSeoul.put("안산시", "3930000");
        mapSeoul.put("안성시", "4080000");
        mapSeoul.put("안양시", "3830000");
        mapSeoul.put("양주시", "5590000");
        mapSeoul.put("양평군", "4170000");
        mapSeoul.put("여주시", "5700000");
        mapSeoul.put("연천군", "4140000");
        mapSeoul.put("오산시", "4000000");
        mapSeoul.put("용인시", "4050000");
        mapSeoul.put("용인시 기흥구", "5630000");
        mapSeoul.put("의왕시", "4030000");
        mapSeoul.put("의정부시", "3820000");
        mapSeoul.put("이천시", "4070000");
        mapSeoul.put("파주시", "4060000");
        mapSeoul.put("평택시", "3910000");
        mapSeoul.put("포천시", "5600000");
        mapSeoul.put("하남시", "4040000");
        mapSeoul.put("화성시", "5530000");

        //강원도테이블
        HashMap<String, String> mapKangwon = new HashMap<String, String>();
        mapSeoul.put("강릉시", "4200000");
        mapSeoul.put("고성군", "4340000");
        mapSeoul.put("동해시", "4210000");
        mapSeoul.put("삼척시", "4240000");
        mapSeoul.put("속초시", "4230000");
        mapSeoul.put("양구군", "4320000");
        mapSeoul.put("양양군", "4350000");
        mapSeoul.put("영월군", "4270000");
        mapSeoul.put("원주시", "4190000");
        mapSeoul.put("인제군", "4330000");
        mapSeoul.put("정선군", "4290000");
        mapSeoul.put("철원군", "4300000");
        mapSeoul.put("춘천시", "4180000");
        mapSeoul.put("태백시", "4220000");
        mapSeoul.put("평창군", "4280000");
        mapSeoul.put("홍천군", "4250000");
        mapSeoul.put("화천군", "4310000");
        mapSeoul.put("횡성군", "4260000");

        //충청북도테이블
        HashMap<String, String> mapNorthchung = new HashMap<String, String>();
        mapSeoul.put("괴산군", "4460000");
        mapSeoul.put("단양군", "4480000");
        mapSeoul.put("보은군", "4420000");
        mapSeoul.put("영동군", "4440000");
        mapSeoul.put("옥천군", "4430000");
        mapSeoul.put("음성군", "4470000");
        mapSeoul.put("제천시", "4400000");
        mapSeoul.put("증평군", "5570000");
        mapSeoul.put("진천군", "4450000");
        mapSeoul.put("청주시", "5710000");
        mapSeoul.put("충주시", "4390000");

        //충청남도테이블
        HashMap<String, String> mapSouthchung = new HashMap<String, String>();
        mapSeoul.put("계룡시", "5580000");
        mapSeoul.put("공주시", "4500000");
        mapSeoul.put("금산군", "4550000");
        mapSeoul.put("논산시", "4540000");
        mapSeoul.put("당진시", "5680000");
        mapSeoul.put("보령시", "4510000");
        mapSeoul.put("부여군", "4570000");
        mapSeoul.put("서산시", "4530000");
        mapSeoul.put("서천군", "4580000");
        mapSeoul.put("아산시", "4520000");
        mapSeoul.put("연기군", "4560000");
        mapSeoul.put("예산군", "4610000");
        mapSeoul.put("천안시", "4490000");
        mapSeoul.put("청양군", "4590000");
        mapSeoul.put("태안군", "4620000");
        mapSeoul.put("홍성군", "4600000");

        //전라북도테이블
        HashMap<String, String> mapNorthchun = new HashMap<String, String>();
        mapSeoul.put("고창군", "4780000");
        mapSeoul.put("군산시", "4670000");
        mapSeoul.put("김제시", "4710000");
        mapSeoul.put("남원시", "4700000");
        mapSeoul.put("무주군", "4740000");
        mapSeoul.put("부안군", "4790000");
        mapSeoul.put("순창군", "4770000");
        mapSeoul.put("완주군", "4720000");
        mapSeoul.put("익산시", "4680000");
        mapSeoul.put("임실군", "4760000");
        mapSeoul.put("장수군", "4750000");
        mapSeoul.put("전주시", "4640000");
        mapSeoul.put("정읍시", "4690000");
        mapSeoul.put("진안군", "4730000");

        //전라남도테이블
        HashMap<String, String> mapSouthchun = new HashMap<String, String>();
        mapSeoul.put("강진군", "4920000");
        mapSeoul.put("고흥군", "4880000");
        mapSeoul.put("곡성군", "4860000");
        mapSeoul.put("광양시", "4840000");
        mapSeoul.put("구례군", "4870000");
        mapSeoul.put("나주시", "4830000");
        mapSeoul.put("담양군", "4850000");
        mapSeoul.put("목포시", "4800000");
        mapSeoul.put("무안군", "4950000");
        mapSeoul.put("보성군", "4890000");
        mapSeoul.put("순천시", "4820000");
        mapSeoul.put("신안군", "5010000");
        mapSeoul.put("여수시", "4810000");
        mapSeoul.put("영광군", "4970000");
        mapSeoul.put("영암군", "4940000");
        mapSeoul.put("완도군", "4990000");
        mapSeoul.put("장성군", "4980000");
        mapSeoul.put("장흥군", "4910000");
        mapSeoul.put("진도군", "5000000");
        mapSeoul.put("함평군", "4960000");
        mapSeoul.put("해남군", "4930000");
        mapSeoul.put("화순군", "4900000");

        //경상북도테이블
        HashMap<String, String> mapNorthkyung = new HashMap<String, String>();
        mapSeoul.put("경산시", "5130000");
        mapSeoul.put("경주시", "5050000");
        mapSeoul.put("고령군", "5200000");
        mapSeoul.put("구미시", "5080000");
        mapSeoul.put("군위군", "5140000");
        mapSeoul.put("김천시", "5060000");
        mapSeoul.put("문경시", "5120000");
        mapSeoul.put("봉화군", "5240000");
        mapSeoul.put("상주시", "5110000");
        mapSeoul.put("성주군", "5210000");
        mapSeoul.put("안동시", "5070000");
        mapSeoul.put("영덕군", "5180000");
        mapSeoul.put("영양군", "5170000");
        mapSeoul.put("영주시", "5090000");
        mapSeoul.put("영천시", "5100000");
        mapSeoul.put("예천군", "5230000");
        mapSeoul.put("울릉군", "5260000");
        mapSeoul.put("울진군", "5250000");
        mapSeoul.put("의성군", "5150000");
        mapSeoul.put("청도군", "5190000");
        mapSeoul.put("청송군", "5160000");
        mapSeoul.put("칠곡군", "5220000");
        mapSeoul.put("포항시", "5020000");

        //경상남도테이블
        HashMap<String, String> mapSouthkyung = new HashMap<String, String>();
        mapSeoul.put("거제시", "5370000");
        mapSeoul.put("거창군", "5470000");
        mapSeoul.put("고성군", "5420000");
        mapSeoul.put("김해시", "5350000");
        mapSeoul.put("남해군", "5430000");
        mapSeoul.put("밀양시", "5360000");
        mapSeoul.put("사천시", "5340000");
        mapSeoul.put("산청군", "5450000");
        mapSeoul.put("양산시", "5380000");
        mapSeoul.put("의령군", "5390000");
        mapSeoul.put("진주시", "5310000");
        mapSeoul.put("창녕군", "5410000");
        mapSeoul.put("창원 마산합포회원구", "5280000");
        mapSeoul.put("창원 의창성산구", "5670000");
        mapSeoul.put("창원 진해구", "5320000");
        mapSeoul.put("통영시", "5330000");
        mapSeoul.put("하동군", "5440000");
        mapSeoul.put("함안군", "5400000");
        mapSeoul.put("함양군", "5460000");
        mapSeoul.put("합천군", "5480000");

        //제주도
        HashMap<String, String> mapJeju = new HashMap<String, String>();
        mapSeoul.put("서귀포시", "6520000");
        mapSeoul.put("제주시", "6510000");
        mapSeoul.put("제주특별자치도", "6500000");

        //축종코드
        HashMap<String, String> mapKindCd = new HashMap<String, String>();
        mapKindCd.put("개", "417000");
        mapKindCd.put("고양이", "422400");
        mapKindCd.put("선택안함", "429900");



        //검색시작
        Button btnFinish = (Button)findViewById(R.id.btnConditionSearch);
        btnFinish.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                //검색조건 가공
                String city = edtConditionSido.getSelectedItem().toString();
                String gungu = edtConditionGungu.getSelectedItem().toString();
                String kindCd = edtConditionKind.getSelectedItem().toString();

                switch(city)
                {
                    case "서울특별시":
                        gungu = mapSeoul.get(gungu);
                        break;
                    case "부산광역시":
                        gungu = mapBusan.get(gungu);
                        break;
                    case "대구광역시":
                        gungu = mapDaegu.get(gungu);
                        break;
                    case "인천광역시":
                        gungu = mapIncheon.get(gungu);
                        break;
                    case "광주광역시":
                        gungu = mapGwangju.get(gungu);
                        break;
                    case "대전광역시":
                        gungu = mapDaejeon.get(gungu);
                        break;
                    case "울산광역시":
                        gungu = mapUlsan.get(gungu);
                        break;
                    case "경기도":
                        gungu = mapKyungki.get(gungu);
                        break;
                    case "강원도":
                        gungu = mapKangwon.get(gungu);
                        break;
                    case "충청북도":
                        gungu = mapNorthchung.get(gungu);
                        break;
                    case "충청남도":
                        gungu = mapSouthchung.get(gungu);
                        break;
                    case "전라북도":
                        gungu = mapNorthchun.get(gungu);
                        break;
                    case "전라남도":
                        gungu = mapSouthchun.get(gungu);
                        break;
                    case "경상북도":
                        gungu = mapNorthkyung.get(gungu);
                        break;
                    case "경상남도":
                        gungu = mapSouthkyung.get(gungu);
                        break;
                    case "제주특별자치시":
                        gungu = mapJeju.get(gungu);
                        break;
                }



                kindCd = mapKindCd.get(kindCd);
                String startDate = edtConditionStartDate.getText().toString();
                String endDate = edtConditionEndDate.getText().toString();
                city = mapSido.get(city);
                Boolean Search = true; // 검색조건을 통한 검색인 경우 True / Default는 False
                String default2 = "1"; // 검색 후는 기본적으로 1페이지로 이동

                Intent intent = new Intent(getApplicationContext(), SubActivity.class);
                intent.putExtra("upr_cd", city);
                intent.putExtra("org_cd", gungu);
                intent.putExtra("noticeSdt", startDate);
                intent.putExtra("noticeEdt", endDate);
                intent.putExtra("kindCd", kindCd);
                intent.putExtra("Page", default2);
                intent.putExtra("Check", Search);
                startActivity(intent);
                finish();
            }
        });

    }
}