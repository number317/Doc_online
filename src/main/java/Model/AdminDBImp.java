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
public class AdminDBImp {
    private ConnectionFactory factory= ConnectionFactory.getInstatnce();
    private Connection connection = null;
    private PreparedStatement pStatement = null;
    private ResultSet resultSet = null;

    public boolean checkAdmin(Admin admin) throws SQLException {
        connection = factory.getConnection();
        pStatement = connection.prepareStatement("select Admin_password from Admins where Admin_ID='"+admin.getId()+"' limit 1;");
        resultSet = pStatement.executeQuery();
        if(resultSet.next()){
            String db_password = resultSet.getString(1);
            return db_password.equals(admin.getPassword());
        }
        else
            return false;
    }

    public ArrayList<Admin> GetAdminInfo() throws SQLException {
        ArrayList<Admin> admins = new ArrayList<>();
        connection = factory.getConnection();
        pStatement = connection.prepareStatement("call pro_GetAdminInfo()");
        resultSet = pStatement.executeQuery();
        while(resultSet.next()){
            Admin admin = new Admin(resultSet.getString(1),resultSet.getString(2));
            admins.add(admin);
        }
        return admins;
    }

    public static void main(String args[]) throws SQLException {
        AdminDBImp adminDBImp = new AdminDBImp();
        ArrayList<Admin> admins = new ArrayList<>();
        admins = adminDBImp.GetAdminInfo();
        for(int i=0; i< admins.size();i++){
            System.out.println(admins.get(i).getId()+"  "+admins.get(i).getPassword());
        }
    }
}
