package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.util.Preconditions;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public abstract class FragmentHostCallback<E> extends FragmentContainer {

    /* renamed from: b  reason: collision with root package name */
    private final Activity f3399b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f3400c;

    /* renamed from: d  reason: collision with root package name */
    private final Handler f3401d;

    /* renamed from: e  reason: collision with root package name */
    private final int f3402e;

    /* renamed from: f  reason: collision with root package name */
    final FragmentManager f3403f;

    FragmentHostCallback(FragmentActivity fragmentActivity) {
        this(fragmentActivity, fragmentActivity, new Handler(), 0);
    }

    public View c(int i2) {
        return null;
    }

    public boolean d() {
        return true;
    }

    /* access modifiers changed from: package-private */
    public Activity e() {
        return this.f3399b;
    }

    /* access modifiers changed from: package-private */
    public Context f() {
        return this.f3400c;
    }

    /* access modifiers changed from: package-private */
    public Handler g() {
        return this.f3401d;
    }

    public void h(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    public abstract E i();

    public LayoutInflater j() {
        return LayoutInflater.from(this.f3400c);
    }

    @Deprecated
    public void k(Fragment fragment, String[] strArr, int i2) {
    }

    public boolean l(Fragment fragment) {
        return true;
    }

    public boolean m(String str) {
        return false;
    }

    public void n(Fragment fragment, @SuppressLint({"UnknownNullness"}) Intent intent, int i2, Bundle bundle) {
        if (i2 == -1) {
            ContextCompat.startActivity(this.f3400c, intent, bundle);
            return;
        }
        throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
    }

    @Deprecated
    public void o(Fragment fragment, @SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5, Bundle bundle) throws IntentSender.SendIntentException {
        if (i2 == -1) {
            ActivityCompat.l(this.f3399b, intentSender, i2, intent, i3, i4, i5, bundle);
        } else {
            throw new IllegalStateException("Starting intent sender with a requestCode requires a FragmentActivity host");
        }
    }

    public void p() {
    }

    FragmentHostCallback(Activity activity, Context context, Handler handler, int i2) {
        this.f3403f = new FragmentManagerImpl();
        this.f3399b = activity;
        this.f3400c = (Context) Preconditions.h(context, "context == null");
        this.f3401d = (Handler) Preconditions.h(handler, "handler == null");
        this.f3402e = i2;
    }
}
