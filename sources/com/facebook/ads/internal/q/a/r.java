package com.facebook.ads.internal.q.a;

import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class r implements View.OnSystemUiVisibilityChangeListener {

    /* renamed from: a  reason: collision with root package name */
    private final View f20656a;

    /* renamed from: b  reason: collision with root package name */
    private int f20657b;

    /* renamed from: c  reason: collision with root package name */
    private Window f20658c;

    /* renamed from: d  reason: collision with root package name */
    private a f20659d = a.DEFAULT;

    /* renamed from: e  reason: collision with root package name */
    private final Runnable f20660e = new Runnable() {
        public void run() {
            r.this.a(false);
        }
    };

    /* renamed from: com.facebook.ads.internal.q.a.r$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f20662a;

        static {
            int[] iArr = new int[a.values().length];
            f20662a = iArr;
            try {
                iArr[a.FULL_SCREEN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public enum a {
        DEFAULT,
        FULL_SCREEN
    }

    public r(View view) {
        this.f20656a = view;
        view.setOnSystemUiVisibilityChangeListener(this);
    }

    private void a(int i2, boolean z2) {
        int i3;
        Window window = this.f20658c;
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            if (z2) {
                i3 = i2 | attributes.flags;
            } else {
                i3 = (~i2) & attributes.flags;
            }
            attributes.flags = i3;
            this.f20658c.setAttributes(attributes);
        }
    }

    /* access modifiers changed from: private */
    public void a(boolean z2) {
        if (!a.DEFAULT.equals(this.f20659d)) {
            int i2 = !z2 ? 3847 : 3840;
            Handler handler = this.f20656a.getHandler();
            if (handler != null && z2) {
                handler.removeCallbacks(this.f20660e);
                handler.postDelayed(this.f20660e, 2000);
            }
            this.f20656a.setSystemUiVisibility(i2);
        }
    }

    public void a() {
        this.f20658c = null;
    }

    public void a(Window window) {
        this.f20658c = window;
    }

    public void a(a aVar) {
        this.f20659d = aVar;
        if (AnonymousClass2.f20662a[aVar.ordinal()] != 1) {
            a(67108864, false);
            a(134217728, false);
            this.f20656a.setSystemUiVisibility(0);
            return;
        }
        a(67108864, true);
        a(134217728, true);
        a(false);
    }

    public void onSystemUiVisibilityChange(int i2) {
        this.f20657b = i2;
        if (((this.f20657b ^ i2) & 2) != 0 && (i2 & 2) == 0) {
            a(true);
        }
    }
}
