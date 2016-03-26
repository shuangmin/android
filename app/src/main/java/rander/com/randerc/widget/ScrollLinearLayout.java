package rander.com.randerc.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Scroller;

import rander.com.randerc.utils.L;

import static rander.com.randerc.widget.ScrollLinearLayout.Mode.SCROLLER;
import static rander.com.randerc.widget.ScrollLinearLayout.Mode.SCROLL_BY;
import static rander.com.randerc.widget.ScrollLinearLayout.Mode.SCROLL_TO;

/**
 * Created by rander on 16-3-26.
 */
public class ScrollLinearLayout extends LinearLayout{
    Scroller mScroller;
    public enum Mode
    {
        SCROLL_TO,
        SCROLL_BY,
        SCROLLER,
    }

    public Mode mode = SCROLL_TO;
    public ScrollLinearLayout(Context context) {
        this(context, null);
    }

    public ScrollLinearLayout(Context context, AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public ScrollLinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public void setMode(Mode mode) {
        this.mode = mode;
        if(mode == SCROLLER)
        {
            mScroller.startScroll(0,0,-100 ,-50,1200) ;

            invalidate();
        }
    }

    public Mode getMode() {
        return mode;
    }

    Button btn;
    private void init() {
        setBackgroundColor(getResources().getColor(android.R.color.holo_blue_bright));
        btn = new Button(getContext());
        btn.setText("Hello");
        btn.setClickable(false);
        btn.setFocusable(false);
        LayoutParams lp = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        addView(btn,lp);

        Button btn1 = new Button(getContext());
        btn1.setText("Hello1");
        btn1.setClickable(false);
        btn1.setFocusable(false);
        addView(btn1, lp);

        mScroller = new Scroller(getContext());
    }

    int oldX;
    int oldY;

    public interface OnPositionChanageListener
    {
        void onPositionChanged(int x,int y);
    }

    OnPositionChanageListener listener;

    public void setOnPositionChanageListener(OnPositionChanageListener listener)
    {
        this.listener = listener;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int curX = (int) event.getX();
        int curY = (int) event.getY();
        switch (event.getAction())
        {
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_MOVE:
                btn.offsetLeftAndRight(curX - oldX);
                btn.offsetTopAndBottom(curY - oldY);
                scrollTo(-curX,-curY);
                switch (mode)
                {
                    case SCROLL_TO:
                        //按照绝对偏移量进行移动
                        scrollTo(-curX, -curY);
                        if(null != listener)
                        {
                            listener.onPositionChanged(-curX,-curY);
                        }
                        break;
                    case SCROLL_BY:
                        //按照相对偏移量进行移动
                        scrollBy(oldX-curX,oldY-curY);
                        if(null != listener)
                        {
                            listener.onPositionChanged(oldX-curX,oldY-curY);
                        }
                        break;
                    case SCROLLER:

                        break;
                }
                oldX = curX;
                oldY = curY;
//                btn.setX(curX - btn.getMeasuredWidth()/2);
//                btn.setY(curY - btn.getMeasuredHeight()/2);

                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        return true;
    }

    @Override
    public void computeScroll() {
        L.d("=====>>>>>>>>>> computeScroll ");
        if(mode != SCROLLER ) return;
        if (mScroller.computeScrollOffset()) {
            scrollTo(mScroller.getCurrX(), mScroller.getCurrY());
            postInvalidate();
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(800,300);
    }
}
