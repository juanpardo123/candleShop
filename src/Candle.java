import javax.swing.*;

public class Candle {
    String name;
    int quantity;
    int burnTime;
    double dollarTime;
    double price;

    ImageIcon image;

    ImageIcon thumbnail;

    public Candle(String qName, int qQuantity, int qBurnTime, double qPrice, ImageIcon productImage, ImageIcon productThumbnail){
        this.name = qName;
        this.quantity = qQuantity;
        this.burnTime = qBurnTime;
        this.price = qPrice;
        this.dollarTime = qPrice/Double.valueOf(qBurnTime);
        this.image = productImage;
        this.thumbnail = productThumbnail;

    }
}
