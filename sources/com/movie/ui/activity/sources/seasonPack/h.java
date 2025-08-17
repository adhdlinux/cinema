package com.movie.ui.activity.sources.seasonPack;

import com.utils.Getlink.Provider.BaseProvider;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

public final /* synthetic */ class h implements ObservableOnSubscribe {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SeasonPackActivity f33023a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BaseProvider f33024b;

    public /* synthetic */ h(SeasonPackActivity seasonPackActivity, BaseProvider baseProvider) {
        this.f33023a = seasonPackActivity;
        this.f33024b = baseProvider;
    }

    public final void subscribe(ObservableEmitter observableEmitter) {
        this.f33023a.M(this.f33024b, observableEmitter);
    }
}
