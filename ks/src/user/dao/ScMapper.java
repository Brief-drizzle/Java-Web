package user.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import user.entity.Sc;

@Mapper
public interface ScMapper {

	/**
     * 查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
	List<Sc> listAll();
	List<Sc> listAllBycourse(String courseId);


	/**
     * 根据主键查询
     *
     * @param scId 主键
     * @return 返回记录，没有返回null
     */
	Sc getById(String scId);
	Sc getByStuId(String studentid);
	Sc getByCourseId(String courseid);
	Sc getByCourseStuId(@Param("courseid")String courseid,@Param("stuid")String stuid);
	/**
     * 新增，插入所有字段
     *
     * @param sc 新增的记录
     * @return 返回影响行数
     */
	int insert(Sc sc);
	
	/**
     * 新增，忽略null字段
     *
     * @param sc 新增的记录
     * @return 返回影响行数
     */
	int insertIgnoreNull(Sc sc);
	
	/**
     * 修改，修改所有字段
     *
     * @param sc 修改的记录
     * @return 返回影响行数
     */
	int update(Sc sc);
	
	/**
     * 修改，忽略null字段
     *
     * @param sc 修改的记录
     * @return 返回影响行数
     */
	int updateIgnoreNull(Sc sc);
	
	/**
     * 删除记录
     *
     * @param sc 待删除的记录
     * @return 返回影响行数
     */
	int delete(Sc sc);
	
}