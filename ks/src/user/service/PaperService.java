package user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import user.dao.PaperMapper;
import user.entity.Paper;
import user.entity.Topic;

import java.util.ArrayList;
import java.util.List;

@Service("paperService")
public class PaperService {

    @Autowired
    private PaperMapper paperMapper;

    /**
     * 查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
    public List<Paper> listAll() {
    	return paperMapper.listAll();
    }
    public List<Paper> listAllPaper(String stuid,String topicid)
    {
        return paperMapper.listAllPaper(stuid, topicid);
    }
    public List<Paper> listAllPaperForStu(String stuid)
    {
        List<Paper> al=paperMapper.listAll();
        List<Paper> re=new ArrayList<>();
        for (Paper topic : al) {
            String ci = topic.getStudentId();
            if (ci.equals(stuid)) {
                re.add(topic);
            }
        }
        return re;
    }

    /**
     * 根据主键查询
     *
     * @param paperId 主键
     * @return 返回记录，没有返回null
     */
    public Paper getById(String paperId) {
    	return paperMapper.getById(paperId);
    }
    /**
     * 新增，插入所有字段
     *
     * @param paper 新增的记录
     * @return 返回影响行数
     */
    public int insert(Paper paper) {
    	return paperMapper.insert(paper);
    }
	
    /**
     * 新增，忽略null字段
     *
     * @param paper 新增的记录
     * @return 返回影响行数
     */
    public int insertIgnoreNull(Paper paper) {
    	return paperMapper.insertIgnoreNull(paper);
    }
	
    /**
     * 修改，修改所有字段
     *
     * @param paper 修改的记录
     * @return 返回影响行数
     */
    public int update(Paper paper) {
    	return paperMapper.update(paper);
    }
	
    /**
     * 修改，忽略null字段
     *
     * @param paper 修改的记录
     * @return 返回影响行数
     */
    public int updateIgnoreNull(Paper paper) {
    	return paperMapper.updateIgnoreNull(paper);
    }
	
    /**
     * 删除记录
     *
     * @param paper 待删除的记录
     * @return 返回影响行数
     */
    public int delete(Paper paper) {
    	return paperMapper.delete(paper);
    }
	
}