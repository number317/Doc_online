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

    public void uploadFile(String fileId, String fileName, String fileType, String fileClassId, String fileClassName, String empId, String deptId, String deptName) throws SQLException {
        connection = factory.getConnection();
        pStatement = connection.prepareStatement("call pro_UploadFile("+"\""+fileId+"\",\""+fileName+"\",\""+fileType+"\",\""+fileClassId+"\",\""+fileClassName+"\",\""+empId+"\",\""+deptId+"\",\""+deptName+"\""+")");
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
        String fileId = "9ad100b3-8af7-3433-8bab-72defa78e3e0";
        String fileName = "test";
        String fileType = "pdf";
        String fileClassId = "00001";
        String fileClassName = "Normal";
        String empId = "01234567890123";
        String deptId = "000001";
        String deptName = "Technology";
        FileDBImp fileDBImp = new FileDBImp();
        fileDBImp.uploadFile(fileId,fileName,fileType,fileClassId,fileClassName,empId,deptId,deptName);
    }
}