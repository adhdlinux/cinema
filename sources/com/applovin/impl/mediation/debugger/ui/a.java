package com.applovin.impl.mediation.debugger.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.applovin.communicator.AppLovinCommunicator;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.communicator.AppLovinCommunicatorSubscriber;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.sdk.R;
import java.util.ArrayList;
import java.util.List;

public abstract class a extends Activity implements AppLovinCommunicatorSubscriber {
    protected List<String> communicatorTopics = new ArrayList();

    /* renamed from: com.applovin.impl.mediation.debugger.ui.a$a  reason: collision with other inner class name */
    public interface C0016a<T extends Activity> {
        void a(T t2);
    }

    public String getCommunicatorId() {
        return getClass().getSimpleName();
    }

    /* access modifiers changed from: protected */
    public abstract m getSdk();

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getSdk() != null && !Utils.isPubInDebugMode(this, getSdk())) {
            setTheme(R.style.com_applovin_mediation_MaxDebuggerActivity_Theme_Live);
        }
        List<String> list = this.communicatorTopics;
        if (list != null && list.size() > 0) {
            AppLovinCommunicator.getInstance(this).subscribe((AppLovinCommunicatorSubscriber) this, this.communicatorTopics);
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        List<String> list = this.communicatorTopics;
        if (list != null && list.size() > 0) {
            AppLovinCommunicator.getInstance(this).unsubscribe((AppLovinCommunicatorSubscriber) this, this.communicatorTopics);
        }
    }

    public void onMessageReceived(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
    }

    /* access modifiers changed from: protected */
    public void startActivity(final Class cls, final com.applovin.impl.sdk.a aVar, final C0016a aVar2) {
        aVar.a(new com.applovin.impl.sdk.utils.a() {
            public void onActivityCreated(Activity activity, Bundle bundle) {
                if (cls.isInstance(activity)) {
                    aVar2.a(activity);
                    aVar.b(this);
                }
            }
        });
        startActivity(new Intent(this, cls));
    }
}
