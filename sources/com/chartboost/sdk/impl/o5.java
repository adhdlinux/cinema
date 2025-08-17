package com.chartboost.sdk.impl;

import com.facebook.common.util.UriUtil;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.offline.Download;
import com.google.android.exoplayer2.offline.DownloadRequest;
import kotlin.jvm.internal.Intrinsics;

public final class o5 {

    /* renamed from: a  reason: collision with root package name */
    public final h5 f18289a;

    public o5(h5 h5Var) {
        Intrinsics.f(h5Var, "downloadManager");
        this.f18289a = h5Var;
    }

    public final MediaItem a(rc rcVar) {
        Download a2;
        DownloadRequest downloadRequest;
        Intrinsics.f(rcVar, UriUtil.LOCAL_ASSET_SCHEME);
        q4 b2 = this.f18289a.b(rcVar.d());
        if (b2 == null || (a2 = b2.a()) == null || (downloadRequest = a2.f25519a) == null) {
            return null;
        }
        return downloadRequest.c();
    }
}
