/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Exceptions.ListaVaciaException;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.HeadlessException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author xhunik
 */
public class ListarTabs extends JFrame {
    DefaultTableModel model;
    JTable table;

    public ListarTabs() throws HeadlessException {
        super("Tableros Registrados");
        setSize(420,480);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Container content = getContentPane();
        
        content.add(new JLabel("Tableros Registrados"),BorderLayout.NORTH);
        
        model = new DefaultTableModel();
        table = new JTable(model);
        
        model.addColumn("titulo");
        model.addColumn("color");
        try{
            String[][] rowsData = App.gestor.getArrayDataTableros();
        
        
            for (int i = 0; i < rowsData[0].length; i++){
                String[] datos = {rowsData[0][i],
                    rowsData[1][i]
                };
                model.addRow(datos);
            }
        }
        catch (ListaVaciaException lve){
            lve.printStackTrace();
        }
        
        /*
        model.addColumn("Col 1");
        model.addColumn("Col 2");         <- definir elementos en la tabla
        model.addRow(new Object[]{"v1","v2"});
        */
        content.add(new JScrollPane(table),BorderLayout.CENTER);
    }
}
