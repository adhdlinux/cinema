package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzik;
import com.google.android.gms.internal.measurement.zzil;

public abstract class zzik<MessageType extends zzil<MessageType, BuilderType>, BuilderType extends zzik<MessageType, BuilderType>> implements zzli {
    public final /* synthetic */ zzli zzaA(byte[] bArr, zzjo zzjo) throws zzkm {
        return zzax(bArr, 0, bArr.length, zzjo);
    }

    /* renamed from: zzau */
    public abstract zzik clone();

    /* access modifiers changed from: protected */
    public abstract zzik zzav(zzil zzil);

    public zzik zzaw(byte[] bArr, int i2, int i3) throws zzkm {
        throw null;
    }

    public zzik zzax(byte[] bArr, int i2, int i3, zzjo zzjo) throws zzkm {
        throw null;
    }

    public final /* bridge */ /* synthetic */ zzli zzay(zzlj zzlj) {
        if (zzbR().getClass().isInstance(zzlj)) {
            return zzav((zzil) zzlj);
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }

    public final /* synthetic */ zzli zzaz(byte[] bArr) throws zzkm {
        return zzaw(bArr, 0, bArr.length);
    }
}
