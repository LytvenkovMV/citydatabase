package com.example.citydatabasegateway.configuration;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class RouteLocatorConfig {

    @Bean
    RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("bankserver_route",
                        route -> route.path("/bank/api/**")
                                .uri("lb://bank/api"))
                .route("cityserver_route",
                        route -> route.path("/city/api/**")
                                .uri("lb://city/api"))
                .build();
    }
}
