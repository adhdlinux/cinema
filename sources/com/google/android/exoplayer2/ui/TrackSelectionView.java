package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.LinearLayout;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.Tracks;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.trackselection.TrackSelectionOverride;
import com.google.android.exoplayer2.util.Assertions;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TrackSelectionView extends LinearLayout {

    /* renamed from: b  reason: collision with root package name */
    private final int f28261b;

    /* renamed from: c  reason: collision with root package name */
    private final LayoutInflater f28262c;

    /* renamed from: d  reason: collision with root package name */
    private final CheckedTextView f28263d;

    /* renamed from: e  reason: collision with root package name */
    private final CheckedTextView f28264e;

    /* renamed from: f  reason: collision with root package name */
    private final ComponentListener f28265f;

    /* renamed from: g  reason: collision with root package name */
    private final List<Tracks.Group> f28266g = new ArrayList();

    /* renamed from: h  reason: collision with root package name */
    private final Map<TrackGroup, TrackSelectionOverride> f28267h = new HashMap();

    /* renamed from: i  reason: collision with root package name */
    private boolean f28268i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f28269j;

    /* renamed from: k  reason: collision with root package name */
    private TrackNameProvider f28270k = new DefaultTrackNameProvider(getResources());

    /* renamed from: l  reason: collision with root package name */
    private CheckedTextView[][] f28271l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f28272m;

    /* renamed from: n  reason: collision with root package name */
    private Comparator<TrackInfo> f28273n;

    private class ComponentListener implements View.OnClickListener {
        private ComponentListener() {
        }

        public void onClick(View view) {
            TrackSelectionView.this.c(view);
        }
    }

    private static final class TrackInfo {

        /* renamed from: a  reason: collision with root package name */
        public final Tracks.Group f28275a;

        /* renamed from: b  reason: collision with root package name */
        public final int f28276b;

        public TrackInfo(Tracks.Group group, int i2) {
            this.f28275a = group;
            this.f28276b = i2;
        }

        public Format a() {
            return this.f28275a.c(this.f28276b);
        }
    }

    public TrackSelectionView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        setOrientation(1);
        setSaveFromParentEnabled(false);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{16843534});
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        this.f28261b = resourceId;
        obtainStyledAttributes.recycle();
        LayoutInflater from = LayoutInflater.from(context);
        this.f28262c = from;
        ComponentListener componentListener = new ComponentListener();
        this.f28265f = componentListener;
        CheckedTextView checkedTextView = (CheckedTextView) from.inflate(17367055, this, false);
        this.f28263d = checkedTextView;
        checkedTextView.setBackgroundResource(resourceId);
        checkedTextView.setText(R$string.f28024x);
        checkedTextView.setEnabled(false);
        checkedTextView.setFocusable(true);
        checkedTextView.setOnClickListener(componentListener);
        checkedTextView.setVisibility(8);
        addView(checkedTextView);
        addView(from.inflate(R$layout.f27991a, this, false));
        CheckedTextView checkedTextView2 = (CheckedTextView) from.inflate(17367055, this, false);
        this.f28264e = checkedTextView2;
        checkedTextView2.setBackgroundResource(resourceId);
        checkedTextView2.setText(R$string.f28023w);
        checkedTextView2.setEnabled(false);
        checkedTextView2.setFocusable(true);
        checkedTextView2.setOnClickListener(componentListener);
        addView(checkedTextView2);
    }

    public static Map<TrackGroup, TrackSelectionOverride> b(Map<TrackGroup, TrackSelectionOverride> map, List<Tracks.Group> list, boolean z2) {
        HashMap hashMap = new HashMap();
        for (int i2 = 0; i2 < list.size(); i2++) {
            TrackSelectionOverride trackSelectionOverride = map.get(list.get(i2).b());
            if (trackSelectionOverride != null && (z2 || hashMap.isEmpty())) {
                hashMap.put(trackSelectionOverride.f27761b, trackSelectionOverride);
            }
        }
        return hashMap;
    }

    /* access modifiers changed from: private */
    public void c(View view) {
        if (view == this.f28263d) {
            e();
        } else if (view == this.f28264e) {
            d();
        } else {
            f(view);
        }
        i();
    }

    private void d() {
        this.f28272m = false;
        this.f28267h.clear();
    }

    private void e() {
        this.f28272m = true;
        this.f28267h.clear();
    }

    private void f(View view) {
        boolean z2 = false;
        this.f28272m = false;
        TrackInfo trackInfo = (TrackInfo) Assertions.e(view.getTag());
        TrackGroup b2 = trackInfo.f28275a.b();
        int i2 = trackInfo.f28276b;
        TrackSelectionOverride trackSelectionOverride = this.f28267h.get(b2);
        if (trackSelectionOverride == null) {
            if (!this.f28269j && this.f28267h.size() > 0) {
                this.f28267h.clear();
            }
            this.f28267h.put(b2, new TrackSelectionOverride(b2, ImmutableList.s(Integer.valueOf(i2))));
            return;
        }
        ArrayList arrayList = new ArrayList(trackSelectionOverride.f27762c);
        boolean isChecked = ((CheckedTextView) view).isChecked();
        boolean g2 = g(trackInfo.f28275a);
        if (g2 || h()) {
            z2 = true;
        }
        if (isChecked && z2) {
            arrayList.remove(Integer.valueOf(i2));
            if (arrayList.isEmpty()) {
                this.f28267h.remove(b2);
            } else {
                this.f28267h.put(b2, new TrackSelectionOverride(b2, arrayList));
            }
        } else if (isChecked) {
        } else {
            if (g2) {
                arrayList.add(Integer.valueOf(i2));
                this.f28267h.put(b2, new TrackSelectionOverride(b2, arrayList));
                return;
            }
            this.f28267h.put(b2, new TrackSelectionOverride(b2, ImmutableList.s(Integer.valueOf(i2))));
        }
    }

    private boolean g(Tracks.Group group) {
        return this.f28268i && group.e();
    }

    private boolean h() {
        return this.f28269j && this.f28266g.size() > 1;
    }

    private void i() {
        boolean z2;
        this.f28263d.setChecked(this.f28272m);
        CheckedTextView checkedTextView = this.f28264e;
        if (this.f28272m || this.f28267h.size() != 0) {
            z2 = false;
        } else {
            z2 = true;
        }
        checkedTextView.setChecked(z2);
        for (int i2 = 0; i2 < this.f28271l.length; i2++) {
            TrackSelectionOverride trackSelectionOverride = this.f28267h.get(this.f28266g.get(i2).b());
            int i3 = 0;
            while (true) {
                CheckedTextView[] checkedTextViewArr = this.f28271l[i2];
                if (i3 >= checkedTextViewArr.length) {
                    break;
                }
                if (trackSelectionOverride != null) {
                    this.f28271l[i2][i3].setChecked(trackSelectionOverride.f27762c.contains(Integer.valueOf(((TrackInfo) Assertions.e(checkedTextViewArr[i3].getTag())).f28276b)));
                } else {
                    checkedTextViewArr[i3].setChecked(false);
                }
                i3++;
            }
        }
    }

    private void j() {
        int i2;
        for (int childCount = getChildCount() - 1; childCount >= 3; childCount--) {
            removeViewAt(childCount);
        }
        if (this.f28266g.isEmpty()) {
            this.f28263d.setEnabled(false);
            this.f28264e.setEnabled(false);
            return;
        }
        this.f28263d.setEnabled(true);
        this.f28264e.setEnabled(true);
        this.f28271l = new CheckedTextView[this.f28266g.size()][];
        boolean h2 = h();
        for (int i3 = 0; i3 < this.f28266g.size(); i3++) {
            Tracks.Group group = this.f28266g.get(i3);
            boolean g2 = g(group);
            CheckedTextView[][] checkedTextViewArr = this.f28271l;
            int i4 = group.f23537b;
            checkedTextViewArr[i3] = new CheckedTextView[i4];
            TrackInfo[] trackInfoArr = new TrackInfo[i4];
            for (int i5 = 0; i5 < group.f23537b; i5++) {
                trackInfoArr[i5] = new TrackInfo(group, i5);
            }
            Comparator<TrackInfo> comparator = this.f28273n;
            if (comparator != null) {
                Arrays.sort(trackInfoArr, comparator);
            }
            for (int i6 = 0; i6 < i4; i6++) {
                if (i6 == 0) {
                    addView(this.f28262c.inflate(R$layout.f27991a, this, false));
                }
                if (g2 || h2) {
                    i2 = 17367056;
                } else {
                    i2 = 17367055;
                }
                CheckedTextView checkedTextView = (CheckedTextView) this.f28262c.inflate(i2, this, false);
                checkedTextView.setBackgroundResource(this.f28261b);
                checkedTextView.setText(this.f28270k.a(trackInfoArr[i6].a()));
                checkedTextView.setTag(trackInfoArr[i6]);
                if (group.h(i6)) {
                    checkedTextView.setFocusable(true);
                    checkedTextView.setOnClickListener(this.f28265f);
                } else {
                    checkedTextView.setFocusable(false);
                    checkedTextView.setEnabled(false);
                }
                this.f28271l[i3][i6] = checkedTextView;
                addView(checkedTextView);
            }
        }
        i();
    }

    public boolean getIsDisabled() {
        return this.f28272m;
    }

    public Map<TrackGroup, TrackSelectionOverride> getOverrides() {
        return this.f28267h;
    }

    public void setAllowAdaptiveSelections(boolean z2) {
        if (this.f28268i != z2) {
            this.f28268i = z2;
            j();
        }
    }

    public void setAllowMultipleOverrides(boolean z2) {
        if (this.f28269j != z2) {
            this.f28269j = z2;
            if (!z2 && this.f28267h.size() > 1) {
                Map<TrackGroup, TrackSelectionOverride> b2 = b(this.f28267h, this.f28266g, false);
                this.f28267h.clear();
                this.f28267h.putAll(b2);
            }
            j();
        }
    }

    public void setShowDisableOption(boolean z2) {
        this.f28263d.setVisibility(z2 ? 0 : 8);
    }

    public void setTrackNameProvider(TrackNameProvider trackNameProvider) {
        this.f28270k = (TrackNameProvider) Assertions.e(trackNameProvider);
        j();
    }
}
