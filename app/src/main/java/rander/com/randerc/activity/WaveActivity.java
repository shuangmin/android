package rander.com.randerc.activity;

import android.os.Bundle;

import rander.com.randerc.widget.WaveView;

/**
 * Created by rander on 16-3-26.
 */
public class WaveActivity extends BaseActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new WaveView(this));
    }
}
