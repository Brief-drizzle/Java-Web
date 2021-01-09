package user.controller;

import java.io.UnsupportedEncodingException;
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


@Controller("teacherController")
@RequestMapping("/m_teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private UserService userService;
    @Autowired
    private TcService tcService;
    @Autowired
    private ScService scService;
    @Autowired
    private TopicService topicService;

    //教师详情界面传参
    @RequestMapping("/enter")
    public String enter(String teacherId, HttpSession session)
    {
        List<Courses> courses=courseService.listAllCourses(teacherId);
        Teacher teacher=teacherService.getByteacherId(teacherId);
        session.setAttribute("m__course",courses);
        session.setAttribute("m__teacher",teacher);
        List<Teacher>teachers=teacherService.listAll();
        session.setAttribute("teachers",teachers);
        return "m_detailed_teacher";
    }
    //修改老师信息
    @RequestMapping("/change_teacher")
    public String change(String teacherid,String teacherName,String sex,String protitle,String phone,String userid,HttpSession session) throws UnsupportedEncodingException {
        Teacher teacher=new Teacher();
        teacherName=new String(teacherName.getBytes("ISO-8859-1"),"utf-8");
        protitle=new String(protitle.getBytes("ISO-8859-1"),"utf-8");
        teacher.setTeacherId(teacherid);
        teacher.setName(teacherName);
        teacher.setSex(sex);
        teacher.setProtitle(protitle);
        teacher.setPhone(phone);
        teacher.setUserId(userid);
        teacherService.update(teacher);
        List<Teacher>teachers=teacherService.listAll();
        session.setAttribute("teachers",teachers);
        return "m_manage_teacher";
    }
    //跳转
    @RequestMapping("new_teacher")
    public String inser(HttpSession session)
    {
        String uid="tea";
        int uids=teacherService.listAll().size()+1;
        uid+=String.valueOf(uids);
        int tids=991210+teacherService.listAll().size()+1;
        String tid=String.valueOf(tids);
        session.setAttribute("teaid", tid);
        session.setAttribute("uid", uid);
        return "m_new_teacher";
    }
    //新建老师信息
    @RequestMapping("/insert")
    public String insert(String userid,String teacherid,String teachername,String sex,String protitle,String phone,HttpSession session) throws UnsupportedEncodingException {
        Teacher teacher=new Teacher();
        teachername=new String(teachername.getBytes("ISO-8859-1"),"utf-8");
        protitle=new String(protitle.getBytes("ISO-8859-1"),"utf-8");
        teacher.setTeacherId(teacherid);
        teacher.setName(teachername);
        teacher.setSex(sex);
        teacher.setProtitle(protitle);
        teacher.setPhone(phone);
        teacher.setUserId(userid);
        User user=new User();
        user.setRole(2);
        user.setUserId(userid);
        user.setPassword("123456");
        userService.insert(user);
        teacherService.insert(teacher);
        List<Teacher>teachers=teacherService.listAll();
        session.setAttribute("teachers",teachers);
        List<Course> courses=courseService.listAll();
        List<classes> classes=teacherService.listAllMainTeacher(courses);
        session.setAttribute("classes",classes);
        session.setAttribute("m-teacher",teacher);
        session.setAttribute("m-course",courses);
        return "m_new_teacher_class";
    }
    //更改Tc
    @RequestMapping("/change_class")
    public String ch_ch(String teacherid,String courseid,HttpSession session)
    {
        Teacher teacher=new Teacher();
        teacher=teacherService.getByteacherId(teacherid);
        Course course=new Course();
        course=courseService.getById(courseid);
        Tc tc=new Tc();
        tc=tcService.getByteachercourseId(courseid,teacherid);
        session.setAttribute("m-tc",tc);
        session.setAttribute("m-teacher",teacher);
        session.setAttribute("m-course",course);
        List<Course> courses=courseService.listAll();
        List<classes> classes=teacherService.listAllMainTeacher(courses);
        session.setAttribute("classes",classes);
        List<Teacher>teachers=teacherService.listAll();
        session.setAttribute("teachers",teachers);
        return "m_manage_teacher_class";
    }
    //修改Tc检测
    @RequestMapping("/change_check")
    public String changecheck(String teacherid, String courseId, String courseName, String term, String courseHour, String teaIden, HttpSession session) throws UnsupportedEncodingException {
        Teacher teacher=new Teacher();
        teacher=teacherService.getByteacherId(teacherid);
        Course course=new Course();
        course=courseService.getById(courseId);
        Course course1=new Course();
        teaIden=new String(teaIden.getBytes("ISO-8859-1"),"utf-8");
        courseName=new String(courseName.getBytes("ISO-8859-1"),"utf-8");
        course1.setCourseHour(Integer.parseInt(courseHour));
        course1.setCourseId(courseId);
        course1.setCourseName(courseName);
        course1.setTerm(term);
        List<Tc> tcs=new ArrayList<>();
        tcs=tcService.getByCourseId(courseId);
        Tc tc=tcService.getByteachercourseId(courseId,teacherid);
        int al=0;
        boolean flag=true;
        for (Tc tc1 : tcs) {
            if (tc1.getTeaIdentity().equals("主讲教师"))
            {
                flag=false;
            }
            al += tc1.getTeachHour();
        }
        if (tc.getTeaIdentity().equals("主讲教师"))
        {
            flag=true;
        }
        if (al+Integer.parseInt(courseHour)-tc.getTeachHour()>course.getCourseHour()|| !flag)
        {
            session.setAttribute("m-tc",tc);
            List<Course> courses=courseService.listAll();
            session.setAttribute("m-teacher",teacher);
            session.setAttribute("m-course",courses);
            return "m_change_class_fail";
        }
        else
        {
            courseService.update(course1);
            tc.setTeaIdentity(teaIden);
            tcService.update(tc);
            teacher=teacherService.getByteacherId(teacherid);
            course=courseService.getById(courseId);
            session.setAttribute("m-tc",tc);
            session.setAttribute("m-teacher",teacher);
            session.setAttribute("m-course",course);
            List<Course> courses=courseService.listAll();
            List<classes> classes=teacherService.listAllMainTeacher(courses);
            session.setAttribute("classes",classes);
            List<Teacher>teachers=teacherService.listAll();
            session.setAttribute("teachers",teachers);
            return "m_manage_teacher";
        }
    }
    //为老师新增授课信息并检测
    @RequestMapping("/new_teacher_class")
    public String ne(String teacherid,String courseName,String courseHour,String teaIden,HttpSession session) throws UnsupportedEncodingException {
        Teacher teacher=new Teacher();
        teacher=teacherService.getByteacherId(teacherid);
        Course course=new Course();
        courseName=new String(courseName.getBytes("ISO-8859-1"),"utf-8");
        course=courseService.getId(courseName);
        teaIden=new String(teaIden.getBytes("ISO-8859-1"),"utf-8");
        Tc tc=new Tc();
        String courseId=course.getCourseId();
        tc.setCourseId(courseId);
        int id=tcService.listAll().size();
        String ids=String.valueOf(id+1);
        tc.setTcId(ids);
        tc.setTeacherId(teacherid);
        tc.setTeachHour(Integer.parseInt(courseHour));
        tc.setTeaIdentity(teaIden);
        int al=0;
        boolean flag=false;
        List<Tc> tcs=new ArrayList<>();
        tcs=tcService.getByCourseId(courseId);
        for (Tc tc1 : tcs) {
            if (tc1.getTeaIdentity().equals("主讲教师"))
            {
                flag=true;
            }
            al += tc1.getTeachHour();
        }
        if(flag==true&&teaIden.equals("主讲教师")){
            flag=true;
        }else {
            flag=false;
        }
        if (al+Integer.parseInt(courseHour)>course.getCourseHour()|| flag)
        {
            session.setAttribute("m-tc",tc);
            List<Course> courses=courseService.listAll();
            session.setAttribute("m-teacher",teacher);
            session.setAttribute("m-course",courses);
            return "m_change_class_fail";
        }
        else
        {
            tcService.insert(tc);
            List<Course> courses=courseService.listAll();
            List<classes> classes=teacherService.listAllMainTeacher(courses);
            session.setAttribute("classes",classes);
            List<Teacher>teachers=teacherService.listAll();
            session.setAttribute("teachers",teachers);
            return "m_manage_teacher";
        }
    }
    //教师查看自己的课程详情
    @RequestMapping("/my_detailed_class")
    public String show(String teacherid,String courseid,HttpSession session)
    {
        tran1(teacherid, courseid, session);
        List<Teacher> teachers=teacherService.listAll();
        session.setAttribute("teachers", teachers);
        return "t_showstudent";
    }
    public void tran1(String teacherid,String courseid,HttpSession session)
    {
        List<Teacher> teachers1=teacherService.listAllExcept(courseid);
        session.setAttribute("teachers", teachers1);
        List<Teachers> teachersList=teacherService.listAllteaBycourseId(courseid);
        session.setAttribute("tea_courses", teachersList);
        List<Teachers> teachers=teacherService.listAllteaBycourseId(courseid);
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