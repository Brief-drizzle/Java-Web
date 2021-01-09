package user.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import user.entity.Teacher;
import user.entity.Teachers;

@Mapper
public interface TeacherMapper {

	/**
     * 查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
	List<Teacher> listAll();
	List<Teacher> listAllTeachers(String courseId);
	List<Teacher> listAllExcept(String courseId);
	/**
     * 根据主键查询
     *
     * @param teacherId 主键
     * @return 返回记录，没有返回null
     */
	Teacher getById(String teacherId);
	Teacher getByteacherId(String teacherId);
	Teacher getByName(String name);
	/**
     * 新增，插入所有字段
     *
     * @param teacher 新增的记录
     * @return 返回影响行数
     */
	int insert(Teacher teacher);
	
	/**
     * 新增，忽略null字段
     *
     * @param teacher 新增的记录
     * @return 返回影响行数
     */
	int insertIgnoreNull(Teacher teacher);
	
	/**
     * 修改，修改所有字段
     *
     * @param teacher 修改的记录
     * @return 返回影响行数
     */
	int update(Teacher teacher);
	
	/**
     * 修改，忽略null字段
     *
     * @param teacher 修改的记录
     * @return 返回影响行数
     */
	int updateIgnoreNull(Teacher teacher);
	
	/**
     * 删除记录
     *
     * @param teacher 待删除的记录
     * @return 返回影响行数
     */
	int delete(Teacher teacher);
	
}