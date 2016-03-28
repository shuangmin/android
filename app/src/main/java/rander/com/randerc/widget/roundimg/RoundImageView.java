package rander.com.randerc.widget.roundimg;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

import rander.com.randerc.R;

/**
 * Created by rander on 16-3-29.
 */

/**
 * 圆角图片，用BitmapShader实现
 */
public class RoundImageView extends View {
    private Bitmap mBitmap;
    private Paint mPaint;

    public RoundImageView(Context context) {
        this(context, null);
    }

    public RoundImageView(Context context, AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public RoundImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.lufei2);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setDither(true);
        mPaint.setShader(new BitmapShader(mBitmap, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawCircle(mBitmap.getWidth(), mBitmap.getHeight(), Math.min(mBitmap.getWidth(), mBitmap.getHeight()), mPaint);
    }
}
