package src.indi.wree.gymManagement.utli;

import java.awt.*;

public class WindowUTI {
    public static void setFrameCenter(Container c) {

        Toolkit tk = Toolkit.getDefaultToolkit();

        //get the width and height of the window
        Dimension d = tk.getScreenSize();
        double srceenWidth = d.getWidth();
        double srceenHeigth = d.getHeight();

        //get the width and height of the frame
        int frameWidth = c.getWidth();
        int frameHeight = c.getHeight();

        //set the new width and the height
        int width = (int) (srceenWidth - frameWidth) / 2;
        int height = (int) (srceenHeigth - frameHeight) / 2;

        //set the location of the window
        c.setLocation(width, height);
    }
}
