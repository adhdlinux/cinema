package com.movie.data.model.sstream;

public class SSModel {

    public class HlsConfig {
        public int maxBufferLength;
        public long maxBufferSize;

        public HlsConfig() {
        }
    }

    public static class Player {
        public String name;
        public ServerStatus status;
        public PlayerType type;
        public String url;

        public String toString() {
            return "Player{url='" + this.url + '\'' + ", status=" + this.status + '}';
        }
    }

    public enum PlayerType {
        PlayerJS
    }

    public class Playerjs {
        public Object file;
        public HlsConfig hlsconfig;
        public String subtitle;

        public Playerjs() {
        }

        public String toString() {
            return "Playerjs{hlsconfig=" + this.hlsconfig + ", subtitle='" + this.subtitle + '\'' + ", file=" + this.file + '}';
        }
    }

    public enum ServerStatus {
        SUCCESS,
        WARNING,
        UNKNOW
    }
}
