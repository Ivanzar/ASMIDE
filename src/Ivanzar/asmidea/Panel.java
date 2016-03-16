package Ivanzar.asmidea;

import Ivanzar.asmidea.filechooser.WorkWithHotButton;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.*;
import javax.swing.text.*;

import java.awt.event.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.fife.ui.rtextarea.RTextScrollPane;

public class Panel extends JPanel implements ActionListener{
    
    JToolBar toolbar;
    
    RSyntaxTextArea textarea;
    TextLineNumber textlinenumber;
    JScrollPane scrollpane;
    
    String[] text;
    
    int strarea = 0;
    int strarean = 0;
    
    
    
    //==========COLORS===========\\
    
    final StyleContext context = new StyleContext();
    final AttributeSet redattr = context.addAttribute(context.getEmptySet(), StyleConstants.Foreground, Color.RED);
    final AttributeSet blackattr = context.addAttribute(context.getEmptySet(), StyleConstants.Foreground, Color.BLACK);
    final AttributeSet greenattr = context.addAttribute(context.getEmptySet(), StyleConstants.Foreground, Color.GREEN);
    final AttributeSet graynattr = context.addAttribute(context.getEmptySet(), StyleConstants.Foreground, Color.GRAY);
    final AttributeSet bluenattr = context.addAttribute(context.getEmptySet(), StyleConstants.Foreground, Color.BLUE);
    final AttributeSet yellownattr = context.addAttribute(context.getEmptySet(), StyleConstants.Foreground, Color.magenta);
    
    
            
    public Panel(){
        super(new BorderLayout());
    
        setBackground(Color.lightGray);
        add(addToolBar(), BorderLayout.PAGE_START);
        add(addTextArea(), BorderLayout.CENTER);
        
        //new Thread(new Start()).start();
    
    }
    
    JScrollPane addTextArea(){
        
        /*//====SET COLOR FOR WORDS=====\\
        
        DefaultStyledDocument doc = new DefaultStyledDocument(){
                @Override
                public void insertString(int offset, String str, AttributeSet a) throws BadLocationException{
                    super.insertString(offset, str, a);
                    
                    System.out.println(offset);
                
                        String text = getText(0, getLength()).toLowerCase();
                        int start_str = findStartWordChar(text, offset);
                        if(start_str < 0) start_str = 0;
                        int end_str = findEndWordChar(text, offset+str.length());
                        int WordEnd = start_str;
                        int WordStart = start_str;
                        
                        while (WordEnd <= end_str){
                            
                            if(WordEnd == end_str || String.valueOf(text.charAt(WordEnd)).matches("\\W")){
                                
                                System.out.println("ok");
                                if(text.substring(WordStart, WordEnd).matches("(\\W)*(mov|int|add|and|assume|call|clc|cld|cli|cmp|dec|div|equ|fadd|fild|fist|inc|iret|ja|jaeb|jb|jbe|jc|je|jmp|jna|jnb|jnc|jz|lods|loop|movs|mul|nop|offset|or|org|pop|popa|popf|push|pusha|pushf|rep|repe|ret|retf|scas|shl|shr|stc|std|sti|stos|sub|xchg|xor)")) 
                                    setCharacterAttributes(WordStart, WordEnd-WordStart, redattr, false);
                                else if(text.substring(WordStart, WordEnd).matches("(\\W)*(eax|ebx)")) setCharacterAttributes(WordStart, WordEnd-WordStart, greenattr, false);
                                else if(text.substring(WordStart, WordEnd).matches("(\\W)*(ax|bx|cx|dx)")) setCharacterAttributes(WordStart, WordEnd-WordStart, bluenattr, false);
                                else if(text.substring(WordStart, WordEnd).matches("(\\W)*(ah|al|bh|bl|ch|cl|dh|dl)")) setCharacterAttributes(WordStart, WordEnd-WordStart, graynattr, false);
                                else setCharacterAttributes(WordStart, WordEnd-WordStart, blackattr, false);
                                
                                WordStart = WordEnd;
                                
                                
                                System.out.println(WordEnd-WordStart);
                            
                            }
                            WordEnd++;
                            System.out.println(WordEnd);
                            
                    }
                
                }
                    
                //===WHEN CHAR DELETE===\\
                
                public void remove(int offset, int len) throws BadLocationException{
                    super.remove(offset, len);
                    
                    
                    String text = getText(0, getLength());
                        int start_str = findStartWordChar(text, offset);
                        if(start_str < 0) start_str = 0;
                        int end_str = findEndWordChar(text, offset);
                                
                                System.out.println("ok");
                                if(text.substring(start_str, end_str).matches("(\\W)*(mov|int)")) 
                                    setCharacterAttributes(start_str, end_str, redattr, false);
                                else if(text.substring(start_str, end_str).matches("(\\W)*(EAX|EBX)")) setCharacterAttributes(start_str, end_str-start_str, greenattr, false);
                                else if(text.substring(start_str, end_str).matches("(\\W)*(ax|bx|cx|dx)")) setCharacterAttributes(start_str, end_str-start_str, bluenattr, false);
                                else if(text.substring(start_str, end_str).matches("(\\W)*(ah|al|bh|bl|ch|cl|dh|dl)")) setCharacterAttributes(start_str, end_str-start_str, graynattr, false);
                                else setCharacterAttributes(start_str, end_str-start_str, blackattr, false);
                            
                            }
                
            };
        
        
    
        textarea =  new JTextPane(doc);
        
        //textarea.setContentType("text/html");
        
        textlinenumber =  new TextLineNumber(textarea, 10);
        scrollpane =  new JScrollPane(textarea);
        scrollpane.setRowHeaderView(textlinenumber);
        
        textarea.setSelectedTextColor(Color.WHITE);
        textarea.setSelectionColor(Color.BLUE);
        */
        
       textarea = new RSyntaxTextArea(20, 30);
      textarea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_ASSEMBLER_X86);
      textarea.setCodeFoldingEnabled(true);
      RTextScrollPane scrollpane = new RTextScrollPane(textarea);
        
   
        return scrollpane;
    }
    
    
    JToolBar addToolBar(){
    
        toolbar = new JToolBar("Files tree");
        
        addToolBarButton(toolbar);
        toolbar.setEnabled(false);
        
        return toolbar;
    
    }
    
    void addToolBarButton(JToolBar j){
        
        JButton openb = new JButton("Open file"); 
        openb.addActionListener(this);
        openb.setActionCommand("FOPEN");
        toolbar.add(openb);
        
        JButton saveb = new JButton("Save file");
        saveb.addActionListener(this);
        saveb.setActionCommand("FSAVE");
        toolbar.add(saveb);
        
        JButton compilb = new JButton("COMPILE");
        compilb.addActionListener(this);
        compilb.setActionCommand("FCOMPILE");
        toolbar.add(compilb);
        
        /*JButton startb = new JButton("START IN UNIX");
        startb.addActionListener(this);
        startb.setActionCommand("STARTINUNIX");
        toolbar.add(startb);*/
    
    }
    
    
    /* private int findEndWordChar(String text, int index){
            
                while(index < text.length()){
                    
                    if(String.valueOf(text.charAt(index)).matches("\\W")) break;
                
                    index++;
                
                }
            
            return index;
            
            }
    
    private int findStartWordChar(String text, int index){
            
                while(--index >= 0){
                
                    if(String.valueOf(text.charAt(index)).matches("\\W")) break;
                    
                }
            
            return index;
            
            }*/
    
    JFileChooser fc = new JFileChooser();
    WorkWithHotButton hb = new WorkWithHotButton();
    boolean start = false;

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("FOPEN")){
            
            hb.openb(fc, textarea, this);
            start = true;
        
        }
        if(e.getActionCommand().equals("FSAVE")){
        
            hb.saveb(fc, textarea, this);
            start = true;
            
        }
        if(e.getActionCommand().equals("FCOMPILE")){
            
            if(!start) JOptionPane.showMessageDialog(this, "You must save this progect or open other progect","Error",JOptionPane.ERROR_MESSAGE);
            else {
                try {
                    hb.compilb(fc);
                } catch (IOException ex) {
                    Logger.getLogger(Panel.class.getName()).log(Level.SEVERE, null, ex);
                }
            start = true;
            }
            
        }
        if(e.getActionCommand().equals("STARTINUNIX")){
            
            JOptionPane.showMessageDialog(this, "You need have dosbox\nsudo apt-get install dosbox","Info",JOptionPane.INFORMATION_MESSAGE);
        
            if(!start) JOptionPane.showMessageDialog(this, "You must save this progect or open other progect","Error",JOptionPane.ERROR_MESSAGE);
            else
            hb.startinunix(fc);
        
        }
        
    }
    
    }