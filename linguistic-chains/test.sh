#!/usr/bin/env sh

CLASSES_DIR="bin/main"
TEST_CLASSES_DIR="bin/test"

##### CLEAN UP #####
rm -rf bin/
mkdir -p "$CLASSES_DIR"
mkdir -p "$TEST_CLASSES_DIR"

##### DONWLOAD DEPS #####
echo "Fetching dependencies.."
MOCKITO="http://mirrors.ibiblio.org/maven2/org/mockito/mockito-all/1.10.19/mockito-all-1.10.19.jar"
JUNIT="http://mirrors.ibiblio.org/maven2/junit/junit/4.12/junit-4.12.jar"
HAMCREST="http://mirrors.ibiblio.org/maven2/org/hamcrest/hamcrest-core/1.3/hamcrest-core-1.3.jar"
#HAMCREST=""
cd dependencies && { curl -O $MOCKITO -O $JUNIT -O $HAMCREST ; cd - > /dev/null; }

##### COMPILE SOURCES #####
SOURCES=$(find src/main -name "*.java")
COMPILE_CLASSPATH=
for x in $(find dependencies -name "*.jar"); do COMPILE_CLASSPATH="$COMPILE_CLASSPATH:$x"; done
javac -d "$CLASSES_DIR" -cp "$COMPILE_CLASSPATH" $SOURCES

##### COMPILE TEST SOURCES #####
TEST_SOURCES=$(find src/test -name "*.java")
javac -d "$TEST_CLASSES_DIR" -cp "$COMPILE_CLASSPATH:$CLASSES_DIR" $TEST_SOURCES

##### RUNS TESTS #####
COMPILED_TEST_CLASSES=$(find "$TEST_CLASSES_DIR" -name "*.class" | sed 's/bin\/test\///g' | sed 's/\.class//g' | sed 's/\//\./g')
echo ""
TESTS=
for class in $COMPILED_TEST_CLASSES; do TESTS="$TESTS $class"; done
java -cp ".$COMPILE_CLASSPATH:$CLASSES_DIR:$TEST_CLASSES_DIR" org.junit.runner.JUnitCore $TESTS;

