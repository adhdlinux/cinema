package com.google.android.exoplayer2.source.smoothstreaming;

import com.google.android.exoplayer2.source.chunk.ChunkSource;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.upstream.LoaderErrorThrower;
import com.google.android.exoplayer2.upstream.TransferListener;

public interface SsChunkSource extends ChunkSource {

    public interface Factory {
        SsChunkSource a(LoaderErrorThrower loaderErrorThrower, SsManifest ssManifest, int i2, ExoTrackSelection exoTrackSelection, TransferListener transferListener);
    }

    void b(ExoTrackSelection exoTrackSelection);

    void e(SsManifest ssManifest);
}
