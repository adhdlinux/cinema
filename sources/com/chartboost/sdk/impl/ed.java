package com.chartboost.sdk.impl;

import android.content.Context;
import android.util.Log;
import com.chartboost.sdk.impl.dd;
import com.chartboost.sdk.impl.id;
import com.chartboost.sdk.internal.Model.CBError;
import com.google.android.gms.common.internal.ImagesContract;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

public final class ed implements dd, id.a {

    /* renamed from: a  reason: collision with root package name */
    public final vc f17651a;

    /* renamed from: b  reason: collision with root package name */
    public final h5 f17652b;

    /* renamed from: c  reason: collision with root package name */
    public final Function1 f17653c;

    /* renamed from: d  reason: collision with root package name */
    public final CoroutineDispatcher f17654d;

    /* renamed from: e  reason: collision with root package name */
    public final Lazy f17655e;

    /* renamed from: f  reason: collision with root package name */
    public final Lazy f17656f;

    /* renamed from: g  reason: collision with root package name */
    public m5 f17657g;

    /* renamed from: h  reason: collision with root package name */
    public Job f17658h;

    public static final class a extends Lambda implements Function1 {

        /* renamed from: b  reason: collision with root package name */
        public static final a f17659b = new a();

        public a() {
            super(1);
        }

        /* renamed from: a */
        public final n5 invoke(Context context) {
            Intrinsics.f(context, "c");
            return new n5(context, (File) null, (File) null, (File) null, 14, (DefaultConstructorMarker) null);
        }
    }

    public static final class b extends Lambda implements Function0 {

        /* renamed from: b  reason: collision with root package name */
        public static final b f17660b = new b();

        public b() {
            super(0);
        }

        /* renamed from: a */
        public final ConcurrentHashMap invoke() {
            return new ConcurrentHashMap();
        }
    }

    public static final class c extends SuspendLambda implements Function2 {

        /* renamed from: b  reason: collision with root package name */
        public int f17661b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ ed f17662c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(ed edVar, Continuation continuation) {
            super(2, continuation);
            this.f17662c = edVar;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((c) create(coroutineScope, continuation)).invokeSuspend(Unit.f40298a);
        }

        public final Continuation create(Object obj, Continuation continuation) {
            return new c(this.f17662c, continuation);
        }

        public final Object invokeSuspend(Object obj) {
            Object e2 = IntrinsicsKt__IntrinsicsKt.e();
            int i2 = this.f17661b;
            if (i2 == 0) {
                ResultKt.b(obj);
                long i3 = this.f17662c.f17651a.i();
                this.f17661b = 1;
                if (DelayKt.a(i3, this) == e2) {
                    return e2;
                }
            } else if (i2 == 1) {
                ResultKt.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            this.f17662c.f17658h = null;
            try {
                dd.a.a(this.f17662c, (String) null, 0, false, 7, (Object) null);
            } catch (IllegalStateException e3) {
                Log.e(fd.f17705a, "Cannot start download", e3);
            }
            return Unit.f40298a;
        }
    }

    public static final class d extends Lambda implements Function0 {

        /* renamed from: b  reason: collision with root package name */
        public static final d f17663b = new d();

        public d() {
            super(0);
        }

        /* renamed from: a */
        public final ConcurrentHashMap invoke() {
            return new ConcurrentHashMap();
        }
    }

    public ed(vc vcVar, h5 h5Var, Function1 function1, CoroutineDispatcher coroutineDispatcher) {
        Intrinsics.f(vcVar, "policy");
        Intrinsics.f(h5Var, "downloadManager");
        Intrinsics.f(function1, "fileCachingFactory");
        Intrinsics.f(coroutineDispatcher, "dispatcher");
        this.f17651a = vcVar;
        this.f17652b = h5Var;
        this.f17653c = function1;
        this.f17654d = coroutineDispatcher;
        this.f17655e = LazyKt__LazyJVMKt.b(b.f17660b);
        this.f17656f = LazyKt__LazyJVMKt.b(d.f17663b);
    }

    public final ConcurrentHashMap b() {
        return (ConcurrentHashMap) this.f17656f.getValue();
    }

    public final File c(String str) {
        m5 m5Var = this.f17657g;
        if (m5Var != null) {
            return m5Var.a(str);
        }
        return null;
    }

    public final void d(rc rcVar) {
        String a2 = fd.f17705a;
        Log.d(a2, "startForcedDownload() - " + rcVar);
        this.f17651a.a();
        this.f17652b.a(rcVar);
    }

    public final void e(rc rcVar) {
        p4 p4Var;
        if (this.f17651a.g()) {
            d();
            p4Var = p4.MAX_COUNT_TIME_WINDOW;
        } else {
            p4Var = p4.NONE;
        }
        a(rcVar, p4Var);
    }

    public final rc b(rc rcVar) {
        a().put(rcVar.d(), rcVar);
        return rcVar;
    }

    public final rc c(rc rcVar) {
        String a2 = fd.f17705a;
        Log.d(a2, "queueDownload() - asset: " + rcVar);
        a(rcVar, p4.STOPPED_QUEUE);
        return rcVar;
    }

    public final ConcurrentHashMap a() {
        return (ConcurrentHashMap) this.f17655e.getValue();
    }

    public rc b(String str) {
        Intrinsics.f(str, "filename");
        return (rc) a().get(str);
    }

    public void a(Context context) {
        Intrinsics.f(context, "context");
        Log.d(fd.f17705a, "initialize()");
        this.f17657g = (m5) this.f17653c.invoke(context);
        h5 h5Var = this.f17652b;
        h5Var.a();
        h5Var.a((id.a) this);
        h5Var.b();
    }

    public final void c() {
        p4 p4Var;
        if (this.f17651a.g()) {
            d();
            p4Var = p4.MAX_COUNT_TIME_WINDOW;
        } else {
            p4Var = p4.NONE;
        }
        if (p4Var == p4.NONE) {
            this.f17651a.a();
        }
        this.f17652b.a(p4Var);
    }

    public final void d() {
        if (this.f17658h == null) {
            this.f17658h = BuildersKt__Builders_commonKt.b(CoroutineScopeKt.a(this.f17654d), (CoroutineContext) null, (CoroutineStart) null, new c(this, (Continuation) null), 3, (Object) null);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ed(vc vcVar, h5 h5Var, Function1 function1, CoroutineDispatcher coroutineDispatcher, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(vcVar, h5Var, (i2 & 4) != 0 ? a.f17659b : function1, (i2 & 8) != 0 ? Dispatchers.b() : coroutineDispatcher);
    }

    public void a(String str, String str2, boolean z2, n0 n0Var) {
        rc a2;
        rc b2;
        Intrinsics.f(str, ImagesContract.URL);
        Intrinsics.f(str2, "filename");
        String a3 = fd.f17705a;
        Log.d(a3, "downloadVideoFile() - url: " + str + ", filename: " + str2 + ", showImmediately: " + z2 + ", callback: " + n0Var);
        if (n0Var != null) {
            b().put(str, n0Var);
        }
        File c2 = c(str2);
        if (c2 == null || (a2 = a(c2, str)) == null || (b2 = b(a2)) == null || c(b2) == null) {
            Log.d(fd.f17705a, "downloadVideoFile() - cache file is null");
        }
        dd.a.a(this, str2, 0, z2, 2, (Object) null);
    }

    public final rc a(File file, String str) {
        String name = file.getName();
        Intrinsics.e(name, "name");
        rc rcVar = new rc(str, name, file, file.getParentFile(), 0, (String) null, 0, 112, (DefaultConstructorMarker) null);
        file.setLastModified(rcVar.a());
        return rcVar;
    }

    public void a(String str, int i2, boolean z2) {
        Unit unit;
        rc rcVar;
        String a2 = fd.f17705a;
        Log.d(a2, "startDownloadIfPossible() - filename " + str + ", forceDownload " + z2);
        if (str == null || (rcVar = (rc) a().get(str)) == null) {
            unit = null;
        } else {
            String a3 = fd.f17705a;
            Log.d(a3, "startDownloadIfPossible() - asset: " + rcVar);
            if (z2) {
                d(rcVar);
            } else {
                e(rcVar);
            }
            unit = Unit.f40298a;
        }
        if (unit == null) {
            Log.d(fd.f17705a, "startDownloadIfPossible() - null asset, resume next download in Download Manager index");
            c();
        }
    }

    public final void a(rc rcVar, p4 p4Var) {
        String a2 = fd.f17705a;
        Log.d(a2, "sendDownloadToDownloadManager() - " + rcVar);
        if (p4Var == p4.NONE) {
            this.f17651a.a();
        }
        this.f17652b.a(rcVar, p4Var);
    }

    public boolean a(String str) {
        Intrinsics.f(str, "videoFilename");
        return this.f17652b.a(str);
    }

    public int a(rc rcVar) {
        if (rcVar != null) {
            return ba.a(this.f17652b.d(rcVar.d()));
        }
        return 0;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: com.chartboost.sdk.impl.n0} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(java.lang.String r2, java.lang.String r3, long r4, com.chartboost.sdk.impl.n0 r6) {
        /*
            r1 = this;
            java.lang.String r4 = "url"
            kotlin.jvm.internal.Intrinsics.f(r2, r4)
            java.lang.String r4 = "videoFileName"
            kotlin.jvm.internal.Intrinsics.f(r3, r4)
            java.lang.String r4 = com.chartboost.sdk.impl.fd.f17705a
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r0 = "tempFileIsReady() - url "
            r5.append(r0)
            r5.append(r2)
            java.lang.String r0 = ", videoFileName "
            r5.append(r0)
            r5.append(r3)
            java.lang.String r3 = r5.toString()
            android.util.Log.d(r4, r3)
            if (r6 != 0) goto L_0x0037
            java.util.concurrent.ConcurrentHashMap r3 = r1.b()
            java.lang.Object r3 = r3.get(r2)
            r6 = r3
            com.chartboost.sdk.impl.n0 r6 = (com.chartboost.sdk.impl.n0) r6
        L_0x0037:
            if (r6 == 0) goto L_0x003c
            r6.a(r2)
        L_0x003c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.impl.ed.a(java.lang.String, java.lang.String, long, com.chartboost.sdk.impl.n0):void");
    }

    public void a(String str, String str2) {
        Intrinsics.f(str, "uri");
        Intrinsics.f(str2, "videoFileName");
        String a2 = fd.f17705a;
        Log.d(a2, "onSuccess() - uri " + str + ", videoFileName " + str2);
        b().remove(str);
        dd.a.a(this, (String) null, 0, false, 7, (Object) null);
    }

    public void a(String str, String str2, CBError cBError) {
        Intrinsics.f(str, "uri");
        Intrinsics.f(str2, "videoFileName");
        String a2 = fd.f17705a;
        Log.d(a2, "onError() - uri " + str + ", videoFileName " + str2 + ", error " + cBError);
        b().remove(str);
    }
}
