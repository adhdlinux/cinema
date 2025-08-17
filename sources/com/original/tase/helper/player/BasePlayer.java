package com.original.tase.helper.player;

import android.content.Context;
import android.content.Intent;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import com.original.tase.helper.PlayerHelper;
import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

public abstract class BasePlayer extends ActivityResultContract<PlayerHelper.PlayData, ActivityResult> {

    /* renamed from: a  reason: collision with root package name */
    private final String f34005a;

    /* renamed from: b  reason: collision with root package name */
    private ActivityResultLauncher<PlayerHelper.PlayData> f34006b;

    public String d() {
        return this.f34005a;
    }

    public ActivityResultLauncher<PlayerHelper.PlayData> e() {
        return this.f34006b;
    }

    public abstract String f();

    public abstract String g(Context context);

    public abstract long h(ActivityResult activityResult);

    public List<Pair<Integer, Long>> i(ActivityResult activityResult) {
        Intrinsics.f(activityResult, "result");
        return new ArrayList();
    }

    /* renamed from: j */
    public ActivityResult c(int i2, Intent intent) {
        return new ActivityResult(i2, intent);
    }

    public void k(ActivityResultLauncher<PlayerHelper.PlayData> activityResultLauncher) {
        this.f34006b = activityResultLauncher;
    }
}
