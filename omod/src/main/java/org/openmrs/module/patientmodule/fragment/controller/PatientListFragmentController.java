package org.openmrs.module.patientmodule.fragment.controller;

import org.openmrs.api.PatientService;
import org.openmrs.ui.framework.annotation.SpringBean;
import org.openmrs.ui.framework.fragment.FragmentModel;

/**
 * Created by banga on 5/20/15.
 */
public class PatientListFragmentController {
    public void controller(FragmentModel model, @SpringBean("patientService") PatientService service) {

        model.addAttribute("patients", service.getAllPatients());
    }
}
