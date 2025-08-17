package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

final class zzgpd {
    private static final zzgpd zzb = new zzgpd(true);
    final zzgsc zza = new zzgrs(16);
    private boolean zzc;
    private boolean zzd;

    private zzgpd() {
    }

    public static zzgpd zza() {
        throw null;
    }

    private static final void zzd(zzgpc zzgpc, Object obj) {
        boolean z2;
        zzgsw zzb2 = zzgpc.zzb();
        byte[] bArr = zzgpw.zzd;
        obj.getClass();
        zzgsw zzgsw = zzgsw.DOUBLE;
        zzgsx zzgsx = zzgsx.INT;
        switch (zzb2.zza().ordinal()) {
            case 0:
                z2 = obj instanceof Integer;
                break;
            case 1:
                z2 = obj instanceof Long;
                break;
            case 2:
                z2 = obj instanceof Float;
                break;
            case 3:
                z2 = obj instanceof Double;
                break;
            case 4:
                z2 = obj instanceof Boolean;
                break;
            case 5:
                z2 = obj instanceof String;
                break;
            case 6:
                if ((obj instanceof zzgoe) || (obj instanceof byte[])) {
                    return;
                }
            case 7:
                if ((obj instanceof Integer) || (obj instanceof zzgpo)) {
                    return;
                }
            case 8:
                if ((obj instanceof zzgqw) || (obj instanceof zzgqb)) {
                    return;
                }
        }
        if (z2) {
            return;
        }
        throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", new Object[]{Integer.valueOf(zzgpc.zza()), zzgpc.zzb().zza(), obj.getClass().getName()}));
    }

    public final /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzgpd zzgpd = new zzgpd();
        for (int i2 = 0; i2 < this.zza.zzb(); i2++) {
            Map.Entry zzg = this.zza.zzg(i2);
            zzgpd.zzc((zzgpc) zzg.getKey(), zzg.getValue());
        }
        for (Map.Entry entry : this.zza.zzc()) {
            zzgpd.zzc((zzgpc) entry.getKey(), entry.getValue());
        }
        zzgpd.zzd = this.zzd;
        return zzgpd;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzgpd)) {
            return false;
        }
        return this.zza.equals(((zzgpd) obj).zza);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final void zzb() {
        if (!this.zzc) {
            for (int i2 = 0; i2 < this.zza.zzb(); i2++) {
                Map.Entry zzg = this.zza.zzg(i2);
                if (zzg.getValue() instanceof zzgpm) {
                    ((zzgpm) zzg.getValue()).zzaS();
                }
            }
            this.zza.zza();
            this.zzc = true;
        }
    }

    public final void zzc(zzgpc zzgpc, Object obj) {
        if (!zzgpc.zzc()) {
            zzd(zzgpc, obj);
        } else if (obj instanceof List) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                zzd(zzgpc, arrayList.get(i2));
            }
            obj = arrayList;
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        if (obj instanceof zzgqb) {
            this.zzd = true;
        }
        this.zza.put(zzgpc, obj);
    }

    private zzgpd(boolean z2) {
        zzb();
        zzb();
    }
}
