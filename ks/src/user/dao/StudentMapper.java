package user.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import user.entity.Student;

@Mapper
public interface StudentMapper {

	/**
     * 查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
	List<Student> listAll();
	List<Student> listAllExcept(String courseid);

	/**
     * 根据主键查询
     *
     * @param stuid 主键
     * @return 返回记录，没有返回null
     */
	Student getById(String stuid);
	Student getByName(String stuname);
	Student getByUserid(String userid);
	/**
     * 新增，插入所有字段
     *
     * @param student 新增的记录
     * @return 返回影响行数
     */
	int insert(Student student);
	
	/**
     * 新增，忽略null字段
     *
     * @param student 新增的记录
     * @return 返回影响行数
     */
	int insertIgnoreNull(Student student);
	
	/**
     * 修改，修改所有字段
     *
     * @param student 修改的记录
     * @return 返回影响行数
     */
	int update(Student student);
	
	/**
     * 修改，忽略null字段
     *
     * @param student 修改的记录
     * @return 返回影响行数
     */
	int updateIgnoreNull(Student student);
	
	/**
     * 删除记录
     *
     * @param student 待删除的记录
     * @return 返回影响行数
     */
	int delete(Student student);
	
}