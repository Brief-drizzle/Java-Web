package user.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import user.entity.Tc;

@Mapper
public interface TcMapper {

	/**
     * 查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
	List<Tc> listAll();


	/**
     * 根据主键查询
     *
     * @param tcId 主键
     * @return 返回记录，没有返回null
     */
	Tc getBycourseIdmain(String tcId);
	List<Tc> getByteacherId(String tcId);
	List<Tc> getBycourseId(String courseId);
	Tc getByTeacherCourseId(@Param("courseId") String courseId, @Param("teacherId") String teacherId);
	/**
     * 新增，插入所有字段
     *
     * @param tc 新增的记录
     * @return 返回影响行数
     */
	int insert(Tc tc);
	
	/**
     * 新增，忽略null字段
     *
     * @param tc 新增的记录
     * @return 返回影响行数
     */
	int insertIgnoreNull(Tc tc);
	
	/**
     * 修改，修改所有字段
     *
     * @param tc 修改的记录
     * @return 返回影响行数
     */
	int update(Tc tc);
	
	/**
     * 修改，忽略null字段
     *
     * @param tc 修改的记录
     * @return 返回影响行数
     */
	int updateIgnoreNull(Tc tc);
	
	/**
     * 删除记录
     *
     * @param tc 待删除的记录
     * @return 返回影响行数
     */
	int delete(Tc tc);
	
}