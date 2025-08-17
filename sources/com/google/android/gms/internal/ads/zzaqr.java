package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

public final class zzaqr extends zzaqq {
    protected zzaqr(Context context, String str, boolean z2) {
        super(context, str, z2);
    }

    public static zzaqr zzt(String str, Context context, boolean z2) {
        zzaqq.zzr(context, false);
        return new zzaqr(context, str, false);
    }

    @Deprecated
    public static zzaqr zzu(String str, Context context, boolean z2, int i2) {
        zzaqq.zzr(context, z2);
        return new zzaqr(context, str, z2);
    }

    /* access modifiers changed from: protected */
    public final List zzp(zzart zzart, Context context, zzanq zzanq, zzanj zzanj) {
        if (zzart.zzk() == null || !this.zzu) {
            return super.zzp(zzart, context, zzanq, (zzanj) null);
        }
        int zza = zzart.zza();
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(super.zzp(zzart, context, zzanq, (zzanj) null));
        arrayList.add(new zzasl(zzart, "sjJJMjdJ4ejENjGN3VSKrjMe8gO2ipNVGbEWPt320LzidWuv9Vye4oanMfYCO4eP", "M+JigCCNgE9WH1drVXVCETLYEk7iaWPFwZXUH8JlEbE=", zzanq, zza, 24));
        return arrayList;
    }
}
