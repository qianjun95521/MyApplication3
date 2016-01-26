package com.example.think.myapplication;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by think on 2016/1/10.
 */
public class MyTextView extends TextView {

    private Paint marginPaint;
    private Paint linePaint;
    private int paperColor;
    private float margin;

    public MyTextView(Context context) {
        super(context);
        init();
    }

    public MyTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        Resources myResources=this.getResources();
        marginPaint=new Paint(Paint.ANTI_ALIAS_FLAG);
        marginPaint.setColor(myResources.getColor(R.color.notepad_margin));
        linePaint=new Paint(Paint.ANTI_ALIAS_FLAG);
        linePaint.setColor(myResources.getColor(R.color.notepad_lines));
        paperColor=myResources.getColor(R.color.notepad_page);
        margin=myResources.getDimension(R.dimen.notepad_margin);

    }
    @Override
    protected void onDraw(Canvas canvas) {
       // canvas.drawColor(paperColor);
        canvas.drawLine(0,0,0,getMeasuredHeight(),linePaint);
        canvas.drawLine(0,getMeasuredHeight(),getMeasuredWidth(),getMeasuredHeight(),linePaint);
        canvas.drawLine(margin,0,margin,getMeasuredHeight(),marginPaint);
        canvas.save();
        canvas.translate(margin,0);
        super.onDraw(canvas);
        canvas.restore();
    }
}
