package game.UIComponents;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class Panel extends JPanel implements ActionListener {
    private final int DELAY;
    private HashMap<String, Page> pageHash;
    private Page currentPage;
    private Frame frame;
    private Timer timer;

    public Panel(Frame frame) {
        this.frame = frame;
        setBackground(new Color(128,128,128));
        this.DELAY = 20; // 50 fps
        this.pageHash = new HashMap<>();
        // start at main menu
        this.registerPage(new MainMenuPage(this));
        this.registerPage(new GamePage(this));
        this.registerPage(new ConfirmPage(this));
        this.setCurrentPage(MainMenuPage.ID); // goto game page directly for now
        // timer for running things every frame
        timer = new Timer(DELAY, this);
        timer.start();
    }
    public Frame getFrame() {return frame;}

    // add page into registry
    public void registerPage(Page page) {this.pageHash.put(page.getId(),page);}
    // set page based on ID
    public void setCurrentPage(String id) {
        Page s = this.pageHash.get(id);
        if(s==null) {
            throw new RuntimeException("ERROR: page doesn't exist");
        }
        else {
            this.currentPage = s;
        }
    }
    // run every frame
    @Override
    public void actionPerformed(ActionEvent e) {
        Mouse.getInstance().setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); // by default the basic cursor should be used unless some code changes that

        Mouse.getInstance().tickStart(this.getFrame());
        this.currentPage.tick(); // run page specific stuff
        Mouse.getInstance().tickEnd();
    }

    // draw everything onto the screen
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(this.currentPage!=null) {
            this.currentPage.paintComponent(g);
        }
        // ensures that images are up to date
        repaint();
        Toolkit.getDefaultToolkit().sync();
    }
}
