package sherwood.tokens;

/**
 * Created by Will on 4/15/2017.
 */
public class TimeSignature implements Token {
    private final int b;
    private final int a;

    public TimeSignature(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public String lily() {
        return "\\time " + a + "/" + b + " ";
    }

    @Override
    public String original() {
        return null;
    }
}
