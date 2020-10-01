package com.dxc.ipay;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.boot.test.context.SpringBootTest;
	import org.springframework.boot.test.web.client.TestRestTemplate;
	import org.springframework.boot.web.server.LocalServerPort;
	import org.springframework.http.HttpEntity;
	import org.springframework.http.HttpHeaders;
	import org.springframework.http.HttpMethod;
	import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;
	import org.springframework.test.context.junit4.SpringRunner;
	import org.springframework.web.client.HttpClientErrorException;

	import com.dxc.ipay.entites.FixedDeposit;

	@RunWith(SpringRunner.class)
	@SpringBootTest(classes = InstaPayApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
	 public class FixedDepositTest {
	     @Autowired
	     private TestRestTemplate restTemplate;

	     @LocalServerPort
	     private int port;

	     private String getRootUrl() {
	         return "http://localhost:" + port;
	     }

	     @Test
	     public void contextLoads() {

	     }


	    @Test
	    public void testCreateFixedDeposit() {
	       FixedDeposit fixed= new FixedDeposit();
	       
	    	fixed.setDepositAmount("100000");
	    	fixed.setPeriod(3);
	    	fixed.setRateOfInterest(3);
	        ResponseEntity<FixedDeposit> postResponse = restTemplate.postForEntity(getRootUrl() + "/fixed", fixed, FixedDeposit.class);
	        assertNotNull(postResponse);
	        assertNotNull(postResponse.getBody());
	    }

	
	}