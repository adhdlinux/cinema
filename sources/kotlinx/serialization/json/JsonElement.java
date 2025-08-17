package kotlinx.serialization.json;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.Serializable;

@Serializable(with = JsonElementSerializer.class)
public abstract class JsonElement {

    /* renamed from: b  reason: collision with root package name */
    public static final Companion f41152b = new Companion((DefaultConstructorMarker) null);

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private JsonElement() {
    }

    public /* synthetic */ JsonElement(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
