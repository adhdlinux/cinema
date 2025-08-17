package com.google.android.datatransport.runtime.backends;

import android.content.Context;
import com.google.android.datatransport.runtime.time.Clock;
import javax.inject.Inject;

class CreationContextFactory {

    /* renamed from: a  reason: collision with root package name */
    private final Context f22550a;

    /* renamed from: b  reason: collision with root package name */
    private final Clock f22551b;

    /* renamed from: c  reason: collision with root package name */
    private final Clock f22552c;

    @Inject
    CreationContextFactory(Context context, Clock clock, Clock clock2) {
        this.f22550a = context;
        this.f22551b = clock;
        this.f22552c = clock2;
    }

    /* access modifiers changed from: package-private */
    public CreationContext a(String str) {
        return CreationContext.a(this.f22550a, this.f22551b, this.f22552c, str);
    }
}
