package game.UIComponents;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashSet;

public class MorrisMouseListener implements MouseListener {
    private HashSet<Integer> heldSet = new HashSet<Integer>();
    private HashSet<Integer> clickedSet = new HashSet<Integer>();

    /**
     *
     * @param e
     */
    @Override
    public void mouseClicked(MouseEvent e) {
    }

    /**
     *
     * @param e
     */
    // calculates whether the mouse has been clicked or held
    @Override
    public void mousePressed(MouseEvent e) {
        if(!this.heldSet.contains(e.getButton())) {
            this.clickedSet.add(e.getButton());
        }
        this.heldSet.add(e.getButton());
    }

    /**
     *
     * @param e
     */
    @Override
    public void mouseReleased(MouseEvent e) {
        this.heldSet.remove(e.getButton());
    }

    /**
     *
     * @param e
     */
    @Override
    public void mouseEntered(MouseEvent e) {
    }

    /**
     *
     * @param e
     */
    @Override
    public void mouseExited(MouseEvent e) {
    }

    // clicking should only last a single frame
    /**
     *
     */
    public void tick() {
        this.clickedSet.clear();
    }

    /**
     *
     * @param button
     * @return
     */
    public boolean clicked(int button) {return clickedSet.contains(button);}
    /**
     *
     * @param button
     * @return
     */
    public boolean held(int button) {return heldSet.contains(button);}
}
