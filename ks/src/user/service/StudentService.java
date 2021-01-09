package user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import user.dao.ScMapper;
import user.dao.StudentMapper;
import user.entity.Sc;
import user.entity.Student;

import java.util.ArrayList;
import java.util.List;

@Service("studentService")
public class StudentService {

    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private ScMapper scMapper;

    /**
     * 查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
    public List<Student> listAll() {
    	return studentMapper.listAll();
    }
    public List<Student> listAllExcept(String courseid)
    {
        return studentMapper.listAllExcept(courseid);
    }

    /**
     * 根据主键查询
     *
     * @param studentId 主键
     * @return 返回记录，没有返回null
     */
    public Student getById(String studentId) {
    	return studentMapper.getById(studentId);
    }
	public Student getByName(String name)
    {
        return studentMapper.getByName(name);
    }
    public Student getByUserId(String userid){return studentMapper.getByUserid(userid);}
    /**
     * 新增，插入所有字段
     *
     * @param student 新增的记录
     * @return 返回影响行数
     */
    public int insert(Student student) {
    	return studentMapper.insert(student);
    }
	
    /**
     * 新增，忽略null字段
     *
     * @param student 新增的记录
     * @return 返回影响行数
     */
    public int insertIgnoreNull(Student student) {
    	return studentMapper.insertIgnoreNull(student);
    }
	
    /**
     * 修改，修改所有字段
     *
     * @param student 修改的记录
     * @return 返回影响行数
     */
    public int update(Student student) {
    	return studentMapper.update(student);
    }
	
    /**
     * 修改，忽略null字段
     *
     * @param student 修改的记录
     * @return 返回影响行数
     */
    public int updateIgnoreNull(Student student) {
    	return studentMapper.updateIgnoreNull(student);
    }
	
    /**
     * 删除记录
     *
     * @param student 待删除的记录
     * @return 返回影响行数
     */
    public int delete(Student student) {
    	return studentMapper.delete(student);
    }
	
}