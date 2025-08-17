package com.movie.data.model.premiumize;

import com.movie.data.model.TorrentObject;
import java.util.ArrayList;
import org.joda.time.DateTime;

public class TransferCreate implements TorrentObject.TorrentObjectConverter {
    private String id;
    private String name;
    private String status;
    private String type;

    public TorrentObject convert() {
        int i2;
        ArrayList arrayList = new ArrayList();
        TorrentObject torrentObject = new TorrentObject();
        torrentObject.setFiles(arrayList);
        torrentObject.setId(getId());
        torrentObject.setName(getName());
        String status2 = getStatus();
        if (getStatus().contains("success")) {
            i2 = 100;
        } else {
            i2 = 0;
        }
        torrentObject.setStatusBean(new TorrentObject.StatusBean(status2, i2, 0, 0));
        torrentObject.setType(TorrentObject.Type.PM);
        torrentObject.setAddedTime(DateTime.now().toString());
        return torrentObject;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getStatus() {
        return this.status;
    }

    public String getType() {
        return this.type;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public void setType(String str) {
        this.type = str;
    }
}
