package b1;

import android.content.Context;
import android.os.Handler;
import androidx.media3.exoplayer.Renderer;
import androidx.media3.exoplayer.RenderersFactory;
import androidx.media3.exoplayer.audio.AudioRendererEventListener;
import androidx.media3.exoplayer.metadata.MetadataOutput;
import androidx.media3.exoplayer.text.TextOutput;
import androidx.media3.exoplayer.video.VideoRendererEventListener;
import com.movie.ui.activity.player.PlayerActivity;

public final /* synthetic */ class v implements RenderersFactory {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f29307a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PlayerActivity f29308b;

    public /* synthetic */ v(Context context, PlayerActivity playerActivity) {
        this.f29307a = context;
        this.f29308b = playerActivity;
    }

    public final Renderer[] a(Handler handler, VideoRendererEventListener videoRendererEventListener, AudioRendererEventListener audioRendererEventListener, TextOutput textOutput, MetadataOutput metadataOutput) {
        return PlayerActivity.z0(this.f29307a, this.f29308b, handler, videoRendererEventListener, audioRendererEventListener, textOutput, metadataOutput);
    }
}
