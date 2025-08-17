package com.applovin.adview;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.applovin.impl.adview.activity.b.a;
import com.applovin.impl.adview.o;
import com.applovin.impl.sdk.m;
import java.util.concurrent.atomic.AtomicBoolean;

public class AppLovinFullscreenAdViewObserver implements LifecycleObserver {

    /* renamed from: a  reason: collision with root package name */
    private final m f13708a;

    /* renamed from: b  reason: collision with root package name */
    private final AtomicBoolean f13709b = new AtomicBoolean(true);

    /* renamed from: c  reason: collision with root package name */
    private a f13710c;

    /* renamed from: d  reason: collision with root package name */
    private o f13711d;

    public AppLovinFullscreenAdViewObserver(Lifecycle lifecycle, o oVar, m mVar) {
        this.f13711d = oVar;
        this.f13708a = mVar;
        lifecycle.a(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        o oVar = this.f13711d;
        if (oVar != null) {
            oVar.e();
            this.f13711d = null;
        }
        a aVar = this.f13710c;
        if (aVar != null) {
            aVar.h();
            this.f13710c.k();
            this.f13710c = null;
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPause() {
        a aVar = this.f13710c;
        if (aVar != null) {
            aVar.g();
            this.f13710c.e();
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume() {
        a aVar;
        if (!this.f13709b.getAndSet(false) && (aVar = this.f13710c) != null) {
            aVar.f();
            this.f13710c.a(0);
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onStop() {
        a aVar = this.f13710c;
        if (aVar != null) {
            aVar.j();
        }
    }

    public void setPresenter(a aVar) {
        this.f13710c = aVar;
    }
}
