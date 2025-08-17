package com.google.android.gms.internal.ads;

import com.facebook.imageutils.JfifUtil;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import com.google.protobuf.CodedOutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

final class zzaph {
    static boolean zza = false;
    static final CountDownLatch zzb = new CountDownLatch(1);
    public static final /* synthetic */ int zzc = 0;
    /* access modifiers changed from: private */
    public static MessageDigest zzd;
    private static final Object zze = new Object();
    private static final Object zzf = new Object();

    static String zza(byte[] bArr, String str) throws GeneralSecurityException, UnsupportedEncodingException {
        byte[] bArr2;
        Vector zzb2 = zzb(bArr, JfifUtil.MARKER_FIRST_BYTE);
        if (zzb2 == null || zzb2.size() == 0) {
            bArr2 = zzg(zzf(CodedOutputStream.DEFAULT_BUFFER_SIZE).zzax(), str, true);
        } else {
            zzaoz zza2 = zzapa.zza();
            int size = zzb2.size();
            for (int i2 = 0; i2 < size; i2++) {
                zza2.zza(zzgoe.zzv(zzg((byte[]) zzb2.get(i2), str, false), 0, UserVerificationMethods.USER_VERIFY_HANDPRINT));
            }
            byte[] zze2 = zze(bArr);
            zzgoe zzgoe = zzgoe.zzb;
            zza2.zzb(zzgoe.zzv(zze2, 0, zze2.length));
            bArr2 = ((zzapa) zza2.zzal()).zzax();
        }
        return zzapd.zza(bArr2, true);
    }

    static Vector zzb(byte[] bArr, int i2) {
        int length = bArr.length;
        if (length <= 0) {
            return null;
        }
        int i3 = length + 254;
        Vector vector = new Vector();
        int i4 = 0;
        while (i4 < i3 / JfifUtil.MARKER_FIRST_BYTE) {
            int i5 = i4 * JfifUtil.MARKER_FIRST_BYTE;
            try {
                int length2 = bArr.length;
                if (length2 - i5 > 255) {
                    length2 = i5 + JfifUtil.MARKER_FIRST_BYTE;
                }
                vector.add(Arrays.copyOfRange(bArr, i5, length2));
                i4++;
            } catch (IndexOutOfBoundsException unused) {
                return null;
            }
        }
        return vector;
    }

    static void zzd() {
        synchronized (zzf) {
            if (!zza) {
                zza = true;
                new Thread(new zzapg((zzapf) null)).start();
            }
        }
    }

    public static byte[] zze(byte[] bArr) throws NoSuchAlgorithmException {
        byte[] digest;
        synchronized (zze) {
            zzd();
            MessageDigest messageDigest = null;
            try {
                if (zzb.await(2, TimeUnit.SECONDS)) {
                    MessageDigest messageDigest2 = zzd;
                    if (messageDigest2 != null) {
                        messageDigest = messageDigest2;
                    }
                }
            } catch (InterruptedException unused) {
            }
            if (messageDigest != null) {
                messageDigest.reset();
                messageDigest.update(bArr);
                digest = zzd.digest();
            } else {
                throw new NoSuchAlgorithmException("Cannot compute hash");
            }
        }
        return digest;
    }

    static zzaon zzf(int i2) {
        zzanq zza2 = zzaon.zza();
        zza2.zzD(4096);
        return (zzaon) zza2.zzal();
    }

    private static byte[] zzg(byte[] bArr, String str, boolean z2) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        int i2;
        byte[] bArr2;
        int length = bArr.length;
        if (true != z2) {
            i2 = JfifUtil.MARKER_FIRST_BYTE;
        } else {
            i2 = 239;
        }
        if (length > i2) {
            bArr = zzf(CodedOutputStream.DEFAULT_BUFFER_SIZE).zzax();
        }
        int length2 = bArr.length;
        if (length2 < i2) {
            byte[] bArr3 = new byte[(i2 - length2)];
            new SecureRandom().nextBytes(bArr3);
            bArr2 = ByteBuffer.allocate(i2 + 1).put((byte) length2).put(bArr).put(bArr3).array();
        } else {
            bArr2 = ByteBuffer.allocate(i2 + 1).put((byte) length2).put(bArr).array();
        }
        if (z2) {
            bArr2 = ByteBuffer.allocate(UserVerificationMethods.USER_VERIFY_HANDPRINT).put(zze(bArr2)).put(bArr2).array();
        }
        byte[] bArr4 = new byte[UserVerificationMethods.USER_VERIFY_HANDPRINT];
        zzapi[] zzapiArr = new zzaqh().zzcG;
        int length3 = zzapiArr.length;
        for (int i3 = 0; i3 < 12; i3++) {
            zzapiArr[i3].zza(bArr2, bArr4);
        }
        if (str != null && str.length() > 0) {
            if (str.length() > 32) {
                str = str.substring(0, 32);
            }
            new zzapb(str.getBytes("UTF-8")).zza(bArr4);
        }
        return bArr4;
    }
}
