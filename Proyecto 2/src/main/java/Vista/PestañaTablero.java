/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;


import Exceptions.InvalidNameColException;
import Exceptions.ListaVaciaException;
import Exceptions.NameColVacioException;
import Exceptions.TitleCardVacioException;
import Logica.Elements.Colaborador;
import Logica.Elements.Columna;
import Logica.Elements.Comentario;
import Logica.Elements.Tablero;
import Logica.Elements.Tarjeta;

import java.awt.BorderLayout;
import java.awt.Color;
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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author xhunik
 */
public class PestañaTablero extends JPanel{

    public PestañaTablero(Tablero tab) {
        super();
        setLayout(new BorderLayout());
        
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panelBotones.add(new BotonAñadirColumnas(tab));
        panelBotones.add(new BotonEliminarTablero(tab));
        
        JPanel content = new JPanel();
        try{
            content.setBackground(Color.decode(tab.hexColor));
        }
        catch(NumberFormatException nfe){
        }
        content.setLayout(null);
        Tablero tablero = App.gestor.getTablerosByTitle(tab.nombre);
        Columna[] cols = tablero.columnas.getArrayColumnas();
        
        for (int i = 0; i<cols.length;i++){
            JPanel columna = new JPanel();
            Border border = new TitledBorder(new EtchedBorder());
            columna.setBorder(border);
            
            columna.setLayout(new BorderLayout());
            columna.setSize(300,480);
            columna.setLocation(i*300, 0);
            
            JPanel botonesColumnas = new JPanel();
            botonesColumnas.setLayout(new FlowLayout(FlowLayout.RIGHT));
            botonesColumnas.add(new BotonAñadirTarjetas(cols[i]));
            botonesColumnas.add(new BotonEliminarTarjetas(cols[i]));
            
            JPanel tarjetas = new JPanel();
            tarjetas.setLayout(new BoxLayout(tarjetas, BoxLayout.Y_AXIS));
            
            try{
                Tarjeta[] cards = cols[i].tarjetas.getArrayDataTarjetas();

                for (int j = 0; j< cards.length;j++){
                    JPanel actTarjeta = new JPanel();
                    actTarjeta.setLayout(new BoxLayout(actTarjeta, BoxLayout.Y_AXIS));
                    actTarjeta.setBorder(border);

                    actTarjeta.add(new JLabel(cards[j].title));
                    actTarjeta.add(new JLabel(cards[j].desc));
                    actTarjeta.add(new JLabel(cards[j].prioridad.toString()));
                    if (cards[j].nickColaborador.equals(""))
                        actTarjeta.add(new JLabel("No hay colaborador vinculado"));
                    else
                        actTarjeta.add(new JLabel(cards[j].nickColaborador));
                    
                    JPanel botonesTarjeta = new JPanel();
                    botonesTarjeta.setLayout(new FlowLayout(FlowLayout.RIGHT));
                    botonesTarjeta.add(new BotonComentarios(cards[j]));
                    
                    actTarjeta.add(botonesTarjeta);
                    
                    tarjetas.add(actTarjeta);
                    
                }
            }
            catch (ListaVaciaException lve){
            }
                
            columna.add(new JLabel(cols[i].nombre+" - "+cols[i].modo),BorderLayout.NORTH);
            columna.add(tarjetas,BorderLayout.CENTER);
            columna.add(botonesColumnas,BorderLayout.SOUTH);
            content.add(columna);
        }
        add(new JScrollPane(content),BorderLayout.CENTER);
        add(panelBotones,BorderLayout.SOUTH);
    }
    
}

class BotonEliminarTablero extends JButton{

    public BotonEliminarTablero(Tablero t) {
        setText("Eliminar Tablero");
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int resp = JOptionPane.showConfirmDialog(null, "Vas a eliminar un tablero, ¿Estas seguro?",
                        "Confirmacion",JOptionPane.YES_NO_OPTION);
                if (resp == 0)
                    App.gestor.deleteTablero(t);
            }
        });
        
    }
    
}

class BotonAñadirColumnas extends JButton{

    public BotonAñadirColumnas(Tablero t) {
        Tablero tab = App.gestor.getTablerosByTitle(t.nombre);
        setText("añadir columna");
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] opt = {"Cola","Pila","Lista Doble"};
                
                String opcion =(String) JOptionPane.showInputDialog(null,
                        "Selecciona el modo de la columna",
                        "Crear Columna",
                        JOptionPane.QUESTION_MESSAGE,null,opt,opt[0]);
                
                String respuesta = JOptionPane.showInputDialog("Ingresa un nombre para la columna");
                try{
                    if(opcion.equals("Cola"))
                        tab.addCols(new Columna(respuesta, Columna.Mode.COLA));
                    if(opcion.equals("Pila"))
                        tab.addCols(new Columna(respuesta, Columna.Mode.PILA));
                    if(opcion.equals("Lista Doble"))
                        tab.addCols(new Columna(respuesta, Columna.Mode.DOBLE));
                    }
                catch (InvalidNameColException ince){
                    JOptionPane.showMessageDialog(null, "Ya existe una columna con ese nombre",
                            "Validacion", JOptionPane.WARNING_MESSAGE);
                }
                catch (NameColVacioException ncve){
                    JOptionPane.showMessageDialog(null, "no puedes dejar el campo nombre en blanco",
                            "Validacion", JOptionPane.WARNING_MESSAGE);
                }
                
            }
        });
    }
}
class BotonAñadirTarjetas extends JButton{

    public BotonAñadirTarjetas(Columna c) {
        setText("Añadir Tarjeta");
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String titulo;
                String desc;
                titulo = JOptionPane.showInputDialog("Titulo para la tarjeta");
                desc = JOptionPane.showInputDialog("Descrpcion de la tarjeta");
                
                Colaborador[] colabs = App.gestor.colaboradoresRegistrados.getArrayColaborador();
                String[] optColabs = new String[colabs.length+1];
                
                optColabs[0] = "";
                
                for (int i = 0; i < colabs.length;i++){
                    optColabs[i+1] = colabs[i].nickname;
                }
                String opcionColabs =(String) JOptionPane.showInputDialog(null,
                        "Selccione el colaborador vinculado a la tarjeta",
                        "Escribir comentario",
                        JOptionPane.QUESTION_MESSAGE,null,optColabs,optColabs[0]);
                
                        
                        
                String[] opt = {"Alta","Media","Baja"};
                
                 String opcion =(String) JOptionPane.showInputDialog(null,
                        "Selccione prioridad de la tarjeta",
                        "Crear Tarjeta",
                        JOptionPane.QUESTION_MESSAGE,null,opt,opt[0]);
                        try{
                            if(opcion.equals("Alta")){
                                c.addTarjeta(new Tarjeta(titulo,desc,
                                        Tarjeta.Priority.ALTA,opcionColabs));
                            }
                            if(opcion.equals("Media")){
                                c.addTarjeta(new Tarjeta(titulo,desc,
                                        Tarjeta.Priority.MEDIA,opcionColabs));
                            }

                            if(opcion.equals("Baja")){
                                c.addTarjeta(new Tarjeta(titulo,desc,
                                        Tarjeta.Priority.BAJA,opcionColabs));
                            }
                        }
                        catch (TitleCardVacioException tcve){
                            JOptionPane.showMessageDialog(null, "no puedes dejar el campo titulo en blanco",
                            "Validacion", JOptionPane.WARNING_MESSAGE);
                        }
            }
        });
    }
    
}

class BotonEliminarTarjetas extends JButton{

    public BotonEliminarTarjetas(Columna c) {
        setText("Eliminar Tarjeta");
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int resp = JOptionPane.showConfirmDialog(null, "Vas a eliminar una tarjeta, ¿Estas seguro?",
                        "Confirmacion",JOptionPane.YES_NO_OPTION);
                try {
                    if (resp == 0)
                        c.deleteTarjeta();
                }
                catch (ListaVaciaException lve){
                     JOptionPane.showMessageDialog(null, "no hay tarjetas que eliminar",
                            "Validacion", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
    }
    
}

class BotonComentarios extends JButton {

    public BotonComentarios(Tarjeta t) {
        setText("Comentarios");
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DialogComentarios d = new DialogComentarios(t);
            }
        });
        
    }
    
}
class DialogComentarios extends JDialog {
    DefaultTableModel model;
    JTable table;
    public DialogComentarios(Tarjeta t){
        super();
        setVisible(true);
        setSize(360,360);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        Container content = getContentPane();
        JPanel panelTablaComentarios = new JPanel();
        model = new DefaultTableModel();
        table = new JTable(model);
        
        model.addColumn("Nickname");
        model.addColumn("Comentario");
        
        String[][] rowsData = t.getArrayDataComments();
        
            for (int i = 0; i < rowsData[0].length;i++){
                String[] datos = {rowsData[0][i],rowsData[1][i]};
                model.addRow(datos);
            }
            
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new FlowLayout(FlowLayout.RIGHT));
        panelBotones.add(new BotonAñadirComentario(t));
        
        content.add(new JScrollPane(table),BorderLayout.CENTER);
        content.add(panelBotones,BorderLayout.SOUTH);
    }
}
class BotonAñadirComentario extends JButton {

    public BotonAñadirComentario(Tarjeta t) {
        setText("Añadir Comentario");
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Colaborador[] colabs = App.gestor.colaboradoresRegistrados.getArrayColaborador();
                String[] opt = new String[colabs.length];
                
                for (int i = 0; i < colabs.length;i++){
                    opt[i] = colabs[i].nickname;
                }
                String opcion =(String) JOptionPane.showInputDialog(null,
                        "Selccione el colaborador que escribe",
                        "Escribir comentario",
                        JOptionPane.QUESTION_MESSAGE,null,opt,opt[0]);
                
                String comment = JOptionPane.showInputDialog("Escribe tu comentario: ");
                t.addComentario(new Comentario(comment,opcion));
            }
        });
    }
    
}