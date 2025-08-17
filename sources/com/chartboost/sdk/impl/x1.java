package com.chartboost.sdk.impl;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebViewClient;
import b0.s0;
import kotlin.jvm.internal.Intrinsics;

public final class x1 extends z2 {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public x1(Context context) {
        super(context);
        Intrinsics.f(context, "context");
    }

    public static final boolean a(ya yaVar, View view, MotionEvent motionEvent) {
        if (yaVar != null) {
            Intrinsics.e(motionEvent, "motionEvent");
            yaVar.a(motionEvent);
        }
        if (motionEvent.getAction() == 2) {
            return true;
        }
        return false;
    }

    public void setWebViewClient(WebViewClient webViewClient) {
        ya yaVar;
        Intrinsics.f(webViewClient, "client");
        super.setWebViewClient(webViewClient);
        if (webViewClient instanceof y1) {
            yaVar = ((y1) webViewClient).a();
        } else {
            yaVar = null;
        }
        setOnTouchListener(new s0(yaVar));
    }
}
