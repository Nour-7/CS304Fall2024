package Templates;

import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyTypeEventListener implements GLEventListener, KeyListener {

  @Override
  public void init(GLAutoDrawable glAutoDrawable) {
    GL gl = glAutoDrawable.getGL();
    gl.glClearColor(0.0f, 1.0f, 0.0f, 1.0f);
    gl.glViewport(-250, -150, 250, 150);
    gl.glMatrixMode(GL.GL_PROJECTION);
    gl.glLoadIdentity();
    // set the orthographic projection
    gl.glOrtho(-250.0, 250.0, -150.0, 150.0, -1, 1);
  }
  // set the initial position
  double x = 0;
  double y = 0;

  @Override
  public void display(GLAutoDrawable glAutoDrawable) {

    GL gl = glAutoDrawable.getGL();
    // clear the color buffer
    gl.glClear(GL.GL_COLOR_BUFFER_BIT);
    // set the color to yellow
    gl.glColor3f(1, 1, 0);
    // set the point size
    gl.glPointSize(10);
    // draw a point
    gl.glBegin(GL.GL_POINTS);
    gl.glVertex2d(x, y);
    gl.glEnd();
  }

  @Override
  public void reshape(GLAutoDrawable glAutoDrawable, int i, int i1, int i2, int i3) {

  }

  @Override
  public void displayChanged(GLAutoDrawable glAutoDrawable, boolean b, boolean b1) {

  }

  @Override
  public void keyTyped(KeyEvent e) {

  }

  @Override
  public void keyPressed(KeyEvent e) {
    // get the key code
    int keyCode = e.getKeyCode();
    // check the tyoe of the key
    if (keyCode == KeyEvent.VK_UP) {
      y += 10;
    }
    if (keyCode == KeyEvent.VK_DOWN) {
      y -= 10;
    }
    if (keyCode == KeyEvent.VK_LEFT) {
      x -= 10;
    }
    if (keyCode == KeyEvent.VK_RIGHT) {
      x += 10;
    }
  }

  @Override
  public void keyReleased(KeyEvent e) {

  }
}
