package kotlinx.coroutines;

public interface ChildJob extends Job {
    void v(ParentJob parentJob);
}
