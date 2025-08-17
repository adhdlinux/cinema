package com.applovin.impl.mediation.debugger.ui.c;

import android.os.Bundle;
import android.widget.ListView;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.impl.mediation.debugger.b.b.b;
import com.applovin.impl.mediation.debugger.ui.a;
import com.applovin.impl.mediation.debugger.ui.c.b;
import com.applovin.impl.mediation.debugger.ui.d.c;
import com.applovin.impl.mediation.debugger.ui.d.d;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.mediation.MaxDebuggerMultiAdActivity;
import com.applovin.sdk.R;

public class a extends com.applovin.impl.mediation.debugger.ui.a {

    /* renamed from: a  reason: collision with root package name */
    private b f14673a;

    /* renamed from: b  reason: collision with root package name */
    private ListView f14674b;

    public a() {
        this.communicatorTopics.add("adapter_initialization_status");
        this.communicatorTopics.add("network_sdk_version_updated");
    }

    /* access modifiers changed from: protected */
    public m getSdk() {
        b bVar = this.f14673a;
        if (bVar != null) {
            return bVar.a().v();
        }
        return null;
    }

    public void initialize(final b bVar) {
        setTitle(bVar.i());
        b bVar2 = new b(bVar, this);
        this.f14673a = bVar2;
        bVar2.a((d.a) new d.a() {
            public void a(com.applovin.impl.mediation.debugger.ui.d.a aVar, c cVar) {
                if (aVar.a() == b.a.TEST_ADS.ordinal()) {
                    m v2 = bVar.v();
                    b.C0015b c2 = bVar.c();
                    if (b.C0015b.READY == c2) {
                        a.this.startActivity(MaxDebuggerMultiAdActivity.class, v2.af(), new a.C0016a<MaxDebuggerMultiAdActivity>() {
                            public void a(MaxDebuggerMultiAdActivity maxDebuggerMultiAdActivity) {
                                maxDebuggerMultiAdActivity.initialize(bVar);
                            }
                        });
                        return;
                    } else if (b.C0015b.DISABLED == c2) {
                        v2.J().d();
                        Utils.showAlert("Restart Required", cVar.m(), a.this);
                        return;
                    }
                }
                Utils.showAlert("Instructions", cVar.m(), a.this);
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.list_view);
        ListView listView = (ListView) findViewById(R.id.listView);
        this.f14674b = listView;
        listView.setAdapter(this.f14673a);
    }

    public void onMessageReceived(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
        if (this.f14673a.a().m().equals(appLovinCommunicatorMessage.getMessageData().getString("adapter_class", ""))) {
            this.f14673a.c();
            this.f14673a.j();
        }
    }
}
