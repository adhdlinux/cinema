package androidx.media3.exoplayer.trackselection;

import android.util.Pair;
import androidx.media3.common.Timeline;
import androidx.media3.common.TrackGroup;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.ExoPlaybackException;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.exoplayer.RendererConfiguration;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.TrackGroupArray;
import e.x;
import java.util.Arrays;

public abstract class MappingTrackSelector extends TrackSelector {

    /* renamed from: c  reason: collision with root package name */
    private MappedTrackInfo f7462c;

    public static final class MappedTrackInfo {

        /* renamed from: a  reason: collision with root package name */
        private final int f7463a;

        /* renamed from: b  reason: collision with root package name */
        private final String[] f7464b;

        /* renamed from: c  reason: collision with root package name */
        private final int[] f7465c;

        /* renamed from: d  reason: collision with root package name */
        private final TrackGroupArray[] f7466d;

        /* renamed from: e  reason: collision with root package name */
        private final int[] f7467e;

        /* renamed from: f  reason: collision with root package name */
        private final int[][][] f7468f;

        /* renamed from: g  reason: collision with root package name */
        private final TrackGroupArray f7469g;

        MappedTrackInfo(String[] strArr, int[] iArr, TrackGroupArray[] trackGroupArrayArr, int[] iArr2, int[][][] iArr3, TrackGroupArray trackGroupArray) {
            this.f7464b = strArr;
            this.f7465c = iArr;
            this.f7466d = trackGroupArrayArr;
            this.f7468f = iArr3;
            this.f7467e = iArr2;
            this.f7469g = trackGroupArray;
            this.f7463a = iArr.length;
        }

        public int a(int i2, int i3, boolean z2) {
            int i4 = this.f7466d[i2].b(i3).f4390a;
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
                String str2 = this.f7466d[i2].b(i3).a(iArr[i4]).f4015n;
                int i7 = i5 + 1;
                if (i5 == 0) {
                    str = str2;
                } else {
                    z2 |= !Util.c(str, str2);
                }
                i6 = Math.min(i6, x.f(this.f7468f[i2][i3][i4]));
                i4++;
                i5 = i7;
            }
            if (z2) {
                return Math.min(i6, this.f7467e[i2]);
            }
            return i6;
        }

        public int c(int i2, int i3, int i4) {
            return this.f7468f[i2][i3][i4];
        }

        public int d() {
            return this.f7463a;
        }

        public int e(int i2) {
            return this.f7465c[i2];
        }

        public TrackGroupArray f(int i2) {
            return this.f7466d[i2];
        }

        public int g(int i2, int i3, int i4) {
            return x.i(c(i2, i3, i4));
        }

        public TrackGroupArray h() {
            return this.f7469g;
        }
    }

    private static int n(RendererCapabilities[] rendererCapabilitiesArr, TrackGroup trackGroup, int[] iArr, boolean z2) throws ExoPlaybackException {
        boolean z3;
        int length = rendererCapabilitiesArr.length;
        int i2 = 0;
        boolean z4 = true;
        for (int i3 = 0; i3 < rendererCapabilitiesArr.length; i3++) {
            RendererCapabilities rendererCapabilities = rendererCapabilitiesArr[i3];
            int i4 = 0;
            for (int i5 = 0; i5 < trackGroup.f4390a; i5++) {
                i4 = Math.max(i4, x.i(rendererCapabilities.c(trackGroup.a(i5))));
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

    private static int[] o(RendererCapabilities rendererCapabilities, TrackGroup trackGroup) throws ExoPlaybackException {
        int[] iArr = new int[trackGroup.f4390a];
        for (int i2 = 0; i2 < trackGroup.f4390a; i2++) {
            iArr[i2] = rendererCapabilities.c(trackGroup.a(i2));
        }
        return iArr;
    }

    private static int[] p(RendererCapabilities[] rendererCapabilitiesArr) throws ExoPlaybackException {
        int length = rendererCapabilitiesArr.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = rendererCapabilitiesArr[i2].p();
        }
        return iArr;
    }

    public final void i(Object obj) {
        this.f7462c = (MappedTrackInfo) obj;
    }

    public final TrackSelectorResult k(RendererCapabilities[] rendererCapabilitiesArr, TrackGroupArray trackGroupArray, MediaSource.MediaPeriodId mediaPeriodId, Timeline timeline) throws ExoPlaybackException {
        boolean z2;
        int[] iArr;
        RendererCapabilities[] rendererCapabilitiesArr2 = rendererCapabilitiesArr;
        TrackGroupArray trackGroupArray2 = trackGroupArray;
        int[] iArr2 = new int[(rendererCapabilitiesArr2.length + 1)];
        int length = rendererCapabilitiesArr2.length + 1;
        TrackGroup[][] trackGroupArr = new TrackGroup[length][];
        int[][][] iArr3 = new int[(rendererCapabilitiesArr2.length + 1)][][];
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = trackGroupArray2.f7178a;
            trackGroupArr[i2] = new TrackGroup[i3];
            iArr3[i2] = new int[i3][];
        }
        int[] p2 = p(rendererCapabilitiesArr);
        for (int i4 = 0; i4 < trackGroupArray2.f7178a; i4++) {
            TrackGroup b2 = trackGroupArray2.b(i4);
            if (b2.f4392c == 5) {
                z2 = true;
            } else {
                z2 = false;
            }
            int n2 = n(rendererCapabilitiesArr, b2, iArr2, z2);
            if (n2 == rendererCapabilitiesArr2.length) {
                iArr = new int[b2.f4390a];
            } else {
                iArr = o(rendererCapabilitiesArr2[n2], b2);
            }
            int i5 = iArr2[n2];
            trackGroupArr[n2][i5] = b2;
            iArr3[n2][i5] = iArr;
            iArr2[n2] = i5 + 1;
        }
        TrackGroupArray[] trackGroupArrayArr = new TrackGroupArray[rendererCapabilitiesArr2.length];
        String[] strArr = new String[rendererCapabilitiesArr2.length];
        int[] iArr4 = new int[rendererCapabilitiesArr2.length];
        for (int i6 = 0; i6 < rendererCapabilitiesArr2.length; i6++) {
            int i7 = iArr2[i6];
            trackGroupArrayArr[i6] = new TrackGroupArray((TrackGroup[]) Util.U0(trackGroupArr[i6], i7));
            iArr3[i6] = (int[][]) Util.U0(iArr3[i6], i7);
            strArr[i6] = rendererCapabilitiesArr2[i6].getName();
            iArr4[i6] = rendererCapabilitiesArr2[i6].d();
        }
        int[] iArr5 = p2;
        int[][][] iArr6 = iArr3;
        MappedTrackInfo mappedTrackInfo = new MappedTrackInfo(strArr, iArr4, trackGroupArrayArr, iArr5, iArr6, new TrackGroupArray((TrackGroup[]) Util.U0(trackGroupArr[rendererCapabilitiesArr2.length], iArr2[rendererCapabilitiesArr2.length])));
        Pair<RendererConfiguration[], ExoTrackSelection[]> q2 = q(mappedTrackInfo, iArr3, p2, mediaPeriodId, timeline);
        return new TrackSelectorResult((RendererConfiguration[]) q2.first, (ExoTrackSelection[]) q2.second, TrackSelectionUtil.a(mappedTrackInfo, (TrackSelection[]) q2.second), mappedTrackInfo);
    }

    /* access modifiers changed from: protected */
    public abstract Pair<RendererConfiguration[], ExoTrackSelection[]> q(MappedTrackInfo mappedTrackInfo, int[][][] iArr, int[] iArr2, MediaSource.MediaPeriodId mediaPeriodId, Timeline timeline) throws ExoPlaybackException;
}
