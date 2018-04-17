package per.hss.model;

public class Grade {
    private int id;
    private String gradename;
    private String gradedesc;
    public Grade()
    {
        super();
    }
    public Grade(String gradename, String gradedesc) {
        super();
        this.gradename = gradename;
        this.gradedesc = gradedesc;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getGradename() {
        return gradename;
    }
    public void setGradename(String gradename) {
        this.gradename = gradename;
    }
    public String getGradedesc() {
        return gradedesc;
    }
    public void setGradedesc(String gradedesc) {
        this.gradedesc = gradedesc;
    }

}
