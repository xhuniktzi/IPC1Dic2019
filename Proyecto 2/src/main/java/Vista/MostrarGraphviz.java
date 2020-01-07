/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author xhunik
 */
public class MostrarGraphviz extends JFrame{

    public MostrarGraphviz(String ruta) throws HeadlessException {
        super("Visualizar diagramas");
        setVisible(true);
        setSize(360,480);
        
        Container content = getContentPane();
        content.setLayout(new FlowLayout(FlowLayout.CENTER));
        /*
        JPanel imageColabs = new JPanel();
        imageColabs.add(new JLabel(new ImageIcon(ruta + "/img/colaboradores.jpg")));
        */
        content.add(new JScrollPane(new JLabel(new ImageIcon(ruta + "/img/colaboradores.jpg"))));
        content.add(new JScrollPane(new JLabel(new ImageIcon(ruta + "/img/tableros.jpg"))));
        //super.repaint();
    }
    
}
