package controller;

import static java.awt.geom.AffineTransform.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import javax.swing.*;

public class DrawArrow extends JComponent {
	
	private double x;
	private double y;
	private double w;
	private double h;
	
	private final int ARR_SIZE = 10;
	
	public DrawArrow(double x, double y, double w, double h){
		super.setBounds(0, 0, 2000, 2000);
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}
	void drawArrow(Graphics g1, double x1, double y1, double x2, double y2) {
		Graphics2D g = (Graphics2D) g1.create();

		double dx = x2 - x1, dy = y2 - y1;
		double angle = Math.atan2(dy, dx);
		int len = (int) Math.sqrt(dx * dx + dy * dy);
		AffineTransform at = AffineTransform.getTranslateInstance(x1, y1);
		at.concatenate(AffineTransform.getRotateInstance(angle));
		g.transform(at);

		// Draw horizontal arrow starting in (0, 0)
		g.drawLine(0, 0, len, 0);
		g.fillPolygon(new int[] { len, len - ARR_SIZE, len - ARR_SIZE, len }, new int[] { 0, -ARR_SIZE, ARR_SIZE, 0 },
				4);
	}

	public void paintComponent(Graphics g) {
//		for (int x = 15; x < 200; x += 16)
//			drawArrow(g, x, x, x, 150);
		drawArrow(g, x, y, w, h);
	}
}