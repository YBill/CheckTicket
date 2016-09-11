package com.bill.customlayout;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CheckTicketActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView[] textViews = new TextView[4];
    private Integer[] ids = new Integer[]{
            R.id.tv_1, R.id.tv_2, R.id.tv_3, R.id.tv_4
    };
    private int NUMBER1 = 0, NUMBER2 = 0, NUMBER3 = 0, NUMBER4 = 0;
    private final static int TIME = 400;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    for (int i = 0; i < ids.length; i++) {
                        textViews[i].setBackgroundColor(Color.parseColor("#FFCF72"));
                    }
                    handler.sendEmptyMessageDelayed(2, TIME);
                    break;
                case 2:
                    for (int i = 0; i < ids.length; i++) {
                        textViews[i].setBackgroundColor(Color.parseColor("#31CFF4"));
                    }
                    handler.sendEmptyMessageDelayed(3, TIME);
                    break;
                case 3:
                    for (int i = 0; i < ids.length; i++) {
                        textViews[i].setBackgroundColor(Color.parseColor("#FF5F7C"));
                    }
                    handler.sendEmptyMessageDelayed(4, TIME);
                    break;
                case 4:
                    for (int i = 0; i < ids.length; i++) {
                        textViews[i].setBackgroundColor(Color.parseColor("#42D5BA"));
                    }
                    handler.sendEmptyMessageDelayed(1, TIME);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_ticket);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.back2);

        for (int i = 0; i < ids.length; i++) {
            textViews[i] = (TextView) findViewById(ids[i]);
            textViews[i].setOnClickListener(this);
        }

        NUMBER1 = 5;
        NUMBER2 = 5;
        NUMBER3 = 5;
        NUMBER4 = 5;
        textViews[0].setText("" + NUMBER1);
        textViews[1].setText("" + NUMBER2);
        textViews[2].setText("" + NUMBER3);
        textViews[3].setText("" + NUMBER4);

        SimpleDateFormat matter = new SimpleDateFormat("MM月dd日");
        TextView dateText = (TextView) findViewById(R.id.tv_date);
        dateText.setText(matter.format(new Date()));

        handler.sendEmptyMessageDelayed(1, TIME);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_1:
                NUMBER1++;
                if (NUMBER1 > 9)
                    NUMBER1 = 0;
                textViews[0].setText("" + NUMBER1);
                break;
            case R.id.tv_2:
                NUMBER2++;
                if (NUMBER2 > 9)
                    NUMBER2 = 0;
                textViews[1].setText("" + NUMBER2);
                break;
            case R.id.tv_3:
                NUMBER3++;
                if (NUMBER3 > 9)
                    NUMBER3 = 0;
                textViews[2].setText("" + NUMBER3);
                break;
            case R.id.tv_4:
                NUMBER4++;
                if (NUMBER4 > 9)
                    NUMBER4 = 0;
                textViews[3].setText("" + NUMBER4);
                break;
        }
    }
}
