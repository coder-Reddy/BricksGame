/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bricksbraker;

import javax.swing.JFrame;

/**
 *
 * @author prasa
 */
public class BricksBraker {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
             JFrame frame=new JFrame();
             gamePlay gaPlay=new gamePlay();
             
             frame.setBounds(10, 10, 700, 600);
             frame.setResizable(false);
             frame.setVisible(true);
             frame.setTitle("Bricks Braker");
             frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             frame.add(gaPlay);
    }
    
}
