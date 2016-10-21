package Model;

import ConnectionPool.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by cheon on 6/15/16.
 */
public class DownloadDBImp {
    private ConnectionFactory factory= ConnectionFactory.getInstatnce();
    private Connection connection = null;
    private PreparedStatement pStatement = null;
    private ResultSet resultSet = null;

    public ArrayList<Model.Download> GetDownloadInfo() throws SQLException {
        ArrayList<Download> downloads = new ArrayList<>();
        connection = factory.getConnection();
        pStatement = connection.prepareStatement("call pro_GetDownloadInfo()");
        resultSet = pStatement.executeQuery();
        if(resultSet.next()){
            Download download = new Download(resultSet.getString(1),resultSet.getString(2),resultSet.getDate(3),resultSet.getString(4),resultSet.getString(5),resultSet.getString(6));
            downloads.add(download);
        }
        return downloads;
    }
    public static void main(String args[]) throws SQLException {
        DownloadDBImp downloadDBImp = new DownloadDBImp();
        ArrayList<Download> downloads;
        downloads = downloadDBImp.GetDownloadInfo();
        for(int i=0; i<downloads.size();i++){
            System.out.println(downloads.get(i).getEmpId()+"    "+downloads.get(i).getFileId()+"    "+downloads.get(i).getDownloadTime().toString()+"   "+downloads.get(i).getFileName()+"  "+downloads.get(i).getDeptName()+"  "+downloads.get(i).getFileClassName());
        }
    }
}
