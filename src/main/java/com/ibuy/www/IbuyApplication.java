package com.ibuy.www;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.ibuy.www.util.file.FileSetting;
import com.ibuy.www.util.ftp.FTPSetting;
import com.ibuy.www.util.sftp.SFTPSetting;

@SpringBootApplication
@EnableConfigurationProperties({FTPSetting.class, SFTPSetting.class, FileSetting.class})
public class IbuyApplication {

    public static void main(String[] args) {
        SpringApplication.run(IbuyApplication.class, args);
    }

}
