package user.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import user.entity.*;
import user.service.*;

import javax.servlet.http.HttpSession;


@Controller("tcController")
@RequestMapping("/t_manage")
public class TcController {

    @Autowired
    private TcService tcService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private UserService userService;
    @Autowired
    private ScService scService;
    @Autowired
    private TopicService topicService;

    @RequestMapping("/insert")
    public String inser(String teaid,String courseid, HttpSession session)
    {
        tran1(teaid, courseid, session);
        List<Teacher> teachers=teacherService.listAllExcept(courseid);
        session.setAttribute("teachers", teachers);
        return "t_new_t";
    }
    @RequestMapping("/insert_check")
    public String insercheck(String courseid,String coursename,String teacherName,String courseHour,String teaIden,HttpSession session) throws UnsupportedEncodingException {
        teacherName=new String(teacherName.getBytes("ISO-8859-1"),"utf-8");
        Teacher teacher=teacherService.getByName(teacherName);
        teaIden=new String(teaIden.getBytes("ISO-8859-1"),"utf-8");
        Course course=courseService.getById(courseid);
        Tc tc=new Tc();
        tc.setTeaIdentity(teaIden);
        tc.setTeachHour(Integer.parseInt(courseHour));
        int id=tcService.listAll().size();
        String ids=String.valueOf(id+1);
        tc.setTcId(ids);
        tc.setTeacherId(teacher.getTeacherId());
        tc.setCourseId(courseid);
        int al=0;
        List<Tc> tcs=new ArrayList<>();
        tcs=tcService.getByCourseId(courseid);
        for (Tc tc1 : tcs) {
            al += tc1.getTeachHour();
        }
        if (al+Integer.parseInt(courseHour)>course.getCourseHour())
        {
            tran(teacher.getTeacherId(), courseid, session);
            List<Teacher> teachers=teacherService.listAllExcept(courseid);
            session.setAttribute("teachers", teachers);
            return "t_new_t_fail";
        }
        else
        {
            tcService.insert(tc);
            List<Teacher> teachers=teacherService.listAllExcept(courseid);
            session.setAttribute("teachers", teachers);
            tran(teacher.getTeacherId(), courseid, session);
            return "t_showteacher";
        }
    }

    @RequestMapping("/change")
    public String change(String courseid,String teaid,String teacherid,HttpSession session)
    {
        //teaid->登录用户，teacherid->修改用户
        tran1(teaid, courseid, session);
        Teacher teacher=teacherService.getByteacherId(teacherid);
        session.setAttribute("change_tea", teacher);
        Tc tc=tcService.getByteachercourseId(courseid,teacherid);
        session.setAttribute("t_tc",tc);
        return "t_manage_t";
    }
    @RequestMapping("/change_check")
    public String change_check(String teaid,String teacherid,String courseId,String courseHour,HttpSession session)
    {
        //teaid->登录用户，teacherid->修改用户
        Course course=courseService.getById(courseId);
        Tc tc=tcService.getByteachercourseId(courseId, teacherid);
        tc.setTeachHour(Integer.parseInt(courseHour));
        List<Tc> tcs=new ArrayList<>();
        int al=0;
        tcs=tcService.getByCourseId(courseId);
        for (Tc tc1 : tcs) {
            al += tc1.getTeachHour();
        }
        if (al+Integer.parseInt(courseHour)>course.getCourseHour()){
            tran1(teaid, courseId, session);
            Teacher teacher=teacherService.getByteacherId(teacherid);
            session.setAttribute("change_tea", teacher);
            Tc tc1=tcService.getByteachercourseId(courseId,teacherid);
            session.setAttribute("t_tc",tc1);
            return "t_manage_t_fail";
        }
        else {
            tcService.update(tc);
            List<Teacher> teachers=teacherService.listAllExcept(courseId);
            session.setAttribute("teachers", teachers);
            tran(teaid, courseId, session);
            return "t_showteacher";
        }
    }

    @RequestMapping("/delete")
    public String delet(String courseid,String teaid,String teacherid,HttpSession session)
    {
        //teaid->登录用户，teacherid->修改用户
        Tc tc=tcService.getByteachercourseId(courseid, teacherid);
        if ("团队教师".equals(tc.getTeaIdentity())){
            tcService.delete(tc);
        }
        List<Teacher> teachers=teacherService.listAllExcept(courseid);
        session.setAttribute("teachers", teachers);
        tran(teaid, courseid, session);
        return "t_showteacher";
    }

    public void tran1(String teacherid,String courseid,HttpSession session)
    {
        List<Teacher> teachers1=teacherService.listAllExcept(courseid);
        session.setAttribute("teachers", teachers1);
        List<Teachers> teachers=teacherService.listAllteaBycourseId(courseid);
        session.setAttribute("teacher_course", teachers);
        List<Teachers> teachersList=teacherService.listAllteaBycourseId(courseid);
        session.setAttribute("tea_courses", teachersList);
        Teacher teacher=teacherService.getByteacherId(teacherid);
        session.setAttribute("teacher",teacher);
        Course course=courseService.getById(courseid);
        session.setAttribute("t_c",course);
        Tc tc=tcService.getByteachercourseId(courseid,teacherid);
        session.setAttribute("t_tc",tc);
        List<students> studentsList=scService.listAllBycourse(courseid);
        session.setAttribute("t_s",studentsList);
        List<Courses> courses=courseService.listAllCourses(teacher.getTeacherId());
        session.setAttribute("m__course",courses);
        List<Topic> topics=new ArrayList<>();
        if ("主讲教师".equals(tc.getTeaIdentity())) {
            topics=topicService.listAllByCourseid(courseid);
        }
        else {
            topics=topicService.listAllByCourseTeaId(courseid, teacherid);
        }
        session.setAttribute("t_to", topics);
    }

    //返回show——teacher
    public void tran(String teacherid,String courseid,HttpSession session)
    {
        List<Teacher> teachers1=teacherService.listAllExcept(courseid);
        session.setAttribute("teachers", teachers1);
        List<Teachers> teachers=teacherService.listAllteaBycourseId(courseid);
        session.setAttribute("teacher_course", teachers);
        List<Teachers> teachersList=teacherService.listAllteaBycourseId(courseid);
        session.setAttribute("tea_courses", teachersList);
        Teacher teacher=teacherService.getByteacherId(teacherid);
        session.setAttribute("teacher",teacher);
        Course course=courseService.getById(courseid);
        session.setAttribute("t_c",course);
        Tc tc=tcService.getByteachercourseId(courseid,teacherid);
        session.setAttribute("t_tc",tc);
        List<students> studentsList=scService.listAllBycourse(courseid);
        session.setAttribute("t_s",studentsList);
        List<Courses> courses=courseService.listAllCourses(teacher.getTeacherId());
        session.setAttribute("m__course",courses);
    }
}