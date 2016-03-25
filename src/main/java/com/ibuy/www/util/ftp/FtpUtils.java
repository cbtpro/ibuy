package com.ibuy.www.util.ftp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ibuy.www.util.file.FileSetting;

@Component(value = "FtpUtils")
public class FtpUtils {

	@Autowired
	FTPSetting FTPSetting;
	@Autowired
	FileSetting FileSetting;
	
	public String uploadImage(InputStream input, String fileName) {
        String ftpHost = FTPSetting.getHost();
        String port = FTPSetting.getPort();
        String ftpUserName = FTPSetting.getUsername();
        String ftpPassword = FTPSetting.getPassword();
        String ftpPath = FTPSetting.getPath();
        int ftpPort = FTPSetting.SFTP_DEFAULT_PORT;
        if (port != null && !port.equals("")) {
            ftpPort = Integer.valueOf(port);
        }
		uploadFile(ftpHost, ftpPort, ftpUserName, ftpPassword, ftpPath, fileName, input);
		return FileSetting.getFileUri() + fileName;
	}
	/**
	* Description: 向FTP服务器上传文件
	* @param url FTP服务器 hostname
	* @param port FTP服务器端口 默认端 21
	* @param username FTP登录账号
	* @param password FTP登录密码
	* @param path FTP服务器保存目录
	* @param filename 上传到FTP服务器上的文件名
	* @param input 输入流
	* @return 成功返回true，否则返回false
	*/ 
	public boolean uploadFile(String url,int port,String username, String password, String path, String filename, InputStream input) { 
	    boolean success = false; 
	    FTPClient ftp = new FTPClient(); 
	    try { 
	        int reply; 
	        ftp.connect(url, port);//连接FTP服务器 
//	        ftp.connect(url);//连接FTP服务器 
	        //如果采用默认端口，可以使用ftp.connect(url)的方式直接连接FTP服务器 
	        ftp.login(username, password);//登录 
	        reply = ftp.getReplyCode(); 
	        if (!FTPReply.isPositiveCompletion(reply)) {
	            ftp.disconnect(); 
	            return success; 
	        }
	        ftp.setFileType(FTP.BINARY_FILE_TYPE);
	        ftp.changeWorkingDirectory(path); 
	        ftp.storeFile(filename, input);
	         
	        input.close(); 
	        ftp.logout(); 
	        success = true; 
	    } catch (IOException e) { 
	        e.printStackTrace(); 
	    } finally { 
	        if (ftp.isConnected()) { 
	            try { 
	                ftp.disconnect(); 
	            } catch (IOException ioe) { 
	            } 
	        } 
	    } 
	    return success;  
}
	
	/**
	* Description: 从FTP服务器下载文件
	* @param url FTP服务器hostname
	* @param port FTP服务器端口
	* @param username FTP登录账号
	* @param password FTP登录密码
	* @param remotePath FTP服务器上的相对路径
	* @param fileName 要下载的文件名
	* @param localPath 下载后保存到本地的路径
	* @return
	*/ 
	public boolean downFile(String url, int port,String username, String password, String remotePath,String fileName,String localPath) { 
	    boolean success = false; 
	    FTPClient ftp = new FTPClient();
	    try { 
	        int reply; 
	        ftp.connect(url, port); 
	        //如果采用默认端口，可以使用ftp.connect(url)的方式直接连接FTP服务器 
	        ftp.login(username, password);//登录 
	        reply = ftp.getReplyCode(); 
	        if (!FTPReply.isPositiveCompletion(reply)) { 
	            ftp.disconnect(); 
	            return success; 
	        } 
	        ftp.changeWorkingDirectory(remotePath);//转移到FTP服务器目录 
	        FTPFile[] fs = ftp.listFiles(); 
	        for(FTPFile ff:fs){ 
	            if(ff.getName().equals(fileName)){ 
	                File localFile = new File(localPath+"/"+ff.getName()); 
	                OutputStream is = new FileOutputStream(localFile);  
	                ftp.retrieveFile(ff.getName(), is); 
	                is.close(); 
	            } 
	        } 
	         
	        ftp.logout(); 
	        success = true; 
	    } catch (IOException e) { 
	        e.printStackTrace(); 
	    } finally { 
	        if (ftp.isConnected()) { 
	            try { 
	                ftp.disconnect(); 
	            } catch (IOException ioe) { 
	            } 
	        } 
	    } 
	    return success; 
	}
//	public static void main(String[] args) throws Exception {
//		FtpUtils ftpUtils = new FtpUtils();
//		// =======上传测试============
////		String localFile = "/Users/peter/Downloads/20151201191854_ff8fef.jpg";
////		String url = "www.ouronghui.com";
////		int port = 21;
////		String username ="peter";
////		String password = "peter_@_PETER";
////		String path ="/mnt/ftp/peter/";
////		String filename ="20151201191854_ff8fef.jpg";
////		InputStream input = new FileInputStream(new File(localFile));
////		ftpUtils.uploadFile(url, port, username, password, path, filename, input);
//		// =======上传测试============
//		
//		// =======下载测试============
////		String localPath = "/Users/peter/Downloads";
////		String url = "www.ouronghui.com";
////		int port = 21;
////		String username ="peter";
////		String password ="peter_@_PETER";
////		String remotePath ="/mnt/ftp/peter/";
////		String fileName = "9f697f2ac65c10381789a26cb7119313b17e8966.jpg";
////		ftpUtils.downFile(url, port, username, password, remotePath, fileName, localPath);
//		// =======下载测试============
//		
//	}	
}
