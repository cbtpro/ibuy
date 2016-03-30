package com.ibuy.www.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.google.gson.Gson;
import com.ibuy.www.util.ftp.FtpUtils;

@RestController
@RequestMapping(value = "/file", produces = { "application/json;charset=UTF-8" })
public class FileController {

	@Autowired
	FtpUtils FtpUtils;
    
	@RequestMapping(value = "uploadImage", method = RequestMethod.POST)
	public String uploadImage(@RequestParam MultipartFile[] files, MultipartHttpServletRequest request, HttpServletResponse response) {
		String fileUri = null;
		List<String> imageList = new ArrayList<>();
		List<String> imageNameList = new ArrayList<>();
		Gson gson = new Gson();
		try {
			for (Iterator<String> iterator = request.getFileNames(); iterator.hasNext();) {
				String imageName = iterator.next();
				MultipartFile mpf = request.getFile(imageName);
				UUID uuid = UUID.randomUUID();
				String fileName = uuid.toString();
				String originalfileName = mpf.getOriginalFilename();
				String fileNameSuffix = originalfileName.substring(originalfileName.lastIndexOf("."), originalfileName.length());
				fileUri = FtpUtils.uploadImage(mpf.getInputStream(), fileName + fileNameSuffix);
				imageList.add(fileUri);
				imageNameList.add(mpf.getOriginalFilename());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < imageNameList.size(); i++) {
			System.out.println(imageNameList.get(i) + "uploaded!");
		}
		return gson.toJson(imageList);
	}
}
