package com.vungle.ads.internal;

import android.content.Context;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

final class VungleInitializer$configure$1 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ Context $context;
    final /* synthetic */ VungleInitializer this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    VungleInitializer$configure$1(VungleInitializer vungleInitializer, Context context) {
        super(1);
        this.this$0 = vungleInitializer;
        this.$context = context;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Boolean) obj).booleanValue());
        return Unit.f40298a;
    }

    public final void invoke(boolean z2) {
        if (z2) {
            this.this$0.downloadMraidJs(this.$context);
        }
    }
}
