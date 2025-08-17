package com.google.android.exoplayer2.source.dash;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.analytics.PlayerId;
import com.google.android.exoplayer2.source.chunk.ChunkSource;
import com.google.android.exoplayer2.source.dash.PlayerEmsgHandler;
import com.google.android.exoplayer2.source.dash.manifest.DashManifest;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.upstream.LoaderErrorThrower;
import com.google.android.exoplayer2.upstream.TransferListener;
import java.util.List;

public interface DashChunkSource extends ChunkSource {

    public interface Factory {
        DashChunkSource a(LoaderErrorThrower loaderErrorThrower, DashManifest dashManifest, BaseUrlExclusionList baseUrlExclusionList, int i2, int[] iArr, ExoTrackSelection exoTrackSelection, int i3, long j2, boolean z2, List<Format> list, PlayerEmsgHandler.PlayerTrackEmsgHandler playerTrackEmsgHandler, TransferListener transferListener, PlayerId playerId);
    }

    void b(ExoTrackSelection exoTrackSelection);

    void i(DashManifest dashManifest, int i2);
}
