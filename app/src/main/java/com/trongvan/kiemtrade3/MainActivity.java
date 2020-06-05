package com.trongvan.kiemtrade3;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final String XANH = "#48FF00";
    public static final String DO = "#ff0000";
    public static final String TIM = "#ff00ff";
    public static final String VANG = "#ffff00";
    public static final String TAG = "ktd3";

    private TextView do1, do2, do3, xanh1, xanh2, xanh3, tim1, tim2, tim3, vang1, vang2, vang3;

    private int trangthai = 0;
    private int c = -1;
    private long startTime = 0;
    private ArrayList<Long> timeList;

    private TienIch tienIch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        timeList = new ArrayList<>();

        tienIch = new TienIch();
        tienIch.inMang();
    }

    private void initView() {
        do1 = (TextView) findViewById(R.id.do1);
        do2 = (TextView) findViewById(R.id.do2);
        do3 = (TextView) findViewById(R.id.do3);

        vang1 = (TextView) findViewById(R.id.vang1);
        vang2 = (TextView) findViewById(R.id.vang2);
        vang3 = (TextView) findViewById(R.id.vang3);

        tim1 = (TextView) findViewById(R.id.tim1);
        tim2 = (TextView) findViewById(R.id.tim2);
        tim3 = (TextView) findViewById(R.id.tim3);

        xanh1 = (TextView) findViewById(R.id.xanh1);
        xanh2 = (TextView) findViewById(R.id.xanh2);
        xanh3 = (TextView) findViewById(R.id.xanh3);
    }

    public void containerClick(View view) {
        if (startTime != 0) {
            long diff = System.currentTimeMillis() - startTime;
            timeList.add(diff);
        }
        doiTrangThai();
        startTime = System.currentTimeMillis();
    }

    private void doiTrangThai() {
        trangthai++;

        switch (trangthai) {
            case 1:
                quay(XANH, VANG, TIM, DO);
                break;
            case 2:
                quay(DO, XANH, VANG, TIM);
                break;
            case 3:
                quay(TIM, DO, XANH, VANG);
                break;
            case 4:
                quay(VANG, TIM, DO, XANH);
                break;
        }
        if (trangthai == 4) {
            trangthai = 0;
        }
    }

    private void quay(String color1, String color2, String color3, String color4) {
        vang1.setBackgroundColor(Color.parseColor(color1));
        vang2.setBackgroundColor(Color.parseColor(color1));
        vang3.setBackgroundColor(Color.parseColor(color1));

        tim1.setBackgroundColor(Color.parseColor(color2));
        tim2.setBackgroundColor(Color.parseColor(color2));
        tim3.setBackgroundColor(Color.parseColor(color2));

        do1.setBackgroundColor(Color.parseColor(color3));
        do2.setBackgroundColor(Color.parseColor(color3));
        do3.setBackgroundColor(Color.parseColor(color3));

        xanh1.setBackgroundColor(Color.parseColor(color4));
        xanh2.setBackgroundColor(Color.parseColor(color4));
        xanh3.setBackgroundColor(Color.parseColor(color4));
    }

    private long maxElement(ArrayList<Long> list) {
        long max = 0;
        if (!list.isEmpty()) {
            max = list.get(0);
            for (int i = 1; i < list.size(); i++) {
                if(list.get(i) > max){
                    max = list.get(i);
                }
            }
        }
        return max;
    }

    @Override
    protected void onStop() {
        c = (int) maxElement(timeList)/1000 ;
        if(c == 0){
            Log.e(TAG,"Chưa click lần nào");
        }else{
            if(tienIch.InArray(c)){
                Log.e(TAG,c + " - Có");
            }else{
                Log.e(TAG,c + " - Không");
            }
        }
        super.onStop();
    }
}
