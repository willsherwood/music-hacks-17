package sherwood.tokens;

/**
 * Created by Will on 4/15/2017.
 */
public class Bracing implements Token {
    private final String brace;

    public Bracing(String brace) {
        this.brace=  brace;
    }

    @Override
    public String lily() {
        return brace;
    }

    @Override
    public String original() {
        return null;
    }
}
