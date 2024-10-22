package Templates;

import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;

public class FirstCircleEventListener implements GLEventListener {

  @Override
  public void init(GLAutoDrawable glAutoDrawable) {
    GL gl = glAutoDrawable.getGL();
    gl.glClearColor(0.0f, 1.0f, 0.0f, 1.0f);
    gl.glViewport(-250, -150, 250, 150);
    gl.glMatrixMode(GL.GL_PROJECTION);
    gl.glLoadIdentity();
    gl.glOrtho(-250.0, 250.0, -150.0, 150.0, -1, 1);
  }

  @Override
  public void display(GLAutoDrawable glAutoDrawable) {
    double x, y;
    double radius = 100;

    GL gl = glAutoDrawable.getGL();
    gl.glClear(GL.GL_COLOR_BUFFER_BIT);
    gl.glColor3f(1, 1, 0);
    gl.glBegin(GL.GL_POLYGON);
    // angle is
    // x = radius * (cosine of angle)
    // y = radius * (sine of angle)
    for (double a = 0; a < Math.toRadians(360); a += Math.toRadians(1)) {
      x = radius * (Math.cos(a));
      y = radius * (Math.sin(a));
      gl.glVertex2d(x, y);
    }
    gl.glEnd();
  }

  @Override
  public void reshape(GLAutoDrawable glAutoDrawable, int i, int i1, int i2, int i3) {

  }

  @Override
  public void displayChanged(GLAutoDrawable glAutoDrawable, boolean b, boolean b1) {

  }
}
