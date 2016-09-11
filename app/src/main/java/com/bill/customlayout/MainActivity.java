package com.bill.customlayout;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button clickBtn;
    private View myView;
    private final static int TIME = 300;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 1:
                    myView.setBackgroundColor(Color.parseColor("#FFCF72"));
                    handler.sendEmptyMessageDelayed(2, TIME);
                    break;
                case 2:
                    myView.setBackgroundColor(Color.parseColor("#31CFF4"));
                    handler.sendEmptyMessageDelayed(3, TIME);
                    break;
                case 3:
                    myView.setBackgroundColor(Color.parseColor("#FF5F7C"));
                    handler.sendEmptyMessageDelayed(4, TIME);
                    break;
                case 4:
                    myView.setBackgroundColor(Color.parseColor("#42D5BA"));
                    handler.sendEmptyMessageDelayed(1, TIME);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myView = findViewById(R.id.myview);
        clickBtn = (Button) findViewById(R.id.btn_click);
        clickBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                setFlickerAnimation(myView);
                handler.sendEmptyMessageDelayed(1, TIME);
            }
        });
    }

    private void tweenAnimation(){
        myView.setBackgroundResource(R.drawable.remote_recording_transition);
        AnimationDrawable recordingTransition = (AnimationDrawable) myView.getBackground();
        recordingTransition.start();
    }

    private void setFlickerAnimation(View iv_chat_head) {
        ValueAnimator colorAnim = ObjectAnimator.ofInt(iv_chat_head, "backgroundColor",
                Color.parseColor("#FFCF72"),
                Color.parseColor("#31CFF4"),
                Color.parseColor("#FF5F7C"),
                Color.parseColor("#42D5BA")
                );
        colorAnim.setDuration(800);
        colorAnim.setEvaluator(new ArgbEvaluator());
        colorAnim.setRepeatCount(ValueAnimator.INFINITE);
        colorAnim.setRepeatMode(ValueAnimator.REVERSE);
        colorAnim.start();
    }
}
