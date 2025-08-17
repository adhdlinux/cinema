package com.extension;

import android.content.Context;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.ListenableWorker;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.RxWorker;
import androidx.work.WorkManager;
import androidx.work.WorkerParameters;
import com.database.entitys.MovieEntity;
import com.movie.data.model.MovieInfo;
import com.original.tase.model.media.MediaSource;
import com.utils.Getlink.Provider.BaseProvider;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.schedulers.Schedulers;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public final class CinemaWorker extends RxWorker {

    /* renamed from: e  reason: collision with root package name */
    public static final Companion f19368e = new Companion((DefaultConstructorMarker) null);

    /* renamed from: d  reason: collision with root package name */
    private final WorkerParameters f19369d;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Context context, MovieEntity movieEntity, MovieInfo movieInfo) {
            Intrinsics.f(context, "context");
            Intrinsics.f(movieEntity, "movieEntity");
            BaseProvider[] baseProviderArr = BaseProvider.f37247c;
            Intrinsics.e(baseProviderArr, "list");
            for (BaseProvider A : baseProviderArr) {
                Data.Builder builder = new Data.Builder();
                builder.f("provider", A.A());
                DataExtKt.a(builder, "movieEntity", movieEntity);
                if (movieInfo != null) {
                    DataExtKt.a(builder, "movieInfo", movieInfo);
                }
                WorkManager d2 = WorkManager.d(context);
                Intrinsics.e(d2, "getInstance(...)");
                d2.b(((OneTimeWorkRequest.Builder) ((OneTimeWorkRequest.Builder) new OneTimeWorkRequest.Builder(CinemaWorker.class).e(new Constraints.Builder().b(NetworkType.CONNECTED).a())).f(builder.a())).b());
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CinemaWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        Intrinsics.f(context, "context");
        Intrinsics.f(workerParameters, "workerParams");
        this.f19369d = workerParameters;
    }

    /* access modifiers changed from: private */
    public static final boolean n(Function1 function1, Object obj) {
        Intrinsics.f(function1, "$tmp0");
        return ((Boolean) function1.invoke(obj)).booleanValue();
    }

    /* access modifiers changed from: private */
    public static final ListenableWorker.Result o(Function1 function1, Object obj) {
        Intrinsics.f(function1, "$tmp0");
        return (ListenableWorker.Result) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void p(Function1 function1, Object obj) {
        Intrinsics.f(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void q(Function1 function1, Object obj) {
        Intrinsics.f(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final ObservableSource s(Function1 function1, Object obj) {
        Intrinsics.f(function1, "$tmp0");
        return (ObservableSource) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final ObservableSource t(Function1 function1, Object obj) {
        Intrinsics.f(function1, "$tmp0");
        return (ObservableSource) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final boolean u(Function1 function1, Object obj) {
        Intrinsics.f(function1, "$tmp0");
        return ((Boolean) function1.invoke(obj)).booleanValue();
    }

    /* access modifiers changed from: private */
    public static final boolean v(Function1 function1, Object obj) {
        Intrinsics.f(function1, "$tmp0");
        return ((Boolean) function1.invoke(obj)).booleanValue();
    }

    /* access modifiers changed from: private */
    public static final boolean w(Function1 function1, Object obj) {
        Intrinsics.f(function1, "$tmp0");
        return ((Boolean) function1.invoke(obj)).booleanValue();
    }

    /* JADX INFO: finally extract failed */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v9, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: android.os.Parcelable} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public io.reactivex.Single<androidx.work.ListenableWorker.Result> a() {
        /*
            r10 = this;
            androidx.work.WorkerParameters r0 = r10.f19369d
            androidx.work.Data r0 = r0.d()
            java.lang.String r1 = "provider"
            java.lang.String r0 = r0.k(r1)
            com.utils.Getlink.Provider.BaseProvider[] r1 = com.utils.Getlink.Provider.BaseProvider.f37247c
            java.lang.String r2 = "list"
            kotlin.jvm.internal.Intrinsics.e(r1, r2)
            int r2 = r1.length
            r3 = 0
            r4 = 0
        L_0x0016:
            if (r4 >= r2) goto L_0x0117
            r5 = r1[r4]
            java.lang.String r6 = r5.A()
            boolean r6 = kotlin.jvm.internal.Intrinsics.a(r6, r0)
            if (r6 == 0) goto L_0x0113
            androidx.work.WorkerParameters r1 = r10.f19369d
            androidx.work.Data r1 = r1.d()
            java.lang.String r2 = "getInputData(...)"
            kotlin.jvm.internal.Intrinsics.e(r1, r2)
            java.lang.String r4 = "movieEntity"
            android.os.Parcel r6 = android.os.Parcel.obtain()
            java.lang.String r7 = "obtain(...)"
            kotlin.jvm.internal.Intrinsics.e(r6, r7)
            byte[] r1 = r1.i(r4)     // Catch:{ all -> 0x010e }
            java.lang.String r4 = "null cannot be cast to non-null type android.os.Parcelable.Creator<T of com.extension.DataExtKt.getParcelable>"
            r8 = 0
            if (r1 != 0) goto L_0x0048
            r6.recycle()
            r1 = r8
            goto L_0x006c
        L_0x0048:
            kotlin.jvm.internal.Intrinsics.c(r1)     // Catch:{ all -> 0x010e }
            int r9 = r1.length     // Catch:{ all -> 0x010e }
            r6.unmarshall(r1, r3, r9)     // Catch:{ all -> 0x010e }
            r6.setDataPosition(r3)     // Catch:{ all -> 0x010e }
            java.lang.Class<com.database.entitys.MovieEntity> r1 = com.database.entitys.MovieEntity.class
            java.lang.String r9 = "CREATOR"
            java.lang.reflect.Field r1 = r1.getField(r9)     // Catch:{ all -> 0x010e }
            java.lang.Object r1 = r1.get(r8)     // Catch:{ all -> 0x010e }
            kotlin.jvm.internal.Intrinsics.d(r1, r4)     // Catch:{ all -> 0x010e }
            android.os.Parcelable$Creator r1 = (android.os.Parcelable.Creator) r1     // Catch:{ all -> 0x010e }
            java.lang.Object r1 = r1.createFromParcel(r6)     // Catch:{ all -> 0x010e }
            android.os.Parcelable r1 = (android.os.Parcelable) r1     // Catch:{ all -> 0x010e }
            r6.recycle()
        L_0x006c:
            com.database.entitys.MovieEntity r1 = (com.database.entitys.MovieEntity) r1
            androidx.work.WorkerParameters r6 = r10.f19369d
            androidx.work.Data r6 = r6.d()
            kotlin.jvm.internal.Intrinsics.e(r6, r2)
            java.lang.String r2 = "movieInfo"
            android.os.Parcel r9 = android.os.Parcel.obtain()
            kotlin.jvm.internal.Intrinsics.e(r9, r7)
            byte[] r2 = r6.i(r2)     // Catch:{ all -> 0x0109 }
            if (r2 != 0) goto L_0x008a
        L_0x0086:
            r9.recycle()
            goto L_0x00ad
        L_0x008a:
            kotlin.jvm.internal.Intrinsics.c(r2)     // Catch:{ all -> 0x0109 }
            int r6 = r2.length     // Catch:{ all -> 0x0109 }
            r9.unmarshall(r2, r3, r6)     // Catch:{ all -> 0x0109 }
            r9.setDataPosition(r3)     // Catch:{ all -> 0x0109 }
            java.lang.Class<com.movie.data.model.MovieInfo> r2 = com.movie.data.model.MovieInfo.class
            java.lang.String r3 = "CREATOR"
            java.lang.reflect.Field r2 = r2.getField(r3)     // Catch:{ all -> 0x0109 }
            java.lang.Object r2 = r2.get(r8)     // Catch:{ all -> 0x0109 }
            kotlin.jvm.internal.Intrinsics.d(r2, r4)     // Catch:{ all -> 0x0109 }
            android.os.Parcelable$Creator r2 = (android.os.Parcelable.Creator) r2     // Catch:{ all -> 0x0109 }
            java.lang.Object r2 = r2.createFromParcel(r9)     // Catch:{ all -> 0x0109 }
            r8 = r2
            android.os.Parcelable r8 = (android.os.Parcelable) r8     // Catch:{ all -> 0x0109 }
            goto L_0x0086
        L_0x00ad:
            com.movie.data.model.MovieInfo r8 = (com.movie.data.model.MovieInfo) r8
            if (r1 == 0) goto L_0x00fb
            if (r8 == 0) goto L_0x00fb
            kotlin.jvm.internal.Intrinsics.c(r5)
            io.reactivex.Observable r2 = r10.r(r5, r1, r8)
            io.reactivex.Scheduler r3 = io.reactivex.schedulers.Schedulers.c()
            io.reactivex.Observable r2 = r2.subscribeOn(r3)
            com.extension.CinemaWorker$createWork$1 r3 = new com.extension.CinemaWorker$createWork$1
            r3.<init>(r1, r0, r10)
            com.extension.a r0 = new com.extension.a
            r0.<init>(r3)
            io.reactivex.Observable r0 = r2.filter(r0)
            io.reactivex.Single r0 = r0.toList()
            com.extension.CinemaWorker$createWork$2 r1 = com.extension.CinemaWorker$createWork$2.f19373f
            com.extension.b r2 = new com.extension.b
            r2.<init>(r1)
            io.reactivex.Single r0 = r0.g(r2)
            com.extension.CinemaWorker$createWork$3 r1 = com.extension.CinemaWorker$createWork$3.f19374f
            com.extension.c r2 = new com.extension.c
            r2.<init>(r1)
            io.reactivex.Single r0 = r0.d(r2)
            com.extension.CinemaWorker$createWork$4 r1 = com.extension.CinemaWorker$createWork$4.f19375f
            com.extension.d r2 = new com.extension.d
            r2.<init>(r1)
            io.reactivex.Single r0 = r0.e(r2)
            java.lang.String r1 = "doOnSuccess(...)"
            kotlin.jvm.internal.Intrinsics.e(r0, r1)
            return r0
        L_0x00fb:
            androidx.work.ListenableWorker$Result r0 = androidx.work.ListenableWorker.Result.a()
            io.reactivex.Single r0 = io.reactivex.Single.f(r0)
            java.lang.String r1 = "just(...)"
            kotlin.jvm.internal.Intrinsics.e(r0, r1)
            return r0
        L_0x0109:
            r0 = move-exception
            r9.recycle()
            throw r0
        L_0x010e:
            r0 = move-exception
            r6.recycle()
            throw r0
        L_0x0113:
            int r4 = r4 + 1
            goto L_0x0016
        L_0x0117:
            java.util.NoSuchElementException r0 = new java.util.NoSuchElementException
            java.lang.String r1 = "Array contains no element matching the predicate."
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.extension.CinemaWorker.a():io.reactivex.Single");
    }

    public final Observable<MediaSource> r(BaseProvider baseProvider, MovieEntity movieEntity, MovieInfo movieInfo) {
        Intrinsics.f(baseProvider, "baseProvider");
        Intrinsics.f(movieEntity, "movieEntity");
        Intrinsics.f(movieInfo, "movieInfo");
        movieInfo.tmdbID = movieEntity.getTmdbID();
        Observable<R> filter = baseProvider.F(movieInfo).subscribeOn(Schedulers.c()).flatMap(new e(CinemaWorker$startProvider$1.f19376f)).flatMap(new f(CinemaWorker$startProvider$2.f19377f)).map(new CinemaWorker$startProvider$3()).filter(new g(CinemaWorker$startProvider$4.f19378f)).filter(new h(CinemaWorker$startProvider$5.f19379f)).filter(new i(CinemaWorker$startProvider$6.f19380f));
        Intrinsics.e(filter, "filter(...)");
        return filter;
    }
}
