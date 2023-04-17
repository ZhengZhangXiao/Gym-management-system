package src.indi.wree.gymManagement.dao;

import src.indi.wree.gymManagement.bean.GymClass;
import src.indi.wree.gymManagement.bean.Members;
import src.indi.wree.gymManagement.bean.User;

import java.sql.*;
import java.util.Vector;

public class jdbcHelper {
   // set variables which used  to connect to the Mysql
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private Connection ct = null;

 // connect to  the database
    private void init(){
     try{
         Class.forName("com.mysql.cj.jdbc.Driver");
         ct= DriverManager.getConnection("jdbc:mysql://localhost:3306/ABCFitnessDao","","");

     }catch( ClassNotFoundException e){
        e.printStackTrace();
     }catch (SQLException e){
         e.printStackTrace();
     }
    }
// constructor of this jdbcHelper class
    public jdbcHelper() {
        this.init();
    }

//  according to the username to find the user in database
    public User getUser(User user){
        User newUser= new User();
        try{
            ps=ct.prepareStatement("select * from user_info where name=?");
            ps.setString(1,user.getUsername());
            rs=ps.executeQuery();
            if(rs.next()){
                newUser.setUsername(rs.getString(2));
                newUser.setPassword(rs.getString(3));
                newUser.setUserType(rs.getInt(1));


            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return newUser;
    }

// register a new gym member or gym staff
    public boolean register(Members members){
        boolean a=true;
        try{
            ps=ct.prepareStatement("insert into user_info (usertype,name,password,email,cellPhone, homeClub) values (?,?,?,?,?,?)");
            ps.setInt(1,members.getType());
            ps.setString(2,members.getName());
            ps.setString(3,members.getPassword());
            ps.setString(4,members.getEmail());
            ps.setString(5,members.getCellPhone());
            ps.setString(6, members.getHomeClub());
            if(ps.executeUpdate()!=1){
                a=false;
            }
        }catch (SQLException e){
            e.printStackTrace();
            a=false;
        }
        return a;
    }

//delete a member or staff according to his name ,email and home club
    public boolean Delete(Members members){
        boolean a=true;
        try{
            ps=ct.prepareStatement("delete from user_info where name=? and email=? and homeclub=?");
            ps.setString(1,members.getName());
            ps.setString(2,members.getEmail());
            ps.setString(3,members.getHomeClub());
            if(ps.executeUpdate()!=1){
                a=false;
            }
        }catch (SQLException e){
            e.printStackTrace();
            a=false;
        }
        return a;
    }

// update some information of gym member or staff
    public boolean Update(Members members,String column,String newInfo){
        boolean a=true;
        String sql= "update user_info set "+column+"=? where name=?";
        try{
            ps= ct.prepareStatement(sql);
            ps.setString(1,newInfo);
            ps.setString(2,members.getName());
            if(ps.executeUpdate()!=1) a=false;

        }catch (SQLException e){
            e.printStackTrace();
            a=false;
        }
        return a;
    }

//    update all the  information of gym member or staff
    public boolean UpdateAll(Members members){
        boolean a=true;

        try{
            ps= ct.prepareStatement("update user_info set password=? ,email=?,cellPhone=?, homeClub=? where name=? ");
            ps.setString(1,members.getPassword());
            ps.setString(2,members.getEmail());
            ps.setString(3, members.getCellPhone());
            ps.setString(4,members.getHomeClub());
            ps.setString(5,members.getName());
            if(ps.executeUpdate()!=1) a=false;

        }catch (SQLException e){
            e.printStackTrace();
            a=false;
        }
        return a;
    }

//add a new gym class
    public boolean addClass(GymClass gymClass){
        boolean a=true;
        try{
            ps=ct.prepareStatement("insert into class_info(className,time ,teacher) values (?,?,?)");
            ps.setString(1,gymClass.getClassName());
            ps.setString(2,gymClass.getTime());
            ps.setString(3,gymClass.getTeacher());
            if(ps.executeUpdate()!=1) a=false;
        }catch (SQLException e){
            e.printStackTrace();
            a=false;
        }
        return a;
    }

//delete a gym glass
    public  boolean deleteClass(GymClass gymClass){
        boolean a=true;
        try{
            ps= ct.prepareStatement("delete from class_info where classNo=? and className=? and time=? ");
            ps.setInt(1,gymClass.getClassNo());
            ps.setString(2,gymClass.getClassName());
            ps.setString(3,gymClass.getTime());
            if(ps.executeUpdate()!=1) a=false;
        }catch (SQLException e){
            e.printStackTrace();
            a=false;
        }
        return  a;
    }

// update some information of a gym class
    public boolean updateClass(GymClass gymClass, String column,String newInfo){
        boolean a= true;
        String sql= "update  class_info set "+column+"=? where classNo=?";
        try{
            ps= ct.prepareStatement(sql);
            ps.setString(1,newInfo);
            ps.setInt(2,gymClass.getClassNo());
            if(ps.executeUpdate()!=1) a=false;

        }catch (SQLException e){
            e.printStackTrace();
            a=false;
        }
        return a;
    }

// get all the gym class
    public Vector<GymClass> getClass(String sql){
        Vector<GymClass> gymClasses=new Vector<GymClass>();
        try{
            Statement st=ct.createStatement();
            rs= st.executeQuery(sql);
            while (rs.next()){
                GymClass gymClass=new GymClass();
                gymClass.setClassNo(rs.getInt(1));
                gymClass.setClassName(rs.getString(2));
                gymClass.setTime(rs.getString(3));
                gymClass.setTeacher(rs.getString(4));
                gymClasses.add(gymClass);

            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return  gymClasses;
    }

//get all the gym members
    public Vector<Members> getMembers(String sql){
        Vector<Members> members=new Vector<Members>();
        try{
            Statement st=ct.createStatement();
            rs= st.executeQuery(sql);
            while (rs.next()){
                Members members1=new Members();
                members1.setType(rs.getInt(1));
                members1.setName(rs.getString(2));
                members1.setPassword(rs.getString(3));
                members1.setEmail(rs.getString(4));
                members1.setCellPhone(rs.getString(5));
                members1.setHomeClub(rs.getString(6));
                members.add(members1);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return  members;
    }

// get all the information of a gym member
    public Members getMemberInfo(User user){
        Members members=new Members();

        try{
            ps=ct.prepareStatement("select * from user_info where name=?");
            ps.setString(1,user.getUsername());
            rs=ps.executeQuery();
            if(rs.next()){
                members.setName(rs.getString(2));
                members.setPassword(rs.getString(3));
                members.setEmail(rs.getString(4));
                members.setCellPhone(rs.getString(5));
                members.setHomeClub(rs.getString(6));
            }


        }catch (SQLException e){
            e.printStackTrace();
        }
        return members;
    }

// close the connection with  mysql
    public void close() {
        try {
            if(rs!=null) rs.close();
            if(ps!=null) ps.close();
            if(ct!=null) ct.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


}
