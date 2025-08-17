package bolts;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.List;

public class AggregateException extends Exception {

    /* renamed from: b  reason: collision with root package name */
    private List<Throwable> f12776b;

    public void printStackTrace(PrintStream printStream) {
        super.printStackTrace(printStream);
        int i2 = -1;
        for (Throwable printStackTrace : this.f12776b) {
            printStream.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
            printStream.append("  Inner throwable #");
            i2++;
            printStream.append(Integer.toString(i2));
            printStream.append(": ");
            printStackTrace.printStackTrace(printStream);
            printStream.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
        }
    }

    public void printStackTrace(PrintWriter printWriter) {
        super.printStackTrace(printWriter);
        int i2 = -1;
        for (Throwable printStackTrace : this.f12776b) {
            printWriter.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
            printWriter.append("  Inner throwable #");
            i2++;
            printWriter.append(Integer.toString(i2));
            printWriter.append(": ");
            printStackTrace.printStackTrace(printWriter);
            printWriter.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
        }
    }
}
