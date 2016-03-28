package rander.com.randerc.widget.roundimg;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.View;

import rander.com.randerc.R;

/**
 * Created by rander on 16-3-29.
 */
public class XformodeRoundImageView extends View{
    private Bitmap mSrcBitmap;
    private Bitmap mDstBitmap;
    private Paint mPaint;
    public XformodeRoundImageView(Context context) {
        this(context, null);
    }

    public XformodeRoundImageView(Context context, AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public XformodeRoundImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        //关闭硬件加速
        setLayerType(LAYER_TYPE_SOFTWARE,null);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setDither(true);
        mPaint.setColor(Color.RED);
        mSrcBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.lufei2);
        mDstBitmap = Bitmap.createBitmap(mSrcBitmap.getWidth(),mSrcBitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(mDstBitmap);
//        canvas.drawRoundRect(0, 0, mDstBitmap.getWidth(), mDstBitmap.getHeight(),
//                50, 50, mPaint);
//        canvas.drawCircle(mDstBitmap.getWidth()/2,mDstBitmap.getHeight()/2,Math.min(mDstBitmap.getWidth(),mDstBitmap.getHeight()),mPaint);
        canvas.drawCircle(mDstBitmap.getWidth()/2,mDstBitmap.getHeight()/2,60,mPaint);
        mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(mSrcBitmap,0,0,mPaint);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawBitmap(mDstBitmap,0,0,null);
    }
}
