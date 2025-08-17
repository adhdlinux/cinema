package com.google.android.exoplayer2.trackselection;

import android.util.Pair;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.RendererCapabilities;
import com.google.android.exoplayer2.RendererConfiguration;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.b2;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;

public abstract class MappingTrackSelector extends TrackSelector {

    /* renamed from: c  reason: collision with root package name */
    private MappedTrackInfo f27750c;

    public static final class MappedTrackInfo {

        /* renamed from: a  reason: collision with root package name */
        private final int f27751a;

        /* renamed from: b  reason: collision with root package name */
        private final String[] f27752b;

        /* renamed from: c  reason: collision with root package name */
        private final int[] f27753c;

        /* renamed from: d  reason: collision with root package name */
        private final TrackGroupArray[] f27754d;

        /* renamed from: e  reason: collision with root package name */
        private final int[] f27755e;

        /* renamed from: f  reason: collision with root package name */
        private final int[][][] f27756f;

        /* renamed from: g  reason: collision with root package name */
        private final TrackGroupArray f27757g;

        MappedTrackInfo(String[] strArr, int[] iArr, TrackGroupArray[] trackGroupArrayArr, int[] iArr2, int[][][] iArr3, TrackGroupArray trackGroupArray) {
            this.f27752b = strArr;
            this.f27753c = iArr;
            this.f27754d = trackGroupArrayArr;
            this.f27756f = iArr3;
            this.f27755e = iArr2;
            this.f27757g = trackGroupArray;
            this.f27751a = iArr.length;
        }

        public int a(int i2, int i3, boolean z2) {
            int i4 = this.f27754d[i2].b(i3).f26002b;
            int[] iArr = new int[i4];
            int i5 = 0;
            for (int i6 = 0; i6 < i4; i6++) {
                int g2 = g(i2, i3, i6);
                if (g2 == 4 || (z2 && g2 == 3)) {
                    iArr[i5] = i6;
                    i5++;
                }
            }
            return b(i2, i3, Arrays.copyOf(iArr, i5));
        }

        public int b(int i2, int i3, int[] iArr) {
            int i4 = 0;
            String str = null;
            boolean z2 = false;
            int i5 = 0;
            int i6 = 16;
            while (i4 < iArr.length) {
                String str2 = this.f27754d[i2].b(i3).c(iArr[i4]).f23071m;
                int i7 = i5 + 1;
                if (i5 == 0) {
                    str = str2;
                } else {
                    z2 |= !Util.c(str, str2);
                }
                i6 = Math.min(i6, b2.d(this.f27756f[i2][i3][i4]));
                i4++;
                i5 = i7;
            }
            if (z2) {
                return Math.min(i6, this.f27755e[i2]);
            }
            return i6;
        }

        public int c(int i2, int i3, int i4) {
            return this.f27756f[i2][i3][i4];
        }

        public int d() {
            return this.f27751a;
        }

        public int e(int i2) {
            return this.f27753c[i2];
        }

        public TrackGroupArray f(int i2) {
            return this.f27754d[i2];
        }

        public int g(int i2, int i3, int i4) {
            return b2.f(c(i2, i3, i4));
        }

        public TrackGroupArray h() {
            return this.f27757g;
        }
    }

    private static int k(RendererCapabilities[] rendererCapabilitiesArr, TrackGroup trackGroup, int[] iArr, boolean z2) throws ExoPlaybackException {
        boolean z3;
        int length = rendererCapabilitiesArr.length;
        int i2 = 0;
        boolean z4 = true;
        for (int i3 = 0; i3 < rendererCapabilitiesArr.length; i3++) {
            RendererCapabilities rendererCapabilities = rendererCapabilitiesArr[i3];
            int i4 = 0;
            for (int i5 = 0; i5 < trackGroup.f26002b; i5++) {
                i4 = Math.max(i4, b2.f(rendererCapabilities.c(trackGroup.c(i5))));
            }
            if (iArr[i3] == 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (i4 > i2 || (i4 == i2 && z2 && !z4 && z3)) {
                length = i3;
                z4 = z3;
                i2 = i4;
            }
        }
        return length;
    }

    private static int[] l(RendererCapabilities rendererCapabilities, TrackGroup trackGroup) throws ExoPlaybackException {
        int[] iArr = new int[trackGroup.f26002b];
        for (int i2 = 0; i2 < trackGroup.f26002b; i2++) {
            iArr[i2] = rendererCapabilities.c(trackGroup.c(i2));
        }
        return iArr;
    }

    private static int[] m(RendererCapabilities[] rendererCapabilitiesArr) throws ExoPlaybackException {
        int length = rendererCapabilitiesArr.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = rendererCapabilitiesArr[i2].p();
        }
        return iArr;
    }

    public final void f(Object obj) {
        this.f27750c = (MappedTrackInfo) obj;
    }

    public final TrackSelectorResult h(RendererCapabilities[] rendererCapabilitiesArr, TrackGroupArray trackGroupArray, MediaSource.MediaPeriodId mediaPeriodId, Timeline timeline) throws ExoPlaybackException {
        boolean z2;
        int[] iArr;
        RendererCapabilities[] rendererCapabilitiesArr2 = rendererCapabilitiesArr;
        TrackGroupArray trackGroupArray2 = trackGroupArray;
        int[] iArr2 = new int[(rendererCapabilitiesArr2.length + 1)];
        int length = rendererCapabilitiesArr2.length + 1;
        TrackGroup[][] trackGroupArr = new TrackGroup[length][];
        int[][][] iArr3 = new int[(rendererCapabilitiesArr2.length + 1)][][];
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = trackGroupArray2.f26010b;
            trackGroupArr[i2] = new TrackGroup[i3];
            iArr3[i2] = new int[i3][];
        }
        int[] m2 = m(rendererCapabilitiesArr);
        for (int i4 = 0; i4 < trackGroupArray2.f26010b; i4++) {
            TrackGroup b2 = trackGroupArray2.b(i4);
            if (b2.f26004d == 5) {
                z2 = true;
            } else {
                z2 = false;
            }
            int k2 = k(rendererCapabilitiesArr, b2, iArr2, z2);
            if (k2 == rendererCapabilitiesArr2.length) {
                iArr = new int[b2.f26002b];
            } else {
                iArr = l(rendererCapabilitiesArr2[k2], b2);
            }
            int i5 = iArr2[k2];
            trackGroupArr[k2][i5] = b2;
            iArr3[k2][i5] = iArr;
            iArr2[k2] = i5 + 1;
        }
        TrackGroupArray[] trackGroupArrayArr = new TrackGroupArray[rendererCapabilitiesArr2.length];
        String[] strArr = new String[rendererCapabilitiesArr2.length];
        int[] iArr4 = new int[rendererCapabilitiesArr2.length];
        for (int i6 = 0; i6 < rendererCapabilitiesArr2.length; i6++) {
            int i7 = iArr2[i6];
            trackGroupArrayArr[i6] = new TrackGroupArray((TrackGroup[]) Util.K0(trackGroupArr[i6], i7));
            iArr3[i6] = (int[][]) Util.K0(iArr3[i6], i7);
            strArr[i6] = rendererCapabilitiesArr2[i6].getName();
            iArr4[i6] = rendererCapabilitiesArr2[i6].d();
        }
        int[] iArr5 = m2;
        int[][][] iArr6 = iArr3;
        MappedTrackInfo mappedTrackInfo = new MappedTrackInfo(strArr, iArr4, trackGroupArrayArr, iArr5, iArr6, new TrackGroupArray((TrackGroup[]) Util.K0(trackGroupArr[rendererCapabilitiesArr2.length], iArr2[rendererCapabilitiesArr2.length])));
        Pair<RendererConfiguration[], ExoTrackSelection[]> n2 = n(mappedTrackInfo, iArr3, m2, mediaPeriodId, timeline);
        return new TrackSelectorResult((RendererConfiguration[]) n2.first, (ExoTrackSelection[]) n2.second, TrackSelectionUtil.a(mappedTrackInfo, (TrackSelection[]) n2.second), mappedTrackInfo);
    }

    /* access modifiers changed from: protected */
    public abstract Pair<RendererConfiguration[], ExoTrackSelection[]> n(MappedTrackInfo mappedTrackInfo, int[][][] iArr, int[] iArr2, MediaSource.MediaPeriodId mediaPeriodId, Timeline timeline) throws ExoPlaybackException;
}
