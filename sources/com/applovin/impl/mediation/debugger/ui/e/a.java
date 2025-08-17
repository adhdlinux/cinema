package com.applovin.impl.mediation.debugger.ui.e;

import android.os.Bundle;
import android.text.SpannedString;
import android.widget.ListView;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.impl.mediation.debugger.b.a.d;
import com.applovin.impl.mediation.debugger.ui.d.c;
import com.applovin.impl.mediation.debugger.ui.d.d;
import com.applovin.impl.mediation.debugger.ui.d.e;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.R;
import java.util.ArrayList;
import java.util.List;

public class a extends com.applovin.impl.mediation.debugger.ui.a {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public m f14740a;

    /* renamed from: b  reason: collision with root package name */
    private List<d> f14741b;

    /* renamed from: c  reason: collision with root package name */
    private List<d> f14742c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public com.applovin.impl.mediation.debugger.ui.d.d f14743d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public List<c> f14744e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public List<c> f14745f;

    /* renamed from: g  reason: collision with root package name */
    private ListView f14746g;

    /* renamed from: com.applovin.impl.mediation.debugger.ui.e.a$a  reason: collision with other inner class name */
    enum C0019a {
        BIDDERS,
        WATERFALL,
        COUNT
    }

    public a() {
        this.communicatorTopics.add("network_sdk_version_updated");
    }

    /* access modifiers changed from: private */
    public d a(com.applovin.impl.mediation.debugger.ui.d.a aVar) {
        return (aVar.a() == C0019a.BIDDERS.ordinal() ? this.f14741b : this.f14742c).get(aVar.b());
    }

    private List<c> a(List<d> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (final d next : list) {
            arrayList.add(new com.applovin.impl.mediation.debugger.ui.b.a.a(next.c(), this) {
                public int f() {
                    if (a.this.f14740a.J().c() == null || !a.this.f14740a.J().c().equals(next.a())) {
                        return 0;
                    }
                    return R.drawable.applovin_ic_check_mark_borderless;
                }

                public int g() {
                    if (a.this.f14740a.J().c() == null || !a.this.f14740a.J().c().equals(next.a())) {
                        return super.g();
                    }
                    return -16776961;
                }

                public SpannedString k() {
                    return StringUtils.createSpannedString(next.b(), b() ? -16777216 : -7829368, 18, 1);
                }
            });
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public m getSdk() {
        return this.f14740a;
    }

    public void initialize(List<d> list, List<d> list2, final m mVar) {
        this.f14740a = mVar;
        this.f14741b = list;
        this.f14742c = list2;
        this.f14744e = a(list);
        this.f14745f = a(list2);
        AnonymousClass1 r12 = new com.applovin.impl.mediation.debugger.ui.d.d(this) {
            /* access modifiers changed from: protected */
            public int a(int i2) {
                return (i2 == C0019a.BIDDERS.ordinal() ? a.this.f14744e : a.this.f14745f).size();
            }

            /* access modifiers changed from: protected */
            public int b() {
                return C0019a.COUNT.ordinal();
            }

            /* access modifiers changed from: protected */
            public c b(int i2) {
                return i2 == C0019a.BIDDERS.ordinal() ? new e("BIDDERS") : new e("WATERFALL");
            }

            /* access modifiers changed from: protected */
            public List<c> c(int i2) {
                return i2 == C0019a.BIDDERS.ordinal() ? a.this.f14744e : a.this.f14745f;
            }

            /* access modifiers changed from: protected */
            public c k() {
                return new c.a(c.b.SECTION_CENTERED).a("Select a network to load ads using your MAX ad unit configuration. Once enabled, this functionality will reset on the next app session.").a();
            }
        };
        this.f14743d = r12;
        r12.a((d.a) new d.a() {
            public void a(com.applovin.impl.mediation.debugger.ui.d.a aVar, c cVar) {
                String a2 = a.this.a(aVar).a();
                if (!StringUtils.isValidString(a2) || !StringUtils.isValidString(mVar.J().c()) || !a2.equals(mVar.J().c())) {
                    mVar.J().a(true);
                    mVar.J().a(a2);
                } else {
                    mVar.J().a(false);
                    mVar.J().a((String) null);
                }
                a.this.f14743d.notifyDataSetChanged();
            }
        });
        this.f14743d.notifyDataSetChanged();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTitle("Select Live Network");
        setContentView(R.layout.list_view);
        ListView listView = (ListView) findViewById(R.id.listView);
        this.f14746g = listView;
        listView.setAdapter(this.f14743d);
    }

    public void onMessageReceived(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
        this.f14744e = a(this.f14741b);
        this.f14745f = a(this.f14742c);
        this.f14743d.j();
    }
}
