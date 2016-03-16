package Ivanzar.asmidea;

import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.*;

public class CodeFrame extends JInternalFrame implements ActionListener{
    
    static int frameCount = 0;
    
    JMenuBar menuBar;
    JMenu menu;
    JMenuItem menuItem;
    
    JDesktopPane desktop;
    
    BufferedImage logo;
    
    Panel p = new Panel();
    
    public CodeFrame(){
        super("Progect #"+(++frameCount),
                true,
                true,
                true,
                true);
        
        try {
            logo = ImageIO.read(new File("images\\logo2.png"));
            this.setIcon(true);
        } catch (Exception e) {
        }
        
        setBounds(0, 0,
                  300, 300);
        
        add(p);
        setJMenuBar(createMenu());
    
    }
    
    JMenuBar createMenu(){
    
        menuBar =  new JMenuBar();
        menu = new JMenu("Config");
        menu.getAccessibleContext().setAccessibleDescription("Setings");
        menuBar.add(menu);
        
        menuItem =  new JMenuItem("compile");
        menuItem.getAccessibleContext().setAccessibleDescription("Add new progect");
        menuItem.setActionCommand("FCOMPILE");
        menuItem.addActionListener(p);
        //menuItem.setToolTipText("Crt+N");
        menu.add(menuItem);
        
        menuItem =  new JMenuItem("save");
        menuItem.getAccessibleContext().setAccessibleDescription("Add new progect");
        menuItem.setActionCommand("FSAVE");
        menuItem.addActionListener(p);
        //menuItem.setToolTipText("Crt+N");
        menu.add(menuItem);
        
        menuItem =  new JMenuItem("open");
        menuItem.getAccessibleContext().setAccessibleDescription("Add new progect");
        menuItem.setActionCommand("FOPEN");
        menuItem.addActionListener(p);
        //menuItem.setToolTipText("Crt+N");
        menu.add(menuItem);
        
        menu.getAccessibleContext().setAccessibleDescription("Setings");
        menuBar.add(menu);
        
        menuItem =  new JMenuItem("start in UNIX(.com)");
        menuItem.getAccessibleContext().setAccessibleDescription("Add new progect");
        menuItem.setActionCommand("STARTINUNIX");
        menuItem.addActionListener(p);
        //menuItem.setToolTipText("Crt+N");
        menu.add(menuItem);
    
        return menuBar;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    
}
