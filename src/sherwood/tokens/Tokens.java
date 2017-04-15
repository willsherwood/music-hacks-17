package sherwood.tokens;

import java.util.*;

/**
 * Created by Will on 4/15/2017.
 */
public class Tokens {

    private String program;
    public List<Token> tokens;
    private int pointer;
    private static Map<Character, String> dynamicMap;
    static {
        dynamicMap = new HashMap<>();
        dynamicMap.put('P', "pp");
        dynamicMap.put('p', "p");
        dynamicMap.put('m', "mp");
        dynamicMap.put('M', "mf");
        dynamicMap.put('f', "f");
        dynamicMap.put('F', "ff");
        dynamicMap.put('D', ">");
        dynamicMap.put('C', "<");
        dynamicMap.put('d', ">");
        dynamicMap.put('c', "<");
        dynamicMap.put('!', "!");
    }

    public Tokens(String program) {
        this.tokens = new ArrayList<>();
        this.program = program + "            ";
        tokenize();
    }

    private void tokenize() {
        if (pointer == program.length()) return;
        if (program.charAt(pointer) == ' ')
            pointer++;
        else if (Character.isDigit(program.charAt(pointer))) {
            int digit = program.charAt(pointer++) - '0';
            List<Expression> exprs = new ArrayList<>();
            Sticking sticking = new Sticking("");
            boolean diddle = false;
            int graces = 0;
            // dotted rhythm
            while (program.charAt(pointer) == '.') {
                exprs.add(new Expression("."));
                pointer++;
            }
            // diddle
            if (program.charAt(pointer) == '/') {
                diddle = true;
                pointer++;
            }
            while (program.charAt(pointer) == 'g') {
                graces++;
                pointer++;
            }
            // expressions
            while ("^>-".contains("" + program.charAt(pointer)))
                exprs.add(new Expression("^" + program.charAt(pointer++)));
            // sticking
            if ("LRlr".contains("" + program.charAt(pointer)))
                sticking = new Sticking("_\"" + program.charAt(pointer++) + "\"");
            tokens.add(new Note("tomml", digit, graces, diddle, sticking, exprs));
            // dynamics
        } else if (program.charAt(pointer) == 'r') {
            pointer++;
            int digit = program.charAt(pointer++) - '0';
            tokens.add(new Note("r", digit, 0, false, new Sticking(""), Collections.emptyList()));
        } else if (dynamicMap.containsKey(program.charAt(pointer)))
            tokens.add(new Dynamic("\\" + dynamicMap.get(program.charAt(pointer++))));
        else if ('t' == program.charAt(pointer)) {
            pointer++;
            int a = number();
            while (program.charAt(pointer) == ' ') pointer++;
            int b = number();
            tokens.add(new Tuplet(a, b));
            while (program.charAt(pointer) == ' ') pointer++;
            if (program.charAt(pointer) != '{') {
                throw new RuntimeException("Expected { after tuple.");
            }
            pointer++;
        } else if ('T' == program.charAt(pointer)) {
            pointer++;
            int a = number();
            while (program.charAt(pointer) == ' ') pointer++;
            int b = number();
            tokens.add(new TimeSignature(a, b));
        } else if ("{}[]()".contains("" + program.charAt(pointer))) {
            tokens.add(new Bracing(program.charAt(pointer++) + ""));
        }
        tokenize();
    }

    private int number() {
        int out = 0;
        int base = 1;
        while (Character.isDigit(program.charAt(pointer))) {
            out += (program.charAt(pointer) - '0') * base;
            base *= 10;
            pointer++;
        }
        return out;
    }
}