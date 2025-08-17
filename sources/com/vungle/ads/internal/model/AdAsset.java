package com.vungle.ads.internal.model;

import kotlin.jvm.internal.Intrinsics;

public final class AdAsset {
    private final String adIdentifier;
    private long fileSize;
    private final FileType fileType;
    private final boolean isRequired;
    private final String localPath;
    private final String serverPath;
    private Status status = Status.NEW;

    public enum FileType {
        ZIP,
        ASSET
    }

    public enum Status {
        NEW,
        DOWNLOAD_RUNNING,
        DOWNLOAD_FAILED,
        DOWNLOAD_SUCCESS,
        PROCESSED
    }

    public AdAsset(String str, String str2, String str3, FileType fileType2, boolean z2) {
        Intrinsics.f(str, "adIdentifier");
        Intrinsics.f(str2, "serverPath");
        Intrinsics.f(str3, "localPath");
        Intrinsics.f(fileType2, "fileType");
        this.adIdentifier = str;
        this.serverPath = str2;
        this.localPath = str3;
        this.fileType = fileType2;
        this.isRequired = z2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !Intrinsics.a(AdAsset.class, obj.getClass())) {
            return false;
        }
        AdAsset adAsset = (AdAsset) obj;
        if (this.status == adAsset.status && this.fileType == adAsset.fileType && this.fileSize == adAsset.fileSize && this.isRequired == adAsset.isRequired && Intrinsics.a(this.adIdentifier, adAsset.adIdentifier) && Intrinsics.a(this.serverPath, adAsset.serverPath)) {
            return Intrinsics.a(this.localPath, adAsset.localPath);
        }
        return false;
    }

    public final String getAdIdentifier() {
        return this.adIdentifier;
    }

    public final long getFileSize() {
        return this.fileSize;
    }

    public final FileType getFileType() {
        return this.fileType;
    }

    public final String getLocalPath() {
        return this.localPath;
    }

    public final String getServerPath() {
        return this.serverPath;
    }

    public final Status getStatus() {
        return this.status;
    }

    public int hashCode() {
        long j2 = this.fileSize;
        return (((((((((((this.adIdentifier.hashCode() * 31) + this.serverPath.hashCode()) * 31) + this.localPath.hashCode()) * 31) + this.status.hashCode()) * 31) + this.fileType.hashCode()) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + a.a(this.isRequired);
    }

    public final boolean isRequired() {
        return this.isRequired;
    }

    public final void setFileSize(long j2) {
        this.fileSize = j2;
    }

    public final void setStatus(Status status2) {
        Intrinsics.f(status2, "<set-?>");
        this.status = status2;
    }

    public String toString() {
        return "AdAsset{, adIdentifier='" + this.adIdentifier + "', serverPath='" + this.serverPath + "', localPath='" + this.localPath + "', status=" + this.status + ", fileType=" + this.fileType + ", fileSize=" + this.fileSize + ", isRequired=" + this.isRequired + '}';
    }
}
