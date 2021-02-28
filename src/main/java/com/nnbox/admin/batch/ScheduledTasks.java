package com.nnbox.admin.batch;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ScheduledTasks {

	@Scheduled(fixedRate = 300000)
	private void schedule1() throws Exception {
		log.debug("schedule1");
	}
	@Scheduled(cron = "0 * * * * *")
	private void schedule2() throws Exception {
		log.debug("schedule2");
	}
}