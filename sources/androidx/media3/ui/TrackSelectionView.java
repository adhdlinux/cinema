package androidx.media3.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.LinearLayout;
import androidx.media3.common.Format;
import androidx.media3.common.TrackGroup;
import androidx.media3.common.TrackSelectionOverride;
import androidx.media3.common.Tracks;
import androidx.media3.common.util.Assertions;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TrackSelectionView extends LinearLayout {

    /* renamed from: b  reason: collision with root package name */
    private final int f10154b;

    /* renamed from: c  reason: collision with root package name */
    private final LayoutInflater f10155c;

    /* renamed from: d  reason: collision with root package name */
    private final CheckedTextView f10156d;

    /* renamed from: e  reason: collision with root package name */
    private final CheckedTextView f10157e;

    /* renamed from: f  reason: collision with root package name */
    private final ComponentListener f10158f;

    /* renamed from: g  reason: collision with root package name */
    private final List<Tracks.Group> f10159g;

    /* renamed from: h  reason: collision with root package name */
    private final Map<TrackGroup, TrackSelectionOverride> f10160h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f10161i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f10162j;

    /* renamed from: k  reason: collision with root package name */
    private TrackNameProvider f10163k;

    /* renamed from: l  reason: collision with root package name */
    private CheckedTextView[][] f10164l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f10165m;

    /* renamed from: n  reason: collision with root package name */
    private Comparator<TrackInfo> f10166n;

    private class ComponentListener implements View.OnClickListener {
        private ComponentListener() {
        }

        public void onClick(View view) {
            TrackSelectionView.this.c(view);
        }
    }

    private static final class TrackInfo {

        /* renamed from: a  reason: collision with root package name */
        public final Tracks.Group f10168a;

        /* renamed from: b  reason: collision with root package name */
        public final int f10169b;

        public TrackInfo(Tracks.Group group, int i2) {
            this.f10168a = group;
            this.f10169b = i2;
        }

        public Format a() {
            return this.f10168a.b(this.f10169b);
        }
    }

    public TrackSelectionView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public static Map<TrackGroup, TrackSelectionOverride> b(Map<TrackGroup, TrackSelectionOverride> map, List<Tracks.Group> list, boolean z2) {
        HashMap hashMap = new HashMap();
        for (int i2 = 0; i2 < list.size(); i2++) {
            TrackSelectionOverride trackSelectionOverride = map.get(list.get(i2).a());
            if (trackSelectionOverride != null && (z2 || hashMap.isEmpty())) {
                hashMap.put(trackSelectionOverride.f4397a, trackSelectionOverride);
            }
        }
        return hashMap;
    }

    /* access modifiers changed from: private */
    public void c(View view) {
        if (view == this.f10156d) {
            e();
        } else if (view == this.f10157e) {
            d();
        } else {
            f(view);
        }
        i();
    }

    private void d() {
        this.f10165m = false;
        this.f10160h.clear();
    }

    private void e() {
        this.f10165m = true;
        this.f10160h.clear();
    }

    private void f(View view) {
        boolean z2 = false;
        this.f10165m = false;
        TrackInfo trackInfo = (TrackInfo) Assertions.f(view.getTag());
        TrackGroup a2 = trackInfo.f10168a.a();
        int i2 = trackInfo.f10169b;
        TrackSelectionOverride trackSelectionOverride = this.f10160h.get(a2);
        if (trackSelectionOverride == null) {
            if (!this.f10162j && this.f10160h.size() > 0) {
                this.f10160h.clear();
            }
            this.f10160h.put(a2, new TrackSelectionOverride(a2, (List<Integer>) ImmutableList.s(Integer.valueOf(i2))));
            return;
        }
        ArrayList arrayList = new ArrayList(trackSelectionOverride.f4398b);
        boolean isChecked = ((CheckedTextView) view).isChecked();
        boolean g2 = g(trackInfo.f10168a);
        if (g2 || h()) {
            z2 = true;
        }
        if (isChecked && z2) {
            arrayList.remove(Integer.valueOf(i2));
            if (arrayList.isEmpty()) {
                this.f10160h.remove(a2);
            } else {
                this.f10160h.put(a2, new TrackSelectionOverride(a2, (List<Integer>) arrayList));
            }
        } else if (isChecked) {
        } else {
            if (g2) {
                arrayList.add(Integer.valueOf(i2));
                this.f10160h.put(a2, new TrackSelectionOverride(a2, (List<Integer>) arrayList));
                return;
            }
            this.f10160h.put(a2, new TrackSelectionOverride(a2, (List<Integer>) ImmutableList.s(Integer.valueOf(i2))));
        }
    }

    private boolean g(Tracks.Group group) {
        return this.f10161i && group.d();
    }

    private boolean h() {
        return this.f10162j && this.f10159g.size() > 1;
    }

    private void i() {
        boolean z2;
        this.f10156d.setChecked(this.f10165m);
        CheckedTextView checkedTextView = this.f10157e;
        if (this.f10165m || this.f10160h.size() != 0) {
            z2 = false;
        } else {
            z2 = true;
        }
        checkedTextView.setChecked(z2);
        for (int i2 = 0; i2 < this.f10164l.length; i2++) {
            TrackSelectionOverride trackSelectionOverride = this.f10160h.get(this.f10159g.get(i2).a());
            int i3 = 0;
            while (true) {
                CheckedTextView[] checkedTextViewArr = this.f10164l[i2];
                if (i3 >= checkedTextViewArr.length) {
                    break;
                }
                if (trackSelectionOverride != null) {
                    this.f10164l[i2][i3].setChecked(trackSelectionOverride.f4398b.contains(Integer.valueOf(((TrackInfo) Assertions.f(checkedTextViewArr[i3].getTag())).f10169b)));
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
        if (this.f10159g.isEmpty()) {
            this.f10156d.setEnabled(false);
            this.f10157e.setEnabled(false);
            return;
        }
        this.f10156d.setEnabled(true);
        this.f10157e.setEnabled(true);
        this.f10164l = new CheckedTextView[this.f10159g.size()][];
        boolean h2 = h();
        for (int i3 = 0; i3 < this.f10159g.size(); i3++) {
            Tracks.Group group = this.f10159g.get(i3);
            boolean g2 = g(group);
            CheckedTextView[][] checkedTextViewArr = this.f10164l;
            int i4 = group.f4477a;
            checkedTextViewArr[i3] = new CheckedTextView[i4];
            TrackInfo[] trackInfoArr = new TrackInfo[i4];
            for (int i5 = 0; i5 < group.f4477a; i5++) {
                trackInfoArr[i5] = new TrackInfo(group, i5);
            }
            Comparator<TrackInfo> comparator = this.f10166n;
            if (comparator != null) {
                Arrays.sort(trackInfoArr, comparator);
            }
            for (int i6 = 0; i6 < i4; i6++) {
                if (i6 == 0) {
                    addView(this.f10155c.inflate(R$layout.f10020b, this, false));
                }
                if (g2 || h2) {
                    i2 = 17367056;
                } else {
                    i2 = 17367055;
                }
                CheckedTextView checkedTextView = (CheckedTextView) this.f10155c.inflate(i2, this, false);
                checkedTextView.setBackgroundResource(this.f10154b);
                checkedTextView.setText(this.f10163k.a(trackInfoArr[i6].a()));
                checkedTextView.setTag(trackInfoArr[i6]);
                if (group.i(i6)) {
                    checkedTextView.setFocusable(true);
                    checkedTextView.setOnClickListener(this.f10158f);
                } else {
                    checkedTextView.setFocusable(false);
                    checkedTextView.setEnabled(false);
                }
                this.f10164l[i3][i6] = checkedTextView;
                addView(checkedTextView);
            }
        }
        i();
    }

    public boolean getIsDisabled() {
        return this.f10165m;
    }

    public Map<TrackGroup, TrackSelectionOverride> getOverrides() {
        return this.f10160h;
    }

    public void setAllowAdaptiveSelections(boolean z2) {
        if (this.f10161i != z2) {
            this.f10161i = z2;
            j();
        }
    }

    public void setAllowMultipleOverrides(boolean z2) {
        if (this.f10162j != z2) {
            this.f10162j = z2;
            if (!z2 && this.f10160h.size() > 1) {
                Map<TrackGroup, TrackSelectionOverride> b2 = b(this.f10160h, this.f10159g, false);
                this.f10160h.clear();
                this.f10160h.putAll(b2);
            }
            j();
        }
    }

    public void setShowDisableOption(boolean z2) {
        this.f10156d.setVisibility(z2 ? 0 : 8);
    }

    public void setTrackNameProvider(TrackNameProvider trackNameProvider) {
        this.f10163k = (TrackNameProvider) Assertions.f(trackNameProvider);
        j();
    }

    public TrackSelectionView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        setOrientation(1);
        setSaveFromParentEnabled(false);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{16843534});
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        this.f10154b = resourceId;
        obtainStyledAttributes.recycle();
        LayoutInflater from = LayoutInflater.from(context);
        this.f10155c = from;
        ComponentListener componentListener = new ComponentListener();
        this.f10158f = componentListener;
        this.f10163k = new DefaultTrackNameProvider(getResources());
        this.f10159g = new ArrayList();
        this.f10160h = new HashMap();
        CheckedTextView checkedTextView = (CheckedTextView) from.inflate(17367055, this, false);
        this.f10156d = checkedTextView;
        checkedTextView.setBackgroundResource(resourceId);
        checkedTextView.setText(R$string.f10051x);
        checkedTextView.setEnabled(false);
        checkedTextView.setFocusable(true);
        checkedTextView.setOnClickListener(componentListener);
        checkedTextView.setVisibility(8);
        addView(checkedTextView);
        addView(from.inflate(R$layout.f10020b, this, false));
        CheckedTextView checkedTextView2 = (CheckedTextView) from.inflate(17367055, this, false);
        this.f10157e = checkedTextView2;
        checkedTextView2.setBackgroundResource(resourceId);
        checkedTextView2.setText(R$string.f10050w);
        checkedTextView2.setEnabled(false);
        checkedTextView2.setFocusable(true);
        checkedTextView2.setOnClickListener(componentListener);
        addView(checkedTextView2);
    }
}
