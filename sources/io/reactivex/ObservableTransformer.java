package io.reactivex;

public interface ObservableTransformer<Upstream, Downstream> {
    ObservableSource<Downstream> a(Observable<Upstream> observable);
}
