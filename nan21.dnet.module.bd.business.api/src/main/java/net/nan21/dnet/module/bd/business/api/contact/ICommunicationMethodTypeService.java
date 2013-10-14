/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.business.api.contact;

import net.nan21.dnet.core.api.service.business.IEntityService;
import net.nan21.dnet.module.bd.domain.impl.contact.CommunicationMethodType;

/**
 * Interface to expose business functions specific for {@link CommunicationMethodType} domain
 * entity.
 */
public interface ICommunicationMethodTypeService
		extends
			IEntityService<CommunicationMethodType> {

	/**
	 * Find by unique key
	 */
	public CommunicationMethodType findByName(String name);
}
