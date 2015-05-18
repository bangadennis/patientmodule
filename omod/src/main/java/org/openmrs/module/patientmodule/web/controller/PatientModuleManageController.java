/**
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */
package org.openmrs.module.patientmodule.web.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.Patient;
import org.openmrs.PatientIdentifier;
import org.openmrs.PersonName;
import org.openmrs.api.context.Context;
import org.openmrs.messagesource.MessageSourceService;
import org.openmrs.module.patientmodule.PatientModule;
import org.openmrs.module.patientmodule.api.PatientModuleService;
import org.openmrs.web.WebConstants;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * The main controller.
 */
@Controller
public class  PatientModuleManageController {
	
	protected final Log log = LogFactory.getLog(getClass());
	
	@RequestMapping(value = "/module/patientmodule/manage.form", method=RequestMethod.GET)
	public void manage(ModelMap model) {
		model.addAttribute("user", Context.getAuthenticatedUser());
        List<Patient> patientList = Context.getPatientService().getAllPatients();
        model.addAttribute("patientList", patientList);
		Patient patient=new Patient();

	}

	//method for deleting an patient
	@RequestMapping(value = "/module/patientmodule/delete.form", method=RequestMethod.GET)
	public String  delete(ModelMap model, WebRequest webRequest, HttpSession httpSession,
					   @RequestParam(value = "id", required = true) Integer patientId) {
		try {
			Patient patient = Context.getPatientService().getPatient(patientId);
			model.addAttribute("user", Context.getAuthenticatedUser());
			Context.getPatientService().purgePatient(patient);
			httpSession.setAttribute(WebConstants.OPENMRS_MSG_ATTR, "Deleted Successfully");
			return "redirect:manage.form";
		}
		catch (Exception ex)
		{
			httpSession.setAttribute(WebConstants.OPENMRS_MSG_ATTR, "Deletion failed");
			return "redirect:manage.form";

		}

		//return "redirect:manage.form";
	}

	//method for edit an patient
	@RequestMapping(value = "/module/patientmodule/edit.form", method=RequestMethod.GET)
	public void editform(ModelMap model, WebRequest webRequest, HttpSession httpSession,
						  @RequestParam(value = "id", required = true) Integer patientId) {
		try {
			Patient patient = Context.getPatientService().getPatient(patientId);
			model.addAttribute("user", Context.getAuthenticatedUser());
			model.addAttribute("patient",patient);
		}
		catch (Exception ex)
		{
			httpSession.setAttribute(WebConstants.OPENMRS_MSG_ATTR, "Edit form failed");

		}

		//return "redirect:manage.form";
	}

	//method for Editing a patient
	@RequestMapping(value = "/module/patientmodule/addedit.form", method=RequestMethod.POST)
	public String  edit(ModelMap model, WebRequest webRequest, HttpSession httpSession,
						  @RequestParam(value = "patientId", required = true) Integer patientId,
						@RequestParam(value = "lname", required = true) String fname,
						@RequestParam(value = "middleName", required = true) String middleName,
						@RequestParam(value = "age", required = true) Date dob,
						@RequestParam(value = "gender", required = true) String gender) {
		try {

			Patient patient = Context.getPatientService().getPatient(patientId);
			PersonName personName=new PersonName();
			personName.setGivenName(fname);
			personName.setMiddleName(middleName);
			patient.addName(personName);
			patient.setGender(gender);
			patient.setBirthdate(dob);
			Context.getPatientService().savePatient(patient);
			httpSession.setAttribute(WebConstants.OPENMRS_MSG_ATTR, "Editted Successfully");
			return "redirect:manage.form";
		}
		catch (Exception ex)
		{
			httpSession.setAttribute(WebConstants.OPENMRS_MSG_ATTR, "Edit failed");
			return "redirect:manage.form";

		}

		//return "redirect:manage.form";
	}






}
