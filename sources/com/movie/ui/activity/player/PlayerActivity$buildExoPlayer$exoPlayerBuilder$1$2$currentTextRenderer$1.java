package com.movie.ui.activity.player;

import android.os.Handler;
import android.os.Looper;
import androidx.media3.exoplayer.ExoPlayer;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import timber.log.Timber;

final class PlayerActivity$buildExoPlayer$exoPlayerBuilder$1$2$currentTextRenderer$1 extends Lambda implements Function0<Unit> {

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ PlayerActivity f32402f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PlayerActivity$buildExoPlayer$exoPlayerBuilder$1$2$currentTextRenderer$1(PlayerActivity playerActivity) {
        super(0);
        this.f32402f = playerActivity;
    }

    /* access modifiers changed from: private */
    public static final void b(PlayerActivity playerActivity) {
        Intrinsics.f(playerActivity, "this$0");
        try {
            ExoPlayer n02 = playerActivity.f32364e;
            if (n02 != null) {
                n02.seekTo(n02.getCurrentPosition() + 1);
            }
        } catch (Exception e2) {
            Timber.f42178a.c(e2);
        }
    }

    public final void invoke() {
        Looper u2;
        ExoPlayer n02 = this.f32402f.f32364e;
        if (n02 != null && (u2 = n02.u()) != null) {
            try {
                new Handler(u2).post(new a(this.f32402f));
            } catch (Exception e2) {
                Timber.f42178a.c(e2);
            }
        }
    }
}
