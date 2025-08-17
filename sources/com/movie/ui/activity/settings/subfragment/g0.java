package com.movie.ui.activity.settings.subfragment;

import android.widget.TextView;
import com.movie.ui.activity.settings.subfragment.SubtitleFragment;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class g0 implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SubtitleFragment.AnonymousClass3.AnonymousClass1 f32650b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TextView f32651c;

    public /* synthetic */ g0(SubtitleFragment.AnonymousClass3.AnonymousClass1 r12, TextView textView) {
        this.f32650b = r12;
        this.f32651c = textView;
    }

    public final void accept(Object obj) {
        this.f32650b.d(this.f32651c, (Throwable) obj);
    }
}
