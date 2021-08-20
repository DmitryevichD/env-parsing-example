#!/bin/bash

level=""

while getopts "c:nl:n" f; do
  case "$f" in
  l) level="$OPTARG" ;;
  *)
    echo "Usage: $0 [-l <inner | env> ]" >&2
    exit 1
    ;;
  esac

  if [ $level == "inner" ]; then
    echo "Using inner properties"
    ./gradlew bootRun
    exit
  fi

  if [ $level == "env" ]; then
    echo "Using env properties"
    export ENV_CEBABCASE_VARIABLECASE=ENV-CEBAB-CASE
    export ENV_CAMELCASE_VARIABLECASE=ENV-CAMELCASE
    export ENV_SNAKECASE_VARIABLECASE=ENV_SNAKE_CASE

    ./gradlew bootRun
  fi

  echo "Usage: $0 [-l <inner | env> ]" >&2
done
