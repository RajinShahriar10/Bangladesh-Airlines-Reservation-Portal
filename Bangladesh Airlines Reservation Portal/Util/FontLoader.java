package Util;

import java.awt.*;
import java.io.File;

public class FontLoader {
    public static Font montserratBold;
    public static Font montserratPlain;

    static {
        try {
            montserratBold = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/Montserrat-Bold.ttf")).deriveFont(20f);
            montserratPlain = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/Montserrat-Regular.ttf")).deriveFont(14f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(montserratBold);
            ge.registerFont(montserratPlain);
        } catch (Exception e) {
            montserratBold = new Font("Arial", Font.BOLD, 20);
            montserratPlain = new Font("Arial", Font.PLAIN, 14);
            System.err.println("Montserrat font loading failed. Using default.");
        }
    }
}