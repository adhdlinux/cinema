package com.google.android.gms.internal.ads;

public enum zzgkj implements zzgpo {
    UNKNOWN_KEYMATERIAL(0),
    SYMMETRIC(1),
    ASYMMETRIC_PRIVATE(2),
    ASYMMETRIC_PUBLIC(3),
    REMOTE(4),
    UNRECOGNIZED(-1);
    
    private static final zzgpp zzg = null;
    private final int zzi;

    static {
        zzg = new zzgki();
    }

    private zzgkj(int i2) {
        this.zzi = i2;
    }

    public final String toString() {
        return Integer.toString(zza());
    }

    public final int zza() {
        if (this != UNRECOGNIZED) {
            return this.zzi;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
