package com.vungle.ads.internal.load;

import com.vungle.ads.internal.model.AdPayload;
import java.io.File;

public final /* synthetic */ class h implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ File f37883b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ File f37884c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ AdPayload f37885d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ File f37886e;

    public /* synthetic */ h(File file, File file2, AdPayload adPayload, File file3) {
        this.f37883b = file;
        this.f37884c = file2;
        this.f37885d = adPayload;
        this.f37886e = file3;
    }

    public final void run() {
        MraidJsLoader$downloadJs$1$2.m186onSuccess$lambda1(this.f37883b, this.f37884c, this.f37885d, this.f37886e);
    }
}
