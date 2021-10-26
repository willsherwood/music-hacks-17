\version "2.18.2" \include "articulate.ly" 
#(set! paper-alist (cons '("my size" . (cons (* 10 in) (* 16 in))) paper-alist))

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
  \stemUp tomml16 tomml16^> tomml8:16^> tomml16^> tomml16 tomml8:16^> tomml16 tomml16 tomml8:16^> tomml16^> tomml16^> tomml8:16^> \tuplet 3/2{ tomml8:16 tomml8:16 tomml8:16 } tomml16^> tomml16 tomml8:16 tomml16 tomml16^> tomml8:16 \tuplet 4/3{ tomml8 tomml8:16 tomml8:16 tomml8:16 } tomml16 tomml16 tomml8:16 tomml16^> tomml16^> tomml8:16 \tuplet 5/4{ tomml8 tomml8:16 tomml8:16 tomml8:16 tomml8:16 }}

\score { \articulate  
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
 \midi { }
 }

