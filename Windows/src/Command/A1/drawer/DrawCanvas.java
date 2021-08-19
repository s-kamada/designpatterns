package drawer;

import command.*;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DrawCanvas extends Canvas implements Drawable {
    // �`��F               
    private Color color;    
    // �`�悷��_�̔��a     
    private int radius;     
    // ����
    private MacroCommand history;
    // �R���X�g���N�^
    public DrawCanvas(int width, int height, MacroCommand history) {
        setSize(width, height);
        setBackground(Color.white);
        this.history = history;
        init();                             
    }
    // ����S�̂��ĕ`��
    public void paint(Graphics g) {
        history.execute();
    }
    // ������                               
    public void init() {                    
        color = Color.red;                  
        radius = 6;                         
        history.append(new ColorCommand(this, color));  
    }                                       
    // �`��
    public void draw(int x, int y) {
        Graphics g = getGraphics();
        g.setColor(color);
        g.fillOval(x - radius, y - radius, radius * 2, radius * 2);
    }
    public void setColor(Color color) {     
        this.color = color;                 
    }                                       
}
