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
  \stemUp tomml16 tomml32 tomml64}

\score {
  <<
    \new DrumStaff \with {
      \override StaffSymbol.line-count = #1
      \override BarLine.bar-extent = #'(-1 . 1)
    } <<
      \set Staff.instrumentName = #"Sn."
      \notes
    >>
  >>
 }

