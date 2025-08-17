package androidx.work.impl.model;

import android.annotation.SuppressLint;
import androidx.work.Data;
import androidx.work.WorkInfo;
import androidx.work.impl.model.WorkSpec;
import java.util.List;

@SuppressLint({"UnknownNullness"})
public interface WorkSpecDao {
    int a(WorkInfo.State state, String... strArr);

    List<WorkSpec> b(long j2);

    void c(WorkSpec workSpec);

    List<WorkSpec> d();

    void delete(String str);

    List<String> e(String str);

    WorkInfo.State f(String str);

    WorkSpec g(String str);

    List<String> h(String str);

    List<Data> i(String str);

    List<WorkSpec> j(int i2);

    int k();

    int l(String str, long j2);

    List<WorkSpec.IdAndState> m(String str);

    List<WorkSpec> n(int i2);

    void o(String str, Data data);

    List<WorkSpec> p();

    boolean q();

    int r(String str);

    int s(String str);

    void t(String str, long j2);
}
