/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crudusuarios;

import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author maycon
 */
public class CRUDUsuarios {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(600, 500));
        TelaPrincipalCRUD nc = new TelaPrincipalCRUD();
        nc.setSize(new Dimension(600, 500));
        frame.add(nc);
        frame.setVisible(true);
    }
    
}
