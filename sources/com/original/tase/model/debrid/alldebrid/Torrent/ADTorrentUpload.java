package com.original.tase.model.debrid.alldebrid.Torrent;

import com.movie.data.model.TorrentObject;
import java.util.ArrayList;
import java.util.List;
import org.joda.time.DateTime;

public class ADTorrentUpload {
    private DataBean data;
    private String status;

    public static class DataBean {
        private List<MagnetsBean> magnets;

        public static class MagnetsBean implements TorrentObject.TorrentObjectConverter {
            private String hash;
            private int id;
            private String magnet;
            private String name;
            private boolean ready;
            private long size;

            public TorrentObject convert() {
                int i2;
                ArrayList arrayList = new ArrayList();
                TorrentObject torrentObject = new TorrentObject();
                torrentObject.setFiles(arrayList);
                torrentObject.setHash(getHash());
                torrentObject.setId(String.valueOf(getId()));
                torrentObject.setName(getName());
                String valueOf = String.valueOf(isReady());
                if (isReady()) {
                    i2 = 100;
                } else {
                    i2 = 0;
                }
                torrentObject.setStatusBean(new TorrentObject.StatusBean(valueOf, i2, 0, 0));
                torrentObject.setType(TorrentObject.Type.AD);
                torrentObject.setAddedTime(DateTime.now().toString());
                return torrentObject;
            }

            public String getHash() {
                return this.hash;
            }

            public int getId() {
                return this.id;
            }

            public String getMagnet() {
                return this.magnet;
            }

            public String getName() {
                return this.name;
            }

            public long getSize() {
                return this.size;
            }

            public boolean isReady() {
                return this.ready;
            }

            public void setHash(String str) {
                this.hash = str;
            }

            public void setId(int i2) {
                this.id = i2;
            }

            public void setMagnet(String str) {
                this.magnet = str;
            }

            public void setName(String str) {
                this.name = str;
            }

            public void setReady(boolean z2) {
                this.ready = z2;
            }

            public void setSize(long j2) {
                this.size = j2;
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
