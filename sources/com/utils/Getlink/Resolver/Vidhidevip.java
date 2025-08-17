package com.utils.Getlink.Resolver;

public class Vidhidevip extends GenericResolver {
    public String c() {
        return "Vidhidevip";
    }

    public boolean o() {
        return false;
    }

    public String p() {
        return "(?://|\\.)(vidhidevip|vidhidepre|vidhide\\w+)\\.(?:tv|cc|to|co|sx|in|pro|com|im)/(?:embed-|e/|d/|embed/|v/|file/|)?([0-9a-zA-Z]+)";
    }

    public String q() {
        return "";
    }

    public String r(String str, String str2) {
        return str + "/embed/" + str2;
    }
}
