package com.movie.ui.activity.shows.seasons;

import com.movie.ui.activity.shows.seasons.SeasonFragment;
import io.reactivex.ObservableEmitter;
import io.reactivex.functions.Consumer;
import java.util.List;

public final /* synthetic */ class m implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SeasonFragment.AnonymousClass2 f32838b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f32839c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ ObservableEmitter f32840d;

    public /* synthetic */ m(SeasonFragment.AnonymousClass2 r12, boolean z2, ObservableEmitter observableEmitter) {
        this.f32838b = r12;
        this.f32839c = z2;
        this.f32840d = observableEmitter;
    }

    public final void accept(Object obj) {
        this.f32838b.c(this.f32839c, this.f32840d, (List) obj);
    }
}
