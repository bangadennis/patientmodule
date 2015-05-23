package org.openmrs.module.patientmodule.usermethod;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by banga on 5/22/15.
 */
public class ConvertStringToDate {
        /*constructor*/
        public ConvertStringToDate() {
        }

        public Date convert(String dateInString) throws ParseException {

            SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");

            if(dateInString.contains("-"))
            {
                dateInString=dateInString.replaceAll("-", "/");
            }

            Date date = null;

            if (dateInString != "") {
                if (dateInString.contains("/")) {

                    date = formatter.parse(dateInString);
                }

            }
            return date;
        }
    }
