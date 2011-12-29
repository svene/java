package org.svenehrke.java.misc.processbuilder;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ProcessBuilderTest {
	@Test
	public void testName() throws Exception {
		assertTrue(isUnix());
	}

	@Test
	public void test_on_unix() throws Exception {
		if (!isUnix()) {
			System.out.println("non Unix system test still outstanding");
			return;
		}
		ProcessBuilder pb = new ProcessBuilder("/bin/sh", "-c", "ls /etc/h*");
		final Map<String,String> environment = pb.environment();
		environment.put("HOME", "/home/bart");
		final Process p = pb.start();

		BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));

		String line;
		StringBuilder sb = new StringBuilder();
		while ((line = br.readLine()) != null) {
			System.out.println(line);
			sb.append(line);
			sb.append("\n");
		}
		p.waitFor();
		assertTrue(sb.toString().contains("/etc/hosts"));
	}
	
	private boolean isUnix() {
		return "/".equals(File.separator);
	}
}
