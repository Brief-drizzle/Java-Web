package user.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import user.entity.Paper;

@Mapper
public interface PaperMapper {

	/**
     * 查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
	List<Paper> listAll();
	List<Paper> listAllPaper(@Param("stuid")String stuid,@Param("topicid")String topicid);

	/**
     * 根据主键查询
     *
     * @param paperId 主键
     * @return 返回记录，没有返回null
     */
	Paper getById(String paperId);
	
	/**
     * 新增，插入所有字段
     *
     * @param paper 新增的记录
     * @return 返回影响行数
     */
	int insert(Paper paper);
	
	/**
     * 新增，忽略null字段
     *
     * @param paper 新增的记录
     * @return 返回影响行数
     */
	int insertIgnoreNull(Paper paper);
	
	/**
     * 修改，修改所有字段
     *
     * @param paper 修改的记录
     * @return 返回影响行数
     */
	int update(Paper paper);
	
	/**
     * 修改，忽略null字段
     *
     * @param paper 修改的记录
     * @return 返回影响行数
     */
	int updateIgnoreNull(Paper paper);
	
	/**
     * 删除记录
     *
     * @param paper 待删除的记录
     * @return 返回影响行数
     */
	int delete(Paper paper);
	
}