package com.proyecto.ticketplus.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.proyecto.ticketplus.services.IUsersService;

@Configuration
@EnableScheduling
public class ScheduleTasks {
	@Autowired
	private IUsersService userService;
	
	@Scheduled(cron = "0 0 3 * * ?")
    private void cleanTokensScheduled() {
        try {
            userService.cleanTokens();
            
            System.out.println("Scheduled Token cleaning");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}