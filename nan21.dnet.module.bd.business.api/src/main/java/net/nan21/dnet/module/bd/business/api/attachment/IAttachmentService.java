/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.business.api.attachment;

import java.util.List;
import net.nan21.dnet.core.api.service.business.IEntityService;
import net.nan21.dnet.module.bd.domain.impl.attachment.Attachment;
import net.nan21.dnet.module.bd.domain.impl.attachment.AttachmentType;

/**
 * Interface to expose business functions specific for {@link Attachment} domain
 * entity.
 */
public interface IAttachmentService extends IEntityService<Attachment> {

	/**
	 * Find by reference: type
	 */
	public List<Attachment> findByType(AttachmentType type);

	/**
	 * Find by ID of reference: type.id
	 */
	public List<Attachment> findByTypeId(String typeId);
}
