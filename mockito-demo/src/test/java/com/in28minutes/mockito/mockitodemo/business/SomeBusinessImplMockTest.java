package com.in28minutes.mockito.mockitodemo.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

class SomeBusinessImplMockTest {

	@Test
	void findTheGreatestFromAllData_basicScenario() {
		DataService dataServiceMock = mock(DataService.class);
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] { 25, 15, 5 });
		SomeBusinessImpl businessImpl = new SomeBusinessImpl(dataServiceMock);
		assertEquals(25, businessImpl.findTheGreatestFromAllData());
	}

	@Test
	void findTheGreatestFromAllData_oneValueScenario() {
		DataService dataServiceMock = mock(DataService.class);
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] { 67 });
		SomeBusinessImpl businessImpl = new SomeBusinessImpl(dataServiceMock);
		assertEquals(67, businessImpl.findTheGreatestFromAllData());
	}

}
