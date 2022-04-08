package com.hackerearth.sender.restcontroller.transaction;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackerearth.sender.model.transaction.Transaction;
import com.hackerearth.sender.utility.EncryptionUtility;

@RestController
@RequestMapping("/transaction/")
public class TransactionController {
	
	@PostMapping("/add")
	public JSONObject addTransaction(@RequestBody Transaction transaction) throws JsonMappingException, JsonProcessingException {
		JSONObject obj = new JSONObject();
		
		Map hm = new HashMap<String, Transaction>();
		hm.put("aa", transaction);
		JSONObject obj2 = new JSONObject(hm);
		String s = EncryptionUtility.encrypt(obj2.toString());
		String a = EncryptionUtility.decrypt(s);
		JSONObject kk = new JSONObject(a);
		System.out.println();
		 ObjectMapper mapper = new ObjectMapper();
		 Transaction readValue = mapper.readValue(kk.get("aa").toString(), Transaction.class);
	        System.out.println("readValue = " + readValue.getAccountForm());
		return new JSONObject();
	}
	

}
