package com.movie.data.model.realdebrid;

import com.google.gson.Gson;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class InstantAvailabilityObject {
    private Map<String, InstanceObj> hashInstances;

    public static class InstanceObj {
        private List<Map<String, RdBean>> rd;

        public static class RdBean {
            private String filename;
            private int filesize;

            public String getFilename() {
                return this.filename;
            }

            public int getFilesize() {
                return this.filesize;
            }

            public void setFilename(String str) {
                this.filename = str;
            }

            public void setFilesize(int i2) {
                this.filesize = i2;
            }
        }

        public List<Map<String, RdBean>> getRd() {
            return this.rd;
        }

        public void setRd(List<Map<String, RdBean>> list) {
            this.rd = list;
        }
    }

    public static InstantAvailabilityObject deserialize(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        JSONArray names = jSONObject.names();
        HashMap hashMap = new HashMap();
        Gson gson = new Gson();
        for (int i2 = 0; i2 < names.length(); i2++) {
            hashMap.put(names.getString(i2), (InstanceObj) gson.l(jSONObject.get(names.getString(i2)).toString(), InstanceObj.class));
        }
        InstantAvailabilityObject instantAvailabilityObject = new InstantAvailabilityObject();
        instantAvailabilityObject.hashInstances = hashMap;
        return instantAvailabilityObject;
    }

    public Map<String, InstanceObj> getHashInstances() {
        return this.hashInstances;
    }

    public void setHashInstances(Map<String, InstanceObj> map) {
        this.hashInstances = map;
    }
}
