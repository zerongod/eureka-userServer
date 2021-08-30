package com.example.springdemo.controller;


import com.example.springdemo.entity.User;
import com.example.springdemo.service.UserService;
import com.example.springdemo.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RequestMapping设置的是URL的路径 在controller类上面的  就是接在端口号后面的
@RestController
@RequestMapping("/testBoot")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private GoodService goodService;
    //

    @GetMapping("/findGoodByID")
    public String findGoodByID(int goodID){
        return goodService.findByID(goodID);
    }

    @GetMapping("/selectAllGood")
    public List selectAllGood(){
        return goodService.selectAllGood();
    }
    @RequestMapping(value = "getUser/{id}",method = RequestMethod.GET)
    public String GetUser(@PathVariable int id) {
        return userService.getUserInfo(id).toString();
    }


    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(int id){
        int result = userService.deleteById(id);
        if(result>=1){
            return "delete success";
        }
        return "delete false";

    }

    //
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(User user) {
        int result = userService.Update(user);
        if (result >= 1) {
            return "update success";
        } else {
            return "update false";
        }
    }
    //

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public User insert(User user) {
        return userService.save(user);
    }

    @RequestMapping("/selectAll")


    @ResponseBody
    public List<User> ListUser() {
        return userService.selectAll();
    }

}
