/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Graphics;
import javax.swing.ImageIcon;

/**
 *
 * @author Jonas Santos
 */
public class painelImagemFundo extends javax.swing.JPanel{
    
    private ImageIcon img;
    
    public painelImagemFundo(){
       img = new ImageIcon();
    } 
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        g.drawImage(img.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
    }
    
    public void setImg(ImageIcon img){
        this.img = img;
    }
    
    public ImageIcon getImg(){
        return this.img;
    }
}
