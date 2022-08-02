package com.utility.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.utility.models.ShortCutBATVO;
import com.utility.service.ShortCutBATService;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

}
