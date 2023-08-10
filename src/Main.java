import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ImageIcon lavenderImage = new ImageIcon("lavender250.png");
        ImageIcon lavenderImageThumbnail = new ImageIcon("lavender50.png");
        ImageIcon vanillaImage = new ImageIcon("vanilla250.png");
        ImageIcon vanillaImageThumbnail = new ImageIcon("vanilla50.png");
        ImageIcon oceanImage = new ImageIcon("ocean250.png");
        ImageIcon oceanImageThumbnail = new ImageIcon("ocean50.png");
        ImageIcon autumImage = new ImageIcon("autum250.png" );
        ImageIcon autumImageThumbnail = new ImageIcon("autum50.png" );
        ImageIcon logo = new ImageIcon("logo60.png");


        Candle tranquilLavender = new Candle("Tranquil Lavender", 1 , 25, 19.99, lavenderImage, lavenderImageThumbnail);
        Candle cozyVanilla = new Candle("Cozy Vanilla", 1 , 20, 14.99,vanillaImage,vanillaImageThumbnail);
        Candle freshOceanBreeze= new Candle("Fresh Ocean Breeze", 1 , 30, 17.99,oceanImage,oceanImageThumbnail);
        Candle spicedAutumnHarvest = new Candle("Spiced Autumn Harvest", 1 , 35, 24.99,autumImage,autumImageThumbnail);
        ArrayList<Candle> inventory = new ArrayList<Candle>();
        ArrayList<Candle> shopCart = new ArrayList<Candle>();
        inventory.add(tranquilLavender);
        inventory.add(cozyVanilla);
        inventory.add(freshOceanBreeze);
        inventory.add(spicedAutumnHarvest);

        JLabel total = new JLabel();



        GUI shop =new GUI();
        JButton checkOut = new JButton();
        checkOut.setText("Check Out");
        checkOut.setBackground(new Color(35,165,89));
        checkOut.setForeground(new Color(245,242,255));
        checkOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Receipt receipt = new Receipt();
            }
        });
        JButton remove = new JButton();
        Color removeColor = new Color(218,55,60);
        remove.setBackground(removeColor);
        remove.setForeground(new Color(245,242,255));
        remove.setSize(100,50);
        remove.setBorderPainted(false);

        remove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                remove.setBackground(new Color(148, 42, 44));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                remove.setBackground(removeColor);
            }
        });
        remove.setText("Remove Last Item");
        remove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent re) {
                if(shopCart.size() > 0){
                    shopCart.remove(shopCart.size()-1);
                    shop.clearCheckout();
                    shop.setCart(shopCart, remove, checkOut);
                }
             else{
                    shop.clearCheckout();
                    shop.setCart(shopCart, remove, checkOut);
                }
            }
        });

        for (Candle e: inventory) {
            JButton button = new JButton();
            button.setText("Add to cart");
            Color addToCartColor = new Color(87,101,242);
            button.setBackground(addToCartColor);
            button.setForeground(new Color(245,242,255));
            button.setBorderPainted(false);
            button.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    button.setBackground(new Color(51, 58, 141));
                }

                public void mouseExited(java.awt.event.MouseEvent evt) {
                    button.setBackground(addToCartColor);
                }
            });
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ev) {

                    shopCart.add(e);
                    double sum = 0.00;
                    shop.setTotal(sum);
                    shop.clearCheckout();
                    shop.setCart(shopCart,remove,checkOut);

                    System.out.println("----------------");
                }
            });
            shop.panel.add(shop.item(e.name, e.quantity, e.burnTime, e.price, e.image, button));
        }
        shop.clearCheckout();
        shop.setCart(shopCart,remove,checkOut);
        JLabel logoLabel = new JLabel();
        logoLabel.setIcon(logo);
        logoLabel.setText("Serenity Candles");
        logoLabel.setFont(new Font("Vivaldi",1,40));
        logoLabel.setHorizontalAlignment(JLabel.LEFT);
        logoLabel.setForeground(new Color(237,226,204));
        logoLabel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        shop.north.add(logoLabel);

        System.out.println(shopCart.size());
    }


}