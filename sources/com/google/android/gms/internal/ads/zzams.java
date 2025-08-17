package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class zzams implements zzamt {
    private static final Logger zzb = Logger.getLogger(zzams.class.getName());
    final ThreadLocal zza = new zzamr(this);

    public abstract zzamw zza(String str, byte[] bArr, String str2);

    public final zzamw zzb(zzgvq zzgvq, zzamx zzamx) throws IOException {
        int zza2;
        long j2;
        String str;
        long zzb2 = zzgvq.zzb();
        ((ByteBuffer) this.zza.get()).rewind().limit(8);
        do {
            zza2 = zzgvq.zza((ByteBuffer) this.zza.get());
            if (zza2 == 8) {
                ((ByteBuffer) this.zza.get()).rewind();
                long zze = zzamv.zze((ByteBuffer) this.zza.get());
                byte[] bArr = null;
                if (zze >= 8 || zze <= 1) {
                    byte[] bArr2 = new byte[4];
                    ((ByteBuffer) this.zza.get()).get(bArr2);
                    try {
                        String str2 = new String(bArr2, "ISO-8859-1");
                        if (zze == 1) {
                            ((ByteBuffer) this.zza.get()).limit(16);
                            zzgvq.zza((ByteBuffer) this.zza.get());
                            ((ByteBuffer) this.zza.get()).position(8);
                            j2 = zzamv.zzf((ByteBuffer) this.zza.get()) - 16;
                        } else if (zze == 0) {
                            j2 = zzgvq.zzc() - zzgvq.zzb();
                        } else {
                            j2 = zze - 8;
                        }
                        if ("uuid".equals(str2)) {
                            ((ByteBuffer) this.zza.get()).limit(((ByteBuffer) this.zza.get()).limit() + 16);
                            zzgvq.zza((ByteBuffer) this.zza.get());
                            bArr = new byte[16];
                            for (int position = ((ByteBuffer) this.zza.get()).position() - 16; position < ((ByteBuffer) this.zza.get()).position(); position++) {
                                bArr[position - (((ByteBuffer) this.zza.get()).position() - 16)] = ((ByteBuffer) this.zza.get()).get(position);
                            }
                            j2 -= 16;
                        }
                        long j3 = j2;
                        if (zzamx instanceof zzamw) {
                            str = ((zzamw) zzamx).zza();
                        } else {
                            str = "";
                        }
                        zzamw zza3 = zza(str2, bArr, str);
                        zza3.zzc(zzamx);
                        ((ByteBuffer) this.zza.get()).rewind();
                        zza3.zzb(zzgvq, (ByteBuffer) this.zza.get(), j3, this);
                        return zza3;
                    } catch (UnsupportedEncodingException e2) {
                        throw new RuntimeException(e2);
                    }
                } else {
                    Logger logger = zzb;
                    Level level = Level.SEVERE;
                    StringBuilder sb = new StringBuilder(80);
                    sb.append("Plausibility check failed: size < 8 (size = ");
                    sb.append(zze);
                    sb.append("). Stop parsing!");
                    logger.logp(level, "com.coremedia.iso.AbstractBoxParser", "parseBox", sb.toString());
                    return null;
                }
            }
        } while (zza2 >= 0);
        zzgvq.zze(zzb2);
        throw new EOFException();
    }
}
