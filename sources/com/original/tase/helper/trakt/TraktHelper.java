package com.original.tase.helper.trakt;

import com.movie.data.api.trakt.TraktV2Cachced;
import com.original.tase.model.trakt.TraktCredentialsInfo;
import com.uwetrottmann.trakt5.TraktV2;
import io.michaelrocks.paranoid.Deobfuscator$app$ProductionRelease;

public class TraktHelper {

    /* renamed from: a  reason: collision with root package name */
    public static String f34019a = Deobfuscator$app$ProductionRelease.a(-278034421330116L);

    /* renamed from: b  reason: collision with root package name */
    public static String f34020b = Deobfuscator$app$ProductionRelease.a(-277755248455876L);

    /* renamed from: c  reason: collision with root package name */
    public static String f34021c = Deobfuscator$app$ProductionRelease.a(-276376563953860L);

    /* renamed from: d  reason: collision with root package name */
    private static TraktV2 f34022d = null;

    public static TraktV2 a() {
        if (f34022d == null) {
            f34022d = new TraktV2Cachced(f34019a, f34020b, f34021c);
        }
        TraktCredentialsInfo b2 = TraktCredentialsHelper.b();
        if (b2.isValid()) {
            f34022d.accessToken(b2.getAccessToken()).refreshToken(b2.getRefreshToken());
        }
        return f34022d;
    }
}
