package retrofit2.converter.gson;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.Buffer;
import retrofit2.Converter;

final class GsonRequestBodyConverter<T> implements Converter<T, RequestBody> {
    private static final MediaType MEDIA_TYPE = MediaType.get("application/json; charset=UTF-8");
    private final TypeAdapter<T> adapter;
    private final Gson gson;

    GsonRequestBodyConverter(Gson gson2, TypeAdapter<T> typeAdapter) {
        this.gson = gson2;
        this.adapter = typeAdapter;
    }

    public RequestBody convert(T t2) throws IOException {
        Buffer buffer = new Buffer();
        JsonWriter s2 = this.gson.s(new OutputStreamWriter(buffer.k0(), StandardCharsets.UTF_8));
        this.adapter.write(s2, t2);
        s2.close();
        return RequestBody.create(MEDIA_TYPE, buffer.c0());
    }
}
