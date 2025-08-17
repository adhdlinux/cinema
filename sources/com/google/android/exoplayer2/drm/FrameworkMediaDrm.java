package com.google.android.exoplayer2.drm;

import android.annotation.SuppressLint;
import android.media.DeniedByServerException;
import android.media.MediaCrypto;
import android.media.MediaCryptoException;
import android.media.MediaDrm;
import android.media.MediaDrmException;
import android.media.NotProvisionedException;
import android.media.UnsupportedSchemeException;
import android.media.metrics.LogSessionId;
import android.text.TextUtils;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.analytics.PlayerId;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.ExoMediaDrm;
import com.google.android.exoplayer2.extractor.mp4.PsshAtomUtil;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import com.google.common.base.Charsets;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public final class FrameworkMediaDrm implements ExoMediaDrm {

    /* renamed from: d  reason: collision with root package name */
    public static final ExoMediaDrm.Provider f24103d = new u();

    /* renamed from: a  reason: collision with root package name */
    private final UUID f24104a;

    /* renamed from: b  reason: collision with root package name */
    private final MediaDrm f24105b;

    /* renamed from: c  reason: collision with root package name */
    private int f24106c = 1;

    private static class Api31 {
        private Api31() {
        }

        public static boolean a(MediaDrm mediaDrm, String str) {
            return mediaDrm.requiresSecureDecoder(str);
        }

        public static void b(MediaDrm mediaDrm, byte[] bArr, PlayerId playerId) {
            LogSessionId a2 = playerId.a();
            if (!a2.equals(LogSessionId.LOG_SESSION_ID_NONE)) {
                ((MediaDrm.PlaybackComponent) Assertions.e(mediaDrm.getPlaybackComponent(bArr))).setLogSessionId(a2);
            }
        }
    }

    private FrameworkMediaDrm(UUID uuid) throws UnsupportedSchemeException {
        Assertions.e(uuid);
        Assertions.b(!C.f22817b.equals(uuid), "Use C.CLEARKEY_UUID instead");
        this.f24104a = uuid;
        MediaDrm mediaDrm = new MediaDrm(u(uuid));
        this.f24105b = mediaDrm;
        if (C.f22819d.equals(uuid) && B()) {
            w(mediaDrm);
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ ExoMediaDrm A(UUID uuid) {
        try {
            return C(uuid);
        } catch (UnsupportedDrmException unused) {
            Log.c("FrameworkMediaDrm", "Failed to instantiate a FrameworkMediaDrm for uuid: " + uuid + ".");
            return new DummyExoMediaDrm();
        }
    }

    private static boolean B() {
        return "ASUS_Z00AD".equals(Util.f28811d);
    }

    public static FrameworkMediaDrm C(UUID uuid) throws UnsupportedDrmException {
        try {
            return new FrameworkMediaDrm(uuid);
        } catch (UnsupportedSchemeException e2) {
            throw new UnsupportedDrmException(1, e2);
        } catch (Exception e3) {
            throw new UnsupportedDrmException(2, e3);
        }
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
                Log.i("FrameworkMediaDrm", "Could not find the </DATA> tag. Skipping LA_URL workaround.");
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

    private static String q(String str) {
        if ("<LA_URL>https://x</LA_URL>".equals(str)) {
            return "";
        }
        if (Util.f28808a != 33 || !"https://default.url".equals(str)) {
            return str;
        }
        return "";
    }

    private static byte[] r(UUID uuid, byte[] bArr) {
        if (C.f22818c.equals(uuid)) {
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
            java.util.UUID r0 = com.google.android.exoplayer2.C.f22820e
            boolean r1 = r0.equals(r3)
            if (r1 == 0) goto L_0x0018
            byte[] r1 = com.google.android.exoplayer2.extractor.mp4.PsshAtomUtil.e(r4, r3)
            if (r1 != 0) goto L_0x000f
            goto L_0x0010
        L_0x000f:
            r4 = r1
        L_0x0010:
            byte[] r4 = p(r4)
            byte[] r4 = com.google.android.exoplayer2.extractor.mp4.PsshAtomUtil.a(r0, r4)
        L_0x0018:
            int r1 = com.google.android.exoplayer2.util.Util.f28808a
            r2 = 23
            if (r1 >= r2) goto L_0x0026
            java.util.UUID r1 = com.google.android.exoplayer2.C.f22819d
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0058
        L_0x0026:
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x005f
            java.lang.String r0 = "Amazon"
            java.lang.String r1 = com.google.android.exoplayer2.util.Util.f28810c
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x005f
            java.lang.String r0 = com.google.android.exoplayer2.util.Util.f28811d
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
            byte[] r3 = com.google.android.exoplayer2.extractor.mp4.PsshAtomUtil.e(r4, r3)
            if (r3 == 0) goto L_0x005f
            return r3
        L_0x005f:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.drm.FrameworkMediaDrm.s(java.util.UUID, byte[]):byte[]");
    }

    private static String t(UUID uuid, String str) {
        if (Util.f28808a >= 26 || !C.f22818c.equals(uuid) || (!"video/mp4".equals(str) && !"audio/mp4".equals(str))) {
            return str;
        }
        return "cenc";
    }

    private static UUID u(UUID uuid) {
        return (Util.f28808a >= 27 || !C.f22818c.equals(uuid)) ? uuid : C.f22817b;
    }

    private static void w(MediaDrm mediaDrm) {
        mediaDrm.setPropertyString("securityLevel", "L3");
    }

    private static DrmInitData.SchemeData y(UUID uuid, List<DrmInitData.SchemeData> list) {
        boolean z2;
        if (!C.f22819d.equals(uuid)) {
            return list.get(0);
        }
        if (Util.f28808a >= 28 && list.size() > 1) {
            DrmInitData.SchemeData schemeData = list.get(0);
            int i2 = 0;
            int i3 = 0;
            while (true) {
                if (i2 >= list.size()) {
                    z2 = true;
                    break;
                }
                DrmInitData.SchemeData schemeData2 = list.get(i2);
                byte[] bArr = (byte[]) Assertions.e(schemeData2.f24083f);
                if (!Util.c(schemeData2.f24082e, schemeData.f24082e) || !Util.c(schemeData2.f24081d, schemeData.f24081d) || !PsshAtomUtil.c(bArr)) {
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
                    byte[] bArr3 = (byte[]) Assertions.e(list.get(i5).f24083f);
                    int length = bArr3.length;
                    System.arraycopy(bArr3, 0, bArr2, i4, length);
                    i4 += length;
                }
                return schemeData.c(bArr2);
            }
        }
        for (int i6 = 0; i6 < list.size(); i6++) {
            DrmInitData.SchemeData schemeData3 = list.get(i6);
            int g2 = PsshAtomUtil.g((byte[]) Assertions.e(schemeData3.f24083f));
            int i7 = Util.f28808a;
            if (i7 < 23 && g2 == 0) {
                return schemeData3;
            }
            if (i7 >= 23 && g2 == 1) {
                return schemeData3;
            }
        }
        return list.get(0);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void z(ExoMediaDrm.OnEventListener onEventListener, MediaDrm mediaDrm, byte[] bArr, int i2, int i3, byte[] bArr2) {
        onEventListener.a(this, bArr, i2, i3, bArr2);
    }

    public Map<String, String> a(byte[] bArr) {
        return this.f24105b.queryKeyStatus(bArr);
    }

    public ExoMediaDrm.ProvisionRequest b() {
        MediaDrm.ProvisionRequest provisionRequest = this.f24105b.getProvisionRequest();
        return new ExoMediaDrm.ProvisionRequest(provisionRequest.getData(), provisionRequest.getDefaultUrl());
    }

    public byte[] c() throws MediaDrmException {
        return this.f24105b.openSession();
    }

    public void d(byte[] bArr, byte[] bArr2) {
        this.f24105b.restoreKeys(bArr, bArr2);
    }

    public void e(byte[] bArr) throws DeniedByServerException {
        this.f24105b.provideProvisionResponse(bArr);
    }

    public int f() {
        return 2;
    }

    public boolean h(byte[] bArr, String str) {
        if (Util.f28808a >= 31) {
            return Api31.a(this.f24105b, str);
        }
        try {
            MediaCrypto mediaCrypto = new MediaCrypto(this.f24104a, bArr);
            try {
                return mediaCrypto.requiresSecureDecoderComponent(str);
            } finally {
                mediaCrypto.release();
            }
        } catch (MediaCryptoException unused) {
            return true;
        }
    }

    public void i(byte[] bArr) {
        this.f24105b.closeSession(bArr);
    }

    public byte[] j(byte[] bArr, byte[] bArr2) throws NotProvisionedException, DeniedByServerException {
        if (C.f22818c.equals(this.f24104a)) {
            bArr2 = ClearKeyUtil.b(bArr2);
        }
        return this.f24105b.provideKeyResponse(bArr, bArr2);
    }

    @SuppressLint({"WrongConstant"})
    public ExoMediaDrm.KeyRequest k(byte[] bArr, List<DrmInitData.SchemeData> list, int i2, HashMap<String, String> hashMap) throws NotProvisionedException {
        DrmInitData.SchemeData schemeData;
        String str;
        byte[] bArr2;
        int i3;
        if (list != null) {
            schemeData = y(this.f24104a, list);
            bArr2 = s(this.f24104a, (byte[]) Assertions.e(schemeData.f24083f));
            str = t(this.f24104a, schemeData.f24082e);
        } else {
            schemeData = null;
            bArr2 = null;
            str = null;
        }
        MediaDrm.KeyRequest keyRequest = this.f24105b.getKeyRequest(bArr, bArr2, str, i2, hashMap);
        byte[] r2 = r(this.f24104a, keyRequest.getData());
        String q2 = q(keyRequest.getDefaultUrl());
        if (TextUtils.isEmpty(q2) && schemeData != null && !TextUtils.isEmpty(schemeData.f24081d)) {
            q2 = schemeData.f24081d;
        }
        if (Util.f28808a >= 23) {
            i3 = keyRequest.getRequestType();
        } else {
            i3 = Integer.MIN_VALUE;
        }
        return new ExoMediaDrm.KeyRequest(r2, q2, i3);
    }

    public void l(byte[] bArr, PlayerId playerId) {
        if (Util.f28808a >= 31) {
            try {
                Api31.b(this.f24105b, bArr, playerId);
            } catch (UnsupportedOperationException unused) {
                Log.i("FrameworkMediaDrm", "setLogSessionId failed.");
            }
        }
    }

    public void m(ExoMediaDrm.OnEventListener onEventListener) {
        v vVar;
        MediaDrm mediaDrm = this.f24105b;
        if (onEventListener == null) {
            vVar = null;
        } else {
            vVar = new v(this, onEventListener);
        }
        mediaDrm.setOnEventListener(vVar);
    }

    public synchronized void release() {
        int i2 = this.f24106c - 1;
        this.f24106c = i2;
        if (i2 == 0) {
            this.f24105b.release();
        }
    }

    /* renamed from: v */
    public FrameworkCryptoConfig g(byte[] bArr) throws MediaCryptoException {
        boolean z2;
        if (Util.f28808a >= 21 || !C.f22819d.equals(this.f24104a) || !"L3".equals(x("securityLevel"))) {
            z2 = false;
        } else {
            z2 = true;
        }
        return new FrameworkCryptoConfig(u(this.f24104a), bArr, z2);
    }

    public String x(String str) {
        return this.f24105b.getPropertyString(str);
    }
}
