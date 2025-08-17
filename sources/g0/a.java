package g0;

import com.google.android.datatransport.TransportScheduleCallback;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.scheduling.DefaultScheduler;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DefaultScheduler f29065b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TransportContext f29066c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ TransportScheduleCallback f29067d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ EventInternal f29068e;

    public /* synthetic */ a(DefaultScheduler defaultScheduler, TransportContext transportContext, TransportScheduleCallback transportScheduleCallback, EventInternal eventInternal) {
        this.f29065b = defaultScheduler;
        this.f29066c = transportContext;
        this.f29067d = transportScheduleCallback;
        this.f29068e = eventInternal;
    }

    public final void run() {
        this.f29065b.e(this.f29066c, this.f29067d, this.f29068e);
    }
}
