package okhttp3;

import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;

public abstract class WebSocketListener {
    public void onClosed(WebSocket webSocket, int i2, String str) {
        Intrinsics.f(webSocket, "webSocket");
        Intrinsics.f(str, "reason");
    }

    public void onClosing(WebSocket webSocket, int i2, String str) {
        Intrinsics.f(webSocket, "webSocket");
        Intrinsics.f(str, "reason");
    }

    public void onFailure(WebSocket webSocket, Throwable th, Response response) {
        Intrinsics.f(webSocket, "webSocket");
        Intrinsics.f(th, "t");
    }

    public void onMessage(WebSocket webSocket, String str) {
        Intrinsics.f(webSocket, "webSocket");
        Intrinsics.f(str, "text");
    }

    public void onMessage(WebSocket webSocket, ByteString byteString) {
        Intrinsics.f(webSocket, "webSocket");
        Intrinsics.f(byteString, "bytes");
    }

    public void onOpen(WebSocket webSocket, Response response) {
        Intrinsics.f(webSocket, "webSocket");
        Intrinsics.f(response, "response");
    }
}
