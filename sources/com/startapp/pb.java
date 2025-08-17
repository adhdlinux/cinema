package com.startapp;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.startapp.sdk.ads.banner.BannerOptions;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;

public class pb {

    /* renamed from: a  reason: collision with root package name */
    public final Handler f35616a;

    /* renamed from: b  reason: collision with root package name */
    public final WeakReference<View> f35617b;

    /* renamed from: c  reason: collision with root package name */
    public final BannerOptions f35618c;

    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f35619a;

        public a(b bVar) {
            this.f35619a = bVar;
        }

        public void run() {
            if (this.f35619a.onUpdate(pb.a(pb.this))) {
                pb.this.f35616a.postDelayed(this, 100);
            }
        }
    }

    public interface b {
        boolean onUpdate(boolean z2);
    }

    public pb(View view, BannerOptions bannerOptions, b bVar) {
        Handler handler = new Handler(Looper.getMainLooper());
        this.f35616a = handler;
        this.f35617b = new WeakReference<>(view);
        this.f35618c = bannerOptions;
        handler.postDelayed(new a(bVar), 100);
    }

    public void a() {
        this.f35616a.removeCallbacksAndMessages((Object) null);
    }

    public static boolean a(pb pbVar) {
        return p.a(pbVar.f35617b.get(), pbVar.f35618c, (AtomicReference<JSONObject>) new AtomicReference()) == null;
    }
}
