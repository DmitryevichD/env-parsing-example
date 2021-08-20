## Project shows an example how parse variables from yml file to ENV 

#### Config from application.yml
`src/main/resources/application.yml`

```bash
env:
  cebab-case:
    variable-case: cebab-case
  camel-case:
    variableCase: camelCase
  snake-case:
    variable_case: snake_case

```

#### Configu from @Value
#### 
```diff 
- ATTENTION!!! Variables with words that contain snake_case delimited don't support by @Value
```

```bash
    @Value("${env.value.one-property.in-cebab-case0:}")
    private String cebabCaseValue0 = null;
    @Value("${env.value.one-property.in-cebab-case1:}")
    private String cebabCaseValue1 = null;
    @Value("${env.value.one_property.in_snake_case0:SNAKE_CASE_WORD not support in @Value}")
    private String snakeCaseValue0 = null;
    @Value("${env.value.one_property.in_snake_case1:SNAKE_CASE_WORD not support in @Value}")
    private String snakeCaseValue1 = null;
```

#### Config from ENV
`.env`
```bash
ENV_CEBABCASE_VARIABLECASE=CEBAB-CASE
ENV_CAMELCASE_VARIABLECASE=CAMELCASE
ENV_SNAKECASE_VARIABLECASE=SNAKE_CASE

```

### Show example with using variables from yml file
```bash
./start.sh -l inner
```

### Show example with using env variables
```bash
./start.sh -l env
```
