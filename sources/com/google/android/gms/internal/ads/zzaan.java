package com.google.android.gms.internal.ads;

import java.lang.reflect.Constructor;

public final /* synthetic */ class zzaan implements zzaap {
    public static final /* synthetic */ zzaan zza = new zzaan();

    private /* synthetic */ zzaan() {
    }

    public final Constructor zza() {
        if (!Boolean.TRUE.equals(Class.forName("androidx.media3.decoder.flac.FlacLibrary").getMethod("isAvailable", new Class[0]).invoke((Object) null, new Object[0]))) {
            return null;
        }
        return Class.forName("androidx.media3.decoder.flac.FlacExtractor").asSubclass(zzaaw.class).getConstructor(new Class[]{Integer.TYPE});
    }
}
