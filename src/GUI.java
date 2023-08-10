import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.ArrayList;

public class GUI extends JFrame {
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();

    JLabel total = new JLabel();
    JPanel south = new JPanel();

    JPanel east = new JPanel();
    Color backdrop = new Color(30,31,34,255);
    Color centerDrop = new Color(43,45,49,255);

    Color text = new Color(148,155,164,255);
    JPanel north = new JPanel();
    public GUI(){



        south.setBackground(new Color(31,31,39));
        south.setPreferredSize(new Dimension(50,50));
        south.setBorder(BorderFactory.createLineBorder(new Color(250,250,250, 23),1));
        south.setLayout(new FlowLayout());

        frame.setBackground(backdrop);
        north.setBackground(backdrop);


        north.setPreferredSize(new Dimension(50,100));


        total.setForeground(Color.blue);
        east.add(total);

        east.setPreferredSize(new Dimension(250,50));
        east.setBackground(new Color(17, 18, 20));
        east.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0, 40),1,true));
        east.setLayout(new BoxLayout(east,BoxLayout.Y_AXIS));
        JPanel west = new JPanel();
        west.setBackground(backdrop);
        west.setPreferredSize(new Dimension(50,50));


        panel.setLayout(new GridLayout(2,2,25,25));
        panel.setPreferredSize(new Dimension(800,800));

        panel.setBackground(centerDrop);



        frame.setVisible(true);
        frame.setSize(new Dimension(1400,788));
        frame.setResizable(false);
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        frame.add(panel,BorderLayout.CENTER);
        frame.add(north,BorderLayout.NORTH);
        frame.add(south, BorderLayout.SOUTH);
        frame.add(east,BorderLayout.EAST);
        frame.add(west,BorderLayout.WEST);
        panel.setBorder(BorderFactory.createEmptyBorder(50,50,50,50));


    }

    public JPanel item(String candleName, int candleQuantity, int candleBurnTime, double candlePrice, ImageIcon candleImage, JButton candleButton){
        JPanel item = new JPanel();
        item.setPreferredSize(new Dimension(300,300));
        item.setLayout(new GridLayout(1,2));
        Font details = new Font("Futura",2,24);
        JLabel title = new JLabel();


        title.setFont(details);
        title.setForeground(text);
        JLabel burnTime = new JLabel();
        burnTime.setForeground(text);
        JLabel image = new JLabel();

        JLabel dollarTime = new JLabel();
        dollarTime.setForeground(text);
        JLabel price = new JLabel();
        price.setForeground(text);


        item.setBackground(centerDrop);
        title.setText(candleName);
        title.setVerticalAlignment(JLabel.CENTER);
        title.setHorizontalAlignment(JLabel.CENTER);
        image.setIcon(candleImage);
        System.out.println(candleImage);
        image.setVisible(true);
        image.setSize(250,250);
        burnTime.setText("Quantity: " + String.valueOf(candleQuantity));
        burnTime.setBorder(BorderFactory.createEmptyBorder(0,50,0,0));
        dollarTime.setText(String.valueOf("Burn Time: " + candleBurnTime));
        dollarTime.setBorder(BorderFactory.createEmptyBorder(0,50,0,0));
        price.setText("Price: $" + String.valueOf(candlePrice));
        price.setBorder(BorderFactory.createEmptyBorder(0,50,0,0));
        item.add(image);
        JPanel detailsPanel = new JPanel();
        detailsPanel.setLayout(new GridLayout(5,1));
        detailsPanel.add(title);
        detailsPanel.add(burnTime);
        detailsPanel.add(dollarTime);
        detailsPanel.add(price);
        detailsPanel.add(candleButton);

        item.add(detailsPanel);
//
//


        item.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0, 21),3,true));
        item.setBackground(new Color(44, 44, 51,255));
        detailsPanel.setBackground(new Color(44, 44, 51,255));
        pack();

        return item;
    }

    public void setTotal(double price){

        total.setText("Total: "+ String.valueOf(price));
    }
    public void setCart(ArrayList<Candle> cart, JButton remove, JButton checkOut){
        double totalprice = 0.00;
        int totalBurnTime = 0;
        JLabel title = new JLabel();
        title.setSize(50,250);
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setVerticalAlignment(JLabel.CENTER);
        title.setForeground(text);
        title.setFont(new Font("Futura",3,18));
        east.add(title);

        if(cart.size()>-1){
            title.setText("Your Cart");
            for (Candle e: cart) {
                JLabel name = new JLabel();
                name.setIcon(e.thumbnail);
                name.setHorizontalAlignment(JLabel.LEFT);
                name.setVerticalAlignment(JLabel.CENTER);
                name.setForeground(text);
                JPanel totalItems = new JPanel();
                totalItems.setBackground(new Color(40, 48, 61, 77));
                JLabel price = new JLabel();
                price.setHorizontalAlignment(JLabel.RIGHT);
                price.setVerticalAlignment(JLabel.CENTER);
                price.setForeground(text);
                JLabel burnTime = new JLabel();
                burnTime.setForeground(text);
                name.setText(e.name);
                price.setText("$ "+String.valueOf(e.price));
                burnTime.setText(String.valueOf(e.burnTime));
                totalItems.add(name);
                totalItems.add(price);
                //totalItems.add(burnTime);
                east.add(totalItems);
                east.revalidate();
                totalprice += e.price;
                totalBurnTime += e.burnTime;
            }
            east.setLayout(new GridLayout(cart.size()+1,1));
        }
        if (cart.size()==0){
            title.setText("No items in your cart");
            title.setBackground(new Color(240,177,50));
        }

        Font southFont = new Font("Futura",1,18);
        JLabel price = new JLabel();
        price.setForeground(text);
        price.setFont(southFont);
        JLabel burnTime = new JLabel();
        burnTime.setForeground(text);
        burnTime.setFont(southFont);
        JLabel dollarTime = new JLabel();
        dollarTime.setForeground(text);
        dollarTime.setFont(southFont);

        price.setText("Total Price: $" + String.valueOf((double) Math.round(totalprice * 100) / 100) + " | ");
        burnTime.setText("Total Burn Time: " + String.valueOf(totalBurnTime ) + " hrs" + " | " );
        dollarTime.setText(String.valueOf("Dollar per Burn Time: " + (double) Math.round((totalBurnTime/totalprice) * 100) / 100)  + " | " );

        JLabel totalQuantity = new JLabel();
        totalQuantity.setText("Total Quantity: "+String.valueOf(cart.size())+" | ");
        totalQuantity.setForeground(text);
        totalQuantity.setFont(southFont);
        south.add(price);
        south.add(burnTime);
        south.add(dollarTime);
        south.add(totalQuantity);
        south.add(remove);
        south.add(checkOut);
        south.revalidate();
    }

    public void clearCheckout(){
        east.removeAll();
        south.removeAll();
        east.revalidate();
        south.revalidate();
    }
}
