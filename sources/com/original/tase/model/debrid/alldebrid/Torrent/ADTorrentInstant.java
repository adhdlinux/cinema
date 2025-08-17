package com.original.tase.model.debrid.alldebrid.Torrent;

import java.util.List;

public class ADTorrentInstant {
    private DataBean data;
    private String status;

    public static class DataBean {
        private List<MagnetsBean> magnets;

        public static class MagnetsBean {
            private String hash;
            private boolean instant;
            private String magnet;

            public String getHash() {
                return this.hash;
            }

            public String getMagnet() {
                return this.magnet;
            }

            public boolean isInstant() {
                return this.instant;
            }

            public void setHash(String str) {
                this.hash = str;
            }

            public void setInstant(boolean z2) {
                this.instant = z2;
            }

            public void setMagnet(String str) {
                this.magnet = str;
            }
        }

        public List<MagnetsBean> getMagnets() {
            return this.magnets;
        }

        public void setMagnets(List<MagnetsBean> list) {
            this.magnets = list;
        }
    }

    public DataBean getData() {
        return this.data;
    }

    public String getStatus() {
        return this.status;
    }

    public void setData(DataBean dataBean) {
        this.data = dataBean;
    }

    public void setStatus(String str) {
        this.status = str;
    }
}
