package com.google.ar.core;

import java.util.Map;

final class p {

    /* renamed from: a  reason: collision with root package name */
    final Map f30347a = new o();

    p() {
    }

    static /* synthetic */ String b(byte b2, int i2, String str) {
        StringBuilder sb = new StringBuilder(String.valueOf(i2).length() + b2);
        sb.append(str);
        sb.append(i2);
        return sb.toString();
    }

    public final synchronized AugmentedFace a(long j2, Session session) {
        Map map = this.f30347a;
        Long valueOf = Long.valueOf(j2);
        AugmentedFace augmentedFace = (AugmentedFace) map.get(valueOf);
        if (augmentedFace != null) {
            return augmentedFace;
        }
        AugmentedFace augmentedFace2 = new AugmentedFace(j2, session);
        this.f30347a.put(valueOf, augmentedFace2);
        return augmentedFace2;
    }
}
