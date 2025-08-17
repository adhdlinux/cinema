package okhttp3.internal;

import com.facebook.common.time.Clock;
import com.facebook.hermes.intl.Constants;
import com.facebook.imageutils.JfifUtil;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.reflect.Field;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketTimeoutException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.http2.Header;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Options;
import okio.Source;
import r1.a;
import r1.b;

public final class Util {
    public static final byte[] EMPTY_BYTE_ARRAY;
    public static final Headers EMPTY_HEADERS = Headers.Companion.of(new String[0]);
    public static final RequestBody EMPTY_REQUEST;
    public static final ResponseBody EMPTY_RESPONSE;
    private static final Options UNICODE_BOMS;
    public static final TimeZone UTC;
    private static final Regex VERIFY_AS_IP_ADDRESS = new Regex("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
    public static final boolean assertionsEnabled = false;
    public static final String okHttpName;
    public static final String userAgent = "okhttp/4.12.0";

    static {
        byte[] bArr = new byte[0];
        EMPTY_BYTE_ARRAY = bArr;
        EMPTY_RESPONSE = ResponseBody.Companion.create$default(ResponseBody.Companion, bArr, (MediaType) null, 1, (Object) null);
        EMPTY_REQUEST = RequestBody.Companion.create$default(RequestBody.Companion, bArr, (MediaType) null, 0, 0, 7, (Object) null);
        Options.Companion companion = Options.f41357e;
        ByteString.Companion companion2 = ByteString.f41331e;
        UNICODE_BOMS = companion.d(companion2.b("efbbbf"), companion2.b("feff"), companion2.b("fffe"), companion2.b("0000ffff"), companion2.b("ffff0000"));
        TimeZone timeZone = TimeZone.getTimeZone("GMT");
        Intrinsics.c(timeZone);
        UTC = timeZone;
        String name = OkHttpClient.class.getName();
        Intrinsics.e(name, "OkHttpClient::class.java.name");
        okHttpName = StringsKt__StringsKt.n0(StringsKt__StringsKt.m0(name, "okhttp3."), "Client");
    }

    public static final <E> void addIfAbsent(List<E> list, E e2) {
        Intrinsics.f(list, "<this>");
        if (!list.contains(e2)) {
            list.add(e2);
        }
    }

    public static final int and(byte b2, int i2) {
        return b2 & i2;
    }

    public static final int and(short s2, int i2) {
        return s2 & i2;
    }

    public static final long and(int i2, long j2) {
        return ((long) i2) & j2;
    }

    public static final EventListener.Factory asFactory(EventListener eventListener) {
        Intrinsics.f(eventListener, "<this>");
        return new b(eventListener);
    }

    /* access modifiers changed from: private */
    public static final EventListener asFactory$lambda$8(EventListener eventListener, Call call) {
        Intrinsics.f(eventListener, "$this_asFactory");
        Intrinsics.f(call, "it");
        return eventListener;
    }

    public static final void assertThreadDoesntHoldLock(Object obj) {
        Intrinsics.f(obj, "<this>");
        if (assertionsEnabled && Thread.holdsLock(obj)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + obj);
        }
    }

    public static final void assertThreadHoldsLock(Object obj) {
        Intrinsics.f(obj, "<this>");
        if (assertionsEnabled && !Thread.holdsLock(obj)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + obj);
        }
    }

    public static final boolean canParseAsIpAddress(String str) {
        Intrinsics.f(str, "<this>");
        return VERIFY_AS_IP_ADDRESS.g(str);
    }

    public static final boolean canReuseConnectionFor(HttpUrl httpUrl, HttpUrl httpUrl2) {
        Intrinsics.f(httpUrl, "<this>");
        Intrinsics.f(httpUrl2, "other");
        if (!Intrinsics.a(httpUrl.host(), httpUrl2.host()) || httpUrl.port() != httpUrl2.port() || !Intrinsics.a(httpUrl.scheme(), httpUrl2.scheme())) {
            return false;
        }
        return true;
    }

    public static final int checkDuration(String str, long j2, TimeUnit timeUnit) {
        boolean z2;
        boolean z3;
        boolean z4;
        Intrinsics.f(str, "name");
        boolean z5 = true;
        int i2 = (j2 > 0 ? 1 : (j2 == 0 ? 0 : -1));
        if (i2 >= 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            if (timeUnit != null) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z3) {
                long millis = timeUnit.toMillis(j2);
                if (millis <= 2147483647L) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (z4) {
                    if (millis == 0 && i2 > 0) {
                        z5 = false;
                    }
                    if (z5) {
                        return (int) millis;
                    }
                    throw new IllegalArgumentException((str + " too small.").toString());
                }
                throw new IllegalArgumentException((str + " too large.").toString());
            }
            throw new IllegalStateException("unit == null".toString());
        }
        throw new IllegalStateException((str + " < 0").toString());
    }

    public static final void checkOffsetAndCount(long j2, long j3, long j4) {
        if ((j3 | j4) < 0 || j3 > j2 || j2 - j3 < j4) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public static final void closeQuietly(Closeable closeable) {
        Intrinsics.f(closeable, "<this>");
        try {
            closeable.close();
        } catch (RuntimeException e2) {
            throw e2;
        } catch (Exception unused) {
        }
    }

    public static final String[] concat(String[] strArr, String str) {
        Intrinsics.f(strArr, "<this>");
        Intrinsics.f(str, AppMeasurementSdk.ConditionalUserProperty.VALUE);
        Object[] copyOf = Arrays.copyOf(strArr, strArr.length + 1);
        Intrinsics.e(copyOf, "copyOf(this, newSize)");
        String[] strArr2 = (String[]) copyOf;
        strArr2[ArraysKt___ArraysKt.y(strArr2)] = str;
        return strArr2;
    }

    public static final int delimiterOffset(String str, String str2, int i2, int i3) {
        Intrinsics.f(str, "<this>");
        Intrinsics.f(str2, "delimiters");
        while (i2 < i3) {
            if (StringsKt__StringsKt.K(str2, str.charAt(i2), false, 2, (Object) null)) {
                return i2;
            }
            i2++;
        }
        return i3;
    }

    public static /* synthetic */ int delimiterOffset$default(String str, String str2, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = str.length();
        }
        return delimiterOffset(str, str2, i2, i3);
    }

    public static final boolean discard(Source source, int i2, TimeUnit timeUnit) {
        Intrinsics.f(source, "<this>");
        Intrinsics.f(timeUnit, "timeUnit");
        try {
            return skipAll(source, i2, timeUnit);
        } catch (IOException unused) {
            return false;
        }
    }

    public static final <T> List<T> filterList(Iterable<? extends T> iterable, Function1<? super T, Boolean> function1) {
        Intrinsics.f(iterable, "<this>");
        Intrinsics.f(function1, "predicate");
        List<T> f2 = CollectionsKt__CollectionsKt.f();
        for (Object next : iterable) {
            if (function1.invoke(next).booleanValue()) {
                if (f2.isEmpty()) {
                    f2 = new ArrayList<>();
                }
                Intrinsics.d(f2, "null cannot be cast to non-null type kotlin.collections.MutableList<T of okhttp3.internal.Util.filterList>");
                TypeIntrinsics.a(f2).add(next);
            }
        }
        return f2;
    }

    public static final String format(String str, Object... objArr) {
        Intrinsics.f(str, "format");
        Intrinsics.f(objArr, "args");
        StringCompanionObject stringCompanionObject = StringCompanionObject.f40434a;
        Locale locale = Locale.US;
        Object[] copyOf = Arrays.copyOf(objArr, objArr.length);
        String format = String.format(locale, str, Arrays.copyOf(copyOf, copyOf.length));
        Intrinsics.e(format, "format(locale, format, *args)");
        return format;
    }

    public static final boolean hasIntersection(String[] strArr, String[] strArr2, Comparator<? super String> comparator) {
        boolean z2;
        boolean z3;
        Intrinsics.f(strArr, "<this>");
        Intrinsics.f(comparator, "comparator");
        if (strArr.length == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2 && strArr2 != null) {
            if (strArr2.length == 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (!z3) {
                for (String str : strArr) {
                    Iterator a2 = ArrayIteratorKt.a(strArr2);
                    while (a2.hasNext()) {
                        if (comparator.compare(str, (String) a2.next()) == 0) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static final long headersContentLength(Response response) {
        Intrinsics.f(response, "<this>");
        String str = response.headers().get("Content-Length");
        if (str != null) {
            return toLongOrDefault(str, -1);
        }
        return -1;
    }

    public static final void ignoreIoExceptions(Function0<Unit> function0) {
        Intrinsics.f(function0, "block");
        try {
            function0.invoke();
        } catch (IOException unused) {
        }
    }

    @SafeVarargs
    public static final <T> List<T> immutableListOf(T... tArr) {
        Intrinsics.f(tArr, "elements");
        Object[] objArr = (Object[]) tArr.clone();
        List<T> unmodifiableList = Collections.unmodifiableList(CollectionsKt__CollectionsKt.i(Arrays.copyOf(objArr, objArr.length)));
        Intrinsics.e(unmodifiableList, "unmodifiableList(listOf(*elements.clone()))");
        return unmodifiableList;
    }

    public static final int indexOf(String[] strArr, String str, Comparator<String> comparator) {
        boolean z2;
        Intrinsics.f(strArr, "<this>");
        Intrinsics.f(str, AppMeasurementSdk.ConditionalUserProperty.VALUE);
        Intrinsics.f(comparator, "comparator");
        int length = strArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (comparator.compare(strArr[i2], str) == 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                return i2;
            }
        }
        return -1;
    }

    public static final int indexOfControlOrNonAscii(String str) {
        Intrinsics.f(str, "<this>");
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (Intrinsics.h(charAt, 31) <= 0 || Intrinsics.h(charAt, 127) >= 0) {
                return i2;
            }
        }
        return -1;
    }

    public static final int indexOfFirstNonAsciiWhitespace(String str, int i2, int i3) {
        boolean z2;
        boolean z3;
        boolean z4;
        Intrinsics.f(str, "<this>");
        while (i2 < i3) {
            char charAt = str.charAt(i2);
            boolean z5 = false;
            if (charAt == 9 || charAt == 10) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2 && charAt != 12) {
                z3 = false;
            } else {
                z3 = true;
            }
            if (!z3 && charAt != 13) {
                z4 = false;
            } else {
                z4 = true;
            }
            if (z4 || charAt == ' ') {
                z5 = true;
            }
            if (!z5) {
                return i2;
            }
            i2++;
        }
        return i3;
    }

    public static /* synthetic */ int indexOfFirstNonAsciiWhitespace$default(String str, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = str.length();
        }
        return indexOfFirstNonAsciiWhitespace(str, i2, i3);
    }

    public static final int indexOfLastNonAsciiWhitespace(String str, int i2, int i3) {
        boolean z2;
        boolean z3;
        boolean z4;
        Intrinsics.f(str, "<this>");
        int i4 = i3 - 1;
        if (i2 <= i4) {
            while (true) {
                char charAt = str.charAt(i4);
                boolean z5 = false;
                if (charAt == 9 || charAt == 10) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (!z2 && charAt != 12) {
                    z3 = false;
                } else {
                    z3 = true;
                }
                if (!z3 && charAt != 13) {
                    z4 = false;
                } else {
                    z4 = true;
                }
                if (z4 || charAt == ' ') {
                    z5 = true;
                }
                if (z5) {
                    if (i4 == i2) {
                        break;
                    }
                    i4--;
                } else {
                    return i4 + 1;
                }
            }
        }
        return i2;
    }

    public static /* synthetic */ int indexOfLastNonAsciiWhitespace$default(String str, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = str.length();
        }
        return indexOfLastNonAsciiWhitespace(str, i2, i3);
    }

    public static final int indexOfNonWhitespace(String str, int i2) {
        Intrinsics.f(str, "<this>");
        int length = str.length();
        while (i2 < length) {
            char charAt = str.charAt(i2);
            if (charAt != ' ' && charAt != 9) {
                return i2;
            }
            i2++;
        }
        return str.length();
    }

    public static /* synthetic */ int indexOfNonWhitespace$default(String str, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = 0;
        }
        return indexOfNonWhitespace(str, i2);
    }

    public static final String[] intersect(String[] strArr, String[] strArr2, Comparator<? super String> comparator) {
        Intrinsics.f(strArr, "<this>");
        Intrinsics.f(strArr2, "other");
        Intrinsics.f(comparator, "comparator");
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            int length = strArr2.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                } else if (comparator.compare(str, strArr2[i2]) == 0) {
                    arrayList.add(str);
                    break;
                } else {
                    i2++;
                }
            }
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0024, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0025, code lost:
        kotlin.io.CloseableKt.a(r0, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0028, code lost:
        throw r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
        r2 = kotlin.Unit.f40298a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001b, code lost:
        kotlin.io.CloseableKt.a(r0, (java.lang.Throwable) null);
        r3.delete(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0022, code lost:
        return false;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0019 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean isCivilized(okhttp3.internal.io.FileSystem r3, java.io.File r4) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.f(r3, r0)
            java.lang.String r0 = "file"
            kotlin.jvm.internal.Intrinsics.f(r4, r0)
            okio.Sink r0 = r3.sink(r4)
            r1 = 0
            r3.delete(r4)     // Catch:{ IOException -> 0x0019 }
            kotlin.io.CloseableKt.a(r0, r1)
            r3 = 1
            return r3
        L_0x0017:
            r3 = move-exception
            goto L_0x0023
        L_0x0019:
            kotlin.Unit r2 = kotlin.Unit.f40298a     // Catch:{ all -> 0x0017 }
            kotlin.io.CloseableKt.a(r0, r1)
            r3.delete(r4)
            r3 = 0
            return r3
        L_0x0023:
            throw r3     // Catch:{ all -> 0x0024 }
        L_0x0024:
            r4 = move-exception
            kotlin.io.CloseableKt.a(r0, r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.Util.isCivilized(okhttp3.internal.io.FileSystem, java.io.File):boolean");
    }

    public static final boolean isHealthy(Socket socket, BufferedSource bufferedSource) {
        int soTimeout;
        Intrinsics.f(socket, "<this>");
        Intrinsics.f(bufferedSource, "source");
        try {
            soTimeout = socket.getSoTimeout();
            socket.setSoTimeout(1);
            boolean z2 = !bufferedSource.V();
            socket.setSoTimeout(soTimeout);
            return z2;
        } catch (SocketTimeoutException unused) {
            return true;
        } catch (IOException unused2) {
            return false;
        } catch (Throwable th) {
            socket.setSoTimeout(soTimeout);
            throw th;
        }
    }

    public static final boolean isSensitiveHeader(String str) {
        Intrinsics.f(str, "name");
        if (StringsKt__StringsJVMKt.t(str, "Authorization", true) || StringsKt__StringsJVMKt.t(str, "Cookie", true) || StringsKt__StringsJVMKt.t(str, "Proxy-Authorization", true) || StringsKt__StringsJVMKt.t(str, "Set-Cookie", true)) {
            return true;
        }
        return false;
    }

    public static final void notify(Object obj) {
        Intrinsics.f(obj, "<this>");
        obj.notify();
    }

    public static final void notifyAll(Object obj) {
        Intrinsics.f(obj, "<this>");
        obj.notifyAll();
    }

    public static final int parseHexDigit(char c2) {
        boolean z2 = true;
        if ('0' <= c2 && c2 < ':') {
            return c2 - '0';
        }
        char c3 = 'a';
        if (!('a' <= c2 && c2 < 'g')) {
            c3 = 'A';
            if ('A' > c2 || c2 >= 'G') {
                z2 = false;
            }
            if (!z2) {
                return -1;
            }
        }
        return (c2 - c3) + 10;
    }

    public static final String peerName(Socket socket) {
        Intrinsics.f(socket, "<this>");
        SocketAddress remoteSocketAddress = socket.getRemoteSocketAddress();
        if (!(remoteSocketAddress instanceof InetSocketAddress)) {
            return remoteSocketAddress.toString();
        }
        String hostName = ((InetSocketAddress) remoteSocketAddress).getHostName();
        Intrinsics.e(hostName, "address.hostName");
        return hostName;
    }

    public static final Charset readBomAsCharset(BufferedSource bufferedSource, Charset charset) throws IOException {
        Intrinsics.f(bufferedSource, "<this>");
        Intrinsics.f(charset, Constants.COLLATION_DEFAULT);
        int n02 = bufferedSource.n0(UNICODE_BOMS);
        if (n02 == -1) {
            return charset;
        }
        if (n02 == 0) {
            Charset charset2 = StandardCharsets.UTF_8;
            Intrinsics.e(charset2, "UTF_8");
            return charset2;
        } else if (n02 == 1) {
            Charset charset3 = StandardCharsets.UTF_16BE;
            Intrinsics.e(charset3, "UTF_16BE");
            return charset3;
        } else if (n02 == 2) {
            Charset charset4 = StandardCharsets.UTF_16LE;
            Intrinsics.e(charset4, "UTF_16LE");
            return charset4;
        } else if (n02 == 3) {
            return Charsets.f40512a.a();
        } else {
            if (n02 == 4) {
                return Charsets.f40512a.b();
            }
            throw new AssertionError();
        }
    }

    public static final <T> T readFieldOrNull(Object obj, Class<T> cls, String str) {
        Object readFieldOrNull;
        Intrinsics.f(obj, "instance");
        Intrinsics.f(cls, "fieldType");
        Intrinsics.f(str, "fieldName");
        Class cls2 = obj.getClass();
        while (true) {
            Class<Object> cls3 = Object.class;
            if (!Intrinsics.a(cls2, cls3)) {
                try {
                    Field declaredField = cls2.getDeclaredField(str);
                    declaredField.setAccessible(true);
                    Object obj2 = declaredField.get(obj);
                    if (!cls.isInstance(obj2)) {
                        return null;
                    }
                    return cls.cast(obj2);
                } catch (NoSuchFieldException unused) {
                    cls2 = cls2.getSuperclass();
                    Intrinsics.e(cls2, "c.superclass");
                }
            } else if (Intrinsics.a(str, "delegate") || (readFieldOrNull = readFieldOrNull(obj, cls3, "delegate")) == null) {
                return null;
            } else {
                return readFieldOrNull(readFieldOrNull, cls, str);
            }
        }
    }

    public static final int readMedium(BufferedSource bufferedSource) throws IOException {
        Intrinsics.f(bufferedSource, "<this>");
        return and(bufferedSource.readByte(), (int) JfifUtil.MARKER_FIRST_BYTE) | (and(bufferedSource.readByte(), (int) JfifUtil.MARKER_FIRST_BYTE) << 16) | (and(bufferedSource.readByte(), (int) JfifUtil.MARKER_FIRST_BYTE) << 8);
    }

    public static final boolean skipAll(Source source, int i2, TimeUnit timeUnit) throws IOException {
        Intrinsics.f(source, "<this>");
        Intrinsics.f(timeUnit, "timeUnit");
        long nanoTime = System.nanoTime();
        long deadlineNanoTime = source.timeout().hasDeadline() ? source.timeout().deadlineNanoTime() - nanoTime : Long.MAX_VALUE;
        source.timeout().deadlineNanoTime(Math.min(deadlineNanoTime, timeUnit.toNanos((long) i2)) + nanoTime);
        try {
            Buffer buffer = new Buffer();
            while (source.read(buffer, 8192) != -1) {
                buffer.a();
            }
            if (deadlineNanoTime == Clock.MAX_TIME) {
                source.timeout().clearDeadline();
            } else {
                source.timeout().deadlineNanoTime(nanoTime + deadlineNanoTime);
            }
            return true;
        } catch (InterruptedIOException unused) {
            if (deadlineNanoTime == Clock.MAX_TIME) {
                source.timeout().clearDeadline();
            } else {
                source.timeout().deadlineNanoTime(nanoTime + deadlineNanoTime);
            }
            return false;
        } catch (Throwable th) {
            if (deadlineNanoTime == Clock.MAX_TIME) {
                source.timeout().clearDeadline();
            } else {
                source.timeout().deadlineNanoTime(nanoTime + deadlineNanoTime);
            }
            throw th;
        }
    }

    public static final ThreadFactory threadFactory(String str, boolean z2) {
        Intrinsics.f(str, "name");
        return new a(str, z2);
    }

    /* access modifiers changed from: private */
    public static final Thread threadFactory$lambda$1(String str, boolean z2, Runnable runnable) {
        Intrinsics.f(str, "$name");
        Thread thread = new Thread(runnable, str);
        thread.setDaemon(z2);
        return thread;
    }

    public static final void threadName(String str, Function0<Unit> function0) {
        Intrinsics.f(str, "name");
        Intrinsics.f(function0, "block");
        Thread currentThread = Thread.currentThread();
        String name = currentThread.getName();
        currentThread.setName(str);
        try {
            function0.invoke();
        } finally {
            InlineMarker.b(1);
            currentThread.setName(name);
            InlineMarker.a(1);
        }
    }

    public static final List<Header> toHeaderList(Headers headers) {
        Intrinsics.f(headers, "<this>");
        IntRange j2 = RangesKt___RangesKt.j(0, headers.size());
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.p(j2, 10));
        Iterator it2 = j2.iterator();
        while (it2.hasNext()) {
            int nextInt = ((IntIterator) it2).nextInt();
            arrayList.add(new Header(headers.name(nextInt), headers.value(nextInt)));
        }
        return arrayList;
    }

    public static final Headers toHeaders(List<Header> list) {
        Intrinsics.f(list, "<this>");
        Headers.Builder builder = new Headers.Builder();
        for (Header next : list) {
            builder.addLenient$okhttp(next.component1().y(), next.component2().y());
        }
        return builder.build();
    }

    public static final String toHexString(long j2) {
        String hexString = Long.toHexString(j2);
        Intrinsics.e(hexString, "toHexString(this)");
        return hexString;
    }

    public static final String toHostHeader(HttpUrl httpUrl, boolean z2) {
        String str;
        Intrinsics.f(httpUrl, "<this>");
        if (StringsKt__StringsKt.L(httpUrl.host(), ":", false, 2, (Object) null)) {
            str = '[' + httpUrl.host() + ']';
        } else {
            str = httpUrl.host();
        }
        if (!z2 && httpUrl.port() == HttpUrl.Companion.defaultPort(httpUrl.scheme())) {
            return str;
        }
        return str + ':' + httpUrl.port();
    }

    public static /* synthetic */ String toHostHeader$default(HttpUrl httpUrl, boolean z2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z2 = false;
        }
        return toHostHeader(httpUrl, z2);
    }

    public static final <T> List<T> toImmutableList(List<? extends T> list) {
        Intrinsics.f(list, "<this>");
        List<T> unmodifiableList = Collections.unmodifiableList(CollectionsKt___CollectionsKt.c0(list));
        Intrinsics.e(unmodifiableList, "unmodifiableList(toMutableList())");
        return unmodifiableList;
    }

    public static final <K, V> Map<K, V> toImmutableMap(Map<K, ? extends V> map) {
        Intrinsics.f(map, "<this>");
        if (map.isEmpty()) {
            return MapsKt__MapsKt.g();
        }
        Map<K, V> unmodifiableMap = Collections.unmodifiableMap(new LinkedHashMap(map));
        Intrinsics.e(unmodifiableMap, "{\n    Collections.unmodi…(LinkedHashMap(this))\n  }");
        return unmodifiableMap;
    }

    public static final long toLongOrDefault(String str, long j2) {
        Intrinsics.f(str, "<this>");
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return j2;
        }
    }

    public static final int toNonNegativeInt(String str, int i2) {
        if (str != null) {
            try {
                long parseLong = Long.parseLong(str);
                if (parseLong > 2147483647L) {
                    return Integer.MAX_VALUE;
                }
                if (parseLong < 0) {
                    return 0;
                }
                return (int) parseLong;
            } catch (NumberFormatException unused) {
            }
        }
        return i2;
    }

    public static final String trimSubstring(String str, int i2, int i3) {
        Intrinsics.f(str, "<this>");
        int indexOfFirstNonAsciiWhitespace = indexOfFirstNonAsciiWhitespace(str, i2, i3);
        String substring = str.substring(indexOfFirstNonAsciiWhitespace, indexOfLastNonAsciiWhitespace(str, indexOfFirstNonAsciiWhitespace, i3));
        Intrinsics.e(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ String trimSubstring$default(String str, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = str.length();
        }
        return trimSubstring(str, i2, i3);
    }

    public static final void wait(Object obj) {
        Intrinsics.f(obj, "<this>");
        obj.wait();
    }

    public static final Throwable withSuppressed(Exception exc, List<? extends Exception> list) {
        Intrinsics.f(exc, "<this>");
        Intrinsics.f(list, "suppressed");
        for (Exception a2 : list) {
            ExceptionsKt__ExceptionsKt.a(exc, a2);
        }
        return exc;
    }

    public static final void writeMedium(BufferedSink bufferedSink, int i2) throws IOException {
        Intrinsics.f(bufferedSink, "<this>");
        bufferedSink.writeByte((i2 >>> 16) & JfifUtil.MARKER_FIRST_BYTE);
        bufferedSink.writeByte((i2 >>> 8) & JfifUtil.MARKER_FIRST_BYTE);
        bufferedSink.writeByte(i2 & JfifUtil.MARKER_FIRST_BYTE);
    }

    public static final int delimiterOffset(String str, char c2, int i2, int i3) {
        Intrinsics.f(str, "<this>");
        while (i2 < i3) {
            if (str.charAt(i2) == c2) {
                return i2;
            }
            i2++;
        }
        return i3;
    }

    public static /* synthetic */ int delimiterOffset$default(String str, char c2, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = str.length();
        }
        return delimiterOffset(str, c2, i2, i3);
    }

    public static final String toHexString(int i2) {
        String hexString = Integer.toHexString(i2);
        Intrinsics.e(hexString, "toHexString(this)");
        return hexString;
    }

    public static final void closeQuietly(Socket socket) {
        Intrinsics.f(socket, "<this>");
        try {
            socket.close();
        } catch (AssertionError e2) {
            throw e2;
        } catch (RuntimeException e3) {
            if (!Intrinsics.a(e3.getMessage(), "bio == null")) {
                throw e3;
            }
        } catch (Exception unused) {
        }
    }

    public static final void closeQuietly(ServerSocket serverSocket) {
        Intrinsics.f(serverSocket, "<this>");
        try {
            serverSocket.close();
        } catch (RuntimeException e2) {
            throw e2;
        } catch (Exception unused) {
        }
    }

    public static final int skipAll(Buffer buffer, byte b2) {
        Intrinsics.f(buffer, "<this>");
        int i2 = 0;
        while (!buffer.V() && buffer.z(0) == b2) {
            i2++;
            buffer.readByte();
        }
        return i2;
    }
}
