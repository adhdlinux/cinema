package com.google.android.gms.internal.ads;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.CountDownLatch;

final class zzapg implements Runnable {
    private zzapg() {
    }

    /* synthetic */ zzapg(zzapf zzapf) {
    }

    public final void run() {
        CountDownLatch countDownLatch;
        try {
            zzaph.zzd = MessageDigest.getInstance("MD5");
            countDownLatch = zzaph.zzb;
        } catch (NoSuchAlgorithmException unused) {
            countDownLatch = zzaph.zzb;
        } catch (Throwable th) {
            zzaph.zzb.countDown();
            throw th;
        }
        countDownLatch.countDown();
    }
}
