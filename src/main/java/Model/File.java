package Model;

import java.sql.Date;

/**
 * Created by cheon on 6/5/16.
 */
public class File {
    private String File_ID = null;
    private String File_name = null;
    private String File_type = null;
    private String File_FileClass_ID = null;
    private String File_FileClass_name = null;
    private String File_Employee_ID = null;
    private String File_Dept_ID = null;
    private String File_Dept_name = null;
    private int Browser_Times = 0;
    private Date Upload_Time = null;
    private int Download_Times = 0;

    public File(String file_ID, String file_name, String file_type, String file_FileClass_ID, String file_FileClass_name, String file_Employee_ID, String file_Dept_ID, String file_Dept_name, int browser_Times, Date upload_Time, int download_Times) {
        File_ID = file_ID;
        File_name = file_name;
        File_type = file_type;
        File_FileClass_ID = file_FileClass_ID;
        File_FileClass_name = file_FileClass_name;
        File_Employee_ID = file_Employee_ID;
        File_Dept_ID = file_Dept_ID;
        File_Dept_name = file_Dept_name;
        Browser_Times = browser_Times;
        Upload_Time = upload_Time;
        Download_Times = download_Times;
    }

    public String getFile_ID() {
        return File_ID;
    }

    public void setFile_ID(String file_ID) {
        File_ID = file_ID;
    }

    public String getFile_name() {
        return File_name;
    }

    public void setFile_name(String file_name) {
        File_name = file_name;
    }

    public String getFile_type() {
        return File_type;
    }

    public void setFile_type(String file_type) {
        File_type = file_type;
    }

    public String getFile_FileClass_ID() {
        return File_FileClass_ID;
    }

    public void setFile_FileClass_ID(String file_FileClass_ID) {
        File_FileClass_ID = file_FileClass_ID;
    }

    public int getDownload_Times() {
        return Download_Times;
    }

    public void setDownload_Times(int download_Times) {
        Download_Times = download_Times;
    }

    public Date getUpload_Time() {
        return Upload_Time;
    }

    public void setUpload_Time(Date upload_Time) {
        Upload_Time = upload_Time;
    }

    public int getBrowse_Times() {
        return Browser_Times;
    }

    public void setBrowse_Times(int browser_Times) {
        Browser_Times = browser_Times;
    }

    public String getFile_Dept_name() {
        return File_Dept_name;
    }

    public void setFile_Dept_name(String file_Dept_name) {
        File_Dept_name = file_Dept_name;
    }

    public String getFile_Dept_ID() {
        return File_Dept_ID;
    }

    public void setFile_Dept_ID(String file_Dept_ID) {
        File_Dept_ID = file_Dept_ID;
    }

    public String getFile_Employee_ID() {
        return File_Employee_ID;
    }

    public void setFile_Employee_ID(String file_Employee_ID) {
        File_Employee_ID = file_Employee_ID;
    }

    public String getFile_FileClass_name() {
        return File_FileClass_name;
    }

    public void setFile_FileClass_name(String file_FileClass_name) {
        File_FileClass_name = file_FileClass_name;
    }
}
