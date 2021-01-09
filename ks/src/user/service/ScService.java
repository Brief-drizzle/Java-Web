package user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import user.dao.*;
import user.entity.*;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("scService")
public class ScService {

    @Autowired
    private ScMapper scMapper;
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private PaperMapper paperMapper;
    @Autowired
    private StutopicMapper stutopicMapper;
    @Autowired
    private TopicpaperMapper topicpaperMapper;
    /**
     * 查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
    public List<Sc> listAll() {
    	return scMapper.listAll();
    }
    public List<students> listAllBycourse(String courseid)
    {
        List<Sc> scs=scMapper.listAllBycourse(courseid);
        List<students> studentsList=new ArrayList<>();
        for (Sc value : scs) {
            students students = new students();
            String stuid=value.getStudentId();
            Sc sc = scMapper.getByCourseStuId(courseid,stuid);
            students.setSc(sc);
            students.setStudent(studentMapper.getById(sc.getStudentId()));
            studentsList.add(students);
        }
        return studentsList;
    }

    /**
     * 根据主键查询
     *
     * @param scId 主键
     * @return 返回记录，没有返回null
     */
    public Sc getById(String scId) {
    	return scMapper.getById(scId);
    }
	public Sc getByCourseStuId(String courseid,String stuid){
        return scMapper.getByCourseStuId(courseid, stuid);
    }
    /**
     * 新增，插入所有字段
     *
     * @param sc 新增的记录
     * @return 返回影响行数
     */
    public int insert(Sc sc) {
    	return scMapper.insert(sc);
    }
	
    /**
     * 新增，忽略null字段
     *
     * @param sc 新增的记录
     * @return 返回影响行数
     */
    public int insertIgnoreNull(Sc sc) {
    	return scMapper.insertIgnoreNull(sc);
    }
	
    /**
     * 修改，修改所有字段
     *
     * @param sc 修改的记录
     * @return 返回影响行数
     */
    public int update(Sc sc) {
    	return scMapper.update(sc);
    }
	
    /**
     * 修改，忽略null字段
     *
     * @param sc 修改的记录
     * @return 返回影响行数
     */
    public int updateIgnoreNull(Sc sc) {
    	return scMapper.updateIgnoreNull(sc);
    }
	
    /**
     * 删除记录
     *
     * @param sc 待删除的记录
     * @return 返回影响行数
     */
    public int delete(Sc sc) {
    	return scMapper.delete(sc);
    }

    public boolean fileImport(String name, MultipartFile file,String stuid,String topicid) throws ParseException, IOException {
        boolean b = false;
        ReadExcel readExcel=new ReadExcel();
        List<Paper> paperList=readExcel.getExcelInfo(name, file);
        if (paperList!=null){
            b=true;
            for(int i=0;i<paperList.size();i++){
                Paper paper=new Paper();
                paper.setAbstract(paperList.get(i).getAbstract());
                paper.setAuthor(paperList.get(i).getAuthor());
                paper.setDocLocation(paperList.get(i).getDocLocation());
                paper.setKeyword(paperList.get(i).getKeyword());
                paper.setSource(paperList.get(i).getSource());
                paper.setTitle(paperList.get(i).getTitle());
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                //设置日期格式
                String date=df.format(new Date());
                // new Date()为获取当前系统时间
                paper.setUploadingTime(df.parse(date));
                int len=paperMapper.listAll().size();
                paper.setPaperId(String.valueOf(len+1));
                paper.setStudentId(stuid);
                paperMapper.insert(paper);

                Stutopic stutopic=stutopicMapper.getByStuTopId(stuid, topicid);
                String stutopicid=stutopic.getStutopicId();
                String topicpaperid=String.valueOf(topicpaperMapper.listAll().size()+1);
                Topicpaper topicpaper=new Topicpaper();
                topicpaper.setPaperId(paper.getPaperId());
                topicpaper.setRelevancy((float) 0.5);
                topicpaper.setStutopicId(stutopicid);
                topicpaper.setTopicpaperId(topicpaperid);
                topicpaperMapper.insert(topicpaper);

                stutopic.setFlag("1");
                stutopicMapper.update(stutopic);
            }
        }
        return b;
    }
}