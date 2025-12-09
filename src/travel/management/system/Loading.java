/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package travel.management.system;

import javax.swing.*;
import java.awt.*;

public class Loading extends JFrame  implements Runnable{
    String username;
    Thread t;
    JProgressBar bar;
    
    public void run(){
        try{
            for(int i=1;i<=101;i++){
                int max=bar.getMaximum();
                int value=bar.getValue();
                if(value < max){
                   bar.setValue(bar.getValue()+1);
                }else{
                    setVisible(false);
                    new Dashboard(username);
                }
                Thread.sleep(50);
        }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    Loading(String username){
        this.username=username;
        t=new Thread(this);
    
        setBounds(500,200,650,400);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
      
        
        JLabel text=new JLabel("YatriConnect");
        text.setBounds(50, 20, 600, 40);
        text.setForeground(new Color(0,98,227));
        text.setFont(new Font("Raleway",Font.BOLD,35));
        add(text);
        
        
         bar= new JProgressBar();
        bar.setBounds(150,100,300,35);
        bar.setStringPainted(true);
        add(bar);
        
         JLabel Loading=new JLabel("Loading wait...");
        Loading.setBounds(200, 140, 150, 30);
        Loading.setForeground(new Color(0,98,227));
        Loading.setFont(new Font("Raleway",Font.BOLD,16));
        add(Loading);
        
         JLabel lblusername=new JLabel("Welcome" + " " + username);
       lblusername.setBounds(20, 310, 400, 40);
      lblusername.setForeground(Color.RED);
       lblusername.setFont(new Font("Raleway",Font.BOLD,16));
        add(lblusername);
        t.start();
          setVisible(true);
    }
    public static void main(String[] args){
        new Loading("");
    }
}


