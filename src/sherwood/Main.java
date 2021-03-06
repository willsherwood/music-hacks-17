package sherwood;

import sherwood.tokens.Token;
import sherwood.tokens.Tokens;

import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        String program = String.join(" ", sysInLines());
        String out = String.join(" ", new Tokens(program).tokens.stream().map(Token::lily).collect(Collectors.toList()));
        System.out.println("\\version \"2.18.2\"\n" +
                        "#(set! paper-alist (cons '(\"my size\" . (cons (* " + Integer.parseInt(args[0]) + " in) (* " + Integer.parseInt(args[1]) + " in))) paper-alist))\n" +
                "\n\\paper {\n" +
                "  indent = 0\\mm\n" +
                "  line-width = 110\\mm\n" +
                "  oddHeaderMarkup = \"\"\n" +
                "  evenHeaderMarkup = \"\"\n" +
                "  oddFooterMarkup = \"\"\n" +
                "  evenFooterMarkup = \"\"\n" +
                "  #(set-paper-size \"my size\")\n" +
                "}\n" +
                "notes = \\drummode {\n" +
                "  \\stemUp " +
                out +
                "}\n" +
                "\n" +
                "\\score { \n" +
                "  <<\n" +
                "    \\new DrumStaff \\with {\n" +
                "      \\override StaffSymbol.line-count = #1\n" +
                "      \\override BarLine.bar-extent = #'(-1 . 1)\n" +
                "      \\override Slur.transparent = ##t\n" +
                "\\override StemTremolo #'slope = #0.5\n" +
                "\\override StemTremolo #'beam-thickness = #0.25\n" +
                "\\override StemTremolo #'beam-width = #1.75\n" +
                "\\override StemTremolo #'Y-offset = #2.25\n" +
                "    } <<\n" +
                "      \\set Staff.instrumentName = #\"Sn.\"\n" +
                "      \\notes\n" +
                "    >>\n" +
                "  >>\n " + (args.length > 2 ? "\\midi { }\n" : "") +
                " " +
                "}\n");
    }

    private static List<String> sysInLines() {
        Scanner s = new Scanner(System.in);
        List<String> ls = new ArrayList<>();
        while (s.hasNextLine())
            ls.add(s.nextLine());
        return ls;
    }
}
