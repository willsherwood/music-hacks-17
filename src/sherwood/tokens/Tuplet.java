package sherwood.tokens;

/**
 * Created by Will on 4/15/2017.
 */
public class Tuplet implements Token {
    private final int a;
    private final int b;

    public Tuplet(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public String lily() {
        return "\\tuplet " + a + "/" + b + "{";
    }

    @Override
    public String original() {
        return null;
    }
}
