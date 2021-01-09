package user.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import user.entity.Topicpaper;

@Mapper
public interface TopicpaperMapper {

	/**
     * 查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
	List<Topicpaper> listAll();


	/**
     * 根据主键查询
     *
     * @param topicpaperId 主键
     * @return 返回记录，没有返回null
     */
	Topicpaper getById(String topicpaperId);
	List<Topicpaper> getByStutopicId(String stutopicid);
	/**
     * 新增，插入所有字段
     *
     * @param topicpaper 新增的记录
     * @return 返回影响行数
     */
	int insert(Topicpaper topicpaper);
	
	/**
     * 新增，忽略null字段
     *
     * @param topicpaper 新增的记录
     * @return 返回影响行数
     */
	int insertIgnoreNull(Topicpaper topicpaper);
	
	/**
     * 修改，修改所有字段
     *
     * @param topicpaper 修改的记录
     * @return 返回影响行数
     */
	int update(Topicpaper topicpaper);
	
	/**
     * 修改，忽略null字段
     *
     * @param topicpaper 修改的记录
     * @return 返回影响行数
     */
	int updateIgnoreNull(Topicpaper topicpaper);
	
	/**
     * 删除记录
     *
     * @param topicpaper 待删除的记录
     * @return 返回影响行数
     */
	int delete(Topicpaper topicpaper);
	
}