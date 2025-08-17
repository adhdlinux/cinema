package com.google.android.gms.internal.cast;

import com.google.android.gms.internal.cast.zzse;
import com.google.android.gms.internal.cast.zzsh;

public class zzse<MessageType extends zzsh<MessageType, BuilderType>, BuilderType extends zzse<MessageType, BuilderType>> extends zzqy<MessageType, BuilderType> {
    protected zzsh zza;
    private final zzsh zzb;

    protected zzse(MessageType messagetype) {
        this.zzb = messagetype;
        if (!messagetype.zzJ()) {
            this.zza = messagetype.zzw();
            return;
        }
        throw new IllegalArgumentException("Default instance must be immutable.");
    }

    private static void zza(Object obj, Object obj2) {
        zztx.zza().zzb(obj.getClass()).zze(obj, obj2);
    }

    /* renamed from: zzn */
    public final zzse zzm() {
        zzse zzse = (zzse) this.zzb.zzb(5, (Object) null, (Object) null);
        zzse.zza = zzr();
        return zzse;
    }

    public final zzse zzo(zzsh zzsh) {
        if (!this.zzb.equals(zzsh)) {
            if (!this.zza.zzJ()) {
                zzu();
            }
            zza(this.zza, zzsh);
        }
        return this;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002e, code lost:
        if (r3 != false) goto L_0x0030;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final MessageType zzp() {
        /*
            r5 = this;
            com.google.android.gms.internal.cast.zzsh r0 = r5.zzr()
            r1 = 1
            r2 = 0
            java.lang.Object r3 = r0.zzb(r1, r2, r2)
            java.lang.Byte r3 = (java.lang.Byte) r3
            byte r3 = r3.byteValue()
            if (r3 != r1) goto L_0x0013
            goto L_0x0030
        L_0x0013:
            if (r3 == 0) goto L_0x0031
            com.google.android.gms.internal.cast.zztx r3 = com.google.android.gms.internal.cast.zztx.zza()
            java.lang.Class r4 = r0.getClass()
            com.google.android.gms.internal.cast.zzua r3 = r3.zzb(r4)
            boolean r3 = r3.zzh(r0)
            if (r1 == r3) goto L_0x0029
            r1 = r2
            goto L_0x002a
        L_0x0029:
            r1 = r0
        L_0x002a:
            r4 = 2
            r0.zzb(r4, r1, r2)
            if (r3 == 0) goto L_0x0031
        L_0x0030:
            return r0
        L_0x0031:
            com.google.android.gms.internal.cast.zzuq r1 = new com.google.android.gms.internal.cast.zzuq
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.cast.zzse.zzp():com.google.android.gms.internal.cast.zzsh");
    }

    /* renamed from: zzq */
    public MessageType zzr() {
        if (!this.zza.zzJ()) {
            return this.zza;
        }
        this.zza.zzE();
        return this.zza;
    }

    public final /* bridge */ /* synthetic */ zztp zzs() {
        throw null;
    }

    /* access modifiers changed from: protected */
    public final void zzt() {
        if (!this.zza.zzJ()) {
            zzu();
        }
    }

    /* access modifiers changed from: protected */
    public void zzu() {
        zzsh zzw = this.zzb.zzw();
        zza(zzw, this.zza);
        this.zza = zzw;
    }
}
