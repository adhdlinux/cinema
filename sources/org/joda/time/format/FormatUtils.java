package org.joda.time.format;

import com.google.android.gms.cast.framework.media.NotificationOptions;
import java.io.IOException;
import java.io.Writer;

public class FormatUtils {
    private static final double LOG_10 = Math.log(10.0d);

    private FormatUtils() {
    }

    public static void appendPaddedInteger(StringBuffer stringBuffer, int i2, int i3) {
        try {
            appendPaddedInteger((Appendable) stringBuffer, i2, i3);
        } catch (IOException unused) {
        }
    }

    public static void appendUnpaddedInteger(StringBuffer stringBuffer, int i2) {
        try {
            appendUnpaddedInteger((Appendable) stringBuffer, i2);
        } catch (IOException unused) {
        }
    }

    public static int calculateDigitCount(long j2) {
        if (j2 < 0) {
            if (j2 != Long.MIN_VALUE) {
                return calculateDigitCount(-j2) + 1;
            }
            return 20;
        } else if (j2 < 10) {
            return 1;
        } else {
            if (j2 < 100) {
                return 2;
            }
            if (j2 < 1000) {
                return 3;
            }
            if (j2 < NotificationOptions.SKIP_STEP_TEN_SECONDS_IN_MS) {
                return 4;
            }
            return 1 + ((int) (Math.log((double) j2) / LOG_10));
        }
    }

    static String createErrorMessage(String str, int i2) {
        String str2;
        int i3 = i2 + 32;
        if (str.length() <= i3 + 3) {
            str2 = str;
        } else {
            str2 = str.substring(0, i3).concat("...");
        }
        if (i2 <= 0) {
            return "Invalid format: \"" + str2 + '\"';
        } else if (i2 >= str.length()) {
            return "Invalid format: \"" + str2 + "\" is too short";
        } else {
            return "Invalid format: \"" + str2 + "\" is malformed at \"" + str2.substring(i2) + '\"';
        }
    }

    static int parseTwoDigits(CharSequence charSequence, int i2) {
        int charAt = charSequence.charAt(i2) - '0';
        return (((charAt << 3) + (charAt << 1)) + charSequence.charAt(i2 + 1)) - 48;
    }

    public static void writePaddedInteger(Writer writer, int i2, int i3) throws IOException {
        if (i2 < 0) {
            writer.write(45);
            if (i2 != Integer.MIN_VALUE) {
                i2 = -i2;
            } else {
                while (i3 > 10) {
                    writer.write(48);
                    i3--;
                }
                writer.write("2147483648");
                return;
            }
        }
        if (i2 < 10) {
            while (i3 > 1) {
                writer.write(48);
                i3--;
            }
            writer.write(i2 + 48);
        } else if (i2 < 100) {
            while (i3 > 2) {
                writer.write(48);
                i3--;
            }
            int i4 = ((i2 + 1) * 13421772) >> 27;
            writer.write(i4 + 48);
            writer.write(((i2 - (i4 << 3)) - (i4 << 1)) + 48);
        } else {
            int log = i2 < 1000 ? 3 : i2 < 10000 ? 4 : ((int) (Math.log((double) i2) / LOG_10)) + 1;
            while (i3 > log) {
                writer.write(48);
                i3--;
            }
            writer.write(Integer.toString(i2));
        }
    }

    public static void writeUnpaddedInteger(Writer writer, int i2) throws IOException {
        if (i2 < 0) {
            writer.write(45);
            if (i2 != Integer.MIN_VALUE) {
                i2 = -i2;
            } else {
                writer.write("2147483648");
                return;
            }
        }
        if (i2 < 10) {
            writer.write(i2 + 48);
        } else if (i2 < 100) {
            int i3 = ((i2 + 1) * 13421772) >> 27;
            writer.write(i3 + 48);
            writer.write(((i2 - (i3 << 3)) - (i3 << 1)) + 48);
        } else {
            writer.write(Integer.toString(i2));
        }
    }

    public static void appendPaddedInteger(Appendable appendable, int i2, int i3) throws IOException {
        if (i2 < 0) {
            appendable.append('-');
            if (i2 != Integer.MIN_VALUE) {
                i2 = -i2;
            } else {
                while (i3 > 10) {
                    appendable.append('0');
                    i3--;
                }
                appendable.append("2147483648");
                return;
            }
        }
        if (i2 < 10) {
            while (i3 > 1) {
                appendable.append('0');
                i3--;
            }
            appendable.append((char) (i2 + 48));
        } else if (i2 < 100) {
            while (i3 > 2) {
                appendable.append('0');
                i3--;
            }
            int i4 = ((i2 + 1) * 13421772) >> 27;
            appendable.append((char) (i4 + 48));
            appendable.append((char) (((i2 - (i4 << 3)) - (i4 << 1)) + 48));
        } else {
            int log = i2 < 1000 ? 3 : i2 < 10000 ? 4 : ((int) (Math.log((double) i2) / LOG_10)) + 1;
            while (i3 > log) {
                appendable.append('0');
                i3--;
            }
            appendable.append(Integer.toString(i2));
        }
    }

    public static void appendUnpaddedInteger(Appendable appendable, int i2) throws IOException {
        if (i2 < 0) {
            appendable.append('-');
            if (i2 != Integer.MIN_VALUE) {
                i2 = -i2;
            } else {
                appendable.append("2147483648");
                return;
            }
        }
        if (i2 < 10) {
            appendable.append((char) (i2 + 48));
        } else if (i2 < 100) {
            int i3 = ((i2 + 1) * 13421772) >> 27;
            appendable.append((char) (i3 + 48));
            appendable.append((char) (((i2 - (i3 << 3)) - (i3 << 1)) + 48));
        } else {
            appendable.append(Integer.toString(i2));
        }
    }

    public static void writeUnpaddedInteger(Writer writer, long j2) throws IOException {
        int i2 = (int) j2;
        if (((long) i2) == j2) {
            writeUnpaddedInteger(writer, i2);
        } else {
            writer.write(Long.toString(j2));
        }
    }

    public static void appendUnpaddedInteger(StringBuffer stringBuffer, long j2) {
        try {
            appendUnpaddedInteger((Appendable) stringBuffer, j2);
        } catch (IOException unused) {
        }
    }

    public static void appendUnpaddedInteger(Appendable appendable, long j2) throws IOException {
        int i2 = (int) j2;
        if (((long) i2) == j2) {
            appendUnpaddedInteger(appendable, i2);
        } else {
            appendable.append(Long.toString(j2));
        }
    }

    public static void writePaddedInteger(Writer writer, long j2, int i2) throws IOException {
        int i3 = (int) j2;
        if (((long) i3) == j2) {
            writePaddedInteger(writer, i3, i2);
        } else if (i2 <= 19) {
            writer.write(Long.toString(j2));
        } else {
            if (j2 < 0) {
                writer.write(45);
                if (j2 != Long.MIN_VALUE) {
                    j2 = -j2;
                } else {
                    while (i2 > 19) {
                        writer.write(48);
                        i2--;
                    }
                    writer.write("9223372036854775808");
                    return;
                }
            }
            int log = ((int) (Math.log((double) j2) / LOG_10)) + 1;
            while (i2 > log) {
                writer.write(48);
                i2--;
            }
            writer.write(Long.toString(j2));
        }
    }

    public static void appendPaddedInteger(StringBuffer stringBuffer, long j2, int i2) {
        try {
            appendPaddedInteger((Appendable) stringBuffer, j2, i2);
        } catch (IOException unused) {
        }
    }

    public static void appendPaddedInteger(Appendable appendable, long j2, int i2) throws IOException {
        int i3 = (int) j2;
        if (((long) i3) == j2) {
            appendPaddedInteger(appendable, i3, i2);
        } else if (i2 <= 19) {
            appendable.append(Long.toString(j2));
        } else {
            if (j2 < 0) {
                appendable.append('-');
                if (j2 != Long.MIN_VALUE) {
                    j2 = -j2;
                } else {
                    while (i2 > 19) {
                        appendable.append('0');
                        i2--;
                    }
                    appendable.append("9223372036854775808");
                    return;
                }
            }
            int log = ((int) (Math.log((double) j2) / LOG_10)) + 1;
            while (i2 > log) {
                appendable.append('0');
                i2--;
            }
            appendable.append(Long.toString(j2));
        }
    }
}
