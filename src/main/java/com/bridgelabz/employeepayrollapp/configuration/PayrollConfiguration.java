package com.bridgelabz.employeepayrollapp.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Purpose - To configure the model mapper Bean to application
 *
 * @author LOKESH
 * @version 0.0.1-SNAPSHOT
 * @since 08-12-21
 */
@Configuration
public class PayrollConfiguration {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
