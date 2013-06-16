#!/bin/sh

TESTSKIP='-Dmaven.test.skip=true'
COMMAND='mvn'

for arg in "$@";
do
    case "$arg" in
        -test) TESTSKIP='';;
        -*) echo "illegal option $arg"; exit 1;;
        *) COMMAND="$COMMAND $arg";;
    esac
done

echo "$COMMAND $TESTSKIP"

exit 0;
