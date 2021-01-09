package user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import user.dao.CourseMapper;
import user.dao.TcMapper;
import user.dao.TeacherMapper;
import user.entity.Course;
import user.entity.Courses;
import user.entity.Tc;
import user.entity.classes;

import java.util.ArrayList;
import java.util.List;

@Service("courseService")
public class CourseService {

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private TcMapper tcMapper;

    @Autowired
    private TeacherMapper teacherMapper;
    /**
     * 查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
    public List<Course> listAll() {
    	return courseMapper.listAll();
    }
    public List<Courses> listAllCourses(String teacherId)
    {
        List<Course> courses=new ArrayList<>();
        courses=courseMapper.listAllTeacher(teacherId);
        List<Courses> courses1=new ArrayList<>();
        for (Course cours : courses) {
            Courses course = new Courses();
            String courseId = cours.getCourseId();
            Tc tc = tcMapper.getByTeacherCourseId(courseId,teacherId);
            course.setTc(tc);
            course.setCourse(courseMapper.getById(tc.getCourseId()));
            courses1.add(course);
        }
        return courses1;
    }
    public List<Course> listAllbyStu(String stuid)
    {
        return courseMapper.listAllbyStu(stuid);
    }


    /**
     * 根据主键查询
     *
     * @param courseId 主键
     * @return 返回记录，没有返回null
     */
    public Course getById(String courseId) {
    	return courseMapper.getById(courseId);
    }
	public Course getId(String courseName)
    {
        return courseMapper.getCourseId(courseName);
    }
    /**
     * 新增，插入所有字段
     *
     * @param course 新增的记录
     * @return 返回影响行数
     */
    public int insert(Course course) {
    	return courseMapper.insert(course);
    }
	
    /**
     * 新增，忽略null字段
     *
     * @param course 新增的记录
     * @return 返回影响行数
     */
    public int insertIgnoreNull(Course course) {
    	return courseMapper.insertIgnoreNull(course);
    }
	
    /**
     * 修改，修改所有字段
     *
     * @param course 修改的记录
     * @return 返回影响行数
     */
    public int update(Course course) {
    	return courseMapper.update(course);
    }
	
    /**
     * 修改，忽略null字段
     *
     * @param course 修改的记录
     * @return 返回影响行数
     */
    public int updateIgnoreNull(Course course) {
    	return courseMapper.updateIgnoreNull(course);
    }
	
    /**
     * 删除记录
     *
     * @param course 待删除的记录
     * @return 返回影响行数
     */
    public int delete(Course course) {
    	return courseMapper.delete(course);
    }

}