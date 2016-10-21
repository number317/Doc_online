package Model;

import java.sql.Date;

/**
 * Created by cheon on 6/15/16.
 */
public class Download {
    private String empId;
    private String fileId;
    private Date downloadTime;
    private String fileName;
    private String deptName;
    private String fileClassName;

    public Download(String empId, String fileId, Date downloadTime, String fileName, String deptName, String fileClassName) {
        this.empId = empId;
        this.fileId = fileId;
        this.downloadTime = downloadTime;
        this.fileName = fileName;
        this.deptName = deptName;
        this.fileClassName = fileClassName;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public Date getDownloadTime() {
        return downloadTime;
    }

    public void setDownloadTime(Date downloadTime) {
        this.downloadTime = downloadTime;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getFileClassName() {
        return fileClassName;
    }

    public void setFileClassName(String fileClassName) {
        this.fileClassName = fileClassName;
    }
}
