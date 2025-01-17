#!/bin/bash

while [ $# -gt 0 ]
do

if [[ $1 == *.txt ]];then
	fileName=`echo $1 | cut -d "." -f 1`
	mv $1 $fileName.md
fi

shift;
done
