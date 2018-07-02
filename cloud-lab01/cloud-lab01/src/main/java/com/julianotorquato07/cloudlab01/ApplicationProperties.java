package com.julianotorquato07.cloudlab01;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationProperties {

    @Value("${application.autor}")
    String autor;

    @Value("${application.idade}")
    String idade;

}
