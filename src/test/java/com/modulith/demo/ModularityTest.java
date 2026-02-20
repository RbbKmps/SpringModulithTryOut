package com.modulith.demo;


import org.junit.jupiter.api.Test;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.modulith.docs.Documenter;

public class ModularityTest {
    ApplicationModules modules = ApplicationModules.of(DemoApplication.class);

    @Test
    public void applicationModulesVerification() {
        modules.forEach(System.out::println);
        modules.verify();
    }

    @Test
    public void generateDocumentation() {
        new Documenter(modules)
                .writeDocumentation();
    }
}