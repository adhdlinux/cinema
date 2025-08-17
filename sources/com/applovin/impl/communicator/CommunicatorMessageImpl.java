package com.applovin.impl.communicator;

import android.content.Intent;
import android.os.Bundle;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.communicator.AppLovinCommunicatorPublisher;
import java.lang.ref.WeakReference;
import java.util.UUID;

public abstract class CommunicatorMessageImpl extends Intent {

    /* renamed from: a  reason: collision with root package name */
    private final String f14142a = UUID.randomUUID().toString();
    protected final Bundle data;
    protected final WeakReference<AppLovinCommunicatorPublisher> publisherRef;
    protected boolean sticky;

    public CommunicatorMessageImpl(Bundle bundle, String str, AppLovinCommunicatorPublisher appLovinCommunicatorPublisher, boolean z2) {
        super(str);
        this.publisherRef = new WeakReference<>(appLovinCommunicatorPublisher);
        this.sticky = z2;
        this.data = bundle;
    }

    public static AppLovinCommunicatorMessage create(Bundle bundle, String str, AppLovinCommunicatorPublisher appLovinCommunicatorPublisher, boolean z2) {
        AppLovinCommunicatorMessage appLovinCommunicatorMessage = new AppLovinCommunicatorMessage(bundle, str, appLovinCommunicatorPublisher);
        appLovinCommunicatorMessage.sticky = z2;
        return appLovinCommunicatorMessage;
    }

    public abstract Bundle getMessageData();

    public abstract String getPublisherId();

    public abstract String getTopic();

    public String toString() {
        return "AppLovinCommunicatorMessage{publisherId=" + getPublisherId() + ", topic=" + getTopic() + '\'' + ", uniqueId='" + this.f14142a + '\'' + ", data=" + this.data + ", sticky=" + this.sticky + '}';
    }
}
