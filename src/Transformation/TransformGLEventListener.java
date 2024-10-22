package Transformation;

import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;


public class TransformGLEventListener implements GLEventListener {

  @Override
  public void init(GLAutoDrawable glAutoDrawable) {
    GL gl = glAutoDrawable.getGL();
    gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
    gl.glLineWidth(2.0f);
    gl.glMatrixMode(GL.GL_PROJECTION);
    gl.glLoadIdentity();
    gl.glOrtho(-250.0, 250.0, -150.0, 150.0, -1, 1);
  }

  @Override
  public void display(GLAutoDrawable glAutoDrawable) {
    GL gl = glAutoDrawable.getGL();
    gl.glClear(GL.GL_COLOR_BUFFER_BIT);
    drawGraph(gl);
    gl.glPushMatrix();
    gl.glTranslated(200, 00, 0);
    gl.glScaled(0.3, 0.3, 1);
    drawTriangle(gl, 90, 0, 50);
    drawTriangle(gl, 0, 0, 60);
    drawTriangle(gl, -100, 0, 70);
    gl.glPopMatrix();

  }

  @Override
  public void reshape(GLAutoDrawable glAutoDrawable, int i, int i1, int i2, int i3) {

  }

  @Override
  public void displayChanged(GLAutoDrawable glAutoDrawable, boolean b, boolean b1) {

  }

  private void drawTriangle(GL gl, int x, int y, int radius) {
    float red = 1f;
    float green = 220f / 255;
    float blue = 0.0f;

    gl.glBegin(GL.GL_TRIANGLES);
    gl.glColor3f(red, green, blue);
    gl.glVertex2d(x, y + radius);
    
    gl.glColor3f(red, green - 0.1f, blue);
    gl.glVertex2d(x - radius, y - radius);
  
    gl.glColor3f(red, green, blue);
    gl.glVertex2d(x + radius, y - radius);
  
    gl.glEnd();

  }

  private void drawGraph(GL gl) {
    float red;
    float green;
    float blue;
    ////////////////////
    // drawing the grid
    red = 0.2f;
    green = 0.2f;
    blue = 0.2f;
    gl.glColor3f(red, green, blue);
    // You may notice I'm using GL_LINES here.
    // Details of glBegin() will be discussed latter.
    gl.glBegin(GL.GL_LINES);
    // draw the vertical lines
    for (int x = -250; x <= 250; x += 10) {
      gl.glVertex2d(x, -150);
      gl.glVertex2d(x, 150);
    }
    // draw the horizontal lines
    for (int y = -150; y <= 150; y += 10) {
      gl.glVertex2d(-250, y);
      gl.glVertex2d(250, y);
    }
    gl.glEnd();
    //////////////////////////////
    // draw the x-axis and y-axis
    red = 0.0f;
    green = 0.2f;
    blue = 0.4f;
    gl.glColor3f(red, green, blue);
    gl.glBegin(GL.GL_LINES);
    // line for y-axis
    gl.glVertex2d(0, 140);
    gl.glVertex2d(0, -140);
    // line for x-axis
    gl.glVertex2d(240, 0);
    gl.glVertex2d(-240, 0);
    gl.glEnd();
    /////////////////////
    // draw arrow heads
    gl.glBegin(GL.GL_TRIANGLES);
    gl.glVertex2d(0, 150);
    gl.glVertex2d(-5, 140);
    gl.glVertex2d(5, 140);
    gl.glVertex2d(0, -150);
    gl.glVertex2d(-5, -140);
    gl.glVertex2d(5, -140);
    gl.glVertex2d(250, 0);
    gl.glVertex2d(240, -5);
    gl.glVertex2d(240, 5);
    gl.glVertex2d(-250, 0);
    gl.glVertex2d(-240, -5);
    gl.glVertex2d(-240, 5);
    gl.glEnd();
  }
}
