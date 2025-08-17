package com.facebook.ads.internal.view.f.c;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.facebook.ads.internal.j.f;
import com.facebook.ads.internal.q.a.x;
import com.facebook.ads.internal.view.b.d;
import com.facebook.ads.internal.view.b.e;
import com.facebook.ads.internal.view.f.a.c;
import com.facebook.ads.internal.view.f.b.b;
import com.facebook.ads.internal.view.f.b.j;

public class g extends c {

    /* renamed from: a  reason: collision with root package name */
    private final ImageView f21402a;

    /* renamed from: b  reason: collision with root package name */
    private final f<j> f21403b = new f<j>() {
        public Class<j> a() {
            return j.class;
        }

        public void a(j jVar) {
            g.this.setVisibility(8);
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private final f<b> f21404c = new f<b>() {
        public Class<b> a() {
            return b.class;
        }

        public void a(b bVar) {
            g.this.setVisibility(0);
        }
    };

    public g(Context context) {
        super(context);
        ImageView imageView = new ImageView(context);
        this.f21402a = imageView;
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        x.a((View) imageView, -16777216);
        imageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        addView(imageView);
    }

    /* access modifiers changed from: protected */
    public void a() {
        super.a();
        if (getVideoView() != null) {
            getVideoView().getEventBus().a((T[]) new f[]{this.f21403b, this.f21404c});
        }
    }

    public void a(String str, e eVar) {
        if (str == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        d a2 = new d(this.f21402a).a();
        if (eVar != null) {
            a2.a(eVar);
        }
        a2.a(str);
    }

    /* access modifiers changed from: protected */
    public void b() {
        if (getVideoView() != null) {
            getVideoView().getEventBus().b((T[]) new f[]{this.f21404c, this.f21403b});
        }
        super.b();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        this.f21402a.layout(0, 0, i4 - i2, i5 - i3);
    }

    public void setImage(String str) {
        a(str, (e) null);
    }
}
