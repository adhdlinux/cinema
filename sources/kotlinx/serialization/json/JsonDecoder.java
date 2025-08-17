package kotlinx.serialization.json;

import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.Decoder;

public interface JsonDecoder extends Decoder, CompositeDecoder {
    Json d();

    JsonElement g();
}
