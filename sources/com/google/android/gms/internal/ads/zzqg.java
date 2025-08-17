package com.google.android.gms.internal.ads;

import com.facebook.imageutils.JfifUtil;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class zzqg {
    private ByteBuffer zza = zzdr.zza;
    private int zzb = 2;
    private int zzc = 0;

    public final void zza(zzhp zzhp) {
        ByteBuffer byteBuffer = zzhp.zzb;
        byteBuffer.getClass();
        if (byteBuffer.limit() - zzhp.zzb.position() != 0) {
            ByteBuffer byteBuffer2 = zzhp.zzb;
            int position = byteBuffer2.position();
            int limit = byteBuffer2.limit();
            int i2 = limit - position;
            int capacity = this.zza.capacity();
            int i3 = (i2 + JfifUtil.MARKER_FIRST_BYTE) / JfifUtil.MARKER_FIRST_BYTE;
            int i4 = i3 + 27 + i2;
            if (capacity < i4) {
                this.zza = ByteBuffer.allocate(i4).order(ByteOrder.LITTLE_ENDIAN);
            } else {
                this.zza.clear();
            }
            ByteBuffer byteBuffer3 = this.zza;
            byteBuffer3.put((byte) 79);
            byteBuffer3.put((byte) 103);
            byteBuffer3.put((byte) 103);
            byteBuffer3.put((byte) 83);
            byteBuffer3.put((byte) 0);
            byteBuffer3.put((byte) 0);
            int zzb2 = this.zzc + zzabr.zzb(byteBuffer2);
            this.zzc = zzb2;
            byteBuffer3.putLong((long) zzb2);
            byteBuffer3.putInt(0);
            byteBuffer3.putInt(this.zzb);
            this.zzb++;
            byteBuffer3.putInt(0);
            byteBuffer3.put((byte) i3);
            for (int i5 = 0; i5 < i3; i5++) {
                if (i2 >= 255) {
                    byteBuffer3.put((byte) -1);
                    i2 -= 255;
                } else {
                    byteBuffer3.put((byte) i2);
                    i2 = 0;
                }
            }
            while (position < limit) {
                byteBuffer3.put(byteBuffer2.get(position));
                position++;
            }
            byteBuffer2.position(byteBuffer2.limit());
            byteBuffer3.flip();
            byteBuffer3.putInt(22, zzfj.zzd(byteBuffer3.array(), byteBuffer3.arrayOffset(), byteBuffer3.limit() - byteBuffer3.position(), 0));
            byteBuffer3.position(0);
            this.zza = byteBuffer3;
            zzhp.zzb();
            zzhp.zzj(this.zza.remaining());
            zzhp.zzb.put(this.zza);
            zzhp.zzk();
        }
    }

    public final void zzb() {
        this.zza = zzdr.zza;
        this.zzc = 0;
        this.zzb = 2;
    }
}
