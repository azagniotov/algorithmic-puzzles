#!/usr/bin/env sh

CURRENT_DIR=`pwd`
JARNAME="linguistic-chains-1.0.0.jar"
CLASSES_DIR="bin/main"
TEST_CLASSES_DIR="bin/test"
echo "You are currently in $CURRENT_DIR"
echo ""

##### CLEAN UP #####
rm -rf bin/
rm -rf dependencies/
rm -f linguistic-chains-*.jar
mkdir -p "$CLASSES_DIR"
mkdir -p "$TEST_CLASSES_DIR"
mkdir dependencies

##### COMPILE SOURCES #####
SOURCES=$(find src/main -name "*.java")
COMPILE_CLASSPATH=
for x in $(find dependencies -name "*.jar"); do COMPILE_CLASSPATH="$COMPILE_CLASSPATH:$x"; done
javac -d "$CLASSES_DIR" -cp "$COMPILE_CLASSPATH" $SOURCES

##### JAR #####
jar cmf MANIFEST.MF $JARNAME -C "$CLASSES_DIR" .
echo "Created $JARNAME under $CURRENT_DIR"
echo ""
echo "Usage: java -jar $JARNAME [input file name]"
