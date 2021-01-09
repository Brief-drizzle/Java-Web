package detailedinfo;

import pojo.Detailedinfotable;

public interface Detailedinfo {
    public int insertDetail(Detailedinfotable detailedinfo);
    public void updateDetail(Detailedinfotable detailedinfo);
    public Detailedinfotable getDetail(String username);
    public void deleteDetail(String username);
}
