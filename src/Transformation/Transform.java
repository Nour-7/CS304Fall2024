package Transformation;

import java.awt.BorderLayout;
import javax.media.opengl.GLCanvas;
import javax.swing.JFrame;

public class Transform extends JFrame {

  private GLCanvas glcanvas;
  private TransformGLEventListener listener = new TransformGLEventListener();

  public static void main(String[] args) {
    new Transform();
  }

  public Transform() {

    super("Transform");

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    glcanvas = new GLCanvas();
    glcanvas.addGLEventListener(listener);

    getContentPane().add(glcanvas, BorderLayout.CENTER);
    setSize(500, 300);
    setLocationRelativeTo(this);
    setVisible(true);
  }
}
