package sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;


@RestController
@EnableDiscoveryClient
@SpringBootApplication
public class ProductServiceApplication {
    @RequestMapping(value = "/echoCarName/{name}")
    public String echoCarName(@PathVariable(name = "name") String name) {
        return "hello  <strong style=\"color: red;\">" + name + " </strong> Responsed on : " + new Date();
    }

    @RequestMapping(value = "/getCarDetails/{name}")
    public Car getCarDetails(@PathVariable(name = "name") String name) {
        return new Car(name, "hatchback", "chevrolet");
    }

    @RequestMapping(value = "/products")
    public String ProductResource () {
        return "hello  <strong style=\"color: red;\"> Product Service </strong> Responsed on : " + new Date();
    }

    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);
    }
}

class Car {
    String name;
    String type;
    String company;

    public Car(String name, String type, String company) {
        super();
        this.name = name;
        this.type = type;
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getCls() {
        return company;
    }
}