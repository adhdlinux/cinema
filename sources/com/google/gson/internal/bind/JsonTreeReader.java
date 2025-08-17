package com.google.gson.internal.bind;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;

public final class JsonTreeReader extends JsonReader {

    /* renamed from: f  reason: collision with root package name */
    private static final Reader f31008f = new Reader() {
        public void close() {
            throw new AssertionError();
        }

        public int read(char[] cArr, int i2, int i3) {
            throw new AssertionError();
        }
    };

    /* renamed from: g  reason: collision with root package name */
    private static final Object f31009g = new Object();

    /* renamed from: b  reason: collision with root package name */
    private Object[] f31010b = new Object[32];

    /* renamed from: c  reason: collision with root package name */
    private int f31011c = 0;

    /* renamed from: d  reason: collision with root package name */
    private String[] f31012d = new String[32];

    /* renamed from: e  reason: collision with root package name */
    private int[] f31013e = new int[32];

    /* renamed from: com.google.gson.internal.bind.JsonTreeReader$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f31014a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.google.gson.stream.JsonToken[] r0 = com.google.gson.stream.JsonToken.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f31014a = r0
                com.google.gson.stream.JsonToken r1 = com.google.gson.stream.JsonToken.NAME     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f31014a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.gson.stream.JsonToken r1 = com.google.gson.stream.JsonToken.END_ARRAY     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f31014a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.gson.stream.JsonToken r1 = com.google.gson.stream.JsonToken.END_OBJECT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f31014a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.google.gson.stream.JsonToken r1 = com.google.gson.stream.JsonToken.END_DOCUMENT     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.bind.JsonTreeReader.AnonymousClass2.<clinit>():void");
        }
    }

    public JsonTreeReader(JsonElement jsonElement) {
        super(f31008f);
        v(jsonElement);
    }

    private void a(JsonToken jsonToken) throws IOException {
        if (peek() != jsonToken) {
            throw new IllegalStateException("Expected " + jsonToken + " but was " + peek() + locationString());
        }
    }

    private String getPath(boolean z2) {
        StringBuilder sb = new StringBuilder();
        sb.append('$');
        int i2 = 0;
        while (true) {
            int i3 = this.f31011c;
            if (i2 >= i3) {
                return sb.toString();
            }
            Object[] objArr = this.f31010b;
            Object obj = objArr[i2];
            if (obj instanceof JsonArray) {
                i2++;
                if (i2 < i3 && (objArr[i2] instanceof Iterator)) {
                    int i4 = this.f31013e[i2];
                    if (z2 && i4 > 0 && (i2 == i3 - 1 || i2 == i3 - 2)) {
                        i4--;
                    }
                    sb.append('[');
                    sb.append(i4);
                    sb.append(']');
                }
            } else if ((obj instanceof JsonObject) && (i2 = i2 + 1) < i3 && (objArr[i2] instanceof Iterator)) {
                sb.append('.');
                String str = this.f31012d[i2];
                if (str != null) {
                    sb.append(str);
                }
            }
            i2++;
        }
    }

    private String i(boolean z2) throws IOException {
        String str;
        a(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) k()).next();
        String str2 = (String) entry.getKey();
        String[] strArr = this.f31012d;
        int i2 = this.f31011c - 1;
        if (z2) {
            str = "<skipped>";
        } else {
            str = str2;
        }
        strArr[i2] = str;
        v(entry.getValue());
        return str2;
    }

    private Object k() {
        return this.f31010b[this.f31011c - 1];
    }

    private String locationString() {
        return " at path " + getPath();
    }

    private Object q() {
        Object[] objArr = this.f31010b;
        int i2 = this.f31011c - 1;
        this.f31011c = i2;
        Object obj = objArr[i2];
        objArr[i2] = null;
        return obj;
    }

    private void v(Object obj) {
        int i2 = this.f31011c;
        Object[] objArr = this.f31010b;
        if (i2 == objArr.length) {
            int i3 = i2 * 2;
            this.f31010b = Arrays.copyOf(objArr, i3);
            this.f31013e = Arrays.copyOf(this.f31013e, i3);
            this.f31012d = (String[]) Arrays.copyOf(this.f31012d, i3);
        }
        Object[] objArr2 = this.f31010b;
        int i4 = this.f31011c;
        this.f31011c = i4 + 1;
        objArr2[i4] = obj;
    }

    public void beginArray() throws IOException {
        a(JsonToken.BEGIN_ARRAY);
        v(((JsonArray) k()).iterator());
        this.f31013e[this.f31011c - 1] = 0;
    }

    public void beginObject() throws IOException {
        a(JsonToken.BEGIN_OBJECT);
        v(((JsonObject) k()).l().iterator());
    }

    public void close() throws IOException {
        this.f31010b = new Object[]{f31009g};
        this.f31011c = 1;
    }

    public void endArray() throws IOException {
        a(JsonToken.END_ARRAY);
        q();
        q();
        int i2 = this.f31011c;
        if (i2 > 0) {
            int[] iArr = this.f31013e;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
        }
    }

    public void endObject() throws IOException {
        a(JsonToken.END_OBJECT);
        this.f31012d[this.f31011c - 1] = null;
        q();
        q();
        int i2 = this.f31011c;
        if (i2 > 0) {
            int[] iArr = this.f31013e;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
        }
    }

    /* access modifiers changed from: package-private */
    public JsonElement f() throws IOException {
        JsonToken peek = peek();
        if (peek == JsonToken.NAME || peek == JsonToken.END_ARRAY || peek == JsonToken.END_OBJECT || peek == JsonToken.END_DOCUMENT) {
            throw new IllegalStateException("Unexpected " + peek + " when reading a JsonElement.");
        }
        JsonElement jsonElement = (JsonElement) k();
        skipValue();
        return jsonElement;
    }

    public String getPreviousPath() {
        return getPath(true);
    }

    public boolean hasNext() throws IOException {
        JsonToken peek = peek();
        if (peek == JsonToken.END_OBJECT || peek == JsonToken.END_ARRAY || peek == JsonToken.END_DOCUMENT) {
            return false;
        }
        return true;
    }

    public boolean nextBoolean() throws IOException {
        a(JsonToken.BOOLEAN);
        boolean m2 = ((JsonPrimitive) q()).m();
        int i2 = this.f31011c;
        if (i2 > 0) {
            int[] iArr = this.f31013e;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
        }
        return m2;
    }

    public double nextDouble() throws IOException {
        JsonToken peek = peek();
        JsonToken jsonToken = JsonToken.NUMBER;
        if (peek == jsonToken || peek == JsonToken.STRING) {
            double n2 = ((JsonPrimitive) k()).n();
            if (isLenient() || (!Double.isNaN(n2) && !Double.isInfinite(n2))) {
                q();
                int i2 = this.f31011c;
                if (i2 > 0) {
                    int[] iArr = this.f31013e;
                    int i3 = i2 - 1;
                    iArr[i3] = iArr[i3] + 1;
                }
                return n2;
            }
            throw new MalformedJsonException("JSON forbids NaN and infinities: " + n2);
        }
        throw new IllegalStateException("Expected " + jsonToken + " but was " + peek + locationString());
    }

    public int nextInt() throws IOException {
        JsonToken peek = peek();
        JsonToken jsonToken = JsonToken.NUMBER;
        if (peek == jsonToken || peek == JsonToken.STRING) {
            int a2 = ((JsonPrimitive) k()).a();
            q();
            int i2 = this.f31011c;
            if (i2 > 0) {
                int[] iArr = this.f31013e;
                int i3 = i2 - 1;
                iArr[i3] = iArr[i3] + 1;
            }
            return a2;
        }
        throw new IllegalStateException("Expected " + jsonToken + " but was " + peek + locationString());
    }

    public long nextLong() throws IOException {
        JsonToken peek = peek();
        JsonToken jsonToken = JsonToken.NUMBER;
        if (peek == jsonToken || peek == JsonToken.STRING) {
            long o2 = ((JsonPrimitive) k()).o();
            q();
            int i2 = this.f31011c;
            if (i2 > 0) {
                int[] iArr = this.f31013e;
                int i3 = i2 - 1;
                iArr[i3] = iArr[i3] + 1;
            }
            return o2;
        }
        throw new IllegalStateException("Expected " + jsonToken + " but was " + peek + locationString());
    }

    public String nextName() throws IOException {
        return i(false);
    }

    public void nextNull() throws IOException {
        a(JsonToken.NULL);
        q();
        int i2 = this.f31011c;
        if (i2 > 0) {
            int[] iArr = this.f31013e;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
        }
    }

    public String nextString() throws IOException {
        JsonToken peek = peek();
        JsonToken jsonToken = JsonToken.STRING;
        if (peek == jsonToken || peek == JsonToken.NUMBER) {
            String e2 = ((JsonPrimitive) q()).e();
            int i2 = this.f31011c;
            if (i2 > 0) {
                int[] iArr = this.f31013e;
                int i3 = i2 - 1;
                iArr[i3] = iArr[i3] + 1;
            }
            return e2;
        }
        throw new IllegalStateException("Expected " + jsonToken + " but was " + peek + locationString());
    }

    public JsonToken peek() throws IOException {
        if (this.f31011c == 0) {
            return JsonToken.END_DOCUMENT;
        }
        Object k2 = k();
        if (k2 instanceof Iterator) {
            boolean z2 = this.f31010b[this.f31011c - 2] instanceof JsonObject;
            Iterator it2 = (Iterator) k2;
            if (it2.hasNext()) {
                if (z2) {
                    return JsonToken.NAME;
                }
                v(it2.next());
                return peek();
            } else if (z2) {
                return JsonToken.END_OBJECT;
            } else {
                return JsonToken.END_ARRAY;
            }
        } else if (k2 instanceof JsonObject) {
            return JsonToken.BEGIN_OBJECT;
        } else {
            if (k2 instanceof JsonArray) {
                return JsonToken.BEGIN_ARRAY;
            }
            if (k2 instanceof JsonPrimitive) {
                JsonPrimitive jsonPrimitive = (JsonPrimitive) k2;
                if (jsonPrimitive.t()) {
                    return JsonToken.STRING;
                }
                if (jsonPrimitive.q()) {
                    return JsonToken.BOOLEAN;
                }
                if (jsonPrimitive.s()) {
                    return JsonToken.NUMBER;
                }
                throw new AssertionError();
            } else if (k2 instanceof JsonNull) {
                return JsonToken.NULL;
            } else {
                if (k2 == f31009g) {
                    throw new IllegalStateException("JsonReader is closed");
                }
                throw new MalformedJsonException("Custom JsonElement subclass " + k2.getClass().getName() + " is not supported");
            }
        }
    }

    public void s() throws IOException {
        a(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) k()).next();
        v(entry.getValue());
        v(new JsonPrimitive((String) entry.getKey()));
    }

    public void skipValue() throws IOException {
        int i2 = AnonymousClass2.f31014a[peek().ordinal()];
        if (i2 == 1) {
            i(true);
        } else if (i2 == 2) {
            endArray();
        } else if (i2 == 3) {
            endObject();
        } else if (i2 != 4) {
            q();
            int i3 = this.f31011c;
            if (i3 > 0) {
                int[] iArr = this.f31013e;
                int i4 = i3 - 1;
                iArr[i4] = iArr[i4] + 1;
            }
        }
    }

    public String toString() {
        return JsonTreeReader.class.getSimpleName() + locationString();
    }

    public String getPath() {
        return getPath(false);
    }
}
