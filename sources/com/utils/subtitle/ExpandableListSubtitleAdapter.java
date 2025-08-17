package com.utils.subtitle;

import android.app.Activity;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;
import com.yoku.marumovie.R;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExpandableListSubtitleAdapter extends BaseExpandableListAdapter {

    /* renamed from: a  reason: collision with root package name */
    private Activity f37699a;

    /* renamed from: b  reason: collision with root package name */
    public Map<String, List<SubtitleInfo>> f37700b;

    /* renamed from: c  reason: collision with root package name */
    private List<String> f37701c = new ArrayList();

    public ExpandableListSubtitleAdapter(Activity activity, Map<String, List<SubtitleInfo>> map) {
        this.f37699a = activity;
        this.f37700b = map;
        Object[] array = map.keySet().toArray();
        for (int i2 = 0; i2 < map.size(); i2++) {
            this.f37701c.add(array[i2].toString());
        }
    }

    public Object getChild(int i2, int i3) {
        return this.f37700b.get(this.f37701c.get(i2)).get(i3);
    }

    public long getChildId(int i2, int i3) {
        return (long) i3;
    }

    public View getChildView(int i2, int i3, boolean z2, View view, ViewGroup viewGroup) {
        SubtitleInfo subtitleInfo = (SubtitleInfo) getChild(i2, i3);
        LayoutInflater layoutInflater = this.f37699a.getLayoutInflater();
        if (view == null) {
            view = layoutInflater.inflate(R.layout.child_listusbtitle_item, (ViewGroup) null);
        }
        ((TextView) view.findViewById(R.id.subtitle_child_name)).setText(subtitleInfo.f37702b);
        return view;
    }

    public int getChildrenCount(int i2) {
        return this.f37700b.get(this.f37701c.get(i2)).size();
    }

    public Object getGroup(int i2) {
        return this.f37701c.get(i2);
    }

    public int getGroupCount() {
        return this.f37701c.size();
    }

    public long getGroupId(int i2) {
        return (long) i2;
    }

    public View getGroupView(int i2, boolean z2, View view, ViewGroup viewGroup) {
        String str = (String) getGroup(i2);
        if (view == null) {
            view = ((LayoutInflater) this.f37699a.getSystemService("layout_inflater")).inflate(R.layout.group_subtitle_list_item, (ViewGroup) null);
        }
        TextView textView = (TextView) view.findViewById(R.id.groupSubtitleItem);
        textView.setTypeface((Typeface) null, 1);
        textView.setText(str);
        return view;
    }

    public boolean hasStableIds() {
        return true;
    }

    public boolean isChildSelectable(int i2, int i3) {
        return true;
    }
}
