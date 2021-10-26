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
  \stemUp tomml16:32 tomml16:32 tomml16:32 tomml16:32 \tuplet 3/2{ tomml32^-_\markup{\general-align #Y #3 R} [ tomml32_\markup{\general-align #Y #3 R} tomml32_\markup{\general-align #Y #3 R} ] tomml32^-_\markup{\general-align #Y #3 L} [ tomml32_\markup{\general-align #Y #3 L} tomml32_\markup{\general-align #Y #3 L} ] } \tuplet 3/2{ tomml32 [ tomml32^- tomml16:32 tomml16:32^- ] } \tuplet 3/2{ tomml32 [ tomml32 tomml32 tomml32 tomml32 tomml32 ] } \tuplet 5/4{ tomml16 \stemUp \acciaccatura { \scaleDurations 1/64 { tomml8 }} \stemUp tomml16^- tomml16 \stemUp \acciaccatura { \scaleDurations 1/64 { tomml8 }} \stemUp tomml16^- tomml16 } tomml16. _\< tomml16. tomml16. tomml16. tomml16^^ _\! tomml16^> tomml16^> tomml16^> tomml16^> tomml16^> tomml16^> tomml16^> \tuplet 3/2{ tomml8 tomml8^> tomml8^> } tomml32 tomml16 tomml32 tomml8^^}

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
 \midi { }
 }

