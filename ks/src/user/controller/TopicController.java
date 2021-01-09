package user.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import user.entity.*;
import user.service.*;

import javax.servlet.http.HttpSession;


@Controller("topicController")
@RequestMapping("/topic")
public class TopicController {

    @Autowired
    private TopicService topicService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private TcService tcService;
    @Autowired
    private ScService scService;
    @Autowired
    private StutopicService stutopicService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private TopicpaperService topicpaperService;
    @Autowired
    private PaperService paperService;

    @RequestMapping("/insert")
    public String inser(String courseid, String teacherid, HttpSession session)
    {
        tran(teacherid, courseid, session);
        return "t_new_to";
    }
    @RequestMapping("/insertreturn")
    public String insert(String courseid, String teacherid, String topicname,String keyword,HttpSession session) throws ParseException {
        Topic topic=new Topic();
        int id=topicService.listAll().size();
        String ids="t";
        ids+=String.valueOf(id+1);
        topic.setTopicId(ids);
        topic.setTopic(topicname);
        topic.setTeacherId(teacherid);
        topic.setCourseId(courseid);
        topic.setKeyword(keyword);
        topic.setStudentNum(0);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //设置日期格式
        String date=df.format(new Date());
        // new Date()为获取当前系统时间
        topic.setCreationTime(df.parse(date));
        topicService.insert(topic);

        tran(teacherid, courseid, session);
        return "t_showtopic";
    }
    @RequestMapping("/showstu")
    public String show(String teacherid,String courseid,HttpSession session,String topicid)
    {
        List<Stutopic>stutopicList=stutopicService.listByTopicid(topicid);
        session.setAttribute("allstudent", stutopicList);
        List<Student>students=studentService.listAll();
        session.setAttribute("allstudents", students);
        tran(teacherid, courseid, session);
        return "t_showtopic_detailed";
    }
    @RequestMapping("/showpaper")
    public String showp(String teacherid,String courseid,HttpSession session,String topicid,String stuid)
    {
        List<Papers> papersList=new ArrayList<>();
        List<Student> studentList=studentService.listAll();
        for (Student student : studentList) {
            Stutopic stutopic = stutopicService.getByStuTopicId(student.getStudentId(), topicid);
            if(stutopic!=null){
                if (topicpaperService.getByStutopicId(stutopic.getStutopicId()) != null) {
                    List<Topicpaper> topicpaper = topicpaperService.getByStutopicId(stutopic.getStutopicId());
                    for (Topicpaper value : topicpaper) {
                        Papers papers = new Papers();
                        papers.setPaper(paperService.getById(value.getPaperId()));
                        papers.setStudent(student);
                        papersList.add(papers);
                    }
                }
            }
        }
        Topic topic=topicService.getById(topicid);
        session.setAttribute("now_topic", topic);
        tran(teacherid, courseid, session);
        session.setAttribute("allstu", papersList);
        return "t_showtopic_detailedpaper";
    }

    public void tran(String teacherid,String courseid,HttpSession session)
    {
        List<Teacher> teachers1=teacherService.listAllExcept(courseid);
        session.setAttribute("teachers", teachers1);
        List<Teacher> teachers2=teacherService.listAll();
        session.setAttribute("allteachers",teachers2);
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
}