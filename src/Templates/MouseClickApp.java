package Templates;

import com.sun.opengl.util.FPSAnimator;

import javax.media.opengl.GLCanvas;
import javax.swing.*;
import java.awt.*;

public class MouseClickApp extends JFrame {

    private GLCanvas glcanvas;
    public static FPSAnimator animator = null;
    private MouseClickEventListener listener = new MouseClickEventListener();

    public static void main(String[] args) {
        new MouseClickApp();
        animator.start();
    }

    public MouseClickApp() {
        super("Mouse Click Point Drawing");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        glcanvas = new GLCanvas();
        animator = new FPSAnimator(glcanvas, 60);
        glcanvas.addGLEventListener(listener);
        glcanvas.addMouseListener(listener);
        getContentPane().add(glcanvas, BorderLayout.CENTER);
        glcanvas.setFocusable(true);
        setSize(500, 300);
        setLocationRelativeTo(this);
        setVisible(true);
    }
}
