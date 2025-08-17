package com.facebook.react.modules.websocket;

import com.facebook.common.logging.FLog;
import com.facebook.fbreact.specs.NativeWebSocketModuleSpec;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.modules.network.ForwardingCookieHandler;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;

@ReactModule(hasConstants = false, name = "WebSocketModule")
public final class WebSocketModule extends NativeWebSocketModuleSpec {
    public static final String NAME = "WebSocketModule";
    public static final String TAG = "WebSocketModule";
    /* access modifiers changed from: private */
    public final Map<Integer, ContentHandler> mContentHandlers = new ConcurrentHashMap();
    private ForwardingCookieHandler mCookieHandler;
    /* access modifiers changed from: private */
    public final Map<Integer, WebSocket> mWebSocketConnections = new ConcurrentHashMap();

    public interface ContentHandler {
        void onMessage(String str, WritableMap writableMap);

        void onMessage(ByteString byteString, WritableMap writableMap);
    }

    public WebSocketModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.mCookieHandler = new ForwardingCookieHandler(reactApplicationContext);
    }

    private String getCookie(String str) {
        try {
            List list = this.mCookieHandler.get(new URI(getDefaultOrigin(str)), new HashMap()).get("Cookie");
            if (list == null) {
                return null;
            }
            if (list.isEmpty()) {
                return null;
            }
            return (String) list.get(0);
        } catch (IOException | URISyntaxException unused) {
            throw new IllegalArgumentException("Unable to get cookie from " + str);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0053 A[Catch:{ URISyntaxException -> 0x00bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x007e A[Catch:{ URISyntaxException -> 0x00bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0093 A[Catch:{ URISyntaxException -> 0x00bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00ae A[Catch:{ URISyntaxException -> 0x00bf }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String getDefaultOrigin(java.lang.String r12) {
        /*
            java.lang.String r0 = ""
            java.net.URI r1 = new java.net.URI     // Catch:{ URISyntaxException -> 0x00bf }
            r1.<init>(r12)     // Catch:{ URISyntaxException -> 0x00bf }
            java.lang.String r2 = r1.getScheme()     // Catch:{ URISyntaxException -> 0x00bf }
            int r3 = r2.hashCode()     // Catch:{ URISyntaxException -> 0x00bf }
            r4 = 3804(0xedc, float:5.33E-42)
            java.lang.String r5 = "https"
            java.lang.String r6 = "http"
            r7 = -1
            r8 = 0
            r9 = 3
            r10 = 2
            r11 = 1
            if (r3 == r4) goto L_0x0046
            r4 = 118039(0x1cd17, float:1.65408E-40)
            if (r3 == r4) goto L_0x003c
            r4 = 3213448(0x310888, float:4.503E-39)
            if (r3 == r4) goto L_0x0034
            r4 = 99617003(0x5f008eb, float:2.2572767E-35)
            if (r3 == r4) goto L_0x002c
            goto L_0x0050
        L_0x002c:
            boolean r2 = r2.equals(r5)     // Catch:{ URISyntaxException -> 0x00bf }
            if (r2 == 0) goto L_0x0050
            r2 = 3
            goto L_0x0051
        L_0x0034:
            boolean r2 = r2.equals(r6)     // Catch:{ URISyntaxException -> 0x00bf }
            if (r2 == 0) goto L_0x0050
            r2 = 2
            goto L_0x0051
        L_0x003c:
            java.lang.String r3 = "wss"
            boolean r2 = r2.equals(r3)     // Catch:{ URISyntaxException -> 0x00bf }
            if (r2 == 0) goto L_0x0050
            r2 = 0
            goto L_0x0051
        L_0x0046:
            java.lang.String r3 = "ws"
            boolean r2 = r2.equals(r3)     // Catch:{ URISyntaxException -> 0x00bf }
            if (r2 == 0) goto L_0x0050
            r2 = 1
            goto L_0x0051
        L_0x0050:
            r2 = -1
        L_0x0051:
            if (r2 == 0) goto L_0x007e
            if (r2 == r11) goto L_0x006e
            if (r2 == r10) goto L_0x005a
            if (r2 == r9) goto L_0x005a
            goto L_0x008d
        L_0x005a:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ URISyntaxException -> 0x00bf }
            r2.<init>()     // Catch:{ URISyntaxException -> 0x00bf }
            r2.append(r0)     // Catch:{ URISyntaxException -> 0x00bf }
            java.lang.String r0 = r1.getScheme()     // Catch:{ URISyntaxException -> 0x00bf }
            r2.append(r0)     // Catch:{ URISyntaxException -> 0x00bf }
            java.lang.String r0 = r2.toString()     // Catch:{ URISyntaxException -> 0x00bf }
            goto L_0x008d
        L_0x006e:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ URISyntaxException -> 0x00bf }
            r2.<init>()     // Catch:{ URISyntaxException -> 0x00bf }
            r2.append(r0)     // Catch:{ URISyntaxException -> 0x00bf }
            r2.append(r6)     // Catch:{ URISyntaxException -> 0x00bf }
            java.lang.String r0 = r2.toString()     // Catch:{ URISyntaxException -> 0x00bf }
            goto L_0x008d
        L_0x007e:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ URISyntaxException -> 0x00bf }
            r2.<init>()     // Catch:{ URISyntaxException -> 0x00bf }
            r2.append(r0)     // Catch:{ URISyntaxException -> 0x00bf }
            r2.append(r5)     // Catch:{ URISyntaxException -> 0x00bf }
            java.lang.String r0 = r2.toString()     // Catch:{ URISyntaxException -> 0x00bf }
        L_0x008d:
            int r2 = r1.getPort()     // Catch:{ URISyntaxException -> 0x00bf }
            if (r2 == r7) goto L_0x00ae
            java.lang.String r2 = "%s://%s:%s"
            java.lang.Object[] r3 = new java.lang.Object[r9]     // Catch:{ URISyntaxException -> 0x00bf }
            r3[r8] = r0     // Catch:{ URISyntaxException -> 0x00bf }
            java.lang.String r0 = r1.getHost()     // Catch:{ URISyntaxException -> 0x00bf }
            r3[r11] = r0     // Catch:{ URISyntaxException -> 0x00bf }
            int r0 = r1.getPort()     // Catch:{ URISyntaxException -> 0x00bf }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ URISyntaxException -> 0x00bf }
            r3[r10] = r0     // Catch:{ URISyntaxException -> 0x00bf }
            java.lang.String r12 = java.lang.String.format(r2, r3)     // Catch:{ URISyntaxException -> 0x00bf }
            goto L_0x00be
        L_0x00ae:
            java.lang.String r2 = "%s://%s"
            java.lang.Object[] r3 = new java.lang.Object[r10]     // Catch:{ URISyntaxException -> 0x00bf }
            r3[r8] = r0     // Catch:{ URISyntaxException -> 0x00bf }
            java.lang.String r0 = r1.getHost()     // Catch:{ URISyntaxException -> 0x00bf }
            r3[r11] = r0     // Catch:{ URISyntaxException -> 0x00bf }
            java.lang.String r12 = java.lang.String.format(r2, r3)     // Catch:{ URISyntaxException -> 0x00bf }
        L_0x00be:
            return r12
        L_0x00bf:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Unable to set "
            r1.append(r2)
            r1.append(r12)
            java.lang.String r12 = " as default origin header"
            r1.append(r12)
            java.lang.String r12 = r1.toString()
            r0.<init>(r12)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.modules.websocket.WebSocketModule.getDefaultOrigin(java.lang.String):java.lang.String");
    }

    /* access modifiers changed from: private */
    public void notifyWebSocketFailed(int i2, String str) {
        WritableMap createMap = Arguments.createMap();
        createMap.putInt("id", i2);
        createMap.putString("message", str);
        sendEvent("websocketFailed", createMap);
    }

    /* access modifiers changed from: private */
    public void sendEvent(String str, WritableMap writableMap) {
        ReactApplicationContext reactApplicationContextIfActiveOrWarn = getReactApplicationContextIfActiveOrWarn();
        if (reactApplicationContextIfActiveOrWarn != null) {
            ((DeviceEventManagerModule.RCTDeviceEventEmitter) reactApplicationContextIfActiveOrWarn.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(str, writableMap);
        }
    }

    public void addListener(String str) {
    }

    public void close(double d2, String str, double d3) {
        int i2 = (int) d3;
        WebSocket webSocket = this.mWebSocketConnections.get(Integer.valueOf(i2));
        if (webSocket != null) {
            try {
                webSocket.close((int) d2, str);
                this.mWebSocketConnections.remove(Integer.valueOf(i2));
                this.mContentHandlers.remove(Integer.valueOf(i2));
            } catch (Exception e2) {
                FLog.e(ReactConstants.TAG, "Could not close WebSocket connection for id " + i2, (Throwable) e2);
            }
        }
    }

    public void connect(String str, ReadableArray readableArray, ReadableMap readableMap, double d2) {
        boolean z2;
        final int i2 = (int) d2;
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        OkHttpClient build = builder.connectTimeout(10, timeUnit).writeTimeout(10, timeUnit).readTimeout(0, TimeUnit.MINUTES).build();
        Request.Builder url = new Request.Builder().tag(Integer.valueOf(i2)).url(str);
        String cookie = getCookie(str);
        if (cookie != null) {
            url.addHeader("Cookie", cookie);
        }
        if (readableMap == null || !readableMap.hasKey("headers") || !readableMap.getType("headers").equals(ReadableType.Map)) {
            z2 = false;
        } else {
            ReadableMap map = readableMap.getMap("headers");
            ReadableMapKeySetIterator keySetIterator = map.keySetIterator();
            z2 = false;
            while (keySetIterator.hasNextKey()) {
                String nextKey = keySetIterator.nextKey();
                if (ReadableType.String.equals(map.getType(nextKey))) {
                    if (nextKey.equalsIgnoreCase("origin")) {
                        z2 = true;
                    }
                    url.addHeader(nextKey, map.getString(nextKey));
                } else {
                    FLog.w(ReactConstants.TAG, "Ignoring: requested " + nextKey + ", value not a string");
                }
            }
        }
        if (!z2) {
            url.addHeader("origin", getDefaultOrigin(str));
        }
        if (readableArray != null && readableArray.size() > 0) {
            StringBuilder sb = new StringBuilder("");
            for (int i3 = 0; i3 < readableArray.size(); i3++) {
                String trim = readableArray.getString(i3).trim();
                if (!trim.isEmpty() && !trim.contains(",")) {
                    sb.append(trim);
                    sb.append(",");
                }
            }
            if (sb.length() > 0) {
                sb.replace(sb.length() - 1, sb.length(), "");
                url.addHeader("Sec-WebSocket-Protocol", sb.toString());
            }
        }
        build.newWebSocket(url.build(), new WebSocketListener() {
            public void onClosed(WebSocket webSocket, int i2, String str) {
                WritableMap createMap = Arguments.createMap();
                createMap.putInt("id", i2);
                createMap.putInt("code", i2);
                createMap.putString("reason", str);
                WebSocketModule.this.sendEvent("websocketClosed", createMap);
            }

            public void onClosing(WebSocket webSocket, int i2, String str) {
                webSocket.close(i2, str);
            }

            public void onFailure(WebSocket webSocket, Throwable th, Response response) {
                WebSocketModule.this.notifyWebSocketFailed(i2, th.getMessage());
            }

            public void onMessage(WebSocket webSocket, String str) {
                WritableMap createMap = Arguments.createMap();
                createMap.putInt("id", i2);
                createMap.putString("type", "text");
                ContentHandler contentHandler = (ContentHandler) WebSocketModule.this.mContentHandlers.get(Integer.valueOf(i2));
                if (contentHandler != null) {
                    contentHandler.onMessage(str, createMap);
                } else {
                    createMap.putString("data", str);
                }
                WebSocketModule.this.sendEvent("websocketMessage", createMap);
            }

            public void onOpen(WebSocket webSocket, Response response) {
                WebSocketModule.this.mWebSocketConnections.put(Integer.valueOf(i2), webSocket);
                WritableMap createMap = Arguments.createMap();
                createMap.putInt("id", i2);
                createMap.putString("protocol", response.header("Sec-WebSocket-Protocol", ""));
                WebSocketModule.this.sendEvent("websocketOpen", createMap);
            }

            public void onMessage(WebSocket webSocket, ByteString byteString) {
                WritableMap createMap = Arguments.createMap();
                createMap.putInt("id", i2);
                createMap.putString("type", "binary");
                ContentHandler contentHandler = (ContentHandler) WebSocketModule.this.mContentHandlers.get(Integer.valueOf(i2));
                if (contentHandler != null) {
                    contentHandler.onMessage(byteString, createMap);
                } else {
                    createMap.putString("data", byteString.a());
                }
                WebSocketModule.this.sendEvent("websocketMessage", createMap);
            }
        });
        build.dispatcher().executorService().shutdown();
    }

    public String getName() {
        return "WebSocketModule";
    }

    public void ping(double d2) {
        int i2 = (int) d2;
        WebSocket webSocket = this.mWebSocketConnections.get(Integer.valueOf(i2));
        if (webSocket == null) {
            WritableMap createMap = Arguments.createMap();
            createMap.putInt("id", i2);
            createMap.putString("message", "client is null");
            sendEvent("websocketFailed", createMap);
            WritableMap createMap2 = Arguments.createMap();
            createMap2.putInt("id", i2);
            createMap2.putInt("code", 0);
            createMap2.putString("reason", "client is null");
            sendEvent("websocketClosed", createMap2);
            this.mWebSocketConnections.remove(Integer.valueOf(i2));
            this.mContentHandlers.remove(Integer.valueOf(i2));
            return;
        }
        try {
            webSocket.send(ByteString.f41332f);
        } catch (Exception e2) {
            notifyWebSocketFailed(i2, e2.getMessage());
        }
    }

    public void removeListeners(double d2) {
    }

    public void send(String str, double d2) {
        int i2 = (int) d2;
        WebSocket webSocket = this.mWebSocketConnections.get(Integer.valueOf(i2));
        if (webSocket == null) {
            WritableMap createMap = Arguments.createMap();
            createMap.putInt("id", i2);
            createMap.putString("message", "client is null");
            sendEvent("websocketFailed", createMap);
            WritableMap createMap2 = Arguments.createMap();
            createMap2.putInt("id", i2);
            createMap2.putInt("code", 0);
            createMap2.putString("reason", "client is null");
            sendEvent("websocketClosed", createMap2);
            this.mWebSocketConnections.remove(Integer.valueOf(i2));
            this.mContentHandlers.remove(Integer.valueOf(i2));
            return;
        }
        try {
            webSocket.send(str);
        } catch (Exception e2) {
            notifyWebSocketFailed(i2, e2.getMessage());
        }
    }

    public void sendBinary(String str, double d2) {
        int i2 = (int) d2;
        WebSocket webSocket = this.mWebSocketConnections.get(Integer.valueOf(i2));
        if (webSocket == null) {
            WritableMap createMap = Arguments.createMap();
            createMap.putInt("id", i2);
            createMap.putString("message", "client is null");
            sendEvent("websocketFailed", createMap);
            WritableMap createMap2 = Arguments.createMap();
            createMap2.putInt("id", i2);
            createMap2.putInt("code", 0);
            createMap2.putString("reason", "client is null");
            sendEvent("websocketClosed", createMap2);
            this.mWebSocketConnections.remove(Integer.valueOf(i2));
            this.mContentHandlers.remove(Integer.valueOf(i2));
            return;
        }
        try {
            webSocket.send(ByteString.c(str));
        } catch (Exception e2) {
            notifyWebSocketFailed(i2, e2.getMessage());
        }
    }

    public void setContentHandler(int i2, ContentHandler contentHandler) {
        if (contentHandler != null) {
            this.mContentHandlers.put(Integer.valueOf(i2), contentHandler);
        } else {
            this.mContentHandlers.remove(Integer.valueOf(i2));
        }
    }

    public void sendBinary(ByteString byteString, int i2) {
        WebSocket webSocket = this.mWebSocketConnections.get(Integer.valueOf(i2));
        if (webSocket == null) {
            WritableMap createMap = Arguments.createMap();
            createMap.putInt("id", i2);
            createMap.putString("message", "client is null");
            sendEvent("websocketFailed", createMap);
            WritableMap createMap2 = Arguments.createMap();
            createMap2.putInt("id", i2);
            createMap2.putInt("code", 0);
            createMap2.putString("reason", "client is null");
            sendEvent("websocketClosed", createMap2);
            this.mWebSocketConnections.remove(Integer.valueOf(i2));
            this.mContentHandlers.remove(Integer.valueOf(i2));
            return;
        }
        try {
            webSocket.send(byteString);
        } catch (Exception e2) {
            notifyWebSocketFailed(i2, e2.getMessage());
        }
    }
}
