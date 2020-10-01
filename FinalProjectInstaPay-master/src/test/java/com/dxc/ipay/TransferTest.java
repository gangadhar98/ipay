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
		
import com.dxc.ipay.entites.Transfer;

		@RunWith(SpringRunner.class)
		@SpringBootTest(classes = InstaPayApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
		 public class TransferTest {
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
		    public void testCreateTransfer() {
		       Transfer transfer=new Transfer();
		       
		    	transfer.setReceiverAccountNumber(45678987);
		    	transfer.setBankIFSC("IDIB567876");
		    	transfer.setAmount("10000");
		    	transfer.setTransactionPassword("king");
		        ResponseEntity<Transfer> postResponse = restTemplate.postForEntity(getRootUrl() + "/send", transfer, Transfer.class);
		        assertNotNull(postResponse);
		        assertNotNull(postResponse.getBody());
		    }

		}