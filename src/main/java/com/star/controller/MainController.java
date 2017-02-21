package com.star.controller;

import com.star.model.UserEntity;
import com.star.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.Valid;
import java.util.List;

/**
 * Created by hp on 2017/2/20.
 */
@Controller
public class MainController {
    // 自动装配数据库接口，不需要再写原始的Connection来操作数据库
    @Autowired
    UserRepository userRepository;


    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String index(){
        return "home";
    }

    @RequestMapping(value = "/users",method = RequestMethod.GET)
    public String getUsers(ModelMap modelMap){
        //查询user表中所有记录
        List<UserEntity> userList=userRepository.findAll();
        // 将所有记录传递给要返回的jsp页面，放在model的userList当中
        modelMap.addAttribute("userList",userList);
        // 返回views目录下的admin/users.jsp页面
        return "users";
    }

    @RequestMapping(value = "/users/add" ,method = RequestMethod.GET)
    public String addPage(Model model){
        model.addAttribute("user",new UserEntity());
        return "addPage";
    }

    @RequestMapping(value = "/users/addP" ,method = RequestMethod.POST)
    public String addUser(@Valid UserEntity user, Errors errors){
        System.out.println(errors.hasErrors());
        System.out.println(user.getNickname());
        System.out.println(user.getNickname().length());
        if (errors.hasErrors()){
            return "addPage";
        }
        userRepository.saveAndFlush(user);
        //立即刷新
        return "redirect:/users";
    }

    @RequestMapping(value = "/users/show/{userId}")
    public String showDetail(@PathVariable("userId") Integer userId,Model model){
        model.addAttribute("user",userRepository.findOne(userId));
        return "userDetail";
    }

    @RequestMapping(value = "/users/delete/{userId}")
    public String deleteUser(@PathVariable("userId") Integer userId){
        userRepository.delete(userId);
        userRepository.flush();
        return "redirect:/users";
    }

    @RequestMapping(value = "/users/update/{id}",method = RequestMethod.GET)
    public String updatePage(@PathVariable("id") Integer userId,Model model){
        model.addAttribute("user",userRepository.findOne(userId));
        return "updateUser";
    }

    @RequestMapping(value = "/users/updateP",method = RequestMethod.POST)
    public String updateUser(UserEntity user){
        userRepository.updateUser(user.getNickname(), user.getFirstName(),
                user.getLastName(), user.getPassword(), user.getId());
        userRepository.flush();
        return "redirect:/users";
    }



}
