package pl.lukaszgrymulski;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class EmployeeTableModel extends AbstractTableModel {

    private static final int LAST_NAME_COL = 0;
    private static final int FIRST_NAME_COL = 1;
    private static final int EMAIL_COL = 2;
    private static final int SALARY_COL = 3;

    private String[] columnNames = {"Last Name", "First Name", "Email", "Salary"};

    private List<Employee> employees;

    public EmployeeTableModel(List<Employee> theEmployees) {
        employees = theEmployees;
    }

    @Override
    public int getRowCount() {
        return employees.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int row, int col) {
        Employee tempEmployee = employees.get(row);

        switch (col) {
            case LAST_NAME_COL: return tempEmployee.getLastName();
            case FIRST_NAME_COL: return tempEmployee.getFirstName();
            case EMAIL_COL: return tempEmployee.getEmail();
            case SALARY_COL: return tempEmployee.getSalary();
            default: return tempEmployee.getId();
        }
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Class getColumnClass(int c){
        return getValueAt(0, c).getClass();
    }
}
