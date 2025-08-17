package kotlinx.serialization.json.internal;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.Json;

public final class ComposerWithPrettyPrint extends Composer {

    /* renamed from: c  reason: collision with root package name */
    private final Json f41209c;

    /* renamed from: d  reason: collision with root package name */
    private int f41210d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ComposerWithPrettyPrint(JsonWriter jsonWriter, Json json) {
        super(jsonWriter);
        Intrinsics.f(jsonWriter, "writer");
        Intrinsics.f(json, "json");
        this.f41209c = json;
    }

    public void b() {
        n(true);
        this.f41210d++;
    }

    public void c() {
        n(false);
        j(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
        int i2 = this.f41210d;
        for (int i3 = 0; i3 < i2; i3++) {
            j(this.f41209c.e().i());
        }
    }

    public void o() {
        e(' ');
    }

    public void p() {
        this.f41210d--;
    }
}
