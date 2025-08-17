package com.google.android.exoplayer2.extractor.ts;

import android.util.SparseArray;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import java.util.Collections;
import java.util.List;

public interface TsPayloadReader {

    public static final class DvbSubtitleInfo {

        /* renamed from: a  reason: collision with root package name */
        public final String f25117a;

        /* renamed from: b  reason: collision with root package name */
        public final int f25118b;

        /* renamed from: c  reason: collision with root package name */
        public final byte[] f25119c;

        public DvbSubtitleInfo(String str, int i2, byte[] bArr) {
            this.f25117a = str;
            this.f25118b = i2;
            this.f25119c = bArr;
        }
    }

    public static final class EsInfo {

        /* renamed from: a  reason: collision with root package name */
        public final int f25120a;

        /* renamed from: b  reason: collision with root package name */
        public final String f25121b;

        /* renamed from: c  reason: collision with root package name */
        public final List<DvbSubtitleInfo> f25122c;

        /* renamed from: d  reason: collision with root package name */
        public final byte[] f25123d;

        public EsInfo(int i2, String str, List<DvbSubtitleInfo> list, byte[] bArr) {
            List<DvbSubtitleInfo> list2;
            this.f25120a = i2;
            this.f25121b = str;
            if (list == null) {
                list2 = Collections.emptyList();
            } else {
                list2 = Collections.unmodifiableList(list);
            }
            this.f25122c = list2;
            this.f25123d = bArr;
        }
    }

    public interface Factory {
        SparseArray<TsPayloadReader> a();

        TsPayloadReader b(int i2, EsInfo esInfo);
    }

    public static final class TrackIdGenerator {

        /* renamed from: a  reason: collision with root package name */
        private final String f25124a;

        /* renamed from: b  reason: collision with root package name */
        private final int f25125b;

        /* renamed from: c  reason: collision with root package name */
        private final int f25126c;

        /* renamed from: d  reason: collision with root package name */
        private int f25127d;

        /* renamed from: e  reason: collision with root package name */
        private String f25128e;

        public TrackIdGenerator(int i2, int i3) {
            this(Integer.MIN_VALUE, i2, i3);
        }

        private void d() {
            if (this.f25127d == Integer.MIN_VALUE) {
                throw new IllegalStateException("generateNewId() must be called before retrieving ids.");
            }
        }

        public void a() {
            int i2;
            int i3 = this.f25127d;
            if (i3 == Integer.MIN_VALUE) {
                i2 = this.f25125b;
            } else {
                i2 = i3 + this.f25126c;
            }
            this.f25127d = i2;
            this.f25128e = this.f25124a + this.f25127d;
        }

        public String b() {
            d();
            return this.f25128e;
        }

        public int c() {
            d();
            return this.f25127d;
        }

        public TrackIdGenerator(int i2, int i3, int i4) {
            String str;
            if (i2 != Integer.MIN_VALUE) {
                str = i2 + "/";
            } else {
                str = "";
            }
            this.f25124a = str;
            this.f25125b = i3;
            this.f25126c = i4;
            this.f25127d = Integer.MIN_VALUE;
            this.f25128e = "";
        }
    }

    void a();

    void b(TimestampAdjuster timestampAdjuster, ExtractorOutput extractorOutput, TrackIdGenerator trackIdGenerator);

    void c(ParsableByteArray parsableByteArray, int i2) throws ParserException;
}
