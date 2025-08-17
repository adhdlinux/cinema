package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public final class zzfyh {
    private final Class zza;
    private ConcurrentMap zzb = new ConcurrentHashMap();
    private final List zzc = new ArrayList();
    private zzfyi zzd;
    private zzghn zze;

    /* synthetic */ zzfyh(Class cls, zzfyg zzfyg) {
        this.zza = cls;
        this.zze = zzghn.zza;
    }

    private final zzfyh zze(Object obj, Object obj2, zzgkw zzgkw, boolean z2) throws GeneralSecurityException {
        byte[] bArr;
        if (this.zzb == null) {
            throw new IllegalStateException("addPrimitive cannot be called after build");
        } else if (obj == null && obj2 == null) {
            throw new GeneralSecurityException("at least one of the `fullPrimitive` or `primitive` must be set");
        } else if (zzgkw.zzk() == 3) {
            Integer valueOf = Integer.valueOf(zzgkw.zza());
            if (zzgkw.zzf() == zzglq.RAW) {
                valueOf = null;
            }
            zzfxn zza2 = zzgeg.zzc().zza(zzgfa.zza(zzgkw.zzc().zzg(), zzgkw.zzc().zzf(), zzgkw.zzc().zzc(), zzgkw.zzf(), valueOf), zzfyq.zza());
            int ordinal = zzgkw.zzf().ordinal();
            if (ordinal != 1) {
                if (ordinal != 2) {
                    if (ordinal == 3) {
                        bArr = zzfxm.zza;
                    } else if (ordinal != 4) {
                        throw new GeneralSecurityException("unknown output prefix type");
                    }
                }
                bArr = ByteBuffer.allocate(5).put((byte) 0).putInt(zzgkw.zza()).array();
            } else {
                bArr = ByteBuffer.allocate(5).put((byte) 1).putInt(zzgkw.zza()).array();
            }
            zzfyi zzfyi = new zzfyi(obj, obj2, bArr, zzgkw.zzk(), zzgkw.zzf(), zzgkw.zza(), zzgkw.zzc().zzg(), zza2);
            ConcurrentMap concurrentMap = this.zzb;
            List list = this.zzc;
            ArrayList arrayList = new ArrayList();
            arrayList.add(zzfyi);
            zzfyk zzfyk = new zzfyk(zzfyi.zzg(), (zzfyj) null);
            List list2 = (List) concurrentMap.put(zzfyk, Collections.unmodifiableList(arrayList));
            if (list2 != null) {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.addAll(list2);
                arrayList2.add(zzfyi);
                concurrentMap.put(zzfyk, Collections.unmodifiableList(arrayList2));
            }
            list.add(zzfyi);
            if (z2) {
                if (this.zzd == null) {
                    this.zzd = zzfyi;
                } else {
                    throw new IllegalStateException("you cannot set two primary primitives");
                }
            }
            return this;
        } else {
            throw new GeneralSecurityException("only ENABLED key is allowed");
        }
    }

    public final zzfyh zza(Object obj, Object obj2, zzgkw zzgkw) throws GeneralSecurityException {
        zze(obj, obj2, zzgkw, false);
        return this;
    }

    public final zzfyh zzb(Object obj, Object obj2, zzgkw zzgkw) throws GeneralSecurityException {
        zze(obj, obj2, zzgkw, true);
        return this;
    }

    public final zzfyh zzc(zzghn zzghn) {
        if (this.zzb != null) {
            this.zze = zzghn;
            return this;
        }
        throw new IllegalStateException("setAnnotations cannot be called after build");
    }

    public final zzfym zzd() throws GeneralSecurityException {
        ConcurrentMap concurrentMap = this.zzb;
        if (concurrentMap != null) {
            zzfym zzfym = new zzfym(concurrentMap, this.zzc, this.zzd, this.zze, this.zza, (zzfyl) null);
            this.zzb = null;
            return zzfym;
        }
        throw new IllegalStateException("build cannot be called twice");
    }
}
