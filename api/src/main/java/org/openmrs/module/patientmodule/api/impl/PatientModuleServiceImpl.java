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
package org.openmrs.module.patientmodule.api.impl;

import org.openmrs.api.impl.BaseOpenmrsService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.module.patientmodule.PatientModule;
import org.openmrs.module.patientmodule.api.PatientModuleService;
import org.openmrs.module.patientmodule.api.db.PatientModuleDAO;

import java.util.List;

/**
 * It is a default implementation of {@link PatientModuleService}.
 */
public class PatientModuleServiceImpl extends BaseOpenmrsService implements PatientModuleService {
	
	protected final Log log = LogFactory.getLog(this.getClass());
	
	private PatientModuleDAO dao;
	
	/**
     * @param dao the dao to set
     */
    public void setDao(PatientModuleDAO dao) {
	    this.dao = dao;
    }
    
    /**
     * @return the dao
     */
    public PatientModuleDAO getDao() {
	    return dao;
    }

    @Override
    public List<PatientModule> getAllPatients() {
        return dao.getAllPatients();
    }

    @Override
    public PatientModule getPatient(Integer nationalId) {
        return dao.getPatient(nationalId);
    }

    @Override
    public PatientModule savePatient(PatientModule patientModule) {
        return dao.savePatient(patientModule);
    }

    @Override
    public void purgePatientModule(PatientModule patientModule) {
        dao.purgePatientModule(patientModule);
    }
}