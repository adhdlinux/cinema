package com.startapp.sdk.ads.video.player;

public interface VideoPlayerInterface {

    public enum VideoPlayerErrorType {
        UNKNOWN,
        SERVER_DIED,
        BUFFERING_TIMEOUT,
        PLAYER_CREATION
    }

    public interface a {
    }

    public interface b {
    }

    public interface c {
    }

    public interface d {
    }

    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public VideoPlayerErrorType f36128a;

        /* renamed from: b  reason: collision with root package name */
        public String f36129b;

        /* renamed from: c  reason: collision with root package name */
        public int f36130c;

        public e(VideoPlayerErrorType videoPlayerErrorType, String str, int i2) {
            this.f36128a = videoPlayerErrorType;
            this.f36129b = str;
            this.f36130c = i2;
        }
    }
}
