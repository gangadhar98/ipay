package com.dxc.ipay.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxc.ipay.entites.Register;
import com.dxc.ipay.exceptions.RegisterDataException;
import com.dxc.ipay.repositories.IRegisterRepository;

@Service
public class RegisterServiceImpl implements IRegisterService {

	@Autowired
	IRegisterRepository repo;//repo is the reference variable to indicate interface IRegisterRepository  .
	
	
	@Autowired
	Register register;
	
	
	
	
	@Override
	public Register addCustomer(Register register) throws RegisterDataException {
		
		Register  isValid = validateData(register);
		    
		    if(isValid != null) {
		    	// TODO Auto-generated method stub
		    	return repo.save(register);
				
		    }else {
		    	throw new RegisterDataException("data missing....!Sorry check again");
		    }
		    
	}

	private Register   validateData(Register register  ) {
		

		
		if((register.getCustomerName().length() <=30)
			
			&&(register.getCustomerMailId().length() <=40)
			
			&&(register. getCustomerPhoneNo().length() ==10)
			
			&&(register.getCustomerAddress().length() <=100)
			
			&&(register.getPanId().length() <=15)
			
			&&(register.getTransactionPassword().length() <=7)) {
		
			
			return register;
			
		}
		
		return null;
		
	

		
	}

}
