/* 
GeoGebra - Dynamic Mathematics for Everyone
http://www.geogebra.org

This file is part of GeoGebra.

This program is free software; you can redistribute it and/or modify it 
under the terms of the GNU General Public License as published by 
the Free Software Foundation.

 */

/*
 * DrawVector.java
 *
 * Created on 16. Oktober 2001, 15:13
 */

package org.geogebra.common.euclidian.draw;

import java.util.ArrayList;

import org.geogebra.common.awt.GGraphics2D;
import org.geogebra.common.awt.GPoint2D;
import org.geogebra.common.awt.GRectangle;
import org.geogebra.common.euclidian.Drawable;
import org.geogebra.common.euclidian.EuclidianView;
import org.geogebra.common.euclidian.Previewable;
import org.geogebra.common.kernel.ConstructionDefaults;
import org.geogebra.common.kernel.geos.GeoElement;
import org.geogebra.common.kernel.geos.GeoVector;
import org.geogebra.common.kernel.geos.VectorHeadStyle;
import org.geogebra.common.kernel.kernelND.GeoPointND;
import org.geogebra.common.kernel.kernelND.GeoVectorND;
import org.geogebra.common.kernel.matrix.Coords;
import org.geogebra.common.util.DoubleUtil;

/**
 * 
 * @author Markus
 */
public class DrawVector extends Drawable implements Previewable, VectorVisibility {

	private GeoVectorND v;

	private boolean isVisible;
	private boolean labelVisible;
	private boolean traceDrawingNeeded = false;

	private final double[] coordsA = new double[2];
	private final double[] coordsB = new double[2];
	private final double[] coordsV = new double[2];
	private ArrayList<GeoPointND> points;
	private final GPoint2D endPoint = new GPoint2D();

	private DrawVectorStyle drawVectorShape;
	private VectorShape vectorShape;

	/**
	 * Creates new DrawVector
	 * 
	 * @param view
	 *            view
	 * @param v
	 *            vector
	 */
	public DrawVector(EuclidianView view, GeoVectorND v) {
		this.view = view;
		this.v = v;
		geo = (GeoElement) v;
		createVectorStyle();
		update();
	}

	private void createVectorStyle() {
		this.drawVectorShape = new DrawVectorShape(this, view);
	}

	/**
	 * @param view
	 *            view
	 * @param points
	 *            start point and end point
	 */
	public DrawVector(EuclidianView view, ArrayList<GeoPointND> points) {
		this.view = view;
		this.points = points;
		geo = view.getKernel().getConstruction().getConstructionDefaults()
				.getDefaultGeo(ConstructionDefaults.DEFAULT_VECTOR);
		createVectorStyle();
		updatePreview();
	}

	@Override
	public final void update() {
		isVisible = geo.isEuclidianVisible();
		if (!isVisible) {
			return;
		}

		labelVisible = geo.isLabelVisible();
		updateStrokes(v);

		if (!updateStartPoint()) {
			return;
		}
		if (!updateVector()) {
			return;
		}
		updateEndPoint();
		updateShape();
		if (labelVisible) {
			updateLabelPosition();
		}
		updateTrace();
	}

	private void updateShape() {
		DrawVectorProperties properties = getProperties();
		VectorHeadStyle headStyle = ((GeoVector) geo).getHeadStyle();
		vectorShape = headStyle.createShape(properties);
		drawVectorShape.update(vectorShape);
	}

	private void updateTrace() {
		traceDrawingNeeded = v.getTrace();
		if (v.getTrace()) {
			isTracing = true;
		} else {
			if (isTracing) {
				isTracing = false;
			}
		}
	}

	private void updateLabelPosition() {
		labelDesc = geo.getLabelDescription();
		// note that coordsV was normalized in setArrow()
		xLabel = (int) ((coordsA[0] + coordsB[0]) / 2.0 + coordsV[1]);
		yLabel = (int) ((coordsA[1] + coordsB[1]) / 2.0 - coordsV[0]);
		addLabelOffset();
	}

	private void updateEndPoint() {
		coordsB[0] = coordsA[0] + coordsV[0];
		coordsB[1] = coordsA[1] + coordsV[1];
	}

	private boolean updateVector() {
		Coords coords;
		coords = view.getCoordsForView(v.getCoordsInD3());
		if (is3DCoords(coords)) {
			isVisible = false;
			return false;
		}
		coordsV[0] = coords.getX();
		coordsV[1] = coords.getY();
		return true;
	}

	private boolean updateStartPoint() {
		// start point in real world coords
		if (isStartPointValid()) {
			Coords coords = view.getCoordsForView(v.getStartPoint().getInhomCoordsInD3());
			if (is3DCoords(coords)) {
				isVisible = false;
				return false;
			}
			coordsA[0] = coords.getX();
			coordsA[1] = coords.getY();
		} else {
			coordsA[0] = 0;
			coordsA[1] = 0;
		}
		return true;
	}

	private static boolean is3DCoords(Coords coords) {
		return !DoubleUtil.isZero(coords.getZ());
	}

	private boolean isStartPointValid() {
		return v.getStartPoint() != null && !v.getStartPoint().isInfinite();
	}

	private DrawVectorProperties getProperties() {
		return new DrawVectorProperties(coordsA, coordsB, coordsV, v.getLineThickness(),
				objStroke);
	}

	/**
	 * @param lineThickness
	 *            vector thickness
	 * @return arrow size
	 */
	public static double getFactor(double lineThickness) {

		// changed to make arrow-heads a bit bigger for line thickness 8-13
		return lineThickness < 8 ? 12.0 + lineThickness : 3 * lineThickness;
	}


	@Override
	public void draw(GGraphics2D g2) {
		if (!isVisible) {
			return;
		}

		if (traceDrawingNeeded) {
			drawTraceToBackground();
		}

		if (isHighlighted()) {
			drawHighlight(g2);
		}

		drawVectorShape(g2);

		if (labelVisible) {
			drawVectorLabel(g2);
		}

	}

	private void drawTraceToBackground() {
		traceDrawingNeeded = false;
		drawTrace(view.getBackgroundGraphics());
	}

	@Override
	protected final void drawTrace(GGraphics2D g2) {
		if (g2 == null) {
			return;
		}

		g2.setPaint(getObjectColor());
		g2.setStroke(objStroke);
		g2.fill(drawVectorShape.getShape());
	}

	private void drawHighlight(GGraphics2D g2) {
		g2.setPaint(v.getSelColor());
		g2.setStroke(selStroke);
		if (isVisible) {
			g2.draw(drawVectorShape.getShape());
		}
	}

	private void drawVectorShape(GGraphics2D g2) {
		g2.setPaint(getObjectColor());
		g2.setStroke(objStroke);

		drawVectorShape.draw(g2);
	}

	private void drawVectorLabel(GGraphics2D g2) {
		g2.setFont(view.getFontVector());
		g2.setPaint(v.getLabelColor());
		drawLabel(g2);
	}

	@Override
	public final void updatePreview() {
		isVisible = points.size() == 1;
		if (isVisible) {
			// start point
			view.getCoordsForView(points.get(0).getInhomCoordsInD3())
					.get(coordsA);
			coordsB[0] = coordsA[0];
			coordsB[1] = coordsA[1];
		}
	}

	@Override
	public final void updateMousePos(double xRWmouse, double yRWmouse) {
		double xRW = xRWmouse;
		double yRW = yRWmouse;
		if (isVisible) {

			// round angle to nearest 15 degrees if alt pressed
			if (points.size() == 1
					&& view.getEuclidianController().isAltDown()) {
				GeoPointND p = points.get(0);
				double px = p.getInhomX();
				double py = p.getInhomY();
				double angle = Math.atan2(yRW - py, xRW - px) * 180 / Math.PI;
				double radius = Math.sqrt(
						(py - yRW) * (py - yRW) + (px - xRW) * (px - xRW));

				// round angle to nearest 15 degrees
				angle = Math.round(angle / 15) * 15.0;

				xRW = px + radius * Math.cos(angle * Math.PI / 180);
				yRW = py + radius * Math.sin(angle * Math.PI / 180);

				endPoint.setLocation(xRW, yRW);
				view.getEuclidianController().setLineEndPoint(endPoint);
			} else {
				view.getEuclidianController().setLineEndPoint(null);
			}

			if (!points.isEmpty()) {
				view.getCoordsForView(points.get(0).getInhomCoordsInD3())
						.get(coordsA);
			}

			coordsB[0] = xRW;
			coordsB[1] = yRW;
			drawVectorShape.update(vectorShape);
		}
	}

	@Override
	public final void drawPreview(GGraphics2D g2) {
		if (isVisible) {
			g2.setPaint(getObjectColor());
			updateStrokes(geo);
			g2.setStroke(objStroke);
			g2.fill(drawVectorShape.getShape());
		}
	}

	@Override
	public void disposePreview() {
		// do nothing
	}

	@Override
	public final boolean hit(int x, int y, int hitThreshold) {
		return drawVectorShape.getShape().intersects(x - 3, y - 3, 6, 6);
	}

	@Override
	public final boolean isInside(GRectangle rect) {
		return rect.contains(drawVectorShape.getShape().getBounds());
	}

	@Override
	public boolean intersectsRectangle(GRectangle rect) {
		return rect.intersects(drawVectorShape.getShape().getBounds());
	}

	/**
	 * Returns the bounding box of this Drawable in screen coordinates.
	 */
	@Override
	public final GRectangle getBounds() {
		return drawVectorShape.getShape().getBounds();
	}


	@Override
	public void setVisible(boolean visible) {
		this.isVisible = visible;
	}

	@Override
	public boolean isVisible() {
		return isVisible;
	}
}
