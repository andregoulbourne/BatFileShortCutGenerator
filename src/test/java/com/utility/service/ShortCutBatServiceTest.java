package com.utility.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.utility.models.ShortCutBATVO;

class ShortCutBatServiceTest {

    private ShortCutBATService shortCutBATService;

    private static final String TEST_RESOURCES = "./src/test/resources/";

    private static final String TEST_EXE_FILE = "./src/test/resources/testFile.exe";

    @BeforeEach
    public void setup(){
        shortCutBATService = new ShortCutBATService();
    }

    @Test
    void testWriteOutShortCutBATFile_testReturnValid(){
        assertFalse(shortCutBATService.writeOutShortCutBATFile(null));

        ShortCutBATVO shortCutBATVO = new ShortCutBATVO();
        shortCutBATVO.setWriteOutPath(TEST_RESOURCES);
        shortCutBATVO.setPathWithEXEFile(TEST_EXE_FILE);
        shortCutBATVO.setShortCutName("shortCut");

        assertTrue(shortCutBATService.writeOutShortCutBATFile(shortCutBATVO));
    }

    @Test
    void testGetExistingBatFiles_testReturnValid(){
        assertEquals(2,shortCutBATService.getExistingBatFiles(TEST_RESOURCES).size());
        assertEquals(0,shortCutBATService.getExistingBatFiles("/SomeNonExistentFolderPath").size());
    }
    
}
