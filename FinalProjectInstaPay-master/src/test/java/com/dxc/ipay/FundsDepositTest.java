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

		import com.dxc.ipay.entites.FundsDeposit;

		@RunWith(SpringRunner.class)
		@SpringBootTest(classes = InstaPayApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
		 public class FundsDepositTest {
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
		       FundsDeposit funds= new FundsDeposit();
		       
		    	funds.setAccountNumber(67678342);
		        funds.setBankIFSC("IMA25789");
		        funds.setAmount("25000");
		        funds.setTransactionPassword("sujay123");
		        ResponseEntity<FundsDeposit> postResponse = restTemplate.postForEntity(getRootUrl() + "/fundsDeposit", funds, FundsDeposit.class);
		        assertNotNull(postResponse);
		        assertNotNull(postResponse.getBody());
		    }

		
		}

	