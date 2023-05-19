package game.UIComponents;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashSet;

public class MorrisMouseListener implements MouseListener {
    private HashSet<Integer> heldSet = new HashSet<Integer>();
    private HashSet<Integer> clickedSet = new HashSet<Integer>();

    /**
     * unused mandatory function
     * @param e event object
     */
    @Override
    public void mouseClicked(MouseEvent e) {
    }

    /**
     * calculates whether the mouse has been clicked or held
     * @param e event object
     */
    @Override
    public void mousePressed(MouseEvent e) {
        if(!this.heldSet.contains(e.getButton())) {
            this.clickedSet.add(e.getButton());
        }
        this.heldSet.add(e.getButton());
    }

    /**
     * unused mandatory function
     * @param e event object
     */
    @Override
    public void mouseReleased(MouseEvent e) {
        this.heldSet.remove(e.getButton());
    }

    /**
     * unused mandatory function
     * @param e event object
     */
    @Override
    public void mouseEntered(MouseEvent e) {
    }

    /**
     * unused mandatory function
     * @param e event object
     */
    @Override
    public void mouseExited(MouseEvent e) {
    }

    /**
     * clear clicked set so that clicking only lasts a single frame
     */
    public void tick() {
        this.clickedSet.clear();
    }

    /**
     * check whether a mouse click occurred
     * @param button 1 = left, 2 = middle, 3 = right
     * @return whether a mouse click occurred
     */
    public boolean clicked(int button) {return clickedSet.contains(button);}
    /**
     * check whether the mouse is being held
     * @param button 1 = left, 2 = middle, 3 = right
     * @return whether the mouse is being held
     */
    public boolean held(int button) {return heldSet.contains(button);}
}
