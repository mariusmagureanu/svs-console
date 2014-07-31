package com.svs.facade.interfaces;

import com.svs.entities.User;

public interface IUserFacade extends IBaseFacade<User> {
	
	boolean isValidUser(String username, String password);

}
