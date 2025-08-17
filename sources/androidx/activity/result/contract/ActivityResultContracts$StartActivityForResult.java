package androidx.activity.result.contract;

import android.content.Context;
import android.content.Intent;
import androidx.activity.result.ActivityResult;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public final class ActivityResultContracts$StartActivityForResult extends ActivityResultContract<Intent, ActivityResult> {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f89a = new Companion((DefaultConstructorMarker) null);

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* renamed from: d */
    public Intent a(Context context, Intent intent) {
        Intrinsics.f(context, "context");
        Intrinsics.f(intent, "input");
        return intent;
    }

    /* renamed from: e */
    public ActivityResult c(int i2, Intent intent) {
        return new ActivityResult(i2, intent);
    }
}
