package com.startapp.sdk.ads.video.player;

import android.media.MediaPlayer;
import android.widget.VideoView;
import com.startapp.e6;
import com.startapp.h5;
import com.startapp.o6;
import com.startapp.sdk.ads.video.VideoMode;
import com.startapp.sdk.ads.video.player.VideoPlayerInterface;
import com.startapp.w5;
import com.startapp.x5;
import com.startapp.y5;
import com.startapp.y8;
import com.startapp.z5;

public class NativeVideoPlayer extends e6 implements MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener {

    /* renamed from: f  reason: collision with root package name */
    public MediaPlayer f36112f;

    /* renamed from: g  reason: collision with root package name */
    public final VideoView f36113g;

    public enum MediaErrorExtra {
        MEDIA_ERROR_IO,
        MEDIA_ERROR_MALFORMED,
        MEDIA_ERROR_UNSUPPORTED,
        MEDIA_ERROR_TIMED_OUT
    }

    public enum MediaErrorType {
        MEDIA_ERROR_UNKNOWN,
        MEDIA_ERROR_SERVER_DIED
    }

    public class a implements MediaPlayer.OnBufferingUpdateListener {
        public a() {
        }

        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i2) {
            VideoPlayerInterface.a aVar = NativeVideoPlayer.this.f34448e;
            if (aVar != null) {
                ((y5) aVar).a(i2);
            }
        }
    }

    public NativeVideoPlayer(VideoView videoView) {
        this.f36113g = videoView;
        videoView.setOnPreparedListener(this);
        videoView.setOnCompletionListener(this);
        videoView.setOnErrorListener(this);
    }

    public void a(String str) {
        this.f34444a = str;
        if (str != null) {
            try {
                this.f36113g.setVideoPath(str);
            } catch (Throwable th) {
                y8.a(this.f36113g.getContext(), th);
                onError(this.f36112f, 1, 0);
            }
        }
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        VideoPlayerInterface.b bVar = this.f34447d;
        if (bVar != null) {
            x5 x5Var = (x5) bVar;
            if (!x5Var.f36912a.I()) {
                x5Var.f36912a.a(VideoMode.VideoFinishedReason.COMPLETE);
            }
            VideoPlayerInterface videoPlayerInterface = x5Var.f36912a.M;
            if (videoPlayerInterface != null) {
                ((NativeVideoPlayer) videoPlayerInterface).f36113g.stopPlayback();
            }
        }
    }

    public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
        int i4;
        MediaErrorType mediaErrorType;
        VideoPlayerInterface.VideoPlayerErrorType videoPlayerErrorType;
        MediaErrorExtra mediaErrorExtra;
        if (this.f34446c == null) {
            return false;
        }
        if (mediaPlayer != null) {
            i4 = mediaPlayer.getCurrentPosition();
        } else {
            i4 = -1;
        }
        VideoPlayerInterface.c cVar = this.f34446c;
        if (i2 == 100) {
            mediaErrorType = MediaErrorType.MEDIA_ERROR_SERVER_DIED;
        } else {
            mediaErrorType = MediaErrorType.MEDIA_ERROR_UNKNOWN;
        }
        if (mediaErrorType == MediaErrorType.MEDIA_ERROR_SERVER_DIED) {
            videoPlayerErrorType = VideoPlayerInterface.VideoPlayerErrorType.SERVER_DIED;
        } else {
            videoPlayerErrorType = VideoPlayerInterface.VideoPlayerErrorType.UNKNOWN;
        }
        if (i3 == -1010) {
            mediaErrorExtra = MediaErrorExtra.MEDIA_ERROR_UNSUPPORTED;
        } else if (i3 == -1007) {
            mediaErrorExtra = MediaErrorExtra.MEDIA_ERROR_MALFORMED;
        } else if (i3 != -110) {
            mediaErrorExtra = MediaErrorExtra.MEDIA_ERROR_IO;
        } else {
            mediaErrorExtra = MediaErrorExtra.MEDIA_ERROR_TIMED_OUT;
        }
        String str = mediaErrorExtra.toString();
        VideoPlayerInterface.e eVar = new VideoPlayerInterface.e(videoPlayerErrorType, str, i4);
        z5 z5Var = (z5) cVar;
        VideoMode videoMode = z5Var.f36980a;
        if (videoMode.M != null) {
            videoMode.f36074h0 = false;
            if (!videoMode.f36073g0 || videoMode.f36077k0 > videoMode.f36078l0 || i4 <= 0 || !str.equals("MEDIA_ERROR_IO")) {
                z5Var.f36980a.a(eVar);
            } else {
                VideoMode videoMode2 = z5Var.f36980a;
                videoMode2.f36077k0++;
                videoMode2.O();
                VideoMode videoMode3 = z5Var.f36980a;
                ((NativeVideoPlayer) videoMode3.M).a(videoMode3.y().c());
                ((NativeVideoPlayer) z5Var.f36980a.M).f36113g.seekTo(eVar.f36130c);
            }
        }
        return true;
    }

    public void onPrepared(MediaPlayer mediaPlayer) {
        MediaPlayer mediaPlayer2;
        this.f36112f = mediaPlayer;
        VideoPlayerInterface.d dVar = this.f34445b;
        if (dVar != null) {
            w5 w5Var = (w5) dVar;
            VideoMode videoMode = w5Var.f36813a;
            videoMode.f36074h0 = true;
            if (videoMode.W && videoMode.X) {
                videoMode.B();
            }
            if (w5Var.f36813a.D()) {
                w5Var.f36813a.Q();
            }
        }
        if (o6.c(this.f34444a) && (mediaPlayer2 = this.f36112f) != null) {
            mediaPlayer2.setOnBufferingUpdateListener(new a());
        } else if (!o6.c(this.f34444a)) {
            h5.b.f34617a.f34615b = this.f34448e;
        }
    }
}
