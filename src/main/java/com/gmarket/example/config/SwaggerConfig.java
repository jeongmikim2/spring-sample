//package com.gmarket.example.config;
//
//import org.springframework.boot.actuate.autoconfigure.endpoint.web.CorsEndpointProperties;
//import org.springframework.boot.actuate.autoconfigure.endpoint.web.WebEndpointProperties;
//import org.springframework.boot.actuate.autoconfigure.web.server.ManagementPortType;
//import org.springframework.boot.actuate.endpoint.ExposableEndpoint;
//import org.springframework.boot.actuate.endpoint.web.*;
//import org.springframework.boot.actuate.endpoint.web.annotation.ControllerEndpointsSupplier;
//import org.springframework.boot.actuate.endpoint.web.annotation.ServletEndpointsSupplier;
//import org.springframework.boot.actuate.endpoint.web.servlet.WebMvcEndpointHandlerMapping;
//import org.springframework.core.env.Environment;
//import org.springframework.util.StringUtils;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger.web.DocExpansion;
//import springfox.documentation.swagger.web.ModelRendering;
//import springfox.documentation.swagger.web.OperationsSorter;
//import springfox.documentation.swagger.web.TagsSorter;
//import springfox.documentation.swagger.web.UiConfiguration;
//import springfox.documentation.swagger.web.UiConfigurationBuilder;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//
//@Configuration
//@EnableSwagger2
//public class SwaggerConfig implements WebMvcConfigurer {
//
//  @Bean
//  public Docket docket() {
//    return new Docket(DocumentationType.SWAGGER_2)
//      .useDefaultResponseMessages(false)
//      .select()
//      .apis(RequestHandlerSelectors.basePackage("com.gmarket.example.controller"))
//      .paths(PathSelectors.ant("/**"))
//      .build();
//  }
//
//  @Bean
//  UiConfiguration uiConfig() {
//    return UiConfigurationBuilder.builder()
//      .deepLinking(true)
//      .displayOperationId(false)
//      .defaultModelsExpandDepth(1)
//      .defaultModelExpandDepth(1)
//      .defaultModelRendering(ModelRendering.EXAMPLE)
//      .displayRequestDuration(false)
//      .docExpansion(DocExpansion.NONE)
//      .filter(false)
//      .maxDisplayedTags(null)
//      .operationsSorter(OperationsSorter.ALPHA)
//      .showExtensions(false)
//      .showCommonExtensions(false)
//      .tagsSorter(TagsSorter.ALPHA)
//      .supportedSubmitMethods(UiConfiguration.Constants.DEFAULT_SUBMIT_METHODS)
//      .validatorUrl(null)
//      .build();
//  }
//
//  @Override
//  public void addResourceHandlers(ResourceHandlerRegistry registry) {
//    registry
//      .addResourceHandler("/swagger-ui/**")
//      .addResourceLocations("classpath:/META-INF/resources/webjars/springfox-swagger-ui/")
//      .resourceChain(false);
//  }
//
//  @Override
//  public void addViewControllers(ViewControllerRegistry registry) {
//    registry.addRedirectViewController("/", "/swagger-ui/index.html");
//  }
//
//  // Springfox-boot-starter 3.0 버전과 Spring boot actuator 호환하기 위한 설정
//  @Bean
//  public WebMvcEndpointHandlerMapping webMvcEndpointHandlerMapping(
//    WebEndpointsSupplier webEndpointsSupplier,
//    ServletEndpointsSupplier servletEndpointsSupplier,
//    ControllerEndpointsSupplier controllerEndpointsSupplier,
//    EndpointMediaTypes endpointMediaTypes,
//    CorsEndpointProperties corsEndpointProperties,
//    WebEndpointProperties webEndpointProperties,
//    Environment environment
//  ) {
//    List<ExposableEndpoint<?>> allEndpoints = new ArrayList<>();
//    Collection<ExposableWebEndpoint> webEndpoints = webEndpointsSupplier.getEndpoints();
//
//    allEndpoints.addAll(webEndpoints);
//    allEndpoints.addAll(servletEndpointsSupplier.getEndpoints());
//    allEndpoints.addAll(controllerEndpointsSupplier.getEndpoints());
//
//    String basePath = webEndpointProperties.getBasePath();
//    EndpointMapping endpointMapping = new EndpointMapping(basePath);
//
//    boolean shouldRegisterLinksMapping = this.shouldRegisterLinksMapping(webEndpointProperties, environment, basePath);
//
//    return new WebMvcEndpointHandlerMapping(endpointMapping, webEndpoints, endpointMediaTypes,
//      corsEndpointProperties.toCorsConfiguration(), new EndpointLinksResolver(allEndpoints, basePath),
//      shouldRegisterLinksMapping, null);
//  }
//
//  private boolean shouldRegisterLinksMapping(WebEndpointProperties webEndpointProperties, Environment environment, String basePath) {
//    return webEndpointProperties.getDiscovery().isEnabled() &&
//      (StringUtils.hasText(basePath) || ManagementPortType.get(environment).equals(ManagementPortType.DIFFERENT));
//  }
//  // Springfox-boot-starter 3.0 버전과 Spring boot actuator 호환하기 위한 설정
//
//}
