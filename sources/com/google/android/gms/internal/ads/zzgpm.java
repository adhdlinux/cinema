package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgpi;
import com.google.android.gms.internal.ads.zzgpm;
import com.google.protobuf.CodedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class zzgpm<MessageType extends zzgpm<MessageType, BuilderType>, BuilderType extends zzgpi<MessageType, BuilderType>> extends zzgnn<MessageType, BuilderType> {
    private static final Map zzb = new ConcurrentHashMap();
    protected zzgsh zzc = zzgsh.zzc();
    private int zzd = -1;

    private final int zza(zzgrp zzgrp) {
        return zzgre.zza().zzb(getClass()).zza(this);
    }

    static zzgpm zzaC(Class cls) {
        Map map = zzb;
        zzgpm zzgpm = (zzgpm) map.get(cls);
        if (zzgpm == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzgpm = (zzgpm) map.get(cls);
            } catch (ClassNotFoundException e2) {
                throw new IllegalStateException("Class initialization cannot fail.", e2);
            }
        }
        if (zzgpm == null) {
            zzgpm = (zzgpm) ((zzgpm) zzgsq.zzg(cls)).zzb(6, (Object) null, (Object) null);
            if (zzgpm != null) {
                map.put(cls, zzgpm);
            } else {
                throw new IllegalStateException();
            }
        }
        return zzgpm;
    }

    protected static zzgpm zzaE(zzgpm zzgpm, zzgoe zzgoe) throws zzgpy {
        zzgoy zzgoy = zzgoy.zza;
        zzgom zzl = zzgoe.zzl();
        zzgpm zzaD = zzgpm.zzaD();
        try {
            zzgrp zzb2 = zzgre.zza().zzb(zzaD.getClass());
            zzb2.zzh(zzaD, zzgon.zzq(zzl), zzgoy);
            zzb2.zzf(zzaD);
            try {
                zzl.zzz(0);
                zzc(zzaD);
                zzc(zzaD);
                return zzaD;
            } catch (zzgpy e2) {
                e2.zzh(zzaD);
                throw e2;
            }
        } catch (zzgpy e3) {
            e = e3;
            if (e.zzl()) {
                e = new zzgpy((IOException) e);
            }
            e.zzh(zzaD);
            throw e;
        } catch (zzgsf e4) {
            zzgpy zza = e4.zza();
            zza.zzh(zzaD);
            throw zza;
        } catch (IOException e5) {
            if (e5.getCause() instanceof zzgpy) {
                throw ((zzgpy) e5.getCause());
            }
            zzgpy zzgpy = new zzgpy(e5);
            zzgpy.zzh(zzaD);
            throw zzgpy;
        } catch (RuntimeException e6) {
            if (e6.getCause() instanceof zzgpy) {
                throw ((zzgpy) e6.getCause());
            }
            throw e6;
        }
    }

    protected static zzgpm zzaF(zzgpm zzgpm, byte[] bArr) throws zzgpy {
        zzgpm zzd2 = zzd(zzgpm, bArr, 0, bArr.length, zzgoy.zza);
        zzc(zzd2);
        return zzd2;
    }

    protected static zzgpm zzaG(zzgpm zzgpm, zzgoe zzgoe, zzgoy zzgoy) throws zzgpy {
        zzgom zzl = zzgoe.zzl();
        zzgpm zzaD = zzgpm.zzaD();
        try {
            zzgrp zzb2 = zzgre.zza().zzb(zzaD.getClass());
            zzb2.zzh(zzaD, zzgon.zzq(zzl), zzgoy);
            zzb2.zzf(zzaD);
            try {
                zzl.zzz(0);
                zzc(zzaD);
                return zzaD;
            } catch (zzgpy e2) {
                e2.zzh(zzaD);
                throw e2;
            }
        } catch (zzgpy e3) {
            e = e3;
            if (e.zzl()) {
                e = new zzgpy((IOException) e);
            }
            e.zzh(zzaD);
            throw e;
        } catch (zzgsf e4) {
            zzgpy zza = e4.zza();
            zza.zzh(zzaD);
            throw zza;
        } catch (IOException e5) {
            if (e5.getCause() instanceof zzgpy) {
                throw ((zzgpy) e5.getCause());
            }
            zzgpy zzgpy = new zzgpy(e5);
            zzgpy.zzh(zzaD);
            throw zzgpy;
        } catch (RuntimeException e6) {
            if (e6.getCause() instanceof zzgpy) {
                throw ((zzgpy) e6.getCause());
            }
            throw e6;
        }
    }

    protected static zzgpm zzaH(zzgpm zzgpm, InputStream inputStream, zzgoy zzgoy) throws zzgpy {
        zzgom zzH = zzgom.zzH(inputStream, CodedOutputStream.DEFAULT_BUFFER_SIZE);
        zzgpm zzaD = zzgpm.zzaD();
        try {
            zzgrp zzb2 = zzgre.zza().zzb(zzaD.getClass());
            zzb2.zzh(zzaD, zzgon.zzq(zzH), zzgoy);
            zzb2.zzf(zzaD);
            zzc(zzaD);
            return zzaD;
        } catch (zzgpy e2) {
            e = e2;
            if (e.zzl()) {
                e = new zzgpy((IOException) e);
            }
            e.zzh(zzaD);
            throw e;
        } catch (zzgsf e3) {
            zzgpy zza = e3.zza();
            zza.zzh(zzaD);
            throw zza;
        } catch (IOException e4) {
            if (e4.getCause() instanceof zzgpy) {
                throw ((zzgpy) e4.getCause());
            }
            zzgpy zzgpy = new zzgpy(e4);
            zzgpy.zzh(zzaD);
            throw zzgpy;
        } catch (RuntimeException e5) {
            if (e5.getCause() instanceof zzgpy) {
                throw ((zzgpy) e5.getCause());
            }
            throw e5;
        }
    }

    protected static zzgpm zzaI(zzgpm zzgpm, byte[] bArr, zzgoy zzgoy) throws zzgpy {
        zzgpm zzd2 = zzd(zzgpm, bArr, 0, bArr.length, zzgoy);
        zzc(zzd2);
        return zzd2;
    }

    protected static zzgpr zzaJ() {
        return zzgpn.zzf();
    }

    protected static zzgpr zzaK(zzgpr zzgpr) {
        int i2;
        int size = zzgpr.size();
        if (size == 0) {
            i2 = 10;
        } else {
            i2 = size + size;
        }
        return zzgpr.zzg(i2);
    }

    protected static zzgpu zzaL() {
        return zzgql.zzf();
    }

    protected static zzgpu zzaM(zzgpu zzgpu) {
        int i2;
        int size = zzgpu.size();
        if (size == 0) {
            i2 = 10;
        } else {
            i2 = size + size;
        }
        return zzgpu.zza(i2);
    }

    protected static zzgpv zzaN() {
        return zzgrf.zze();
    }

    protected static zzgpv zzaO(zzgpv zzgpv) {
        int i2;
        int size = zzgpv.size();
        if (size == 0) {
            i2 = 10;
        } else {
            i2 = size + size;
        }
        return zzgpv.zzd(i2);
    }

    static Object zzaQ(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e2);
        } catch (InvocationTargetException e3) {
            Throwable cause = e3.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else if (cause instanceof Error) {
                throw ((Error) cause);
            } else {
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
        }
    }

    protected static Object zzaR(zzgqw zzgqw, String str, Object[] objArr) {
        return new zzgrg(zzgqw, str, objArr);
    }

    protected static void zzaU(Class cls, zzgpm zzgpm) {
        zzgpm.zzaT();
        zzb.put(cls, zzgpm);
    }

    private static zzgpm zzc(zzgpm zzgpm) throws zzgpy {
        if (zzgpm == null || zzgpm.zzaX()) {
            return zzgpm;
        }
        zzgpy zza = new zzgsf(zzgpm).zza();
        zza.zzh(zzgpm);
        throw zza;
    }

    private static zzgpm zzd(zzgpm zzgpm, byte[] bArr, int i2, int i3, zzgoy zzgoy) throws zzgpy {
        zzgpm zzaD = zzgpm.zzaD();
        try {
            zzgrp zzb2 = zzgre.zza().zzb(zzaD.getClass());
            zzb2.zzi(zzaD, bArr, 0, i3, new zzgnq(zzgoy));
            zzb2.zzf(zzaD);
            return zzaD;
        } catch (zzgpy e2) {
            e = e2;
            if (e.zzl()) {
                e = new zzgpy((IOException) e);
            }
            e.zzh(zzaD);
            throw e;
        } catch (zzgsf e3) {
            zzgpy zza = e3.zza();
            zza.zzh(zzaD);
            throw zza;
        } catch (IOException e4) {
            if (e4.getCause() instanceof zzgpy) {
                throw ((zzgpy) e4.getCause());
            }
            zzgpy zzgpy = new zzgpy(e4);
            zzgpy.zzh(zzaD);
            throw zzgpy;
        } catch (IndexOutOfBoundsException unused) {
            zzgpy zzj = zzgpy.zzj();
            zzj.zzh(zzaD);
            throw zzj;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return zzgre.zza().zzb(getClass()).zzj(this, (zzgpm) obj);
    }

    public final int hashCode() {
        if (zzaY()) {
            return zzay();
        }
        int i2 = this.zza;
        if (i2 != 0) {
            return i2;
        }
        int zzay = zzay();
        this.zza = zzay;
        return zzay;
    }

    public final String toString() {
        return zzgqy.zza(this, super.toString());
    }

    /* access modifiers changed from: protected */
    public final zzgpi zzaA() {
        return (zzgpi) zzb(5, (Object) null, (Object) null);
    }

    public final zzgpi zzaB() {
        zzgpi zzgpi = (zzgpi) zzb(5, (Object) null, (Object) null);
        zzgpi.zzaj(this);
        return zzgpi;
    }

    /* access modifiers changed from: package-private */
    public final zzgpm zzaD() {
        return (zzgpm) zzb(4, (Object) null, (Object) null);
    }

    public final /* synthetic */ zzgqv zzaP() {
        return (zzgpi) zzb(5, (Object) null, (Object) null);
    }

    /* access modifiers changed from: protected */
    public final void zzaS() {
        zzgre.zza().zzb(getClass()).zzf(this);
        zzaT();
    }

    /* access modifiers changed from: package-private */
    public final void zzaT() {
        this.zzd &= Integer.MAX_VALUE;
    }

    /* access modifiers changed from: package-private */
    public final void zzaV(int i2) {
        this.zzd = (this.zzd & Integer.MIN_VALUE) | Integer.MAX_VALUE;
    }

    public final void zzaW(zzgot zzgot) throws IOException {
        zzgre.zza().zzb(getClass()).zzm(this, zzgou.zza(zzgot));
    }

    public final boolean zzaX() {
        zzgpm zzgpm;
        byte byteValue = ((Byte) zzb(1, (Object) null, (Object) null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean zzk = zzgre.zza().zzb(getClass()).zzk(this);
        if (true != zzk) {
            zzgpm = null;
        } else {
            zzgpm = this;
        }
        zzb(2, zzgpm, (Object) null);
        return zzk;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzaY() {
        return (this.zzd & Integer.MIN_VALUE) != 0;
    }

    /* access modifiers changed from: package-private */
    public final int zzat(zzgrp zzgrp) {
        if (zzaY()) {
            int zza = zzgrp.zza(this);
            if (zza >= 0) {
                return zza;
            }
            throw new IllegalStateException("serialized size must be non-negative, was " + zza);
        }
        int i2 = this.zzd & Integer.MAX_VALUE;
        if (i2 != Integer.MAX_VALUE) {
            return i2;
        }
        int zza2 = zzgrp.zza(this);
        if (zza2 >= 0) {
            this.zzd = (this.zzd & Integer.MIN_VALUE) | zza2;
            return zza2;
        }
        throw new IllegalStateException("serialized size must be non-negative, was " + zza2);
    }

    /* access modifiers changed from: package-private */
    public final int zzay() {
        return zzgre.zza().zzb(getClass()).zzb(this);
    }

    public final int zzaz() {
        int i2;
        if (zzaY()) {
            i2 = zza((zzgrp) null);
            if (i2 < 0) {
                throw new IllegalStateException("serialized size must be non-negative, was " + i2);
            }
        } else {
            i2 = this.zzd & Integer.MAX_VALUE;
            if (i2 == Integer.MAX_VALUE) {
                i2 = zza((zzgrp) null);
                if (i2 >= 0) {
                    this.zzd = (this.zzd & Integer.MIN_VALUE) | i2;
                } else {
                    throw new IllegalStateException("serialized size must be non-negative, was " + i2);
                }
            }
        }
        return i2;
    }

    /* access modifiers changed from: protected */
    public abstract Object zzb(int i2, Object obj, Object obj2);

    public final /* synthetic */ zzgqw zzbf() {
        return (zzgpm) zzb(6, (Object) null, (Object) null);
    }
}
