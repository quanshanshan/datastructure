package com.opentext.ecd.dctm.test.designpattern.builder;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URISyntaxException;

import org.apache.commons.io.IOUtils;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import com.opentext.ecd.dctm.test.animal.Dog;
import com.opentext.ecd.dctm.test.animal.Dog.SimpleDogBuilder;
import com.opentext.ecd.dctm.test.animal.Size;

public class BuilderTest {
	
	public void build() {
		
	}
	
	public static void main(String[] args) throws ClientProtocolException, IOException {
		
		  RequestConfig defaultRequestConfig = RequestConfig.custom()
	                .setSocketTimeout(30000)
	                .setConnectTimeout(30000)
	                .setConnectionRequestTimeout(30000)
	                .build();
		
		try(CloseableHttpClient client = HttpClientBuilder.create().setDefaultRequestConfig(defaultRequestConfig).build()){
		     String url = "http://10.245.43.198:9300/dsearch";
			 URIBuilder builder = new URIBuilder(url);
	         HttpGet httpGet = new HttpGet(builder.build());
	         CloseableHttpResponse httpResponse = client.execute(httpGet);         
	    
	         IOUtils.copy(httpResponse.getEntity().getContent(), System.out);      
	        
	       	
	    } catch ( IOException | URISyntaxException e ) {			
			e.printStackTrace();
		
		}
		
		
		
		Dog dog = new Dog.SimpleDogBuilder().setDogName("11").setDogSize(Size.EXTRALARGE).build();
		
		System.out.println(dog.getName());
		 
	}

}
