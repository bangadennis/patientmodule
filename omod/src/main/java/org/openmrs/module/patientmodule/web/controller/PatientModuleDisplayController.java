package org.openmrs.module.patientmodule.web.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.Patient;
import org.openmrs.api.context.Context;
import org.openmrs.module.patientmodule.PatientModule;
import org.openmrs.module.patientmodule.api.PatientModuleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by banga on 5/13/15.
 */

@Controller
public class PatientModuleDisplayController {

    protected final Log log = LogFactory.getLog(getClass());

    @RequestMapping(value = "/module/patientmodule/displaydata.form", method= RequestMethod.GET)
    public void display(ModelMap model) {

        PatientModuleService patientModuleService=Context.getService(PatientModuleService.class);
        model.addAttribute("user", Context.getAuthenticatedUser());
        List<PatientModule> patientData = patientModuleService.getAllPatients();
        model.addAttribute("patientData", patientData);

    }
}
