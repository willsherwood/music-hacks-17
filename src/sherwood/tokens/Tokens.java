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
		private static int notes;

    static {
        dynamicMap = new HashMap<>();
        dynamicMap.put('P', "_\\markup{\\bold \\italic pp}");
        dynamicMap.put('p', "_\\markup{\\bold \\italic p}");
        dynamicMap.put('m', "_\\markup{\\bold \\italic mp}");
        dynamicMap.put('M', "_\\markup{\\bold \\italic mf}");
        dynamicMap.put('f', "_\\markup{\\bold \\italic f}");
        dynamicMap.put('F', "_\\markup{\\bold \\italic ff}");
        dynamicMap.put('D', "_\\>");
        dynamicMap.put('C', "_\\<");
        dynamicMap.put('d', "_\\>");
        dynamicMap.put('c', "_\\<");
        dynamicMap.put('!', "_\\!");
    }

    public Tokens(String program) {
        this.tokens = new ArrayList<>();
        this.program = program + "            ";
        tokenize();
    }

    private void tokenize() {
        if (pointer == program.length()) return;
        if (program.charAt(pointer) == ' ' || program.charAt(pointer) == 9)
            pointer++;
        else if (Character.isDigit(program.charAt(pointer))) {
            int digit = program.charAt(pointer++) - '0';
            List<Expression> exprs = new ArrayList<>();
           // Sticking sticking = new Sticking("_\\markup{\\general-align #Y #3 " + (notes % 2 == 0 ? "R" : "L") + "}");
					  Sticking sticking = new Sticking("");

				//		if (notes++ % 3 == 0) exprs.add(new Expression("^>"));
            boolean diddle = // notes++ % 3 == 0;
						false;

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
            while ("^>-z".contains("" + program.charAt(pointer))) {
            	char expr = program.charAt(pointer++);
		if (expr == 'z') expr = '.'; 
		exprs.add(new Expression("^" + expr));
	    }
            // sticking
						
            if ("LR".contains("" + program.charAt(pointer)))
                sticking = new Sticking("_\\markup{\\general-align #Y #3 " + program.charAt(pointer++) + "}");

            tokens.add(new Note("tomml", digit, graces, diddle, sticking, exprs));
            // dynamics
        } else if (program.charAt(pointer) == 'r') {
            pointer++;
            int digit = program.charAt(pointer++) - '0';
            tokens.add(new Note("r", digit, 0, false, new Sticking(""), Collections.emptyList()));
        } else if (dynamicMap.containsKey(program.charAt(pointer)))
            tokens.add(new Dynamic(dynamicMap.get(program.charAt(pointer++))));
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
        } else {
            throw new RuntimeException("Unrecognized symbol " + (int) program.charAt(pointer));
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
