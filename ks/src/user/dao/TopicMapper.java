package user.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import user.entity.Topic;

@Mapper
public interface TopicMapper {

	/**
     * 查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
	List<Topic> listAll();
	List<Topic> listAllTopic(String studentId);

	/**
     * 根据主键查询
     *
     * @param topicId 主键
     * @return 返回记录，没有返回null
     */
	Topic getById(String topicId);
	Topic getByName(String topicName);
	/**
     * 新增，插入所有字段
     *
     * @param topic 新增的记录
     * @return 返回影响行数
     */
	int insert(Topic topic);
	
	/**
     * 新增，忽略null字段
     *
     * @param topic 新增的记录
     * @return 返回影响行数
     */
	int insertIgnoreNull(Topic topic);
	
	/**
     * 修改，修改所有字段
     *
     * @param topic 修改的记录
     * @return 返回影响行数
     */
	int update(Topic topic);
	
	/**
     * 修改，忽略null字段
     *
     * @param topic 修改的记录
     * @return 返回影响行数
     */
	int updateIgnoreNull(Topic topic);
	
	/**
     * 删除记录
     *
     * @param topic 待删除的记录
     * @return 返回影响行数
     */
	int delete(Topic topic);
	
}