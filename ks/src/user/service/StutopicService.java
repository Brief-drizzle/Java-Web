package user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import user.dao.StutopicMapper;
import user.dao.TopicMapper;
import user.entity.Stutopic;
import user.entity.Topic;

import java.util.ArrayList;
import java.util.List;

@Service("stutopicService")
public class StutopicService {

    @Autowired
    private StutopicMapper stutopicMapper;
    @Autowired
    private TopicMapper topicMapper;

    /**
     * 查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
    public List<Stutopic> listAll() {
    	return stutopicMapper.listAll();
    }
    public List<Stutopic> listByTopicid(String topicid){
        return stutopicMapper.listAllByTopic(topicid);
    }
    /**
     * 根据主键查询
     *
     * @param stutopicId 主键
     * @return 返回记录，没有返回null
     */
    public Stutopic getById(String stutopicId) {
    	return stutopicMapper.getById(stutopicId);
    }
	public Stutopic getByStuTopicId(String stuid,String topicid){
        return stutopicMapper.getByStuTopId(stuid, topicid);
    }
    public Stutopic getByStuCourseId(String stuid,String courseid)
    {
        List<Topic> topicList=topicMapper.listAllTopic(stuid);
        Stutopic stutopic=new Stutopic();
        for (int i=0;i<topicList.size();i++){
            if (topicList.get(i).getCourseId().equals(courseid)){
                stutopic=stutopicMapper.getByStuTopId(stuid, topicList.get(i).getTopicId());
            }
        }
        return stutopic;
    }
    /**
     * 新增，插入所有字段
     *
     * @param stutopic 新增的记录
     * @return 返回影响行数
     */
    public int insert(Stutopic stutopic) {
    	return stutopicMapper.insert(stutopic);
    }
	
    /**
     * 新增，忽略null字段
     *
     * @param stutopic 新增的记录
     * @return 返回影响行数
     */
    public int insertIgnoreNull(Stutopic stutopic) {
    	return stutopicMapper.insertIgnoreNull(stutopic);
    }
	
    /**
     * 修改，修改所有字段
     *
     * @param stutopic 修改的记录
     * @return 返回影响行数
     */
    public int update(Stutopic stutopic) {
    	return stutopicMapper.update(stutopic);
    }
	
    /**
     * 修改，忽略null字段
     *
     * @param stutopic 修改的记录
     * @return 返回影响行数
     */
    public int updateIgnoreNull(Stutopic stutopic) {
    	return stutopicMapper.updateIgnoreNull(stutopic);
    }
	
    /**
     * 删除记录
     *
     * @param stutopic 待删除的记录
     * @return 返回影响行数
     */
    public int delete(Stutopic stutopic) {
    	return stutopicMapper.delete(stutopic);
    }
	
}