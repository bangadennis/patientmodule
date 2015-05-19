package org.openmrs.module.patientmodule.page.controller;


import org.openmrs.api.context.Context;
import org.openmrs.ui.framework.page.PageModel;

/**
 * Created by banga on 5/14/15.
 */

public class HelloWorldPageController {

    public void controller(PageModel model) {
        model.addAttribute("authenticatedUser", Context.getAuthenticatedUser());
    }

}
