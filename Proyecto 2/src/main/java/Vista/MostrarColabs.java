/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.HeadlessException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author xhunik
 */
public class MostrarColabs extends JFrame{
    DefaultTableModel model;
    JTable table;

    public MostrarColabs() throws HeadlessException {
        super("Colaboradores registrados");
        setSize(420,480);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Container content = getContentPane();
        
        content.add(new JLabel("Mostrar colaboradores"),BorderLayout.NORTH);
        
        model = new DefaultTableModel();
        table = new JTable(model);
        
        model.addColumn("nombre");
        model.addColumn("nickname");
        model.addColumn("rol");
        model.addColumn("telefono");
        String[][] rowsData = App.gestor.getArrayDataColaboradores();
        for (int i = 0; i < rowsData[0].length; i++){
            String[] datos = {rowsData[0][i],
                rowsData[1][i],
                rowsData[2][i],
                rowsData[3][i]};
            model.addRow(datos);
        }
        
        /*
        model.addColumn("Col 1");
        model.addColumn("Col 2");         <- definir elementos en la tabla
        model.addRow(new Object[]{"v1","v2"});
        */
        content.add(new JScrollPane(table),BorderLayout.CENTER);
    }
    
}
