package com.utility;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.utility.controller.ShortCutBATController;

@SpringBootTest
class BatFileShortCutGeneratorApplicationTests {

	@Autowired
	private ShortCutBATController shortCutBATController;

	private static final String TEST_RESOURCES = "./src/test/resources/";

    private static final String TEST_EXE_FILE = "./src/test/resources/testFile.exe";

	@Test
	public void testWriteOutShortCutBATFile_testEndtoEnd(){
		assertNotNull(shortCutBATController.writeOutShortCutBATFile(TEST_EXE_FILE, TEST_RESOURCES, "shortCut"));
	}


}