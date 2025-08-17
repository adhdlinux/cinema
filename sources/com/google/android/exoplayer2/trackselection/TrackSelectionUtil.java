package com.google.android.exoplayer2.trackselection;

import android.os.SystemClock;
import com.google.android.exoplayer2.Tracks;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.MappingTrackSelector;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.common.collect.ImmutableList;
import java.util.Arrays;
import java.util.List;

public final class TrackSelectionUtil {
    private TrackSelectionUtil() {
    }

    public static Tracks a(MappingTrackSelector.MappedTrackInfo mappedTrackInfo, TrackSelection[] trackSelectionArr) {
        ImmutableList immutableList;
        List[] listArr = new List[trackSelectionArr.length];
        for (int i2 = 0; i2 < trackSelectionArr.length; i2++) {
            TrackSelection trackSelection = trackSelectionArr[i2];
            if (trackSelection != null) {
                immutableList = ImmutableList.s(trackSelection);
            } else {
                immutableList = ImmutableList.r();
            }
            listArr[i2] = immutableList;
        }
        return b(mappedTrackInfo, listArr);
    }

    public static Tracks b(MappingTrackSelector.MappedTrackInfo mappedTrackInfo, List<? extends TrackSelection>[] listArr) {
        boolean z2;
        boolean z3;
        MappingTrackSelector.MappedTrackInfo mappedTrackInfo2 = mappedTrackInfo;
        ImmutableList.Builder builder = new ImmutableList.Builder();
        for (int i2 = 0; i2 < mappedTrackInfo.d(); i2++) {
            TrackGroupArray f2 = mappedTrackInfo2.f(i2);
            List<? extends TrackSelection> list = listArr[i2];
            for (int i3 = 0; i3 < f2.f26010b; i3++) {
                TrackGroup b2 = f2.b(i3);
                if (mappedTrackInfo2.a(i2, i3, false) != 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                int i4 = b2.f26002b;
                int[] iArr = new int[i4];
                boolean[] zArr = new boolean[i4];
                for (int i5 = 0; i5 < b2.f26002b; i5++) {
                    iArr[i5] = mappedTrackInfo2.g(i2, i3, i5);
                    int i6 = 0;
                    while (true) {
                        if (i6 >= list.size()) {
                            z3 = false;
                            break;
                        }
                        TrackSelection trackSelection = (TrackSelection) list.get(i6);
                        if (trackSelection.h().equals(b2) && trackSelection.g(i5) != -1) {
                            z3 = true;
                            break;
                        }
                        i6++;
                    }
                    zArr[i5] = z3;
                }
                builder.d(new Tracks.Group(b2, z2, iArr, zArr));
            }
        }
        TrackGroupArray h2 = mappedTrackInfo.h();
        for (int i7 = 0; i7 < h2.f26010b; i7++) {
            TrackGroup b3 = h2.b(i7);
            int[] iArr2 = new int[b3.f26002b];
            Arrays.fill(iArr2, 0);
            builder.d(new Tracks.Group(b3, false, iArr2, new boolean[b3.f26002b]));
        }
        return new Tracks(builder.k());
    }

    public static LoadErrorHandlingPolicy.FallbackOptions c(ExoTrackSelection exoTrackSelection) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        int length = exoTrackSelection.length();
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            if (exoTrackSelection.p(i3, elapsedRealtime)) {
                i2++;
            }
        }
        return new LoadErrorHandlingPolicy.FallbackOptions(1, 0, length, i2);
    }
}
