package androidx.work;

import androidx.work.Data;
import java.util.HashMap;
import java.util.List;

public final class OverwritingInputMerger extends InputMerger {
    public Data b(List<Data> list) {
        Data.Builder builder = new Data.Builder();
        HashMap hashMap = new HashMap();
        for (Data j2 : list) {
            hashMap.putAll(j2.j());
        }
        builder.d(hashMap);
        return builder.a();
    }
}
