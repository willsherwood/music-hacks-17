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
  \stemUp \time 7/8  \tuplet 3/2{ tomml8 [ tomml8 tomml8 ] } tomml8 [ tomml8. tomml16 ] \tuplet 3/2{ tomml8 [ tomml8 tomml8 ] } tomml16 tomml16 r8 tomml4 tomml8 tomml8 [ tomml16 tomml16 ] tomml4 tomml4. tomml4}

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

