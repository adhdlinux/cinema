package com.google.android.gms.internal.ads;

import java.security.SecureRandom;

final class zzgnf extends ThreadLocal {
    zzgnf() {
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object initialValue() {
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextLong();
        return secureRandom;
    }
}
