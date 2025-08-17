package com.applovin.impl.mediation.debugger.ui.b;

import android.content.Context;
import android.content.Intent;
import android.database.DataSetObserver;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.ListView;
import com.applovin.impl.mediation.debugger.ui.a;
import com.applovin.impl.mediation.debugger.ui.b.b;
import com.applovin.impl.mediation.debugger.ui.d.c;
import com.applovin.impl.mediation.debugger.ui.d.d;
import com.applovin.impl.sdk.AppLovinContentProviderUtils;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.mediation.MaxDebuggerAdUnitsListActivity;
import com.applovin.mediation.MaxDebuggerDetailActivity;
import com.applovin.mediation.MaxDebuggerTestLiveNetworkActivity;
import com.applovin.sdk.R;

public class a extends com.applovin.impl.mediation.debugger.ui.a {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public b f14620a;

    /* renamed from: b  reason: collision with root package name */
    private DataSetObserver f14621b;

    /* renamed from: c  reason: collision with root package name */
    private FrameLayout f14622c;

    /* renamed from: d  reason: collision with root package name */
    private ListView f14623d;

    /* renamed from: e  reason: collision with root package name */
    private com.applovin.impl.adview.a f14624e;

    private void a() {
        Uri cacheJPEGImageWithFileName;
        Bitmap a2 = this.f14620a.a(this.f14623d);
        if (a2 != null && (cacheJPEGImageWithFileName = AppLovinContentProviderUtils.cacheJPEGImageWithFileName(a2, "mediation_debugger_screenshot.jpeg")) != null) {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("image/jpeg");
            intent.putExtra("android.intent.extra.STREAM", cacheJPEGImageWithFileName);
            intent.addFlags(1);
            startActivity(Intent.createChooser(intent, "Share Mediation Debugger"));
        }
    }

    /* access modifiers changed from: private */
    public void a(final Context context) {
        if (StringUtils.isValidString(this.f14620a.g()) && !this.f14620a.c()) {
            this.f14620a.a(true);
            runOnUiThread(new Runnable() {
                public void run() {
                    Utils.showAlert(a.this.f14620a.f(), a.this.f14620a.g(), context);
                }
            });
        }
    }

    private void b() {
        c();
        com.applovin.impl.adview.a aVar = new com.applovin.impl.adview.a(this, 50, 16842874);
        this.f14624e = aVar;
        aVar.setColor(-3355444);
        this.f14622c.addView(this.f14624e, new FrameLayout.LayoutParams(-1, -1, 17));
        this.f14622c.bringChildToFront(this.f14624e);
        this.f14624e.a();
    }

    /* access modifiers changed from: private */
    public void c() {
        com.applovin.impl.adview.a aVar = this.f14624e;
        if (aVar != null) {
            aVar.b();
            this.f14622c.removeView(this.f14624e);
            this.f14624e = null;
        }
    }

    /* access modifiers changed from: protected */
    public m getSdk() {
        b bVar = this.f14620a;
        if (bVar != null) {
            return bVar.d();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTitle("MAX Mediation Debugger");
        setContentView(R.layout.list_view);
        this.f14622c = (FrameLayout) findViewById(16908290);
        this.f14623d = (ListView) findViewById(R.id.listView);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mediation_debugger_activity_menu, menu);
        return true;
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        b bVar = this.f14620a;
        if (bVar != null) {
            bVar.unregisterDataSetObserver(this.f14621b);
            this.f14620a.a((d.a) null);
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (R.id.action_share != menuItem.getItemId()) {
            return super.onOptionsItemSelected(menuItem);
        }
        a();
        return true;
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        this.f14623d.setAdapter(this.f14620a);
        b bVar = this.f14620a;
        if (bVar != null && !bVar.a()) {
            b();
        }
    }

    public void setListAdapter(b bVar, final com.applovin.impl.sdk.a aVar) {
        DataSetObserver dataSetObserver;
        b bVar2 = this.f14620a;
        if (!(bVar2 == null || (dataSetObserver = this.f14621b) == null)) {
            bVar2.unregisterDataSetObserver(dataSetObserver);
        }
        this.f14620a = bVar;
        this.f14621b = new DataSetObserver() {
            public void onChanged() {
                a.this.c();
                a aVar = a.this;
                aVar.a((Context) aVar);
            }
        };
        a((Context) this);
        this.f14620a.registerDataSetObserver(this.f14621b);
        this.f14620a.a((d.a) new d.a() {
            public void a(com.applovin.impl.mediation.debugger.ui.d.a aVar, final c cVar) {
                String str;
                a aVar2;
                String str2;
                int a2 = aVar.a();
                if (a2 == b.C0018b.MAX.ordinal()) {
                    Utils.showAlert(cVar.l(), cVar.m(), a.this);
                } else if (a2 == b.C0018b.ADS.ordinal()) {
                    if (aVar.b() == b.a.AD_UNITS.ordinal()) {
                        if (a.this.f14620a.e().size() > 0) {
                            a.this.startActivity(MaxDebuggerAdUnitsListActivity.class, aVar, new a.C0016a<MaxDebuggerAdUnitsListActivity>() {
                                public void a(MaxDebuggerAdUnitsListActivity maxDebuggerAdUnitsListActivity) {
                                    maxDebuggerAdUnitsListActivity.initialize(a.this.f14620a.e(), a.this.f14620a.d());
                                }
                            });
                            return;
                        }
                        str = "Please setup or enable your MAX ad units on https://applovin.com.";
                        aVar2 = a.this;
                        str2 = "No live ad units";
                    } else if (aVar.b() != b.a.SELECT_LIVE_NETWORKS.ordinal()) {
                        return;
                    } else {
                        if (a.this.f14620a.h().size() <= 0 && a.this.f14620a.i().size() <= 0) {
                            str = "Please complete integrations in order to access this.";
                            aVar2 = a.this;
                            str2 = "Complete Integrations";
                        } else if (a.this.f14620a.d().J().a()) {
                            Utils.showAlert("Restart Required", cVar.m(), a.this);
                            return;
                        } else {
                            a.this.startActivity(MaxDebuggerTestLiveNetworkActivity.class, aVar, new a.C0016a<MaxDebuggerTestLiveNetworkActivity>() {
                                public void a(MaxDebuggerTestLiveNetworkActivity maxDebuggerTestLiveNetworkActivity) {
                                    maxDebuggerTestLiveNetworkActivity.initialize(a.this.f14620a.h(), a.this.f14620a.i(), a.this.f14620a.d());
                                }
                            });
                            return;
                        }
                    }
                    Utils.showAlert(str2, str, aVar2);
                } else if ((a2 == b.C0018b.INCOMPLETE_NETWORKS.ordinal() || a2 == b.C0018b.COMPLETED_NETWORKS.ordinal()) && (cVar instanceof com.applovin.impl.mediation.debugger.ui.b.a.a)) {
                    a.this.startActivity(MaxDebuggerDetailActivity.class, aVar, new a.C0016a<MaxDebuggerDetailActivity>() {
                        public void a(MaxDebuggerDetailActivity maxDebuggerDetailActivity) {
                            maxDebuggerDetailActivity.initialize(((com.applovin.impl.mediation.debugger.ui.b.a.a) cVar).d());
                        }
                    });
                }
            }
        });
    }
}
