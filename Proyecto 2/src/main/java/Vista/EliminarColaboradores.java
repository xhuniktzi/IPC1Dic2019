/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Logica.Elements.Colaborador;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author xhunik
 */
public class EliminarColaboradores extends JDialog{

    public EliminarColaboradores() {
        super();
        setVisible(true);
        setSize(540,540);
        Border border = new TitledBorder(new EtchedBorder());

        Container content = getContentPane();
//        JPanel panelBotones = new JPanel();
//        panelBotones.setLayout(new FlowLayout(FlowLayout.RIGHT));
//        
//        panelBotones.add(new JButton("Eliminar"));
//        
        JPanel panelContent = new JPanel();
        panelContent.setLayout(new BoxLayout(panelContent, BoxLayout.Y_AXIS));
        
        String[][] dataColabs = App.gestor.getArrayDataColaboradores();
        
        
        for (int i = 0; i < dataColabs[0].length;i++){
            JPanel actColab = new JPanel();
            actColab.setLayout(new FlowLayout(FlowLayout.RIGHT));
            actColab.setBorder(border);
            
            actColab.add(new JLabel("Nombre: "+ dataColabs[0][i]));
            actColab.add(new JLabel("Nickname: "+ dataColabs[1][i]));
            actColab.add(new JLabel("Rol:  "+ dataColabs[2][i]));
            actColab.add(new JLabel("Telefono:  "+ dataColabs[3][i]));
            actColab.add(new BotonEliminarColaborador(dataColabs[1][i]));
            actColab.add(new BotonModificarColaborador(dataColabs[1][i]));
            panelContent.add(actColab);
        }
        content.add(panelContent,BorderLayout.CENTER);
        //content.add(panelBotones,BorderLayout.SOUTH);
        
    }
    
    
}
class BotonEliminarColaborador extends JButton{

    public BotonEliminarColaborador(String nickname) {
        setText("Eliminar Colaborador");
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int resp = JOptionPane.showConfirmDialog(null, "Vas a eliminar un colaborador, ¿Estas seguro?",
                        "Confirmacion",JOptionPane.YES_NO_OPTION);
                if (resp == 0)
                    App.gestor.colaboradoresRegistrados.eliminarColaboradorByNickname(nickname);
            }
        });
    }
    
}
class BotonModificarColaborador extends JButton {

    public BotonModificarColaborador(String nickname) {
        setText("Modificar Colaborador");
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Colaborador act = App.gestor.colaboradoresRegistrados.getColaboradorByNickname(nickname);
                
                String nombre = JOptionPane.showInputDialog("Nombre: ", act.nombre);
                String nickname = JOptionPane.showInputDialog("Nickname: ", act.nickname);
                String rol = JOptionPane.showInputDialog("Rol: ", act.rol);
                String tel = JOptionPane.showInputDialog("Telefono: ", act.telfono);
                
                
                if (!App.gestor.colaboradoresRegistrados.checkExistsNickname(nickname))
                    act.nickname = nickname;
                else {
                    JOptionPane.showMessageDialog(null, "ese nickname ya existe",
                            "Validacion", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                act.nombre = nombre;
                act.rol = rol;
                act.telfono = Integer.parseInt(tel);
                
            }
        });
    }
    
}
