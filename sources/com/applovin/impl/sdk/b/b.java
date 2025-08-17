package com.applovin.impl.sdk.b;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import com.applovin.impl.sdk.ad.e;
import com.applovin.impl.sdk.m;
import com.applovin.sdk.AppLovinSdkUtils;

public class b {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final m f15160a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final Activity f15161b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public AlertDialog f15162c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public a f15163d;

    public interface a {
        void a();

        void b();
    }

    public b(Activity activity, m mVar) {
        this.f15160a = mVar;
        this.f15161b = activity;
    }

    public void a() {
        this.f15161b.runOnUiThread(new Runnable() {
            public void run() {
                if (b.this.f15162c != null) {
                    b.this.f15162c.dismiss();
                }
            }
        });
    }

    public void a(final e eVar, final Runnable runnable) {
        this.f15161b.runOnUiThread(new Runnable() {
            public void run() {
                AlertDialog.Builder builder = new AlertDialog.Builder(b.this.f15161b);
                builder.setTitle(eVar.an());
                String ao = eVar.ao();
                if (AppLovinSdkUtils.isValidString(ao)) {
                    builder.setMessage(ao);
                }
                builder.setPositiveButton(eVar.ap(), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i2) {
                        Runnable runnable = runnable;
                        if (runnable != null) {
                            runnable.run();
                        }
                    }
                });
                builder.setCancelable(false);
                AlertDialog unused = b.this.f15162c = builder.show();
            }
        });
    }

    public void a(a aVar) {
        this.f15163d = aVar;
    }

    public void b() {
        this.f15161b.runOnUiThread(new Runnable() {
            public void run() {
                AlertDialog unused = b.this.f15162c = new AlertDialog.Builder(b.this.f15161b).setTitle((CharSequence) b.this.f15160a.a(com.applovin.impl.sdk.c.b.bv)).setMessage((CharSequence) b.this.f15160a.a(com.applovin.impl.sdk.c.b.bw)).setCancelable(false).setPositiveButton((CharSequence) b.this.f15160a.a(com.applovin.impl.sdk.c.b.by), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i2) {
                        b.this.f15163d.a();
                    }
                }).setNegativeButton((CharSequence) b.this.f15160a.a(com.applovin.impl.sdk.c.b.bx), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i2) {
                        b.this.f15163d.b();
                    }
                }).show();
            }
        });
    }

    public boolean c() {
        AlertDialog alertDialog = this.f15162c;
        if (alertDialog != null) {
            return alertDialog.isShowing();
        }
        return false;
    }
}
