package org.openmrs.module.patientmodule.web.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.Patient;
import org.openmrs.api.context.Context;
import org.openmrs.messagesource.MessageSourceService;
import org.openmrs.module.patientmodule.PatientModule;
import org.openmrs.module.patientmodule.api.PatientModuleService;
import org.openmrs.module.patientmodule.api.impl.PatientModuleServiceImpl;
import org.openmrs.web.WebConstants;
import org.springframework.beans.factory.annotation.Autowired;
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
 * Created by banga on 5/13/15.
 */
@Controller
public class PatientModuleAddPatientController {
    protected final Log log = LogFactory.getLog(getClass());

    @RequestMapping(value = "/module/patientmodule/addpatient.form",method=RequestMethod.GET)
    public void addpatientForm(ModelMap model) {
        PatientModuleService patientModuleService = Context.getService(PatientModuleService.class);
        model.addAttribute("user", Context.getAuthenticatedUser());
        List<PatientModule> patientList=patientModuleService.getAllPatients();
        model.addAttribute("patientList", patientList);
        PatientModule patientModule=new PatientModule();
        model.addAttribute("patientmodule", patientModule);

    }


    @RequestMapping(value = "/module/patientmodule/add.form", method = RequestMethod.POST)
    public String addpatient(WebRequest request, HttpSession httpSession, ModelMap model,
                              @RequestParam(required = false, value = "action") String action,
                              @ModelAttribute("patientmodule") PatientModule patientModule, BindingResult errors) {

        MessageSourceService mss = Context.getMessageSourceService();
        //model.addAttribute("hello", "");
        PatientModuleService patientModuleService = Context.getService(PatientModuleService.class);
        if (!Context.isAuthenticated()) {
            errors.reject("patientModule.auth.required");
        } else if (mss.getMessage("patientmodule.purgePatientModule").equals(action)) {
            try {
                patientModuleService.purgePatientModule(patientModule);
                httpSession.setAttribute(WebConstants.OPENMRS_MSG_ATTR, "Patient Deleted successfully");
                return "redirect:patientmodulelist.list";
            }
            catch (Exception ex) {
                httpSession.setAttribute(WebConstants.OPENMRS_ERROR_ATTR, "Delete failure");
                log.error("Failed to delete patientModule", ex);
                return "redirect:patientmoduleform.form?nationalId=" + request.getParameter("nationalId");
            }
        } else {
            patientModuleService.savePatient(patientModule);
            httpSession.setAttribute(WebConstants.OPENMRS_MSG_ATTR, "Added Successfully");
        }
        return "redirect:addpatient.form";
    }
}
