package org.geogebra.common.kernel.interval.operands;

import static org.geogebra.common.kernel.interval.IntervalConstants.empty;
import static org.geogebra.common.kernel.interval.IntervalConstants.zero;
import static org.geogebra.common.kernel.interval.IntervalHelper.around;
import static org.geogebra.common.kernel.interval.IntervalHelper.interval;
import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

public class SqrtTest {

	@Test
	public void sqrtPositiveInfinityShouldBePositiveInfinity() {
		assertEquals(interval(Double.POSITIVE_INFINITY), interval(Double.POSITIVE_INFINITY).sqrt());
	}

	@Test
	public void sqrtOfZeroShouldBeZero() {
		assertEquals(zero(), interval(0).sqrt());
	}

	@Ignore
	@Test
	public void sqrtAroundZeroShouldBeZero() {
		assertEquals(zero(), around(0).sqrt());
	}

	@Test
	public void sqrtOfNegativeShouldBeEmpty() {
		assertEquals(empty(), interval(-3, -2).sqrt());
		assertEquals(empty(), interval(-2).sqrt());
		assertEquals(empty(), interval(Double.NEGATIVE_INFINITY).sqrt());
		assertEquals(empty(), interval(Double.NEGATIVE_INFINITY, -1E-6).sqrt());
	}

	@Test
	public void sqrtOfZeroInverseShouldBePositiveInfinity() {
		assertEquals(interval(Double.POSITIVE_INFINITY), zero().multiplicativeInverse().sqrt());
	}

}
