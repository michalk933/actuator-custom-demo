package com.example.actuatorcustomdemo.configuration;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.config.MeterFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MeterRegistryConfiguration {

    @Bean
    MeterRegistryCustomizer<MeterRegistry> meterRegistryMeterRegistryCustomizer(@Value("${REGION:us-west}") String region){
        return registry -> registry.config().commonTags("region", region);
    }

    @Bean
    MeterFilter meterFilter(){
        return MeterFilter.denyNameStartsWith("jvm");
    }

}
