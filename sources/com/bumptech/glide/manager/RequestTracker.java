package com.bumptech.glide.manager;

import android.util.Log;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.util.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

public class RequestTracker {

    /* renamed from: a  reason: collision with root package name */
    private final Set<Request> f16994a = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: b  reason: collision with root package name */
    private final List<Request> f16995b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private boolean f16996c;

    public boolean a(Request request) {
        boolean z2 = true;
        if (request == null) {
            return true;
        }
        boolean remove = this.f16994a.remove(request);
        if (!this.f16995b.remove(request) && !remove) {
            z2 = false;
        }
        if (z2) {
            request.clear();
        }
        return z2;
    }

    public void b() {
        for (T a2 : Util.i(this.f16994a)) {
            a(a2);
        }
        this.f16995b.clear();
    }

    public void c() {
        this.f16996c = true;
        for (T t2 : Util.i(this.f16994a)) {
            if (t2.isRunning() || t2.isComplete()) {
                t2.clear();
                this.f16995b.add(t2);
            }
        }
    }

    public void d() {
        this.f16996c = true;
        for (T t2 : Util.i(this.f16994a)) {
            if (t2.isRunning()) {
                t2.pause();
                this.f16995b.add(t2);
            }
        }
    }

    public void e() {
        for (T t2 : Util.i(this.f16994a)) {
            if (!t2.isComplete() && !t2.isCleared()) {
                t2.clear();
                if (!this.f16996c) {
                    t2.begin();
                } else {
                    this.f16995b.add(t2);
                }
            }
        }
    }

    public void f() {
        this.f16996c = false;
        for (T t2 : Util.i(this.f16994a)) {
            if (!t2.isComplete() && !t2.isRunning()) {
                t2.begin();
            }
        }
        this.f16995b.clear();
    }

    public void g(Request request) {
        this.f16994a.add(request);
        if (!this.f16996c) {
            request.begin();
            return;
        }
        request.clear();
        if (Log.isLoggable("RequestTracker", 2)) {
            Log.v("RequestTracker", "Paused, delaying request");
        }
        this.f16995b.add(request);
    }

    public String toString() {
        return super.toString() + "{numRequests=" + this.f16994a.size() + ", isPaused=" + this.f16996c + "}";
    }
}
