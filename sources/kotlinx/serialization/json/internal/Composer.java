package kotlinx.serialization.json.internal;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.jvm.internal.Intrinsics;

public class Composer {

    /* renamed from: a  reason: collision with root package name */
    public final JsonWriter f41206a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f41207b = true;

    public Composer(JsonWriter jsonWriter) {
        Intrinsics.f(jsonWriter, "writer");
        this.f41206a = jsonWriter;
    }

    public final boolean a() {
        return this.f41207b;
    }

    public void b() {
        this.f41207b = true;
    }

    public void c() {
        this.f41207b = false;
    }

    public void d(byte b2) {
        this.f41206a.writeLong((long) b2);
    }

    public final void e(char c2) {
        this.f41206a.a(c2);
    }

    public void f(double d2) {
        this.f41206a.c(String.valueOf(d2));
    }

    public void g(float f2) {
        this.f41206a.c(String.valueOf(f2));
    }

    public void h(int i2) {
        this.f41206a.writeLong((long) i2);
    }

    public void i(long j2) {
        this.f41206a.writeLong(j2);
    }

    public final void j(String str) {
        Intrinsics.f(str, "v");
        this.f41206a.c(str);
    }

    public void k(short s2) {
        this.f41206a.writeLong((long) s2);
    }

    public void l(boolean z2) {
        this.f41206a.c(String.valueOf(z2));
    }

    public final void m(String str) {
        Intrinsics.f(str, AppMeasurementSdk.ConditionalUserProperty.VALUE);
        this.f41206a.b(str);
    }

    /* access modifiers changed from: protected */
    public final void n(boolean z2) {
        this.f41207b = z2;
    }

    public void o() {
    }

    public void p() {
    }
}
