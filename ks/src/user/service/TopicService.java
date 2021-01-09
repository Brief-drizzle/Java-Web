package user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import user.dao.TopicMapper;
import user.entity.Topic;

import java.util.ArrayList;
import java.util.List;

@Service("topicService")
public class TopicService {

    @Autowired
    private TopicMapper topicMapper;

    /**
     * 查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
    public List<Topic> listAll() {
    	return topicMapper.listAll();
    }
    public List<Topic> listAllByCourseid(String courseid)
    {
        List<Topic> all=topicMapper.listAll();
        List<Topic> re=new ArrayList<>();
        for (Topic topic : all) {
            String ci = topic.getCourseId();
            if (ci.equals(courseid)) {
                re.add(topic);
            }
        }
        return re;
    }
    public List<Topic> listAllByCourseTeaId(String courseid,String teaid)
    {
        List<Topic> re=new ArrayList<>();
        List<Topic> al=topicMapper.listAll();
        for (Topic topic : al) {
            String ci = topic.getCourseId();
            String ti = topic.getTeacherId();
            if (ci.equals(courseid) && ti.equals(teaid)) {
                re.add(topic);
            }
        }
        return re;
    }
    public List<Topic> listAllTopic(String studentid,String courseid)
    {
        List<Topic> al=topicMapper.listAllTopic(studentid);
        List<Topic> re=new ArrayList<>();
        for (Topic topic : al) {
            String ci = topic.getCourseId();
            if (ci.equals(courseid)) {
                re.add(topic);
            }
        }
        return re;
    }
    /**
     * 根据主键查询
     *
     * @param topicId 主键
     * @return 返回记录，没有返回null
     */
    public Topic getById(String topicId) {
    	return topicMapper.getById(topicId);
    }
	public Topic getByName(String Name){return topicMapper.getByName(Name);}
    /**
     * 新增，插入所有字段
     *
     * @param topic 新增的记录
     * @return 返回影响行数
     */
    public int insert(Topic topic) {
    	return topicMapper.insert(topic);
    }
	
    /**
     * 新增，忽略null字段
     *
     * @param topic 新增的记录
     * @return 返回影响行数
     */
    public int insertIgnoreNull(Topic topic) {
    	return topicMapper.insertIgnoreNull(topic);
    }
	
    /**
     * 修改，修改所有字段
     *
     * @param topic 修改的记录
     * @return 返回影响行数
     */
    public int update(Topic topic) {
    	return topicMapper.update(topic);
    }
	
    /**
     * 修改，忽略null字段
     *
     * @param topic 修改的记录
     * @return 返回影响行数
     */
    public int updateIgnoreNull(Topic topic) {
    	return topicMapper.updateIgnoreNull(topic);
    }
	
    /**
     * 删除记录
     *
     * @param topic 待删除的记录
     * @return 返回影响行数
     */
    public int delete(Topic topic) {
    	return topicMapper.delete(topic);
    }
	
}