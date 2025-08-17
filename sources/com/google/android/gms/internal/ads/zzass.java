package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

public final class zzass extends zzath {
    private final zzaqw zzi;
    private final long zzj;
    private final long zzk;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzass(zzart zzart, String str, String str2, zzanq zzanq, int i2, int i3, zzaqw zzaqw, long j2, long j3) {
        super(zzart, "hDi2yHM1WBnaBo8xfxWY0dwLv3vkmI37udU/dWBh2W+Ynkfo3oZQp4Q+03pBto4q", "2+LdC0cYaqAwYHmCPPvRLMkFDbEQiwTEweQcBW/SUlU=", zzanq, i2, 11);
        this.zzi = zzaqw;
        this.zzj = j2;
        this.zzk = j3;
    }

    /* access modifiers changed from: protected */
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        zzaqw zzaqw = this.zzi;
        if (zzaqw != null) {
            zzaqu zzaqu = new zzaqu((String) this.zzf.invoke((Object) null, new Object[]{zzaqw.zzb(), Long.valueOf(this.zzj), Long.valueOf(this.zzk)}));
            synchronized (this.zze) {
                this.zze.zzz(zzaqu.zza.longValue());
                if (zzaqu.zzb.longValue() >= 0) {
                    this.zze.zzQ(zzaqu.zzb.longValue());
                }
                if (zzaqu.zzc.longValue() >= 0) {
                    this.zze.zzf(zzaqu.zzc.longValue());
                }
            }
        }
    }
}
