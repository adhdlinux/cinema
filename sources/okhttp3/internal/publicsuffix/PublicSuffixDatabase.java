package okhttp3.internal.publicsuffix;

import com.facebook.imageutils.JfifUtil;
import java.net.IDN;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;

public final class PublicSuffixDatabase {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final char EXCEPTION_MARKER = '!';
    private static final List<String> PREVAILING_RULE = CollectionsKt__CollectionsJVMKt.b("*");
    public static final String PUBLIC_SUFFIX_RESOURCE = "publicsuffixes.gz";
    private static final byte[] WILDCARD_LABEL = {42};
    /* access modifiers changed from: private */
    public static final PublicSuffixDatabase instance = new PublicSuffixDatabase();
    private final AtomicBoolean listRead = new AtomicBoolean(false);
    private byte[] publicSuffixExceptionListBytes;
    private byte[] publicSuffixListBytes;
    private final CountDownLatch readCompleteLatch = new CountDownLatch(1);

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        public final String binarySearch(byte[] bArr, byte[][] bArr2, int i2) {
            int i3;
            boolean z2;
            int i4;
            int and;
            byte[] bArr3 = bArr;
            byte[][] bArr4 = bArr2;
            int length = bArr3.length;
            int i5 = 0;
            while (i5 < length) {
                int i6 = (i5 + length) / 2;
                while (i6 > -1 && bArr3[i6] != 10) {
                    i6--;
                }
                int i7 = i6 + 1;
                int i8 = 1;
                while (true) {
                    i3 = i7 + i8;
                    if (bArr3[i3] == 10) {
                        break;
                    }
                    i8++;
                }
                int i9 = i3 - i7;
                int i10 = i2;
                boolean z3 = false;
                int i11 = 0;
                int i12 = 0;
                while (true) {
                    if (z3) {
                        i4 = 46;
                        z2 = false;
                    } else {
                        z2 = z3;
                        i4 = Util.and(bArr4[i10][i11], (int) JfifUtil.MARKER_FIRST_BYTE);
                    }
                    and = i4 - Util.and(bArr3[i7 + i12], (int) JfifUtil.MARKER_FIRST_BYTE);
                    if (and != 0) {
                        break;
                    }
                    i12++;
                    i11++;
                    if (i12 == i9) {
                        break;
                    } else if (bArr4[i10].length != i11) {
                        z3 = z2;
                    } else if (i10 == bArr4.length - 1) {
                        break;
                    } else {
                        i10++;
                        z3 = true;
                        i11 = -1;
                    }
                }
                if (and >= 0) {
                    if (and <= 0) {
                        int i13 = i9 - i12;
                        int length2 = bArr4[i10].length - i11;
                        int length3 = bArr4.length;
                        for (int i14 = i10 + 1; i14 < length3; i14++) {
                            length2 += bArr4[i14].length;
                        }
                        if (length2 >= i13) {
                            if (length2 <= i13) {
                                Charset charset = StandardCharsets.UTF_8;
                                Intrinsics.e(charset, "UTF_8");
                                return new String(bArr3, i7, i9, charset);
                            }
                        }
                    }
                    i5 = i3 + 1;
                }
                length = i7 - 1;
            }
            return null;
        }

        public final PublicSuffixDatabase get() {
            return PublicSuffixDatabase.instance;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00d5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.util.List<java.lang.String> findMatchingRule(java.util.List<java.lang.String> r18) {
        /*
            r17 = this;
            r0 = r17
            java.util.concurrent.atomic.AtomicBoolean r1 = r0.listRead
            boolean r1 = r1.get()
            r2 = 0
            r3 = 1
            if (r1 != 0) goto L_0x0018
            java.util.concurrent.atomic.AtomicBoolean r1 = r0.listRead
            boolean r1 = r1.compareAndSet(r2, r3)
            if (r1 == 0) goto L_0x0018
            r17.readTheListUninterruptibly()
            goto L_0x0025
        L_0x0018:
            java.util.concurrent.CountDownLatch r1 = r0.readCompleteLatch     // Catch:{ InterruptedException -> 0x001e }
            r1.await()     // Catch:{ InterruptedException -> 0x001e }
            goto L_0x0025
        L_0x001e:
            java.lang.Thread r1 = java.lang.Thread.currentThread()
            r1.interrupt()
        L_0x0025:
            byte[] r1 = r0.publicSuffixListBytes
            if (r1 == 0) goto L_0x002b
            r1 = 1
            goto L_0x002c
        L_0x002b:
            r1 = 0
        L_0x002c:
            if (r1 == 0) goto L_0x0115
            int r1 = r18.size()
            byte[][] r4 = new byte[r1][]
            r5 = 0
        L_0x0035:
            if (r5 >= r1) goto L_0x0054
            r6 = r18
            java.lang.Object r7 = r6.get(r5)
            java.lang.String r7 = (java.lang.String) r7
            java.nio.charset.Charset r8 = java.nio.charset.StandardCharsets.UTF_8
            java.lang.String r9 = "UTF_8"
            kotlin.jvm.internal.Intrinsics.e(r8, r9)
            byte[] r7 = r7.getBytes(r8)
            java.lang.String r8 = "this as java.lang.String).getBytes(charset)"
            kotlin.jvm.internal.Intrinsics.e(r7, r8)
            r4[r5] = r7
            int r5 = r5 + 1
            goto L_0x0035
        L_0x0054:
            r5 = 0
        L_0x0055:
            java.lang.String r6 = "publicSuffixListBytes"
            r7 = 0
            if (r5 >= r1) goto L_0x006e
            okhttp3.internal.publicsuffix.PublicSuffixDatabase$Companion r8 = Companion
            byte[] r9 = r0.publicSuffixListBytes
            if (r9 != 0) goto L_0x0064
            kotlin.jvm.internal.Intrinsics.x(r6)
            r9 = r7
        L_0x0064:
            java.lang.String r8 = r8.binarySearch(r9, r4, r5)
            if (r8 == 0) goto L_0x006b
            goto L_0x006f
        L_0x006b:
            int r5 = r5 + 1
            goto L_0x0055
        L_0x006e:
            r8 = r7
        L_0x006f:
            if (r1 <= r3) goto L_0x0095
            java.lang.Object r5 = r4.clone()
            byte[][] r5 = (byte[][]) r5
            int r9 = r5.length
            int r9 = r9 - r3
            r10 = 0
        L_0x007a:
            if (r10 >= r9) goto L_0x0095
            byte[] r11 = WILDCARD_LABEL
            r5[r10] = r11
            okhttp3.internal.publicsuffix.PublicSuffixDatabase$Companion r11 = Companion
            byte[] r12 = r0.publicSuffixListBytes
            if (r12 != 0) goto L_0x008a
            kotlin.jvm.internal.Intrinsics.x(r6)
            r12 = r7
        L_0x008a:
            java.lang.String r11 = r11.binarySearch(r12, r5, r10)
            if (r11 == 0) goto L_0x0092
            r5 = r11
            goto L_0x0096
        L_0x0092:
            int r10 = r10 + 1
            goto L_0x007a
        L_0x0095:
            r5 = r7
        L_0x0096:
            if (r5 == 0) goto L_0x00b3
            int r1 = r1 - r3
            r6 = 0
        L_0x009a:
            if (r6 >= r1) goto L_0x00b3
            okhttp3.internal.publicsuffix.PublicSuffixDatabase$Companion r9 = Companion
            byte[] r10 = r0.publicSuffixExceptionListBytes
            if (r10 != 0) goto L_0x00a8
            java.lang.String r10 = "publicSuffixExceptionListBytes"
            kotlin.jvm.internal.Intrinsics.x(r10)
            r10 = r7
        L_0x00a8:
            java.lang.String r9 = r9.binarySearch(r10, r4, r6)
            if (r9 == 0) goto L_0x00b0
            r7 = r9
            goto L_0x00b3
        L_0x00b0:
            int r6 = r6 + 1
            goto L_0x009a
        L_0x00b3:
            r1 = 46
            if (r7 == 0) goto L_0x00d5
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r5 = 33
            r4.append(r5)
            r4.append(r7)
            java.lang.String r8 = r4.toString()
            char[] r9 = new char[r3]
            r9[r2] = r1
            r10 = 0
            r11 = 0
            r12 = 6
            r13 = 0
            java.util.List r1 = kotlin.text.StringsKt__StringsKt.u0(r8, r9, r10, r11, r12, r13)
            return r1
        L_0x00d5:
            if (r8 != 0) goto L_0x00dc
            if (r5 != 0) goto L_0x00dc
            java.util.List<java.lang.String> r1 = PREVAILING_RULE
            return r1
        L_0x00dc:
            if (r8 == 0) goto L_0x00ee
            char[] r7 = new char[r3]
            r7[r2] = r1
            r4 = 0
            r9 = 0
            r10 = 6
            r11 = 0
            r6 = r8
            r8 = r4
            java.util.List r4 = kotlin.text.StringsKt__StringsKt.u0(r6, r7, r8, r9, r10, r11)
            if (r4 != 0) goto L_0x00f2
        L_0x00ee:
            java.util.List r4 = kotlin.collections.CollectionsKt__CollectionsKt.f()
        L_0x00f2:
            if (r5 == 0) goto L_0x0104
            char[] r12 = new char[r3]
            r12[r2] = r1
            r13 = 0
            r14 = 0
            r15 = 6
            r16 = 0
            r11 = r5
            java.util.List r1 = kotlin.text.StringsKt__StringsKt.u0(r11, r12, r13, r14, r15, r16)
            if (r1 != 0) goto L_0x0108
        L_0x0104:
            java.util.List r1 = kotlin.collections.CollectionsKt__CollectionsKt.f()
        L_0x0108:
            int r2 = r4.size()
            int r3 = r1.size()
            if (r2 <= r3) goto L_0x0113
            goto L_0x0114
        L_0x0113:
            r4 = r1
        L_0x0114:
            return r4
        L_0x0115:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "Unable to load publicsuffixes.gz resource from the classpath."
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.publicsuffix.PublicSuffixDatabase.findMatchingRule(java.util.List):java.util.List");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0062, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        kotlin.io.CloseableKt.a(r2, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0066, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void readTheList() throws java.io.IOException {
        /*
            r5 = this;
            kotlin.jvm.internal.Ref$ObjectRef r0 = new kotlin.jvm.internal.Ref$ObjectRef     // Catch:{ all -> 0x0067 }
            r0.<init>()     // Catch:{ all -> 0x0067 }
            kotlin.jvm.internal.Ref$ObjectRef r1 = new kotlin.jvm.internal.Ref$ObjectRef     // Catch:{ all -> 0x0067 }
            r1.<init>()     // Catch:{ all -> 0x0067 }
            java.lang.Class<okhttp3.internal.publicsuffix.PublicSuffixDatabase> r2 = okhttp3.internal.publicsuffix.PublicSuffixDatabase.class
            java.lang.String r3 = "publicsuffixes.gz"
            java.io.InputStream r2 = r2.getResourceAsStream(r3)     // Catch:{ all -> 0x0067 }
            if (r2 != 0) goto L_0x001a
            java.util.concurrent.CountDownLatch r0 = r5.readCompleteLatch
            r0.countDown()
            return
        L_0x001a:
            okio.GzipSource r3 = new okio.GzipSource     // Catch:{ all -> 0x0067 }
            okio.Source r2 = okio.Okio.l(r2)     // Catch:{ all -> 0x0067 }
            r3.<init>(r2)     // Catch:{ all -> 0x0067 }
            okio.BufferedSource r2 = okio.Okio.d(r3)     // Catch:{ all -> 0x0067 }
            int r3 = r2.readInt()     // Catch:{ all -> 0x0060 }
            long r3 = (long) r3     // Catch:{ all -> 0x0060 }
            byte[] r3 = r2.G(r3)     // Catch:{ all -> 0x0060 }
            r0.f40429b = r3     // Catch:{ all -> 0x0060 }
            int r3 = r2.readInt()     // Catch:{ all -> 0x0060 }
            long r3 = (long) r3     // Catch:{ all -> 0x0060 }
            byte[] r3 = r2.G(r3)     // Catch:{ all -> 0x0060 }
            r1.f40429b = r3     // Catch:{ all -> 0x0060 }
            kotlin.Unit r3 = kotlin.Unit.f40298a     // Catch:{ all -> 0x0060 }
            r3 = 0
            kotlin.io.CloseableKt.a(r2, r3)     // Catch:{ all -> 0x0067 }
            monitor-enter(r5)     // Catch:{ all -> 0x0067 }
            T r0 = r0.f40429b     // Catch:{ all -> 0x005d }
            kotlin.jvm.internal.Intrinsics.c(r0)     // Catch:{ all -> 0x005d }
            byte[] r0 = (byte[]) r0     // Catch:{ all -> 0x005d }
            r5.publicSuffixListBytes = r0     // Catch:{ all -> 0x005d }
            T r0 = r1.f40429b     // Catch:{ all -> 0x005d }
            kotlin.jvm.internal.Intrinsics.c(r0)     // Catch:{ all -> 0x005d }
            byte[] r0 = (byte[]) r0     // Catch:{ all -> 0x005d }
            r5.publicSuffixExceptionListBytes = r0     // Catch:{ all -> 0x005d }
            monitor-exit(r5)     // Catch:{ all -> 0x0067 }
            java.util.concurrent.CountDownLatch r0 = r5.readCompleteLatch
            r0.countDown()
            return
        L_0x005d:
            r0 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x0067 }
            throw r0     // Catch:{ all -> 0x0067 }
        L_0x0060:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x0062 }
        L_0x0062:
            r1 = move-exception
            kotlin.io.CloseableKt.a(r2, r0)     // Catch:{ all -> 0x0067 }
            throw r1     // Catch:{ all -> 0x0067 }
        L_0x0067:
            r0 = move-exception
            java.util.concurrent.CountDownLatch r1 = r5.readCompleteLatch
            r1.countDown()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.publicsuffix.PublicSuffixDatabase.readTheList():void");
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0027 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void readTheListUninterruptibly() {
        /*
            r5 = this;
            r0 = 0
        L_0x0001:
            r5.readTheList()     // Catch:{ InterruptedIOException -> 0x0027, IOException -> 0x0010 }
            if (r0 == 0) goto L_0x000d
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            r0.interrupt()
        L_0x000d:
            return
        L_0x000e:
            r1 = move-exception
            goto L_0x002c
        L_0x0010:
            r1 = move-exception
            okhttp3.internal.platform.Platform$Companion r2 = okhttp3.internal.platform.Platform.Companion     // Catch:{ all -> 0x000e }
            okhttp3.internal.platform.Platform r2 = r2.get()     // Catch:{ all -> 0x000e }
            java.lang.String r3 = "Failed to read public suffix list"
            r4 = 5
            r2.log(r3, r4, r1)     // Catch:{ all -> 0x000e }
            if (r0 == 0) goto L_0x0026
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            r0.interrupt()
        L_0x0026:
            return
        L_0x0027:
            java.lang.Thread.interrupted()     // Catch:{ all -> 0x000e }
            r0 = 1
            goto L_0x0001
        L_0x002c:
            if (r0 == 0) goto L_0x0035
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            r0.interrupt()
        L_0x0035:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.publicsuffix.PublicSuffixDatabase.readTheListUninterruptibly():void");
    }

    private final List<String> splitDomain(String str) {
        List<String> u02 = StringsKt__StringsKt.u0(str, new char[]{'.'}, false, 0, 6, (Object) null);
        if (Intrinsics.a(CollectionsKt___CollectionsKt.K(u02), "")) {
            return CollectionsKt___CollectionsKt.A(u02, 1);
        }
        return u02;
    }

    public final String getEffectiveTldPlusOne(String str) {
        int i2;
        int i3;
        Intrinsics.f(str, "domain");
        String unicode = IDN.toUnicode(str);
        Intrinsics.e(unicode, "unicodeDomain");
        List<String> splitDomain = splitDomain(unicode);
        List<String> findMatchingRule = findMatchingRule(splitDomain);
        if (splitDomain.size() == findMatchingRule.size() && findMatchingRule.get(0).charAt(0) != '!') {
            return null;
        }
        if (findMatchingRule.get(0).charAt(0) == '!') {
            i3 = splitDomain.size();
            i2 = findMatchingRule.size();
        } else {
            i3 = splitDomain.size();
            i2 = findMatchingRule.size() + 1;
        }
        return SequencesKt___SequencesKt.j(SequencesKt___SequencesKt.g(CollectionsKt___CollectionsKt.y(splitDomain(str)), i3 - i2), ".", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
    }

    public final void setListBytes(byte[] bArr, byte[] bArr2) {
        Intrinsics.f(bArr, "publicSuffixListBytes");
        Intrinsics.f(bArr2, "publicSuffixExceptionListBytes");
        this.publicSuffixListBytes = bArr;
        this.publicSuffixExceptionListBytes = bArr2;
        this.listRead.set(true);
        this.readCompleteLatch.countDown();
    }
}
