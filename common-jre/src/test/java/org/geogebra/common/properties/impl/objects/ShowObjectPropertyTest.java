package org.geogebra.common.properties.impl.objects;

import org.geogebra.common.BaseUnitTest;
import org.geogebra.common.kernel.geos.GeoNumeric;
import org.junit.Test;

public class ShowObjectPropertyTest extends BaseUnitTest {

	@Test
	public void testConstructorSucceeds() {
		GeoNumeric slider = addAvInput("1");
		new ShowObjectProperty(slider);
	}
}