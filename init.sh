#!/bin/bash

[ -z "${1}" ] && exit

$PROJ=$1

git clone https://github.com/anonymoose/clojure-skeleton.git
mv clojure-skeleton $PROJ
cd $PROJ

perl -p -i -e "s/myproject/${PROJ}/ig" `grep -ril myproject *`

cd test
mv myproject $PROJ
cd ..
cd src
mv myproject $PROJ
cd ..
lein deps
bin/dev
