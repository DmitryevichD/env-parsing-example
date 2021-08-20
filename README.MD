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
