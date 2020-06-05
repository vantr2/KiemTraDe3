package com.trongvan.kiemtrade3;

import android.graphics.Color;
import android.util.Log;

import java.util.ArrayList;
import java.util.Random;

public class TienIch {
    private int[] mangMau;

    private int getRandomARGB() {
        int alpha = 30 + new Random().nextInt(225);
        int red = new Random().nextInt(255);
        int green = new Random().nextInt(255);
        int blue = new Random().nextInt(255);
        return Color.argb(alpha,red,green,blue);
    }

    public TienIch(){
        mangMau = new int [101];
        for (int i = 0; i < mangMau.length; i++) {
            mangMau[i] = getRandomARGB();
        }
    }

    public void inMang(){
        for (int i = 0; i < mangMau.length; i++) {
            Log.e(MainActivity.TAG,"Phần tử thứ " + i + "là: " + mangMau[i]);
        }
    }

    public ArrayList<Integer> Intersect(int[] S){
        ArrayList<Integer> mangGiao = new ArrayList<>();
        for (int i = 0; i < S.length; i++) {
            for (int j = 0; j < mangMau.length; j++) {
                if(S[i] == mangMau[j]) {
                    mangGiao.add(S[i]);
                }
            }
        }
        return mangGiao;
    }

    public boolean InArray(int c){
        for (int i = 0; i < mangMau.length; i++) {
            if(c == mangMau[i]) return true;
        }
        return false;
    }



}
