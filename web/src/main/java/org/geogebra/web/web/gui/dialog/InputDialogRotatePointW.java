package org.geogebra.web.web.gui.dialog;

import org.geogebra.common.euclidian.EuclidianController;
import org.geogebra.common.gui.InputHandler;
import org.geogebra.common.kernel.geos.GeoElement;
import org.geogebra.common.kernel.geos.GeoPolygon;
import org.geogebra.common.kernel.kernelND.GeoPointND;
import org.geogebra.common.main.DialogManager;
import org.geogebra.common.util.AsyncOperation;
import org.geogebra.web.html5.main.AppW;

public class InputDialogRotatePointW extends InputDialogRotateW {


	private GeoPointND[] points;
	
	public InputDialogRotatePointW(AppW app, String title,
			InputHandler handler, GeoPolygon[] polys, GeoPointND[] points,
			GeoElement[] selGeos, EuclidianController ec) {
		super(app, title, handler, polys, selGeos, ec);

		this.points = points;	}


	@Override
	protected void processInput(AsyncOperation<String> callback) {

		DialogManager.rotateObject(app, inputPanel.getText(),
				rbClockWise.getValue(), polys,
				new DialogManager.CreateGeoForRotatePoint(points[0]), selGeos,
				ec, this,
				callback);
		

	}
}
