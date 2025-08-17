package com.google.android.datatransport.runtime;

import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.Event;
import com.google.android.datatransport.Transformer;
import com.google.android.datatransport.Transport;
import com.google.android.datatransport.TransportScheduleCallback;

final class TransportImpl<T> implements Transport<T> {

    /* renamed from: a  reason: collision with root package name */
    private final TransportContext f22520a;

    /* renamed from: b  reason: collision with root package name */
    private final String f22521b;

    /* renamed from: c  reason: collision with root package name */
    private final Encoding f22522c;

    /* renamed from: d  reason: collision with root package name */
    private final Transformer<T, byte[]> f22523d;

    /* renamed from: e  reason: collision with root package name */
    private final TransportInternal f22524e;

    TransportImpl(TransportContext transportContext, String str, Encoding encoding, Transformer<T, byte[]> transformer, TransportInternal transportInternal) {
        this.f22520a = transportContext;
        this.f22521b = str;
        this.f22522c = encoding;
        this.f22523d = transformer;
        this.f22524e = transportInternal;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void c(Exception exc) {
    }

    public void a(Event<T> event) {
        d(event, new a());
    }

    public void d(Event<T> event, TransportScheduleCallback transportScheduleCallback) {
        this.f22524e.a(SendRequest.a().e(this.f22520a).c(event).f(this.f22521b).d(this.f22523d).b(this.f22522c).a(), transportScheduleCallback);
    }
}
