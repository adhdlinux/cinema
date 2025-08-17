package okhttp3;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSink;

public final class FormBody extends RequestBody {
    private static final MediaType CONTENT_TYPE = MediaType.Companion.get("application/x-www-form-urlencoded");
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final List<String> encodedNames;
    private final List<String> encodedValues;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public FormBody(List<String> list, List<String> list2) {
        Intrinsics.f(list, "encodedNames");
        Intrinsics.f(list2, "encodedValues");
        this.encodedNames = Util.toImmutableList(list);
        this.encodedValues = Util.toImmutableList(list2);
    }

    private final long writeOrCountBytes(BufferedSink bufferedSink, boolean z2) {
        Buffer buffer;
        if (z2) {
            buffer = new Buffer();
        } else {
            Intrinsics.c(bufferedSink);
            buffer = bufferedSink.c();
        }
        int size = this.encodedNames.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (i2 > 0) {
                buffer.writeByte(38);
            }
            buffer.w(this.encodedNames.get(i2));
            buffer.writeByte(61);
            buffer.w(this.encodedValues.get(i2));
        }
        if (!z2) {
            return 0;
        }
        long size2 = buffer.size();
        buffer.a();
        return size2;
    }

    /* renamed from: -deprecated_size  reason: not valid java name */
    public final int m264deprecated_size() {
        return size();
    }

    public long contentLength() {
        return writeOrCountBytes((BufferedSink) null, true);
    }

    public MediaType contentType() {
        return CONTENT_TYPE;
    }

    public final String encodedName(int i2) {
        return this.encodedNames.get(i2);
    }

    public final String encodedValue(int i2) {
        return this.encodedValues.get(i2);
    }

    public final String name(int i2) {
        return HttpUrl.Companion.percentDecode$okhttp$default(HttpUrl.Companion, encodedName(i2), 0, 0, true, 3, (Object) null);
    }

    public final int size() {
        return this.encodedNames.size();
    }

    public final String value(int i2) {
        return HttpUrl.Companion.percentDecode$okhttp$default(HttpUrl.Companion, encodedValue(i2), 0, 0, true, 3, (Object) null);
    }

    public void writeTo(BufferedSink bufferedSink) throws IOException {
        Intrinsics.f(bufferedSink, "sink");
        writeOrCountBytes(bufferedSink, false);
    }

    public static final class Builder {
        private final Charset charset;
        private final List<String> names;
        private final List<String> values;

        public Builder() {
            this((Charset) null, 1, (DefaultConstructorMarker) null);
        }

        public Builder(Charset charset2) {
            this.charset = charset2;
            this.names = new ArrayList();
            this.values = new ArrayList();
        }

        public final Builder add(String str, String str2) {
            String str3 = str;
            Intrinsics.f(str3, "name");
            Intrinsics.f(str2, AppMeasurementSdk.ConditionalUserProperty.VALUE);
            HttpUrl.Companion companion = HttpUrl.Companion;
            this.names.add(HttpUrl.Companion.canonicalize$okhttp$default(companion, str3, 0, 0, HttpUrl.FORM_ENCODE_SET, false, false, true, false, this.charset, 91, (Object) null));
            this.values.add(HttpUrl.Companion.canonicalize$okhttp$default(companion, str2, 0, 0, HttpUrl.FORM_ENCODE_SET, false, false, true, false, this.charset, 91, (Object) null));
            return this;
        }

        public final Builder addEncoded(String str, String str2) {
            String str3 = str;
            Intrinsics.f(str3, "name");
            Intrinsics.f(str2, AppMeasurementSdk.ConditionalUserProperty.VALUE);
            HttpUrl.Companion companion = HttpUrl.Companion;
            this.names.add(HttpUrl.Companion.canonicalize$okhttp$default(companion, str3, 0, 0, HttpUrl.FORM_ENCODE_SET, true, false, true, false, this.charset, 83, (Object) null));
            this.values.add(HttpUrl.Companion.canonicalize$okhttp$default(companion, str2, 0, 0, HttpUrl.FORM_ENCODE_SET, true, false, true, false, this.charset, 83, (Object) null));
            return this;
        }

        public final FormBody build() {
            return new FormBody(this.names, this.values);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Builder(Charset charset2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? null : charset2);
        }
    }
}
