package game.UIComponents;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashSet;

public class MorrisMouseListener implements MouseListener {
    private HashSet<Integer> heldSet = new HashSet<Integer>();
    private HashSet<Integer> clickedSet = new HashSet<Integer>();

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    // calculates whether the mouse has been clicked or held
    @Override
    public void mousePressed(MouseEvent e) {
        if(!this.heldSet.contains(e.getButton())) {
            this.clickedSet.add(e.getButton());
        }
        this.heldSet.add(e.getButton());
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        this.heldSet.remove(e.getButton());
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    // clicking should only last a single frame
    public void tick() {
        this.clickedSet.clear();
    }

    public boolean clicked(int button) {return clickedSet.contains(button);}
    public boolean held(int button) {return heldSet.contains(button);}
}
