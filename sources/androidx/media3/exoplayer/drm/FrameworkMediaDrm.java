package androidx.media3.exoplayer.drm;

import android.annotation.SuppressLint;
import android.media.DeniedByServerException;
import android.media.MediaCryptoException;
import android.media.MediaDrm;
import android.media.MediaDrmException;
import android.media.NotProvisionedException;
import android.media.UnsupportedSchemeException;
import android.media.metrics.LogSessionId;
import android.text.TextUtils;
import androidx.media3.common.C;
import androidx.media3.common.DrmInitData;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.drm.ExoMediaDrm;
import androidx.media3.extractor.mp4.PsshAtomUtil;
import com.google.common.base.Charsets;
import com.unity3d.ads.metadata.MediationMetaData;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

public final class FrameworkMediaDrm implements ExoMediaDrm {

    /* renamed from: d  reason: collision with root package name */
    public static final ExoMediaDrm.Provider f6239d = new v();

    /* renamed from: a  reason: collision with root package name */
    private final UUID f6240a;

    /* renamed from: b  reason: collision with root package name */
    private final MediaDrm f6241b;

    /* renamed from: c  reason: collision with root package name */
    private int f6242c = 1;

    private static class Api31 {
        private Api31() {
        }

        public static boolean a(MediaDrm mediaDrm, String str) {
            return mediaDrm.requiresSecureDecoder(str);
        }

        public static void b(MediaDrm mediaDrm, byte[] bArr, PlayerId playerId) {
            LogSessionId a2 = playerId.a();
            if (!a2.equals(LogSessionId.LOG_SESSION_ID_NONE)) {
                ((MediaDrm.PlaybackComponent) Assertions.f(mediaDrm.getPlaybackComponent(bArr))).setLogSessionId(a2);
            }
        }
    }

    private FrameworkMediaDrm(UUID uuid) throws UnsupportedSchemeException {
        Assertions.f(uuid);
        Assertions.b(!C.f3931b.equals(uuid), "Use C.CLEARKEY_UUID instead");
        this.f6240a = uuid;
        MediaDrm mediaDrm = new MediaDrm(u(uuid));
        this.f6241b = mediaDrm;
        if (C.f3933d.equals(uuid) && C()) {
            w(mediaDrm);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void A(ExoMediaDrm.OnEventListener onEventListener, MediaDrm mediaDrm, byte[] bArr, int i2, int i3, byte[] bArr2) {
        onEventListener.a(this, bArr, i2, i3, bArr2);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ ExoMediaDrm B(UUID uuid) {
        try {
            return D(uuid);
        } catch (UnsupportedDrmException unused) {
            Log.c("FrameworkMediaDrm", "Failed to instantiate a FrameworkMediaDrm for uuid: " + uuid + ".");
            return new DummyExoMediaDrm();
        }
    }

    private static boolean C() {
        return "ASUS_Z00AD".equals(Util.f4717d);
    }

    public static FrameworkMediaDrm D(UUID uuid) throws UnsupportedDrmException {
        try {
            return new FrameworkMediaDrm(uuid);
        } catch (UnsupportedSchemeException e2) {
            throw new UnsupportedDrmException(1, e2);
        } catch (Exception e3) {
            throw new UnsupportedDrmException(2, e3);
        }
    }

    private boolean E() {
        if (Util.f4714a >= 21 || !C.f3933d.equals(this.f6240a) || !"L3".equals(x("securityLevel"))) {
            return false;
        }
        return true;
    }

    private static byte[] p(byte[] bArr) {
        ParsableByteArray parsableByteArray = new ParsableByteArray(bArr);
        int u2 = parsableByteArray.u();
        short w2 = parsableByteArray.w();
        short w3 = parsableByteArray.w();
        if (w2 == 1 && w3 == 1) {
            short w4 = parsableByteArray.w();
            Charset charset = Charsets.UTF_16LE;
            String F = parsableByteArray.F(w4, charset);
            if (F.contains("<LA_URL>")) {
                return bArr;
            }
            int indexOf = F.indexOf("</DATA>");
            if (indexOf == -1) {
                Log.h("FrameworkMediaDrm", "Could not find the </DATA> tag. Skipping LA_URL workaround.");
            }
            String str = F.substring(0, indexOf) + "<LA_URL>https://x</LA_URL>" + F.substring(indexOf);
            int i2 = u2 + 52;
            ByteBuffer allocate = ByteBuffer.allocate(i2);
            allocate.order(ByteOrder.LITTLE_ENDIAN);
            allocate.putInt(i2);
            allocate.putShort((short) w2);
            allocate.putShort((short) w3);
            allocate.putShort((short) (str.length() * 2));
            allocate.put(str.getBytes(charset));
            return allocate.array();
        }
        Log.f("FrameworkMediaDrm", "Unexpected record count or type. Skipping LA_URL workaround.");
        return bArr;
    }

    private String q(String str) {
        if ("<LA_URL>https://x</LA_URL>".equals(str)) {
            return "";
        }
        if (Util.f4714a >= 33 && "https://default.url".equals(str)) {
            String x2 = x(MediationMetaData.KEY_VERSION);
            if (Objects.equals(x2, "1.2") || Objects.equals(x2, "aidl-1")) {
                return "";
            }
        }
        return str;
    }

    private static byte[] r(UUID uuid, byte[] bArr) {
        if (C.f3932c.equals(uuid)) {
            return ClearKeyUtil.a(bArr);
        }
        return bArr;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0056, code lost:
        if ("AFTT".equals(r0) == false) goto L_0x005f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static byte[] s(java.util.UUID r3, byte[] r4) {
        /*
            java.util.UUID r0 = androidx.media3.common.C.f3934e
            boolean r1 = r0.equals(r3)
            if (r1 == 0) goto L_0x0018
            byte[] r1 = androidx.media3.extractor.mp4.PsshAtomUtil.e(r4, r3)
            if (r1 != 0) goto L_0x000f
            goto L_0x0010
        L_0x000f:
            r4 = r1
        L_0x0010:
            byte[] r4 = p(r4)
            byte[] r4 = androidx.media3.extractor.mp4.PsshAtomUtil.a(r0, r4)
        L_0x0018:
            int r1 = androidx.media3.common.util.Util.f4714a
            r2 = 23
            if (r1 >= r2) goto L_0x0026
            java.util.UUID r1 = androidx.media3.common.C.f3933d
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0058
        L_0x0026:
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x005f
            java.lang.String r0 = "Amazon"
            java.lang.String r1 = androidx.media3.common.util.Util.f4716c
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x005f
            java.lang.String r0 = androidx.media3.common.util.Util.f4717d
            java.lang.String r1 = "AFTB"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L_0x0058
            java.lang.String r1 = "AFTS"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L_0x0058
            java.lang.String r1 = "AFTM"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L_0x0058
            java.lang.String r1 = "AFTT"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x005f
        L_0x0058:
            byte[] r3 = androidx.media3.extractor.mp4.PsshAtomUtil.e(r4, r3)
            if (r3 == 0) goto L_0x005f
            return r3
        L_0x005f:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.drm.FrameworkMediaDrm.s(java.util.UUID, byte[]):byte[]");
    }

    private static String t(UUID uuid, String str) {
        if (Util.f4714a >= 26 || !C.f3932c.equals(uuid) || (!"video/mp4".equals(str) && !"audio/mp4".equals(str))) {
            return str;
        }
        return "cenc";
    }

    private static UUID u(UUID uuid) {
        return (Util.f4714a >= 27 || !C.f3932c.equals(uuid)) ? uuid : C.f3931b;
    }

    private static void w(MediaDrm mediaDrm) {
        mediaDrm.setPropertyString("securityLevel", "L3");
    }

    private static DrmInitData.SchemeData y(UUID uuid, List<DrmInitData.SchemeData> list) {
        boolean z2;
        if (!C.f3933d.equals(uuid)) {
            return list.get(0);
        }
        if (Util.f4714a >= 28 && list.size() > 1) {
            DrmInitData.SchemeData schemeData = list.get(0);
            int i2 = 0;
            int i3 = 0;
            while (true) {
                if (i2 >= list.size()) {
                    z2 = true;
                    break;
                }
                DrmInitData.SchemeData schemeData2 = list.get(i2);
                byte[] bArr = (byte[]) Assertions.f(schemeData2.f3978f);
                if (!Util.c(schemeData2.f3977e, schemeData.f3977e) || !Util.c(schemeData2.f3976d, schemeData.f3976d) || !PsshAtomUtil.c(bArr)) {
                    z2 = false;
                } else {
                    i3 += bArr.length;
                    i2++;
                }
            }
            z2 = false;
            if (z2) {
                byte[] bArr2 = new byte[i3];
                int i4 = 0;
                for (int i5 = 0; i5 < list.size(); i5++) {
                    byte[] bArr3 = (byte[]) Assertions.f(list.get(i5).f3978f);
                    int length = bArr3.length;
                    System.arraycopy(bArr3, 0, bArr2, i4, length);
                    i4 += length;
                }
                return schemeData.c(bArr2);
            }
        }
        for (int i6 = 0; i6 < list.size(); i6++) {
            DrmInitData.SchemeData schemeData3 = list.get(i6);
            int g2 = PsshAtomUtil.g((byte[]) Assertions.f(schemeData3.f3978f));
            int i7 = Util.f4714a;
            if (i7 < 23 && g2 == 0) {
                return schemeData3;
            }
            if (i7 >= 23 && g2 == 1) {
                return schemeData3;
            }
        }
        return list.get(0);
    }

    private boolean z() {
        if (!this.f6240a.equals(C.f3933d)) {
            return this.f6240a.equals(C.f3932c);
        }
        String x2 = x(MediationMetaData.KEY_VERSION);
        if (x2.startsWith("v5.") || x2.startsWith("14.") || x2.startsWith("15.") || x2.startsWith("16.0")) {
            return false;
        }
        return true;
    }

    public Map<String, String> a(byte[] bArr) {
        return this.f6241b.queryKeyStatus(bArr);
    }

    public ExoMediaDrm.ProvisionRequest b() {
        MediaDrm.ProvisionRequest provisionRequest = this.f6241b.getProvisionRequest();
        return new ExoMediaDrm.ProvisionRequest(provisionRequest.getData(), provisionRequest.getDefaultUrl());
    }

    public byte[] c() throws MediaDrmException {
        return this.f6241b.openSession();
    }

    public void d(byte[] bArr, byte[] bArr2) {
        this.f6241b.restoreKeys(bArr, bArr2);
    }

    public void e(byte[] bArr) throws DeniedByServerException {
        this.f6241b.provideProvisionResponse(bArr);
    }

    public int f() {
        return 2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x002d  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0041 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean h(byte[] r5, java.lang.String r6) {
        /*
            r4 = this;
            int r0 = androidx.media3.common.util.Util.f4714a
            r1 = 31
            r2 = 1
            if (r0 < r1) goto L_0x0014
            boolean r0 = r4.z()
            if (r0 == 0) goto L_0x0014
            android.media.MediaDrm r5 = r4.f6241b
            boolean r5 = androidx.media3.exoplayer.drm.FrameworkMediaDrm.Api31.a(r5, r6)
            goto L_0x0038
        L_0x0014:
            r0 = 0
            android.media.MediaCrypto r1 = new android.media.MediaCrypto     // Catch:{ MediaCryptoException -> 0x0031, all -> 0x002a }
            java.util.UUID r3 = r4.f6240a     // Catch:{ MediaCryptoException -> 0x0031, all -> 0x002a }
            r1.<init>(r3, r5)     // Catch:{ MediaCryptoException -> 0x0031, all -> 0x002a }
            boolean r5 = r1.requiresSecureDecoderComponent(r6)     // Catch:{ MediaCryptoException -> 0x0027, all -> 0x0024 }
            r1.release()
            goto L_0x0038
        L_0x0024:
            r5 = move-exception
            r0 = r1
            goto L_0x002b
        L_0x0027:
            r0 = r1
            goto L_0x0032
        L_0x002a:
            r5 = move-exception
        L_0x002b:
            if (r0 == 0) goto L_0x0030
            r0.release()
        L_0x0030:
            throw r5
        L_0x0031:
        L_0x0032:
            if (r0 == 0) goto L_0x0037
            r0.release()
        L_0x0037:
            r5 = 1
        L_0x0038:
            if (r5 == 0) goto L_0x0041
            boolean r5 = r4.E()
            if (r5 != 0) goto L_0x0041
            goto L_0x0042
        L_0x0041:
            r2 = 0
        L_0x0042:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.drm.FrameworkMediaDrm.h(byte[], java.lang.String):boolean");
    }

    public void i(byte[] bArr) {
        this.f6241b.closeSession(bArr);
    }

    public byte[] j(byte[] bArr, byte[] bArr2) throws NotProvisionedException, DeniedByServerException {
        if (C.f3932c.equals(this.f6240a)) {
            bArr2 = ClearKeyUtil.b(bArr2);
        }
        return this.f6241b.provideKeyResponse(bArr, bArr2);
    }

    @SuppressLint({"WrongConstant"})
    public ExoMediaDrm.KeyRequest k(byte[] bArr, List<DrmInitData.SchemeData> list, int i2, HashMap<String, String> hashMap) throws NotProvisionedException {
        DrmInitData.SchemeData schemeData;
        String str;
        byte[] bArr2;
        int i3;
        if (list != null) {
            schemeData = y(this.f6240a, list);
            bArr2 = s(this.f6240a, (byte[]) Assertions.f(schemeData.f3978f));
            str = t(this.f6240a, schemeData.f3977e);
        } else {
            schemeData = null;
            bArr2 = null;
            str = null;
        }
        MediaDrm.KeyRequest keyRequest = this.f6241b.getKeyRequest(bArr, bArr2, str, i2, hashMap);
        byte[] r2 = r(this.f6240a, keyRequest.getData());
        String q2 = q(keyRequest.getDefaultUrl());
        if (TextUtils.isEmpty(q2) && schemeData != null && !TextUtils.isEmpty(schemeData.f3976d)) {
            q2 = schemeData.f3976d;
        }
        if (Util.f4714a >= 23) {
            i3 = keyRequest.getRequestType();
        } else {
            i3 = Integer.MIN_VALUE;
        }
        return new ExoMediaDrm.KeyRequest(r2, q2, i3);
    }

    public void l(ExoMediaDrm.OnEventListener onEventListener) {
        w wVar;
        MediaDrm mediaDrm = this.f6241b;
        if (onEventListener == null) {
            wVar = null;
        } else {
            wVar = new w(this, onEventListener);
        }
        mediaDrm.setOnEventListener(wVar);
    }

    public void m(byte[] bArr, PlayerId playerId) {
        if (Util.f4714a >= 31) {
            try {
                Api31.b(this.f6241b, bArr, playerId);
            } catch (UnsupportedOperationException unused) {
                Log.h("FrameworkMediaDrm", "setLogSessionId failed.");
            }
        }
    }

    public synchronized void release() {
        int i2 = this.f6242c - 1;
        this.f6242c = i2;
        if (i2 == 0) {
            this.f6241b.release();
        }
    }

    /* renamed from: v */
    public FrameworkCryptoConfig g(byte[] bArr) throws MediaCryptoException {
        return new FrameworkCryptoConfig(u(this.f6240a), bArr, E());
    }

    public String x(String str) {
        return this.f6241b.getPropertyString(str);
    }
}
