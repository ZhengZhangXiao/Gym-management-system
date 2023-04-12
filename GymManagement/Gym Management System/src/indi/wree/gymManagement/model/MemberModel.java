package src.indi.wree.gymManagement.model;

import src.indi.wree.gymManagement.bean.GymClass;
import src.indi.wree.gymManagement.bean.Members;
import src.indi.wree.gymManagement.dao.ManageHelper;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.util.Vector;

public class MemberModel extends AbstractTableModel {

    private ManageHelper helper;
    private Vector<Members> members;
    private  Vector<String> columnNames = null;
    private Vector<Vector<String>> rowData = null;

    public MemberModel(String sql, JDialog jd,String type) {
        helper=new ManageHelper();
        members=helper.getMembers(sql);
        columnNames=new Vector<String>();
        rowData = new Vector<Vector<String>>();

        columnNames.add("Name");
        columnNames.add("Password");
        columnNames.add("Email");
        columnNames.add("Cell Phone");
        columnNames.add("Home Club");

        for(Members mb:members){
            Vector<String> hang = new Vector<String>();
            hang.add(mb.getName());
            hang.add(mb.getPassword());
            hang.add(mb.getEmail());
            hang.add(mb.getCellPhone());
            hang.add(mb.getHomeClub());
            rowData.add(hang);
        }

        if(getRowCount()!=0){
            JOptionPane.showMessageDialog(jd, "We have "+getRowCount()+" gym "+type);
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
