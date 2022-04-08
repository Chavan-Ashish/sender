package com.hackerearth.sender.service.transaction;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.hackerearth.sender.model.transaction.Transaction;
import com.hackerearth.sender.utility.EncryptionUtility;
import com.hackerearth.sender.utility.RESTUtility;

@Service
public class TransactionService {
	
	public boolean addTransactionToQueue(Transaction transaction) throws Exception {
		Map<String,Transaction> hashMap = new HashMap<>();
		hashMap.put("transaction", transaction);
		String encrypedData = EncryptionUtility.encrypt(new JSONObject(hashMap).toString());
		List<NameValuePair> pair = new ArrayList<NameValuePair>();
		pair.add(new BasicNameValuePair(encrypedData, encrypedData));
		JSONObject obj = RESTUtility.postWithBody("localhost:8082/transaction/add", encrypedData,null);
		if(obj==null) {return false;}
		return true;
		
	}
	
	

}
