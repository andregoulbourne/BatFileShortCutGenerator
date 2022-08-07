package com.utility.service;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.utility.constants.Constants;
import com.utility.models.ShortCutBATVO;

@Service
public class ShortCutBATService {

	private static Logger logger = Logger.getLogger(ShortCutBATService.class);

	public boolean writeOutShortCutBATFile(ShortCutBATVO shortCutBATVO) {
		try (PrintWriter writer = new PrintWriter(
				new File(shortCutBATVO.getWriteOutPath() +File.separator+shortCutBATVO.getShortCutName() + ".bat"), "UTF-8")) {
			writer.println(Constants.HEADER_SERVICE);
			writer.println(Constants.START_SERVICE + shortCutBATVO.getPathWithEXEFile());
			logger.info("Finished Writing out BAT file ... ");
			return true;
		} catch (Exception e) {
			logger.error("An Exception occured while writing out BAT file ... ", e);
		}
		return false;
	}

    public List<String> getExistingBatFiles(String folderPath) {
		List<String> listOfBatFileNames = new ArrayList<>();

		File dir = new File(folderPath);
		File[] directoryListing = dir.listFiles();
		if (directoryListing != null) {
			for (File file : directoryListing) {
				if(file.getName().contains(".bat"))
					listOfBatFileNames.add(file.getName());
			}
			logger.info("Finish searching directory for bat files ...");
		} else {
			logger.error("Directory could not be found ...");
		}
		return listOfBatFileNames;
    }

}
