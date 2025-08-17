package com.facebook.ads.internal.view.f.c;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import com.facebook.ads.internal.j.f;
import com.facebook.ads.internal.view.f.a;
import com.facebook.ads.internal.view.f.a.c;
import com.facebook.ads.internal.view.f.b.b;
import com.facebook.ads.internal.view.f.b.i;
import com.facebook.ads.internal.view.f.b.j;
import com.facebook.ads.internal.view.f.b.k;
import com.facebook.ads.internal.view.f.b.l;
import com.facebook.ads.internal.view.f.b.m;
import com.facebook.ads.internal.view.f.d.d;

public class h extends c implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    private final m f21407a;

    /* renamed from: b  reason: collision with root package name */
    private final i f21408b;

    /* renamed from: c  reason: collision with root package name */
    private final k f21409c;

    /* renamed from: d  reason: collision with root package name */
    private final com.facebook.ads.internal.view.f.b.c f21410d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final m f21411e;

    public h(Context context) {
        this(context, (AttributeSet) null);
    }

    public h(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public h(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f21407a = new m() {
            public void a(l lVar) {
                h.this.setVisibility(0);
            }
        };
        this.f21408b = new i() {
            public void a(com.facebook.ads.internal.view.f.b.h hVar) {
                h.this.f21411e.setChecked(true);
            }
        };
        this.f21409c = new k() {
            public void a(j jVar) {
                h.this.f21411e.setChecked(false);
            }
        };
        this.f21410d = new com.facebook.ads.internal.view.f.b.c() {
            public void a(b bVar) {
                h.this.f21411e.setChecked(true);
            }
        };
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        m mVar = new m(context);
        this.f21411e = mVar;
        mVar.setChecked(true);
        float f2 = displayMetrics.density;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (f2 * 25.0f), (int) (f2 * 25.0f));
        setVisibility(8);
        addView(mVar, layoutParams);
        setClickable(true);
        setFocusable(true);
    }

    /* access modifiers changed from: protected */
    public void a() {
        super.a();
        this.f21411e.setOnTouchListener(this);
        setOnTouchListener(this);
        if (getVideoView() != null) {
            getVideoView().getEventBus().a((T[]) new f[]{this.f21407a, this.f21410d, this.f21408b, this.f21409c});
        }
    }

    /* access modifiers changed from: protected */
    public void b() {
        if (getVideoView() != null) {
            getVideoView().getEventBus().b((T[]) new f[]{this.f21409c, this.f21408b, this.f21410d, this.f21407a});
        }
        setOnTouchListener((View.OnTouchListener) null);
        this.f21411e.setOnTouchListener((View.OnTouchListener) null);
        super.b();
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        a videoView;
        if (motionEvent.getAction() != 1 || (videoView = getVideoView()) == null) {
            return false;
        }
        if (videoView.getState() == d.PREPARED || videoView.getState() == d.PAUSED || videoView.getState() == d.PLAYBACK_COMPLETED) {
            videoView.a(com.facebook.ads.internal.view.f.a.a.USER_STARTED);
            return true;
        }
        if (videoView.getState() == d.STARTED) {
            videoView.a(true);
        }
        return false;
    }
}
