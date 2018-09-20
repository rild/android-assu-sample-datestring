package com.lifeistech.android.stringdatetest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textview);

        // String 型の値を持っているのは Food クラス
        Food edit = new Food();


        // 変換対象の日付文字列
        String dateStr = edit.date;

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

        Date formatDate = new Date();
        try {
            // Date型変換
            formatDate = sdf.parse(dateStr);
        } catch (ParseException e) {

        }


        // Calendarクラスに変更
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(formatDate);

        // Calendarクラスからそれぞれの値を取り出す
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);  // １月: 0 １２月: 11 な点に注意
        int date = calendar.get(Calendar.DATE);
        Log.d("Check", "year: " + year);
        Log.d("Check", "month: " + month);
        Log.d("Check", "date: " + date);

        textView.setText(year + "/" + (month + 1) + "/" + date);
    }

    class Food {
        String date = "2018/09/21";
    }
}
