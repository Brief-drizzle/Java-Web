package user.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import user.entity.*;
import user.service.*;

import javax.servlet.http.HttpSession;


@Controller("studentController")
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private ScService scService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private TcService tcService;
    @Autowired
    private TopicService topicService;

    @RequestMapping("/insert")
    public String inser(String courseid, String teacherid, HttpSession session){
        tran(teacherid, courseid, session);
        List<Student> alreadyStudent=new ArrayList<>();
        alreadyStudent=studentService.listAllExcept(courseid);
        session.setAttribute("studentexcept",alreadyStudent);
        //没有选课的学生
        return "t_new_s";
    }
    @RequestMapping("/insertreturn")
    public String insert(String teacherid,String courseid,String stuname,HttpSession session)
    {
        Student student=studentService.getByName(stuname);
        Sc sc=new Sc();
        int id=scService.listAll().size();
        String ids=String.valueOf(id+1);
        sc.setCourseId(courseid);
        sc.setScId(ids);
        sc.setScore(0);
        sc.setStudentId(student.getStudentId());
        scService.insert(sc);
        tran(teacherid, courseid, session);
        return "t_teacher_detailed";
    }
    @RequestMapping("/delete")
    public String dele(String studentid,String courseid,String teacherid, HttpSession session){
        Sc sc=scService.getByCourseStuId(courseid,studentid);
        scService.delete(sc);
        tran(teacherid, courseid, session);
        return "t_teacher_detailed";
    }
    public void tran(String teacherid,String courseid,HttpSession session)
    {
        List<Teacher> teachers=teacherService.listAllByCourseid(courseid);
        session.setAttribute("teacher_course", teachers);
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
}