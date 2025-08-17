package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

final class zzqi extends zzds {
    private static final int zzd = Float.floatToIntBits(Float.NaN);

    zzqi() {
    }

    private static void zzo(int i2, ByteBuffer byteBuffer) {
        int floatToIntBits = Float.floatToIntBits((float) (((double) i2) * 4.656612875245797E-10d));
        if (floatToIntBits == zzd) {
            floatToIntBits = Float.floatToIntBits(0.0f);
        }
        byteBuffer.putInt(floatToIntBits);
    }

    public final void zze(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2;
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int i2 = limit - position;
        int i3 = this.zzb.zzd;
        if (i3 == 536870912) {
            byteBuffer2 = zzj((i2 / 3) * 4);
            while (position < limit) {
                zzo(((byteBuffer.get(position) & 255) << 8) | ((byteBuffer.get(position + 1) & 255) << 16) | ((byteBuffer.get(position + 2) & 255) << 24), byteBuffer2);
                position += 3;
            }
        } else if (i3 == 805306368) {
            byteBuffer2 = zzj(i2);
            while (position < limit) {
                zzo((byteBuffer.get(position) & 255) | ((byteBuffer.get(position + 1) & 255) << 8) | ((byteBuffer.get(position + 2) & 255) << 16) | ((byteBuffer.get(position + 3) & 255) << 24), byteBuffer2);
                position += 4;
            }
        } else {
            throw new IllegalStateException();
        }
        byteBuffer.position(byteBuffer.limit());
        byteBuffer2.flip();
    }

    public final zzdp zzi(zzdp zzdp) throws zzdq {
        int i2 = zzdp.zzd;
        int i3 = zzfj.zza;
        if (i2 == 536870912 || i2 == 805306368) {
            return new zzdp(zzdp.zzb, zzdp.zzc, 4);
        }
        if (i2 == 4) {
            return zzdp.zza;
        }
        throw new zzdq("Unhandled input format:", zzdp);
    }
}
