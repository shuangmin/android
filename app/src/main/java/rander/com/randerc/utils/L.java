package rander.com.randerc.utils;

import android.util.Log;

/**
 * Created by rander on 16-3-23.
 */

/**
 * 自定义打印的类
 */
public class L {

    public static String getCaller() {
        int i;
        StackTraceElement[] stack = (new Throwable()).getStackTrace();
        if(stack != null && stack.length > 2)
        {
            StackTraceElement ste = stack[2];
            return  ste.getClassName() + "." + ste.getMethodName() + "(...)" + "[" + ste.getFileName() + "/" + ste.getLineNumber() + "]";
        }
        return new String();
    }

    private L() {
        /* cannot be instantiated */
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    public static boolean isDebug = true;// 是否需要打印bug，可以在application的onCreate函数里面初始化
    private static final String TAG = "way";

    // 下面四个是默认tag的函数
    public static void i(String msg) {
        if (isDebug)
            Log.i(TAG, msg + " " + getCaller());
    }

    public static void d(String msg) {
        if (isDebug)
            Log.d(TAG, msg + " " + getCaller());
    }

    public static void e(String msg) {
        if (isDebug)
            Log.e(TAG, msg + " " + getCaller());
    }

    public static void v(String msg) {
        if (isDebug)
            Log.v(TAG, msg + " " + getCaller());
    }

    // 下面是传入自定义tag的函数
    public static void i(String tag, String msg) {
        if (isDebug)
            Log.i(tag, msg + " " + getCaller());
    }

    public static void d(String tag, String msg) {
        if (isDebug)
            Log.i(tag, msg + " " + getCaller());
    }

    public static void e(String tag, String msg) {
        if (isDebug)
            Log.i(tag, msg + " " + getCaller());
    }

    public static void v(String tag, String msg) {
        if (isDebug)
            Log.i(tag, msg + " " + getCaller());
    }
}
