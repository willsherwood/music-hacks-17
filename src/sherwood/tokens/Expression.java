package sherwood.tokens;

/**
 * Created by Will on 4/15/2017.
 */
public class Expression implements Token {
    private final String lily;

    public Expression(String lily) {
        this.lily = lily;
    }

    @Override
    public String lily() {
        return lily;
    }

    @Override
    public String original() {
        return null;
    }
}
