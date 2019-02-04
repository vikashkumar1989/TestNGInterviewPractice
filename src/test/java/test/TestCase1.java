package test;

import org.testng.annotations.Test;

import base.Base;
import pages.HomePageActions;

public class TestCase1 {

	@Test
	public void TestCase1() {
		Base.Initialize("Chrome", "https://ksrtc.in/oprs-web/");
		HomePageActions hm=new HomePageActions();
		hm.SearchBus();
		Base.TearDown();
	}
}
