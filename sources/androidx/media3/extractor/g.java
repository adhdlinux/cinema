package androidx.media3.extractor;

import androidx.media3.common.DataReader;
import androidx.media3.common.util.ParsableByteArray;
import java.io.IOException;

public final /* synthetic */ class g {
    public static int a(TrackOutput trackOutput, DataReader dataReader, int i2, boolean z2) throws IOException {
        return trackOutput.e(dataReader, i2, z2, 0);
    }

    public static void b(TrackOutput trackOutput, ParsableByteArray parsableByteArray, int i2) {
        trackOutput.a(parsableByteArray, i2, 0);
    }
}
