package com.startapp;

public class i5 {
    private String admtag;
    private String campaign_id;
    private String partnerName;
    private String partnerResponse;
    private boolean recordHops;
    private boolean skipFailed;
    private String ttl_sec;
    private String vasttag;

    public String getAdmTag() {
        return this.admtag;
    }

    public String getCampaignId() {
        return this.campaign_id;
    }

    public String getPartnerName() {
        return this.partnerName;
    }

    public String getPartnerResponse() {
        return this.partnerResponse;
    }

    public String getTtlSec() {
        return this.ttl_sec;
    }

    public String getVastTag() {
        return this.vasttag;
    }

    public boolean isRecordHops() {
        return this.recordHops;
    }

    public boolean isSkipFailed() {
        return this.skipFailed;
    }
}
