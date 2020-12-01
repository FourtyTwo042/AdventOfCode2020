#!/bin bash
# shellcheck shell=bash
for i in {1..25}
do
	mkdir "day$i"
	touch "day$i/main.java"
done
