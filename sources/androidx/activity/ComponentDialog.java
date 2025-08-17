package androidx.activity;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public class ComponentDialog extends Dialog implements LifecycleOwner, OnBackPressedDispatcherOwner {
    private LifecycleRegistry _lifecycleRegistry;
    private final OnBackPressedDispatcher onBackPressedDispatcher;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ComponentDialog(Context context) {
        this(context, 0, 2, (DefaultConstructorMarker) null);
        Intrinsics.f(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ComponentDialog(Context context, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? 0 : i2);
    }

    private final LifecycleRegistry getLifecycleRegistry() {
        LifecycleRegistry lifecycleRegistry = this._lifecycleRegistry;
        if (lifecycleRegistry != null) {
            return lifecycleRegistry;
        }
        LifecycleRegistry lifecycleRegistry2 = new LifecycleRegistry(this);
        this._lifecycleRegistry = lifecycleRegistry2;
        return lifecycleRegistry2;
    }

    private static /* synthetic */ void getOnBackPressedDispatcher$annotations() {
    }

    private final void initViewTreeOwners() {
        Window window = getWindow();
        Intrinsics.c(window);
        ViewTreeLifecycleOwner.a(window.getDecorView(), this);
        Window window2 = getWindow();
        Intrinsics.c(window2);
        View decorView = window2.getDecorView();
        Intrinsics.e(decorView, "window!!.decorView");
        ViewTreeOnBackPressedDispatcherOwner.a(decorView, this);
    }

    /* access modifiers changed from: private */
    /* renamed from: onBackPressedDispatcher$lambda-1  reason: not valid java name */
    public static final void m0onBackPressedDispatcher$lambda1(ComponentDialog componentDialog) {
        Intrinsics.f(componentDialog, "this$0");
        super.onBackPressed();
    }

    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        Intrinsics.f(view, "view");
        initViewTreeOwners();
        super.addContentView(view, layoutParams);
    }

    public final Lifecycle getLifecycle() {
        return getLifecycleRegistry();
    }

    public final OnBackPressedDispatcher getOnBackPressedDispatcher() {
        return this.onBackPressedDispatcher;
    }

    public void onBackPressed() {
        this.onBackPressedDispatcher.f();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 33) {
            this.onBackPressedDispatcher.g(getOnBackInvokedDispatcher());
        }
        getLifecycleRegistry().h(Lifecycle.Event.ON_CREATE);
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        getLifecycleRegistry().h(Lifecycle.Event.ON_RESUME);
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        getLifecycleRegistry().h(Lifecycle.Event.ON_DESTROY);
        this._lifecycleRegistry = null;
        super.onStop();
    }

    public void setContentView(int i2) {
        initViewTreeOwners();
        super.setContentView(i2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ComponentDialog(Context context, int i2) {
        super(context, i2);
        Intrinsics.f(context, "context");
        this.onBackPressedDispatcher = new OnBackPressedDispatcher(new d(this));
    }

    public void setContentView(View view) {
        Intrinsics.f(view, "view");
        initViewTreeOwners();
        super.setContentView(view);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        Intrinsics.f(view, "view");
        initViewTreeOwners();
        super.setContentView(view, layoutParams);
    }
}
