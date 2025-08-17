package com.movie.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.original.tase.model.media.MediaSource;
import com.yoku.marumovie.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MediaSourceArrayAdapter extends ArrayAdapter<MediaSource> {

    /* renamed from: b  reason: collision with root package name */
    private final int f33084b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public List<MediaSource> f33085c;

    /* renamed from: d  reason: collision with root package name */
    private final LayoutInflater f33086d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public Listener f33087e = null;

    public interface Listener {
        void o(MediaSource mediaSource);
    }

    public MediaSourceArrayAdapter(Context context, int i2, List<MediaSource> list) {
        super(context, i2, 0, list);
        this.f33084b = i2;
        this.f33086d = LayoutInflater.from(context);
        this.f33085c = list;
    }

    public void c(MediaSource mediaSource) {
        if (mediaSource != null && !this.f33085c.contains(mediaSource)) {
            this.f33085c.add(mediaSource);
        }
    }

    public void clear() {
        List<MediaSource> list = this.f33085c;
        if (list != null) {
            list.clear();
        } else {
            this.f33085c = new ArrayList();
        }
    }

    public void d(Listener listener) {
        this.f33087e = listener;
    }

    public void e() {
        Collections.sort(this.f33085c);
        notifyDataSetChanged();
    }

    public int getCount() {
        return this.f33085c.size();
    }

    public View getView(int i2, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f33086d.inflate(this.f33084b, viewGroup, false);
        }
        try {
            LinearLayout linearLayout = (LinearLayout) view;
            TextView textView = (TextView) linearLayout.findViewById(R.id.text1);
            ImageButton imageButton = (ImageButton) linearLayout.findViewById(R.id.download_btn);
            MediaSource mediaSource = (MediaSource) getItem(i2);
            if (mediaSource != null) {
                textView.setText(mediaSource.toString2());
                if (!mediaSource.isDebrid()) {
                    textView.setTextColor(-1);
                } else if (mediaSource.isRawTorrent()) {
                    textView.setTextColor(-16711936);
                } else {
                    textView.setTextColor(-256);
                }
                if (mediaSource.isPlayed()) {
                    textView.setTextColor(-7829368);
                }
            }
            if (mediaSource.isHLS()) {
                imageButton.setVisibility(8);
            } else {
                imageButton.setVisibility(0);
                imageButton.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        View view2 = (View) view.getParent();
                        MediaSourceArrayAdapter.this.f33087e.o((MediaSource) MediaSourceArrayAdapter.this.f33085c.get(((ListView) view2.getParent()).getPositionForView(view2)));
                    }
                });
            }
            return view;
        } catch (Throwable th) {
            throw new IllegalStateException("ArrayAdapter requires the resource ID to be a TextView", th);
        }
    }
}
