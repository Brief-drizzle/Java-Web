package user.controller;

import gvjava.org.json.JSONException;
import gvjava.org.json.JSONObject;
import netscape.javascript.JSObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import user.entity.*;
import user.service.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ad
 */
@Controller("userController")
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private TcService tcService;

    @RequestMapping(path = "/login",method = RequestMethod.POST)
    public String login(String username, String password, HttpSession session) throws JSONException {
        User user=userService.getById(username);
        if (user==null||!user.getPassword().equals(password)){
            return "loginfail";
        }
        else if (user.getRole()==2){
            Teacher teacher=teacherService.getById(user.getUserId());
            session.setAttribute("teacher",teacher);
            List<Courses> courses=courseService.listAllCourses(teacher.getTeacherId());
            session.setAttribute("m__course",courses);
            return "t_teacher_detailed";
        }
        else if (user.getRole()==3){
            Student student =studentService.getByUserId(user.getUserId());
            session.setAttribute("student",student);
            List<Course> courses=courseService.listAllbyStu(student.getStudentId());
            List<classes> classesList=teacherService.listAllMainTeacher(courses);
            session.setAttribute("my_courses", classesList);
            return "s_showmyclass";
        }
        else
        {
            List<Course> courses=courseService.listAll();
            List<classes> classes=teacherService.listAllMainTeacher(courses);
            session.setAttribute("classes",classes);
            List<Teacher>teachers=teacherService.listAll();
            session.setAttribute("teachers",teachers);
            return "m_manage_class";
        }
    }
    @RequestMapping(path = "/all")
    @ResponseBody
    public Map<String,Object> getAllCourse()
    {
        Map<String,Object> map=new HashMap<String,Object>();
        List<Course> courses=courseService.listAll();
        List<classes> classes=teacherService.listAllMainTeacher(courses);
        map.put("code",0);
        map.put("msg","");
        map.put("count",classes.size());
        map.put("data",classes);
        System.out.println(map);
        return map;
    }
}