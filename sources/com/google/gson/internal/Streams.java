package com.google.gson.internal;

import com.google.gson.JsonElement;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Objects;

public final class Streams {
    private Streams() {
        throw new UnsupportedOperationException();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0016, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001c, code lost:
        throw new com.google.gson.JsonIOException((java.lang.Throwable) r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001d, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0023, code lost:
        throw new com.google.gson.JsonSyntaxException((java.lang.Throwable) r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x002a, code lost:
        return com.google.gson.JsonNull.f30890b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0030, code lost:
        throw new com.google.gson.JsonSyntaxException((java.lang.Throwable) r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000d, code lost:
        r2 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x000f, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0015, code lost:
        throw new com.google.gson.JsonSyntaxException((java.lang.Throwable) r2);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0016 A[ExcHandler: IOException (r2v5 'e' java.io.IOException A[CUSTOM_DECLARE]), Splitter:B:0:0x0000] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x001d A[ExcHandler: MalformedJsonException (r2v4 'e' com.google.gson.stream.MalformedJsonException A[CUSTOM_DECLARE]), Splitter:B:0:0x0000] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0028  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x002b  */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x000f A[ExcHandler: NumberFormatException (r2v6 'e' java.lang.NumberFormatException A[CUSTOM_DECLARE]), Splitter:B:0:0x0000] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.gson.JsonElement a(com.google.gson.stream.JsonReader r2) throws com.google.gson.JsonParseException {
        /*
            r2.peek()     // Catch:{ EOFException -> 0x0024, MalformedJsonException -> 0x001d, IOException -> 0x0016, NumberFormatException -> 0x000f }
            r0 = 0
            com.google.gson.TypeAdapter<com.google.gson.JsonElement> r1 = com.google.gson.internal.bind.TypeAdapters.V     // Catch:{ EOFException -> 0x000d, MalformedJsonException -> 0x001d, IOException -> 0x0016, NumberFormatException -> 0x000f }
            java.lang.Object r2 = r1.read(r2)     // Catch:{ EOFException -> 0x000d, MalformedJsonException -> 0x001d, IOException -> 0x0016, NumberFormatException -> 0x000f }
            com.google.gson.JsonElement r2 = (com.google.gson.JsonElement) r2     // Catch:{ EOFException -> 0x000d, MalformedJsonException -> 0x001d, IOException -> 0x0016, NumberFormatException -> 0x000f }
            return r2
        L_0x000d:
            r2 = move-exception
            goto L_0x0026
        L_0x000f:
            r2 = move-exception
            com.google.gson.JsonSyntaxException r0 = new com.google.gson.JsonSyntaxException
            r0.<init>((java.lang.Throwable) r2)
            throw r0
        L_0x0016:
            r2 = move-exception
            com.google.gson.JsonIOException r0 = new com.google.gson.JsonIOException
            r0.<init>((java.lang.Throwable) r2)
            throw r0
        L_0x001d:
            r2 = move-exception
            com.google.gson.JsonSyntaxException r0 = new com.google.gson.JsonSyntaxException
            r0.<init>((java.lang.Throwable) r2)
            throw r0
        L_0x0024:
            r2 = move-exception
            r0 = 1
        L_0x0026:
            if (r0 == 0) goto L_0x002b
            com.google.gson.JsonNull r2 = com.google.gson.JsonNull.f30890b
            return r2
        L_0x002b:
            com.google.gson.JsonSyntaxException r0 = new com.google.gson.JsonSyntaxException
            r0.<init>((java.lang.Throwable) r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.Streams.a(com.google.gson.stream.JsonReader):com.google.gson.JsonElement");
    }

    public static void b(JsonElement jsonElement, JsonWriter jsonWriter) throws IOException {
        TypeAdapters.V.write(jsonWriter, jsonElement);
    }

    public static Writer c(Appendable appendable) {
        return appendable instanceof Writer ? (Writer) appendable : new AppendableWriter(appendable);
    }

    private static final class AppendableWriter extends Writer {

        /* renamed from: b  reason: collision with root package name */
        private final Appendable f30983b;

        /* renamed from: c  reason: collision with root package name */
        private final CurrentWrite f30984c = new CurrentWrite();

        private static class CurrentWrite implements CharSequence {

            /* renamed from: b  reason: collision with root package name */
            private char[] f30985b;

            /* renamed from: c  reason: collision with root package name */
            private String f30986c;

            private CurrentWrite() {
            }

            /* access modifiers changed from: package-private */
            public void a(char[] cArr) {
                this.f30985b = cArr;
                this.f30986c = null;
            }

            public char charAt(int i2) {
                return this.f30985b[i2];
            }

            public int length() {
                return this.f30985b.length;
            }

            public CharSequence subSequence(int i2, int i3) {
                return new String(this.f30985b, i2, i3 - i2);
            }

            public String toString() {
                if (this.f30986c == null) {
                    this.f30986c = new String(this.f30985b);
                }
                return this.f30986c;
            }
        }

        AppendableWriter(Appendable appendable) {
            this.f30983b = appendable;
        }

        public void close() {
        }

        public void flush() {
        }

        public void write(char[] cArr, int i2, int i3) throws IOException {
            this.f30984c.a(cArr);
            this.f30983b.append(this.f30984c, i2, i3 + i2);
        }

        public Writer append(CharSequence charSequence) throws IOException {
            this.f30983b.append(charSequence);
            return this;
        }

        public void write(int i2) throws IOException {
            this.f30983b.append((char) i2);
        }

        public Writer append(CharSequence charSequence, int i2, int i3) throws IOException {
            this.f30983b.append(charSequence, i2, i3);
            return this;
        }

        public void write(String str, int i2, int i3) throws IOException {
            Objects.requireNonNull(str);
            this.f30983b.append(str, i2, i3 + i2);
        }
    }
}
