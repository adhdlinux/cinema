package kotlinx.serialization.json;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.modules.SerializersModule;

public final class JsonBuilder {

    /* renamed from: a  reason: collision with root package name */
    private boolean f41127a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f41128b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f41129c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f41130d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f41131e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f41132f;

    /* renamed from: g  reason: collision with root package name */
    private String f41133g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f41134h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f41135i;

    /* renamed from: j  reason: collision with root package name */
    private String f41136j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f41137k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f41138l;

    /* renamed from: m  reason: collision with root package name */
    private SerializersModule f41139m;

    public JsonBuilder(Json json) {
        Intrinsics.f(json, "json");
        this.f41127a = json.e().e();
        this.f41128b = json.e().f();
        this.f41129c = json.e().g();
        this.f41130d = json.e().l();
        this.f41131e = json.e().b();
        this.f41132f = json.e().h();
        this.f41133g = json.e().i();
        this.f41134h = json.e().d();
        this.f41135i = json.e().k();
        this.f41136j = json.e().c();
        this.f41137k = json.e().a();
        this.f41138l = json.e().j();
        this.f41139m = json.a();
    }

    public final JsonConfiguration a() {
        if (!this.f41135i || Intrinsics.a(this.f41136j, "type")) {
            if (!this.f41132f) {
                if (!Intrinsics.a(this.f41133g, "    ")) {
                    throw new IllegalArgumentException("Indent should not be specified when default printing mode is used".toString());
                }
            } else if (!Intrinsics.a(this.f41133g, "    ")) {
                String str = this.f41133g;
                boolean z2 = false;
                int i2 = 0;
                while (true) {
                    boolean z3 = true;
                    if (i2 >= str.length()) {
                        z2 = true;
                        break;
                    }
                    char charAt = str.charAt(i2);
                    if (!(charAt == ' ' || charAt == 9 || charAt == 13 || charAt == 10)) {
                        z3 = false;
                    }
                    if (!z3) {
                        break;
                    }
                    i2++;
                }
                if (!z2) {
                    throw new IllegalArgumentException(("Only whitespace, tab, newline and carriage return are allowed as pretty print symbols. Had " + this.f41133g).toString());
                }
            }
            return new JsonConfiguration(this.f41127a, this.f41129c, this.f41130d, this.f41131e, this.f41132f, this.f41128b, this.f41133g, this.f41134h, this.f41135i, this.f41136j, this.f41137k, this.f41138l);
        }
        throw new IllegalArgumentException("Class discriminator should not be specified when array polymorphism is specified".toString());
    }

    public final SerializersModule b() {
        return this.f41139m;
    }

    public final void c(boolean z2) {
        this.f41131e = z2;
    }

    public final void d(boolean z2) {
        this.f41127a = z2;
    }

    public final void e(boolean z2) {
        this.f41128b = z2;
    }

    public final void f(boolean z2) {
        this.f41129c = z2;
    }
}
