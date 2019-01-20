package com.mcy;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class SpringBean {

//	private static Logger log = LoggerFactory.getLogger(SpringBean.class);

	@PostConstruct
	public void log() {
		log.debug("debug");
		log.info("info");
		log.error("error");
	}

}
