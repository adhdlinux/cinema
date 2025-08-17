package com.facebook.soloader;

import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.ClosedByInterruptException;
import okhttp3.internal.ws.WebSocketProtocol;

public final class MinElf {
    public static final int DT_NEEDED = 1;
    public static final int DT_NULL = 0;
    public static final int DT_STRTAB = 5;
    public static final int ELF_MAGIC = 1179403647;
    public static final int PN_XNUM = 65535;
    public static final int PT_DYNAMIC = 2;
    public static final int PT_LOAD = 1;
    private static final String TAG = "MinElf";

    private static class ElfError extends RuntimeException {
        ElfError(String str) {
            super(str);
        }
    }

    public enum ISA {
        NOT_SO("not_so"),
        X86("x86"),
        ARM("armeabi-v7a"),
        X86_64("x86_64"),
        AARCH64("arm64-v8a"),
        OTHERS("others");
        
        private final String value;

        private ISA(String str) {
            this.value = str;
        }

        public String toString() {
            return this.value;
        }
    }

    public static String[] extract_DT_NEEDED(File file) throws IOException {
        ElfFileChannel elfFileChannel = new ElfFileChannel(file);
        try {
            String[] extract_DT_NEEDED = extract_DT_NEEDED((ElfByteChannel) elfFileChannel);
            elfFileChannel.close();
            return extract_DT_NEEDED;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    private static String[] extract_DT_NEEDED_no_retries(ElfByteChannel elfByteChannel) throws IOException {
        long j2;
        long j3;
        long j4;
        long j5;
        long j6;
        long j7;
        long j8;
        long j9;
        long j10;
        long j11;
        long j12;
        long j13;
        long j14;
        long j15;
        long j16;
        long j17;
        long j18;
        long j19;
        long j20;
        long j21;
        ElfByteChannel elfByteChannel2 = elfByteChannel;
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        long j22 = getu32(elfByteChannel2, allocate, 0);
        if (j22 == 1179403647) {
            boolean z2 = true;
            if (getu8(elfByteChannel2, allocate, 4) != 1) {
                z2 = false;
            }
            if (getu8(elfByteChannel2, allocate, 5) == 2) {
                allocate.order(ByteOrder.BIG_ENDIAN);
            }
            if (z2) {
                j2 = getu32(elfByteChannel2, allocate, 28);
            } else {
                j2 = get64(elfByteChannel2, allocate, 32);
            }
            if (z2) {
                j3 = (long) getu16(elfByteChannel2, allocate, 44);
            } else {
                j3 = (long) getu16(elfByteChannel2, allocate, 56);
            }
            if (z2) {
                j4 = 42;
            } else {
                j4 = 54;
            }
            int i2 = getu16(elfByteChannel2, allocate, j4);
            if (j3 == WebSocketProtocol.PAYLOAD_SHORT_MAX) {
                if (z2) {
                    j20 = getu32(elfByteChannel2, allocate, 32);
                } else {
                    j20 = get64(elfByteChannel2, allocate, 40);
                }
                if (z2) {
                    j21 = getu32(elfByteChannel2, allocate, j20 + 28);
                } else {
                    j21 = getu32(elfByteChannel2, allocate, j20 + 44);
                }
                j3 = j21;
            }
            long j23 = j2;
            long j24 = 0;
            while (true) {
                if (j24 >= j3) {
                    j5 = 0;
                    break;
                }
                if (z2) {
                    j19 = getu32(elfByteChannel2, allocate, j23 + 0);
                } else {
                    j19 = getu32(elfByteChannel2, allocate, j23 + 0);
                }
                if (j19 != 2) {
                    j23 += (long) i2;
                    j24++;
                } else if (z2) {
                    j5 = getu32(elfByteChannel2, allocate, j23 + 4);
                } else {
                    j5 = get64(elfByteChannel2, allocate, j23 + 8);
                }
            }
            long j25 = 0;
            if (j5 != 0) {
                long j26 = j5;
                long j27 = 0;
                int i3 = 0;
                while (true) {
                    boolean z3 = z2;
                    if (z2) {
                        j6 = getu32(elfByteChannel2, allocate, j26 + j25);
                    } else {
                        j6 = get64(elfByteChannel2, allocate, j26 + j25);
                    }
                    if (j6 == 1) {
                        j7 = j5;
                        if (i3 != Integer.MAX_VALUE) {
                            i3++;
                        } else {
                            throw new ElfError("malformed DT_NEEDED section");
                        }
                    } else {
                        j7 = j5;
                        if (j6 == 5) {
                            if (z3) {
                                j18 = getu32(elfByteChannel2, allocate, j26 + 4);
                            } else {
                                j18 = get64(elfByteChannel2, allocate, j26 + 8);
                            }
                            j27 = j18;
                        }
                    }
                    long j28 = 16;
                    if (z3) {
                        j8 = 8;
                    } else {
                        j8 = 16;
                    }
                    j26 += j8;
                    j25 = 0;
                    if (j6 != 0) {
                        z2 = z3;
                        j5 = j7;
                    } else if (j27 != 0) {
                        int i4 = 0;
                        while (true) {
                            if (((long) i4) >= j3) {
                                j9 = 0;
                                break;
                            }
                            if (z3) {
                                j13 = getu32(elfByteChannel2, allocate, j2 + j25);
                            } else {
                                j13 = getu32(elfByteChannel2, allocate, j2 + j25);
                            }
                            if (j13 == 1) {
                                if (z3) {
                                    j15 = getu32(elfByteChannel2, allocate, j2 + 8);
                                } else {
                                    j15 = get64(elfByteChannel2, allocate, j2 + j28);
                                }
                                if (z3) {
                                    j14 = j3;
                                    j16 = getu32(elfByteChannel2, allocate, j2 + 20);
                                } else {
                                    j14 = j3;
                                    j16 = get64(elfByteChannel2, allocate, j2 + 40);
                                }
                                if (j15 <= j27 && j27 < j16 + j15) {
                                    if (z3) {
                                        j17 = getu32(elfByteChannel2, allocate, j2 + 4);
                                    } else {
                                        j17 = get64(elfByteChannel2, allocate, j2 + 8);
                                    }
                                    j9 = j17 + (j27 - j15);
                                }
                            } else {
                                j14 = j3;
                            }
                            j2 += (long) i2;
                            i4++;
                            j3 = j14;
                            j28 = 16;
                            j25 = 0;
                        }
                        long j29 = 0;
                        if (j9 != 0) {
                            String[] strArr = new String[i3];
                            int i5 = 0;
                            while (true) {
                                long j30 = j7 + j29;
                                if (z3) {
                                    j10 = getu32(elfByteChannel2, allocate, j30);
                                } else {
                                    j10 = get64(elfByteChannel2, allocate, j30);
                                }
                                if (j10 == 1) {
                                    if (z3) {
                                        j12 = getu32(elfByteChannel2, allocate, j7 + 4);
                                    } else {
                                        j12 = get64(elfByteChannel2, allocate, j7 + 8);
                                    }
                                    strArr[i5] = getSz(elfByteChannel2, allocate, j12 + j9);
                                    if (i5 != Integer.MAX_VALUE) {
                                        i5++;
                                    } else {
                                        throw new ElfError("malformed DT_NEEDED section");
                                    }
                                }
                                if (z3) {
                                    j11 = 8;
                                } else {
                                    j11 = 16;
                                }
                                j7 += j11;
                                if (j10 != 0) {
                                    j29 = 0;
                                } else if (i5 == i3) {
                                    return strArr;
                                } else {
                                    throw new ElfError("malformed DT_NEEDED section");
                                }
                            }
                        } else {
                            throw new ElfError("did not find file offset of DT_STRTAB table");
                        }
                    } else {
                        throw new ElfError("Dynamic section string-table not found");
                    }
                }
            } else {
                throw new ElfError("ELF file does not contain dynamic linking information");
            }
        } else {
            throw new ElfError("file is not ELF: 0x" + Long.toHexString(j22));
        }
    }

    private static String[] extract_DT_NEEDED_with_retries(ElfFileChannel elfFileChannel) throws IOException {
        int i2 = 0;
        while (true) {
            try {
                return extract_DT_NEEDED_no_retries(elfFileChannel);
            } catch (ClosedByInterruptException e2) {
                i2++;
                if (i2 <= 4) {
                    Thread.interrupted();
                    Log.e(TAG, "retrying extract_DT_NEEDED due to ClosedByInterruptException", e2);
                    elfFileChannel.openChannel();
                } else {
                    throw e2;
                }
            }
        }
    }

    private static long get64(ElfByteChannel elfByteChannel, ByteBuffer byteBuffer, long j2) throws IOException {
        read(elfByteChannel, byteBuffer, 8, j2);
        return byteBuffer.getLong();
    }

    private static String getSz(ElfByteChannel elfByteChannel, ByteBuffer byteBuffer, long j2) throws IOException {
        StringBuilder sb = new StringBuilder();
        while (true) {
            long j3 = 1 + j2;
            short u8Var = getu8(elfByteChannel, byteBuffer, j2);
            if (u8Var == 0) {
                return sb.toString();
            }
            sb.append((char) u8Var);
            j2 = j3;
        }
    }

    private static int getu16(ElfByteChannel elfByteChannel, ByteBuffer byteBuffer, long j2) throws IOException {
        read(elfByteChannel, byteBuffer, 2, j2);
        return byteBuffer.getShort() & 65535;
    }

    private static long getu32(ElfByteChannel elfByteChannel, ByteBuffer byteBuffer, long j2) throws IOException {
        read(elfByteChannel, byteBuffer, 4, j2);
        return ((long) byteBuffer.getInt()) & 4294967295L;
    }

    private static short getu8(ElfByteChannel elfByteChannel, ByteBuffer byteBuffer, long j2) throws IOException {
        read(elfByteChannel, byteBuffer, 1, j2);
        return (short) (byteBuffer.get() & 255);
    }

    private static void read(ElfByteChannel elfByteChannel, ByteBuffer byteBuffer, int i2, long j2) throws IOException {
        int read;
        byteBuffer.position(0);
        byteBuffer.limit(i2);
        while (byteBuffer.remaining() > 0 && (read = elfByteChannel.read(byteBuffer, j2)) != -1) {
            j2 += (long) read;
        }
        if (byteBuffer.remaining() <= 0) {
            byteBuffer.position(0);
            return;
        }
        throw new ElfError("ELF file truncated");
    }

    public static String[] extract_DT_NEEDED(ElfByteChannel elfByteChannel) throws IOException {
        if (elfByteChannel instanceof ElfFileChannel) {
            return extract_DT_NEEDED_with_retries((ElfFileChannel) elfByteChannel);
        }
        return extract_DT_NEEDED_no_retries(elfByteChannel);
    }
}
