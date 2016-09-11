package com.bill.customlayout.layout;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/**
 * Created by Bill on 2016/9/11.
 */
public class BottomView extends LinearLayout {

    private Paint paint;
    private float gap = 5;
    private float radius = 5;
    private int circleNum;
    private float remain;

    public BottomView(Context context) {
        super(context);
        init();
    }

    public BottomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public BottomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setColor(Color.WHITE);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (remain == 0) {
            remain = (int) (w - gap) % (2 * radius + gap);
        }
        circleNum = (int) ((w - gap) / (2 * radius + gap));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int i = 0; i < circleNum; i++) {
            float x = gap + radius + remain / 2 + ((gap + radius * 2) * i);
            canvas.drawCircle(x, getHeight(), radius, paint);
        }
    }
}
