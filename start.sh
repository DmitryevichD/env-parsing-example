#!/bin/bash

level=""

while getopts "c:nl:n" f; do
  case "$f" in
  l) level="$OPTARG" ;;
  *)
    echo "Usage: $0 [-l <inner | env | value> ]" >&2
    exit 1
    ;;
  esac

  if [ $level == "inner" ]; then
    echo "Using inner properties"
    ./gradlew bootRun
    exit
  fi

  if [ $level == "env" ]; then
    echo "Using env properties for ConfigurationProperties"
    export ENV_CEBAB_CASE_VARIABLE_CASE=ENV-CEBAB-CASE
    export ENV_CAMELCASE_VARIABLECASE=ENV-CAMELCASE
    export ENV_SNAKECASE_VARIABLECASE=ENV_SNAKE_CASE

    echo "Using env properties for Value annotation"
#    @Value("${env.value.one-property.in-cebab-case0}")
    export ENV_VALUE_ONE_PROPERTY_IN_CEBAB_CASE0="Value(env.value.one-property.in-cebab-case0) ->> ENV_VALUE_ONE_PROPERTY_IN_CEBAB_CASE0"
#    @Value("${env.value.one-property.in-cebab-case1}")
    export ENV_VALUE_ONEPROPERTY_INCEBABCASE1="Value(env.value.one-property.in-cebab-case1) ->> ENV_VALUE_ONEPROPERTY_INCEBABCASE1"

#    @Value("${env.value.one_property.in_snake_case0}")
    export ENV_VALUE_ONE_PROPERTY_IN_SNAKE_CASE_0="Value(env.value.one_property.in_snake_case0) ->> ENV -> not support"
#    @Value("${env.value.one_property.in_snake_case1}")
    export ENV_VALUE_ONEPROPERTY_INSNAKECASE1="Value(env.value.one_property.in_snake_case1) ->> ENV -> not support"

#    @Value("${env.value.oneProperty.inCamelCase}")
    export ENV_VALUE_ONEPROPERTY_INCAMELCASE="Value(env.value.oneProperty.inCamelCase) ->> ENV -> ENV_VALUE_ONEPRPOPERTY_INCAMELCASE"
    ./gradlew bootRun
  fi

  echo "Usage: $0 [-l <inner | env> ]" >&2
done
