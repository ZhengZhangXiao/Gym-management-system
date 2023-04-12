package src.indi.wree.gymManagement.model;

import src.indi.wree.gymManagement.bean.GymClass;
import src.indi.wree.gymManagement.dao.ManageHelper;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.util.Vector;

public class ClassModel extends AbstractTableModel {
    private ManageHelper helper;
    private Vector<GymClass> gymClasses;
    private  Vector<String> columnNames = null;
    private Vector<Vector<String>> rowData = null;

    public ClassModel(String sql, JDialog jd) {
     helper=new ManageHelper();
     gymClasses=helper.getClass(sql);
     columnNames=new Vector<String>();
     rowData = new Vector<Vector<String>>();
     columnNames.add("Class No");
     columnNames.add("Class Name");
     columnNames.add("Class time");
     columnNames.add("Class Teacher");

     for(GymClass gc:gymClasses){
         Vector<String> hang = new Vector<String>();
         hang.add(Integer.toString(gc.getClassNo()));
         hang.add(gc.getClassName());
         hang.add(gc.getTime());
         hang.add(gc.getTeacher());
         rowData.add(hang);
     }
        System.out.println(columnNames.get(2));
        System.out.println(rowData.get(1).get(1));
        if(getRowCount()!=0){
            JOptionPane.showMessageDialog(jd, "We have "+getRowCount()+" gym classes");
            return ;
        }else{
            JOptionPane.showMessageDialog(jd, "No Gym Class!");
            return ;
        }



    }



    @Override
    public int getRowCount() {
        return this.rowData.size();
    }

    @Override
    public int getColumnCount() {
        return this.columnNames.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return ((Vector)this.rowData.get(rowIndex)).get(columnIndex);
    }

    @Override
    public String getColumnName(int column) {

        return (String)this.columnNames.get(column);
    }
}
