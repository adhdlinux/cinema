package com.unity3d.services.core.webview.bridge;

import com.unity3d.services.core.log.DeviceLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Invocation {
    private static AtomicInteger _idCount = new AtomicInteger(0);
    private static Map<Integer, Invocation> _invocationSets;
    private IInvocationCallbackInvoker _invocationCallbackInvoker;
    private int _invocationId;
    private ArrayList<ArrayList<Object>> _invocations;
    private ArrayList<ArrayList<Object>> _responses;
    private final IWebViewBridge _webViewBridge;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Invocation() {
        /*
            r2 = this;
            com.unity3d.services.core.webview.bridge.SharedInstances r0 = com.unity3d.services.core.webview.bridge.SharedInstances.INSTANCE
            com.unity3d.services.core.webview.bridge.IInvocationCallbackInvoker r1 = r0.getWebViewAppInvocationCallbackInvoker()
            com.unity3d.services.core.webview.bridge.IWebViewBridge r0 = r0.getWebViewBridge()
            r2.<init>(r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.core.webview.bridge.Invocation.<init>():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0020, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized com.unity3d.services.core.webview.bridge.Invocation getInvocationById(int r3) {
        /*
            java.lang.Class<com.unity3d.services.core.webview.bridge.Invocation> r0 = com.unity3d.services.core.webview.bridge.Invocation.class
            monitor-enter(r0)
            java.util.Map<java.lang.Integer, com.unity3d.services.core.webview.bridge.Invocation> r1 = _invocationSets     // Catch:{ all -> 0x0022 }
            if (r1 == 0) goto L_0x001f
            java.lang.Integer r2 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0022 }
            boolean r1 = r1.containsKey(r2)     // Catch:{ all -> 0x0022 }
            if (r1 == 0) goto L_0x001f
            java.util.Map<java.lang.Integer, com.unity3d.services.core.webview.bridge.Invocation> r1 = _invocationSets     // Catch:{ all -> 0x0022 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0022 }
            java.lang.Object r3 = r1.get(r3)     // Catch:{ all -> 0x0022 }
            com.unity3d.services.core.webview.bridge.Invocation r3 = (com.unity3d.services.core.webview.bridge.Invocation) r3     // Catch:{ all -> 0x0022 }
            monitor-exit(r0)
            return r3
        L_0x001f:
            monitor-exit(r0)
            r3 = 0
            return r3
        L_0x0022:
            r3 = move-exception
            monitor-exit(r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.core.webview.bridge.Invocation.getInvocationById(int):com.unity3d.services.core.webview.bridge.Invocation");
    }

    public void addInvocation(String str, String str2, Object[] objArr, WebViewCallback webViewCallback) {
        if (this._invocations == null) {
            this._invocations = new ArrayList<>();
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        arrayList.add(str2);
        arrayList.add(objArr);
        arrayList.add(webViewCallback);
        this._invocations.add(arrayList);
    }

    public int getId() {
        return this._invocationId;
    }

    public ArrayList<ArrayList<Object>> getResponses() {
        return this._responses;
    }

    public boolean nextInvocation() {
        ArrayList<ArrayList<Object>> arrayList = this._invocations;
        if (arrayList == null || arrayList.size() <= 0) {
            return false;
        }
        ArrayList remove = this._invocations.remove(0);
        String str = (String) remove.get(0);
        String str2 = (String) remove.get(1);
        Object[] objArr = (Object[]) remove.get(2);
        try {
            this._webViewBridge.handleInvocation(str, str2, objArr, (WebViewCallback) remove.get(3));
        } catch (Exception e2) {
            DeviceLog.exception(String.format("Error handling invocation %s.%s(%s)", new Object[]{str, str2, Arrays.toString(objArr)}), e2);
        }
        return true;
    }

    public void sendInvocationCallback() {
        _invocationSets.remove(Integer.valueOf(getId()));
        this._invocationCallbackInvoker.invokeCallback(this);
    }

    public void setInvocationResponse(CallbackStatus callbackStatus, Enum enumR, Object... objArr) {
        if (this._responses == null) {
            this._responses = new ArrayList<>();
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(callbackStatus);
        arrayList.add(enumR);
        arrayList.add(objArr);
        this._responses.add(arrayList);
    }

    public Invocation(IWebViewBridge iWebViewBridge) {
        this(SharedInstances.INSTANCE.getWebViewAppInvocationCallbackInvoker(), iWebViewBridge);
    }

    public Invocation(IInvocationCallbackInvoker iInvocationCallbackInvoker, IWebViewBridge iWebViewBridge) {
        this._invocationCallbackInvoker = iInvocationCallbackInvoker;
        this._webViewBridge = iWebViewBridge;
        this._invocationId = _idCount.getAndIncrement();
        if (_invocationSets == null) {
            _invocationSets = new HashMap();
        }
        _invocationSets.put(Integer.valueOf(this._invocationId), this);
    }
}
