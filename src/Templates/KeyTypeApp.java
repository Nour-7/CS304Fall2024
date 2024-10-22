package Templates;

import com.sun.opengl.util.FPSAnimator;

import javax.media.opengl.GLCanvas;
import javax.swing.*;
import java.awt.*;

public class KeyTypeApp extends JFrame {

  private GLCanvas glcanvas;
  public static FPSAnimator animator = null;
  private KeyTypeEventListener listener = new KeyTypeEventListener();

  public static void main(String[] args) {
    new KeyTypeApp();
    animator.start();
  }

  public KeyTypeApp() {
    //set the JFrame title
    super("First Circle Using Sine and Cosine");
    //kill the process when the JFrame is closed
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    glcanvas = new GLCanvas();
    // initialize the animator with the GLCanvas and the frame rate
    animator = new FPSAnimator(glcanvas, 60);
    // add the GLEventListener to the GLCanvas
    glcanvas.addGLEventListener(listener);
    // add the key listener to the GLCanvas
    glcanvas.addKeyListener(listener);
    //add the GLCanvas just like we would any Component
    getContentPane().add(glcanvas, BorderLayout.CENTER);
    // set the focus to the GLCanvas
    glcanvas.setFocusable(true);
    // set the size of the JFrame
    setSize(500, 300);
    // set the location of the JFrame
    setLocationRelativeTo(this);
    // make the JFrame visible
    setVisible(true);
  }

}

  