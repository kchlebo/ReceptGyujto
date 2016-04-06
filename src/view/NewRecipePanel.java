/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import controller.Controller;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author 604772006
 */
public class NewRecipePanel  extends JPanel{

    private JFrame pFrame;
    private JLabel cim;
    private JTextField receptNeve;
    private JTextField otevoMennyiseg;
   private JTextField otevoMegnevezes;
    private JTable otevoTabla;
    private JList otevoList;
    private JTextField receptLeiras;
    private JButton btnHozzaad;
    private JButton btnMentes;
    private JButton btnVissza;
    private JPanel guiPanel;
            
    
    public NewRecipePanel(Controller controller) {
        //construct components
        cim = new JLabel("Új recept felvétel");
        JLabel rnevLabel = new JLabel("Recept neve");
        receptNeve= new JTextField(1);
        otevoMennyiseg= new JTextField(1);
        otevoMegnevezes= new JTextField(1);
        JLabel otevLabel = new JLabel("Összetevők:");
        JLabel otevoHozzaadLabel = new JLabel("Összetevő hozzáadás");
        JLabel otevoMennyisegLabel = new JLabel("Mennyiség");
        JLabel otevoMennyisegTipusLabel = new JLabel("Mennyiség Típus");
        JLabel ujOtevLabel = new JLabel("Összetevő");
        
        otevoList= new JList(new String[]{"listelem1","listaelem2"});
        JLabel leirLabel = new JLabel("Recept leírása:");
        receptLeiras=new JTextField("leírás...");
        btnHozzaad=new JButton("Összetevő hozzáadása");
        btnMentes=new JButton("Mentés");
        btnVissza=new JButton("Vissza");
        btnVissza.addActionListener(controller.getVisszaGombListener());
        btnMentes.addActionListener(controller.getMentesGombListener());
        btnHozzaad.addActionListener(controller.getOsszetevotHozzaadListener());
        otevoList.getSelectionModel().addListSelectionListener(controller.getListaElemListener());
        otevoList.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        otevoTabla= new JTable();
        otevoTabla.setModel(new DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null}
                
            },
            new String [] {
                "Mennyiség", "Egység", "Összetevő"
            }
        ));
        
        ListSelectionModel rowSelectionModel=otevoTabla.getSelectionModel();
        rowSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        rowSelectionModel.addListSelectionListener(controller.getTablaSorListener());
        JScrollPane tableScrollPane=new JScrollPane();
        tableScrollPane.setViewportView(otevoTabla);
        
        //adjust size and set layout
        setPreferredSize (new Dimension (395, 156));
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        
        //add components
        add(cim);
        add(rnevLabel);
        add(receptNeve);
        add(otevLabel);
        add(tableScrollPane);
        add(otevoHozzaadLabel);
        add(otevoMennyisegLabel);
        add(otevoMennyiseg);
        add(otevoMennyisegTipusLabel);
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.getViewport().setView(otevoList);
        add(scrollPane);
        add(ujOtevLabel);
        add(otevoMegnevezes);
        
        
        add(btnHozzaad);
        //add(otevoTabla);
        add(leirLabel);
        add(receptLeiras);
        add(btnMentes);
        add(btnVissza);
    }
  
    public void setGuiPanel(JPanel guiPanel) {
        this.guiPanel = guiPanel;
    }

    public void setpFrame(JFrame pFrame) {
        this.pFrame = pFrame;
    }

    

    public String getReceptNeve() {
        return receptNeve.getText();
    }

    public void setReceptNeve(String receptNeve) {
        this.receptNeve.setText(receptNeve);
    }

    public ListModel getOtevoList() {
        return otevoList.getModel();
    }

    public void setOtevoList(ListModel otevoList) {
        this.otevoList.setModel(otevoList);
    }

    public String getReceptLeiras() {
        return receptLeiras.getText();
    }

    public void setReceptLeiras(String receptLeiras) {
        this.receptLeiras.setText(receptLeiras);
    }

    public TableModel getOtevoTabla() {
        return otevoTabla.getModel();
    }

    public void setOtevoTabla(TableModel otevoTabla) {
        this.otevoTabla.setModel(otevoTabla);
    }
    
    
    
    
    
    
}
