package logintable;

import java.util.List;

public interface Loginfo {
    public pojo.Logintable isexsitanceLogin(pojo.Logintable logintable);
    public int insertLogin(pojo.Logintable logintable);
    public void deleteLogin(String username);
    public List<pojo.Logintable> allLogin();
}
