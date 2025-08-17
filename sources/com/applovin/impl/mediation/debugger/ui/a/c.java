package com.applovin.impl.mediation.debugger.ui.a;

import android.content.Context;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.widget.ListView;
import com.applovin.impl.mediation.debugger.b.a.b;
import com.applovin.impl.mediation.debugger.ui.a;
import com.applovin.impl.mediation.debugger.ui.d.c;
import com.applovin.impl.mediation.debugger.ui.d.d;
import com.applovin.impl.mediation.debugger.ui.d.e;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.mediation.MaxDebuggerAdUnitDetailActivity;
import com.applovin.sdk.R;
import java.util.ArrayList;
import java.util.List;

public class c extends a {

    /* renamed from: a  reason: collision with root package name */
    private List<com.applovin.impl.mediation.debugger.b.a.a> f14602a;

    /* renamed from: b  reason: collision with root package name */
    private m f14603b;

    /* renamed from: c  reason: collision with root package name */
    private d f14604c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public List<com.applovin.impl.mediation.debugger.ui.d.c> f14605d;

    /* renamed from: e  reason: collision with root package name */
    private ListView f14606e;

    private List<com.applovin.impl.mediation.debugger.ui.d.c> a(List<com.applovin.impl.mediation.debugger.b.a.a> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (com.applovin.impl.mediation.debugger.b.a.a next : list) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(StringUtils.createListItemDetailSubSpannedString("ID\t\t\t\t\t\t", -7829368));
            spannableStringBuilder.append(StringUtils.createListItemDetailSpannedString(next.a(), -16777216));
            spannableStringBuilder.append(new SpannedString(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE));
            spannableStringBuilder.append(StringUtils.createListItemDetailSubSpannedString("FORMAT  ", -7829368));
            spannableStringBuilder.append(StringUtils.createListItemDetailSpannedString(next.c(), -16777216));
            arrayList.add(com.applovin.impl.mediation.debugger.ui.d.c.a(c.b.DETAIL).a(StringUtils.createSpannedString(next.b(), -16777216, 18, 1)).b(new SpannedString(spannableStringBuilder)).a((Context) this).a(true).a());
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public m getSdk() {
        return this.f14603b;
    }

    public void initialize(final List<com.applovin.impl.mediation.debugger.b.a.a> list, final m mVar) {
        this.f14602a = list;
        this.f14603b = mVar;
        this.f14605d = a(list);
        AnonymousClass1 r02 = new d(this) {
            /* access modifiers changed from: protected */
            public int a(int i2) {
                return list.size();
            }

            /* access modifiers changed from: protected */
            public int b() {
                return 1;
            }

            /* access modifiers changed from: protected */
            public com.applovin.impl.mediation.debugger.ui.d.c b(int i2) {
                return new e("");
            }

            /* access modifiers changed from: protected */
            public List<com.applovin.impl.mediation.debugger.ui.d.c> c(int i2) {
                return c.this.f14605d;
            }
        };
        this.f14604c = r02;
        r02.a((d.a) new d.a() {
            public void a(final com.applovin.impl.mediation.debugger.ui.d.a aVar, com.applovin.impl.mediation.debugger.ui.d.c cVar) {
                c.this.startActivity(MaxDebuggerAdUnitDetailActivity.class, mVar.af(), new a.C0016a<MaxDebuggerAdUnitDetailActivity>() {
                    public void a(MaxDebuggerAdUnitDetailActivity maxDebuggerAdUnitDetailActivity) {
                        maxDebuggerAdUnitDetailActivity.initialize((com.applovin.impl.mediation.debugger.b.a.a) list.get(aVar.b()), (b) null, mVar);
                    }
                });
            }
        });
        this.f14604c.notifyDataSetChanged();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTitle("Ad Units");
        setContentView(R.layout.list_view);
        ListView listView = (ListView) findViewById(R.id.listView);
        this.f14606e = listView;
        listView.setAdapter(this.f14604c);
    }
}
