package kotlinx.serialization.json;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.Serializable;

@Serializable(with = JsonPrimitiveSerializer.class)
public abstract class JsonPrimitive extends JsonElement {

    /* renamed from: c  reason: collision with root package name */
    public static final Companion f41181c = new Companion((DefaultConstructorMarker) null);

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private JsonPrimitive() {
        super((DefaultConstructorMarker) null);
    }

    public /* synthetic */ JsonPrimitive(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract String a();

    public String toString() {
        return a();
    }
}
