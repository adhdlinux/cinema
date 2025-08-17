package com.google.android.gms.internal.ads;

import java.util.Iterator;

final class zzfpr implements Iterable {
    final /* synthetic */ CharSequence zza;
    final /* synthetic */ zzfpu zzb;

    zzfpr(zzfpu zzfpu, CharSequence charSequence) {
        this.zzb = zzfpu;
        this.zza = charSequence;
    }

    public final Iterator iterator() {
        return this.zzb.zzg(this.zza);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        zzfow.zzb(sb, this, ", ");
        sb.append(']');
        return sb.toString();
    }
}
