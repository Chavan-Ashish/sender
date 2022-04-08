package com.hackerearth.sender.restcontroller.transaction;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hackerearth.sender.model.transaction.Transaction;
import com.hackerearth.sender.service.transaction.TransactionService;

@RestController
@RequestMapping("/transaction/")
public class TransactionController {
	@Autowired
	private TransactionService transactionService;
	
	@PostMapping("/add")
	public JSONObject addTransaction(@RequestBody Transaction transaction)  {
		try {
			boolean result = transactionService.addTransactionToQueue(transaction);
			JSONObject response = new JSONObject();
			if(result) {
				response.put("result", "success");
			}else {
				response.put("result", "failure");
			}
			
			return response;
		} catch (Exception e) {
			JSONObject response = new JSONObject();
			response.put("result", "failure");
		}
		JSONObject response = new JSONObject();
		response.put("result", "failure");
		return response;
	}
	

}
