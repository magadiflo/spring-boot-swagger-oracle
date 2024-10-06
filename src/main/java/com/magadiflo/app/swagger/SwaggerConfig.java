package com.magadiflo.app.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * El segundo paso es crear el archivo Docket, mediante el cual le indicamos a Swagger que es lo que debe de tomar en
 * cuenta al momento de crear la documentación. Para esto, debemos de crear una clase que esté anotada
 * con @Configuration y @EnableWebMvc y tenga un método que cree el objeto Docket
 * <p>
 * Dentro del método api construimos el objeto Docket, en el cual le indicamos que tome todos los servicios que
 * se encuentre en el paquete com.magadiflo.app y los auto documente por nosotros.
 * <p>
 * Finalmente, en el método getApiInfo, generamos el objeto ApiInfo, el cual define los datos de la propiedad del API,
 * como su nombre, correo de contacto, licencia, etc.
 */

@Configuration
@EnableWebMvc
public class SwaggerConfig implements WebMvcConfigurer {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.magadiflo.app"))
                .paths(PathSelectors.regex("/.*"))
                .build()
                .apiInfo(this.getApiInfo());
    }

    private ApiInfo getApiInfo() {
        return new ApiInfoBuilder().title("Documenta API REST con Swagger")
                .description("API Endpoint Decoration")
                .contact(new Contact("Magadiflo Sys", "https://www.magadiflo-system.com/", "magadiflo@system.com"))
                .license("Apache 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                .version("1.0.0")
                .build();
    }


}
