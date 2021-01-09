package users.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import users.pojo.Userpojo;
import users.service.Userservice;

@Controller("userController")
@RequestMapping(path = "/Controller")
public class Usercontroller {
        @Autowired
        private Userservice userservice;

    @RequestMapping(path = "/Liuyan",method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView liuyan(String name, String word)
    {
        Userpojo userpojo1=new Userpojo();
        userpojo1.setUsername(name);
        userpojo1.setWord(word);
        userservice.insert(userpojo1);
        ModelAndView modelAndView =new ModelAndView();
        modelAndView.addObject("liuyanbean",userpojo1);
        modelAndView.setViewName("inputOk");
        return modelAndView;
    }
}
