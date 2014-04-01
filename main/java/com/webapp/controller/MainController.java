package com.webapp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.webapp.models.Client;
import com.webapp.models.Phone;
import com.webapp.models.PhoneType;
import com.webapp.service.EntityService;


@Controller
public class MainController {
	@Autowired
	EntityService<Client> clientService;
	
	@Autowired
	EntityService<Phone> phoneService;
	
	@Autowired
	EntityService<PhoneType> phoneTypeService;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String getContactClient(Model model) {
		List<Phone> phones=phoneService.getListEntity();
		List<PhoneType> phoneTypes=phoneTypeService.getListEntity();
		model.addAttribute("phones", phones);
		model.addAttribute("phoneTypes", phoneTypes);
		return "main";
	}
	
	@RequestMapping(value="/edit/contact/ajax", method=RequestMethod.POST)
	@ResponseBody
	public void editContactClient(	@RequestParam(value="phoneid") Integer phoneId,
									@RequestParam(value="phonenum") String phoneNum,
									@RequestParam(value="phonetypeid") Integer	phoneTypeId,
									@RequestParam(value="phonecomment") String	phoneComment,
									HttpServletResponse response) {
		String returnText;
		Phone phone=phoneService.readEntityById(phoneId);
		 if(phone!=null && phoneTypeId!=0 && !phoneNum.isEmpty()){
			 	phone.setPhoneNumber(phoneNum);
			 	phone.setDescription(phoneComment);
			 	PhoneType phoneType=phoneTypeService.readEntityById(phoneTypeId);
			 	phone.setTyper(phoneType);
			 	phoneService.updateEntity(phone);
	            returnText = "User contact has been changed to the list. Total number of contact is: " +phoneNum+"; typeid = "+phoneTypeId+"; comment="+phoneComment;
	        }else{
	            returnText = "Sorry, an error has occur. User contact has not been changed to list.";
	        }
		 	response.setCharacterEncoding("UTF-8");  
	        response.setContentType("text/html");  
	        try {
				response.getWriter().write(returnText);
			} catch (IOException e) {
				e.printStackTrace();
			} 
	}
}
