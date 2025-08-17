package com.google.common.util.concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public final class Uninterruptibles {
    private Uninterruptibles() {
    }

    public static <V> V a(Future<V> future) throws ExecutionException {
        V v2;
        boolean z2 = false;
        while (true) {
            try {
                v2 = future.get();
                break;
            } catch (InterruptedException unused) {
                z2 = true;
            } catch (Throwable th) {
                if (z2) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z2) {
            Thread.currentThread().interrupt();
        }
        return v2;
    }
}
