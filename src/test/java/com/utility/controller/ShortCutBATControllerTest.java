package com.utility.controller;

import com.utility.constants.Constants;
import com.utility.controller.ShortCutBATController;
import com.utility.models.ShortCutBATVO;
import com.utility.service.ShortCutBATService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ShortCutBATControllerTest {

    @InjectMocks
    private ShortCutBATController shortCutBATController;

    @Mock
    private ShortCutBATService shortCutBATService;

    private String pathWithEXEFile = "";

    private String writeOutPath = "";

    private String shortCutName = "";

    @BeforeEach
    public void setup(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testWriteOutShortCutBATFile_validReturn(){

        ShortCutBATVO shortCutBATVO = new ShortCutBATVO();
        shortCutBATVO.setPathWithEXEFile(pathWithEXEFile);
        shortCutBATVO.setWriteOutPath(writeOutPath);
        shortCutBATVO.setShortCutName(shortCutName);

        Mockito.when(shortCutBATService.writeOutShortCutBATFile(shortCutBATVO))
                .thenReturn(true);

         assertTrue((Boolean) shortCutBATController.writeOutShortCutBATFile(pathWithEXEFile, pathWithEXEFile, shortCutName).get(Constants.SUCCESS_CONTROLLER));
    }

}
