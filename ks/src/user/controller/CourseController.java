package user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import user.entity.*;
import user.service.CourseService;
import user.service.TcService;
import user.service.TeacherService;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller("courseCotroller")
@RequestMapping("/manager")
public class CourseController {

    @Autowired
    private CourseService courseService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private TcService tcService;

    @RequestMapping("/enter")
    public String enter(String courseId, HttpSession session)
    {
        List<Teachers> teachers=teacherService.listAllTeachers(courseId);
        Course course=courseService.getById(courseId);
        session.setAttribute("m_teacher",teachers);
        session.setAttribute("m_course",course);
        return "m_detailed_class";
    }
    @RequestMapping("/change_class")
    public String change(String courseId,String courseName,String term,Integer courseHour,HttpSession session)
    {
        Course course=new Course();
        course.setCourseId(courseId);
        course.setCourseName(courseName);
        course.setTerm(term);
        course.setCourseHour(courseHour);
        courseService.update(course);
        List<Course> courses=courseService.listAll();
        List<classes> classes=teacherService.listAllMainTeacher(courses);
        session.setAttribute("classes",classes);
        List<Teacher>teachers=teacherService.listAll();
        session.setAttribute("teachers",teachers);
        return "m_manage_class";
    }
    @RequestMapping("/new_class")
    public String inser(HttpSession session)
    {
        int id=courseService.listAll().size()+1;
        String ids="c";
        ids+=String.valueOf(id);
        session.setAttribute("new_course_id", ids);
        return "m_new_class";
    }
    @RequestMapping("/insert")
    public String insert(String courseId,String courseName,String term,Integer courseHour,HttpSession session) throws UnsupportedEncodingException {
        Course course=new Course();
        courseName=new String(courseName.getBytes("ISO-8859-1"),"utf-8");
        course.setCourseId(courseId);
        course.setCourseName(courseName);
        course.setTerm(term);
        course.setCourseHour(courseHour);
        Tc tc=new Tc();
        tc.setCourseId(courseId);
        int id=tcService.listAll().size();
        String ids=String.valueOf(id+1);
        tc.setTcId(ids);
        tc.setTeacherId("0");
        tc.setTeachHour(0);
        tc.setTeaIdentity("Ö÷½²½ÌÊ¦");
        courseService.insert(course);
        tcService.insert(tc);
        List<Course> courses=courseService.listAll();
        List<classes> classes=teacherService.listAllMainTeacher(courses);
        session.setAttribute("classes",classes);
        List<Teacher>teachers=teacherService.listAll();
        session.setAttribute("teachers",teachers);
        return "m_manage_class";
    }
}