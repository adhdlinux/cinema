package kotlin.text;

import java.util.List;
import kotlin.ranges.IntRange;

public interface MatchResult {
    List<String> a();

    IntRange b();

    String getValue();

    MatchResult next();
}
