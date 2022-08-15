package com.pluralsight.customerservice.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.pluralsight.customerservice.model.ContactDetails;
import com.pluralsight.customerservice.model.CustomerDetails;
import com.pluralsight.customerservice.model.VehicleDetails;

@RestController
public class CustomerController {
	
	@Autowired
	private WebClient webClient;
	
	@GetMapping("/servicestatus")
	public String getStatus() {
		return "Up";
	}

	@RequestMapping(value = "/customer/{cid}", method = RequestMethod.GET)
	public CustomerDetails getCustomer(@PathVariable String cid) {

		CustomerDetails customer = new CustomerDetails();
		//WebClient client = WebClient.create();

		ContactDetails svc1 = webClient.get().uri("http://localhost:8081/customer/" + cid + "/contactdetails").retrieve()
				.bodyToMono(ContactDetails.class).block();

		VehicleDetails svc2 = webClient.get().uri("http://localhost:8082/customer/" + cid + "/vehicledetails").retrieve()
				.bodyToMono(VehicleDetails.class).block();

		customer.setContactId(cid);
		customer.setContactName(svc1.getContactName());
		customer.setPostalCode(svc1.getPostalCode());
		customer.setLicensePlate(svc2.getLicensePlate());
		customer.setCarType(svc2.getCarType());

		return customer;

	}

}
