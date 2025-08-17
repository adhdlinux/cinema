package com.facebook.ads.internal.view.f;

import android.database.ContentObserver;
import android.os.Handler;

class e extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    private final c f21553a;

    e(Handler handler, c cVar) {
        super(handler);
        this.f21553a = cVar;
    }

    public boolean deliverSelfNotifications() {
        return false;
    }

    public void onChange(boolean z2) {
        this.f21553a.e();
    }
}
