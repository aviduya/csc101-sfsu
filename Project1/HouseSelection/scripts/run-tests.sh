#!/bin/bash

PROJECT_DIR="$(cd "$(dirname "$0")/.." && pwd)"

mkdir -p "$PROJECT_DIR/build"

javac -d "$PROJECT_DIR/build" "$PROJECT_DIR/src"/*.java || exit 1

clear

for testfile in "$PROJECT_DIR/tests"/*.txt; do
    echo "=============================="
    echo "Running: $(basename "$testfile")"
    echo "=============================="

    java -cp "$PROJECT_DIR/build" HousingSelection \ < <(sed '/^[[:space:]]*#/d' "$testfile")

    exit_code=$?
    echo "Java exited with code: $exit_code"
done