package rander.com.randerc.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

import rander.com.randerc.R;

/**
 * Created by rander on 16-3-24.
 */
public class NormalAdapter extends BaseAdapter{
    protected String[] datas = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X"};
    private LayoutInflater layoutInflater;
    private Context mContext;

    public NormalAdapter(Context mContext) {
        this.datas = datas;
        this.mContext = mContext;
        layoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return datas.length;
    }

    @Override
    public Object getItem(int position) {
        return datas[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
//        ViewHolder viewHolder;
//        if(convertView == null)
//        {
//            convertView = layoutInflater.inflate(R.layout.item,parent,false);
//            viewHolder = new ViewHolder();
//            viewHolder.tvTitle = (TextView) convertView.findViewById(R.id.title);
//            viewHolder.btnConfirm = (Button) convertView.findViewById(R.id.ok);
//            convertView.setTag(viewHolder);
//        }
//        else
//        {
//            viewHolder = (ViewHolder) convertView.getTag();
//        }
//        viewHolder.tvTitle.setText(datas[position]);
//        viewHolder.btnConfirm.setText(datas[position]);
//        ViewHolder viewHolder = ViewHolder.get(position, convertView, parent, R.layout.item, mContext);
//        TextView textView = viewHolder.getView(R.id.title);
//        textView.setText(datas[position]);
//        Button btn = viewHolder.getView(R.id.ok);
//        btn.setText(datas[position]);
        return new View(mContext);
    }

//    static class ViewHolder
//    {
//        TextView tvTitle;
//        Button btnConfirm;
//    }
}
