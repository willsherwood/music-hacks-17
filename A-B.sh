#!/bin/bash
python ab.py > a
python ab.py > b
./articulate a
mv out.pdf out-2.pdf
./articulate b
start out.pdf
start out-2.pdf

sleep 2
start out-midi.mid
