package org.geogebra.common.kernel.arithmetic.simplifiers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.geogebra.common.BaseAppTestSetup;
import org.geogebra.common.SuiteSubApp;
import org.geogebra.common.kernel.StringTemplate;
import org.geogebra.common.kernel.kernelND.GeoElementND;
import org.geogebra.common.plugin.Operation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ExpressionReducerTest extends BaseAppTestSetup {
	private ExpressionReducer productReducer;

	@BeforeEach
	void setUp() {
		setupApp(SuiteSubApp.GRAPHING);
		productReducer = new ExpressionReducer(new SimplifyUtils(getKernel()), Operation.MULTIPLY);
	}

	@ParameterizedTest
	@CsvSource({
			"sqrt(2)*2*sqrt(6)*5*7, 70sqrt(2) sqrt(6)",
			"sqrt(6)*2*sqrt(2)*5*7, 70sqrt(6) sqrt(2)",
			"sqrt(2)*2*-sqrt(6)*5*7, -70sqrt(2) sqrt(6)",
			"sqrt(2)*2*sqrt(6)*-5*7, -70sqrt(2) sqrt(6)",
			"sqrt(2)*2*sqrt(6)*-5*-7, 70sqrt(2) sqrt(6)"
	})
	void testReduce(String definition, String expected) {
		GeoElementND product = evaluateGeoElement(definition);
		assertEquals(expected, productReducer.apply(product.getDefinition())
				.toString(StringTemplate.defaultTemplate));
	}

}
