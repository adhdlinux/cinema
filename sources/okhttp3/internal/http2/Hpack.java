package okhttp3.internal.http2;

import com.facebook.common.util.UriUtil;
import com.facebook.imageutils.JfifUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Source;

public final class Hpack {
    public static final Hpack INSTANCE;
    private static final Map<ByteString, Integer> NAME_TO_FIRST_INDEX;
    private static final int PREFIX_4_BITS = 15;
    private static final int PREFIX_5_BITS = 31;
    private static final int PREFIX_6_BITS = 63;
    private static final int PREFIX_7_BITS = 127;
    private static final int SETTINGS_HEADER_TABLE_SIZE = 4096;
    private static final int SETTINGS_HEADER_TABLE_SIZE_LIMIT = 16384;
    private static final Header[] STATIC_HEADER_TABLE;

    static {
        Hpack hpack = new Hpack();
        INSTANCE = hpack;
        ByteString byteString = Header.TARGET_METHOD;
        ByteString byteString2 = Header.TARGET_PATH;
        ByteString byteString3 = Header.TARGET_SCHEME;
        ByteString byteString4 = Header.RESPONSE_STATUS;
        STATIC_HEADER_TABLE = new Header[]{new Header(Header.TARGET_AUTHORITY, ""), new Header(byteString, "GET"), new Header(byteString, "POST"), new Header(byteString2, "/"), new Header(byteString2, "/index.html"), new Header(byteString3, (String) UriUtil.HTTP_SCHEME), new Header(byteString3, (String) UriUtil.HTTPS_SCHEME), new Header(byteString4, "200"), new Header(byteString4, "204"), new Header(byteString4, "206"), new Header(byteString4, "304"), new Header(byteString4, "400"), new Header(byteString4, "404"), new Header(byteString4, "500"), new Header("accept-charset", ""), new Header("accept-encoding", "gzip, deflate"), new Header("accept-language", ""), new Header("accept-ranges", ""), new Header("accept", ""), new Header("access-control-allow-origin", ""), new Header("age", ""), new Header("allow", ""), new Header("authorization", ""), new Header("cache-control", ""), new Header("content-disposition", ""), new Header("content-encoding", ""), new Header("content-language", ""), new Header("content-length", ""), new Header("content-location", ""), new Header("content-range", ""), new Header("content-type", ""), new Header("cookie", ""), new Header("date", ""), new Header("etag", ""), new Header("expect", ""), new Header("expires", ""), new Header("from", ""), new Header("host", ""), new Header("if-match", ""), new Header("if-modified-since", ""), new Header("if-none-match", ""), new Header("if-range", ""), new Header("if-unmodified-since", ""), new Header("last-modified", ""), new Header("link", ""), new Header("location", ""), new Header("max-forwards", ""), new Header("proxy-authenticate", ""), new Header("proxy-authorization", ""), new Header("range", ""), new Header("referer", ""), new Header("refresh", ""), new Header("retry-after", ""), new Header("server", ""), new Header("set-cookie", ""), new Header("strict-transport-security", ""), new Header("transfer-encoding", ""), new Header("user-agent", ""), new Header("vary", ""), new Header("via", ""), new Header("www-authenticate", "")};
        NAME_TO_FIRST_INDEX = hpack.nameToFirstIndex();
    }

    private Hpack() {
    }

    private final Map<ByteString, Integer> nameToFirstIndex() {
        Header[] headerArr = STATIC_HEADER_TABLE;
        LinkedHashMap linkedHashMap = new LinkedHashMap(headerArr.length);
        int length = headerArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            Header[] headerArr2 = STATIC_HEADER_TABLE;
            if (!linkedHashMap.containsKey(headerArr2[i2].name)) {
                linkedHashMap.put(headerArr2[i2].name, Integer.valueOf(i2));
            }
        }
        Map<ByteString, Integer> unmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
        Intrinsics.e(unmodifiableMap, "unmodifiableMap(result)");
        return unmodifiableMap;
    }

    public final ByteString checkLowercase(ByteString byteString) throws IOException {
        boolean z2;
        Intrinsics.f(byteString, "name");
        int size = byteString.size();
        int i2 = 0;
        while (i2 < size) {
            byte f2 = byteString.f(i2);
            if (65 > f2 || f2 >= 91) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (!z2) {
                i2++;
            } else {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + byteString.y());
            }
        }
        return byteString;
    }

    public final Map<ByteString, Integer> getNAME_TO_FIRST_INDEX() {
        return NAME_TO_FIRST_INDEX;
    }

    public final Header[] getSTATIC_HEADER_TABLE() {
        return STATIC_HEADER_TABLE;
    }

    public static final class Reader {
        public Header[] dynamicTable;
        public int dynamicTableByteCount;
        public int headerCount;
        private final List<Header> headerList;
        private final int headerTableSizeSetting;
        private int maxDynamicTableByteCount;
        private int nextHeaderIndex;
        private final BufferedSource source;

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public Reader(Source source2, int i2) {
            this(source2, i2, 0, 4, (DefaultConstructorMarker) null);
            Intrinsics.f(source2, "source");
        }

        public Reader(Source source2, int i2, int i3) {
            Intrinsics.f(source2, "source");
            this.headerTableSizeSetting = i2;
            this.maxDynamicTableByteCount = i3;
            this.headerList = new ArrayList();
            this.source = Okio.d(source2);
            Header[] headerArr = new Header[8];
            this.dynamicTable = headerArr;
            this.nextHeaderIndex = headerArr.length - 1;
        }

        private final void adjustDynamicTableByteCount() {
            int i2 = this.maxDynamicTableByteCount;
            int i3 = this.dynamicTableByteCount;
            if (i2 >= i3) {
                return;
            }
            if (i2 == 0) {
                clearDynamicTable();
            } else {
                evictToRecoverBytes(i3 - i2);
            }
        }

        private final void clearDynamicTable() {
            ArraysKt___ArraysJvmKt.m(this.dynamicTable, (Object) null, 0, 0, 6, (Object) null);
            this.nextHeaderIndex = this.dynamicTable.length - 1;
            this.headerCount = 0;
            this.dynamicTableByteCount = 0;
        }

        private final int dynamicTableIndex(int i2) {
            return this.nextHeaderIndex + 1 + i2;
        }

        private final int evictToRecoverBytes(int i2) {
            int i3;
            int i4 = 0;
            if (i2 > 0) {
                int length = this.dynamicTable.length;
                while (true) {
                    length--;
                    i3 = this.nextHeaderIndex;
                    if (length < i3 || i2 <= 0) {
                        Header[] headerArr = this.dynamicTable;
                        System.arraycopy(headerArr, i3 + 1, headerArr, i3 + 1 + i4, this.headerCount);
                        this.nextHeaderIndex += i4;
                    } else {
                        Header header = this.dynamicTable[length];
                        Intrinsics.c(header);
                        int i5 = header.hpackSize;
                        i2 -= i5;
                        this.dynamicTableByteCount -= i5;
                        this.headerCount--;
                        i4++;
                    }
                }
                Header[] headerArr2 = this.dynamicTable;
                System.arraycopy(headerArr2, i3 + 1, headerArr2, i3 + 1 + i4, this.headerCount);
                this.nextHeaderIndex += i4;
            }
            return i4;
        }

        private final ByteString getName(int i2) throws IOException {
            if (isStaticHeader(i2)) {
                return Hpack.INSTANCE.getSTATIC_HEADER_TABLE()[i2].name;
            }
            int dynamicTableIndex = dynamicTableIndex(i2 - Hpack.INSTANCE.getSTATIC_HEADER_TABLE().length);
            if (dynamicTableIndex >= 0) {
                Header[] headerArr = this.dynamicTable;
                if (dynamicTableIndex < headerArr.length) {
                    Header header = headerArr[dynamicTableIndex];
                    Intrinsics.c(header);
                    return header.name;
                }
            }
            throw new IOException("Header index too large " + (i2 + 1));
        }

        private final void insertIntoDynamicTable(int i2, Header header) {
            this.headerList.add(header);
            int i3 = header.hpackSize;
            if (i2 != -1) {
                Header header2 = this.dynamicTable[dynamicTableIndex(i2)];
                Intrinsics.c(header2);
                i3 -= header2.hpackSize;
            }
            int i4 = this.maxDynamicTableByteCount;
            if (i3 > i4) {
                clearDynamicTable();
                return;
            }
            int evictToRecoverBytes = evictToRecoverBytes((this.dynamicTableByteCount + i3) - i4);
            if (i2 == -1) {
                int i5 = this.headerCount + 1;
                Header[] headerArr = this.dynamicTable;
                if (i5 > headerArr.length) {
                    Header[] headerArr2 = new Header[(headerArr.length * 2)];
                    System.arraycopy(headerArr, 0, headerArr2, headerArr.length, headerArr.length);
                    this.nextHeaderIndex = this.dynamicTable.length - 1;
                    this.dynamicTable = headerArr2;
                }
                int i6 = this.nextHeaderIndex;
                this.nextHeaderIndex = i6 - 1;
                this.dynamicTable[i6] = header;
                this.headerCount++;
            } else {
                this.dynamicTable[i2 + dynamicTableIndex(i2) + evictToRecoverBytes] = header;
            }
            this.dynamicTableByteCount += i3;
        }

        private final boolean isStaticHeader(int i2) {
            return i2 >= 0 && i2 <= Hpack.INSTANCE.getSTATIC_HEADER_TABLE().length - 1;
        }

        private final int readByte() throws IOException {
            return Util.and(this.source.readByte(), (int) JfifUtil.MARKER_FIRST_BYTE);
        }

        private final void readIndexedHeader(int i2) throws IOException {
            if (isStaticHeader(i2)) {
                this.headerList.add(Hpack.INSTANCE.getSTATIC_HEADER_TABLE()[i2]);
                return;
            }
            int dynamicTableIndex = dynamicTableIndex(i2 - Hpack.INSTANCE.getSTATIC_HEADER_TABLE().length);
            if (dynamicTableIndex >= 0) {
                Header[] headerArr = this.dynamicTable;
                if (dynamicTableIndex < headerArr.length) {
                    Header header = headerArr[dynamicTableIndex];
                    Intrinsics.c(header);
                    this.headerList.add(header);
                    return;
                }
            }
            throw new IOException("Header index too large " + (i2 + 1));
        }

        private final void readLiteralHeaderWithIncrementalIndexingIndexedName(int i2) throws IOException {
            insertIntoDynamicTable(-1, new Header(getName(i2), readByteString()));
        }

        private final void readLiteralHeaderWithIncrementalIndexingNewName() throws IOException {
            insertIntoDynamicTable(-1, new Header(Hpack.INSTANCE.checkLowercase(readByteString()), readByteString()));
        }

        private final void readLiteralHeaderWithoutIndexingIndexedName(int i2) throws IOException {
            this.headerList.add(new Header(getName(i2), readByteString()));
        }

        private final void readLiteralHeaderWithoutIndexingNewName() throws IOException {
            this.headerList.add(new Header(Hpack.INSTANCE.checkLowercase(readByteString()), readByteString()));
        }

        public final List<Header> getAndResetHeaderList() {
            List<Header> a02 = CollectionsKt___CollectionsKt.a0(this.headerList);
            this.headerList.clear();
            return a02;
        }

        public final int maxDynamicTableByteCount() {
            return this.maxDynamicTableByteCount;
        }

        public final ByteString readByteString() throws IOException {
            boolean z2;
            int readByte = readByte();
            if ((readByte & 128) == 128) {
                z2 = true;
            } else {
                z2 = false;
            }
            long readInt = (long) readInt(readByte, 127);
            if (!z2) {
                return this.source.Q(readInt);
            }
            Buffer buffer = new Buffer();
            Huffman.INSTANCE.decode(this.source, readInt, buffer);
            return buffer.c0();
        }

        public final void readHeaders() throws IOException {
            while (!this.source.V()) {
                int and = Util.and(this.source.readByte(), (int) JfifUtil.MARKER_FIRST_BYTE);
                if (and == 128) {
                    throw new IOException("index == 0");
                } else if ((and & 128) == 128) {
                    readIndexedHeader(readInt(and, 127) - 1);
                } else if (and == 64) {
                    readLiteralHeaderWithIncrementalIndexingNewName();
                } else if ((and & 64) == 64) {
                    readLiteralHeaderWithIncrementalIndexingIndexedName(readInt(and, 63) - 1);
                } else if ((and & 32) == 32) {
                    int readInt = readInt(and, 31);
                    this.maxDynamicTableByteCount = readInt;
                    if (readInt < 0 || readInt > this.headerTableSizeSetting) {
                        throw new IOException("Invalid dynamic table size update " + this.maxDynamicTableByteCount);
                    }
                    adjustDynamicTableByteCount();
                } else if (and == 16 || and == 0) {
                    readLiteralHeaderWithoutIndexingNewName();
                } else {
                    readLiteralHeaderWithoutIndexingIndexedName(readInt(and, 15) - 1);
                }
            }
        }

        public final int readInt(int i2, int i3) throws IOException {
            int i4 = i2 & i3;
            if (i4 < i3) {
                return i4;
            }
            int i5 = 0;
            while (true) {
                int readByte = readByte();
                if ((readByte & 128) == 0) {
                    return i3 + (readByte << i5);
                }
                i3 += (readByte & 127) << i5;
                i5 += 7;
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Reader(Source source2, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
            this(source2, i2, (i4 & 4) != 0 ? i2 : i3);
        }
    }

    public static final class Writer {
        public Header[] dynamicTable;
        public int dynamicTableByteCount;
        private boolean emitDynamicTableSizeUpdate;
        public int headerCount;
        public int headerTableSizeSetting;
        public int maxDynamicTableByteCount;
        private int nextHeaderIndex;
        private final Buffer out;
        private int smallestHeaderTableSizeSetting;
        private final boolean useCompression;

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public Writer(int i2, Buffer buffer) {
            this(i2, false, buffer, 2, (DefaultConstructorMarker) null);
            Intrinsics.f(buffer, "out");
        }

        public Writer(int i2, boolean z2, Buffer buffer) {
            Intrinsics.f(buffer, "out");
            this.headerTableSizeSetting = i2;
            this.useCompression = z2;
            this.out = buffer;
            this.smallestHeaderTableSizeSetting = Integer.MAX_VALUE;
            this.maxDynamicTableByteCount = i2;
            Header[] headerArr = new Header[8];
            this.dynamicTable = headerArr;
            this.nextHeaderIndex = headerArr.length - 1;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public Writer(Buffer buffer) {
            this(0, false, buffer, 3, (DefaultConstructorMarker) null);
            Intrinsics.f(buffer, "out");
        }

        private final void adjustDynamicTableByteCount() {
            int i2 = this.maxDynamicTableByteCount;
            int i3 = this.dynamicTableByteCount;
            if (i2 >= i3) {
                return;
            }
            if (i2 == 0) {
                clearDynamicTable();
            } else {
                evictToRecoverBytes(i3 - i2);
            }
        }

        private final void clearDynamicTable() {
            ArraysKt___ArraysJvmKt.m(this.dynamicTable, (Object) null, 0, 0, 6, (Object) null);
            this.nextHeaderIndex = this.dynamicTable.length - 1;
            this.headerCount = 0;
            this.dynamicTableByteCount = 0;
        }

        private final int evictToRecoverBytes(int i2) {
            int i3;
            int i4 = 0;
            if (i2 > 0) {
                int length = this.dynamicTable.length;
                while (true) {
                    length--;
                    i3 = this.nextHeaderIndex;
                    if (length < i3 || i2 <= 0) {
                        Header[] headerArr = this.dynamicTable;
                        System.arraycopy(headerArr, i3 + 1, headerArr, i3 + 1 + i4, this.headerCount);
                        Header[] headerArr2 = this.dynamicTable;
                        int i5 = this.nextHeaderIndex;
                        Arrays.fill(headerArr2, i5 + 1, i5 + 1 + i4, (Object) null);
                        this.nextHeaderIndex += i4;
                    } else {
                        Header header = this.dynamicTable[length];
                        Intrinsics.c(header);
                        i2 -= header.hpackSize;
                        int i6 = this.dynamicTableByteCount;
                        Header header2 = this.dynamicTable[length];
                        Intrinsics.c(header2);
                        this.dynamicTableByteCount = i6 - header2.hpackSize;
                        this.headerCount--;
                        i4++;
                    }
                }
                Header[] headerArr3 = this.dynamicTable;
                System.arraycopy(headerArr3, i3 + 1, headerArr3, i3 + 1 + i4, this.headerCount);
                Header[] headerArr22 = this.dynamicTable;
                int i52 = this.nextHeaderIndex;
                Arrays.fill(headerArr22, i52 + 1, i52 + 1 + i4, (Object) null);
                this.nextHeaderIndex += i4;
            }
            return i4;
        }

        private final void insertIntoDynamicTable(Header header) {
            int i2 = header.hpackSize;
            int i3 = this.maxDynamicTableByteCount;
            if (i2 > i3) {
                clearDynamicTable();
                return;
            }
            evictToRecoverBytes((this.dynamicTableByteCount + i2) - i3);
            int i4 = this.headerCount + 1;
            Header[] headerArr = this.dynamicTable;
            if (i4 > headerArr.length) {
                Header[] headerArr2 = new Header[(headerArr.length * 2)];
                System.arraycopy(headerArr, 0, headerArr2, headerArr.length, headerArr.length);
                this.nextHeaderIndex = this.dynamicTable.length - 1;
                this.dynamicTable = headerArr2;
            }
            int i5 = this.nextHeaderIndex;
            this.nextHeaderIndex = i5 - 1;
            this.dynamicTable[i5] = header;
            this.headerCount++;
            this.dynamicTableByteCount += i2;
        }

        public final void resizeHeaderTable(int i2) {
            this.headerTableSizeSetting = i2;
            int min = Math.min(i2, 16384);
            int i3 = this.maxDynamicTableByteCount;
            if (i3 != min) {
                if (min < i3) {
                    this.smallestHeaderTableSizeSetting = Math.min(this.smallestHeaderTableSizeSetting, min);
                }
                this.emitDynamicTableSizeUpdate = true;
                this.maxDynamicTableByteCount = min;
                adjustDynamicTableByteCount();
            }
        }

        public final void writeByteString(ByteString byteString) throws IOException {
            Intrinsics.f(byteString, "data");
            if (this.useCompression) {
                Huffman huffman = Huffman.INSTANCE;
                if (huffman.encodedLength(byteString) < byteString.size()) {
                    Buffer buffer = new Buffer();
                    huffman.encode(byteString, buffer);
                    ByteString c02 = buffer.c0();
                    writeInt(c02.size(), 127, 128);
                    this.out.h0(c02);
                    return;
                }
            }
            writeInt(byteString.size(), 127, 0);
            this.out.h0(byteString);
        }

        /* JADX WARNING: Removed duplicated region for block: B:27:0x0085  */
        /* JADX WARNING: Removed duplicated region for block: B:38:0x00ca  */
        /* JADX WARNING: Removed duplicated region for block: B:39:0x00d2  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void writeHeaders(java.util.List<okhttp3.internal.http2.Header> r14) throws java.io.IOException {
            /*
                r13 = this;
                java.lang.String r0 = "headerBlock"
                kotlin.jvm.internal.Intrinsics.f(r14, r0)
                boolean r0 = r13.emitDynamicTableSizeUpdate
                r1 = 0
                if (r0 == 0) goto L_0x0023
                int r0 = r13.smallestHeaderTableSizeSetting
                int r2 = r13.maxDynamicTableByteCount
                r3 = 32
                r4 = 31
                if (r0 >= r2) goto L_0x0017
                r13.writeInt(r0, r4, r3)
            L_0x0017:
                r13.emitDynamicTableSizeUpdate = r1
                r0 = 2147483647(0x7fffffff, float:NaN)
                r13.smallestHeaderTableSizeSetting = r0
                int r0 = r13.maxDynamicTableByteCount
                r13.writeInt(r0, r4, r3)
            L_0x0023:
                int r0 = r14.size()
                r2 = 0
            L_0x0028:
                if (r2 >= r0) goto L_0x010d
                java.lang.Object r3 = r14.get(r2)
                okhttp3.internal.http2.Header r3 = (okhttp3.internal.http2.Header) r3
                okio.ByteString r4 = r3.name
                okio.ByteString r4 = r4.w()
                okio.ByteString r5 = r3.value
                okhttp3.internal.http2.Hpack r6 = okhttp3.internal.http2.Hpack.INSTANCE
                java.util.Map r7 = r6.getNAME_TO_FIRST_INDEX()
                java.lang.Object r7 = r7.get(r4)
                java.lang.Integer r7 = (java.lang.Integer) r7
                r8 = -1
                r9 = 1
                if (r7 == 0) goto L_0x0081
                int r7 = r7.intValue()
                int r7 = r7 + r9
                r10 = 2
                if (r10 > r7) goto L_0x0056
                r10 = 8
                if (r7 >= r10) goto L_0x0056
                r10 = 1
                goto L_0x0057
            L_0x0056:
                r10 = 0
            L_0x0057:
                if (r10 == 0) goto L_0x007f
                okhttp3.internal.http2.Header[] r10 = r6.getSTATIC_HEADER_TABLE()
                int r11 = r7 + -1
                r10 = r10[r11]
                okio.ByteString r10 = r10.value
                boolean r10 = kotlin.jvm.internal.Intrinsics.a(r10, r5)
                if (r10 == 0) goto L_0x006b
                r6 = r7
                goto L_0x0083
            L_0x006b:
                okhttp3.internal.http2.Header[] r6 = r6.getSTATIC_HEADER_TABLE()
                r6 = r6[r7]
                okio.ByteString r6 = r6.value
                boolean r6 = kotlin.jvm.internal.Intrinsics.a(r6, r5)
                if (r6 == 0) goto L_0x007f
                int r6 = r7 + 1
                r12 = r7
                r7 = r6
                r6 = r12
                goto L_0x0083
            L_0x007f:
                r6 = r7
                goto L_0x0082
            L_0x0081:
                r6 = -1
            L_0x0082:
                r7 = -1
            L_0x0083:
                if (r7 != r8) goto L_0x00c8
                int r10 = r13.nextHeaderIndex
                int r10 = r10 + r9
                okhttp3.internal.http2.Header[] r9 = r13.dynamicTable
                int r9 = r9.length
            L_0x008b:
                if (r10 >= r9) goto L_0x00c8
                okhttp3.internal.http2.Header[] r11 = r13.dynamicTable
                r11 = r11[r10]
                kotlin.jvm.internal.Intrinsics.c(r11)
                okio.ByteString r11 = r11.name
                boolean r11 = kotlin.jvm.internal.Intrinsics.a(r11, r4)
                if (r11 == 0) goto L_0x00c5
                okhttp3.internal.http2.Header[] r11 = r13.dynamicTable
                r11 = r11[r10]
                kotlin.jvm.internal.Intrinsics.c(r11)
                okio.ByteString r11 = r11.value
                boolean r11 = kotlin.jvm.internal.Intrinsics.a(r11, r5)
                if (r11 == 0) goto L_0x00b7
                int r7 = r13.nextHeaderIndex
                int r10 = r10 - r7
                okhttp3.internal.http2.Hpack r7 = okhttp3.internal.http2.Hpack.INSTANCE
                okhttp3.internal.http2.Header[] r7 = r7.getSTATIC_HEADER_TABLE()
                int r7 = r7.length
                int r7 = r7 + r10
                goto L_0x00c8
            L_0x00b7:
                if (r6 != r8) goto L_0x00c5
                int r6 = r13.nextHeaderIndex
                int r6 = r10 - r6
                okhttp3.internal.http2.Hpack r11 = okhttp3.internal.http2.Hpack.INSTANCE
                okhttp3.internal.http2.Header[] r11 = r11.getSTATIC_HEADER_TABLE()
                int r11 = r11.length
                int r6 = r6 + r11
            L_0x00c5:
                int r10 = r10 + 1
                goto L_0x008b
            L_0x00c8:
                if (r7 == r8) goto L_0x00d2
                r3 = 127(0x7f, float:1.78E-43)
                r4 = 128(0x80, float:1.794E-43)
                r13.writeInt(r7, r3, r4)
                goto L_0x0109
            L_0x00d2:
                r7 = 64
                if (r6 != r8) goto L_0x00e5
                okio.Buffer r6 = r13.out
                r6.writeByte(r7)
                r13.writeByteString(r4)
                r13.writeByteString(r5)
                r13.insertIntoDynamicTable(r3)
                goto L_0x0109
            L_0x00e5:
                okio.ByteString r8 = okhttp3.internal.http2.Header.PSEUDO_PREFIX
                boolean r8 = r4.v(r8)
                if (r8 == 0) goto L_0x00fe
                okio.ByteString r8 = okhttp3.internal.http2.Header.TARGET_AUTHORITY
                boolean r4 = kotlin.jvm.internal.Intrinsics.a(r8, r4)
                if (r4 != 0) goto L_0x00fe
                r3 = 15
                r13.writeInt(r6, r3, r1)
                r13.writeByteString(r5)
                goto L_0x0109
            L_0x00fe:
                r4 = 63
                r13.writeInt(r6, r4, r7)
                r13.writeByteString(r5)
                r13.insertIntoDynamicTable(r3)
            L_0x0109:
                int r2 = r2 + 1
                goto L_0x0028
            L_0x010d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Hpack.Writer.writeHeaders(java.util.List):void");
        }

        public final void writeInt(int i2, int i3, int i4) {
            if (i2 < i3) {
                this.out.writeByte(i2 | i4);
                return;
            }
            this.out.writeByte(i4 | i3);
            int i5 = i2 - i3;
            while (i5 >= 128) {
                this.out.writeByte(128 | (i5 & 127));
                i5 >>>= 7;
            }
            this.out.writeByte(i5);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Writer(int i2, boolean z2, Buffer buffer, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? 4096 : i2, (i3 & 2) != 0 ? true : z2, buffer);
        }
    }
}
