package com.ibuy.www.controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.ibuy.www.util.ftp.FtpUtils;

@RestController
@RequestMapping(value = "/file", produces = { "application/json;charset=UTF-8" })
public class FileController {

	@Autowired
	FtpUtils FtpUtils;
    
	@RequestMapping(value = "uploadImage", method = RequestMethod.POST)
	public String uploadImage(@RequestParam MultipartFile[] files, MultipartHttpServletRequest request, HttpServletResponse response) {
		Iterator<String> itr = request.getFileNames();
		MultipartFile mpf = request.getFile(itr.next());
		String fileUri = null;
		UUID uuid = UUID.randomUUID();
		String fileName = uuid.toString();
		try {
			String originalfileName = mpf.getOriginalFilename();
			String fileNameSuffix = originalfileName.substring(originalfileName.lastIndexOf("."), originalfileName.length());
			fileUri = FtpUtils.uploadImage(mpf.getInputStream(), fileName + fileNameSuffix);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(mpf.getOriginalFilename() + " uploaded!");
		return fileUri;
	}
}
