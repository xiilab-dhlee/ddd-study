package com.ide.common.event;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EventsConfiguration {

    @Bean
    public InitializingBean eventsInitializer(ApplicationContext applicationContext) {
        return () -> Events.setPublisher(applicationContext);
    }
}

