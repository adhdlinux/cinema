package com.google.ar.core;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.ar.core.ArCoreApk;
import com.google.ar.core.annotations.UsedByReflection;
import com.google.ar.core.exceptions.FatalException;
import com.google.ar.core.exceptions.UnavailableDeviceNotCompatibleException;
import com.google.ar.core.exceptions.UnavailableUserDeclinedInstallationException;
import java.util.concurrent.atomic.AtomicReference;

@TargetApi(24)
@UsedByReflection("AndroidManifest.xml")
public class InstallActivity extends Activity {
    private static final int BOX_SIZE_DP = 280;
    private static final int INSTALLING_TEXT_BOTTOM_MARGIN_DP = 30;
    static final String INSTALL_BEHAVIOR_KEY = "behavior";
    static final String MESSAGE_TYPE_KEY = "message";
    private static final String TAG = "ARCore-InstallActivity";
    private boolean finished;
    private ArCoreApk.InstallBehavior installBehavior;
    private boolean installStarted;
    private w lastEvent = w.CANCELLED;
    private ArCoreApk.UserMessageType messageType;
    private final ContextThemeWrapper themeWrapper = new ContextThemeWrapper(this, 16974394);
    private boolean waitingForCompletion;

    /* access modifiers changed from: private */
    /* renamed from: animateToSpinner */
    public void b() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int width = getWindow().getDecorView().getWidth();
        int height = getWindow().getDecorView().getHeight();
        setContentView(new RelativeLayout(this));
        int i2 = (int) (displayMetrics.density * 280.0f);
        getWindow().getDecorView().setMinimumWidth(i2);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        ofFloat.setDuration(300);
        ofFloat.addUpdateListener(new t(this, width, i2, height));
        ofFloat.addListener(new u(this));
        ofFloat.start();
    }

    /* access modifiers changed from: private */
    /* renamed from: closeInstaller */
    public void e() {
        startActivity(new Intent(this, InstallActivity.class).setFlags(67108864));
    }

    /* access modifiers changed from: private */
    /* renamed from: finishWithFailure */
    public void c(Exception exc) {
        k.a().f30330b = exc;
        k.a().c();
        this.finished = true;
        super.finish();
    }

    private boolean isOptional() {
        return this.installBehavior == ArCoreApk.InstallBehavior.OPTIONAL;
    }

    private void showEducationDialog() {
        setContentView(R.layout.f30238a);
        int i2 = R.id.f30235a;
        findViewById(i2).setOnClickListener(new s(this, 1));
        if (!isOptional()) {
            findViewById(i2).setVisibility(8);
        }
        findViewById(R.id.f30236b).setOnClickListener(new s(this, 0));
        TextView textView = (TextView) findViewById(R.id.f30237c);
        w wVar = w.ACCEPTED;
        ArCoreApk.UserMessageType userMessageType = ArCoreApk.UserMessageType.APPLICATION;
        ArCoreApk.Availability availability = ArCoreApk.Availability.UNKNOWN_ERROR;
        if (this.messageType.ordinal() != 1) {
            textView.setText(R.string.f30239a);
        } else {
            textView.setText(R.string.f30240b);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: showSpinner */
    public void a() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int i2 = (int) (displayMetrics.density * 280.0f);
        getWindow().setLayout(i2, i2);
        RelativeLayout relativeLayout = new RelativeLayout(this.themeWrapper);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        ProgressBar progressBar = new ProgressBar(this.themeWrapper);
        progressBar.setIndeterminate(true);
        progressBar.setLayoutParams(layoutParams);
        relativeLayout.addView(progressBar);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(14);
        layoutParams2.addRule(12);
        layoutParams2.bottomMargin = (int) (displayMetrics.density * 30.0f);
        TextView textView = new TextView(this.themeWrapper);
        textView.setText(R.string.f30241c);
        textView.setLayoutParams(layoutParams2);
        relativeLayout.addView(textView);
        setContentView(relativeLayout);
        getWindow().setLayout(i2, i2);
    }

    /* access modifiers changed from: private */
    /* renamed from: startInstaller */
    public void d() {
        this.installStarted = true;
        this.lastEvent = w.CANCELLED;
        k.a().b(this).h(this, new v(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void f(w wVar) {
        this.lastEvent = wVar;
    }

    public void finish() {
        c(new UnavailableUserDeclinedInstallationException());
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ boolean g() {
        return this.waitingForCompletion;
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        StringBuilder sb = new StringBuilder(String.valueOf(i3).length() + 16);
        sb.append("activityResult: ");
        sb.append(i3);
        Log.i(TAG, sb.toString());
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            try {
                c(new FatalException("Install activity was suspended and recreated."));
            } catch (RuntimeException e2) {
                c(new FatalException("Exception starting install flow", e2));
            }
        } else {
            this.messageType = (ArCoreApk.UserMessageType) getIntent().getSerializableExtra(MESSAGE_TYPE_KEY);
            ArCoreApk.InstallBehavior installBehavior2 = (ArCoreApk.InstallBehavior) getIntent().getSerializableExtra(INSTALL_BEHAVIOR_KEY);
            this.installBehavior = installBehavior2;
            if (this.messageType == null || installBehavior2 == null) {
                Log.e(TAG, "missing intent data.");
                c(new FatalException("Install activity launched without config data."));
                return;
            }
            setTheme(16974394);
            getWindow().requestFeature(1);
            setFinishOnTouchOutside(isOptional());
            if (this.messageType == ArCoreApk.UserMessageType.USER_ALREADY_INFORMED) {
                a();
                return;
            }
            AtomicReference atomicReference = new AtomicReference(ArCoreApk.Availability.UNKNOWN_CHECKING);
            k.a().b(this).c(this, new C0061r(atomicReference));
            w wVar = w.ACCEPTED;
            int ordinal = ((ArCoreApk.Availability) atomicReference.get()).ordinal();
            if (ordinal == 0) {
                Log.w(TAG, "Preliminary compatibility check failed.");
            } else if (ordinal == 3) {
                c(new UnavailableDeviceNotCompatibleException());
                return;
            }
            showEducationDialog();
        }
    }

    public void onDestroy() {
        if (!this.finished) {
            k.a().c();
        }
        super.onDestroy();
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (!this.installStarted) {
            if (this.messageType == ArCoreApk.UserMessageType.USER_ALREADY_INFORMED) {
                d();
            }
        } else if (!this.finished) {
            synchronized (this) {
                w wVar = this.lastEvent;
                if (wVar == w.CANCELLED) {
                    finish();
                } else if (wVar == w.ACCEPTED) {
                    this.waitingForCompletion = true;
                } else {
                    c(k.a().f30330b);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("didResume", true);
    }
}
