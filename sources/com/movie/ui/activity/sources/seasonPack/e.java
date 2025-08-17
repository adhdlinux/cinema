package com.movie.ui.activity.sources.seasonPack;

import com.movie.ui.activity.sources.adapter.SeasonPackAdapter;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class e implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SeasonPackActivity f33020b;

    public /* synthetic */ e(SeasonPackActivity seasonPackActivity) {
        this.f33020b = seasonPackActivity;
    }

    public final void accept(Object obj) {
        this.f33020b.P((SeasonPackAdapter.SeasonPackData) obj);
    }
}
