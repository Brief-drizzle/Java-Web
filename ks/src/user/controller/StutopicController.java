package user.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import user.entity.*;
import user.service.*;

import javax.servlet.http.HttpSession;


@Controller("stutopicController")
@RequestMapping("/stu_to")
public class StutopicController {

    @Autowired
    private StutopicService stutopicService;
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
    @Autowired
    private PaperService paperService;

    @RequestMapping("/enter")
    public String enter(String stuname, String teacherid, String courseid, HttpSession session)
    {
        Student student =studentService.getByName(stuname);
        session.setAttribute("student", student);
        List<Topic> topics=topicService.listAllTopic(student.getStudentId(),courseid);
        session.setAttribute("s_topic", topics);
        tran(teacherid, courseid, session);
        List<Teacher> teachers=teacherService.listAllByCourseid(courseid);
        session.setAttribute("teachers", teachers);
        return "t_showtopic_s";
    }
    @RequestMapping("/enter_topic")
    public String enters(String studentid,String teacherid,String topicname,String courseid,HttpSession session)
    {
        Topic topic=topicService.getByName(topicname);
        List<Paper> papers=paperService.listAllPaper(studentid,topic.getTopicId());
        session.setAttribute("s_papers", papers);
        session.setAttribute("now_topic", topic);
        tran(teacherid, courseid, session);
        return "t_showtopic_s_paper";
    }



    public void tran(String teacherid, String courseid, HttpSession session)
    {
        List<Teacher> teachers=teacherService.listAllExcept(courseid);
        session.setAttribute("teachers", teachers);
        List<Teachers> teachersList=teacherService.listAllteaBycourseId(courseid);
        session.setAttribute("tea_courses", teachersList);
        List<Teacher> teachers1=teacherService.listAllByCourseid(courseid);
        session.setAttribute("teacher_course", teachers1);
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
        if ("Ö÷½²½ÌÊ¦".equals(tc.getTeaIdentity())) {
            topics=topicService.listAllByCourseid(courseid);
        }
        else {
            topics=topicService.listAllByCourseTeaId(courseid, teacherid);
        }
        session.setAttribute("t_to", topics);
    }
}