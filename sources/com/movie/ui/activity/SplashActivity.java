package com.movie.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.security.ProviderInstaller;
import com.movie.AppComponent;
import com.movie.FreeMoviesApp;
import com.original.tase.Logger;
import com.original.tase.utils.NetworkUtils;
import com.utils.PrefUtils;
import com.utils.Utils;
import com.utils.download.DownloadActivity;
import com.yarolegovich.lovelydialog.LovelyStandardDialog;
import com.yoku.marumovie.R;
import java.util.Calendar;

public class SplashActivity extends BaseActivity {

    /* renamed from: b  reason: collision with root package name */
    private long f32169b = 0;

    private void z() {
        Utils.ac(PrefUtils.e(this));
        if (!FreeMoviesApp.p().getBoolean("PREF_KEY_SHORTCUT_ADDED", false)) {
            Intent intent = new Intent(getApplicationContext(), SplashActivity.class);
            intent.addFlags(268435456);
            intent.addFlags(67108864);
            Intent intent2 = new Intent();
            intent2.putExtra("android.intent.extra.shortcut.INTENT", intent);
            intent2.putExtra("android.intent.extra.shortcut.NAME", getResources().getString(R.string.app_name));
            intent2.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(getApplicationContext(), R.mipmap.ic_launcher));
            intent2.setAction("com.android.launcher.action.INSTALL_SHORTCUT");
            getApplicationContext().sendBroadcast(intent2);
            FreeMoviesApp.p().edit().putBoolean("PREF_KEY_SHORTCUT_ADDED", true).apply();
        }
    }

    public void A() {
        boolean z2;
        long j2;
        if (!Utils.k0() || FreeMoviesApp.p().getBoolean("pref_low_profilev2", false)) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            try {
                ProviderInstaller.installIfNeeded(this);
            } catch (GooglePlayServicesRepairableException e2) {
                Logger.d(e2, new boolean[0]);
            } catch (GooglePlayServicesNotAvailableException e3) {
                Logger.d(e3, new boolean[0]);
            }
        }
        this.f32169b = Calendar.getInstance().getTime().getTime();
        if (NetworkUtils.a()) {
            Utils.f0();
            long time = Calendar.getInstance().getTime().getTime() - this.f32169b;
            Handler handler = new Handler();
            AnonymousClass1 r3 = new Runnable() {
                public void run() {
                    int S = Utils.S(FreeMoviesApp.p().getString("pref_choose_default_tab", "Latest"));
                    Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                    intent.putExtra("GotNavID", S);
                    SplashActivity.this.startActivity(intent);
                }
            };
            if (time < 200) {
                j2 = 200 - time;
            } else {
                j2 = 0;
            }
            handler.postDelayed(r3, j2);
            return;
        }
        ((LovelyStandardDialog) ((LovelyStandardDialog) ((LovelyStandardDialog) ((LovelyStandardDialog) new LovelyStandardDialog(this, LovelyStandardDialog.ButtonLayout.HORIZONTAL).m(R.color.indigo)).r(R.color.darkDeepOrange).h(R.drawable.ic_star_border_white_36dp)).k("Offline Mode")).j("Network not available!, App will showVideo downloaded movie only!")).u(17039370, new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(SplashActivity.this.getApplicationContext(), DownloadActivity.class);
                intent.setFlags(603979776);
                SplashActivity.this.startActivity(intent);
                SplashActivity.this.finish();
            }
        }).o();
    }

    public Intent getParentActivityIntent() {
        return super.getParentActivityIntent().addFlags(67108864);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getIntent().hasExtra("exit")) {
            finish();
        } else if (isTaskRoot() || ((!getIntent().hasCategory("android.intent.category.LEANBACK_LAUNCHER") && !getIntent().hasCategory("android.intent.category.LAUNCHER")) || getIntent().getAction() == null || !getIntent().getAction().equals("android.intent.action.MAIN"))) {
            A();
            if (FreeMoviesApp.p().getBoolean("pref_keep_alive", false)) {
                Utils.C0(this);
            }
        } else {
            finish();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        Utils.ac(PrefUtils.e(this));
    }

    public void onPause() {
        super.onPause();
    }

    public void onResume() {
        super.onResume();
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        z();
    }

    /* access modifiers changed from: protected */
    public void setupComponent(AppComponent appComponent) {
    }
}
