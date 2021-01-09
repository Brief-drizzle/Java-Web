package user.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import user.entity.Stutopic;

@Mapper
public interface StutopicMapper {

	/**
     * 查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
	List<Stutopic> listAll();
	List<Stutopic> listAllByStu(String stuid);
	List<Stutopic> listAllByTopic(String topicid);

	/**
     * 根据主键查询
     *
     * @param stutopicId 主键
     * @return 返回记录，没有返回null
     */
	Stutopic getById(String stutopicId);
	Stutopic getByStuTopId(@Param("stuId")String stuId,@Param("TopicId")String topicId);

	/**
     * 新增，插入所有字段
     *
     * @param stutopic 新增的记录
     * @return 返回影响行数
     */
	int insert(Stutopic stutopic);
	
	/**
     * 新增，忽略null字段
     *
     * @param stutopic 新增的记录
     * @return 返回影响行数
     */
	int insertIgnoreNull(Stutopic stutopic);
	
	/**
     * 修改，修改所有字段
     *
     * @param stutopic 修改的记录
     * @return 返回影响行数
     */
	int update(Stutopic stutopic);
	
	/**
     * 修改，忽略null字段
     *
     * @param stutopic 修改的记录
     * @return 返回影响行数
     */
	int updateIgnoreNull(Stutopic stutopic);
	
	/**
     * 删除记录
     *
     * @param stutopic 待删除的记录
     * @return 返回影响行数
     */
	int delete(Stutopic stutopic);
	
}