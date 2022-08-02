package com.utility.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.utility.constants.Constants;
import com.utility.models.ShortCutBATVO;
import com.utility.service.ShortCutBATService;

@RestController
public class ShortCutBATController extends ControllerTemplate{

	@Autowired
	private ShortCutBATService shortCutBATService; 
	
	@PostMapping("writeOutShortCutBATFile.do")
	public Map<String, Object> writeOutShortCutBATFile(@RequestParam  String pathWithEXEFile, @RequestParam  String writeOutPath, @RequestParam  String shortCutName) {
		
		respMap = new HashMap<>();
		
		ShortCutBATVO shortCutBATVO = new ShortCutBATVO();
		shortCutBATVO.setPathWithEXEFile(pathWithEXEFile);
		shortCutBATVO.setWriteOutPath(writeOutPath);
		shortCutBATVO.setShortCutName(shortCutName);
		
		respMap.put(Constants.SUCCESS_CONTROLLER, shortCutBATService.writeOutShortCutBATFile(shortCutBATVO));
		
		return respMap;
	}
	
}
