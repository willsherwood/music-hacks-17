package sherwood.tokens;

/**
 * Created by Will on 4/15/2017.
 */
public class Sticking implements Token {
    private final String sticking;

    public Sticking(String s) {
        this.sticking = s;
    }

    @Override
    public String lily() {
        return sticking;
    }

    @Override
    public String original() {
        return null;
    }
}
