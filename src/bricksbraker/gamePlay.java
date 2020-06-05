/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bricksbraker;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author prasa
 */
public class gamePlay extends JPanel implements KeyListener, ActionListener{

        private boolean play=false;
        private int score=0;
        private int totalBricks=21;
        
        private Timer time;
        private int delay=8;
        
        private int playerX=310;
        
        private int ballposX=120;
        private int ballposY=350;
        private int ballXdir=-1;
        private int ballYdir=-2;
    
        public gamePlay(){
            addKeyListener(this);
             setFocusable(true);
             setFocusTraversalKeysEnabled(false);
             
             time=new Timer(delay, this);
             time.start();
            
            
        }
        
        
    
    public void paint(Graphics g){
    //background
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 692,592);
        
        
        //borders
        g.setColor(Color.YELLOW);
        g.fillRect(0, 0, 3, 592);
        g.fillRect(0, 0, 692, 3);
        g.fillRect(691, 0, 3, 592);
        
        
        //paddle
        g.setColor(Color.GREEN);
        g.fillRect(playerX, 550, 100, 8);
        
        
        //paddle2
        g.setColor(Color.GREEN);
        g.fillRect(playerX, 100,100 , 8);
        
        
        
        //ball
        g.setColor(Color.YELLOW);
        g.fillOval(ballposX, ballposY, 20, 20);
        
        
        //End
        if(ballposY>570)
        {
            play=false;
            ballXdir=0;
            ballYdir=0;
            g.setColor(Color.red);
            g.setFont(new Font("serif",Font.BOLD,50));
            g.drawString("GAME OVER", 190, 300);
        }
        
        
        g.dispose();
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
        if(e.getKeyCode()==KeyEvent.VK_RIGHT){
            if(playerX>=600)
            {
                playerX=600;
            }
            else
            {
                moveRight();
            }
        
        }
        if(e.getKeyCode()==KeyEvent.VK_LEFT){
        
            if(playerX<=10)
            {
                playerX=10;
            }
            else
            {
                moveLeft();
            }
        }
        
        
       
    }
    public void moveRight()
    {
        play=true;
        playerX+=20;
    }
     public void moveLeft()
    {
        play=true;
        playerX-=20;
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        time.start();
        if(play)
        {
            if(new Rectangle(ballposX,ballposY,20,20).intersects(new Rectangle(playerX, 550, 100, 8)))
            {
                ballYdir=-ballYdir;
            }
            if(new Rectangle(ballposX,ballposY,20,20).intersects(new Rectangle(playerX, 100, 100, 8)))
            {
                ballYdir=-ballYdir;
            }
            
            ballposX+=ballXdir;
            ballposY+=ballYdir;
            if(ballposX<0)
            {
                ballXdir=-ballXdir;
                }
            if(ballposY<0)
            {
                ballYdir=-ballYdir;
                }
            if(ballposX>670)
            {
                ballXdir=-ballXdir;
                }
        }
        repaint();
    }
    
}
