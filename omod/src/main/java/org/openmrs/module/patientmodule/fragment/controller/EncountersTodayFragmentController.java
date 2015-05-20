package org.openmrs.module.patientmodule.fragment.controller;

import org.openmrs.api.EncounterService;
import org.openmrs.ui.framework.annotation.SpringBean;
import org.openmrs.ui.framework.fragment.FragmentModel;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by banga on 5/19/15.
 */
public class EncountersTodayFragmentController {
    public void controller(FragmentModel model, @SpringBean("encounterService") EncounterService service) {
//        Calendar cal = Calendar.getInstance();
//        cal.set(Calendar.HOUR_OF_DAY, 0);
//        cal.set(Calendar.MINUTE, 0);
//        cal.set(Calendar.SECOND, 0);
//        cal.set(Calendar.MILLISECOND, 0);
//        Date startOfDay = cal.getTime();
//
//        cal.add(Calendar.DAY_OF_MONTH, 1);
//        cal.add(Calendar.MILLISECOND, -1);
//        Date endOfDay = cal.getTime();
        Date startOfDay=new Date();
        Date endOfDay=new Date();
        try {
            startOfDay = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse("2011-02-16 00:00:00.000");
            endOfDay = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse("2015-05-20 23:59:59.999");
        } catch (Exception ex) { }

        model.addAttribute("encounters", service.getEncounters(null, null, startOfDay, endOfDay, null, null, null, false));
    }

}
