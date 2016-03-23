package rander.com.randerc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.lang.StackTraceElement;

import rander.com.randerc.utils.L;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        L.e(getClass().getSimpleName(),"Hello World !");
    }


}
