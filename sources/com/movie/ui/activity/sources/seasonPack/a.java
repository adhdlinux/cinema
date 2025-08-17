package com.movie.ui.activity.sources.seasonPack;

import com.movie.data.model.TorrentObject;
import com.movie.ui.activity.sources.adapter.SeasonPackAdapter;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class a implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SeasonPackActivity f33015b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SeasonPackAdapter.SeasonPackData f33016c;

    public /* synthetic */ a(SeasonPackActivity seasonPackActivity, SeasonPackAdapter.SeasonPackData seasonPackData) {
        this.f33015b = seasonPackActivity;
        this.f33016c = seasonPackData;
    }

    public final void accept(Object obj) {
        this.f33015b.N(this.f33016c, (TorrentObject) obj);
    }
}
