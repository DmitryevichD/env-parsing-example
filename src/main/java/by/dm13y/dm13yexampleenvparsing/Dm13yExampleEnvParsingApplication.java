package by.dm13y.dm13yexampleenvparsing;

import by.dm13y.dm13yexampleenvparsing.properties.CamelCaseProperties;
import by.dm13y.dm13yexampleenvparsing.properties.CebabCaseProperties;
import by.dm13y.dm13yexampleenvparsing.properties.SnakeCaseProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties
@SpringBootApplication
@RequiredArgsConstructor
public class Dm13yExampleEnvParsingApplication implements CommandLineRunner {
    private final CebabCaseProperties cebabCaseProperties;
    private final SnakeCaseProperties snakeCaseProperties;
    private final CamelCaseProperties camelCaseProperties;

    public static void main(String[] args) {
        SpringApplication.run(Dm13yExampleEnvParsingApplication.class, args);
    }

    @Override
    public void run(String... args) {
        System.out.println(cebabCaseProperties.getVariableCase());
        System.out.println(camelCaseProperties.getVariableCase());
        System.out.println(snakeCaseProperties.getVariableCase());
    }
}
