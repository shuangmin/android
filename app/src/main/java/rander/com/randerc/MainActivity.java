package rander.com.randerc;

import android.app.Activity;
import android.content.Intent;
import android.graphics.BitmapRegionDecoder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SectionIndexer;

import java.lang.StackTraceElement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import rander.com.randerc.activity.BigPicActivity;
import rander.com.randerc.activity.ScrollActivity;
import rander.com.randerc.adapter.CommonAdapter;
import rander.com.randerc.adapter.MyBaseAdapter;
import rander.com.randerc.adapter.NormalAdapter;
import rander.com.randerc.adapter.ViewHolder;
import rander.com.randerc.utils.L;
import rander.com.randerc.widget.ScrollLinearLayout;

public class MainActivity extends AppCompatActivity{

    ListView listView;
    Map<String,Class<?>> aClasses;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
        listView = new ListView(this);
        listView.setDescendantFocusability(ViewGroup.FOCUS_BLOCK_DESCENDANTS);
        final ArrayList<String> strs = new ArrayList<>((Set<String>)aClasses.keySet());
        listView.setAdapter(new MyBaseAdapter<String>(strs,R.layout.item,this) {
            @Override
            protected void convert(ViewHolder viewHolder, String s) {
                viewHolder.setTvText(R.id.title, s);
            }
        });
        setContentView(listView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Class<?> cl = aClasses.get(strs.get(position));
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,cl);
                startActivity(intent);
            }
        });
    }

    private void init() {
        aClasses = new LinkedHashMap<>();
        aClasses.put("View滚动方法", ScrollActivity.class);
        aClasses.put("巨图加载，不压缩", BigPicActivity.class);
    }

}
