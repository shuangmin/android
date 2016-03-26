package rander.com.randerc.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import rander.com.randerc.R;
import rander.com.randerc.widget.ScrollLinearLayout;

/**
 * Created by rander on 16-3-26.
 */
public class ScrollActivity extends BaseActivity implements ScrollLinearLayout.OnPositionChanageListener{
    Button btn_scrollTo;
    Button btn_scrollBy;
    Button btn_scroller;
    ScrollLinearLayout scrollLinearlayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scroll_layout);
        scrollLinearlayout = (ScrollLinearLayout) findViewById(R.id.scrollLinearlayout);
        btn_scrollTo = (Button) findViewById(R.id.scrollTo);
        btn_scrollBy = (Button)findViewById(R.id.scrollBy);
        btn_scroller = (Button) findViewById(R.id.scroller);
        btn_scrollTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrollLinearlayout.setMode(ScrollLinearLayout.Mode.SCROLL_TO);
            }
        });
        btn_scrollBy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrollLinearlayout.setMode(ScrollLinearLayout.Mode.SCROLL_BY);
            }
        });
        btn_scroller.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrollLinearlayout.setMode(ScrollLinearLayout.Mode.SCROLLER);
            }
        });
        scrollLinearlayout.setOnPositionChanageListener(this);
    }

    @Override
    public void onPositionChanged(int x, int y) {
        if(scrollLinearlayout.getMode() == ScrollLinearLayout.Mode.SCROLL_TO)
        {
            btn_scrollTo.setText("scrollTo(" + x + "," + y + ")");
        }
        else if(scrollLinearlayout.getMode() == ScrollLinearLayout.Mode.SCROLL_BY)
        {
            btn_scrollBy.setText("scrollBy(" + x + "," + y + ")");
        }
        else if(scrollLinearlayout.getMode() == ScrollLinearLayout.Mode.SCROLLER)
        {
            btn_scroller.setText("startScroll(" + x + "," + y + ")");
        }
    }
}
