import javax.swing.*;
import java.awt.*;

public class Receipt {
    Color backdrop = new Color(30,31,34,255);
    public Receipt(){
        JFrame receipt = new JFrame();
        receipt.setBackground(backdrop);
        receipt.setSize(500,800);
        receipt.setVisible(true);
        JPanel backing = new JPanel();
        backing.setBackground(backdrop);
        backing.setBounds(0,0,500,500);
        receipt.add(backing);



    }
}
