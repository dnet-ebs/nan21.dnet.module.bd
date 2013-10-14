/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.business.api.attr;

import java.util.List;
import net.nan21.dnet.core.api.service.business.IEntityService;
import net.nan21.dnet.module.bd.domain.impl.attr.AttributeSetAttribute;
import net.nan21.dnet.module.bd.domain.impl.attr.AttributeValue;

/**
 * Interface to expose business functions specific for {@link AttributeValue} domain
 * entity.
 */
public interface IAttributeValueService extends IEntityService<AttributeValue> {

	/**
	 * Find by unique key
	 */
	public AttributeValue findByAttr(String targetRefid,
			AttributeSetAttribute setAttribute);

	/**
	 * Find by unique key
	 */
	public AttributeValue findByAttr(String targetRefid, Long setAttributeId);

	/**
	 * Find by reference: setAttribute
	 */
	public List<AttributeValue> findBySetAttribute(
			AttributeSetAttribute setAttribute);

	/**
	 * Find by ID of reference: setAttribute.id
	 */
	public List<AttributeValue> findBySetAttributeId(String setAttributeId);
}
