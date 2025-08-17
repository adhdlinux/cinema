package com.chartboost.sdk.impl;

import android.net.Uri;
import com.chartboost.sdk.impl.f3;
import com.chartboost.sdk.impl.id;
import com.chartboost.sdk.internal.Model.CBError;
import com.chartboost.sdk.internal.video.repository.exoplayer.VideoRepositoryDownloadService;
import com.facebook.common.util.UriUtil;
import com.google.android.exoplayer2.database.DatabaseProvider;
import com.google.android.exoplayer2.offline.Download;
import com.google.android.exoplayer2.offline.DownloadManager;
import com.google.android.exoplayer2.offline.DownloadRequest;
import com.google.android.exoplayer2.offline.DownloadService;
import com.google.android.exoplayer2.offline.e;
import com.google.android.exoplayer2.scheduler.Requirements;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.cache.Cache;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

public final class j5 implements h5, DownloadManager.Listener, f3.b {

    /* renamed from: a  reason: collision with root package name */
    public final i5 f17973a;

    /* renamed from: b  reason: collision with root package name */
    public DownloadManager f17974b;

    /* renamed from: c  reason: collision with root package name */
    public DataSource.Factory f17975c;

    /* renamed from: d  reason: collision with root package name */
    public m5 f17976d;

    /* renamed from: e  reason: collision with root package name */
    public u5 f17977e;

    /* renamed from: f  reason: collision with root package name */
    public volatile List f17978f;

    /* renamed from: g  reason: collision with root package name */
    public volatile Map f17979g;

    public static final class a extends Lambda implements Function1 {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ q4 f17980b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(q4 q4Var) {
            super(1);
            this.f17980b = q4Var;
        }

        public final void a(id.a aVar) {
            Intrinsics.f(aVar, "$this$forEachListener");
            aVar.a(this.f17980b.f(), this.f17980b.b());
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((id.a) obj);
            return Unit.f40298a;
        }
    }

    public static final class b extends Lambda implements Function1 {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ q4 f17981b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CBError f17982c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(q4 q4Var, CBError cBError) {
            super(1);
            this.f17981b = q4Var;
            this.f17982c = cBError;
        }

        public final void a(id.a aVar) {
            Intrinsics.f(aVar, "$this$forEachListener");
            aVar.a(this.f17981b.f(), this.f17981b.b(), this.f17982c);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((id.a) obj);
            return Unit.f40298a;
        }
    }

    public static final class c extends Lambda implements Function1 {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ q4 f17983b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(q4 q4Var) {
            super(1);
            this.f17983b = q4Var;
        }

        public final void a(id.a aVar) {
            Intrinsics.f(aVar, "$this$forEachListener");
            aVar.a(this.f17983b.f(), this.f17983b.b(), 0, (n0) null);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((id.a) obj);
            return Unit.f40298a;
        }
    }

    public j5(i5 i5Var) {
        Intrinsics.f(i5Var, "dependencies");
        this.f17973a = i5Var;
        this.f17978f = CollectionsKt__CollectionsKt.f();
        this.f17979g = MapsKt__MapsKt.g();
    }

    public void a(id.a aVar) {
        Intrinsics.f(aVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.f17978f = CollectionsKt___CollectionsKt.O(this.f17978f, aVar);
    }

    public void b() {
        a(nc.a(d()));
    }

    public final void c(rc rcVar) {
        for (q4 q4Var : nc.a(d())) {
            if (!Intrinsics.a(q4Var.b(), rcVar.d())) {
                a(q4Var, p4.FORCED_OUT);
            }
        }
    }

    public DownloadManager d() {
        if (this.f17974b == null) {
            DatabaseProvider databaseProvider = (DatabaseProvider) this.f17973a.d().invoke(this.f17973a.c());
            this.f17976d = (m5) this.f17973a.g().invoke(this.f17973a.c());
            Function4 b2 = this.f17973a.b();
            m5 m5Var = this.f17976d;
            if (m5Var == null) {
                Intrinsics.x("fileCaching");
                m5Var = null;
            }
            Cache cache = (Cache) b2.invoke(m5Var, this.f17973a.j(), databaseProvider, this);
            this.f17975c = (DataSource.Factory) this.f17973a.a().invoke(cache, this.f17973a.h());
            Function1 f2 = this.f17973a.f();
            m5 m5Var2 = this.f17976d;
            if (m5Var2 == null) {
                Intrinsics.x("fileCaching");
                m5Var2 = null;
            }
            this.f17977e = (u5) f2.invoke(m5Var2);
            this.f17974b = (DownloadManager) this.f17973a.e().invoke(this.f17973a.c(), databaseProvider, cache, this.f17973a.h(), this);
        }
        DownloadManager downloadManager = this.f17974b;
        if (downloadManager != null) {
            return downloadManager;
        }
        Intrinsics.x("downloadManager");
        return null;
    }

    public final void e(q4 q4Var) {
        try {
            DownloadService.sendRemoveDownload(this.f17973a.c(), VideoRepositoryDownloadService.class, q4Var.b(), false);
            u5 u5Var = this.f17977e;
            if (u5Var == null) {
                Intrinsics.x("fakePrecacheFilesManager");
                u5Var = null;
            }
            u5Var.d(q4Var);
        } catch (Exception e2) {
            String a2 = k5.f18027a;
            Intrinsics.e(a2, "TAG");
            w7.a(a2, "Error sending remove download", e2);
        }
    }

    public void onDownloadChanged(DownloadManager downloadManager, Download download, Exception exc) {
        Intrinsics.f(downloadManager, "downloadManager");
        Intrinsics.f(download, "download");
        String a2 = k5.f18027a;
        Intrinsics.e(a2, "TAG");
        w7.a(a2, "onDownloadChanged() - state " + r4.a(download.f25520b) + ", finalException " + exc);
        int i2 = download.f25520b;
        if (i2 == 0 || i2 == 1) {
            u5 u5Var = this.f17977e;
            if (u5Var == null) {
                Intrinsics.x("fakePrecacheFilesManager");
                u5Var = null;
            }
            u5Var.c(r4.a(download));
        } else if (i2 == 2) {
            c(r4.a(download));
        } else if (i2 == 3) {
            b(r4.a(download));
        } else if (i2 == 4) {
            a(r4.a(download), exc);
        } else if (i2 == 5) {
            d(r4.a(download));
        }
    }

    public /* bridge */ /* synthetic */ void onDownloadRemoved(DownloadManager downloadManager, Download download) {
        e.a(this, downloadManager, download);
    }

    public /* bridge */ /* synthetic */ void onDownloadsPausedChanged(DownloadManager downloadManager, boolean z2) {
        e.b(this, downloadManager, z2);
    }

    public /* bridge */ /* synthetic */ void onIdle(DownloadManager downloadManager) {
        e.c(this, downloadManager);
    }

    public /* bridge */ /* synthetic */ void onInitialized(DownloadManager downloadManager) {
        e.d(this, downloadManager);
    }

    public /* bridge */ /* synthetic */ void onRequirementsStateChanged(DownloadManager downloadManager, Requirements requirements, int i2) {
        e.e(this, downloadManager, requirements, i2);
    }

    public /* bridge */ /* synthetic */ void onWaitingForRequirementsChanged(DownloadManager downloadManager, boolean z2) {
        e.f(this, downloadManager, z2);
    }

    public final void a(int i2, String str, Function1 function1) {
        for (id.a aVar : this.f17978f) {
            Integer num = (Integer) this.f17979g.get(str);
            if (num == null || num.intValue() != i2) {
                this.f17979g = MapsKt__MapsKt.p(this.f17979g, TuplesKt.a(str, Integer.valueOf(i2)));
                function1.invoke(aVar);
            }
        }
    }

    public final void b(rc rcVar) {
        this.f17979g = MapsKt__MapsKt.k(this.f17979g, rcVar.g());
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ j5(com.chartboost.sdk.impl.i5 r15, int r16, kotlin.jvm.internal.DefaultConstructorMarker r17) {
        /*
            r14 = this;
            r0 = r16 & 1
            if (r0 == 0) goto L_0x0019
            com.chartboost.sdk.impl.i5 r0 = new com.chartboost.sdk.impl.i5
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 1023(0x3ff, float:1.434E-42)
            r13 = 0
            r1 = r0
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            r1 = r14
            goto L_0x001b
        L_0x0019:
            r1 = r14
            r0 = r15
        L_0x001b:
            r14.<init>(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.impl.j5.<init>(com.chartboost.sdk.impl.i5, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public q4 b(String str) {
        Intrinsics.f(str, "id");
        return nc.a(d(), str);
    }

    public DataSource.Factory c() {
        DataSource.Factory factory = this.f17975c;
        if (factory != null) {
            return factory;
        }
        Intrinsics.x("cacheDataSourceFactory");
        return null;
    }

    public final void b(q4 q4Var) {
        String a2 = k5.f18027a;
        Intrinsics.e(a2, "TAG");
        w7.a(a2, "notifyDownloadCompleted() - download " + q4Var + ", listeners: " + this.f17978f);
        StringBuilder sb = new StringBuilder();
        sb.append("Video downloaded success ");
        sb.append(q4Var.f());
        la.a(sb.toString());
        a(3, q4Var.f(), new a(q4Var));
    }

    public final void c(q4 q4Var) {
        String a2 = k5.f18027a;
        Intrinsics.e(a2, "TAG");
        w7.a(a2, "notifyTempFileIsReady() - download " + q4Var + ", listeners: " + this.f17978f);
        StringBuilder sb = new StringBuilder();
        sb.append("Start downloading ");
        sb.append(q4Var.f());
        la.a(sb.toString());
        u5 u5Var = this.f17977e;
        if (u5Var == null) {
            Intrinsics.x("fakePrecacheFilesManager");
            u5Var = null;
        }
        u5Var.e(q4Var);
        a(2, q4Var.f(), new c(q4Var));
    }

    public synchronized void a() {
        String a2 = k5.f18027a;
        Intrinsics.e(a2, "TAG");
        w7.a(a2, "initialize()");
        this.f17973a.i().invoke();
        d();
    }

    public final void b(rc rcVar, p4 p4Var) {
        String a2 = k5.f18027a;
        Intrinsics.e(a2, "TAG");
        w7.a(a2, "VideoAsset.addDownload() - videoAsset " + rcVar + ", stopReason " + p4Var);
        if (!StringsKt__StringsJVMKt.v(rcVar.g())) {
            try {
                DownloadService.sendAddDownload(this.f17973a.c(), VideoRepositoryDownloadService.class, new DownloadRequest.Builder(rcVar.d(), Uri.parse(rcVar.g())).a(), p4Var.b(), false);
            } catch (Exception e2) {
                String a3 = k5.f18027a;
                Intrinsics.e(a3, "TAG");
                w7.a(a3, "Error sending add download", e2);
            }
        }
    }

    public boolean a(String str) {
        Intrinsics.f(str, "id");
        q4 b2 = b(str);
        return b2 != null && (b2.d() == 3 || b2.d() == 2);
    }

    public void c(String str) {
        Object obj;
        Intrinsics.f(str, ImagesContract.URL);
        Iterator it2 = nc.a(d()).iterator();
        while (true) {
            if (!it2.hasNext()) {
                obj = null;
                break;
            }
            obj = it2.next();
            if (Intrinsics.a(((q4) obj).f(), str)) {
                break;
            }
        }
        q4 q4Var = (q4) obj;
        if (q4Var != null) {
            e(q4Var);
        }
    }

    public void a(rc rcVar, p4 p4Var) {
        Intrinsics.f(rcVar, UriUtil.LOCAL_ASSET_SCHEME);
        Intrinsics.f(p4Var, "stopReason");
        String a2 = k5.f18027a;
        Intrinsics.e(a2, "TAG");
        w7.a(a2, "addDownload() - asset: " + rcVar + ", stopReason " + p4Var);
        b(rcVar, p4Var);
    }

    public void a(rc rcVar) {
        Intrinsics.f(rcVar, UriUtil.LOCAL_ASSET_SCHEME);
        String a2 = k5.f18027a;
        Intrinsics.e(a2, "TAG");
        w7.a(a2, "startDownload() - asset: " + rcVar);
        b(rcVar);
        c(rcVar);
        a(this, rcVar, (p4) null, 1, (Object) null);
    }

    public float d(String str) {
        Intrinsics.f(str, "id");
        q4 b2 = b(str);
        return (b2 != null ? b2.c() : 0.0f) / 100.0f;
    }

    public void a(p4 p4Var) {
        q4 a2;
        Intrinsics.f(p4Var, "currentDownloadStopReason");
        List<Download> e2 = d().e();
        Intrinsics.e(e2, "getDownloadManager().currentDownloads");
        Download download = (Download) CollectionsKt___CollectionsKt.D(e2);
        if (download != null && (a2 = r4.a(download)) != null) {
            a(a2, p4Var);
        }
    }

    public final void d(q4 q4Var) {
        String a2 = k5.f18027a;
        Intrinsics.e(a2, "TAG");
        w7.a(a2, "downloadRemoved() - download " + q4Var + ", listeners: " + this.f17978f);
        u5 u5Var = this.f17977e;
        if (u5Var == null) {
            Intrinsics.x("fakePrecacheFilesManager");
            u5Var = null;
        }
        u5Var.d(q4Var);
        this.f17979g = MapsKt__MapsKt.k(this.f17979g, q4Var.f());
    }

    public final void b(List list) {
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            e((q4) it2.next());
        }
    }

    public final void a(q4 q4Var, Exception exc) {
        CBError a2 = a(exc);
        la.a("Video downloaded failed " + q4Var.f() + " with error " + a2.getErrorDesc());
        a(4, q4Var.f(), new b(q4Var, a2));
    }

    public final CBError a(Exception exc) {
        if (exc instanceof IOException) {
            return new CBError(CBError.a.NETWORK_FAILURE, e5.a(exc));
        }
        return new CBError(CBError.a.MISCELLANEOUS, e5.a(exc));
    }

    public final void a(q4 q4Var, p4 p4Var) {
        String a2 = k5.f18027a;
        Intrinsics.e(a2, "TAG");
        w7.a(a2, "Download.sendStopReason() - download " + q4Var + ", stopReason " + p4Var);
        try {
            DownloadService.sendSetStopReason(this.f17973a.c(), VideoRepositoryDownloadService.class, q4Var.b(), p4Var.b(), false);
        } catch (Exception e2) {
            String a3 = k5.f18027a;
            Intrinsics.e(a3, "TAG");
            w7.a(a3, "Error sending stop reason", e2);
        }
    }

    public static /* synthetic */ void a(j5 j5Var, rc rcVar, p4 p4Var, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            p4Var = p4.NONE;
        }
        j5Var.b(rcVar, p4Var);
    }

    public final boolean a(q4 q4Var) {
        return this.f17973a.j().a(q4Var.e());
    }

    public final List a(List list) {
        ArrayList arrayList = new ArrayList();
        for (Object next : list) {
            if (a((q4) next)) {
                arrayList.add(next);
            }
        }
        b((List) arrayList);
        return list;
    }
}
