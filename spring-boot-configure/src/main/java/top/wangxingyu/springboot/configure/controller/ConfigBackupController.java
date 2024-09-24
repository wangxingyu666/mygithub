package top.wangxingyu.springboot.configure.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.wangxingyu.springboot.configure.service.ConfigBackupService;

@RestController
@AllArgsConstructor
public  class ConfigBackupController{
    private final ConfigBackupService configBackupService;

    @GetMapping("/backup")
    public void backupConfig(){
        configBackupService.backupConfigFile();
    }
}