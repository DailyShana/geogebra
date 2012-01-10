package geogebra.web;


import java.util.HashMap;

import geogebra.common.kernel.commands.AlgebraProcessor;
import geogebra.common.main.AbstractApplication;
import geogebra.web.main.Application;
import geogebra.web.mvp4g.Mvp4gModule;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.Widget;



/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Web implements EntryPoint {
	public void t(String s,AlgebraProcessor ap) throws Exception{
		ap.processAlgebraCommandNoExceptionHandling(s, false,false, true);
	}
	private String defaultCons =
			"<?xml version=\"1.0\" encoding=\"utf-8\"?>"
					+"<geogebra format=\"4.0\" id=\"b1447de8-445d-4492-8f5d-9714fa7f9417\"  xsi:noNamespaceSchemaLocation=\"http://www.geogebra.org/ggb.xsd\" xmlns=\"\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" >"
					+"<gui>"
					+"	<window width=\"800\" height=\"600\" />"
					+"	<perspectives>"
					+"<perspective id=\"tmp\">"
					+"	<panes>"
					+"		<pane location=\"\" divider=\"0.2575\" orientation=\"1\" />"
					+"	</panes>"
					+"	<views>"
					+"		<view id=\"4\" toolbar=\"0 || 2020 , 2021 , 2022 , 66 || 2001 , 2003 , 2002 , 2004 , 2005 || 2040 , 2041 , 2042 , 2044 , 2043\" visible=\"false\" inframe=\"false\" stylebar=\"false\" location=\"1,1\" size=\"300\" window=\"100,100,600,400\" />"
					+"		<view id=\"1\" visible=\"true\" inframe=\"false\" stylebar=\"false\" location=\"1\" size=\"578\" window=\"100,100,600,400\" />"
					+"		<view id=\"2\" visible=\"true\" inframe=\"false\" stylebar=\"false\" location=\"3\" size=\"206\" window=\"100,100,250,400\" />"
					+"		<view id=\"16\" visible=\"false\" inframe=\"true\" stylebar=\"false\" location=\"1\" size=\"150\" window=\"50,50,500,500\" />"
					+"		<view id=\"32\" visible=\"false\" inframe=\"true\" stylebar=\"true\" location=\"1\" size=\"150\" window=\"50,50,500,500\" />"
					+"		<view id=\"64\" visible=\"false\" inframe=\"true\" stylebar=\"false\" location=\"1\" size=\"150\" window=\"50,50,500,500\" />"
					+"	</views>"
					+"	<toolbar show=\"true\" items=\"0 39 59 || 1 501 67 , 5 19 , 72 | 2 15 45 , 18 65 , 7 37 | 4 3 8 9 , 13 44 , 58 , 47 || 16 51 64 , 70 | 10 34 53 11 , 24  20 22 , 21 23 | 55 56 57 , 12 || 36 46 , 38 49 50 , 71 | 30 29 54 32 31 33 | 17 26 62 73 , 14 66 68 | 25 52 60 61 || 40 41 42 , 27 28 35 , 6\" />"
					+"	<input show=\"true\" cmd=\"true\" top=\"false\" />"
					+"</perspective>"
					+"	</perspectives>"
					+"	<labelingStyle  val=\"3\"/>"
					+"	<font  size=\"12\"/>"
					+"	<graphicsSettings javaLatexFonts=\"false\"/>"
					+"	<consProtColumns  col0=\"true\" col1=\"true\" col2=\"false\" col3=\"true\" col4=\"false\" col5=\"true\" col6=\"true\" col7=\"false\"/>"
					+"	<consProtocol useColors=\"true\" addIcons=\"false\" showOnlyBreakpoints=\"false\"/>"
					+"</gui>"
					+"<euclidianView>"
					+"	<size  width=\"578\" height=\"456\"/>"
					+"	<coordSystem xZero=\"224.36363636363637\" yZero=\"309.3636363636364\" scale=\"45.45454545454544\" yscale=\"45.45454545454545\"/>"
					+"	<evSettings axes=\"true\" grid=\"false\" gridIsBold=\"false\" pointCapturing=\"3\" rightAngleStyle=\"1\" checkboxSize=\"13\" gridType=\"0\"/>"
					+"	<bgColor r=\"255\" g=\"255\" b=\"255\"/>"
					+"	<axesColor r=\"0\" g=\"0\" b=\"0\"/>"
					+"	<gridColor r=\"192\" g=\"192\" b=\"192\"/>"
					+"	<lineStyle axes=\"1\" grid=\"10\"/>"
					+"	<axis id=\"0\" show=\"true\" label=\"\" unitLabel=\"\" tickStyle=\"1\" showNumbers=\"true\"/>"
					+"	<axis id=\"1\" show=\"true\" label=\"\" unitLabel=\"\" tickStyle=\"1\" showNumbers=\"true\"/>"
					+"</euclidianView>"
					+"<kernel>"
					+"	<continuous val=\"false\"/>"
					+"	<decimals val=\"2\"/>"
					+"	<angleUnit val=\"degree\"/>"
					+"	<algebraStyle val=\"0\"/>"
					+"	<coordStyle val=\"0\"/>"
					+"	<angleFromInvTrig val=\"false\"/>"
					+"</kernel>"
					+"<scripting blocked=\"false\" disabled=\"false\"/>"
					+"<construction title=\"\" author=\"\" date=\"\">"
					+"<element type=\"point\" label=\"A\">"
					+"	<show object=\"true\" label=\"true\"/>"
					+"	<objColor r=\"0\" g=\"0\" b=\"255\" alpha=\"0.0\"/>"
					+"	<layer val=\"0\"/>"
					+"	<labelMode val=\"0\"/>"
					+"	<animation step=\"1\" speed=\"1\" type=\"1\" playing=\"false\"/>"
					+"	<coords x=\"-2.54\" y=\"4.26\" z=\"1.0\"/>"
					+"	<pointSize val=\"3\"/>"
					+"	<pointStyle val=\"0\"/>"
					+"</element>"
					+"<element type=\"point\" label=\"B\">"
					+"	<show object=\"true\" label=\"true\"/>"
					+"	<objColor r=\"0\" g=\"0\" b=\"255\" alpha=\"0.0\"/>"
					+"	<layer val=\"0\"/>"
					+"	<labelMode val=\"0\"/>"
					+"	<animation step=\"1\" speed=\"1\" type=\"1\" playing=\"false\"/>"
					+"	<coords x=\"2.0\" y=\"4.0\" z=\"1.0\"/>"
					+"	<pointSize val=\"3\"/>"
					+"	<pointStyle val=\"0\"/>"
					+"</element>"
					+"<element type=\"point\" label=\"C\">"
					+"	<show object=\"true\" label=\"true\"/>"
					+"	<objColor r=\"0\" g=\"0\" b=\"255\" alpha=\"0.0\"/>"
					+"	<layer val=\"0\"/>"
					+"	<labelMode val=\"0\"/>"
					+"	<animation step=\"1\" speed=\"1\" type=\"1\" playing=\"false\"/>"
					+"	<coords x=\"1.96\" y=\"1.2\" z=\"1.0\"/>"
					+"	<pointSize val=\"3\"/>"
					+"	<pointStyle val=\"0\"/>"
					+"</element>"
					+"<element type=\"point\" label=\"D\">"
					+"	<show object=\"true\" label=\"true\"/>"
					+"	<objColor r=\"0\" g=\"0\" b=\"255\" alpha=\"0.0\"/>"
					+"	<layer val=\"0\"/>"
					+"	<labelMode val=\"0\"/>"
					+"	<animation step=\"1\" speed=\"1\" type=\"1\" playing=\"false\"/>"
					+"	<coords x=\"-1.46\" y=\"0.7\" z=\"1.0\"/>"
					+"	<pointSize val=\"3\"/>"
					+"	<pointStyle val=\"0\"/>"
					+"</element>"
					+"<element type=\"point\" label=\"E\">"
					+"	<show object=\"true\" label=\"true\"/>"
					+"	<objColor r=\"0\" g=\"0\" b=\"255\" alpha=\"0.0\"/>"
					+"	<layer val=\"0\"/>"
					+"	<labelMode val=\"0\"/>"
					+"	<animation step=\"1\" speed=\"1\" type=\"1\" playing=\"false\"/>"
					+"	<coords x=\"-2.84\" y=\"1.84\" z=\"1.0\"/>"
					+"	<pointSize val=\"3\"/>"
					+"	<pointStyle val=\"0\"/>"
					+"</element>"
					+"<command name=\"Polygon\">"
					+"	<input a0=\"A\" a1=\"B\" a2=\"C\" a3=\"D\" a4=\"E\"/>"
					+"	<output a0=\"poly1\" a1=\"a\" a2=\"b\" a3=\"c\" a4=\"d\" a5=\"e\"/>"
					+"</command>"
					+"<element type=\"polygon\" label=\"poly1\">"
					+"	<lineStyle thickness=\"2\" type=\"0\" typeHidden=\"1\"/>"
					+"	<show object=\"true\" label=\"false\"/>"
					+"	<objColor r=\"153\" g=\"51\" b=\"0\" alpha=\"0.1\"/>"
					+"	<layer val=\"0\"/>"
					+"	<labelMode val=\"0\"/>"
					+"</element>"
					+"<element type=\"segment\" label=\"a\">"
					+"	<show object=\"true\" label=\"false\"/>"
					+"	<objColor r=\"153\" g=\"51\" b=\"0\" alpha=\"0.0\"/>"
					+"	<layer val=\"0\"/>"
					+"	<labelMode val=\"0\"/>"
					+"	<coords x=\"0.2599999999999998\" y=\"4.54\" z=\"-18.68\"/>"
					+"	<lineStyle thickness=\"2\" type=\"0\" typeHidden=\"1\"/>"
					+"	<eqnStyle style=\"implicit\"/>"
					+"	<outlyingIntersections val=\"false\"/>"
					+"	<keepTypeOnTransform val=\"true\"/>"
					+"</element>"
					+"<element type=\"segment\" label=\"b\">"
					+"	<show object=\"true\" label=\"false\"/>"
					+"	<objColor r=\"153\" g=\"51\" b=\"0\" alpha=\"0.0\"/>"
					+"	<layer val=\"0\"/>"
					+"	<labelMode val=\"0\"/>"
					+"	<coords x=\"2.8\" y=\"-0.040000000000000036\" z=\"-5.4399999999999995\"/>"
					+"	<lineStyle thickness=\"2\" type=\"0\" typeHidden=\"1\"/>"
					+"	<eqnStyle style=\"implicit\"/>"
					+"	<outlyingIntersections val=\"false\"/>"
					+"	<keepTypeOnTransform val=\"true\"/>"
					+"</element>"
					+"<element type=\"segment\" label=\"c\">"
					+"	<show object=\"true\" label=\"false\"/>"
					+"	<objColor r=\"153\" g=\"51\" b=\"0\" alpha=\"0.0\"/>"
					+"	<layer val=\"0\"/>"
					+"	<labelMode val=\"0\"/>"
					+"	<coords x=\"0.5\" y=\"-3.42\" z=\"3.1239999999999997\"/>"
					+"	<lineStyle thickness=\"2\" type=\"0\" typeHidden=\"1\"/>"
					+"	<eqnStyle style=\"implicit\"/>"
					+"	<outlyingIntersections val=\"false\"/>"
					+"	<keepTypeOnTransform val=\"true\"/>"
					+"</element>"
					+"<element type=\"segment\" label=\"d\">"
					+"	<show object=\"true\" label=\"false\"/>"
					+"	<objColor r=\"153\" g=\"51\" b=\"0\" alpha=\"0.0\"/>"
					+"	<layer val=\"0\"/>"
					+"	<labelMode val=\"0\"/>"
					+"	<coords x=\"-1.1400000000000001\" y=\"-1.38\" z=\"-0.6984000000000001\"/>"
					+"	<lineStyle thickness=\"2\" type=\"0\" typeHidden=\"1\"/>"
					+"	<eqnStyle style=\"implicit\"/>"
					+"	<outlyingIntersections val=\"false\"/>"
					+"	<keepTypeOnTransform val=\"true\"/>"
					+"</element>"
					+"<element type=\"segment\" label=\"e\">"
					+"	<show object=\"true\" label=\"false\"/>"
					+"	<objColor r=\"153\" g=\"51\" b=\"0\" alpha=\"0.0\"/>"
					+"	<layer val=\"0\"/>"
					+"	<labelMode val=\"0\"/>"
					+"	<coords x=\"-2.42\" y=\"0.2999999999999998\" z=\"-7.424799999999998\"/>"
					+"	<lineStyle thickness=\"2\" type=\"0\" typeHidden=\"1\"/>"
					+"	<eqnStyle style=\"implicit\"/>"
					+"	<outlyingIntersections val=\"false\"/>"
					+"	<keepTypeOnTransform val=\"true\"/>"
					+"</element>"
					+"<expression label =\"f\" exp=\"f(x) = sin(x)\"/>"
					+"<element type=\"function\" label=\"f\">"
					+"	<show object=\"true\" label=\"false\"/>"
					+"	<objColor r=\"0\" g=\"0\" b=\"0\" alpha=\"0.0\"/>"
					+"	<layer val=\"0\"/>"
					+"	<labelMode val=\"0\"/>"
					+"	<animation step=\"1\" speed=\"1\" type=\"0\" playing=\"false\"/>"
					+"	<lineStyle thickness=\"2\" type=\"0\" typeHidden=\"1\"/>"
					+"</element>"
					+"<expression label=\"F\" exp=\"(A + B) / 2\" type=\"point\" />"
					+"<element type=\"point\" label=\"F\">"
					+"	<show object=\"true\" label=\"true\"/>"
					+"	<objColor r=\"64\" g=\"64\" b=\"64\" alpha=\"0.0\"/>"
					+"	<layer val=\"0\"/>"
					+"	<labelMode val=\"0\"/>"
					+"	<coords x=\"-0.27\" y=\"4.13\" z=\"1.0\"/>"
					+"	<pointSize val=\"3\"/>"
					+"	<pointStyle val=\"0\"/>"
					+"</element>"
					+"<command name=\"Midpoint\">"
					+"	<input a0=\"E\" a1=\"F\"/>"
					+"	<output a0=\"G\"/>"
					+"</command>"
					+"<element type=\"point\" label=\"G\">"
					+"	<show object=\"true\" label=\"true\"/>"
					+"	<objColor r=\"64\" g=\"64\" b=\"64\" alpha=\"0.0\"/>"
					+"	<layer val=\"0\"/>"
					+"	<labelMode val=\"0\"/>"
					+"	<coords x=\"-1.555\" y=\"2.985\" z=\"1.0\"/>"
					+"	<pointSize val=\"3\"/>"
					+"	<pointStyle val=\"0\"/>"
					+"</element>"
					+"<command name=\"Line\">"
					+"	<input a0=\"A\" a1=\"C\"/>"
					+"	<output a0=\"g\"/>"
					+"</command>"
					+"<element type=\"line\" label=\"g\">"
					+"	<show object=\"true\" label=\"false\"/>"
					+"	<objColor r=\"0\" g=\"0\" b=\"0\" alpha=\"0.0\"/>"
					+"	<layer val=\"0\"/>"
					+"	<labelMode val=\"0\"/>"
					+"	<coords x=\"3.0599999999999996\" y=\"4.5\" z=\"-11.397599999999999\"/>"
					+"	<lineStyle thickness=\"2\" type=\"0\" typeHidden=\"1\"/>"
					+"	<eqnStyle style=\"implicit\"/>"
					+"</element>"
					+"<command name=\"Segment\">"
					+"	<input a0=\"E\" a1=\"B\"/>"
					+"	<output a0=\"h\"/>"
					+"</command>"
					+"<element type=\"segment\" label=\"h\">"
					+"	<show object=\"true\" label=\"false\"/>"
					+"	<objColor r=\"0\" g=\"0\" b=\"0\" alpha=\"0.0\"/>"
					+"	<layer val=\"0\"/>"
					+"	<labelMode val=\"0\"/>"
					+"	<coords x=\"-2.16\" y=\"4.84\" z=\"-15.04\"/>"
					+"	<lineStyle thickness=\"2\" type=\"0\" typeHidden=\"1\"/>"
					+"	<eqnStyle style=\"implicit\"/>"
					+"	<outlyingIntersections val=\"false\"/>"
					+"	<keepTypeOnTransform val=\"true\"/>"
					+"</element>"
					+"</construction>"
					+"</geogebra>";
	public void onModuleLoad() {
		//just mimic not real :-)
		Mvp4gModule module = (Mvp4gModule) GWT.create(Mvp4gModule.class);
		module.createAndStartModule();
		//tempRootLayoutPanel.get().add((Widget) module.getStartView());
		Application app = new Application();
		app.updateCommandDictionary();
		HashMap<String,String> archiveContent = new HashMap<String, String>();
		archiveContent.put("geogebra.xml",defaultCons);
		try{
		app.loadGgbFile(archiveContent);
		app.getKernel().setNotifyViewsActive(true);
		app.getEuclidianView().repaint();
		}
		catch (Throwable t){
			t.printStackTrace();
			
			
		}
	}
}
