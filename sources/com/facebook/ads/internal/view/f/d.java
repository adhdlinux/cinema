package com.facebook.ads.internal.view.f;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import com.facebook.ads.internal.q.a.x;
import com.facebook.ads.internal.view.f.c.g;
import com.facebook.ads.internal.view.f.d.c;
import java.lang.ref.WeakReference;

public class d extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private final c f21486a;

    /* renamed from: b  reason: collision with root package name */
    private g f21487b;

    /* renamed from: c  reason: collision with root package name */
    private WeakReference<a> f21488c;

    public interface a {
        void a();
    }

    public d(Context context, c cVar) {
        super(context);
        this.f21486a = cVar;
        x.b((View) cVar);
        addView(cVar.getView(), new RelativeLayout.LayoutParams(-1, -1));
    }

    public void a(com.facebook.ads.internal.view.f.a.c cVar) {
        addView(cVar, new RelativeLayout.LayoutParams(-1, -1));
        this.f21487b = (g) cVar;
    }

    public void b(com.facebook.ads.internal.view.f.a.c cVar) {
        x.b(cVar);
        this.f21487b = null;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        ((View) this.f21486a).layout(0, 0, getWidth(), getHeight());
        g gVar = this.f21487b;
        if (gVar != null) {
            gVar.layout(0, 0, getWidth(), getHeight());
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        boolean z2;
        WeakReference<a> weakReference;
        int i4;
        int videoWidth = this.f21486a.getVideoWidth();
        int videoHeight = this.f21486a.getVideoHeight();
        int defaultSize = View.getDefaultSize(videoWidth, i2);
        int defaultSize2 = View.getDefaultSize(videoHeight, i3);
        if (videoWidth <= 0 || videoHeight <= 0) {
            z2 = false;
        } else {
            int mode = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            int mode2 = View.MeasureSpec.getMode(i3);
            int size2 = View.MeasureSpec.getSize(i3);
            z2 = true;
            if (mode == 1073741824 && mode2 == 1073741824) {
                int i5 = videoWidth * size2;
                int i6 = size * videoHeight;
                if (i5 < i6) {
                    defaultSize = i5 / videoHeight;
                    defaultSize2 = size2;
                } else {
                    if (i5 > i6) {
                        defaultSize2 = i6 / videoWidth;
                    }
                    defaultSize = size;
                    defaultSize2 = size2;
                }
            } else if (mode == 1073741824) {
                int i7 = (videoHeight * size) / videoWidth;
                if (mode2 != Integer.MIN_VALUE || i7 <= size2) {
                    defaultSize = size;
                    defaultSize2 = i7;
                }
                defaultSize = size;
                defaultSize2 = size2;
            } else if (mode2 == 1073741824) {
                int i8 = (videoWidth * size2) / videoHeight;
                if (mode != Integer.MIN_VALUE || i8 <= size) {
                    defaultSize2 = size2;
                    defaultSize = i8;
                }
                defaultSize = size;
                defaultSize2 = size2;
            } else {
                if (mode2 != Integer.MIN_VALUE || videoHeight <= size2) {
                    i4 = videoWidth;
                    size2 = videoHeight;
                } else {
                    i4 = (size2 * videoWidth) / videoHeight;
                }
                if (mode != Integer.MIN_VALUE || i4 <= size) {
                    defaultSize = i4;
                    defaultSize2 = size2;
                } else {
                    defaultSize2 = (videoHeight * size) / videoWidth;
                }
            }
            defaultSize = size;
        }
        setMeasuredDimension(defaultSize, defaultSize2);
        if (z2 && (weakReference = this.f21488c) != null && weakReference.get() != null) {
            this.f21488c.get().a();
        }
    }

    public void setViewImplInflationListener(a aVar) {
        this.f21488c = new WeakReference<>(aVar);
    }
}
