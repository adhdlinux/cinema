package androidx.media3.common.util;

import androidx.media3.common.util.NetworkTypeObserver;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ NetworkTypeObserver f4735b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ NetworkTypeObserver.Listener f4736c;

    public /* synthetic */ c(NetworkTypeObserver networkTypeObserver, NetworkTypeObserver.Listener listener) {
        this.f4735b = networkTypeObserver;
        this.f4736c = listener;
    }

    public final void run() {
        this.f4735b.h(this.f4736c);
    }
}
