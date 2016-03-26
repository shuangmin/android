package rander.com.randerc.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Rect;
import android.os.Bundle;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;

import rander.com.randerc.widget.LargeImageView;

/**
 * Created by rander on 16-3-26.
 */
public class BigPicActivity extends BaseActivity {
    BitmapRegionDecoder bitmapRegionDecoder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        initView1();

        initView2();
    }

    private void initView2(){
        LargeImageView largeImageView = new LargeImageView(this);
        try {
            InputStream inputStream = getAssets().open("bigpicture.jpg");
            largeImageView.setInputStream(inputStream);
            setContentView(largeImageView);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initView1() {
        try {
            InputStream inputStream = getAssets().open("beauty.jpg");
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(inputStream, null, options);
            int width = options.outWidth;
            int height = options.outHeight;
            bitmapRegionDecoder = BitmapRegionDecoder.newInstance(inputStream, false);
            BitmapFactory.Options opts = new BitmapFactory.Options();
            opts.inPreferredConfig = Bitmap.Config.RGB_565;
            Bitmap bitmap = bitmapRegionDecoder.decodeRegion(new Rect(width / 2 - 100, height / 2 - 100, width / 2 + 100, height / 2 + 100), opts);
            ImageView imageView = new ImageView(this);
            imageView.setImageBitmap(bitmap);
            setContentView(imageView);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
