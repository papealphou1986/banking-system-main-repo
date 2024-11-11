package com.atongbatechs.bankingapp.customerservice;


import com.atongbatechs.bankingapp.customerservice.configs.GlobalConfigs;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;


import java.util.List;

@SpringBootApplication
@EnableConfigurationProperties(GlobalConfigs.class)
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }
   /*
    @Bean
    CommandLineRunner init(CustomerService customerService) {
        return args -> {
            customerService.saveAllCustomers(
                    List.of(
                            CustomerDtoRequest.builder()
                                    .firstName("Alphousseyni")
                                    .lastName("Mané")
                                    .email("alphousseyni@gmail.com")
                                    .build(),
                            CustomerDtoRequest.builder()
                                    .firstName("Pape")
                                    .lastName("Mansaly")
                                    .email("pape@gmail.com")
                                    .build(),
                            CustomerDtoRequest.builder()
                                    .firstName("Bireum")
                                    .lastName("Seck")
                                    .email("bireum@gmail.com")
                                    .build(),
                            CustomerDtoRequest.builder()
                                    .firstName("Alassane")
                                    .lastName("Sadio")
                                    .email("alou@gmail.com")
                                    .build()
                    )
            );
        };
    }
   */
}
