package androidx.media3.extractor.ts;

import android.util.SparseArray;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.TimestampAdjuster;
import androidx.media3.extractor.ExtractorOutput;
import java.util.Collections;
import java.util.List;

public interface TsPayloadReader {

    public static final class DvbSubtitleInfo {

        /* renamed from: a  reason: collision with root package name */
        public final String f9540a;

        /* renamed from: b  reason: collision with root package name */
        public final int f9541b;

        /* renamed from: c  reason: collision with root package name */
        public final byte[] f9542c;

        public DvbSubtitleInfo(String str, int i2, byte[] bArr) {
            this.f9540a = str;
            this.f9541b = i2;
            this.f9542c = bArr;
        }
    }

    public static final class EsInfo {

        /* renamed from: a  reason: collision with root package name */
        public final int f9543a;

        /* renamed from: b  reason: collision with root package name */
        public final String f9544b;

        /* renamed from: c  reason: collision with root package name */
        public final int f9545c;

        /* renamed from: d  reason: collision with root package name */
        public final List<DvbSubtitleInfo> f9546d;

        /* renamed from: e  reason: collision with root package name */
        public final byte[] f9547e;

        public EsInfo(int i2, String str, int i3, List<DvbSubtitleInfo> list, byte[] bArr) {
            List<DvbSubtitleInfo> list2;
            this.f9543a = i2;
            this.f9544b = str;
            this.f9545c = i3;
            if (list == null) {
                list2 = Collections.emptyList();
            } else {
                list2 = Collections.unmodifiableList(list);
            }
            this.f9546d = list2;
            this.f9547e = bArr;
        }

        public int a() {
            int i2 = this.f9545c;
            if (i2 != 2) {
                return i2 != 3 ? 0 : 512;
            }
            return 2048;
        }
    }

    public interface Factory {
        SparseArray<TsPayloadReader> a();

        TsPayloadReader b(int i2, EsInfo esInfo);
    }

    public static final class TrackIdGenerator {

        /* renamed from: a  reason: collision with root package name */
        private final String f9548a;

        /* renamed from: b  reason: collision with root package name */
        private final int f9549b;

        /* renamed from: c  reason: collision with root package name */
        private final int f9550c;

        /* renamed from: d  reason: collision with root package name */
        private int f9551d;

        /* renamed from: e  reason: collision with root package name */
        private String f9552e;

        public TrackIdGenerator(int i2, int i3) {
            this(Integer.MIN_VALUE, i2, i3);
        }

        private void d() {
            if (this.f9551d == Integer.MIN_VALUE) {
                throw new IllegalStateException("generateNewId() must be called before retrieving ids.");
            }
        }

        public void a() {
            int i2;
            int i3 = this.f9551d;
            if (i3 == Integer.MIN_VALUE) {
                i2 = this.f9549b;
            } else {
                i2 = i3 + this.f9550c;
            }
            this.f9551d = i2;
            this.f9552e = this.f9548a + this.f9551d;
        }

        public String b() {
            d();
            return this.f9552e;
        }

        public int c() {
            d();
            return this.f9551d;
        }

        public TrackIdGenerator(int i2, int i3, int i4) {
            String str;
            if (i2 != Integer.MIN_VALUE) {
                str = i2 + "/";
            } else {
                str = "";
            }
            this.f9548a = str;
            this.f9549b = i3;
            this.f9550c = i4;
            this.f9551d = Integer.MIN_VALUE;
            this.f9552e = "";
        }
    }

    void a();

    void b(ParsableByteArray parsableByteArray, int i2) throws ParserException;

    void c(TimestampAdjuster timestampAdjuster, ExtractorOutput extractorOutput, TrackIdGenerator trackIdGenerator);
}
