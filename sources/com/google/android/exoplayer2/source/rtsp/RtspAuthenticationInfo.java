package com.google.android.exoplayer2.source.rtsp;

import android.net.Uri;
import android.util.Base64;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.source.rtsp.RtspMessageUtil;
import com.google.android.exoplayer2.util.Util;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

final class RtspAuthenticationInfo {

    /* renamed from: a  reason: collision with root package name */
    public final int f26790a;

    /* renamed from: b  reason: collision with root package name */
    public final String f26791b;

    /* renamed from: c  reason: collision with root package name */
    public final String f26792c;

    /* renamed from: d  reason: collision with root package name */
    public final String f26793d;

    public RtspAuthenticationInfo(int i2, String str, String str2, String str3) {
        this.f26790a = i2;
        this.f26791b = str;
        this.f26792c = str2;
        this.f26793d = str3;
    }

    private String b(RtspMessageUtil.RtspAuthUserInfo rtspAuthUserInfo) {
        return Util.C("Basic %s", Base64.encodeToString(RtspMessageUtil.d(rtspAuthUserInfo.f26907a + ":" + rtspAuthUserInfo.f26908b), 0));
    }

    private String c(RtspMessageUtil.RtspAuthUserInfo rtspAuthUserInfo, Uri uri, int i2) throws ParserException {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            String t2 = RtspMessageUtil.t(i2);
            String d12 = Util.d1(instance.digest(RtspMessageUtil.d(rtspAuthUserInfo.f26907a + ":" + this.f26791b + ":" + rtspAuthUserInfo.f26908b)));
            StringBuilder sb = new StringBuilder();
            sb.append(t2);
            sb.append(":");
            sb.append(uri);
            String d13 = Util.d1(instance.digest(RtspMessageUtil.d(sb.toString())));
            String d14 = Util.d1(instance.digest(RtspMessageUtil.d(d12 + ":" + this.f26792c + ":" + d13)));
            if (this.f26793d.isEmpty()) {
                return Util.C("Digest username=\"%s\", realm=\"%s\", nonce=\"%s\", uri=\"%s\", response=\"%s\"", rtspAuthUserInfo.f26907a, this.f26791b, this.f26792c, uri, d14);
            }
            return Util.C("Digest username=\"%s\", realm=\"%s\", nonce=\"%s\", uri=\"%s\", response=\"%s\", opaque=\"%s\"", rtspAuthUserInfo.f26907a, this.f26791b, this.f26792c, uri, d14, this.f26793d);
        } catch (NoSuchAlgorithmException e2) {
            throw ParserException.d((String) null, e2);
        }
    }

    public String a(RtspMessageUtil.RtspAuthUserInfo rtspAuthUserInfo, Uri uri, int i2) throws ParserException {
        int i3 = this.f26790a;
        if (i3 == 1) {
            return b(rtspAuthUserInfo);
        }
        if (i3 == 2) {
            return c(rtspAuthUserInfo, uri, i2);
        }
        throw ParserException.d((String) null, new UnsupportedOperationException());
    }
}
