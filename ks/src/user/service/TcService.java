package user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import user.dao.TcMapper;
import user.entity.Tc;

import java.util.List;

@Service("tcService")
public class TcService {

    @Autowired
    private TcMapper tcMapper;

    /**
     * 查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
    public List<Tc> listAll() {
    	return tcMapper.listAll();
    }


    /**
     * 根据主键查询
     *
     * @param tcId 主键
     * @return 返回记录，没有返回null
     */
    public Tc getBycourseId(String tcId) {
    	return tcMapper.getBycourseIdmain(tcId);
    }
    public Tc getByteachercourseId(String courseId,String teacherId)
    {
        return tcMapper.getByTeacherCourseId(courseId,teacherId);
    }
    public List<Tc> getByCourseId(String courseId)
    {
        return  tcMapper.getBycourseId(courseId);
    }
    public List<Tc> getByteacherId(String tcId) {
        return tcMapper.getByteacherId(tcId);
    }
    /**
     * 新增，插入所有字段
     *
     * @param tc 新增的记录
     * @return 返回影响行数
     */
    public int insert(Tc tc) {
    	return tcMapper.insert(tc);
    }
	
    /**
     * 新增，忽略null字段
     *
     * @param tc 新增的记录
     * @return 返回影响行数
     */
    public int insertIgnoreNull(Tc tc) {
    	return tcMapper.insertIgnoreNull(tc);
    }
	
    /**
     * 修改，修改所有字段
     *
     * @param tc 修改的记录
     * @return 返回影响行数
     */
    public int update(Tc tc) {
    	return tcMapper.update(tc);
    }
	
    /**
     * 修改，忽略null字段
     *
     * @param tc 修改的记录
     * @return 返回影响行数
     */
    public int updateIgnoreNull(Tc tc) {
    	return tcMapper.updateIgnoreNull(tc);
    }
	
    /**
     * 删除记录
     *
     * @param tc 待删除的记录
     * @return 返回影响行数
     */
    public int delete(Tc tc) {
    	return tcMapper.delete(tc);
    }
	
}