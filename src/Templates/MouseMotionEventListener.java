package Templates;

import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MouseMotionEventListener implements GLEventListener, MouseMotionListener {

  @Override
  public void init(GLAutoDrawable glAutoDrawable) {
    GL gl = glAutoDrawable.getGL();
    gl.glClearColor(0.0f, 1.0f, 0.0f, 1.0f);
    gl.glViewport(0, 0, 250, 150);
    gl.glMatrixMode(GL.GL_PROJECTION);
    gl.glLoadIdentity();
    // set the orthographic projection
    gl.glOrtho(0.0, 250.0, 0.0, 150.0, -1, 1);
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
  // convert the x coordinate to the range of the viewport
  public double convertX(double x, double width) {
    return (x / width)*250;
  }
  // convert the y coordinate to the range of the viewport
  public double convertY(double y, double height) {
    return (1-y/ height) *150;
  }

  @Override
  public void mouseMoved(MouseEvent e) {
    x = convertX(e.getX(), e.getComponent().getWidth());
    y = convertY(e.getY(), e.getComponent().getHeight());
  }

  @Override
  public void mouseDragged(MouseEvent e) {

  }
}
