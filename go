#!/bin/bash
python3 3.py |
               sed -r 's@ 4([^ {/]*) r4 r4 r4 @ 2\1@g' |
               sed -r 's@ 4([^ {/]*) r3 @ 3.\1 @g' |
              sed -r 's@ 4([^ {/]*) r4@ 3\1 @g' |
               sed -r 's@ r4 r4 r4 @ r3#.# @g' |
               sed 's@ 55 \[@5 [5@g' |
               sed 's@ r4 \]@ ] r4 @g' |
               sed 's@\[ r3#.# \]@ r3#.# @g'
