package com.utils.Getlink.Resolver;

public class Filelions extends GenericResolver {
    public String c() {
        return "Filelions";
    }

    public boolean o() {
        return false;
    }

    public String p() {
        return "(?://|\\.)(filelions|vidhidepro)\\.(?:tv|cc|to|co|sx|in|com|net|org)/(?:embed-|e/|d/|v/|file/)?([0-9a-zA-Z]+)";
    }

    public String q() {
        return "https://filelions.to";
    }

    public String r(String str, String str2) {
        return str + "/v/" + str2;
    }
}
