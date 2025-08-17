package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgpi;
import com.google.android.gms.internal.ads.zzgpm;
import java.io.IOException;

public class zzgpi<MessageType extends zzgpm<MessageType, BuilderType>, BuilderType extends zzgpi<MessageType, BuilderType>> extends zzgnm<MessageType, BuilderType> {
    protected zzgpm zza;
    private final zzgpm zzb;

    protected zzgpi(MessageType messagetype) {
        this.zzb = messagetype;
        if (!messagetype.zzaY()) {
            this.zza = messagetype.zzaD();
            return;
        }
        throw new IllegalArgumentException("Default instance must be immutable.");
    }

    private static void zza(Object obj, Object obj2) {
        zzgre.zza().zzb(obj.getClass()).zzg(obj, obj2);
    }

    /* renamed from: zzai */
    public final zzgpi zzah() {
        zzgpi zzgpi = (zzgpi) this.zzb.zzb(5, (Object) null, (Object) null);
        zzgpi.zza = zzan();
        return zzgpi;
    }

    public final zzgpi zzaj(zzgpm zzgpm) {
        if (!this.zzb.equals(zzgpm)) {
            if (!this.zza.zzaY()) {
                zzaq();
            }
            zza(this.zza, zzgpm);
        }
        return this;
    }

    public final zzgpi zzak(byte[] bArr, int i2, int i3, zzgoy zzgoy) throws zzgpy {
        if (!this.zza.zzaY()) {
            zzaq();
        }
        try {
            zzgre.zza().zzb(this.zza.getClass()).zzi(this.zza, bArr, 0, i3, new zzgnq(zzgoy));
            return this;
        } catch (zzgpy e2) {
            throw e2;
        } catch (IndexOutOfBoundsException unused) {
            throw zzgpy.zzj();
        } catch (IOException e3) {
            throw new RuntimeException("Reading from byte array should not throw IOException.", e3);
        }
    }

    public final MessageType zzal() {
        MessageType zzam = zzan();
        if (zzam.zzaX()) {
            return zzam;
        }
        throw new zzgsf(zzam);
    }

    /* renamed from: zzam */
    public MessageType zzan() {
        if (!this.zza.zzaY()) {
            return this.zza;
        }
        this.zza.zzaS();
        return this.zza;
    }

    /* access modifiers changed from: protected */
    public final void zzap() {
        if (!this.zza.zzaY()) {
            zzaq();
        }
    }

    /* access modifiers changed from: protected */
    public void zzaq() {
        zzgpm zzaD = this.zzb.zzaD();
        zza(zzaD, this.zza);
        this.zza = zzaD;
    }

    public final /* synthetic */ zzgqw zzbf() {
        throw null;
    }
}
