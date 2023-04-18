package game.UIComponents;


import javax.swing.*;
import java.awt.*;

public class MainMenuPage extends Page {
    public static final String ID = "mainMenu";
    private Image img;
    public MainMenuPage(Panel panel) {
        super(panel, ID);
        // code for testing purposes
        // test image of a duck
        ImageIcon ii = new ImageIcon("images/duck.png");
        this.img = ii.getImage();
        // resize image
        this.img = this.img.getScaledInstance(64,64, Image.SCALE_DEFAULT);

    }

    @Override
    public void tick() {
        super.tick();
        if(Mouse.getInstance().leftClicked()) { // on click go to game page (testing code)
            this.getPanel().setCurrentPage(GamePage.ID);
        }
        super.tick();
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        // temporary code for testing purposes
        g2d.drawImage(this.img,0,0,this.getPanel());
        g2d.drawImage(this.img,100,300,this.getPanel());
        g2d.drawImage(this.img,200,100,this.getPanel());
        super.paintComponent(g);
    }
}
