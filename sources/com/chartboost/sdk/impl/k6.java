package com.chartboost.sdk.impl;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.chartboost.sdk.view.CBImpressionActivity;
import kotlin.jvm.internal.Intrinsics;

public final class k6 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f18028a;

    public k6(Context context) {
        Intrinsics.f(context, "context");
        this.f18028a = context;
    }

    public final Intent a() {
        Intent addFlags = new Intent(this.f18028a, CBImpressionActivity.class).putExtra("isChartboost", true).addFlags(268435456);
        Intrinsics.e(addFlags, "Intent(context, CBImpres…t.FLAG_ACTIVITY_NEW_TASK)");
        return addFlags;
    }

    public final void a(Intent intent) {
        Intrinsics.f(intent, "intent");
        try {
            this.f18028a.startActivity(intent);
        } catch (Exception e2) {
            Log.e("ImpressionActivity", "Cannot start the activity: " + e2);
        }
    }
}
