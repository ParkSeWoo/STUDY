package sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import sample.filter.ErrorFilter;
import sample.filter.PostFilter;
import sample.filter.PreFilter;
import sample.filter.RouteFilter;

@EnableZuulProxy
@EnableDiscoveryClient
@SpringBootApplication
class ApiZuulGatewayServerApplication {

    @Bean
    public PreFilter preFilter() {
        return new PreFilter();
    }
    @Bean
    public PostFilter postFilter() {
        return new PostFilter();
    }
    @Bean
    public ErrorFilter errorFilter() {
        return new ErrorFilter();
    }
    @Bean
    public RouteFilter routeFilter() {
        return new RouteFilter();
    }

    public static void main(String[] args) {
        SpringApplication.run(ApiZuulGatewayServerApplication.class, args);

    }


}

