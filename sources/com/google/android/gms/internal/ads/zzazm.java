package com.google.android.gms.internal.ads;

public enum zzazm implements zzgpo {
    UNSPECIFIED(0),
    CONNECTING(1),
    CONNECTED(2),
    DISCONNECTING(3),
    DISCONNECTED(4),
    SUSPENDED(5);
    
    private static final zzgpp zzg = null;
    private final int zzi;

    static {
        zzg = new zzazk();
    }

    private zzazm(int i2) {
        this.zzi = i2;
    }

    public static zzazm zzb(int i2) {
        if (i2 == 0) {
            return UNSPECIFIED;
        }
        if (i2 == 1) {
            return CONNECTING;
        }
        if (i2 == 2) {
            return CONNECTED;
        }
        if (i2 == 3) {
            return DISCONNECTING;
        }
        if (i2 == 4) {
            return DISCONNECTED;
        }
        if (i2 != 5) {
            return null;
        }
        return SUSPENDED;
    }

    public final String toString() {
        return Integer.toString(this.zzi);
    }

    public final int zza() {
        return this.zzi;
    }
}
