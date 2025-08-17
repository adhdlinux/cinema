package androidx.media3.exoplayer.dash;

import androidx.media3.common.Format;
import androidx.media3.datasource.TransferListener;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.dash.PlayerEmsgHandler;
import androidx.media3.exoplayer.dash.manifest.DashManifest;
import androidx.media3.exoplayer.source.chunk.ChunkSource;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;
import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import androidx.media3.exoplayer.upstream.LoaderErrorThrower;
import androidx.media3.extractor.text.SubtitleParser;
import java.util.List;

public interface DashChunkSource extends ChunkSource {

    public interface Factory {
        Factory a(SubtitleParser.Factory factory);

        Factory b(boolean z2);

        Format c(Format format);

        DashChunkSource d(LoaderErrorThrower loaderErrorThrower, DashManifest dashManifest, BaseUrlExclusionList baseUrlExclusionList, int i2, int[] iArr, ExoTrackSelection exoTrackSelection, int i3, long j2, boolean z2, List<Format> list, PlayerEmsgHandler.PlayerTrackEmsgHandler playerTrackEmsgHandler, TransferListener transferListener, PlayerId playerId, CmcdConfiguration cmcdConfiguration);
    }

    void b(DashManifest dashManifest, int i2);

    void i(ExoTrackSelection exoTrackSelection);
}
