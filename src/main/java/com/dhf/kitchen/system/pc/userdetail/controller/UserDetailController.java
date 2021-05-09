package com.dhf.kitchen.system.pc.userdetail.controller;


import com.dhf.kitchen.base.KitResult;
import com.dhf.kitchen.system.pc.login.model.User;
import com.dhf.kitchen.system.pc.userdetail.model.UserDetail;
import com.dhf.kitchen.system.pc.userdetail.model.dto.UserDetailDto;
import com.dhf.kitchen.system.pc.userdetail.service.UserDetailService;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author fangwanjun
 * @since 2020-11-13
 */
@RestController
@RequestMapping("/userDetail")
public class UserDetailController {

    @Autowired
    private UserDetailService userDetailService;

    @GetMapping(value = "/getDetail")
    @RequiresAuthentication
    public KitResult getDetail(String userId) {
        return userDetailService.queryUserDetail(userId);
    }

    /* 获取粉丝量前20 的用户 */
    @GetMapping(value = "/getUserRank")
    public KitResult getUserRank() {
        return userDetailService.getUserRank();
    }

    /* 上传图片 */
    @PostMapping(value = "/static")
    public KitResult loadPhoto(@RequestParam("file") MultipartFile file){

//        String filePath = System.getProperty("user.dir")+"/src/vue/src/static/image/userphoto/"+file.getOriginalFilename();
        String filePath = System.getProperty("user.dir")+"/target/classes/static/image/"+file.getOriginalFilename();
        String filePath1 = System.getProperty("user.dir")+"/src/resources/static/image/"+file.getOriginalFilename();

        File files = new File(filePath);
        File files1 = new File(filePath);
        if (!files.exists()) {
            try {
                files.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (!files1.exists()) {
            try {
                files1.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            file.transferTo(files);
            file.transferTo(files1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return KitResult.succ(null);
    }

    @GetMapping(value = "/setPhoto")
    public KitResult setPhoto(String photo,String id){

        System.out.println(photo+"   "+id);
       return userDetailService.updateUserPhoto(photo,id);
    }

    @GetMapping(value = "/getWorks")
    public KitResult getWorks(String userId) {
        return userDetailService.getWorks(userId);
    }

    @PostMapping(value = "/updateUser")
    public KitResult updateUser(@RequestBody UserDetail userDetail){
        return userDetailService.updateUser(userDetail);
    }
}

