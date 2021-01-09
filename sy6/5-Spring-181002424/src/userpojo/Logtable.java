package userpojo;

public class Logtable {
    String username;
    String logtime;
    String logip;
    Long logcontime;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLogtime() {
        return logtime;
    }

    public void setLogtime(String logtime) {
        this.logtime = logtime;
    }

    public String getLogip() {
        return logip;
    }

    public void setLogip(String logip) {
        this.logip = logip;
    }

    public Long getLogcontime() {
        return logcontime;
    }

    public void setLogcontime(Long logcontime) {
        this.logcontime = logcontime;
    }
}
