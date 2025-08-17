package com.google.protobuf;

import com.facebook.imageutils.JfifUtil;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;

final class Utf8 {
    private static final long ASCII_MASK_LONG = -9187201950435737472L;
    static final int COMPLETE = 0;
    static final int MALFORMED = -1;
    static final int MAX_BYTES_PER_CHAR = 3;
    private static final int UNSAFE_COUNT_ASCII_THRESHOLD = 16;
    private static final Processor processor;

    private static class DecodeUtil {
        private DecodeUtil() {
        }

        /* access modifiers changed from: private */
        public static void handleFourBytes(byte b2, byte b3, byte b4, byte b5, char[] cArr, int i2) throws InvalidProtocolBufferException {
            if (isNotTrailingByte(b3) || (((b2 << 28) + (b3 + 112)) >> 30) != 0 || isNotTrailingByte(b4) || isNotTrailingByte(b5)) {
                throw InvalidProtocolBufferException.invalidUtf8();
            }
            int trailingByteValue = ((b2 & 7) << 18) | (trailingByteValue(b3) << 12) | (trailingByteValue(b4) << 6) | trailingByteValue(b5);
            cArr[i2] = highSurrogate(trailingByteValue);
            cArr[i2 + 1] = lowSurrogate(trailingByteValue);
        }

        /* access modifiers changed from: private */
        public static void handleOneByte(byte b2, char[] cArr, int i2) {
            cArr[i2] = (char) b2;
        }

        /* access modifiers changed from: private */
        public static void handleThreeBytes(byte b2, byte b3, byte b4, char[] cArr, int i2) throws InvalidProtocolBufferException {
            if (isNotTrailingByte(b3) || ((b2 == -32 && b3 < -96) || ((b2 == -19 && b3 >= -96) || isNotTrailingByte(b4)))) {
                throw InvalidProtocolBufferException.invalidUtf8();
            }
            cArr[i2] = (char) (((b2 & 15) << 12) | (trailingByteValue(b3) << 6) | trailingByteValue(b4));
        }

        /* access modifiers changed from: private */
        public static void handleTwoBytes(byte b2, byte b3, char[] cArr, int i2) throws InvalidProtocolBufferException {
            if (b2 < -62 || isNotTrailingByte(b3)) {
                throw InvalidProtocolBufferException.invalidUtf8();
            }
            cArr[i2] = (char) (((b2 & 31) << 6) | trailingByteValue(b3));
        }

        private static char highSurrogate(int i2) {
            return (char) ((i2 >>> 10) + 55232);
        }

        private static boolean isNotTrailingByte(byte b2) {
            return b2 > -65;
        }

        /* access modifiers changed from: private */
        public static boolean isOneByte(byte b2) {
            return b2 >= 0;
        }

        /* access modifiers changed from: private */
        public static boolean isThreeBytes(byte b2) {
            return b2 < -16;
        }

        /* access modifiers changed from: private */
        public static boolean isTwoBytes(byte b2) {
            return b2 < -32;
        }

        private static char lowSurrogate(int i2) {
            return (char) ((i2 & 1023) + 56320);
        }

        private static int trailingByteValue(byte b2) {
            return b2 & 63;
        }
    }

    static abstract class Processor {
        Processor() {
        }

        /* access modifiers changed from: package-private */
        public final String decodeUtf8(ByteBuffer byteBuffer, int i2, int i3) throws InvalidProtocolBufferException {
            if (byteBuffer.hasArray()) {
                return decodeUtf8(byteBuffer.array(), byteBuffer.arrayOffset() + i2, i3);
            } else if (byteBuffer.isDirect()) {
                return decodeUtf8Direct(byteBuffer, i2, i3);
            } else {
                return decodeUtf8Default(byteBuffer, i2, i3);
            }
        }

        /* access modifiers changed from: package-private */
        public abstract String decodeUtf8(byte[] bArr, int i2, int i3) throws InvalidProtocolBufferException;

        /* access modifiers changed from: package-private */
        public final String decodeUtf8Default(ByteBuffer byteBuffer, int i2, int i3) throws InvalidProtocolBufferException {
            if ((i2 | i3 | ((byteBuffer.limit() - i2) - i3)) >= 0) {
                int i4 = i2 + i3;
                char[] cArr = new char[i3];
                int i5 = 0;
                while (r13 < i4) {
                    byte b2 = byteBuffer.get(r13);
                    if (!DecodeUtil.isOneByte(b2)) {
                        break;
                    }
                    i2 = r13 + 1;
                    DecodeUtil.handleOneByte(b2, cArr, i5);
                    i5++;
                }
                int i6 = i5;
                while (r13 < i4) {
                    int i7 = r13 + 1;
                    byte b3 = byteBuffer.get(r13);
                    if (DecodeUtil.isOneByte(b3)) {
                        int i8 = i6 + 1;
                        DecodeUtil.handleOneByte(b3, cArr, i6);
                        while (i7 < i4) {
                            byte b4 = byteBuffer.get(i7);
                            if (!DecodeUtil.isOneByte(b4)) {
                                break;
                            }
                            i7++;
                            DecodeUtil.handleOneByte(b4, cArr, i8);
                            i8++;
                        }
                        r13 = i7;
                        i6 = i8;
                    } else if (DecodeUtil.isTwoBytes(b3)) {
                        if (i7 < i4) {
                            DecodeUtil.handleTwoBytes(b3, byteBuffer.get(i7), cArr, i6);
                            r13 = i7 + 1;
                            i6++;
                        } else {
                            throw InvalidProtocolBufferException.invalidUtf8();
                        }
                    } else if (DecodeUtil.isThreeBytes(b3)) {
                        if (i7 < i4 - 1) {
                            int i9 = i7 + 1;
                            DecodeUtil.handleThreeBytes(b3, byteBuffer.get(i7), byteBuffer.get(i9), cArr, i6);
                            r13 = i9 + 1;
                            i6++;
                        } else {
                            throw InvalidProtocolBufferException.invalidUtf8();
                        }
                    } else if (i7 < i4 - 2) {
                        int i10 = i7 + 1;
                        byte b5 = byteBuffer.get(i7);
                        int i11 = i10 + 1;
                        DecodeUtil.handleFourBytes(b3, b5, byteBuffer.get(i10), byteBuffer.get(i11), cArr, i6);
                        r13 = i11 + 1;
                        i6 = i6 + 1 + 1;
                    } else {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                }
                return new String(cArr, 0, i6);
            }
            throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", new Object[]{Integer.valueOf(byteBuffer.limit()), Integer.valueOf(i2), Integer.valueOf(i3)}));
        }

        /* access modifiers changed from: package-private */
        public abstract String decodeUtf8Direct(ByteBuffer byteBuffer, int i2, int i3) throws InvalidProtocolBufferException;

        /* access modifiers changed from: package-private */
        public abstract int encodeUtf8(CharSequence charSequence, byte[] bArr, int i2, int i3);

        /* access modifiers changed from: package-private */
        public final void encodeUtf8(CharSequence charSequence, ByteBuffer byteBuffer) {
            if (byteBuffer.hasArray()) {
                int arrayOffset = byteBuffer.arrayOffset();
                ByteBuffer byteBuffer2 = (ByteBuffer) byteBuffer.position(Utf8.encode(charSequence, byteBuffer.array(), byteBuffer.position() + arrayOffset, byteBuffer.remaining()) - arrayOffset);
            } else if (byteBuffer.isDirect()) {
                encodeUtf8Direct(charSequence, byteBuffer);
            } else {
                encodeUtf8Default(charSequence, byteBuffer);
            }
        }

        /* access modifiers changed from: package-private */
        public final void encodeUtf8Default(CharSequence charSequence, ByteBuffer byteBuffer) {
            int i2;
            int length = charSequence.length();
            int position = byteBuffer.position();
            int i3 = 0;
            while (i3 < length) {
                try {
                    char charAt = charSequence.charAt(i3);
                    if (charAt >= 128) {
                        break;
                    }
                    byteBuffer.put(position + i3, (byte) charAt);
                    i3++;
                } catch (IndexOutOfBoundsException unused) {
                    throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(i3) + " at index " + (byteBuffer.position() + Math.max(i3, (position - byteBuffer.position()) + 1)));
                }
            }
            if (i3 == length) {
                ByteBuffer byteBuffer2 = (ByteBuffer) byteBuffer.position(position + i3);
                return;
            }
            position += i3;
            while (i3 < length) {
                char charAt2 = charSequence.charAt(i3);
                if (charAt2 < 128) {
                    byteBuffer.put(position, (byte) charAt2);
                } else if (charAt2 < 2048) {
                    i2 = position + 1;
                    try {
                        byteBuffer.put(position, (byte) ((charAt2 >>> 6) | JfifUtil.MARKER_SOFn));
                        byteBuffer.put(i2, (byte) ((charAt2 & '?') | 128));
                        position = i2;
                    } catch (IndexOutOfBoundsException unused2) {
                        position = i2;
                        throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(i3) + " at index " + (byteBuffer.position() + Math.max(i3, (position - byteBuffer.position()) + 1)));
                    }
                } else if (charAt2 < 55296 || 57343 < charAt2) {
                    i2 = position + 1;
                    byteBuffer.put(position, (byte) ((charAt2 >>> 12) | 224));
                    position = i2 + 1;
                    byteBuffer.put(i2, (byte) (((charAt2 >>> 6) & 63) | 128));
                    byteBuffer.put(position, (byte) ((charAt2 & '?') | 128));
                } else {
                    int i4 = i3 + 1;
                    if (i4 != length) {
                        try {
                            char charAt3 = charSequence.charAt(i4);
                            if (Character.isSurrogatePair(charAt2, charAt3)) {
                                int codePoint = Character.toCodePoint(charAt2, charAt3);
                                int i5 = position + 1;
                                try {
                                    byteBuffer.put(position, (byte) ((codePoint >>> 18) | 240));
                                    position = i5 + 1;
                                    byteBuffer.put(i5, (byte) (((codePoint >>> 12) & 63) | 128));
                                    i5 = position + 1;
                                    byteBuffer.put(position, (byte) (((codePoint >>> 6) & 63) | 128));
                                    byteBuffer.put(i5, (byte) ((codePoint & 63) | 128));
                                    position = i5;
                                    i3 = i4;
                                } catch (IndexOutOfBoundsException unused3) {
                                    position = i5;
                                    i3 = i4;
                                    throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(i3) + " at index " + (byteBuffer.position() + Math.max(i3, (position - byteBuffer.position()) + 1)));
                                }
                            } else {
                                i3 = i4;
                            }
                        } catch (IndexOutOfBoundsException unused4) {
                            i3 = i4;
                            throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(i3) + " at index " + (byteBuffer.position() + Math.max(i3, (position - byteBuffer.position()) + 1)));
                        }
                    }
                    throw new UnpairedSurrogateException(i3, length);
                }
                i3++;
                position++;
            }
            ByteBuffer byteBuffer3 = (ByteBuffer) byteBuffer.position(position);
        }

        /* access modifiers changed from: package-private */
        public abstract void encodeUtf8Direct(CharSequence charSequence, ByteBuffer byteBuffer);

        /* access modifiers changed from: package-private */
        public final boolean isValidUtf8(byte[] bArr, int i2, int i3) {
            return partialIsValidUtf8(0, bArr, i2, i3) == 0;
        }

        /* access modifiers changed from: package-private */
        public final int partialIsValidUtf8(int i2, ByteBuffer byteBuffer, int i3, int i4) {
            if (byteBuffer.hasArray()) {
                int arrayOffset = byteBuffer.arrayOffset();
                return partialIsValidUtf8(i2, byteBuffer.array(), i3 + arrayOffset, arrayOffset + i4);
            } else if (byteBuffer.isDirect()) {
                return partialIsValidUtf8Direct(i2, byteBuffer, i3, i4);
            } else {
                return partialIsValidUtf8Default(i2, byteBuffer, i3, i4);
            }
        }

        /* access modifiers changed from: package-private */
        public abstract int partialIsValidUtf8(int i2, byte[] bArr, int i3, int i4);

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x004c, code lost:
            if (r8.get(r9) > -65) goto L_0x004e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x008f, code lost:
            if (r8.get(r7) > -65) goto L_0x0091;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0017, code lost:
            if (r8.get(r9) > -65) goto L_0x001d;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final int partialIsValidUtf8Default(int r7, java.nio.ByteBuffer r8, int r9, int r10) {
            /*
                r6 = this;
                if (r7 == 0) goto L_0x0092
                if (r9 < r10) goto L_0x0005
                return r7
            L_0x0005:
                byte r0 = (byte) r7
                r1 = -32
                r2 = -1
                r3 = -65
                if (r0 >= r1) goto L_0x001e
                r7 = -62
                if (r0 < r7) goto L_0x001d
                int r7 = r9 + 1
                byte r9 = r8.get(r9)
                if (r9 <= r3) goto L_0x001a
                goto L_0x001d
            L_0x001a:
                r9 = r7
                goto L_0x0092
            L_0x001d:
                return r2
            L_0x001e:
                r4 = -16
                if (r0 >= r4) goto L_0x004f
                int r7 = r7 >> 8
                int r7 = ~r7
                byte r7 = (byte) r7
                if (r7 != 0) goto L_0x0038
                int r7 = r9 + 1
                byte r9 = r8.get(r9)
                if (r7 < r10) goto L_0x0035
                int r7 = com.google.protobuf.Utf8.incompleteStateFor(r0, r9)
                return r7
            L_0x0035:
                r5 = r9
                r9 = r7
                r7 = r5
            L_0x0038:
                if (r7 > r3) goto L_0x004e
                r4 = -96
                if (r0 != r1) goto L_0x0040
                if (r7 < r4) goto L_0x004e
            L_0x0040:
                r1 = -19
                if (r0 != r1) goto L_0x0046
                if (r7 >= r4) goto L_0x004e
            L_0x0046:
                int r7 = r9 + 1
                byte r9 = r8.get(r9)
                if (r9 <= r3) goto L_0x001a
            L_0x004e:
                return r2
            L_0x004f:
                int r1 = r7 >> 8
                int r1 = ~r1
                byte r1 = (byte) r1
                if (r1 != 0) goto L_0x0064
                int r7 = r9 + 1
                byte r1 = r8.get(r9)
                if (r7 < r10) goto L_0x0062
                int r7 = com.google.protobuf.Utf8.incompleteStateFor(r0, r1)
                return r7
            L_0x0062:
                r9 = 0
                goto L_0x006a
            L_0x0064:
                int r7 = r7 >> 16
                byte r7 = (byte) r7
                r5 = r9
                r9 = r7
                r7 = r5
            L_0x006a:
                if (r9 != 0) goto L_0x007c
                int r9 = r7 + 1
                byte r7 = r8.get(r7)
                if (r9 < r10) goto L_0x0079
                int r7 = com.google.protobuf.Utf8.incompleteStateFor((int) r0, (int) r1, (int) r7)
                return r7
            L_0x0079:
                r5 = r9
                r9 = r7
                r7 = r5
            L_0x007c:
                if (r1 > r3) goto L_0x0091
                int r0 = r0 << 28
                int r1 = r1 + 112
                int r0 = r0 + r1
                int r0 = r0 >> 30
                if (r0 != 0) goto L_0x0091
                if (r9 > r3) goto L_0x0091
                int r9 = r7 + 1
                byte r7 = r8.get(r7)
                if (r7 <= r3) goto L_0x0092
            L_0x0091:
                return r2
            L_0x0092:
                int r7 = partialIsValidUtf8(r8, r9, r10)
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.Utf8.Processor.partialIsValidUtf8Default(int, java.nio.ByteBuffer, int, int):int");
        }

        /* access modifiers changed from: package-private */
        public abstract int partialIsValidUtf8Direct(int i2, ByteBuffer byteBuffer, int i3, int i4);

        /* access modifiers changed from: package-private */
        public final boolean isValidUtf8(ByteBuffer byteBuffer, int i2, int i3) {
            return partialIsValidUtf8(0, byteBuffer, i2, i3) == 0;
        }

        private static int partialIsValidUtf8(ByteBuffer byteBuffer, int i2, int i3) {
            int access$200 = i2 + Utf8.estimateConsecutiveAscii(byteBuffer, i2, i3);
            while (access$200 < i3) {
                int i4 = access$200 + 1;
                byte b2 = byteBuffer.get(access$200);
                if (b2 < 0) {
                    if (b2 < -32) {
                        if (i4 >= i3) {
                            return b2;
                        }
                        if (b2 < -62 || byteBuffer.get(i4) > -65) {
                            return -1;
                        }
                        i4++;
                    } else if (b2 < -16) {
                        if (i4 >= i3 - 1) {
                            return Utf8.incompleteStateFor(byteBuffer, b2, i4, i3 - i4);
                        }
                        int i5 = i4 + 1;
                        byte b3 = byteBuffer.get(i4);
                        if (b3 > -65 || ((b2 == -32 && b3 < -96) || ((b2 == -19 && b3 >= -96) || byteBuffer.get(i5) > -65))) {
                            return -1;
                        }
                        access$200 = i5 + 1;
                    } else if (i4 >= i3 - 2) {
                        return Utf8.incompleteStateFor(byteBuffer, b2, i4, i3 - i4);
                    } else {
                        int i6 = i4 + 1;
                        byte b4 = byteBuffer.get(i4);
                        if (b4 <= -65 && (((b2 << 28) + (b4 + 112)) >> 30) == 0) {
                            int i7 = i6 + 1;
                            if (byteBuffer.get(i6) <= -65) {
                                i4 = i7 + 1;
                                if (byteBuffer.get(i7) > -65) {
                                }
                            }
                        }
                        return -1;
                    }
                }
                access$200 = i4;
            }
            return 0;
        }
    }

    static class UnpairedSurrogateException extends IllegalArgumentException {
        UnpairedSurrogateException(int i2, int i3) {
            super("Unpaired surrogate at index " + i2 + " of " + i3);
        }
    }

    static {
        Processor processor2;
        if (!UnsafeProcessor.isAvailable() || Android.isOnAndroidDevice()) {
            processor2 = new SafeProcessor();
        } else {
            processor2 = new UnsafeProcessor();
        }
        processor = processor2;
    }

    private Utf8() {
    }

    static String decodeUtf8(ByteBuffer byteBuffer, int i2, int i3) throws InvalidProtocolBufferException {
        return processor.decodeUtf8(byteBuffer, i2, i3);
    }

    static int encode(CharSequence charSequence, byte[] bArr, int i2, int i3) {
        return processor.encodeUtf8(charSequence, bArr, i2, i3);
    }

    static void encodeUtf8(CharSequence charSequence, ByteBuffer byteBuffer) {
        processor.encodeUtf8(charSequence, byteBuffer);
    }

    static int encodedLength(CharSequence charSequence) {
        int length = charSequence.length();
        int i2 = 0;
        while (i2 < length && charSequence.charAt(i2) < 128) {
            i2++;
        }
        int i3 = length;
        while (true) {
            if (i2 < length) {
                char charAt = charSequence.charAt(i2);
                if (charAt >= 2048) {
                    i3 += encodedLengthGeneral(charSequence, i2);
                    break;
                }
                i3 += (127 - charAt) >>> 31;
                i2++;
            } else {
                break;
            }
        }
        if (i3 >= length) {
            return i3;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (((long) i3) + 4294967296L));
    }

    private static int encodedLengthGeneral(CharSequence charSequence, int i2) {
        int length = charSequence.length();
        int i3 = 0;
        while (i2 < length) {
            char charAt = charSequence.charAt(i2);
            if (charAt < 2048) {
                i3 += (127 - charAt) >>> 31;
            } else {
                i3 += 2;
                if (55296 <= charAt && charAt <= 57343) {
                    if (Character.codePointAt(charSequence, i2) >= 65536) {
                        i2++;
                    } else {
                        throw new UnpairedSurrogateException(i2, length);
                    }
                }
            }
            i2++;
        }
        return i3;
    }

    /* access modifiers changed from: private */
    public static int estimateConsecutiveAscii(ByteBuffer byteBuffer, int i2, int i3) {
        int i4 = i3 - 7;
        int i5 = i2;
        while (i5 < i4 && (byteBuffer.getLong(i5) & ASCII_MASK_LONG) == 0) {
            i5 += 8;
        }
        return i5 - i2;
    }

    /* access modifiers changed from: private */
    public static int incompleteStateFor(int i2) {
        if (i2 > -12) {
            return -1;
        }
        return i2;
    }

    /* access modifiers changed from: private */
    public static int incompleteStateFor(int i2, int i3) {
        if (i2 > -12 || i3 > -65) {
            return -1;
        }
        return i2 ^ (i3 << 8);
    }

    /* access modifiers changed from: private */
    public static int incompleteStateFor(int i2, int i3, int i4) {
        if (i2 > -12 || i3 > -65 || i4 > -65) {
            return -1;
        }
        return (i2 ^ (i3 << 8)) ^ (i4 << 16);
    }

    /* access modifiers changed from: private */
    public static int incompleteStateFor(byte[] bArr, int i2, int i3) {
        byte b2 = bArr[i2 - 1];
        int i4 = i3 - i2;
        if (i4 == 0) {
            return incompleteStateFor(b2);
        }
        if (i4 == 1) {
            return incompleteStateFor(b2, bArr[i2]);
        }
        if (i4 == 2) {
            return incompleteStateFor((int) b2, (int) bArr[i2], (int) bArr[i2 + 1]);
        }
        throw new AssertionError();
    }

    static boolean isValidUtf8(byte[] bArr) {
        return processor.isValidUtf8(bArr, 0, bArr.length);
    }

    static int partialIsValidUtf8(int i2, byte[] bArr, int i3, int i4) {
        return processor.partialIsValidUtf8(i2, bArr, i3, i4);
    }

    static String decodeUtf8(byte[] bArr, int i2, int i3) throws InvalidProtocolBufferException {
        return processor.decodeUtf8(bArr, i2, i3);
    }

    static boolean isValidUtf8(byte[] bArr, int i2, int i3) {
        return processor.isValidUtf8(bArr, i2, i3);
    }

    static int partialIsValidUtf8(int i2, ByteBuffer byteBuffer, int i3, int i4) {
        return processor.partialIsValidUtf8(i2, byteBuffer, i3, i4);
    }

    static final class UnsafeProcessor extends Processor {
        UnsafeProcessor() {
        }

        static boolean isAvailable() {
            return UnsafeUtil.hasUnsafeArrayOperations() && UnsafeUtil.hasUnsafeByteBufferOperations();
        }

        private static int unsafeEstimateConsecutiveAscii(byte[] bArr, long j2, int i2) {
            int i3 = 0;
            if (i2 < 16) {
                return 0;
            }
            int i4 = 8 - (((int) j2) & 7);
            while (i3 < i4) {
                long j3 = 1 + j2;
                if (UnsafeUtil.getByte(bArr, j2) < 0) {
                    return i3;
                }
                i3++;
                j2 = j3;
            }
            while (true) {
                int i5 = i3 + 8;
                if (i5 <= i2 && (UnsafeUtil.getLong((Object) bArr, UnsafeUtil.BYTE_ARRAY_BASE_OFFSET + j2) & Utf8.ASCII_MASK_LONG) == 0) {
                    j2 += 8;
                    i3 = i5;
                }
            }
            while (i3 < i2) {
                long j4 = j2 + 1;
                if (UnsafeUtil.getByte(bArr, j2) < 0) {
                    return i3;
                }
                i3++;
                j2 = j4;
            }
            return i2;
        }

        private static int unsafeIncompleteStateFor(byte[] bArr, int i2, long j2, int i3) {
            if (i3 == 0) {
                return Utf8.incompleteStateFor(i2);
            }
            if (i3 == 1) {
                return Utf8.incompleteStateFor(i2, UnsafeUtil.getByte(bArr, j2));
            }
            if (i3 == 2) {
                return Utf8.incompleteStateFor(i2, (int) UnsafeUtil.getByte(bArr, j2), (int) UnsafeUtil.getByte(bArr, j2 + 1));
            }
            throw new AssertionError();
        }

        /* access modifiers changed from: package-private */
        public String decodeUtf8(byte[] bArr, int i2, int i3) throws InvalidProtocolBufferException {
            Charset charset = Internal.UTF_8;
            String str = new String(bArr, i2, i3, charset);
            if (!str.contains("�") || Arrays.equals(str.getBytes(charset), Arrays.copyOfRange(bArr, i2, i3 + i2))) {
                return str;
            }
            throw InvalidProtocolBufferException.invalidUtf8();
        }

        /* access modifiers changed from: package-private */
        public String decodeUtf8Direct(ByteBuffer byteBuffer, int i2, int i3) throws InvalidProtocolBufferException {
            long j2;
            int i4 = i2;
            int i5 = i3;
            if ((i4 | i5 | ((byteBuffer.limit() - i4) - i5)) >= 0) {
                long addressOffset = UnsafeUtil.addressOffset(byteBuffer) + ((long) i4);
                long j3 = ((long) i5) + addressOffset;
                char[] cArr = new char[i5];
                int i6 = 0;
                while (addressOffset < j3) {
                    byte b2 = UnsafeUtil.getByte(addressOffset);
                    if (!DecodeUtil.isOneByte(b2)) {
                        break;
                    }
                    addressOffset++;
                    DecodeUtil.handleOneByte(b2, cArr, i6);
                    i6++;
                }
                while (true) {
                    int i7 = i6;
                    while (j2 < j3) {
                        long j4 = j2 + 1;
                        byte b3 = UnsafeUtil.getByte(j2);
                        if (DecodeUtil.isOneByte(b3)) {
                            int i8 = i7 + 1;
                            DecodeUtil.handleOneByte(b3, cArr, i7);
                            while (j4 < j3) {
                                byte b4 = UnsafeUtil.getByte(j4);
                                if (!DecodeUtil.isOneByte(b4)) {
                                    break;
                                }
                                j4++;
                                DecodeUtil.handleOneByte(b4, cArr, i8);
                                i8++;
                            }
                            i7 = i8;
                            j2 = j4;
                        } else if (DecodeUtil.isTwoBytes(b3)) {
                            if (j4 < j3) {
                                j2 = j4 + 1;
                                DecodeUtil.handleTwoBytes(b3, UnsafeUtil.getByte(j4), cArr, i7);
                                i7++;
                            } else {
                                throw InvalidProtocolBufferException.invalidUtf8();
                            }
                        } else if (DecodeUtil.isThreeBytes(b3)) {
                            if (j4 < j3 - 1) {
                                long j5 = j4 + 1;
                                DecodeUtil.handleThreeBytes(b3, UnsafeUtil.getByte(j4), UnsafeUtil.getByte(j5), cArr, i7);
                                i7++;
                                j2 = j5 + 1;
                            } else {
                                throw InvalidProtocolBufferException.invalidUtf8();
                            }
                        } else if (j4 < j3 - 2) {
                            long j6 = j4 + 1;
                            byte b5 = UnsafeUtil.getByte(j4);
                            long j7 = j6 + 1;
                            byte b6 = UnsafeUtil.getByte(j6);
                            addressOffset = j7 + 1;
                            DecodeUtil.handleFourBytes(b3, b5, b6, UnsafeUtil.getByte(j7), cArr, i7);
                            i6 = i7 + 1 + 1;
                        } else {
                            throw InvalidProtocolBufferException.invalidUtf8();
                        }
                    }
                    return new String(cArr, 0, i7);
                }
            }
            throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", new Object[]{Integer.valueOf(byteBuffer.limit()), Integer.valueOf(i2), Integer.valueOf(i3)}));
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Removed duplicated region for block: B:11:0x0031  */
        /* JADX WARNING: Removed duplicated region for block: B:13:0x0033 A[LOOP:1: B:13:0x0033->B:38:0x00fb, LOOP_START, PHI: r2 r3 r4 r11 
          PHI: (r2v3 int) = (r2v2 int), (r2v5 int) binds: [B:10:0x002f, B:38:0x00fb] A[DONT_GENERATE, DONT_INLINE]
          PHI: (r3v2 char) = (r3v1 char), (r3v3 char) binds: [B:10:0x002f, B:38:0x00fb] A[DONT_GENERATE, DONT_INLINE]
          PHI: (r4v3 long) = (r4v2 long), (r4v5 long) binds: [B:10:0x002f, B:38:0x00fb] A[DONT_GENERATE, DONT_INLINE]
          PHI: (r11v3 long) = (r11v2 long), (r11v4 long) binds: [B:10:0x002f, B:38:0x00fb] A[DONT_GENERATE, DONT_INLINE]] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int encodeUtf8(java.lang.CharSequence r23, byte[] r24, int r25, int r26) {
            /*
                r22 = this;
                r0 = r23
                r1 = r24
                r2 = r25
                r3 = r26
                long r4 = (long) r2
                long r6 = (long) r3
                long r6 = r6 + r4
                int r8 = r23.length()
                java.lang.String r9 = " at index "
                java.lang.String r10 = "Failed writing "
                if (r8 > r3) goto L_0x0144
                int r11 = r1.length
                int r11 = r11 - r3
                if (r11 < r2) goto L_0x0144
                r2 = 0
            L_0x001a:
                r3 = 128(0x80, float:1.794E-43)
                r11 = 1
                if (r2 >= r8) goto L_0x002f
                char r13 = r0.charAt(r2)
                if (r13 >= r3) goto L_0x002f
                long r11 = r11 + r4
                byte r3 = (byte) r13
                com.google.protobuf.UnsafeUtil.putByte((byte[]) r1, (long) r4, (byte) r3)
                int r2 = r2 + 1
                r4 = r11
                goto L_0x001a
            L_0x002f:
                if (r2 != r8) goto L_0x0033
                int r0 = (int) r4
                return r0
            L_0x0033:
                if (r2 >= r8) goto L_0x0142
                char r13 = r0.charAt(r2)
                if (r13 >= r3) goto L_0x004b
                int r14 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
                if (r14 >= 0) goto L_0x004b
                long r14 = r4 + r11
                byte r13 = (byte) r13
                com.google.protobuf.UnsafeUtil.putByte((byte[]) r1, (long) r4, (byte) r13)
                r4 = r11
                r12 = r14
            L_0x0047:
                r11 = 128(0x80, float:1.794E-43)
                goto L_0x00fb
            L_0x004b:
                r14 = 2048(0x800, float:2.87E-42)
                if (r13 >= r14) goto L_0x0075
                r14 = 2
                long r14 = r6 - r14
                int r16 = (r4 > r14 ? 1 : (r4 == r14 ? 0 : -1))
                if (r16 > 0) goto L_0x0075
                long r14 = r4 + r11
                int r3 = r13 >>> 6
                r3 = r3 | 960(0x3c0, float:1.345E-42)
                byte r3 = (byte) r3
                com.google.protobuf.UnsafeUtil.putByte((byte[]) r1, (long) r4, (byte) r3)
                long r3 = r14 + r11
                r5 = r13 & 63
                r13 = 128(0x80, float:1.794E-43)
                r5 = r5 | r13
                byte r5 = (byte) r5
                com.google.protobuf.UnsafeUtil.putByte((byte[]) r1, (long) r14, (byte) r5)
                r20 = r11
                r11 = 128(0x80, float:1.794E-43)
                r12 = r3
                r4 = r20
                goto L_0x00fb
            L_0x0075:
                r3 = 57343(0xdfff, float:8.0355E-41)
                r14 = 55296(0xd800, float:7.7486E-41)
                if (r13 < r14) goto L_0x007f
                if (r3 >= r13) goto L_0x00ae
            L_0x007f:
                r15 = 3
                long r15 = r6 - r15
                int r17 = (r4 > r15 ? 1 : (r4 == r15 ? 0 : -1))
                if (r17 > 0) goto L_0x00ae
                long r14 = r4 + r11
                int r3 = r13 >>> 12
                r3 = r3 | 480(0x1e0, float:6.73E-43)
                byte r3 = (byte) r3
                com.google.protobuf.UnsafeUtil.putByte((byte[]) r1, (long) r4, (byte) r3)
                long r3 = r14 + r11
                int r5 = r13 >>> 6
                r5 = r5 & 63
                r11 = 128(0x80, float:1.794E-43)
                r5 = r5 | r11
                byte r5 = (byte) r5
                com.google.protobuf.UnsafeUtil.putByte((byte[]) r1, (long) r14, (byte) r5)
                r14 = 1
                long r18 = r3 + r14
                r5 = r13 & 63
                r5 = r5 | r11
                byte r5 = (byte) r5
                com.google.protobuf.UnsafeUtil.putByte((byte[]) r1, (long) r3, (byte) r5)
                r12 = r18
                r4 = 1
                goto L_0x0047
            L_0x00ae:
                r11 = 4
                long r11 = r6 - r11
                int r15 = (r4 > r11 ? 1 : (r4 == r11 ? 0 : -1))
                if (r15 > 0) goto L_0x010f
                int r3 = r2 + 1
                if (r3 == r8) goto L_0x0107
                char r2 = r0.charAt(r3)
                boolean r11 = java.lang.Character.isSurrogatePair(r13, r2)
                if (r11 == 0) goto L_0x0106
                int r2 = java.lang.Character.toCodePoint(r13, r2)
                r11 = 1
                long r13 = r4 + r11
                int r15 = r2 >>> 18
                r15 = r15 | 240(0xf0, float:3.36E-43)
                byte r15 = (byte) r15
                com.google.protobuf.UnsafeUtil.putByte((byte[]) r1, (long) r4, (byte) r15)
                long r4 = r13 + r11
                int r15 = r2 >>> 12
                r15 = r15 & 63
                r11 = 128(0x80, float:1.794E-43)
                r12 = r15 | 128(0x80, float:1.794E-43)
                byte r12 = (byte) r12
                com.google.protobuf.UnsafeUtil.putByte((byte[]) r1, (long) r13, (byte) r12)
                r12 = 1
                long r14 = r4 + r12
                int r16 = r2 >>> 6
                r12 = r16 & 63
                r12 = r12 | r11
                byte r12 = (byte) r12
                com.google.protobuf.UnsafeUtil.putByte((byte[]) r1, (long) r4, (byte) r12)
                r4 = 1
                long r12 = r14 + r4
                r2 = r2 & 63
                r2 = r2 | r11
                byte r2 = (byte) r2
                com.google.protobuf.UnsafeUtil.putByte((byte[]) r1, (long) r14, (byte) r2)
                r2 = r3
            L_0x00fb:
                int r2 = r2 + 1
                r3 = 128(0x80, float:1.794E-43)
                r20 = r4
                r4 = r12
                r11 = r20
                goto L_0x0033
            L_0x0106:
                r2 = r3
            L_0x0107:
                com.google.protobuf.Utf8$UnpairedSurrogateException r0 = new com.google.protobuf.Utf8$UnpairedSurrogateException
                int r2 = r2 + -1
                r0.<init>(r2, r8)
                throw r0
            L_0x010f:
                if (r14 > r13) goto L_0x0127
                if (r13 > r3) goto L_0x0127
                int r1 = r2 + 1
                if (r1 == r8) goto L_0x0121
                char r0 = r0.charAt(r1)
                boolean r0 = java.lang.Character.isSurrogatePair(r13, r0)
                if (r0 != 0) goto L_0x0127
            L_0x0121:
                com.google.protobuf.Utf8$UnpairedSurrogateException r0 = new com.google.protobuf.Utf8$UnpairedSurrogateException
                r0.<init>(r2, r8)
                throw r0
            L_0x0127:
                java.lang.ArrayIndexOutOfBoundsException r0 = new java.lang.ArrayIndexOutOfBoundsException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                r1.append(r10)
                r1.append(r13)
                r1.append(r9)
                r1.append(r4)
                java.lang.String r1 = r1.toString()
                r0.<init>(r1)
                throw r0
            L_0x0142:
                int r0 = (int) r4
                return r0
            L_0x0144:
                java.lang.ArrayIndexOutOfBoundsException r1 = new java.lang.ArrayIndexOutOfBoundsException
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>()
                r4.append(r10)
                int r8 = r8 + -1
                char r0 = r0.charAt(r8)
                r4.append(r0)
                r4.append(r9)
                int r0 = r2 + r3
                r4.append(r0)
                java.lang.String r0 = r4.toString()
                r1.<init>(r0)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.Utf8.UnsafeProcessor.encodeUtf8(java.lang.CharSequence, byte[], int, int):int");
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Removed duplicated region for block: B:11:0x0045 A[LOOP:1: B:11:0x0045->B:36:0x0104, LOOP_START, PHI: r2 r4 r9 r10 
          PHI: (r2v2 long) = (r2v0 long), (r2v3 long) binds: [B:8:0x003a, B:36:0x0104] A[DONT_GENERATE, DONT_INLINE]
          PHI: (r4v4 long) = (r4v3 long), (r4v6 long) binds: [B:8:0x003a, B:36:0x0104] A[DONT_GENERATE, DONT_INLINE]
          PHI: (r9v3 int) = (r9v2 int), (r9v5 int) binds: [B:8:0x003a, B:36:0x0104] A[DONT_GENERATE, DONT_INLINE]
          PHI: (r10v1 char) = (r10v0 char), (r10v2 char) binds: [B:8:0x003a, B:36:0x0104] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARNING: Removed duplicated region for block: B:9:0x003c  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void encodeUtf8Direct(java.lang.CharSequence r22, java.nio.ByteBuffer r23) {
            /*
                r21 = this;
                r0 = r22
                r1 = r23
                long r2 = com.google.protobuf.UnsafeUtil.addressOffset(r23)
                int r4 = r23.position()
                long r4 = (long) r4
                long r4 = r4 + r2
                int r6 = r23.limit()
                long r6 = (long) r6
                long r6 = r6 + r2
                int r8 = r22.length()
                long r9 = (long) r8
                long r11 = r6 - r4
                java.lang.String r13 = " at index "
                java.lang.String r14 = "Failed writing "
                int r15 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
                if (r15 > 0) goto L_0x0158
                r9 = 0
            L_0x0024:
                r10 = 128(0x80, float:1.794E-43)
                r11 = 1
                if (r9 >= r8) goto L_0x003a
                char r15 = r0.charAt(r9)
                if (r15 >= r10) goto L_0x003a
                long r10 = r4 + r11
                byte r12 = (byte) r15
                com.google.protobuf.UnsafeUtil.putByte(r4, r12)
                int r9 = r9 + 1
                r4 = r10
                goto L_0x0024
            L_0x003a:
                if (r9 != r8) goto L_0x0045
                long r4 = r4 - r2
                int r0 = (int) r4
                java.nio.Buffer r0 = r1.position(r0)
                java.nio.ByteBuffer r0 = (java.nio.ByteBuffer) r0
                return
            L_0x0045:
                if (r9 >= r8) goto L_0x014a
                char r15 = r0.charAt(r9)
                if (r15 >= r10) goto L_0x005f
                int r16 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
                if (r16 >= 0) goto L_0x005f
                long r16 = r4 + r11
                byte r15 = (byte) r15
                com.google.protobuf.UnsafeUtil.putByte(r4, r15)
                r4 = r16
                r15 = 128(0x80, float:1.794E-43)
                r17 = r2
                goto L_0x0104
            L_0x005f:
                r10 = 2048(0x800, float:2.87E-42)
                if (r15 >= r10) goto L_0x0087
                r17 = 2
                long r17 = r6 - r17
                int r10 = (r4 > r17 ? 1 : (r4 == r17 ? 0 : -1))
                if (r10 > 0) goto L_0x0087
                r17 = r2
                long r1 = r4 + r11
                int r3 = r15 >>> 6
                r3 = r3 | 960(0x3c0, float:1.345E-42)
                byte r3 = (byte) r3
                com.google.protobuf.UnsafeUtil.putByte(r4, r3)
                long r3 = r1 + r11
                r5 = r15 & 63
                r10 = 128(0x80, float:1.794E-43)
                r5 = r5 | r10
                byte r5 = (byte) r5
                com.google.protobuf.UnsafeUtil.putByte(r1, r5)
                r4 = r3
            L_0x0083:
                r15 = 128(0x80, float:1.794E-43)
                goto L_0x0104
            L_0x0087:
                r17 = r2
                r1 = 57343(0xdfff, float:8.0355E-41)
                r2 = 55296(0xd800, float:7.7486E-41)
                if (r15 < r2) goto L_0x0093
                if (r1 >= r15) goto L_0x00bd
            L_0x0093:
                r19 = 3
                long r19 = r6 - r19
                int r3 = (r4 > r19 ? 1 : (r4 == r19 ? 0 : -1))
                if (r3 > 0) goto L_0x00bd
                long r1 = r4 + r11
                int r3 = r15 >>> 12
                r3 = r3 | 480(0x1e0, float:6.73E-43)
                byte r3 = (byte) r3
                com.google.protobuf.UnsafeUtil.putByte(r4, r3)
                long r3 = r1 + r11
                int r5 = r15 >>> 6
                r5 = r5 & 63
                r10 = 128(0x80, float:1.794E-43)
                r5 = r5 | r10
                byte r5 = (byte) r5
                com.google.protobuf.UnsafeUtil.putByte(r1, r5)
                long r1 = r3 + r11
                r5 = r15 & 63
                r5 = r5 | r10
                byte r5 = (byte) r5
                com.google.protobuf.UnsafeUtil.putByte(r3, r5)
                r4 = r1
                goto L_0x0083
            L_0x00bd:
                r19 = 4
                long r19 = r6 - r19
                int r3 = (r4 > r19 ? 1 : (r4 == r19 ? 0 : -1))
                if (r3 > 0) goto L_0x0117
                int r1 = r9 + 1
                if (r1 == r8) goto L_0x010f
                char r2 = r0.charAt(r1)
                boolean r3 = java.lang.Character.isSurrogatePair(r15, r2)
                if (r3 == 0) goto L_0x010e
                int r2 = java.lang.Character.toCodePoint(r15, r2)
                long r9 = r4 + r11
                int r3 = r2 >>> 18
                r3 = r3 | 240(0xf0, float:3.36E-43)
                byte r3 = (byte) r3
                com.google.protobuf.UnsafeUtil.putByte(r4, r3)
                long r3 = r9 + r11
                int r5 = r2 >>> 12
                r5 = r5 & 63
                r15 = 128(0x80, float:1.794E-43)
                r5 = r5 | r15
                byte r5 = (byte) r5
                com.google.protobuf.UnsafeUtil.putByte(r9, r5)
                long r9 = r3 + r11
                int r5 = r2 >>> 6
                r5 = r5 & 63
                r5 = r5 | r15
                byte r5 = (byte) r5
                com.google.protobuf.UnsafeUtil.putByte(r3, r5)
                long r3 = r9 + r11
                r2 = r2 & 63
                r2 = r2 | r15
                byte r2 = (byte) r2
                com.google.protobuf.UnsafeUtil.putByte(r9, r2)
                r9 = r1
                r4 = r3
            L_0x0104:
                int r9 = r9 + 1
                r1 = r23
                r2 = r17
                r10 = 128(0x80, float:1.794E-43)
                goto L_0x0045
            L_0x010e:
                r9 = r1
            L_0x010f:
                com.google.protobuf.Utf8$UnpairedSurrogateException r0 = new com.google.protobuf.Utf8$UnpairedSurrogateException
                int r9 = r9 + -1
                r0.<init>(r9, r8)
                throw r0
            L_0x0117:
                if (r2 > r15) goto L_0x012f
                if (r15 > r1) goto L_0x012f
                int r1 = r9 + 1
                if (r1 == r8) goto L_0x0129
                char r0 = r0.charAt(r1)
                boolean r0 = java.lang.Character.isSurrogatePair(r15, r0)
                if (r0 != 0) goto L_0x012f
            L_0x0129:
                com.google.protobuf.Utf8$UnpairedSurrogateException r0 = new com.google.protobuf.Utf8$UnpairedSurrogateException
                r0.<init>(r9, r8)
                throw r0
            L_0x012f:
                java.lang.ArrayIndexOutOfBoundsException r0 = new java.lang.ArrayIndexOutOfBoundsException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                r1.append(r14)
                r1.append(r15)
                r1.append(r13)
                r1.append(r4)
                java.lang.String r1 = r1.toString()
                r0.<init>(r1)
                throw r0
            L_0x014a:
                r17 = r2
                long r4 = r4 - r17
                int r0 = (int) r4
                r1 = r23
                java.nio.Buffer r0 = r1.position(r0)
                java.nio.ByteBuffer r0 = (java.nio.ByteBuffer) r0
                return
            L_0x0158:
                java.lang.ArrayIndexOutOfBoundsException r2 = new java.lang.ArrayIndexOutOfBoundsException
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                r3.append(r14)
                int r8 = r8 + -1
                char r0 = r0.charAt(r8)
                r3.append(r0)
                r3.append(r13)
                int r0 = r23.limit()
                r3.append(r0)
                java.lang.String r0 = r3.toString()
                r2.<init>(r0)
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.Utf8.UnsafeProcessor.encodeUtf8Direct(java.lang.CharSequence, java.nio.ByteBuffer):void");
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x0059, code lost:
            if (com.google.protobuf.UnsafeUtil.getByte(r13, r2) > -65) goto L_0x005e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:54:0x009e, code lost:
            if (com.google.protobuf.UnsafeUtil.getByte(r13, r2) > -65) goto L_0x00a0;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int partialIsValidUtf8(int r12, byte[] r13, int r14, int r15) {
            /*
                r11 = this;
                r0 = r14 | r15
                int r1 = r13.length
                int r1 = r1 - r15
                r0 = r0 | r1
                r1 = 0
                if (r0 < 0) goto L_0x00a8
                long r2 = (long) r14
                long r14 = (long) r15
                if (r12 == 0) goto L_0x00a1
                int r0 = (r2 > r14 ? 1 : (r2 == r14 ? 0 : -1))
                if (r0 < 0) goto L_0x0011
                return r12
            L_0x0011:
                byte r0 = (byte) r12
                r4 = -32
                r5 = -1
                r6 = -65
                r7 = 1
                if (r0 >= r4) goto L_0x002b
                r12 = -62
                if (r0 < r12) goto L_0x002a
                long r7 = r7 + r2
                byte r12 = com.google.protobuf.UnsafeUtil.getByte((byte[]) r13, (long) r2)
                if (r12 <= r6) goto L_0x0027
                goto L_0x002a
            L_0x0027:
                r2 = r7
                goto L_0x00a1
            L_0x002a:
                return r5
            L_0x002b:
                r9 = -16
                if (r0 >= r9) goto L_0x005f
                int r12 = r12 >> 8
                int r12 = ~r12
                byte r12 = (byte) r12
                if (r12 != 0) goto L_0x0045
                long r9 = r2 + r7
                byte r12 = com.google.protobuf.UnsafeUtil.getByte((byte[]) r13, (long) r2)
                int r1 = (r9 > r14 ? 1 : (r9 == r14 ? 0 : -1))
                if (r1 < 0) goto L_0x0044
                int r12 = com.google.protobuf.Utf8.incompleteStateFor(r0, r12)
                return r12
            L_0x0044:
                r2 = r9
            L_0x0045:
                if (r12 > r6) goto L_0x005e
                r1 = -96
                if (r0 != r4) goto L_0x004d
                if (r12 < r1) goto L_0x005e
            L_0x004d:
                r4 = -19
                if (r0 != r4) goto L_0x0053
                if (r12 >= r1) goto L_0x005e
            L_0x0053:
                long r0 = r2 + r7
                byte r12 = com.google.protobuf.UnsafeUtil.getByte((byte[]) r13, (long) r2)
                if (r12 <= r6) goto L_0x005c
                goto L_0x005e
            L_0x005c:
                r2 = r0
                goto L_0x00a1
            L_0x005e:
                return r5
            L_0x005f:
                int r4 = r12 >> 8
                int r4 = ~r4
                byte r4 = (byte) r4
                if (r4 != 0) goto L_0x0076
                long r9 = r2 + r7
                byte r4 = com.google.protobuf.UnsafeUtil.getByte((byte[]) r13, (long) r2)
                int r12 = (r9 > r14 ? 1 : (r9 == r14 ? 0 : -1))
                if (r12 < 0) goto L_0x0074
                int r12 = com.google.protobuf.Utf8.incompleteStateFor(r0, r4)
                return r12
            L_0x0074:
                r2 = r9
                goto L_0x0079
            L_0x0076:
                int r12 = r12 >> 16
                byte r1 = (byte) r12
            L_0x0079:
                if (r1 != 0) goto L_0x008b
                long r9 = r2 + r7
                byte r1 = com.google.protobuf.UnsafeUtil.getByte((byte[]) r13, (long) r2)
                int r12 = (r9 > r14 ? 1 : (r9 == r14 ? 0 : -1))
                if (r12 < 0) goto L_0x008a
                int r12 = com.google.protobuf.Utf8.incompleteStateFor((int) r0, (int) r4, (int) r1)
                return r12
            L_0x008a:
                r2 = r9
            L_0x008b:
                if (r4 > r6) goto L_0x00a0
                int r12 = r0 << 28
                int r4 = r4 + 112
                int r12 = r12 + r4
                int r12 = r12 >> 30
                if (r12 != 0) goto L_0x00a0
                if (r1 > r6) goto L_0x00a0
                long r0 = r2 + r7
                byte r12 = com.google.protobuf.UnsafeUtil.getByte((byte[]) r13, (long) r2)
                if (r12 <= r6) goto L_0x005c
            L_0x00a0:
                return r5
            L_0x00a1:
                long r14 = r14 - r2
                int r12 = (int) r14
                int r12 = partialIsValidUtf8(r13, r2, r12)
                return r12
            L_0x00a8:
                java.lang.ArrayIndexOutOfBoundsException r12 = new java.lang.ArrayIndexOutOfBoundsException
                r0 = 3
                java.lang.Object[] r0 = new java.lang.Object[r0]
                int r13 = r13.length
                java.lang.Integer r13 = java.lang.Integer.valueOf(r13)
                r0[r1] = r13
                r13 = 1
                java.lang.Integer r14 = java.lang.Integer.valueOf(r14)
                r0[r13] = r14
                r13 = 2
                java.lang.Integer r14 = java.lang.Integer.valueOf(r15)
                r0[r13] = r14
                java.lang.String r13 = "Array length=%d, index=%d, limit=%d"
                java.lang.String r13 = java.lang.String.format(r13, r0)
                r12.<init>(r13)
                throw r12
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.Utf8.UnsafeProcessor.partialIsValidUtf8(int, byte[], int, int):int");
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x0063, code lost:
            if (com.google.protobuf.UnsafeUtil.getByte(r2) > -65) goto L_0x0068;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:54:0x00a8, code lost:
            if (com.google.protobuf.UnsafeUtil.getByte(r2) > -65) goto L_0x00aa;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int partialIsValidUtf8Direct(int r11, java.nio.ByteBuffer r12, int r13, int r14) {
            /*
                r10 = this;
                r0 = r13 | r14
                int r1 = r12.limit()
                int r1 = r1 - r14
                r0 = r0 | r1
                r1 = 0
                if (r0 < 0) goto L_0x00b2
                long r2 = com.google.protobuf.UnsafeUtil.addressOffset(r12)
                long r4 = (long) r13
                long r2 = r2 + r4
                int r14 = r14 - r13
                long r12 = (long) r14
                long r12 = r12 + r2
                if (r11 == 0) goto L_0x00ab
                int r14 = (r2 > r12 ? 1 : (r2 == r12 ? 0 : -1))
                if (r14 < 0) goto L_0x001b
                return r11
            L_0x001b:
                byte r14 = (byte) r11
                r0 = -32
                r4 = -1
                r5 = -65
                r6 = 1
                if (r14 >= r0) goto L_0x0035
                r11 = -62
                if (r14 < r11) goto L_0x0034
                long r6 = r6 + r2
                byte r11 = com.google.protobuf.UnsafeUtil.getByte(r2)
                if (r11 <= r5) goto L_0x0031
                goto L_0x0034
            L_0x0031:
                r2 = r6
                goto L_0x00ab
            L_0x0034:
                return r4
            L_0x0035:
                r8 = -16
                if (r14 >= r8) goto L_0x0069
                int r11 = r11 >> 8
                int r11 = ~r11
                byte r11 = (byte) r11
                if (r11 != 0) goto L_0x004f
                long r8 = r2 + r6
                byte r11 = com.google.protobuf.UnsafeUtil.getByte(r2)
                int r1 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
                if (r1 < 0) goto L_0x004e
                int r11 = com.google.protobuf.Utf8.incompleteStateFor(r14, r11)
                return r11
            L_0x004e:
                r2 = r8
            L_0x004f:
                if (r11 > r5) goto L_0x0068
                r1 = -96
                if (r14 != r0) goto L_0x0057
                if (r11 < r1) goto L_0x0068
            L_0x0057:
                r0 = -19
                if (r14 != r0) goto L_0x005d
                if (r11 >= r1) goto L_0x0068
            L_0x005d:
                long r0 = r2 + r6
                byte r11 = com.google.protobuf.UnsafeUtil.getByte(r2)
                if (r11 <= r5) goto L_0x0066
                goto L_0x0068
            L_0x0066:
                r2 = r0
                goto L_0x00ab
            L_0x0068:
                return r4
            L_0x0069:
                int r0 = r11 >> 8
                int r0 = ~r0
                byte r0 = (byte) r0
                if (r0 != 0) goto L_0x0080
                long r8 = r2 + r6
                byte r0 = com.google.protobuf.UnsafeUtil.getByte(r2)
                int r11 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
                if (r11 < 0) goto L_0x007e
                int r11 = com.google.protobuf.Utf8.incompleteStateFor(r14, r0)
                return r11
            L_0x007e:
                r2 = r8
                goto L_0x0083
            L_0x0080:
                int r11 = r11 >> 16
                byte r1 = (byte) r11
            L_0x0083:
                if (r1 != 0) goto L_0x0095
                long r8 = r2 + r6
                byte r1 = com.google.protobuf.UnsafeUtil.getByte(r2)
                int r11 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
                if (r11 < 0) goto L_0x0094
                int r11 = com.google.protobuf.Utf8.incompleteStateFor((int) r14, (int) r0, (int) r1)
                return r11
            L_0x0094:
                r2 = r8
            L_0x0095:
                if (r0 > r5) goto L_0x00aa
                int r11 = r14 << 28
                int r0 = r0 + 112
                int r11 = r11 + r0
                int r11 = r11 >> 30
                if (r11 != 0) goto L_0x00aa
                if (r1 > r5) goto L_0x00aa
                long r0 = r2 + r6
                byte r11 = com.google.protobuf.UnsafeUtil.getByte(r2)
                if (r11 <= r5) goto L_0x0066
            L_0x00aa:
                return r4
            L_0x00ab:
                long r12 = r12 - r2
                int r11 = (int) r12
                int r11 = partialIsValidUtf8(r2, r11)
                return r11
            L_0x00b2:
                java.lang.ArrayIndexOutOfBoundsException r11 = new java.lang.ArrayIndexOutOfBoundsException
                r0 = 3
                java.lang.Object[] r0 = new java.lang.Object[r0]
                int r12 = r12.limit()
                java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
                r0[r1] = r12
                r12 = 1
                java.lang.Integer r13 = java.lang.Integer.valueOf(r13)
                r0[r12] = r13
                r12 = 2
                java.lang.Integer r13 = java.lang.Integer.valueOf(r14)
                r0[r12] = r13
                java.lang.String r12 = "buffer limit=%d, index=%d, limit=%d"
                java.lang.String r12 = java.lang.String.format(r12, r0)
                r11.<init>(r12)
                throw r11
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.Utf8.UnsafeProcessor.partialIsValidUtf8Direct(int, java.nio.ByteBuffer, int, int):int");
        }

        private static int unsafeEstimateConsecutiveAscii(long j2, int i2) {
            if (i2 < 16) {
                return 0;
            }
            int i3 = (int) ((-j2) & 7);
            int i4 = i3;
            while (i4 > 0) {
                long j3 = 1 + j2;
                if (UnsafeUtil.getByte(j2) < 0) {
                    return i3 - i4;
                }
                i4--;
                j2 = j3;
            }
            int i5 = i2 - i3;
            while (i5 >= 8 && (UnsafeUtil.getLong(j2) & Utf8.ASCII_MASK_LONG) == 0) {
                j2 += 8;
                i5 -= 8;
            }
            return i2 - i5;
        }

        private static int unsafeIncompleteStateFor(long j2, int i2, int i3) {
            if (i3 == 0) {
                return Utf8.incompleteStateFor(i2);
            }
            if (i3 == 1) {
                return Utf8.incompleteStateFor(i2, UnsafeUtil.getByte(j2));
            }
            if (i3 == 2) {
                return Utf8.incompleteStateFor(i2, (int) UnsafeUtil.getByte(j2), (int) UnsafeUtil.getByte(j2 + 1));
            }
            throw new AssertionError();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0039, code lost:
            return -1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x0063, code lost:
            return -1;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static int partialIsValidUtf8(byte[] r8, long r9, int r11) {
            /*
                int r0 = unsafeEstimateConsecutiveAscii(r8, r9, r11)
                int r11 = r11 - r0
                long r0 = (long) r0
                long r9 = r9 + r0
            L_0x0007:
                r0 = 0
                r1 = 0
            L_0x0009:
                r2 = 1
                if (r11 <= 0) goto L_0x001a
                long r4 = r9 + r2
                byte r1 = com.google.protobuf.UnsafeUtil.getByte((byte[]) r8, (long) r9)
                if (r1 < 0) goto L_0x0019
                int r11 = r11 + -1
                r9 = r4
                goto L_0x0009
            L_0x0019:
                r9 = r4
            L_0x001a:
                if (r11 != 0) goto L_0x001d
                return r0
            L_0x001d:
                int r11 = r11 + -1
                r0 = -32
                r4 = -65
                r5 = -1
                if (r1 >= r0) goto L_0x003a
                if (r11 != 0) goto L_0x0029
                return r1
            L_0x0029:
                int r11 = r11 + -1
                r0 = -62
                if (r1 < r0) goto L_0x0039
                long r2 = r2 + r9
                byte r9 = com.google.protobuf.UnsafeUtil.getByte((byte[]) r8, (long) r9)
                if (r9 <= r4) goto L_0x0037
                goto L_0x0039
            L_0x0037:
                r9 = r2
                goto L_0x0007
            L_0x0039:
                return r5
            L_0x003a:
                r6 = -16
                if (r1 >= r6) goto L_0x0064
                r6 = 2
                if (r11 >= r6) goto L_0x0046
                int r8 = unsafeIncompleteStateFor(r8, r1, r9, r11)
                return r8
            L_0x0046:
                int r11 = r11 + -2
                long r6 = r9 + r2
                byte r9 = com.google.protobuf.UnsafeUtil.getByte((byte[]) r8, (long) r9)
                if (r9 > r4) goto L_0x0063
                r10 = -96
                if (r1 != r0) goto L_0x0056
                if (r9 < r10) goto L_0x0063
            L_0x0056:
                r0 = -19
                if (r1 != r0) goto L_0x005c
                if (r9 >= r10) goto L_0x0063
            L_0x005c:
                long r2 = r2 + r6
                byte r9 = com.google.protobuf.UnsafeUtil.getByte((byte[]) r8, (long) r6)
                if (r9 <= r4) goto L_0x0037
            L_0x0063:
                return r5
            L_0x0064:
                r0 = 3
                if (r11 >= r0) goto L_0x006c
                int r8 = unsafeIncompleteStateFor(r8, r1, r9, r11)
                return r8
            L_0x006c:
                int r11 = r11 + -3
                long r6 = r9 + r2
                byte r9 = com.google.protobuf.UnsafeUtil.getByte((byte[]) r8, (long) r9)
                if (r9 > r4) goto L_0x008e
                int r10 = r1 << 28
                int r9 = r9 + 112
                int r10 = r10 + r9
                int r9 = r10 >> 30
                if (r9 != 0) goto L_0x008e
                long r9 = r6 + r2
                byte r0 = com.google.protobuf.UnsafeUtil.getByte((byte[]) r8, (long) r6)
                if (r0 > r4) goto L_0x008e
                long r2 = r2 + r9
                byte r9 = com.google.protobuf.UnsafeUtil.getByte((byte[]) r8, (long) r9)
                if (r9 <= r4) goto L_0x0037
            L_0x008e:
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.Utf8.UnsafeProcessor.partialIsValidUtf8(byte[], long, int):int");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0039, code lost:
            return -1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x0063, code lost:
            return -1;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static int partialIsValidUtf8(long r8, int r10) {
            /*
                int r0 = unsafeEstimateConsecutiveAscii(r8, r10)
                long r1 = (long) r0
                long r8 = r8 + r1
                int r10 = r10 - r0
            L_0x0007:
                r0 = 0
                r1 = 0
            L_0x0009:
                r2 = 1
                if (r10 <= 0) goto L_0x001a
                long r4 = r8 + r2
                byte r1 = com.google.protobuf.UnsafeUtil.getByte(r8)
                if (r1 < 0) goto L_0x0019
                int r10 = r10 + -1
                r8 = r4
                goto L_0x0009
            L_0x0019:
                r8 = r4
            L_0x001a:
                if (r10 != 0) goto L_0x001d
                return r0
            L_0x001d:
                int r10 = r10 + -1
                r0 = -32
                r4 = -65
                r5 = -1
                if (r1 >= r0) goto L_0x003a
                if (r10 != 0) goto L_0x0029
                return r1
            L_0x0029:
                int r10 = r10 + -1
                r0 = -62
                if (r1 < r0) goto L_0x0039
                long r2 = r2 + r8
                byte r8 = com.google.protobuf.UnsafeUtil.getByte(r8)
                if (r8 <= r4) goto L_0x0037
                goto L_0x0039
            L_0x0037:
                r8 = r2
                goto L_0x0007
            L_0x0039:
                return r5
            L_0x003a:
                r6 = -16
                if (r1 >= r6) goto L_0x0064
                r6 = 2
                if (r10 >= r6) goto L_0x0046
                int r8 = unsafeIncompleteStateFor(r8, r1, r10)
                return r8
            L_0x0046:
                int r10 = r10 + -2
                long r6 = r8 + r2
                byte r8 = com.google.protobuf.UnsafeUtil.getByte(r8)
                if (r8 > r4) goto L_0x0063
                r9 = -96
                if (r1 != r0) goto L_0x0056
                if (r8 < r9) goto L_0x0063
            L_0x0056:
                r0 = -19
                if (r1 != r0) goto L_0x005c
                if (r8 >= r9) goto L_0x0063
            L_0x005c:
                long r2 = r2 + r6
                byte r8 = com.google.protobuf.UnsafeUtil.getByte(r6)
                if (r8 <= r4) goto L_0x0037
            L_0x0063:
                return r5
            L_0x0064:
                r0 = 3
                if (r10 >= r0) goto L_0x006c
                int r8 = unsafeIncompleteStateFor(r8, r1, r10)
                return r8
            L_0x006c:
                int r10 = r10 + -3
                long r6 = r8 + r2
                byte r8 = com.google.protobuf.UnsafeUtil.getByte(r8)
                if (r8 > r4) goto L_0x008e
                int r9 = r1 << 28
                int r8 = r8 + 112
                int r9 = r9 + r8
                int r8 = r9 >> 30
                if (r8 != 0) goto L_0x008e
                long r8 = r6 + r2
                byte r0 = com.google.protobuf.UnsafeUtil.getByte(r6)
                if (r0 > r4) goto L_0x008e
                long r2 = r2 + r8
                byte r8 = com.google.protobuf.UnsafeUtil.getByte(r8)
                if (r8 <= r4) goto L_0x0037
            L_0x008e:
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.Utf8.UnsafeProcessor.partialIsValidUtf8(long, int):int");
        }
    }

    static boolean isValidUtf8(ByteBuffer byteBuffer) {
        return processor.isValidUtf8(byteBuffer, byteBuffer.position(), byteBuffer.remaining());
    }

    /* access modifiers changed from: private */
    public static int incompleteStateFor(ByteBuffer byteBuffer, int i2, int i3, int i4) {
        if (i4 == 0) {
            return incompleteStateFor(i2);
        }
        if (i4 == 1) {
            return incompleteStateFor(i2, byteBuffer.get(i3));
        }
        if (i4 == 2) {
            return incompleteStateFor(i2, (int) byteBuffer.get(i3), (int) byteBuffer.get(i3 + 1));
        }
        throw new AssertionError();
    }

    static final class SafeProcessor extends Processor {
        SafeProcessor() {
        }

        private static int partialIsValidUtf8NonAscii(byte[] bArr, int i2, int i3) {
            while (i2 < i3) {
                int i4 = i2 + 1;
                byte b2 = bArr[i2];
                if (b2 < 0) {
                    if (b2 < -32) {
                        if (i4 >= i3) {
                            return b2;
                        }
                        if (b2 >= -62) {
                            i2 = i4 + 1;
                            if (bArr[i4] > -65) {
                            }
                        }
                        return -1;
                    } else if (b2 < -16) {
                        if (i4 >= i3 - 1) {
                            return Utf8.incompleteStateFor(bArr, i4, i3);
                        }
                        int i5 = i4 + 1;
                        byte b3 = bArr[i4];
                        if (b3 <= -65 && ((b2 != -32 || b3 >= -96) && (b2 != -19 || b3 < -96))) {
                            i2 = i5 + 1;
                            if (bArr[i5] > -65) {
                            }
                        }
                        return -1;
                    } else if (i4 >= i3 - 2) {
                        return Utf8.incompleteStateFor(bArr, i4, i3);
                    } else {
                        int i6 = i4 + 1;
                        byte b4 = bArr[i4];
                        if (b4 <= -65 && (((b2 << 28) + (b4 + 112)) >> 30) == 0) {
                            int i7 = i6 + 1;
                            if (bArr[i6] <= -65) {
                                i4 = i7 + 1;
                                if (bArr[i7] > -65) {
                                }
                            }
                        }
                        return -1;
                    }
                }
                i2 = i4;
            }
            return 0;
        }

        /* access modifiers changed from: package-private */
        public String decodeUtf8(byte[] bArr, int i2, int i3) throws InvalidProtocolBufferException {
            if ((i2 | i3 | ((bArr.length - i2) - i3)) >= 0) {
                int i4 = i2 + i3;
                char[] cArr = new char[i3];
                int i5 = 0;
                while (r13 < i4) {
                    byte b2 = bArr[r13];
                    if (!DecodeUtil.isOneByte(b2)) {
                        break;
                    }
                    i2 = r13 + 1;
                    DecodeUtil.handleOneByte(b2, cArr, i5);
                    i5++;
                }
                int i6 = i5;
                while (r13 < i4) {
                    int i7 = r13 + 1;
                    byte b3 = bArr[r13];
                    if (DecodeUtil.isOneByte(b3)) {
                        int i8 = i6 + 1;
                        DecodeUtil.handleOneByte(b3, cArr, i6);
                        while (i7 < i4) {
                            byte b4 = bArr[i7];
                            if (!DecodeUtil.isOneByte(b4)) {
                                break;
                            }
                            i7++;
                            DecodeUtil.handleOneByte(b4, cArr, i8);
                            i8++;
                        }
                        r13 = i7;
                        i6 = i8;
                    } else if (DecodeUtil.isTwoBytes(b3)) {
                        if (i7 < i4) {
                            DecodeUtil.handleTwoBytes(b3, bArr[i7], cArr, i6);
                            r13 = i7 + 1;
                            i6++;
                        } else {
                            throw InvalidProtocolBufferException.invalidUtf8();
                        }
                    } else if (DecodeUtil.isThreeBytes(b3)) {
                        if (i7 < i4 - 1) {
                            int i9 = i7 + 1;
                            DecodeUtil.handleThreeBytes(b3, bArr[i7], bArr[i9], cArr, i6);
                            r13 = i9 + 1;
                            i6++;
                        } else {
                            throw InvalidProtocolBufferException.invalidUtf8();
                        }
                    } else if (i7 < i4 - 2) {
                        int i10 = i7 + 1;
                        byte b5 = bArr[i7];
                        int i11 = i10 + 1;
                        DecodeUtil.handleFourBytes(b3, b5, bArr[i10], bArr[i11], cArr, i6);
                        r13 = i11 + 1;
                        i6 = i6 + 1 + 1;
                    } else {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                }
                return new String(cArr, 0, i6);
            }
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i2), Integer.valueOf(i3)}));
        }

        /* access modifiers changed from: package-private */
        public String decodeUtf8Direct(ByteBuffer byteBuffer, int i2, int i3) throws InvalidProtocolBufferException {
            return decodeUtf8Default(byteBuffer, i2, i3);
        }

        /* access modifiers changed from: package-private */
        public int encodeUtf8(CharSequence charSequence, byte[] bArr, int i2, int i3) {
            int i4;
            int i5;
            int i6;
            char charAt;
            int length = charSequence.length();
            int i7 = i3 + i2;
            int i8 = 0;
            while (i8 < length && (i6 = i8 + i2) < i7 && (charAt = charSequence.charAt(i8)) < 128) {
                bArr[i6] = (byte) charAt;
                i8++;
            }
            if (i8 == length) {
                return i2 + length;
            }
            int i9 = i2 + i8;
            while (i8 < length) {
                char charAt2 = charSequence.charAt(i8);
                if (charAt2 < 128 && i9 < i7) {
                    i5 = i9 + 1;
                    bArr[i9] = (byte) charAt2;
                } else if (charAt2 < 2048 && i9 <= i7 - 2) {
                    int i10 = i9 + 1;
                    bArr[i9] = (byte) ((charAt2 >>> 6) | 960);
                    i9 = i10 + 1;
                    bArr[i10] = (byte) ((charAt2 & '?') | 128);
                    i8++;
                } else if ((charAt2 < 55296 || 57343 < charAt2) && i9 <= i7 - 3) {
                    int i11 = i9 + 1;
                    bArr[i9] = (byte) ((charAt2 >>> 12) | 480);
                    int i12 = i11 + 1;
                    bArr[i11] = (byte) (((charAt2 >>> 6) & 63) | 128);
                    i5 = i12 + 1;
                    bArr[i12] = (byte) ((charAt2 & '?') | 128);
                } else if (i9 <= i7 - 4) {
                    int i13 = i8 + 1;
                    if (i13 != charSequence.length()) {
                        char charAt3 = charSequence.charAt(i13);
                        if (Character.isSurrogatePair(charAt2, charAt3)) {
                            int codePoint = Character.toCodePoint(charAt2, charAt3);
                            int i14 = i9 + 1;
                            bArr[i9] = (byte) ((codePoint >>> 18) | 240);
                            int i15 = i14 + 1;
                            bArr[i14] = (byte) (((codePoint >>> 12) & 63) | 128);
                            int i16 = i15 + 1;
                            bArr[i15] = (byte) (((codePoint >>> 6) & 63) | 128);
                            i9 = i16 + 1;
                            bArr[i16] = (byte) ((codePoint & 63) | 128);
                            i8 = i13;
                            i8++;
                        } else {
                            i8 = i13;
                        }
                    }
                    throw new UnpairedSurrogateException(i8 - 1, length);
                } else if (55296 > charAt2 || charAt2 > 57343 || ((i4 = i8 + 1) != charSequence.length() && Character.isSurrogatePair(charAt2, charSequence.charAt(i4)))) {
                    throw new ArrayIndexOutOfBoundsException("Failed writing " + charAt2 + " at index " + i9);
                } else {
                    throw new UnpairedSurrogateException(i8, length);
                }
                i9 = i5;
                i8++;
            }
            return i9;
        }

        /* access modifiers changed from: package-private */
        public void encodeUtf8Direct(CharSequence charSequence, ByteBuffer byteBuffer) {
            encodeUtf8Default(charSequence, byteBuffer);
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0046, code lost:
            if (r8[r9] > -65) goto L_0x0048;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x0083, code lost:
            if (r8[r7] > -65) goto L_0x0085;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0015, code lost:
            if (r8[r9] > -65) goto L_0x001b;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int partialIsValidUtf8(int r7, byte[] r8, int r9, int r10) {
            /*
                r6 = this;
                if (r7 == 0) goto L_0x0086
                if (r9 < r10) goto L_0x0005
                return r7
            L_0x0005:
                byte r0 = (byte) r7
                r1 = -32
                r2 = -1
                r3 = -65
                if (r0 >= r1) goto L_0x001c
                r7 = -62
                if (r0 < r7) goto L_0x001b
                int r7 = r9 + 1
                byte r9 = r8[r9]
                if (r9 <= r3) goto L_0x0018
                goto L_0x001b
            L_0x0018:
                r9 = r7
                goto L_0x0086
            L_0x001b:
                return r2
            L_0x001c:
                r4 = -16
                if (r0 >= r4) goto L_0x0049
                int r7 = r7 >> 8
                int r7 = ~r7
                byte r7 = (byte) r7
                if (r7 != 0) goto L_0x0034
                int r7 = r9 + 1
                byte r9 = r8[r9]
                if (r7 < r10) goto L_0x0031
                int r7 = com.google.protobuf.Utf8.incompleteStateFor(r0, r9)
                return r7
            L_0x0031:
                r5 = r9
                r9 = r7
                r7 = r5
            L_0x0034:
                if (r7 > r3) goto L_0x0048
                r4 = -96
                if (r0 != r1) goto L_0x003c
                if (r7 < r4) goto L_0x0048
            L_0x003c:
                r1 = -19
                if (r0 != r1) goto L_0x0042
                if (r7 >= r4) goto L_0x0048
            L_0x0042:
                int r7 = r9 + 1
                byte r9 = r8[r9]
                if (r9 <= r3) goto L_0x0018
            L_0x0048:
                return r2
            L_0x0049:
                int r1 = r7 >> 8
                int r1 = ~r1
                byte r1 = (byte) r1
                if (r1 != 0) goto L_0x005c
                int r7 = r9 + 1
                byte r1 = r8[r9]
                if (r7 < r10) goto L_0x005a
                int r7 = com.google.protobuf.Utf8.incompleteStateFor(r0, r1)
                return r7
            L_0x005a:
                r9 = 0
                goto L_0x0062
            L_0x005c:
                int r7 = r7 >> 16
                byte r7 = (byte) r7
                r5 = r9
                r9 = r7
                r7 = r5
            L_0x0062:
                if (r9 != 0) goto L_0x0072
                int r9 = r7 + 1
                byte r7 = r8[r7]
                if (r9 < r10) goto L_0x006f
                int r7 = com.google.protobuf.Utf8.incompleteStateFor((int) r0, (int) r1, (int) r7)
                return r7
            L_0x006f:
                r5 = r9
                r9 = r7
                r7 = r5
            L_0x0072:
                if (r1 > r3) goto L_0x0085
                int r0 = r0 << 28
                int r1 = r1 + 112
                int r0 = r0 + r1
                int r0 = r0 >> 30
                if (r0 != 0) goto L_0x0085
                if (r9 > r3) goto L_0x0085
                int r9 = r7 + 1
                byte r7 = r8[r7]
                if (r7 <= r3) goto L_0x0086
            L_0x0085:
                return r2
            L_0x0086:
                int r7 = partialIsValidUtf8(r8, r9, r10)
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.Utf8.SafeProcessor.partialIsValidUtf8(int, byte[], int, int):int");
        }

        /* access modifiers changed from: package-private */
        public int partialIsValidUtf8Direct(int i2, ByteBuffer byteBuffer, int i3, int i4) {
            return partialIsValidUtf8Default(i2, byteBuffer, i3, i4);
        }

        private static int partialIsValidUtf8(byte[] bArr, int i2, int i3) {
            while (i2 < i3 && bArr[i2] >= 0) {
                i2++;
            }
            if (i2 >= i3) {
                return 0;
            }
            return partialIsValidUtf8NonAscii(bArr, i2, i3);
        }
    }
}
