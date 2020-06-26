\version "2.18.2"

\paper {
  indent = 0\mm
  line-width = 110\mm
  oddHeaderMarkup = ""
  evenHeaderMarkup = ""
  oddFooterMarkup = ""
  evenFooterMarkup = ""
}
notes = \drummode {
  \stemUp \time 12/8  r4 tomml8^> tomml8^> [ tomml8:16 tomml8:16 ] tomml8^> [ tomml8^> \stemUp \acciaccatura {tomml8 } \stemUp tomml8 ] \stemUp \acciaccatura {tomml8 } \stemUp tomml4. tomml8^> [ tomml8^> tomml8:16 ] tomml8:16 [ tomml8^> tomml8^> ] \stemUp \acciaccatura {tomml8 } \stemUp tomml8 \stemUp \acciaccatura {tomml8 } \stemUp tomml4 r8 \time 9/8  tomml8^> tomml8^> tomml8:16 tomml8:16 tomml8^> tomml8^> \stemUp \acciaccatura {tomml8 } \stemUp tomml8 \stemUp \acciaccatura {tomml8 } \stemUp tomml8 \stemUp \acciaccatura {tomml8 } \stemUp tomml4.}

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

