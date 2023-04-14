package src.indi.wree.gymManagement.dao;

import src.indi.wree.gymManagement.bean.GymClass;
import src.indi.wree.gymManagement.bean.Members;
import src.indi.wree.gymManagement.bean.User;

import java.util.Vector;

public class ManageHelper {
   private jdbcHelper helper;


   // login function
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

    // register a new gym member or gym staff
    public boolean Register(Members members){
       helper=new jdbcHelper();
       boolean b= helper.register(members);
       helper.close();
       return b;
    }

    //delete a member or staff according to his name ,email and home club
    public boolean Delete(Members members){
       helper=new jdbcHelper();
       boolean b= helper.Delete(members);
       helper.close();
       return b;
    }

    // update some information of gym member or staff
    public boolean Update(Members members,String column,String newInfo){
       helper=new jdbcHelper();
       boolean b= helper.Update(members,column,newInfo);
       helper.close();
       return b;

    }

    //    update all the  information of gym member or staff
    public boolean UpdateAll(Members members){
        helper=new jdbcHelper();
        boolean b= helper.UpdateAll(members);
        helper.close();
        return b;

    }
    //add a new gym class
    public boolean addClass(GymClass gymClass){
       helper=new jdbcHelper();
       boolean b= helper.addClass(gymClass);
       helper.close();
       return b;
    }

    //delete a gym glass
    public boolean deleteClass(GymClass gymClass){
       helper=new jdbcHelper();
       boolean b= helper.deleteClass(gymClass);
       helper.close();
       return b;
    }

    // update some information of a gym class
    public boolean updateClass(GymClass gymClass,String column,String newInfo){
        helper=new jdbcHelper();
        boolean b= helper.updateClass(gymClass,column,newInfo);
        helper.close();
        return b;
    }

    // get all the gym class
    public Vector<GymClass> getClass(String sql){
       Vector<GymClass> gymClasses;
       helper=new jdbcHelper();
       gymClasses=helper.getClass(sql);
       helper.close();
       return  gymClasses;
    }
    //get all the gym members
    public Vector<Members> getMembers(String sql){
        Vector<Members> members;
        helper=new jdbcHelper();
        members=helper.getMembers(sql);
        helper.close();
        return  members;
    }
    // get all the information of a gym member
    public Members getMemberInfo(User user){
       helper=new jdbcHelper();
       Members members;
       members= helper.getMemberInfo(user);
       helper.close();
       return members;
    }
}
