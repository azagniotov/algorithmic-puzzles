#!/usr/bin/env bash

JARNAME="linguistic-chains-1.0.0.jar"

COMPILE_CLASSPATH=
for x in $(find dependencies -name "*.jar"); do COMPILE_CLASSPATH="$COMPILE_CLASSPATH:$x"; done
java -cp "$JARNAME:$COMPILE_CLASSPATH" linguistic_chains.Main input/354982.txt
