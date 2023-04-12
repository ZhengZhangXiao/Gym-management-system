package src.indi.wree.gymManagement.dao;

import src.indi.wree.gymManagement.bean.GymClass;
import src.indi.wree.gymManagement.bean.Members;
import src.indi.wree.gymManagement.bean.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.util.Vector;

public class ManageHelper {
   private jdbcHelper helper;

   public boolean login(User user1){
       boolean b=true;
       helper=new jdbcHelper();
       User newUser=helper.getUser(user1);

       if(!user1.getPassword().equals(newUser.getPassword()) ){
           b=false;
       };
       if(user1.isUserType()!=newUser.isUserType()){
           b=false;
       };

      helper.close();
       return  b;
   }

    public boolean Register(Members members){
       helper=new jdbcHelper();
       boolean b= helper.register(members);
       helper.close();
       return b;
    }

    public boolean Delete(Members members){
       helper=new jdbcHelper();
       boolean b= helper.Delete(members);
       helper.close();
       return b;
    }

    public boolean Update(Members members,String column,String newInfo){
       helper=new jdbcHelper();
       boolean b= helper.Update(members,column,newInfo);
       helper.close();
       return b;

    }
    public boolean UpdateAll(Members members){
        helper=new jdbcHelper();
        boolean b= helper.UpdateAll(members);
        helper.close();
        return b;

    }

    public boolean addClass(GymClass gymClass){
       helper=new jdbcHelper();
       boolean b= helper.addClass(gymClass);
       helper.close();
       return b;
    }

    public boolean deleteClass(GymClass gymClass){
       helper=new jdbcHelper();
       boolean b= helper.deleteClass(gymClass);
       helper.close();
       return b;
    }

    public boolean updateClass(GymClass gymClass,String column,String newInfo){
        helper=new jdbcHelper();
        boolean b= helper.updateClass(gymClass,column,newInfo);
        helper.close();
        return b;
    }

    public Vector<GymClass> getClass(String sql){
       Vector<GymClass> gymClasses;
       helper=new jdbcHelper();
       gymClasses=helper.getClass(sql);
       helper.close();
       return  gymClasses;
    }

    public Vector<Members> getMembers(String sql){
        Vector<Members> members;
        helper=new jdbcHelper();
        members=helper.getMembers(sql);
        helper.close();
        return  members;
    }

    public Members getMemberInfo(User user){
       helper=new jdbcHelper();
       Members members;
       members= helper.getMemberInfo(user);
       helper.close();
       return members;
    }
}
