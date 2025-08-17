package androidx.activity.result.contract;

import android.content.Context;
import android.content.Intent;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.core.content.ContextCompat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public final class ActivityResultContracts$RequestMultiplePermissions extends ActivityResultContract<String[], Map<String, Boolean>> {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f88a = new Companion((DefaultConstructorMarker) null);

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Intent a(String[] strArr) {
            Intrinsics.f(strArr, "input");
            Intent putExtra = new Intent("androidx.activity.result.contract.action.REQUEST_PERMISSIONS").putExtra("androidx.activity.result.contract.extra.PERMISSIONS", strArr);
            Intrinsics.e(putExtra, "Intent(ACTION_REQUEST_PE…EXTRA_PERMISSIONS, input)");
            return putExtra;
        }
    }

    /* renamed from: d */
    public Intent a(Context context, String[] strArr) {
        Intrinsics.f(context, "context");
        Intrinsics.f(strArr, "input");
        return f88a.a(strArr);
    }

    /* renamed from: e */
    public ActivityResultContract.SynchronousResult<Map<String, Boolean>> b(Context context, String[] strArr) {
        boolean z2;
        boolean z3;
        Intrinsics.f(context, "context");
        Intrinsics.f(strArr, "input");
        boolean z4 = true;
        if (strArr.length == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            return new ActivityResultContract.SynchronousResult<>(MapsKt__MapsKt.g());
        }
        int length = strArr.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                break;
            }
            if (ContextCompat.checkSelfPermission(context, strArr[i2]) == 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (!z3) {
                z4 = false;
                break;
            }
            i2++;
        }
        if (!z4) {
            return null;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt___RangesKt.b(MapsKt__MapsJVMKt.d(strArr.length), 16));
        for (String a2 : strArr) {
            Pair a3 = TuplesKt.a(a2, Boolean.TRUE);
            linkedHashMap.put(a3.c(), a3.d());
        }
        return new ActivityResultContract.SynchronousResult<>(linkedHashMap);
    }

    /* renamed from: f */
    public Map<String, Boolean> c(int i2, Intent intent) {
        boolean z2;
        if (i2 != -1) {
            return MapsKt__MapsKt.g();
        }
        if (intent == null) {
            return MapsKt__MapsKt.g();
        }
        String[] stringArrayExtra = intent.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
        int[] intArrayExtra = intent.getIntArrayExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS");
        if (intArrayExtra == null || stringArrayExtra == null) {
            return MapsKt__MapsKt.g();
        }
        ArrayList arrayList = new ArrayList(intArrayExtra.length);
        for (int i3 : intArrayExtra) {
            if (i3 == 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            arrayList.add(Boolean.valueOf(z2));
        }
        return MapsKt__MapsKt.s(CollectionsKt___CollectionsKt.e0(ArraysKt___ArraysKt.u(stringArrayExtra), arrayList));
    }
}
