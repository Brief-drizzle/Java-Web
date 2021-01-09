package user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import user.dao.TopicpaperMapper;
import user.entity.Topicpaper;

import java.util.List;

@Service("topicpaperService")
public class TopicpaperService {

    @Autowired
    private TopicpaperMapper topicpaperMapper;

    /**
     * 查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
    public List<Topicpaper> listAll() {
    	return topicpaperMapper.listAll();
    }

    /**
     * 根据主键查询
     *
     * @param topicpaperId 主键
     * @return 返回记录，没有返回null
     */
    public Topicpaper getById(String topicpaperId) {
    	return topicpaperMapper.getById(topicpaperId);
    }
	public List<Topicpaper> getByStutopicId(String stutopicid){return topicpaperMapper.getByStutopicId(stutopicid);}
    /**
     * 新增，插入所有字段
     *
     * @param topicpaper 新增的记录
     * @return 返回影响行数
     */
    public int insert(Topicpaper topicpaper) {
    	return topicpaperMapper.insert(topicpaper);
    }
	
    /**
     * 新增，忽略null字段
     *
     * @param topicpaper 新增的记录
     * @return 返回影响行数
     */
    public int insertIgnoreNull(Topicpaper topicpaper) {
    	return topicpaperMapper.insertIgnoreNull(topicpaper);
    }
	
    /**
     * 修改，修改所有字段
     *
     * @param topicpaper 修改的记录
     * @return 返回影响行数
     */
    public int update(Topicpaper topicpaper) {
    	return topicpaperMapper.update(topicpaper);
    }
	
    /**
     * 修改，忽略null字段
     *
     * @param topicpaper 修改的记录
     * @return 返回影响行数
     */
    public int updateIgnoreNull(Topicpaper topicpaper) {
    	return topicpaperMapper.updateIgnoreNull(topicpaper);
    }
	
    /**
     * 删除记录
     *
     * @param topicpaper 待删除的记录
     * @return 返回影响行数
     */
    public int delete(Topicpaper topicpaper) {
    	return topicpaperMapper.delete(topicpaper);
    }
	
}