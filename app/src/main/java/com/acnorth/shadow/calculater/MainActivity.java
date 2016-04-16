package com.acnorth.shadow.calculater;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class MainActivity extends Activity {

    int d;
    double num;
    EditText money,each,all;
    NumberPicker np1,np2;
    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,dot,back,cancle;
    int fei,ren;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        fei = 1;
        ren = 1;
        d = 0;
        num = 0;
        money = (EditText)findViewById(R.id.money_edittext);
        each = (EditText)findViewById(R.id.each_edittext);
        all = (EditText)findViewById(R.id.all_edittext);
        np1 = (NumberPicker)findViewById(R.id.fei_numberPicker);
        np2 = (NumberPicker)findViewById(R.id.ren_numberPicker);
        b1 = (Button)findViewById(R.id.one);
        b2 = (Button)findViewById(R.id.two);
        b3 = (Button)findViewById(R.id.three);
        b4 = (Button)findViewById(R.id.four);
        b5 = (Button)findViewById(R.id.five);
        b6 = (Button)findViewById(R.id.six);
        b7 = (Button)findViewById(R.id.seven);
        b8 = (Button)findViewById(R.id.eight);
        b9 = (Button)findViewById(R.id.nine);
        b0 = (Button)findViewById(R.id.zero);
        dot = (Button)findViewById(R.id.dot);
        back = (Button)findViewById(R.id.back);
        cancle = (Button)findViewById(R.id.cancle);
        np1.setMinValue(1);
        np1.setMaxValue(99);
        np1.setValue(1);
        np1.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                fei = newVal;
                OnShow();
            }
        });
        np2.setMinValue(1);
        np2.setMaxValue(200);
        np2.setValue(1);
        np2.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                ren = newVal;
                OnShow();
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (d == 0) {
                    num = num * 10 + 1;
                } else {
                    num = num + 1 / Math.pow(10, d++);
                }
                OnShow();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(d == 0) {
                    num = num*10+2;
                }
                else {
                    num = num+(double)2/Math.pow(10, d++);
                }
                OnShow();
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(d == 0) {
                    num = num*10+3;
                }
                else {
                    num = num+(double)3/Math.pow(10,d++);
                }
                OnShow();
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(d == 0) {
                    num = num*10+4;
                }
                else {
                    num = num+(double)4/Math.pow(10,d++);
                }
                OnShow();
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(d == 0) {
                    num = num*10+5;
                }
                else {
                    num = num+(double)5/Math.pow(10,d++);
                }
                OnShow();
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(d == 0) {
                    num = num*10+6;
                }
                else {
                    num = num+(double)6/Math.pow(10,d++);
                }
                OnShow();
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(d == 0) {
                    num = num*10+7;
                }
                else {
                    num = num+(double)7/Math.pow(10,d++);
                }
                OnShow();
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(d == 0) {
                    num = num*10+8;
                }
                else {
                    num = num+(double)8/Math.pow(10,d++);
                }
                OnShow();
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(d == 0) {
                    num = num*10+9;
                }
                else {
                    num = num+(double)9/Math.pow(10,d++);
                }
                OnShow();
            }
        });
        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(d == 0) {
                    num = num*10;
                }
                else {
                    d++;
                }
                OnShow();
            }
        });
        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(d == 0) {
                    d++;
                }
                OnShow();
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(d == 0) {
                    num = (int)num/10;
                }
                else {
                    d--;
                    num = (int)(num*Math.pow(10,d));
                    num = num/Math.pow(10,d);
                }
                OnShow();
            }
        });
        cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d = 0;
                num = 0;
                OnShow();
            }
        });
    }
    private void OnShow()
    {
        BigDecimal b = new BigDecimal(num);
        double num = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        money.setText(Double.toString(num));
        DecimalFormat df = new DecimalFormat("#.00");
        double X = num/ren+num*fei/100/ren;
        double Y = num+num*fei/100;
        df.format(X);
//        df.format(Y);
//        BigDecimal x = new BigDecimal((double)(num/ren+num*fei/100/ren));
//        double X = x.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
//        BigDecimal y = new BigDecimal((double)(num+num*fei/100));
//        double Y = y.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        String a = num + "/" + ren + "+" + num + "*" + fei + "%/" + ren + "=" + X;
        String c = num + "+" + num + "*" + fei + "% =" + Y;
//        String a = Double.toString(num / ren + num * fei / 100 / ren);
//        String c = Double.toString(num+num*fei/100);
        each.setText(a);
        all.setText(c);
    }
}
