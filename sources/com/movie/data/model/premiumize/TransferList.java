package com.movie.data.model.premiumize;

import com.movie.data.model.TorrentObject;
import com.original.tase.utils.Regex;
import java.util.ArrayList;
import java.util.List;
import org.joda.time.DateTime;

public class TransferList {
    private String status;
    private List<TransfersBean> transfers;

    public static class TransfersBean implements TorrentObject.TorrentObjectConverter {
        private String file_id;
        private String folder_id;
        private String id;
        private String message;
        private String name;
        private double progress;
        private String src;
        private String status;

        public TorrentObject convert() {
            int i2;
            ArrayList arrayList = new ArrayList();
            TorrentObject torrentObject = new TorrentObject();
            torrentObject.setFiles(arrayList);
            torrentObject.setHash(Regex.a(getSrc(), "magnet:\\?xt=urn:btih:([^&.]+)", 1).toLowerCase());
            torrentObject.setFolder_id(getFolder_id());
            torrentObject.setFile_id(getFile_id());
            torrentObject.setId(getId());
            torrentObject.setName(getName());
            String status2 = getStatus();
            if (getStatus().contains("finished")) {
                i2 = 100;
            } else {
                i2 = (int) getProgress();
            }
            torrentObject.setStatusBean(new TorrentObject.StatusBean(status2, i2, 0, 0));
            torrentObject.setType(TorrentObject.Type.PM);
            torrentObject.setAddedTime(DateTime.now().toString());
            return torrentObject;
        }

        public String getFile_id() {
            return this.file_id;
        }

        public String getFolder_id() {
            return this.folder_id;
        }

        public String getId() {
            return this.id;
        }

        public String getMessage() {
            return this.message;
        }

        public String getName() {
            return this.name;
        }

        public double getProgress() {
            return this.progress;
        }

        public String getSrc() {
            return this.src;
        }

        public String getStatus() {
            return this.status;
        }

        public void setFile_id(String str) {
            this.file_id = str;
        }

        public void setFolder_id(String str) {
            this.folder_id = str;
        }

        public void setId(String str) {
            this.id = str;
        }

        public void setMessage(String str) {
            this.message = str;
        }

        public void setName(String str) {
            this.name = str;
        }

        public void setProgress(double d2) {
            this.progress = d2;
        }

        public void setSrc(String str) {
            this.src = str;
        }

        public void setStatus(String str) {
            this.status = str;
        }
    }

    public String getStatus() {
        return this.status;
    }

    public List<TransfersBean> getTransfers() {
        return this.transfers;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public void setTransfers(List<TransfersBean> list) {
        this.transfers = list;
    }
}
