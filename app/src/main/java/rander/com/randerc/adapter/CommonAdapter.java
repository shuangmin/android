package rander.com.randerc.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import rander.com.randerc.R;

/**
 * Created by rander on 16-3-24.
 */
public class CommonAdapter<T> extends MyBaseAdapter {

    public CommonAdapter(List<T> datas, int layoutId, Context context) {
        super(datas, layoutId, context);
    }

    @Override
    protected void convert(ViewHolder viewHolder, Object o) {
        viewHolder.setTvText(R.id.title, (String) o);
    }
}
