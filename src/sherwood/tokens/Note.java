package sherwood.tokens;

import java.util.List;

/**
 * Created by Will on 4/15/2017.
 */
public class Note implements Token {

    private final List<Expression> exprs;
    private final Sticking sticking;
    private final int length;
    private final String instrument;
    private final boolean diddle;
    private final int graces;

    public Note(String instrument, int length, int graces, boolean diddle, Sticking sticking, List<Expression> exprs) {
        this.instrument = instrument;
        this.length = length;
        this.sticking = sticking;
        this.exprs = exprs;
        this.diddle = diddle;
        this.graces = graces;
    }

    @Override
    public String lily() {
        StringBuilder out = new StringBuilder();
        int graces = this.graces;
        if (graces > 0) {
            out.append("\\stemUp \\acciaccatura {");
            while (graces --> 0)
                out.append("tomml8 ");
            out.append("} ");
        }
        out.append(instrument);
        out.append(1 << length);
        if (diddle)  {
            out.append(":");
            out.append(2 << length);
        }
        for (Expression expr: exprs) {
            out.append(expr.lily());
        }
        out.append(sticking.lily());
        return out.toString();
    }

    @Override
    public String original() {
        return null;
    }
}
