\version "2.18.2"
#(set! paper-alist (cons '("my size" . (cons (* 19 in) (* 9 in))) paper-alist))

\paper {
  indent = 0\mm
  line-width = 110\mm
  oddHeaderMarkup = ""
  evenHeaderMarkup = ""
  oddFooterMarkup = ""
  evenFooterMarkup = ""
  #(set-paper-size "my size")
}
notes = \drummode {
  \stemUp tomml8 tomml16 tomml16 tomml32 tomml16 tomml32 tomml32 tomml16. tomml16. tomml16. tomml16 r16 tomml8. tomml8 tomml32 tomml16 tomml16 tomml16 tomml32 tomml16. tomml32 tomml8 tomml8. tomml16. tomml16. tomml16 tomml16 tomml32 tomml32 tomml16:32 tomml8^"z" tomml16 tomml32 tomml16 tomml32 tomml16:32 tomml8^"z" tomml16 tomml16:32 tomml32 tomml16 tomml32 tomml8^"z" tomml16:32 tomml32 tomml16 tomml32 tomml16 tomml8^"z" tomml16:32 tomml32 tomml16 tomml16 tomml32 tomml8^"z" tomml16:32 tomml16:32 tomml16^- tomml8^"z" tomml16^- tomml8^"z" tomml8^"z" tomml32 tomml32 tomml16:32 tomml16 tomml32 tomml16:32 tomml16 tomml32 tomml8^"z" tomml32^> tomml32^> tomml8.^> tomml32^> tomml32^> tomml8.^> tomml16^> tomml32^> tomml32^> tomml8^> tomml32^> tomml4.^> tomml4^> tomml8 tomml16 tomml16 tomml32 tomml32 tomml32 tomml32 tomml2^^}

\score { 
  <<
    \new DrumStaff \with {
      \override StaffSymbol.line-count = #1
      \override BarLine.bar-extent = #'(-1 . 1)
      \override Slur.transparent = ##t
\override StemTremolo #'slope = #0.5
\override StemTremolo #'beam-thickness = #0.25
\override StemTremolo #'beam-width = #1.75
\override StemTremolo #'Y-offset = #2.25
    } <<
      \set Staff.instrumentName = #"Sn."
      \notes
    >>
  >>
  }

