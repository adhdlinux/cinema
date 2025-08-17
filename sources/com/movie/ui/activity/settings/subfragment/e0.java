package com.movie.ui.activity.settings.subfragment;

import com.utils.subtitle.services.openSubtitle.models.UserInfoResponse;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class e0 implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SubtitleFragment f32647b;

    public /* synthetic */ e0(SubtitleFragment subtitleFragment) {
        this.f32647b = subtitleFragment;
    }

    public final void accept(Object obj) {
        this.f32647b.lambda$onCreatePreferences$0((UserInfoResponse) obj);
    }
}
