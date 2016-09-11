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
public class CouponDisplayView extends LinearLayout {

    private Paint paint;
    private float gap = 8;
    private float radius = 10;
    private int circleNum;
    private float remain;

    public CouponDisplayView(Context context) {
        super(context);
        init();
    }

    public CouponDisplayView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CouponDisplayView(Context context, AttributeSet attrs, int defStyleAttr) {
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
            canvas.drawCircle(x, 0, radius, paint);
            canvas.drawCircle(x, getHeight(), radius, paint);
        }
    }
}
