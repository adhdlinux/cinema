package androidx.activity;

import androidx.core.util.Consumer;

public final /* synthetic */ class e implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ OnBackPressedDispatcher f52a;

    public /* synthetic */ e(OnBackPressedDispatcher onBackPressedDispatcher) {
        this.f52a = onBackPressedDispatcher;
    }

    public final void accept(Object obj) {
        this.f52a.e((Boolean) obj);
    }
}
