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
  \stemUp \time 11/16  r16 \tuplet 5/4{ tomml16:32 tomml32^- tomml16:32 } tomml32 tomml64^- tomml64^- tomml16 \tuplet 3/2{ tomml8:16 tomml16 } tomml16 tomml64 [ tomml64^- tomml32:64 tomml32^- ] \stemUp \acciaccatura {tomml8 } \stemUp tomml32^- [ tomml32 \stemUp \acciaccatura {tomml8 } \stemUp tomml32^- ] tomml128}

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

