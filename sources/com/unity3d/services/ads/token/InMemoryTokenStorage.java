package com.unity3d.services.ads.token;

import com.unity3d.services.core.configuration.ConfigurationReader;
import com.unity3d.services.core.configuration.InitializeEventsMetricSender;
import com.unity3d.services.core.configuration.PrivacyConfigStorage;
import com.unity3d.services.core.device.reader.GameSessionIdReader;
import com.unity3d.services.core.device.reader.builder.DeviceInfoReaderBuilder;
import com.unity3d.services.core.di.IServiceComponent;
import com.unity3d.services.core.di.IServiceProvider;
import com.unity3d.services.core.webview.WebViewApp;
import com.unity3d.services.core.webview.WebViewEventCategory;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.json.JSONArray;
import org.json.JSONException;

public final class InMemoryTokenStorage implements TokenStorage, IServiceComponent {
    private final MutableStateFlow<Integer> accessCounter = StateFlowKt.a(-1);
    private final Lazy asyncTokenStorage$delegate = LazyKt__LazyJVMKt.a(LazyThreadSafetyMode.NONE, new InMemoryTokenStorage$special$$inlined$inject$default$1(this, ""));
    private final ExecutorService executorService = Executors.newSingleThreadExecutor();
    private final MutableStateFlow<String> initToken = StateFlowKt.a(null);
    private final ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();

    /* access modifiers changed from: private */
    public static final void _get_nativeGeneratedToken_$lambda$2(String str) {
        WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.TOKEN, TokenEvent.TOKEN_NATIVE_DATA, str);
    }

    private final AsyncTokenStorage getAsyncTokenStorage() {
        return (AsyncTokenStorage) this.asyncTokenStorage$delegate.getValue();
    }

    private final void triggerTokenAvailable(boolean z2) {
        InitializeEventsMetricSender.getInstance().sdkTokenDidBecomeAvailableWithConfig(z2);
    }

    public void appendTokens(JSONArray jSONArray) throws JSONException {
        Intrinsics.f(jSONArray, "tokens");
        this.accessCounter.a(-1, 0);
        int length = jSONArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            this.queue.add(jSONArray.getString(i2));
        }
        if (length > 0) {
            triggerTokenAvailable(false);
            getAsyncTokenStorage().onTokenAvailable();
        }
    }

    public void createTokens(JSONArray jSONArray) throws JSONException {
        Intrinsics.f(jSONArray, "tokens");
        deleteTokens();
        appendTokens(jSONArray);
    }

    public void deleteTokens() {
        Integer value;
        this.queue.clear();
        MutableStateFlow<Integer> mutableStateFlow = this.accessCounter;
        do {
            value = mutableStateFlow.getValue();
            value.intValue();
        } while (!mutableStateFlow.a(value, -1));
    }

    public Unit getNativeGeneratedToken() {
        new NativeTokenGenerator(this.executorService, new DeviceInfoReaderBuilder(new ConfigurationReader(), PrivacyConfigStorage.getInstance(), GameSessionIdReader.getInstance()), (String) null).generateToken(new a());
        return Unit.f40298a;
    }

    public IServiceProvider getServiceProvider() {
        return IServiceComponent.DefaultImpls.getServiceProvider(this);
    }

    public String getToken() {
        Integer value;
        Number number;
        if (this.accessCounter.getValue().intValue() == -1) {
            return this.initToken.getValue();
        }
        if (this.queue.isEmpty()) {
            WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.TOKEN, TokenEvent.QUEUE_EMPTY, new Object[0]);
            return null;
        }
        MutableStateFlow<Integer> mutableStateFlow = this.accessCounter;
        do {
            value = mutableStateFlow.getValue();
            number = value;
        } while (!mutableStateFlow.a(value, Integer.valueOf(number.intValue() + 1)));
        int intValue = number.intValue();
        WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.TOKEN, TokenEvent.TOKEN_ACCESS, Integer.valueOf(intValue));
        return this.queue.poll();
    }

    public void setInitToken(String str) {
        String value;
        if (str != null) {
            MutableStateFlow<String> mutableStateFlow = this.initToken;
            do {
                value = mutableStateFlow.getValue();
                String str2 = value;
            } while (!mutableStateFlow.a(value, str));
            triggerTokenAvailable(true);
            getAsyncTokenStorage().onTokenAvailable();
        }
    }
}
