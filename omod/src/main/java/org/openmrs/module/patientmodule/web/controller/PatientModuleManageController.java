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

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * The main controller.
 */
@Controller
public class  PatientModuleManageController {
	
	protected final Log log = LogFactory.getLog(getClass());
	
	@RequestMapping(value = "/module/patientmodule/manage", method = RequestMethod.GET)
	public void manage(ModelMap model) {
		model.addAttribute("user", Context.getAuthenticatedUser());
        List<Patient> patientList = Context.getPatientService().getAllPatients();
        model.addAttribute("patientList", patientList);

	}

	@RequestMapping(value = "/module/patientmodule/addPatientModule.form", method = RequestMethod.POST)
	public String submitPatientModule(WebRequest request, HttpSession httpSession, ModelMap model,
								   @RequestParam(required = false, value = "action") String action,
								   @ModelAttribute("patientModule") PatientModule patientModule, BindingResult errors) {

		MessageSourceService mss = Context.getMessageSourceService();
        model.addAttribute("hello", "");
		PatientModuleService patientModuleService = Context.getService(PatientModuleService.class);
		if (!Context.isAuthenticated()) {
			errors.reject("patientModule.auth.required");
		} else if (mss.getMessage("patientModule.purgePatientModule").equals(action)) {
            try {
                patientModuleService.purgePatientModule(patientModule);
				httpSession.setAttribute(WebConstants.OPENMRS_MSG_ATTR, "patientModule.delete.success");
				return "redirect:patientModuleList.list";
			}
			catch (Exception ex) {
				httpSession.setAttribute(WebConstants.OPENMRS_ERROR_ATTR, "patientModule.delete.failure");
				log.error("Failed to delete patientModule", ex);
				return "redirect:patientModuleForm.form?nationalId=" + request.getParameter("nationalId");
            }
        } else {
            patientModuleService.savePatient(patientModule);
			httpSession.setAttribute(WebConstants.OPENMRS_MSG_ATTR, "patientModule.saved");
		}
		return "redirect:patientModuleList.list";
	}

}
