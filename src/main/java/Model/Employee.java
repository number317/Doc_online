package Model;

/**
 * Created by cheon on 6/4/16.
 */
public class Employee {
    private String id;
    private String password;
    private String titleId;
    private String titleName;
    private String deptId;
    private String deptName;
    private int perNum;

    public Employee(String id, String password){
        this.id=id;
        this.password=password;
    }

    public Employee(String id, String password, String titleId, String titleName, String deptId, String deptName, int perNum){
        this.id=id;
        this.password=password;
        this.titleId=titleId;
        this.titleName=titleName;
        this.deptId=deptId;
        this.deptName=deptName;
        this.perNum=perNum;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public void setId(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.id = username;
    }

    public String getTitleId() {
        return titleId;
    }

    public void setTitleId(String titleId) {
        this.titleId = titleId;
    }

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public int getPerNum() {
        return perNum;
    }

    public void setPerNum(int perNum) {
        this.perNum = perNum;
    }
}
