package kotlinx.serialization.json;

import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Encoder;

public interface JsonEncoder extends Encoder, CompositeEncoder {
    void A(JsonElement jsonElement);

    Json d();
}
