package z0;

import com.movie.data.model.tmvdb.SeasonTMDB;
import io.reactivex.functions.Function;

public final /* synthetic */ class h implements Function {
    public final Object apply(Object obj) {
        return ((SeasonTMDB) obj).getEpisodes();
    }
}
