package com.mcy;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StartupApplicationTests {

	@Autowired
	SpringBean bean;

	@Value("${com.mcy.filePath}")
	String file;

	@Test
	public void springBeanLog_whenLevelError_thenReadInfoAndError() throws IOException, InterruptedException {
		bean.log();
		String content = new String(Files.readAllBytes(Paths.get(file)));
		assertTrue(content.contains("INFO  com.mcy.SpringBean - info")
				&& content.contains("ERROR com.mcy.SpringBean - error"));
	}

}
