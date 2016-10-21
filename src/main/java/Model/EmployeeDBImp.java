package Model;

import ConnectionPool.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by cheon on 6/4/16.
 */
public class EmployeeDBImp {
    private ConnectionFactory factory= ConnectionFactory.getInstatnce();
    private Connection connection = null;
    private PreparedStatement pStatement = null;
    private ResultSet resultSet = null;

    public boolean checkEmployee(Employee employee) throws SQLException {
        connection = factory.getConnection();
        pStatement = connection.prepareStatement("select Employee_password from Employees where Employee_ID='"+employee.getId()+"' limit 1;");
        resultSet = pStatement.executeQuery();
        if(resultSet.next()){
            String db_password = resultSet.getString(1);
            return db_password.equals(employee.getPassword());
        }
        else
            return false;

    }

    public int getPerNum(String id) throws SQLException {
        int PerNum = 0;
        connection = factory.getConnection();
        pStatement = connection.prepareStatement("call pro_GetPerNum$0("+"\""+id+"\")");
        resultSet = pStatement.executeQuery();
        if(resultSet.next())
            PerNum = resultSet.getInt(1);
        return PerNum;
    }

    public String getDeptId(String id) throws SQLException{
        String deptId = null;
        connection = factory.getConnection();
        pStatement = connection.prepareStatement("call pro_GetDeptId("+"\""+id+"\")");
        resultSet = pStatement.executeQuery();
        if(resultSet.next())
            deptId = resultSet.getString(1);
        return deptId;
    }

    public String getDeptName(String id) throws  SQLException{
        String deptName = null;
        connection = factory.getConnection();
        pStatement = connection.prepareStatement("call pro_GetDeptName("+"\""+id+"\")");
        resultSet = pStatement.executeQuery();
        if(resultSet.next())
            deptName = resultSet.getString(1);
        return deptName;
    }

    public ArrayList<Employee> getEmpInfo() throws SQLException {
        ArrayList<Employee> employees = new ArrayList<>();
        connection = factory.getConnection();
        pStatement = connection.prepareStatement("call pro_GetEmpInfo()");
        resultSet = pStatement.executeQuery();
        if(resultSet.next()){
            Employee employee = new Employee(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4),resultSet.getString(5), resultSet.getString(6), resultSet.getInt(7));
            employees.add(employee);
        }
        return employees;
    }

    public void updatePassword(String id, String newPassword) throws SQLException {
        connection = factory.getConnection();
        pStatement = connection.prepareStatement("call pro_UpdatePassword("+"\""+id+"\""+",\""+newPassword+"\")");
        pStatement.executeQuery();
    }

    public static void main(String args[]) throws SQLException {
        EmployeeDBImp employeeDBImp = new EmployeeDBImp();
        ArrayList<Employee> employees;
        employees=employeeDBImp.getEmpInfo();
        System.out.println(employeeDBImp.getDeptId("01234567890123"));
        for(int i=0; i<employees.size(); i++){
            System.out.println(employees.get(i).getId()+"   "+employees.get(i).getPassword()+"  "+employees.get(i).getTitleId()+"   "+employees.get(i).getTitleName()+" "+employees.get(i).getDeptId()+"    "+employees.get(i).getDeptName()+"  "+employees.get(i).getPerNum());
        }
    }
}
