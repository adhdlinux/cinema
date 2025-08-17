package androidx.media3.extractor.mp4;

import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableByteArray;
import java.nio.ByteBuffer;
import java.util.UUID;
import okhttp3.internal.http2.Http2Connection;

public final class PsshAtomUtil {

    public static final class PsshAtom {

        /* renamed from: a  reason: collision with root package name */
        public final UUID f8647a;

        /* renamed from: b  reason: collision with root package name */
        public final int f8648b;

        /* renamed from: c  reason: collision with root package name */
        public final byte[] f8649c;

        /* renamed from: d  reason: collision with root package name */
        public final UUID[] f8650d;

        PsshAtom(UUID uuid, int i2, byte[] bArr, UUID[] uuidArr) {
            this.f8647a = uuid;
            this.f8648b = i2;
            this.f8649c = bArr;
            this.f8650d = uuidArr;
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
        if (bArr == null || bArr.length == 0) {
            allocate.putInt(0);
        } else {
            allocate.putInt(bArr.length);
            allocate.put(bArr);
        }
        return allocate.array();
    }

    public static boolean c(byte[] bArr) {
        return d(bArr) != null;
    }

    public static PsshAtom d(byte[] bArr) {
        UUID[] uuidArr;
        ParsableByteArray parsableByteArray = new ParsableByteArray(bArr);
        if (parsableByteArray.g() < 32) {
            return null;
        }
        parsableByteArray.U(0);
        int a2 = parsableByteArray.a();
        int q2 = parsableByteArray.q();
        if (q2 != a2) {
            Log.h("PsshAtomUtil", "Advertised atom size (" + q2 + ") does not match buffer size: " + a2);
            return null;
        }
        int q3 = parsableByteArray.q();
        if (q3 != 1886614376) {
            Log.h("PsshAtomUtil", "Atom type is not pssh: " + q3);
            return null;
        }
        int c2 = Atom.c(parsableByteArray.q());
        if (c2 > 1) {
            Log.h("PsshAtomUtil", "Unsupported pssh version: " + c2);
            return null;
        }
        UUID uuid = new UUID(parsableByteArray.A(), parsableByteArray.A());
        if (c2 == 1) {
            int L = parsableByteArray.L();
            uuidArr = new UUID[L];
            for (int i2 = 0; i2 < L; i2++) {
                uuidArr[i2] = new UUID(parsableByteArray.A(), parsableByteArray.A());
            }
        } else {
            uuidArr = null;
        }
        int L2 = parsableByteArray.L();
        int a3 = parsableByteArray.a();
        if (L2 != a3) {
            Log.h("PsshAtomUtil", "Atom data size (" + L2 + ") does not match the bytes left: " + a3);
            return null;
        }
        byte[] bArr2 = new byte[L2];
        parsableByteArray.l(bArr2, 0, L2);
        return new PsshAtom(uuid, c2, bArr2, uuidArr);
    }

    public static byte[] e(byte[] bArr, UUID uuid) {
        PsshAtom d2 = d(bArr);
        if (d2 == null) {
            return null;
        }
        if (uuid.equals(d2.f8647a)) {
            return d2.f8649c;
        }
        Log.h("PsshAtomUtil", "UUID mismatch. Expected: " + uuid + ", got: " + d2.f8647a + ".");
        return null;
    }

    public static UUID f(byte[] bArr) {
        PsshAtom d2 = d(bArr);
        if (d2 == null) {
            return null;
        }
        return d2.f8647a;
    }

    public static int g(byte[] bArr) {
        PsshAtom d2 = d(bArr);
        if (d2 == null) {
            return -1;
        }
        return d2.f8648b;
    }
}
