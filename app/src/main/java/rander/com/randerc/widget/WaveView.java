package rander.com.randerc.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.lang.ref.WeakReference;

import rander.com.randerc.R;

/**
 * Created by rander on 16-3-17.
 */
public class WaveView extends View{
    public WaveView(Context context) {
        this(context, null);
    }

    public WaveView(Context context, AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public WaveView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        //解析自定义属性
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.CanvasView, defStyleAttr, 0);
        final int count = typedArray.getIndexCount();
        for(int i=0 ;i < count;i++)
        {
            int attr = typedArray.getIndex(i);
            switch (attr)
            {
                case R.styleable.CanvasView_maxRadius:
                    maxRadius = typedArray.getInteger(attr,DEFAULT_RADIUS);
                    break;
            }
        }
        typedArray.recycle();
        init();
    }

    private Paint mPaint;
    /** 屏幕宽*/
    private int mScreenWith;
    /** 屏幕高*/
    private int mScreenHeight;
    /** 圆心x,y*/
    private int cx;
    private int cy;
    /** 半径，动态变化*/
    private int mRadius;
    /** 最大半径*/
    private int maxRadius = DEFAULT_RADIUS;
    /** 用户没设的时候默认最大半径*/
    private static final int DEFAULT_RADIUS = 200;

    private Handler mHandler;
    private void init() {
        mPaint = new Paint();
        mPaint.setColor(Color.RED);
        mPaint.setStrokeWidth(5);
        mPaint.setDither(true);
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.STROKE);
        mHandler = new WaveHandler(this);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mScreenWith = w;
        mScreenHeight = h;
        cx = mScreenWith/2;
        cy = mScreenHeight/2;
    }

    private static final int MSG = 0x7986;
    /** 是否需要递增*/
    private boolean isIncrease = true;
    static class WaveHandler extends Handler
    {
        WeakReference<WaveView> wrf;

        public WaveHandler(WaveView waveView) {
            this.wrf = new WeakReference<WaveView>(waveView);
        }

        @Override
        public void handleMessage(Message msg) {
            WaveView waveView = wrf.get();
            if(waveView == null)
            {
                removeCallbacksAndMessages(null);
                return;
            }
            waveView.handleMessage(msg);
        }
    }

    private void handleMessage(Message msg)
    {
        switch (msg.what)
        {
            case MSG:
                /**是递增*/
                if(isIncrease)
                {
                    /**超过最大值就递减*/
                    if(mRadius > maxRadius)
                    {
                        isIncrease = false;
                    }
                    else
                    {
                        mRadius++;
                    }
                }
                else
                {
                    /**小于0就递增*/
                    if(mRadius < 0)
                    {
                        isIncrease = true;
                    }
                    else
                    {
                        mRadius--;
                    }
                }
                invalidate();
                break;
        }
    }

    /**波浪数量*/
    private final int WAVE_COUNT = 10;
    @Override
    protected void onDraw(Canvas canvas) {

        for(int i=0;i<WAVE_COUNT;i++)
        {
            canvas.drawCircle(cx, cy, mRadius - 20 * i, mPaint);
        }
        mHandler.sendEmptyMessage(MSG);
        super.onDraw(canvas);
    }
}