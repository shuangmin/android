package rander.com.randerc.widget;

import android.content.Context;
import android.view.MotionEvent;

/**
 * Created by rander on 16-3-26.
 */
public abstract class BaseGestureDetector {
    //是否处于移动状态
    protected boolean mGestureInProgress;
    //上一次的移动事件
    protected MotionEvent mPreMotionEvent;
    //下一次的移动事件
    protected MotionEvent mCurrentMotionEvent;

    protected Context mContext;

    public BaseGestureDetector(Context context)
    {
        mContext = context;
    }

    public boolean onToucEvent(MotionEvent event)
    {
        //如果没有开始移动，则启动移动处理事件，否则处理正在移动的事件
        if (!mGestureInProgress)
        {
            handleStartProgressEvent(event);
        } else
        {
            handleInProgressEvent(event);
        }

        return true;

    }

    protected abstract void handleInProgressEvent(MotionEvent event);

    protected abstract void handleStartProgressEvent(MotionEvent event);

    protected abstract void updateStateByEvent(MotionEvent event);

    //状态恢复
    protected void resetState()
    {
        if (mPreMotionEvent != null)
        {
            mPreMotionEvent.recycle();
            mPreMotionEvent = null;
        }
        if (mCurrentMotionEvent != null)
        {
            mCurrentMotionEvent.recycle();
            mCurrentMotionEvent = null;
        }
        mGestureInProgress = false;
    }
}
