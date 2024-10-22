package Templates;

import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseClickEventListener implements GLEventListener, MouseListener {

    private double x, y;
    @Override
    public void init(GLAutoDrawable glAutoDrawable) {
        GL gl = glAutoDrawable.getGL();
        gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f); // Set background to black
        gl.glViewport(0, 0, 500, 300);
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        gl.glOrtho(0.0, 500.0, 0.0, 300.0, -1, 1);
    }

    @Override
    public void display(GLAutoDrawable glAutoDrawable) {
        GL gl = glAutoDrawable.getGL();
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);
        gl.glColor3f(1.0f, 1.0f, 1.0f); // Set point color to white
        gl.glPointSize(5.0f);

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
    public void mouseClicked(MouseEvent e) {
        x = convertX(e.getX(), e.getComponent().getWidth());
        y = convertY(e.getY(), e.getComponent().getHeight());
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    private double convertX(double x, double width) {
        return (x / width) * 500;
    }

    private double convertY(double y, double height) {
        return (1 - y / height) * 300;
    }

}
