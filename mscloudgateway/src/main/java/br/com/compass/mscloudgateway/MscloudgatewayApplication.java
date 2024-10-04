package br.com.compass.mscloudgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class MscloudgatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(MscloudgatewayApplication.class, args);
	}

	@Bean //Toda vez que acessar a rota ele vai
	public RouteLocator routes(RouteLocatorBuilder builder) {
		return builder
				.routes() //Toda vez que receber uma requisição dessa vai jogar pro loadbalancear pra gerenciar o miscroserviço de clientes
					.route(r -> r.path("/clientes/**").uri("lb://msclientes") )
				.build();
	}

}


