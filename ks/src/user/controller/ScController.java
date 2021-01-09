package user.controller;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import user.entity.*;
import user.service.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller("scController")
@RequestMapping("stu_con")
public class ScController {

    @Autowired
    private ScService scService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private TcService tcService;
    @Autowired
    private TopicService topicService;
    @Autowired
    private TopicpaperService topicpaperService;
    @Autowired
    private StutopicService stutopicService;
    @Autowired
    private PaperService paperService;

    @RequestMapping("/enter")
    public String enter(String courseId, String stuId, HttpSession session){
        Stutopic stutopic=stutopicService.getByStuCourseId(stuId, courseId);
        tran1(stutopic.getTopicId(), courseId, stuId, session);
        return "s_showtopic_stu";
    }
    @RequestMapping("/read")
    public String read(String courseId,String stuId,String topicId,HttpSession session) throws ParseException {
        Stutopic stutopic=new Stutopic();
        stutopic.setStudentId(stuId);
        stutopic.setTopicId(topicId);
        stutopic.setFlag("0");
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //设置日期格式
        String date=df.format(new Date());
        // new Date()为获取当前系统时间
        stutopic.setSelectTime(df.parse(date));
        int id=stutopicService.listAll().size()+1;
        stutopic.setStutopicId(String.valueOf(id));
        stutopicService.insert(stutopic);
        tran1(topicId, courseId, stuId, session);
        return "s_showtopic_stu";
    }
    @RequestMapping("/show")
    public String show(String courseId,String stuId,String topicId,HttpSession session){
        List<Papers> papersList=new ArrayList<>();
        List<Student> studentList=studentService.listAll();
        for (Student student : studentList) {
            Stutopic stutopic = stutopicService.getByStuTopicId(student.getStudentId(), topicId);
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
        //获得当前选题的学生的论文
        tran1(topicId, courseId, stuId, session);
        session.setAttribute("allstu", papersList);
        return "s_showall";
    }

    @RequestMapping("/update")
    public String up(String stuid, String courseid, String topicid, HttpSession session)
    {
        tran1(topicid, courseid, stuid, session);
        return "s_updatefile";
    }

    @RequestMapping("/updatefile")
    public String update(MultipartFile file,HttpSession session) throws ParseException, IOException {
        Student student= (Student) session.getAttribute("now_stu");
        Course course= (Course) session.getAttribute("now_course");
        List<Topic>mytopic= (List<Topic>) session.getAttribute("mytopics");
        String name=file.getOriginalFilename();
        String stuid=student.getStudentId();
        String topicid=mytopic.get(0).getTopicId();
        boolean b=scService.fileImport(name, file,stuid,topicid);
        tran1(mytopic.get(0).getTopicId(), course.getCourseId(), student.getStudentId(), session);
        return "s_mytopic";
    }

    public void tran(String courseId,String stuId,HttpSession session)
    {
        Course course=courseService.getById(courseId);
        session.setAttribute("now_course", course);
        Student student=studentService.getById(stuId);
        session.setAttribute("now_stu", student);
        //mytopic应该只有一项
        List<Topic> mytopics=topicService.listAllTopic(stuId, courseId);
        session.setAttribute("mytopics", mytopics);
        List<Topic> alltopics=topicService.listAllByCourseid(courseId);
        session.setAttribute("alltopics",alltopics );
    }
    public void tran1(String topicId,String courseId,String stuId,HttpSession session)
    {
        tran(courseId, stuId, session);
        Stutopic stutopic=stutopicService.getByStuCourseId(stuId, courseId);
        session.setAttribute("stutopic", stutopic);
        Topic topic=topicService.getById(topicId);
        session.setAttribute("now_topic", topic);
    }
}