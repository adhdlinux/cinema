package com.extension;

import android.content.ContentValues;
import android.content.Context;
import com.database.entitys.MovieEntity;
import com.domain.api.provider.ProviderContract;
import com.original.tase.model.media.MediaSource;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.random.Random;
import timber.log.Timber;

final class CinemaWorker$createWork$1 extends Lambda implements Function1<MediaSource, Boolean> {

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ MovieEntity f19370f;

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ String f19371g;

    /* renamed from: h  reason: collision with root package name */
    final /* synthetic */ CinemaWorker f19372h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CinemaWorker$createWork$1(MovieEntity movieEntity, String str, CinemaWorker cinemaWorker) {
        super(1);
        this.f19370f = movieEntity;
        this.f19371g = str;
        this.f19372h = cinemaWorker;
    }

    /* renamed from: a */
    public final Boolean invoke(MediaSource mediaSource) {
        String str;
        Intrinsics.f(mediaSource, "mediaSource");
        Timber.Forest forest = Timber.f42178a;
        forest.h(mediaSource.getStreamLink(), new Object[0]);
        forest.h(this.f19370f.getName(), new Object[0]);
        forest.h(this.f19371g, new Object[0]);
        ContentValues contentValues = new ContentValues();
        MovieEntity movieEntity = this.f19370f;
        contentValues.put("streamUri", mediaSource.getStreamLink());
        contentValues.put("provider", "com.yoku");
        Boolean tv = movieEntity.getTV();
        if (tv != null) {
            Intrinsics.c(tv);
            tv.booleanValue();
            str = "EPISODE";
        } else {
            str = "MOVIE";
        }
        contentValues.put("type", str);
        contentValues.put("resolvedUrl", mediaSource.getStreamLink());
        contentValues.put("update_at", Long.valueOf(System.currentTimeMillis()));
        contentValues.put("_id", Long.valueOf(((long) this.f19370f.getId()) + Random.f40443b.f()));
        Context applicationContext = this.f19372h.getApplicationContext();
        Intrinsics.e(applicationContext, "getApplicationContext(...)");
        ProviderContract.b(applicationContext, "com.yoku").b(contentValues);
        return Boolean.TRUE;
    }
}
