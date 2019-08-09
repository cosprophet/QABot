package com.se1405.service;

import org.glassfish.jersey.server.ResourceConfig;

public class QABot extends ResourceConfig{
	public QABot() {
        register(QABotService.class);
        register(CorsFilter.class);
    }
}
