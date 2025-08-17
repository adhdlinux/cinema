package com.applovin.impl.sdk;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.c.b;
import com.applovin.impl.sdk.utils.h;
import com.applovin.impl.sdk.utils.o;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

class k implements AppLovinBroadcastManager.Receiver {
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static AlertDialog f15487b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static final AtomicBoolean f15488c = new AtomicBoolean();
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final l f15489a;

    /* renamed from: d  reason: collision with root package name */
    private o f15490d;

    public interface a {
        void a();

        void b();
    }

    k(l lVar, m mVar) {
        this.f15489a = lVar;
        mVar.aj().registerReceiver(this, new IntentFilter("com.applovin.application_paused"));
        mVar.aj().registerReceiver(this, new IntentFilter("com.applovin.application_resumed"));
    }

    public void a(long j2, final m mVar, final a aVar) {
        if (j2 > 0) {
            AlertDialog alertDialog = f15487b;
            if (alertDialog == null || !alertDialog.isShowing()) {
                if (f15488c.getAndSet(true)) {
                    if (j2 < this.f15490d.a()) {
                        if (v.a()) {
                            v A = mVar.A();
                            A.b("ConsentAlertManager", "Scheduling consent alert earlier (" + j2 + "ms) than remaining scheduled time (" + this.f15490d.a() + "ms)");
                        }
                        this.f15490d.d();
                    } else if (v.a()) {
                        v A2 = mVar.A();
                        A2.d("ConsentAlertManager", "Skip scheduling consent alert - one scheduled already with remaining time of " + this.f15490d.a() + " milliseconds");
                        return;
                    } else {
                        return;
                    }
                }
                if (v.a()) {
                    v A3 = mVar.A();
                    A3.b("ConsentAlertManager", "Scheduling consent alert for " + j2 + " milliseconds");
                }
                this.f15490d = o.a(j2, mVar, new Runnable() {
                    public void run() {
                        String str;
                        v vVar;
                        if (!k.this.f15489a.d()) {
                            Activity a2 = mVar.af().a();
                            if (a2 == null || !h.a(mVar.L())) {
                                if (v.a()) {
                                    if (a2 == null) {
                                        vVar = mVar.A();
                                        str = "No parent Activity found - rescheduling consent alert...";
                                    } else {
                                        vVar = mVar.A();
                                        str = "No internet available - rescheduling consent alert...";
                                    }
                                    vVar.e("ConsentAlertManager", str);
                                }
                                k.f15488c.set(false);
                                k.this.a(((Long) mVar.a(b.aF)).longValue(), mVar, aVar);
                                return;
                            }
                            AppLovinSdkUtils.runOnUiThread(new Runnable() {
                                public void run() {
                                    AlertDialog unused = k.f15487b = new AlertDialog.Builder(mVar.af().a()).setTitle((CharSequence) mVar.a(b.aG)).setMessage((CharSequence) mVar.a(b.aH)).setCancelable(false).setPositiveButton((CharSequence) mVar.a(b.aI), new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialogInterface, int i2) {
                                            aVar.a();
                                            dialogInterface.dismiss();
                                            k.f15488c.set(false);
                                        }
                                    }).setNegativeButton((CharSequence) mVar.a(b.aJ), new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialogInterface, int i2) {
                                            aVar.b();
                                            dialogInterface.dismiss();
                                            k.f15488c.set(false);
                                            long longValue = ((Long) mVar.a(b.aE)).longValue();
                                            AnonymousClass1 r02 = AnonymousClass1.this;
                                            k.this.a(longValue, mVar, aVar);
                                        }
                                    }).create();
                                    k.f15487b.show();
                                }
                            });
                        } else if (v.a()) {
                            mVar.A().e("ConsentAlertManager", "Consent dialog already showing, skip showing of consent alert");
                        }
                    }
                });
            }
        }
    }

    public void onReceive(Context context, Intent intent, Map<String, Object> map) {
        if (this.f15490d != null) {
            String action = intent.getAction();
            if ("com.applovin.application_paused".equals(action)) {
                this.f15490d.b();
            } else if ("com.applovin.application_resumed".equals(action)) {
                this.f15490d.c();
            }
        }
    }
}
