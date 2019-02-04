package test;

import org.testng.annotations.Test;

import base.Base;

public class Testing01 extends Base {

	@Test(priority=0, enabled=true, groups= {"smoke"})
	public void method1() {
		System.out.println("Method1");

	}
	@Test(priority=-3, enabled=true, groups= {"regression"})
	public void method2() {
		System.out.println("Method2");
	}
	@Test(priority=3, dependsOnMethods= {"method2"}, groups= {"regression"})
	public void method3() {
		System.out.println("Method3");
	}
	@Test(priority=-1, groups= {"functional"})
	public void method4() {
		System.out.println("Method4");
	}
	@Test(priority=-10, groups= {"functional"})
	public void method5() {
		System.out.println("Method5");
	}

}
