package com.facebook.ads.internal.view.f.c;

import android.content.Context;
import android.widget.TextView;
import com.facebook.ads.internal.j.f;
import com.facebook.ads.internal.view.f.b.n;
import java.util.concurrent.TimeUnit;

public class c extends com.facebook.ads.internal.view.f.a.c {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final TextView f21363a;

    /* renamed from: b  reason: collision with root package name */
    private final String f21364b;

    /* renamed from: c  reason: collision with root package name */
    private final f<n> f21365c = new f<n>() {
        public Class<n> a() {
            return n.class;
        }

        public void a(n nVar) {
            if (c.this.getVideoView() != null) {
                TextView d2 = c.this.f21363a;
                c cVar = c.this;
                d2.setText(cVar.a((long) (cVar.getVideoView().getDuration() - c.this.getVideoView().getCurrentPositionInMillis())));
            }
        }
    };

    public c(Context context, String str) {
        super(context);
        TextView textView = new TextView(context);
        this.f21363a = textView;
        this.f21364b = str;
        addView(textView);
    }

    /* access modifiers changed from: private */
    public String a(long j2) {
        if (j2 <= 0) {
            return "00:00";
        }
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        long minutes = timeUnit.toMinutes(j2);
        long seconds = timeUnit.toSeconds(j2 % 60000);
        if (this.f21364b.isEmpty()) {
            return String.format("%02d:%02d", new Object[]{Long.valueOf(minutes), Long.valueOf(seconds)});
        }
        return this.f21364b.replace("{{REMAINING_TIME}}", String.format("%02d:%02d", new Object[]{Long.valueOf(minutes), Long.valueOf(seconds)}));
    }

    /* access modifiers changed from: protected */
    public void a() {
        super.a();
        if (getVideoView() != null) {
            getVideoView().getEventBus().a(this.f21365c);
        }
    }

    /* access modifiers changed from: protected */
    public void b() {
        if (getVideoView() != null) {
            getVideoView().getEventBus().b(this.f21365c);
        }
        super.b();
    }

    public void setCountdownTextColor(int i2) {
        this.f21363a.setTextColor(i2);
    }
}
