package com.google.android.exoplayer2.extractor.mp4;

import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.nio.ByteBuffer;
import java.util.UUID;
import okhttp3.internal.http2.Http2Connection;

public final class PsshAtomUtil {

    private static class PsshAtom {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final UUID f24647a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final int f24648b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public final byte[] f24649c;

        public PsshAtom(UUID uuid, int i2, byte[] bArr) {
            this.f24647a = uuid;
            this.f24648b = i2;
            this.f24649c = bArr;
        }
    }

    private PsshAtomUtil() {
    }

    public static byte[] a(UUID uuid, byte[] bArr) {
        return b(uuid, (UUID[]) null, bArr);
    }

    public static byte[] b(UUID uuid, UUID[] uuidArr, byte[] bArr) {
        int i2;
        int i3;
        if (bArr != null) {
            i2 = bArr.length;
        } else {
            i2 = 0;
        }
        int i4 = i2 + 32;
        if (uuidArr != null) {
            i4 += (uuidArr.length * 16) + 4;
        }
        ByteBuffer allocate = ByteBuffer.allocate(i4);
        allocate.putInt(i4);
        allocate.putInt(1886614376);
        if (uuidArr != null) {
            i3 = Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE;
        } else {
            i3 = 0;
        }
        allocate.putInt(i3);
        allocate.putLong(uuid.getMostSignificantBits());
        allocate.putLong(uuid.getLeastSignificantBits());
        if (uuidArr != null) {
            allocate.putInt(uuidArr.length);
            for (UUID uuid2 : uuidArr) {
                allocate.putLong(uuid2.getMostSignificantBits());
                allocate.putLong(uuid2.getLeastSignificantBits());
            }
        }
        if (!(bArr == null || bArr.length == 0)) {
            allocate.putInt(bArr.length);
            allocate.put(bArr);
        }
        return allocate.array();
    }

    public static boolean c(byte[] bArr) {
        return d(bArr) != null;
    }

    private static PsshAtom d(byte[] bArr) {
        ParsableByteArray parsableByteArray = new ParsableByteArray(bArr);
        if (parsableByteArray.g() < 32) {
            return null;
        }
        parsableByteArray.U(0);
        if (parsableByteArray.q() != parsableByteArray.a() + 4 || parsableByteArray.q() != 1886614376) {
            return null;
        }
        int c2 = Atom.c(parsableByteArray.q());
        if (c2 > 1) {
            Log.i("PsshAtomUtil", "Unsupported pssh version: " + c2);
            return null;
        }
        UUID uuid = new UUID(parsableByteArray.A(), parsableByteArray.A());
        if (c2 == 1) {
            parsableByteArray.V(parsableByteArray.L() * 16);
        }
        int L = parsableByteArray.L();
        if (L != parsableByteArray.a()) {
            return null;
        }
        byte[] bArr2 = new byte[L];
        parsableByteArray.l(bArr2, 0, L);
        return new PsshAtom(uuid, c2, bArr2);
    }

    public static byte[] e(byte[] bArr, UUID uuid) {
        PsshAtom d2 = d(bArr);
        if (d2 == null) {
            return null;
        }
        if (uuid.equals(d2.f24647a)) {
            return d2.f24649c;
        }
        Log.i("PsshAtomUtil", "UUID mismatch. Expected: " + uuid + ", got: " + d2.f24647a + ".");
        return null;
    }

    public static UUID f(byte[] bArr) {
        PsshAtom d2 = d(bArr);
        if (d2 == null) {
            return null;
        }
        return d2.f24647a;
    }

    public static int g(byte[] bArr) {
        PsshAtom d2 = d(bArr);
        if (d2 == null) {
            return -1;
        }
        return d2.f24648b;
    }
}
