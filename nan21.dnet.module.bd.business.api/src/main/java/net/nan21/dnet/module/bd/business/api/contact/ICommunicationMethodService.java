/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.business.api.contact;

import java.util.List;
import net.nan21.dnet.core.api.service.business.IEntityService;
import net.nan21.dnet.module.bd.domain.impl.contact.CommunicationMethod;
import net.nan21.dnet.module.bd.domain.impl.contact.CommunicationMethodType;

/**
 * Interface to expose business functions specific for {@link CommunicationMethod} domain
 * entity.
 */
public interface ICommunicationMethodService
		extends
			IEntityService<CommunicationMethod> {

	/**
	 * Find by reference: type
	 */
	public List<CommunicationMethod> findByType(CommunicationMethodType type);

	/**
	 * Find by ID of reference: type.id
	 */
	public List<CommunicationMethod> findByTypeId(String typeId);
}
