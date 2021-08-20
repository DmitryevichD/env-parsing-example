package by.dm13y.dm13yexampleenvparsing;

import by.dm13y.dm13yexampleenvparsing.properties.CamelCaseProperties;
import by.dm13y.dm13yexampleenvparsing.properties.CebabCaseProperties;
import by.dm13y.dm13yexampleenvparsing.properties.SnakeCaseProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import java.util.Optional;

@EnableConfigurationProperties
@SpringBootApplication
@RequiredArgsConstructor
public class Dm13yExampleEnvParsingApplication implements CommandLineRunner {
    private final CebabCaseProperties cebabCaseProperties;
    private final SnakeCaseProperties snakeCaseProperties;
    private final CamelCaseProperties camelCaseProperties;

    @Value("${env.value.one-property.in-cebab-case0:}")
    private String cebabCaseValue0 = null;
    @Value("${env.value.one-property.in-cebab-case1:}")
    private String cebabCaseValue1 = null;
    @Value("${env.value.one_property.in_snake_case0:SNAKE_CASE_WORD not support in @Value}")
    private String snakeCaseValue0 = null;
    @Value("${env.value.one_property.in_snake_case1:SNAKE_CASE_WORD not support in @Value}")
    private String snakeCaseValue1 = null;

    @Value("${env.value.oneProperty.inCamelCase:}")
    private String camelCaseValue = null;

    public static void main(String[] args) {
        SpringApplication.run(Dm13yExampleEnvParsingApplication.class, args);
    }

    @Override
    public void run(String... args) {
        System.out.println("Parse variables to Properties file -> (@ConfigurationProperties(prefix = \"env...\")");
        System.out.println(cebabCaseProperties.getVariableCase());
        System.out.println(camelCaseProperties.getVariableCase());
        System.out.println(snakeCaseProperties.getVariableCase());

        System.out.println("Parse variables to Properties file -> (@ConfigurationProperties(prefix = \"env...\")");
        Optional.ofNullable(cebabCaseValue0).ifPresent(System.out::println);
        Optional.ofNullable(cebabCaseValue1).ifPresent(System.out::println);

        Optional.ofNullable(snakeCaseValue0).ifPresent(System.out::println);
        Optional.ofNullable(snakeCaseValue1).ifPresent(System.out::println);

        Optional.ofNullable(camelCaseValue).ifPresent(System.out::println);
    }
}
