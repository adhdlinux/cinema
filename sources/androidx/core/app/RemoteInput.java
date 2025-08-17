package androidx.core.app;

import android.app.RemoteInput;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import java.util.Map;
import java.util.Set;

public final class RemoteInput {

    /* renamed from: a  reason: collision with root package name */
    private final String f2464a;

    /* renamed from: b  reason: collision with root package name */
    private final CharSequence f2465b;

    /* renamed from: c  reason: collision with root package name */
    private final CharSequence[] f2466c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f2467d;

    /* renamed from: e  reason: collision with root package name */
    private final int f2468e;

    /* renamed from: f  reason: collision with root package name */
    private final Bundle f2469f;

    /* renamed from: g  reason: collision with root package name */
    private final Set<String> f2470g;

    static class Api20Impl {
        private Api20Impl() {
        }

        static void a(Object obj, Intent intent, Bundle bundle) {
            android.app.RemoteInput.addResultsToIntent((android.app.RemoteInput[]) obj, intent, bundle);
        }

        public static android.app.RemoteInput b(RemoteInput remoteInput) {
            Set<String> d2;
            RemoteInput.Builder addExtras = new RemoteInput.Builder(remoteInput.i()).setLabel(remoteInput.h()).setChoices(remoteInput.e()).setAllowFreeFormInput(remoteInput.c()).addExtras(remoteInput.g());
            if (Build.VERSION.SDK_INT >= 26 && (d2 = remoteInput.d()) != null) {
                for (String d3 : d2) {
                    Api26Impl.d(addExtras, d3, true);
                }
            }
            if (Build.VERSION.SDK_INT >= 29) {
                Api29Impl.b(addExtras, remoteInput.f());
            }
            return addExtras.build();
        }

        static Bundle c(Intent intent) {
            return android.app.RemoteInput.getResultsFromIntent(intent);
        }
    }

    static class Api26Impl {
        private Api26Impl() {
        }

        static void a(RemoteInput remoteInput, Intent intent, Map<String, Uri> map) {
            android.app.RemoteInput.addDataResultToIntent(RemoteInput.a(remoteInput), intent, map);
        }

        static Set<String> b(Object obj) {
            return ((android.app.RemoteInput) obj).getAllowedDataTypes();
        }

        static Map<String, Uri> c(Intent intent, String str) {
            return android.app.RemoteInput.getDataResultsFromIntent(intent, str);
        }

        static RemoteInput.Builder d(RemoteInput.Builder builder, String str, boolean z2) {
            return builder.setAllowDataType(str, z2);
        }
    }

    static class Api29Impl {
        private Api29Impl() {
        }

        static int a(Object obj) {
            return ((android.app.RemoteInput) obj).getEditChoicesBeforeSending();
        }

        static RemoteInput.Builder b(RemoteInput.Builder builder, int i2) {
            return builder.setEditChoicesBeforeSending(i2);
        }
    }

    static android.app.RemoteInput a(RemoteInput remoteInput) {
        return Api20Impl.b(remoteInput);
    }

    static android.app.RemoteInput[] b(RemoteInput[] remoteInputArr) {
        if (remoteInputArr == null) {
            return null;
        }
        android.app.RemoteInput[] remoteInputArr2 = new android.app.RemoteInput[remoteInputArr.length];
        for (int i2 = 0; i2 < remoteInputArr.length; i2++) {
            remoteInputArr2[i2] = a(remoteInputArr[i2]);
        }
        return remoteInputArr2;
    }

    public boolean c() {
        return this.f2467d;
    }

    public Set<String> d() {
        return this.f2470g;
    }

    public CharSequence[] e() {
        return this.f2466c;
    }

    public int f() {
        return this.f2468e;
    }

    public Bundle g() {
        return this.f2469f;
    }

    public CharSequence h() {
        return this.f2465b;
    }

    public String i() {
        return this.f2464a;
    }

    public boolean j() {
        if (c() || ((e() != null && e().length != 0) || d() == null || d().isEmpty())) {
            return false;
        }
        return true;
    }
}
