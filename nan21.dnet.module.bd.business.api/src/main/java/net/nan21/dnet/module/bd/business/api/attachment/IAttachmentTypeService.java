/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.business.api.attachment;

import net.nan21.dnet.core.api.service.business.IEntityService;
import net.nan21.dnet.module.bd.domain.impl.attachment.AttachmentType;

/**
 * Interface to expose business functions specific for {@link AttachmentType} domain
 * entity.
 */
public interface IAttachmentTypeService extends IEntityService<AttachmentType> {

	/**
	 * Find by unique key
	 */
	public AttachmentType findByName(String name);
}
