package com.movie.ui.activity.gamechallenge;

import android.content.pm.PackageManager;
import com.movie.data.model.gamechallenge.GameChallengeModel;
import io.reactivex.functions.Consumer;
import java.util.List;

public final /* synthetic */ class c implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GameChallenge f32243b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ PackageManager f32244c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ List f32245d;

    public /* synthetic */ c(GameChallenge gameChallenge, PackageManager packageManager, List list) {
        this.f32243b = gameChallenge;
        this.f32244c = packageManager;
        this.f32245d = list;
    }

    public final void accept(Object obj) {
        this.f32243b.F(this.f32244c, this.f32245d, (GameChallengeModel) obj);
    }
}
