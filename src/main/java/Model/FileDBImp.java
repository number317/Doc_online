package Model;

import ConnectionPool.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by cheon on 6/5/16.
 */
public class FileDBImp {
    private ConnectionFactory factory = ConnectionFactory.getInstatnce();
    private Connection connection = null;
    private PreparedStatement pStatement = null;
    private ResultSet resultSet = null;

    public ArrayList<String> getFileInfoById(String fileId) throws SQLException {
        ArrayList<String> info = new ArrayList<>();
        connection = factory.getConnection();
        pStatement = connection.prepareStatement("call pro_SearchFile$0("+"\""+fileId+"\""+")");
        resultSet = pStatement.executeQuery();
        while (resultSet.next())
            for(int i=1; i<=10; i++)
                info.add(resultSet.getString(i));
        return info;
    }

    public ArrayList<File> getFileByName(String name) throws SQLException {
        ArrayList<File> files = new ArrayList<>();
        connection = factory.getConnection();
        pStatement = connection.prepareStatement("call pro_SearchFile$1("+"\""+name+"\""+")");
        resultSet = pStatement.executeQuery();
        while(resultSet.next()){
            File file = new File(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getString(6),resultSet.getString(7),resultSet.getString(8),resultSet.getInt(9),resultSet.getDate(10),resultSet.getInt(11));
            files.add(file);
        }
        return files;
    }

    public ArrayList<File> getFileByType(String type) throws SQLException {
        ArrayList<File> files = new ArrayList<>();
        connection = factory.getConnection();
        pStatement = connection.prepareStatement("call pro_SearchFile$2("+"\""+type+"\""+")");
        resultSet = pStatement.executeQuery();
        while(resultSet.next()){
            File file = new File(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getString(6),resultSet.getString(7),resultSet.getString(8),resultSet.getInt(9),resultSet.getDate(10),resultSet.getInt(11));
            files.add(file);
        }
        return files;
    }

    public ArrayList<File> getFileByEmpId(String empId) throws SQLException {
        ArrayList<File> files = new ArrayList<>();
        connection = factory.getConnection();
        pStatement = connection.prepareStatement("call pro_SearchFile$5("+"\""+empId+"\")");
        resultSet = pStatement.executeQuery();
        while(resultSet.next()){
            File file = new File(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getString(6),resultSet.getString(7),resultSet.getString(8),resultSet.getInt(9),resultSet.getDate(10),resultSet.getInt(11));
            files.add(file);
        }
        return files;
    }

    public ArrayList<File> getLatestFile() throws SQLException {
        ArrayList<File> files = new ArrayList<>();
        connection = factory.getConnection();
        pStatement = connection.prepareStatement("call pro_LatestFile()");
        resultSet = pStatement.executeQuery();
        while(resultSet.next()){
            File file = new File(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getString(6),resultSet.getString(7),resultSet.getString(8),resultSet.getInt(9),resultSet.getDate(10),resultSet.getInt(11));
            files.add(file);
        }
        return files;
    }

    public ArrayList<File> MostDownload() throws SQLException {
        ArrayList<File> files = new ArrayList<>();
        connection = factory.getConnection();
        pStatement = connection.prepareStatement("call pro_MostDownload()");
        resultSet = pStatement.executeQuery();
        while(resultSet.next()){
            File file = new File(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getString(6),resultSet.getString(7),resultSet.getString(8),resultSet.getInt(9),resultSet.getDate(10),resultSet.getInt(11));
            files.add(file);
        }
        return files;
    }

    public ArrayList<File> MostBrowse() throws SQLException {
        ArrayList<File> files = new ArrayList<>();
        connection = factory.getConnection();
        pStatement = connection.prepareStatement("call pro_MostBrowse()");
        resultSet = pStatement.executeQuery();
        while(resultSet.next()){
            File file = new File(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getString(6),resultSet.getString(7),resultSet.getString(8),resultSet.getInt(9),resultSet.getDate(10),resultSet.getInt(11));
            files.add(file);
        }
        return files;
    }

    public ArrayList<File> getFileInfo() throws SQLException {
        ArrayList<File> files = new ArrayList<>();
        connection = factory.getConnection();
        pStatement = connection.prepareStatement("call pro_GetFileInfo()");
        resultSet = pStatement.executeQuery();
        while(resultSet.next()){
            File file = new File(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getString(6),resultSet.getString(7),resultSet.getString(8),resultSet.getInt(9),resultSet.getDate(10),resultSet.getInt(11));
            files.add(file);
        }
        return files;
    }

    public void updateBrowseTimes(String fileId) throws SQLException {
        connection = factory.getConnection();
        pStatement = connection.prepareStatement("call pro_UpdateBrowseTimes("+"\""+fileId+"\")");
        pStatement.executeQuery();
    }

    public void uploadFile(String fileId, String fileName, String fileType, String fileClassId, String fileClassName, String empId, String deptId, String deptName, String filePath) throws SQLException {
        connection = factory.getConnection();
        pStatement = connection.prepareStatement("call pro_UploadFile("+"\""+fileId+"\",\""+fileName+"\",\""+fileType+"\",\""+fileClassId+"\",\""+fileClassName+"\",\""+empId+"\",\""+deptId+"\",\""+deptName+"\",\""+filePath+"\")");
        pStatement.executeQuery();
    }

    public void insertDownload(String empId, String fileId, String fileName, String deptName, String fileClassName) throws SQLException {
        connection = factory.getConnection();
        pStatement = connection.prepareStatement("call pro_InsertDownload("+"\""+empId+"\",\""+fileId+"\",\""+fileName+"\",\""+deptName+"\",\""+fileClassName+"\")");
        pStatement.executeQuery();
    }

    public int getFilePerNum(String fileClass) throws SQLException {
        int PerNum = 0;
        switch (fileClass){
            case "Normal":
                PerNum = 1;
                break;
            case "Important":
                PerNum = 2;
                break;
            case "Secret":
                PerNum = 3;
                break;
        }
        return PerNum;
    }

    public int getPageCount(int rowCount, int pageSize){
        int pageCount;
        if(rowCount % pageSize == 0)
            pageCount = rowCount / pageSize;
        else
            pageCount = rowCount / pageSize + 1;
        if (pageCount ==0 )
            pageCount = 1;
        return pageCount;
    }



    public static void main(String args[]) throws SQLException {
        ArrayList<String> info;
        String id="3d325260-ca62-4f45-9261-047be8c71d3c";
        FileDBImp fileDBImp = new FileDBImp();
        info = fileDBImp.getFileInfoById(id);
        for(int i=0; i< info.size();i++){
            System.out.println(info.get(i));
        }
        String empId = "01234567890123";
        String fileName = info.get(0);
        String fileType = info.get(1);
        String deptName = info.get(6);
        String fileClassName = info.get(3);
        fileDBImp.insertDownload(empId,id,fileName,deptName,fileClassName);
        ArrayList<File> files = fileDBImp.getFileInfo();
        for(int i=0;i<files.size();i++){
            System.out.println(files.get(i).getFile_ID()+"  "+files.get(i).getFile_name()+"  "+files.get(i).getFile_type()+"  "+files.get(i).getFile_Dept_ID()+"   "+files.get(i).getFile_Dept_name()+"  "+files.get(i).getFile_Employee_ID()+"   "+files.get(i).getFile_FileClass_ID()+"   "+files.get(i).getFile_FileClass_name()+files.get(i).getUpload_Time()+"   "+files.get(i).getBrowse_Times()+"    "+files.get(i).getUpload_Time());
        }
    }
}