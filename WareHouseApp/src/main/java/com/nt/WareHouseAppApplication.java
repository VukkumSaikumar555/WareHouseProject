package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.nt.controller.OrderMethodController;
import com.nt.controller.ShipmentTypeController;

@SpringBootApplication
public class WareHouseAppApplication {

	public static void main(String[] args) {
		//get ioc container
		ApplicationContext ctx=SpringApplication.run(WareHouseAppApplication.class, args);
		//ShipmentTypeController control=ctx.getBean("ctr",ShipmentTypeController.class);
		//control.ShowReg();
		     //OrderMethodController  control=ctx.getBean("com",OrderMethodController.class);
		     //control.saveRecord();
	}

}
