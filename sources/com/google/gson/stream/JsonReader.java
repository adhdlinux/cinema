package com.google.gson.stream;

import com.facebook.hermes.intl.Constants;
import com.google.gson.Strictness;
import com.google.gson.internal.JsonReaderInternalAccess;
import com.google.gson.internal.TroubleshootingGuide;
import com.google.gson.internal.bind.JsonTreeReader;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.Objects;

public class JsonReader implements Closeable {
    static final int BUFFER_SIZE = 1024;
    private static final long MIN_INCOMPLETE_INTEGER = -922337203685477580L;
    private static final int NUMBER_CHAR_DECIMAL = 3;
    private static final int NUMBER_CHAR_DIGIT = 2;
    private static final int NUMBER_CHAR_EXP_DIGIT = 7;
    private static final int NUMBER_CHAR_EXP_E = 5;
    private static final int NUMBER_CHAR_EXP_SIGN = 6;
    private static final int NUMBER_CHAR_FRACTION_DIGIT = 4;
    private static final int NUMBER_CHAR_NONE = 0;
    private static final int NUMBER_CHAR_SIGN = 1;
    private static final int PEEKED_BEGIN_ARRAY = 3;
    private static final int PEEKED_BEGIN_OBJECT = 1;
    private static final int PEEKED_BUFFERED = 11;
    private static final int PEEKED_DOUBLE_QUOTED = 9;
    private static final int PEEKED_DOUBLE_QUOTED_NAME = 13;
    private static final int PEEKED_END_ARRAY = 4;
    private static final int PEEKED_END_OBJECT = 2;
    private static final int PEEKED_EOF = 17;
    private static final int PEEKED_FALSE = 6;
    private static final int PEEKED_LONG = 15;
    private static final int PEEKED_NONE = 0;
    private static final int PEEKED_NULL = 7;
    private static final int PEEKED_NUMBER = 16;
    private static final int PEEKED_SINGLE_QUOTED = 8;
    private static final int PEEKED_SINGLE_QUOTED_NAME = 12;
    private static final int PEEKED_TRUE = 5;
    private static final int PEEKED_UNQUOTED = 10;
    private static final int PEEKED_UNQUOTED_NAME = 14;
    private final char[] buffer = new char[1024];
    private final Reader in;
    private int limit = 0;
    private int lineNumber = 0;
    private int lineStart = 0;
    private int[] pathIndices;
    private String[] pathNames;
    int peeked = 0;
    private long peekedLong;
    private int peekedNumberLength;
    private String peekedString;
    private int pos = 0;
    private int[] stack;
    private int stackSize;
    private Strictness strictness = Strictness.LEGACY_STRICT;

    static {
        JsonReaderInternalAccess.INSTANCE = new JsonReaderInternalAccess() {
            public void promoteNameToValue(JsonReader jsonReader) throws IOException {
                if (jsonReader instanceof JsonTreeReader) {
                    ((JsonTreeReader) jsonReader).s();
                    return;
                }
                int i2 = jsonReader.peeked;
                if (i2 == 0) {
                    i2 = jsonReader.doPeek();
                }
                if (i2 == 13) {
                    jsonReader.peeked = 9;
                } else if (i2 == 12) {
                    jsonReader.peeked = 8;
                } else if (i2 == 14) {
                    jsonReader.peeked = 10;
                } else {
                    throw jsonReader.unexpectedTokenError("a name");
                }
            }
        };
    }

    public JsonReader(Reader reader) {
        int[] iArr = new int[32];
        this.stack = iArr;
        this.stackSize = 0 + 1;
        iArr[0] = 6;
        this.pathNames = new String[32];
        this.pathIndices = new int[32];
        Objects.requireNonNull(reader, "in == null");
        this.in = reader;
    }

    private void checkLenient() throws MalformedJsonException {
        if (this.strictness != Strictness.LENIENT) {
            throw syntaxError("Use JsonReader.setStrictness(Strictness.LENIENT) to accept malformed JSON");
        }
    }

    private void consumeNonExecutePrefix() throws IOException {
        nextNonWhitespace(true);
        int i2 = this.pos - 1;
        this.pos = i2;
        if (i2 + 5 <= this.limit || fillBuffer(5)) {
            int i3 = this.pos;
            char[] cArr = this.buffer;
            if (cArr[i3] == ')' && cArr[i3 + 1] == ']' && cArr[i3 + 2] == '}' && cArr[i3 + 3] == '\'' && cArr[i3 + 4] == 10) {
                this.pos = i3 + 5;
            }
        }
    }

    private boolean fillBuffer(int i2) throws IOException {
        int i3;
        int i4;
        char[] cArr = this.buffer;
        int i5 = this.lineStart;
        int i6 = this.pos;
        this.lineStart = i5 - i6;
        int i7 = this.limit;
        if (i7 != i6) {
            int i8 = i7 - i6;
            this.limit = i8;
            System.arraycopy(cArr, i6, cArr, 0, i8);
        } else {
            this.limit = 0;
        }
        this.pos = 0;
        do {
            Reader reader = this.in;
            int i9 = this.limit;
            int read = reader.read(cArr, i9, cArr.length - i9);
            if (read == -1) {
                return false;
            }
            i3 = this.limit + read;
            this.limit = i3;
            if (this.lineNumber == 0 && (i4 = this.lineStart) == 0 && i3 > 0 && cArr[0] == 65279) {
                this.pos++;
                this.lineStart = i4 + 1;
                i2++;
                continue;
            }
        } while (i3 < i2);
        return true;
    }

    private String getPath(boolean z2) {
        StringBuilder sb = new StringBuilder();
        sb.append('$');
        int i2 = 0;
        while (true) {
            int i3 = this.stackSize;
            if (i2 >= i3) {
                return sb.toString();
            }
            int i4 = this.stack[i2];
            switch (i4) {
                case 1:
                case 2:
                    int i5 = this.pathIndices[i2];
                    if (z2 && i5 > 0 && i2 == i3 - 1) {
                        i5--;
                    }
                    sb.append('[');
                    sb.append(i5);
                    sb.append(']');
                    break;
                case 3:
                case 4:
                case 5:
                    sb.append('.');
                    String str = this.pathNames[i2];
                    if (str == null) {
                        break;
                    } else {
                        sb.append(str);
                        break;
                    }
                case 6:
                case 7:
                case 8:
                    break;
                default:
                    throw new AssertionError("Unknown scope value: " + i4);
            }
            i2++;
        }
    }

    private boolean isLiteral(char c2) throws IOException {
        if (c2 == 9 || c2 == 10 || c2 == 12 || c2 == 13 || c2 == ' ') {
            return false;
        }
        if (c2 != '#') {
            if (c2 == ',') {
                return false;
            }
            if (!(c2 == '/' || c2 == '=')) {
                if (c2 == '{' || c2 == '}' || c2 == ':') {
                    return false;
                }
                if (c2 != ';') {
                    switch (c2) {
                        case '[':
                        case ']':
                            return false;
                        case '\\':
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        checkLenient();
        return false;
    }

    private int nextNonWhitespace(boolean z2) throws IOException {
        char[] cArr = this.buffer;
        int i2 = this.pos;
        int i3 = this.limit;
        while (true) {
            if (i2 == i3) {
                this.pos = i2;
                if (fillBuffer(1)) {
                    i2 = this.pos;
                    i3 = this.limit;
                } else if (!z2) {
                    return -1;
                } else {
                    throw new EOFException("End of input" + locationString());
                }
            }
            int i4 = i2 + 1;
            char c2 = cArr[i2];
            if (c2 == 10) {
                this.lineNumber++;
                this.lineStart = i4;
            } else if (!(c2 == ' ' || c2 == 13 || c2 == 9)) {
                if (c2 == '/') {
                    this.pos = i4;
                    if (i4 == i3) {
                        this.pos = i4 - 1;
                        boolean fillBuffer = fillBuffer(2);
                        this.pos++;
                        if (!fillBuffer) {
                            return c2;
                        }
                    }
                    checkLenient();
                    int i5 = this.pos;
                    char c3 = cArr[i5];
                    if (c3 == '*') {
                        this.pos = i5 + 1;
                        if (skipTo("*/")) {
                            i2 = this.pos + 2;
                            i3 = this.limit;
                        } else {
                            throw syntaxError("Unterminated comment");
                        }
                    } else if (c3 != '/') {
                        return c2;
                    } else {
                        this.pos = i5 + 1;
                        skipToEndOfLine();
                        i2 = this.pos;
                        i3 = this.limit;
                    }
                } else if (c2 == '#') {
                    this.pos = i4;
                    checkLenient();
                    skipToEndOfLine();
                    i2 = this.pos;
                    i3 = this.limit;
                } else {
                    this.pos = i4;
                    return c2;
                }
            }
            i2 = i4;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x006e, code lost:
        if (r1 != null) goto L_0x007e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0070, code lost:
        r1 = new java.lang.StringBuilder(java.lang.Math.max((r2 - r3) * 2, 16));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x007e, code lost:
        r1.append(r0, r3, r2 - r3);
        r10.pos = r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String nextQuotedValue(char r11) throws java.io.IOException {
        /*
            r10 = this;
            char[] r0 = r10.buffer
            r1 = 0
        L_0x0003:
            int r2 = r10.pos
            int r3 = r10.limit
        L_0x0007:
            r4 = r3
            r3 = r2
        L_0x0009:
            r5 = 16
            r6 = 1
            if (r2 >= r4) goto L_0x006e
            int r7 = r2 + 1
            char r2 = r0[r2]
            com.google.gson.Strictness r8 = r10.strictness
            com.google.gson.Strictness r9 = com.google.gson.Strictness.STRICT
            if (r8 != r9) goto L_0x0024
            r8 = 32
            if (r2 < r8) goto L_0x001d
            goto L_0x0024
        L_0x001d:
            java.lang.String r11 = "Unescaped control characters (\\u0000-\\u001F) are not allowed in strict mode"
            com.google.gson.stream.MalformedJsonException r11 = r10.syntaxError(r11)
            throw r11
        L_0x0024:
            if (r2 != r11) goto L_0x003a
            r10.pos = r7
            int r7 = r7 - r3
            int r7 = r7 - r6
            if (r1 != 0) goto L_0x0032
            java.lang.String r11 = new java.lang.String
            r11.<init>(r0, r3, r7)
            return r11
        L_0x0032:
            r1.append(r0, r3, r7)
            java.lang.String r11 = r1.toString()
            return r11
        L_0x003a:
            r8 = 92
            if (r2 != r8) goto L_0x0061
            r10.pos = r7
            int r7 = r7 - r3
            int r7 = r7 - r6
            if (r1 != 0) goto L_0x0052
            int r1 = r7 + 1
            int r1 = r1 * 2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            int r1 = java.lang.Math.max(r1, r5)
            r2.<init>(r1)
            r1 = r2
        L_0x0052:
            r1.append(r0, r3, r7)
            char r2 = r10.readEscapeCharacter()
            r1.append(r2)
            int r2 = r10.pos
            int r3 = r10.limit
            goto L_0x0007
        L_0x0061:
            r5 = 10
            if (r2 != r5) goto L_0x006c
            int r2 = r10.lineNumber
            int r2 = r2 + r6
            r10.lineNumber = r2
            r10.lineStart = r7
        L_0x006c:
            r2 = r7
            goto L_0x0009
        L_0x006e:
            if (r1 != 0) goto L_0x007e
            int r1 = r2 - r3
            int r1 = r1 * 2
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            int r1 = java.lang.Math.max(r1, r5)
            r4.<init>(r1)
            r1 = r4
        L_0x007e:
            int r4 = r2 - r3
            r1.append(r0, r3, r4)
            r10.pos = r2
            boolean r2 = r10.fillBuffer(r6)
            if (r2 == 0) goto L_0x008d
            goto L_0x0003
        L_0x008d:
            java.lang.String r11 = "Unterminated string"
            com.google.gson.stream.MalformedJsonException r11 = r10.syntaxError(r11)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.stream.JsonReader.nextQuotedValue(char):java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x004a, code lost:
        checkLenient();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String nextUnquotedValue() throws java.io.IOException {
        /*
            r6 = this;
            r0 = 0
            r1 = 0
        L_0x0002:
            r2 = 0
        L_0x0003:
            int r3 = r6.pos
            int r4 = r3 + r2
            int r5 = r6.limit
            if (r4 >= r5) goto L_0x004e
            char[] r4 = r6.buffer
            int r3 = r3 + r2
            char r3 = r4[r3]
            r4 = 9
            if (r3 == r4) goto L_0x005c
            r4 = 10
            if (r3 == r4) goto L_0x005c
            r4 = 12
            if (r3 == r4) goto L_0x005c
            r4 = 13
            if (r3 == r4) goto L_0x005c
            r4 = 32
            if (r3 == r4) goto L_0x005c
            r4 = 35
            if (r3 == r4) goto L_0x004a
            r4 = 44
            if (r3 == r4) goto L_0x005c
            r4 = 47
            if (r3 == r4) goto L_0x004a
            r4 = 61
            if (r3 == r4) goto L_0x004a
            r4 = 123(0x7b, float:1.72E-43)
            if (r3 == r4) goto L_0x005c
            r4 = 125(0x7d, float:1.75E-43)
            if (r3 == r4) goto L_0x005c
            r4 = 58
            if (r3 == r4) goto L_0x005c
            r4 = 59
            if (r3 == r4) goto L_0x004a
            switch(r3) {
                case 91: goto L_0x005c;
                case 92: goto L_0x004a;
                case 93: goto L_0x005c;
                default: goto L_0x0047;
            }
        L_0x0047:
            int r2 = r2 + 1
            goto L_0x0003
        L_0x004a:
            r6.checkLenient()
            goto L_0x005c
        L_0x004e:
            char[] r3 = r6.buffer
            int r3 = r3.length
            if (r2 >= r3) goto L_0x005e
            int r3 = r2 + 1
            boolean r3 = r6.fillBuffer(r3)
            if (r3 == 0) goto L_0x005c
            goto L_0x0003
        L_0x005c:
            r1 = r2
            goto L_0x007e
        L_0x005e:
            if (r0 != 0) goto L_0x006b
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r3 = 16
            int r3 = java.lang.Math.max(r2, r3)
            r0.<init>(r3)
        L_0x006b:
            char[] r3 = r6.buffer
            int r4 = r6.pos
            r0.append(r3, r4, r2)
            int r3 = r6.pos
            int r3 = r3 + r2
            r6.pos = r3
            r2 = 1
            boolean r2 = r6.fillBuffer(r2)
            if (r2 != 0) goto L_0x0002
        L_0x007e:
            if (r0 != 0) goto L_0x008a
            java.lang.String r0 = new java.lang.String
            char[] r2 = r6.buffer
            int r3 = r6.pos
            r0.<init>(r2, r3, r1)
            goto L_0x0095
        L_0x008a:
            char[] r2 = r6.buffer
            int r3 = r6.pos
            r0.append(r2, r3, r1)
            java.lang.String r0 = r0.toString()
        L_0x0095:
            int r2 = r6.pos
            int r2 = r2 + r1
            r6.pos = r2
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.stream.JsonReader.nextUnquotedValue():java.lang.String");
    }

    private int peekKeyword() throws IOException {
        int i2;
        String str;
        String str2;
        boolean z2;
        boolean z3;
        char c2 = this.buffer[this.pos];
        if (c2 == 't' || c2 == 'T') {
            str2 = "true";
            str = "TRUE";
            i2 = 5;
        } else if (c2 == 'f' || c2 == 'F') {
            str2 = Constants.CASEFIRST_FALSE;
            str = "FALSE";
            i2 = 6;
        } else if (c2 != 'n' && c2 != 'N') {
            return 0;
        } else {
            str2 = "null";
            str = "NULL";
            i2 = 7;
        }
        if (this.strictness != Strictness.STRICT) {
            z2 = true;
        } else {
            z2 = false;
        }
        int length = str2.length();
        for (int i3 = 0; i3 < length; i3++) {
            if (this.pos + i3 >= this.limit && !fillBuffer(i3 + 1)) {
                return 0;
            }
            char c3 = this.buffer[this.pos + i3];
            if (c3 == str2.charAt(i3) || (z2 && c3 == str.charAt(i3))) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (!z3) {
                return 0;
            }
        }
        if ((this.pos + length < this.limit || fillBuffer(length + 1)) && isLiteral(this.buffer[this.pos + length])) {
            return 0;
        }
        this.pos += length;
        this.peeked = i2;
        return i2;
    }

    private int peekNumber() throws IOException {
        char c2;
        boolean z2;
        char[] cArr = this.buffer;
        int i2 = this.pos;
        int i3 = this.limit;
        int i4 = 0;
        int i5 = 0;
        char c3 = 0;
        boolean z3 = true;
        long j2 = 0;
        boolean z4 = false;
        while (true) {
            if (i2 + i5 == i3) {
                if (i5 == cArr.length) {
                    return i4;
                }
                if (!fillBuffer(i5 + 1)) {
                    break;
                }
                i2 = this.pos;
                i3 = this.limit;
            }
            c2 = cArr[i2 + i5];
            if (c2 == '+') {
                i4 = 0;
                if (c3 != 5) {
                    return 0;
                }
            } else if (c2 == 'E' || c2 == 'e') {
                i4 = 0;
                if (c3 != 2 && c3 != 4) {
                    return 0;
                }
                c3 = 5;
                i5++;
            } else {
                if (c2 == '-') {
                    i4 = 0;
                    if (c3 == 0) {
                        c3 = 1;
                        z4 = true;
                    } else if (c3 != 5) {
                        return 0;
                    }
                } else if (c2 == '.') {
                    i4 = 0;
                    if (c3 != 2) {
                        return 0;
                    }
                    c3 = 3;
                } else if (c2 >= '0' && c2 <= '9') {
                    if (c3 == 1 || c3 == 0) {
                        j2 = (long) (-(c2 - '0'));
                        i4 = 0;
                        c3 = 2;
                    } else {
                        if (c3 == 2) {
                            if (j2 == 0) {
                                return 0;
                            }
                            long j3 = (10 * j2) - ((long) (c2 - '0'));
                            int i6 = (j2 > MIN_INCOMPLETE_INTEGER ? 1 : (j2 == MIN_INCOMPLETE_INTEGER ? 0 : -1));
                            if (i6 > 0 || (i6 == 0 && j3 < j2)) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            z3 &= z2;
                            j2 = j3;
                        } else if (c3 == 3) {
                            i4 = 0;
                            c3 = 4;
                        } else if (c3 == 5 || c3 == 6) {
                            i4 = 0;
                            c3 = 7;
                        }
                        i4 = 0;
                    }
                }
                i5++;
            }
            c3 = 6;
            i5++;
        }
        if (isLiteral(c2)) {
            return 0;
        }
        if (c3 == 2 && z3 && ((j2 != Long.MIN_VALUE || z4) && (j2 != 0 || !z4))) {
            if (!z4) {
                j2 = -j2;
            }
            this.peekedLong = j2;
            this.pos += i5;
            this.peeked = 15;
            return 15;
        } else if (c3 != 2 && c3 != 4 && c3 != 7) {
            return 0;
        } else {
            this.peekedNumberLength = i5;
            this.peeked = 16;
            return 16;
        }
    }

    private void push(int i2) {
        int i3 = this.stackSize;
        int[] iArr = this.stack;
        if (i3 == iArr.length) {
            int i4 = i3 * 2;
            this.stack = Arrays.copyOf(iArr, i4);
            this.pathIndices = Arrays.copyOf(this.pathIndices, i4);
            this.pathNames = (String[]) Arrays.copyOf(this.pathNames, i4);
        }
        int[] iArr2 = this.stack;
        int i5 = this.stackSize;
        this.stackSize = i5 + 1;
        iArr2[i5] = i2;
    }

    private char readEscapeCharacter() throws IOException {
        int i2;
        int i3;
        if (this.pos != this.limit || fillBuffer(1)) {
            char[] cArr = this.buffer;
            int i4 = this.pos;
            int i5 = i4 + 1;
            this.pos = i5;
            char c2 = cArr[i4];
            if (c2 != 10) {
                if (c2 != '\"') {
                    if (c2 != '\'') {
                        if (!(c2 == '/' || c2 == '\\')) {
                            if (c2 == 'b') {
                                return 8;
                            }
                            if (c2 == 'f') {
                                return 12;
                            }
                            if (c2 == 'n') {
                                return 10;
                            }
                            if (c2 == 'r') {
                                return 13;
                            }
                            if (c2 == 't') {
                                return 9;
                            }
                            if (c2 != 'u') {
                                throw syntaxError("Invalid escape sequence");
                            } else if (i5 + 4 <= this.limit || fillBuffer(4)) {
                                int i6 = this.pos;
                                int i7 = i6 + 4;
                                int i8 = 0;
                                while (i6 < i7) {
                                    char c3 = this.buffer[i6];
                                    int i9 = i8 << 4;
                                    if (c3 < '0' || c3 > '9') {
                                        if (c3 >= 'a' && c3 <= 'f') {
                                            i2 = c3 - 'a';
                                        } else if (c3 < 'A' || c3 > 'F') {
                                            throw syntaxError("Malformed Unicode escape \\u" + new String(this.buffer, this.pos, 4));
                                        } else {
                                            i2 = c3 - 'A';
                                        }
                                        i3 = i2 + 10;
                                    } else {
                                        i3 = c3 - '0';
                                    }
                                    i8 = i9 + i3;
                                    i6++;
                                }
                                this.pos += 4;
                                return (char) i8;
                            } else {
                                throw syntaxError("Unterminated escape sequence");
                            }
                        }
                    }
                }
                return c2;
            } else if (this.strictness != Strictness.STRICT) {
                this.lineNumber++;
                this.lineStart = i5;
            } else {
                throw syntaxError("Cannot escape a newline character in strict mode");
            }
            if (this.strictness == Strictness.STRICT) {
                throw syntaxError("Invalid escaped character \"'\" in strict mode");
            }
            return c2;
        }
        throw syntaxError("Unterminated escape sequence");
    }

    private void skipQuotedValue(char c2) throws IOException {
        char[] cArr = this.buffer;
        do {
            int i2 = this.pos;
            int i3 = this.limit;
            while (i2 < i3) {
                int i4 = i2 + 1;
                char c3 = cArr[i2];
                if (c3 == c2) {
                    this.pos = i4;
                    return;
                } else if (c3 == '\\') {
                    this.pos = i4;
                    readEscapeCharacter();
                    i2 = this.pos;
                    i3 = this.limit;
                } else {
                    if (c3 == 10) {
                        this.lineNumber++;
                        this.lineStart = i4;
                    }
                    i2 = i4;
                }
            }
            this.pos = i2;
        } while (fillBuffer(1));
        throw syntaxError("Unterminated string");
    }

    private boolean skipTo(String str) throws IOException {
        int length = str.length();
        while (true) {
            int i2 = 0;
            if (this.pos + length > this.limit && !fillBuffer(length)) {
                return false;
            }
            char[] cArr = this.buffer;
            int i3 = this.pos;
            if (cArr[i3] == 10) {
                this.lineNumber++;
                this.lineStart = i3 + 1;
            } else {
                while (i2 < length) {
                    if (this.buffer[this.pos + i2] == str.charAt(i2)) {
                        i2++;
                    }
                }
                return true;
            }
            this.pos++;
        }
    }

    private void skipToEndOfLine() throws IOException {
        char c2;
        do {
            if (this.pos < this.limit || fillBuffer(1)) {
                char[] cArr = this.buffer;
                int i2 = this.pos;
                int i3 = i2 + 1;
                this.pos = i3;
                c2 = cArr[i2];
                if (c2 == 10) {
                    this.lineNumber++;
                    this.lineStart = i3;
                    return;
                }
            } else {
                return;
            }
        } while (c2 != 13);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0048, code lost:
        checkLenient();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void skipUnquotedValue() throws java.io.IOException {
        /*
            r4 = this;
        L_0x0000:
            r0 = 0
        L_0x0001:
            int r1 = r4.pos
            int r2 = r1 + r0
            int r3 = r4.limit
            if (r2 >= r3) goto L_0x0051
            char[] r2 = r4.buffer
            int r1 = r1 + r0
            char r1 = r2[r1]
            r2 = 9
            if (r1 == r2) goto L_0x004b
            r2 = 10
            if (r1 == r2) goto L_0x004b
            r2 = 12
            if (r1 == r2) goto L_0x004b
            r2 = 13
            if (r1 == r2) goto L_0x004b
            r2 = 32
            if (r1 == r2) goto L_0x004b
            r2 = 35
            if (r1 == r2) goto L_0x0048
            r2 = 44
            if (r1 == r2) goto L_0x004b
            r2 = 47
            if (r1 == r2) goto L_0x0048
            r2 = 61
            if (r1 == r2) goto L_0x0048
            r2 = 123(0x7b, float:1.72E-43)
            if (r1 == r2) goto L_0x004b
            r2 = 125(0x7d, float:1.75E-43)
            if (r1 == r2) goto L_0x004b
            r2 = 58
            if (r1 == r2) goto L_0x004b
            r2 = 59
            if (r1 == r2) goto L_0x0048
            switch(r1) {
                case 91: goto L_0x004b;
                case 92: goto L_0x0048;
                case 93: goto L_0x004b;
                default: goto L_0x0045;
            }
        L_0x0045:
            int r0 = r0 + 1
            goto L_0x0001
        L_0x0048:
            r4.checkLenient()
        L_0x004b:
            int r1 = r4.pos
            int r1 = r1 + r0
            r4.pos = r1
            return
        L_0x0051:
            int r1 = r1 + r0
            r4.pos = r1
            r0 = 1
            boolean r0 = r4.fillBuffer(r0)
            if (r0 != 0) goto L_0x0000
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.stream.JsonReader.skipUnquotedValue():void");
    }

    private MalformedJsonException syntaxError(String str) throws MalformedJsonException {
        throw new MalformedJsonException(str + locationString() + "\nSee " + TroubleshootingGuide.a("malformed-json"));
    }

    /* access modifiers changed from: private */
    public IllegalStateException unexpectedTokenError(String str) throws IOException {
        String str2;
        if (peek() == JsonToken.NULL) {
            str2 = "adapter-not-null-safe";
        } else {
            str2 = "unexpected-json-structure";
        }
        return new IllegalStateException("Expected " + str + " but was " + peek() + locationString() + "\nSee " + TroubleshootingGuide.a(str2));
    }

    public void beginArray() throws IOException {
        int i2 = this.peeked;
        if (i2 == 0) {
            i2 = doPeek();
        }
        if (i2 == 3) {
            push(1);
            this.pathIndices[this.stackSize - 1] = 0;
            this.peeked = 0;
            return;
        }
        throw unexpectedTokenError("BEGIN_ARRAY");
    }

    public void beginObject() throws IOException {
        int i2 = this.peeked;
        if (i2 == 0) {
            i2 = doPeek();
        }
        if (i2 == 1) {
            push(3);
            this.peeked = 0;
            return;
        }
        throw unexpectedTokenError("BEGIN_OBJECT");
    }

    public void close() throws IOException {
        this.peeked = 0;
        this.stack[0] = 8;
        this.stackSize = 1;
        this.in.close();
    }

    /* access modifiers changed from: package-private */
    public int doPeek() throws IOException {
        int nextNonWhitespace;
        int[] iArr = this.stack;
        int i2 = this.stackSize;
        int i3 = iArr[i2 - 1];
        if (i3 == 1) {
            iArr[i2 - 1] = 2;
        } else if (i3 == 2) {
            int nextNonWhitespace2 = nextNonWhitespace(true);
            if (nextNonWhitespace2 != 44) {
                if (nextNonWhitespace2 == 59) {
                    checkLenient();
                } else if (nextNonWhitespace2 == 93) {
                    this.peeked = 4;
                    return 4;
                } else {
                    throw syntaxError("Unterminated array");
                }
            }
        } else if (i3 == 3 || i3 == 5) {
            iArr[i2 - 1] = 4;
            if (i3 == 5 && (nextNonWhitespace = nextNonWhitespace(true)) != 44) {
                if (nextNonWhitespace == 59) {
                    checkLenient();
                } else if (nextNonWhitespace == 125) {
                    this.peeked = 2;
                    return 2;
                } else {
                    throw syntaxError("Unterminated object");
                }
            }
            int nextNonWhitespace3 = nextNonWhitespace(true);
            if (nextNonWhitespace3 == 34) {
                this.peeked = 13;
                return 13;
            } else if (nextNonWhitespace3 == 39) {
                checkLenient();
                this.peeked = 12;
                return 12;
            } else if (nextNonWhitespace3 != 125) {
                checkLenient();
                this.pos--;
                if (isLiteral((char) nextNonWhitespace3)) {
                    this.peeked = 14;
                    return 14;
                }
                throw syntaxError("Expected name");
            } else if (i3 != 5) {
                this.peeked = 2;
                return 2;
            } else {
                throw syntaxError("Expected name");
            }
        } else if (i3 == 4) {
            iArr[i2 - 1] = 5;
            int nextNonWhitespace4 = nextNonWhitespace(true);
            if (nextNonWhitespace4 != 58) {
                if (nextNonWhitespace4 == 61) {
                    checkLenient();
                    if (this.pos < this.limit || fillBuffer(1)) {
                        char[] cArr = this.buffer;
                        int i4 = this.pos;
                        if (cArr[i4] == '>') {
                            this.pos = i4 + 1;
                        }
                    }
                } else {
                    throw syntaxError("Expected ':'");
                }
            }
        } else if (i3 == 6) {
            if (this.strictness == Strictness.LENIENT) {
                consumeNonExecutePrefix();
            }
            this.stack[this.stackSize - 1] = 7;
        } else if (i3 == 7) {
            if (nextNonWhitespace(false) == -1) {
                this.peeked = 17;
                return 17;
            }
            checkLenient();
            this.pos--;
        } else if (i3 == 8) {
            throw new IllegalStateException("JsonReader is closed");
        }
        int nextNonWhitespace5 = nextNonWhitespace(true);
        if (nextNonWhitespace5 == 34) {
            this.peeked = 9;
            return 9;
        } else if (nextNonWhitespace5 != 39) {
            if (!(nextNonWhitespace5 == 44 || nextNonWhitespace5 == 59)) {
                if (nextNonWhitespace5 == 91) {
                    this.peeked = 3;
                    return 3;
                } else if (nextNonWhitespace5 != 93) {
                    if (nextNonWhitespace5 != 123) {
                        this.pos--;
                        int peekKeyword = peekKeyword();
                        if (peekKeyword != 0) {
                            return peekKeyword;
                        }
                        int peekNumber = peekNumber();
                        if (peekNumber != 0) {
                            return peekNumber;
                        }
                        if (isLiteral(this.buffer[this.pos])) {
                            checkLenient();
                            this.peeked = 10;
                            return 10;
                        }
                        throw syntaxError("Expected value");
                    }
                    this.peeked = 1;
                    return 1;
                } else if (i3 == 1) {
                    this.peeked = 4;
                    return 4;
                }
            }
            if (i3 == 1 || i3 == 2) {
                checkLenient();
                this.pos--;
                this.peeked = 7;
                return 7;
            }
            throw syntaxError("Unexpected value");
        } else {
            checkLenient();
            this.peeked = 8;
            return 8;
        }
    }

    public void endArray() throws IOException {
        int i2 = this.peeked;
        if (i2 == 0) {
            i2 = doPeek();
        }
        if (i2 == 4) {
            int i3 = this.stackSize - 1;
            this.stackSize = i3;
            int[] iArr = this.pathIndices;
            int i4 = i3 - 1;
            iArr[i4] = iArr[i4] + 1;
            this.peeked = 0;
            return;
        }
        throw unexpectedTokenError("END_ARRAY");
    }

    public void endObject() throws IOException {
        int i2 = this.peeked;
        if (i2 == 0) {
            i2 = doPeek();
        }
        if (i2 == 2) {
            int i3 = this.stackSize - 1;
            this.stackSize = i3;
            this.pathNames[i3] = null;
            int[] iArr = this.pathIndices;
            int i4 = i3 - 1;
            iArr[i4] = iArr[i4] + 1;
            this.peeked = 0;
            return;
        }
        throw unexpectedTokenError("END_OBJECT");
    }

    public String getPreviousPath() {
        return getPath(true);
    }

    public final Strictness getStrictness() {
        return this.strictness;
    }

    public boolean hasNext() throws IOException {
        int i2 = this.peeked;
        if (i2 == 0) {
            i2 = doPeek();
        }
        if (i2 == 2 || i2 == 4 || i2 == 17) {
            return false;
        }
        return true;
    }

    public final boolean isLenient() {
        return this.strictness == Strictness.LENIENT;
    }

    /* access modifiers changed from: package-private */
    public String locationString() {
        return " at line " + (this.lineNumber + 1) + " column " + ((this.pos - this.lineStart) + 1) + " path " + getPath();
    }

    public boolean nextBoolean() throws IOException {
        int i2 = this.peeked;
        if (i2 == 0) {
            i2 = doPeek();
        }
        if (i2 == 5) {
            this.peeked = 0;
            int[] iArr = this.pathIndices;
            int i3 = this.stackSize - 1;
            iArr[i3] = iArr[i3] + 1;
            return true;
        } else if (i2 == 6) {
            this.peeked = 0;
            int[] iArr2 = this.pathIndices;
            int i4 = this.stackSize - 1;
            iArr2[i4] = iArr2[i4] + 1;
            return false;
        } else {
            throw unexpectedTokenError("a boolean");
        }
    }

    public double nextDouble() throws IOException {
        char c2;
        int i2 = this.peeked;
        if (i2 == 0) {
            i2 = doPeek();
        }
        if (i2 == 15) {
            this.peeked = 0;
            int[] iArr = this.pathIndices;
            int i3 = this.stackSize - 1;
            iArr[i3] = iArr[i3] + 1;
            return (double) this.peekedLong;
        }
        if (i2 == 16) {
            this.peekedString = new String(this.buffer, this.pos, this.peekedNumberLength);
            this.pos += this.peekedNumberLength;
        } else if (i2 == 8 || i2 == 9) {
            if (i2 == 8) {
                c2 = '\'';
            } else {
                c2 = '\"';
            }
            this.peekedString = nextQuotedValue(c2);
        } else if (i2 == 10) {
            this.peekedString = nextUnquotedValue();
        } else if (i2 != 11) {
            throw unexpectedTokenError("a double");
        }
        this.peeked = 11;
        double parseDouble = Double.parseDouble(this.peekedString);
        if (this.strictness == Strictness.LENIENT || (!Double.isNaN(parseDouble) && !Double.isInfinite(parseDouble))) {
            this.peekedString = null;
            this.peeked = 0;
            int[] iArr2 = this.pathIndices;
            int i4 = this.stackSize - 1;
            iArr2[i4] = iArr2[i4] + 1;
            return parseDouble;
        }
        throw syntaxError("JSON forbids NaN and infinities: " + parseDouble);
    }

    public int nextInt() throws IOException {
        char c2;
        int i2 = this.peeked;
        if (i2 == 0) {
            i2 = doPeek();
        }
        if (i2 == 15) {
            long j2 = this.peekedLong;
            int i3 = (int) j2;
            if (j2 == ((long) i3)) {
                this.peeked = 0;
                int[] iArr = this.pathIndices;
                int i4 = this.stackSize - 1;
                iArr[i4] = iArr[i4] + 1;
                return i3;
            }
            throw new NumberFormatException("Expected an int but was " + this.peekedLong + locationString());
        }
        if (i2 == 16) {
            this.peekedString = new String(this.buffer, this.pos, this.peekedNumberLength);
            this.pos += this.peekedNumberLength;
        } else if (i2 == 8 || i2 == 9 || i2 == 10) {
            if (i2 == 10) {
                this.peekedString = nextUnquotedValue();
            } else {
                if (i2 == 8) {
                    c2 = '\'';
                } else {
                    c2 = '\"';
                }
                this.peekedString = nextQuotedValue(c2);
            }
            try {
                int parseInt = Integer.parseInt(this.peekedString);
                this.peeked = 0;
                int[] iArr2 = this.pathIndices;
                int i5 = this.stackSize - 1;
                iArr2[i5] = iArr2[i5] + 1;
                return parseInt;
            } catch (NumberFormatException unused) {
            }
        } else {
            throw unexpectedTokenError("an int");
        }
        this.peeked = 11;
        double parseDouble = Double.parseDouble(this.peekedString);
        int i6 = (int) parseDouble;
        if (((double) i6) == parseDouble) {
            this.peekedString = null;
            this.peeked = 0;
            int[] iArr3 = this.pathIndices;
            int i7 = this.stackSize - 1;
            iArr3[i7] = iArr3[i7] + 1;
            return i6;
        }
        throw new NumberFormatException("Expected an int but was " + this.peekedString + locationString());
    }

    public long nextLong() throws IOException {
        char c2;
        int i2 = this.peeked;
        if (i2 == 0) {
            i2 = doPeek();
        }
        if (i2 == 15) {
            this.peeked = 0;
            int[] iArr = this.pathIndices;
            int i3 = this.stackSize - 1;
            iArr[i3] = iArr[i3] + 1;
            return this.peekedLong;
        }
        if (i2 == 16) {
            this.peekedString = new String(this.buffer, this.pos, this.peekedNumberLength);
            this.pos += this.peekedNumberLength;
        } else if (i2 == 8 || i2 == 9 || i2 == 10) {
            if (i2 == 10) {
                this.peekedString = nextUnquotedValue();
            } else {
                if (i2 == 8) {
                    c2 = '\'';
                } else {
                    c2 = '\"';
                }
                this.peekedString = nextQuotedValue(c2);
            }
            try {
                long parseLong = Long.parseLong(this.peekedString);
                this.peeked = 0;
                int[] iArr2 = this.pathIndices;
                int i4 = this.stackSize - 1;
                iArr2[i4] = iArr2[i4] + 1;
                return parseLong;
            } catch (NumberFormatException unused) {
            }
        } else {
            throw unexpectedTokenError("a long");
        }
        this.peeked = 11;
        double parseDouble = Double.parseDouble(this.peekedString);
        long j2 = (long) parseDouble;
        if (((double) j2) == parseDouble) {
            this.peekedString = null;
            this.peeked = 0;
            int[] iArr3 = this.pathIndices;
            int i5 = this.stackSize - 1;
            iArr3[i5] = iArr3[i5] + 1;
            return j2;
        }
        throw new NumberFormatException("Expected a long but was " + this.peekedString + locationString());
    }

    public String nextName() throws IOException {
        String str;
        int i2 = this.peeked;
        if (i2 == 0) {
            i2 = doPeek();
        }
        if (i2 == 14) {
            str = nextUnquotedValue();
        } else if (i2 == 12) {
            str = nextQuotedValue('\'');
        } else if (i2 == 13) {
            str = nextQuotedValue('\"');
        } else {
            throw unexpectedTokenError("a name");
        }
        this.peeked = 0;
        this.pathNames[this.stackSize - 1] = str;
        return str;
    }

    public void nextNull() throws IOException {
        int i2 = this.peeked;
        if (i2 == 0) {
            i2 = doPeek();
        }
        if (i2 == 7) {
            this.peeked = 0;
            int[] iArr = this.pathIndices;
            int i3 = this.stackSize - 1;
            iArr[i3] = iArr[i3] + 1;
            return;
        }
        throw unexpectedTokenError("null");
    }

    public String nextString() throws IOException {
        String str;
        int i2 = this.peeked;
        if (i2 == 0) {
            i2 = doPeek();
        }
        if (i2 == 10) {
            str = nextUnquotedValue();
        } else if (i2 == 8) {
            str = nextQuotedValue('\'');
        } else if (i2 == 9) {
            str = nextQuotedValue('\"');
        } else if (i2 == 11) {
            str = this.peekedString;
            this.peekedString = null;
        } else if (i2 == 15) {
            str = Long.toString(this.peekedLong);
        } else if (i2 == 16) {
            str = new String(this.buffer, this.pos, this.peekedNumberLength);
            this.pos += this.peekedNumberLength;
        } else {
            throw unexpectedTokenError("a string");
        }
        this.peeked = 0;
        int[] iArr = this.pathIndices;
        int i3 = this.stackSize - 1;
        iArr[i3] = iArr[i3] + 1;
        return str;
    }

    public JsonToken peek() throws IOException {
        int i2 = this.peeked;
        if (i2 == 0) {
            i2 = doPeek();
        }
        switch (i2) {
            case 1:
                return JsonToken.BEGIN_OBJECT;
            case 2:
                return JsonToken.END_OBJECT;
            case 3:
                return JsonToken.BEGIN_ARRAY;
            case 4:
                return JsonToken.END_ARRAY;
            case 5:
            case 6:
                return JsonToken.BOOLEAN;
            case 7:
                return JsonToken.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return JsonToken.STRING;
            case 12:
            case 13:
            case 14:
                return JsonToken.NAME;
            case 15:
            case 16:
                return JsonToken.NUMBER;
            case 17:
                return JsonToken.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    @Deprecated
    public final void setLenient(boolean z2) {
        setStrictness(z2 ? Strictness.LENIENT : Strictness.LEGACY_STRICT);
    }

    public final void setStrictness(Strictness strictness2) {
        Objects.requireNonNull(strictness2);
        this.strictness = strictness2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0056, code lost:
        r1 = r1 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0071, code lost:
        r1 = r1 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0073, code lost:
        r7.peeked = 0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void skipValue() throws java.io.IOException {
        /*
            r7 = this;
            r0 = 0
            r1 = 0
        L_0x0002:
            int r2 = r7.peeked
            if (r2 != 0) goto L_0x000a
            int r2 = r7.doPeek()
        L_0x000a:
            r3 = 34
            r4 = 39
            java.lang.String r5 = "<skipped>"
            r6 = 1
            switch(r2) {
                case 1: goto L_0x006d;
                case 2: goto L_0x005d;
                case 3: goto L_0x0059;
                case 4: goto L_0x0051;
                case 5: goto L_0x0014;
                case 6: goto L_0x0014;
                case 7: goto L_0x0014;
                case 8: goto L_0x004d;
                case 9: goto L_0x0049;
                case 10: goto L_0x0045;
                case 11: goto L_0x0014;
                case 12: goto L_0x0038;
                case 13: goto L_0x002b;
                case 14: goto L_0x001e;
                case 15: goto L_0x0014;
                case 16: goto L_0x0016;
                case 17: goto L_0x0015;
                default: goto L_0x0014;
            }
        L_0x0014:
            goto L_0x0073
        L_0x0015:
            return
        L_0x0016:
            int r2 = r7.pos
            int r3 = r7.peekedNumberLength
            int r2 = r2 + r3
            r7.pos = r2
            goto L_0x0073
        L_0x001e:
            r7.skipUnquotedValue()
            if (r1 != 0) goto L_0x0073
            java.lang.String[] r2 = r7.pathNames
            int r3 = r7.stackSize
            int r3 = r3 - r6
            r2[r3] = r5
            goto L_0x0073
        L_0x002b:
            r7.skipQuotedValue(r3)
            if (r1 != 0) goto L_0x0073
            java.lang.String[] r2 = r7.pathNames
            int r3 = r7.stackSize
            int r3 = r3 - r6
            r2[r3] = r5
            goto L_0x0073
        L_0x0038:
            r7.skipQuotedValue(r4)
            if (r1 != 0) goto L_0x0073
            java.lang.String[] r2 = r7.pathNames
            int r3 = r7.stackSize
            int r3 = r3 - r6
            r2[r3] = r5
            goto L_0x0073
        L_0x0045:
            r7.skipUnquotedValue()
            goto L_0x0073
        L_0x0049:
            r7.skipQuotedValue(r3)
            goto L_0x0073
        L_0x004d:
            r7.skipQuotedValue(r4)
            goto L_0x0073
        L_0x0051:
            int r2 = r7.stackSize
            int r2 = r2 - r6
            r7.stackSize = r2
        L_0x0056:
            int r1 = r1 + -1
            goto L_0x0073
        L_0x0059:
            r7.push(r6)
            goto L_0x0071
        L_0x005d:
            if (r1 != 0) goto L_0x0067
            java.lang.String[] r2 = r7.pathNames
            int r3 = r7.stackSize
            int r3 = r3 - r6
            r4 = 0
            r2[r3] = r4
        L_0x0067:
            int r2 = r7.stackSize
            int r2 = r2 - r6
            r7.stackSize = r2
            goto L_0x0056
        L_0x006d:
            r2 = 3
            r7.push(r2)
        L_0x0071:
            int r1 = r1 + 1
        L_0x0073:
            r7.peeked = r0
            if (r1 > 0) goto L_0x0002
            int[] r0 = r7.pathIndices
            int r1 = r7.stackSize
            int r1 = r1 - r6
            r2 = r0[r1]
            int r2 = r2 + r6
            r0[r1] = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.stream.JsonReader.skipValue():void");
    }

    public String toString() {
        return getClass().getSimpleName() + locationString();
    }

    public String getPath() {
        return getPath(false);
    }
}
