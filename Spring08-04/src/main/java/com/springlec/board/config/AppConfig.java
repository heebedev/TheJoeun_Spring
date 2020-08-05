package com.springlec.board.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springlec.board.command.BListCommand;

@Configuration
public class AppConfig {

	@Bean
	public BListCommand list() {
		return new BListCommand();
	}

}
