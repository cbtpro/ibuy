package com.ibuy.www.util.file;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "file.http")
public class FileSetting {
	private String host;
	private String port;
	private String path;
	public String separator_colon = ":";
	public String separator_divide = "/";
	private String fileUri;
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getFileUri() {
		return this.host + this.separator_colon + this.port + this.separator_divide + this.path + this.separator_divide;
	}
}
