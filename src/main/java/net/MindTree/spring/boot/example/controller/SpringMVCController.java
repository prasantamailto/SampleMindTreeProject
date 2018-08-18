package net.MindTree.spring.boot.example.controller;

import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import net.MindTree.spring.boot.example.pojo.Transaction;

/**
 * @author prasa
 *
 */
@RestController
public class SpringMVCController {
	Logger logger = Logger.getLogger(SpringMVCController.class.getName());
	static final String TRANSACTION_URL = "http://ec2-52-15-52-170.us-east-2.compute.amazonaws.com:8080/transactions/v1/transactions?productId=AnyID";
	
	
	/**
	 * @param orderBy
	 * @param direction
	 * @param from
	 * @param size
	 * @return
	 */
	@RequestMapping(value = { "/transactions"}, method = RequestMethod.GET)
	public ModelAndView getDetails(@RequestParam(value="orderBy", required=false, defaultValue="id") String orderBy,
							@RequestParam(value="direction", required=false, defaultValue="ASC") String direction,
							@RequestParam(value="from", required=false, defaultValue="0") Integer from,
							@RequestParam(value="size", required=false) Integer size){

		logger.info("Inside getDetails Method");
		logger.info("request parameters are orderBy:"+orderBy+" direction:"+direction+" from:"+from+" size:"+size);
		RestTemplate restTemplate = new RestTemplate();
		Transaction[] list = restTemplate.getForObject(TRANSACTION_URL, Transaction[].class);
		 		 
		 List<Transaction> transactionList = Arrays.asList(list);
		 //Sorting as per id
		 if(orderBy.equals("id"))
		 {
			 logger.info("Sorting by ID");
		 transactionList.sort((t1, t2) -> {
			    if(t1.getId() == t2.getId()){
			        return 0;
			    }
			    //Selecting the order
			    if(direction.equals("DESC"))
			    	return t2.getId().compareTo(t1.getId());
			    else
			    	return t1.getId().compareTo(t2.getId());
			    	
			});
		 }
		 else if(orderBy.equals("amount"))
		 {
			 logger.info("Sorting by Amount");
			 transactionList.sort((t1, t2) -> {
				    if(t1.getAmount() == t2.getAmount()){
				        return 0;
				    }
				    //Selecting the order
				    if(direction.equals("DESC"))
				    	return t2.getAmount().compareTo(t1.getAmount());
				    else
				    return t1.getAmount().compareTo(t2.getAmount());
				});
			  
		 }
		 else if(orderBy.equals("instructedAmount"))
		 {
			 logger.info("Sorting by instructedAmount");
			 transactionList.sort((t1, t2) -> {
				    if(t1.getInstructedAmount() == t2.getInstructedAmount()){
				        return 0;
				    }
				    //Selecting the order
				    if(direction.equals("DESC"))
				    	return t2.getInstructedAmount().compareTo(t1.getInstructedAmount());
				    else
				    return t1.getInstructedAmount().compareTo(t2.getInstructedAmount());
				});
			  
		 }
		 
		 int toSize =0;
		 if(from<0 || from > transactionList.size())
		 {
			 logger.info("from is either <0 or > total number of records so reseting the value to 0");
			 from = 0;
		 }
		 
		 if(null == size || from+size<0)
		 {
			 logger.info("size is either null or from+size > total number of records so reseting the value to total number of records");

			 toSize = transactionList.size();
		 }
		 else if(from+size > transactionList.size())
		 {
			 logger.info("from + size > total number of records so reseting the value to total number of records");

			 toSize = transactionList.size();
		 }
		 else
		 {
			 toSize = from+size;
		 }
		 //Creating the sublist as per the from and size values
		 List<Transaction> pagedList = transactionList.subList(from, toSize);

		 ModelAndView model = new ModelAndView("index");
			model.addObject("transactions", pagedList);
		 
	        return model;
	}

}
