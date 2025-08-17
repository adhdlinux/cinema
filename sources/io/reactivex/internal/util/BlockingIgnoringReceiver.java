package io.reactivex.internal.util;

import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import java.util.concurrent.CountDownLatch;

public final class BlockingIgnoringReceiver extends CountDownLatch implements Consumer<Throwable>, Action {

    /* renamed from: b  reason: collision with root package name */
    public Throwable f40059b;

    public BlockingIgnoringReceiver() {
        super(1);
    }

    /* renamed from: a */
    public void accept(Throwable th) {
        this.f40059b = th;
        countDown();
    }

    public void run() {
        countDown();
    }
}
