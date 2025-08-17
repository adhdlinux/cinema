package androidx.media3.common.util;

import androidx.media3.common.util.ListenerSet;
import java.util.concurrent.CopyOnWriteArraySet;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CopyOnWriteArraySet f4732b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f4733c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ ListenerSet.Event f4734d;

    public /* synthetic */ b(CopyOnWriteArraySet copyOnWriteArraySet, int i2, ListenerSet.Event event) {
        this.f4732b = copyOnWriteArraySet;
        this.f4733c = i2;
        this.f4734d = event;
    }

    public final void run() {
        ListenerSet.h(this.f4732b, this.f4733c, this.f4734d);
    }
}
