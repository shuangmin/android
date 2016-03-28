package rander.com.randerc.activity;

import android.os.Bundle;
import android.widget.LinearLayout;

import rander.com.randerc.R;
import rander.com.randerc.widget.roundimg.RoundImageView;
import rander.com.randerc.widget.roundimg.XformodeRoundImageView;

/**
 * Created by rander on 16-3-29.
 */
public class RoundImageActivity extends BaseActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        LinearLayout linearLayout = new LinearLayout(this);
//        linearLayout.setOrientation(LinearLayout.VERTICAL);
//        linearLayout.addView(new RoundImageView(this));
//        LinearLayout linearLayout2 = new LinearLayout(this);
//        linearLayout2.setOrientation(LinearLayout.VERTICAL);
//        linearLayout2.addView(new XformodeRoundImageView(this));
//        LinearLayout l = new LinearLayout(this);
//        l.addView(linearLayout);
//        l.addView(linearLayout2);
        setContentView(R.layout.round_img_layout);
    }
}
