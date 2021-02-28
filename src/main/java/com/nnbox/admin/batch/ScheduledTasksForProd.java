package com.nnbox.admin.batch;

import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@Profile("prod")
public class ScheduledTasksForProd {

	@Scheduled(fixedRate = 600000)
	private void scheduleProd1() throws Exception {
		log.debug("scheduleProd1");
	}
}
