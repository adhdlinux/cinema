package com.utils.Getlink.Resolver;

public class Filemoon extends GenericResolver {
    public String c() {
        return "Filemoon";
    }

    public boolean o() {
        return false;
    }

    public String p() {
        return "(?://|\\.)(filemoon|streamhide|movhide|ztreamhub|guccihide|Ahvsh|moviesm4u|hellnaw|kerapoxy)\\.(?:tv|cc|to|co|sx|in|pro|com|im)/(?:embed-|e/|d/|)?([0-9a-zA-Z]+)";
    }

    public String q() {
        return "";
    }

    public String r(String str, String str2) {
        return str + "/e/" + str2;
    }
}
