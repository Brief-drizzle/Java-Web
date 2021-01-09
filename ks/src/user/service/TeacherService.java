package user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import user.dao.CourseMapper;
import user.dao.TcMapper;
import user.dao.TeacherMapper;
import user.entity.*;

import java.util.ArrayList;
import java.util.List;

@Service("teacherService")
public class TeacherService {

    @Autowired
    private TeacherMapper teacherMapper;

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private TcMapper tcMapper;

    /**
     * 查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
    public List<Teacher> listAll() {
    	return teacherMapper.listAll();
    }
    public List<Teacher> listAllByCourseid(String courseid){return teacherMapper.listAllTeachers(courseid);}
    public List<Teachers> listAllteaBycourseId(String courseid)
    {
        List<Teacher> teachers=teacherMapper.listAllTeachers(courseid);
        List<Teachers> teachers1=new ArrayList<>();
        for (Teacher teacher : teachers) {
            Tc tc = tcMapper.getByTeacherCourseId(courseid, teacher.getTeacherId());
            Teachers teachers2 = new Teachers();
            teachers2.setTc(tc);
            teachers2.setTeacher(teacher);
            teachers1.add(teachers2);
        }
        return teachers1;
    }
    public List<Teacher> listAllExcept(String courseId)
    { return teacherMapper.listAllExcept(courseId); }
    /**
     * 根据主键查询
     *
     * @param userId 主键
     * @return 返回记录，没有返回null
     */
    public Teacher getById(String userId) {
    	return teacherMapper.getById(userId);
    }
    public Teacher getByteacherId(String teacherId)
    {
        return teacherMapper.getByteacherId(teacherId);
    }
	public Teacher getByName(String name){return teacherMapper.getByName(name);}
    /**
     * 新增，插入所有字段
     *
     * @param teacher 新增的记录
     * @return 返回影响行数
     */
    public int insert(Teacher teacher) {
    	return teacherMapper.insert(teacher);
    }
	
    /**
     * 新增，忽略null字段
     *
     * @param teacher 新增的记录
     * @return 返回影响行数
     */
    public int insertIgnoreNull(Teacher teacher) {
    	return teacherMapper.insertIgnoreNull(teacher);
    }
	
    /**
     * 修改，修改所有字段
     *
     * @param teacher 修改的记录
     * @return 返回影响行数
     */
    public int update(Teacher teacher) {
    	return teacherMapper.update(teacher);
    }
	
    /**
     * 修改，忽略null字段
     *
     * @param teacher 修改的记录
     * @return 返回影响行数
     */
    public int updateIgnoreNull(Teacher teacher) {
    	return teacherMapper.updateIgnoreNull(teacher);
    }
	
    /**
     * 删除记录
     *
     * @param teacher 待删除的记录
     * @return 返回影响行数
     */
    public int delete(Teacher teacher) {
    	return teacherMapper.delete(teacher);
    }

    public List<classes> listAllMainTeacher(List<Course> courses)
    {
        List<classes> teachers=new ArrayList<>();
        for (Course course:courses){
            Tc tc = tcMapper.getBycourseIdmain(course.getCourseId());
            Teacher teacher=teacherMapper.getByteacherId(tc.getTeacherId());
            classes classes=new classes();
            classes.setCourseHour(course.getCourseHour());
            classes.setCourseId(course.getCourseId());
            classes.setCourseName(course.getCourseName());
            classes.setName(teacher.getName());
            classes.setTerm(course.getTerm());
            teachers.add(classes);
        }
        return teachers;
    }
    public List<Teachers> listAllTeachers(String courseId)
    {
        List<Teacher> teachers=new ArrayList<>();
        teachers=teacherMapper.listAllTeachers(courseId);
        List<Teachers> teachers1=new ArrayList<>();
        for (Teacher teacher : teachers) {
            Teachers teachers2 = new Teachers();
            String teacherId = teacher.getTeacherId();
            Tc tc = tcMapper.getByTeacherCourseId(courseId, teacherId);
            if (tc!=null){
                teachers2.setTeacher(teacherMapper.getByteacherId(tc.getTeacherId()));
                teachers2.setTc(tc);
                teachers1.add(teachers2);
            }
        }
        return teachers1;
    }
}