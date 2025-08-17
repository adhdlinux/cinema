package com.vungle.ads.internal.presenter;

import android.content.Context;
import com.vungle.ads.internal.ClickCoordinateTracker;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

final class MRAIDPresenter$clickCoordinateTracker$2 extends Lambda implements Function0<ClickCoordinateTracker> {
    final /* synthetic */ MRAIDPresenter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MRAIDPresenter$clickCoordinateTracker$2(MRAIDPresenter mRAIDPresenter) {
        super(0);
        this.this$0 = mRAIDPresenter;
    }

    public final ClickCoordinateTracker invoke() {
        Context context = this.this$0.adWidget.getContext();
        Intrinsics.e(context, "adWidget.context");
        return new ClickCoordinateTracker(context, this.this$0.advertisement, this.this$0.executor);
    }
}
