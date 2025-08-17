package com.original.tase.model.debrid.premiumize;

import java.util.ArrayList;
import java.util.List;

public class PremiumizeCacheCheckResponse {
    private List<CacheCheckResponseSingle> consolidatedResponse;
    public String[] filename;
    public String[] filesize;
    public String[] response;
    public String status;
    public String[] transcoded;

    public class CacheCheckResponseSingle {
        public String filename;
        public Long filesize;
        public boolean response;
        public String transcoded;

        public CacheCheckResponseSingle(PremiumizeCacheCheckResponse premiumizeCacheCheckResponse, int i2) {
            boolean z2;
            String str;
            String[] strArr = premiumizeCacheCheckResponse.response;
            if (strArr == null || strArr.length <= i2 || !"true".equals(strArr[i2])) {
                z2 = false;
            } else {
                z2 = true;
            }
            this.response = z2;
            String[] strArr2 = premiumizeCacheCheckResponse.transcoded;
            String str2 = null;
            if (strArr2 == null || strArr2.length <= i2) {
                str = null;
            } else {
                str = strArr2[i2];
            }
            this.transcoded = str;
            String[] strArr3 = premiumizeCacheCheckResponse.filename;
            if (strArr3 != null && strArr3.length > i2) {
                str2 = strArr3[i2];
            }
            this.filename = str2;
            String[] strArr4 = premiumizeCacheCheckResponse.filesize;
            if (strArr4 != null && strArr4.length > i2) {
                try {
                    this.filesize = Long.valueOf(Long.parseLong(strArr4[i2]));
                } catch (Exception unused) {
                }
            }
        }
    }

    public List<CacheCheckResponseSingle> consolidate() {
        String[] strArr;
        if (!"success".equals(this.status) || (strArr = this.response) == null || strArr.length <= 0) {
            return null;
        }
        if (this.consolidatedResponse == null) {
            this.consolidatedResponse = new ArrayList();
            for (int i2 = 0; i2 < this.response.length; i2++) {
                this.consolidatedResponse.add(new CacheCheckResponseSingle(this, i2));
            }
        }
        return this.consolidatedResponse;
    }

    public CacheCheckResponseSingle getFirst() {
        if (consolidate() == null || consolidate().size() <= 0) {
            return null;
        }
        return consolidate().get(0);
    }
}
