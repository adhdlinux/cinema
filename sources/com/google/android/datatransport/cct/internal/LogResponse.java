package com.google.android.datatransport.cct.internal;

import android.util.JsonReader;
import android.util.JsonToken;
import com.google.auto.value.AutoValue;
import java.io.IOException;
import java.io.Reader;

@AutoValue
public abstract class LogResponse {
    static LogResponse a(long j2) {
        return new AutoValue_LogResponse(j2);
    }

    public static LogResponse b(Reader reader) throws IOException {
        JsonReader jsonReader = new JsonReader(reader);
        try {
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                if (!jsonReader.nextName().equals("nextRequestWaitMillis")) {
                    jsonReader.skipValue();
                } else if (jsonReader.peek() == JsonToken.STRING) {
                    return a(Long.parseLong(jsonReader.nextString()));
                } else {
                    LogResponse a2 = a(jsonReader.nextLong());
                    jsonReader.close();
                    return a2;
                }
            }
            throw new IOException("Response is missing nextRequestWaitMillis field.");
        } finally {
            jsonReader.close();
        }
    }

    public abstract long c();
}
