/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.business.api.attr;

import java.util.List;
import net.nan21.dnet.core.api.service.business.IEntityService;
import net.nan21.dnet.module.bd.domain.impl.attr.AttributeSet;
import net.nan21.dnet.module.bd.domain.impl.attr.AttributeSubSet;

/**
 * Interface to expose business functions specific for {@link AttributeSubSet} domain
 * entity.
 */
public interface IAttributeSubSetService
		extends
			IEntityService<AttributeSubSet> {

	/**
	 * Find by unique key
	 */
	public AttributeSubSet findByCode(AttributeSet attributeSet, String code);

	/**
	 * Find by unique key
	 */
	public AttributeSubSet findByCode(Long attributeSetId, String code);

	/**
	 * Find by reference: attributeSet
	 */
	public List<AttributeSubSet> findByAttributeSet(AttributeSet attributeSet);

	/**
	 * Find by ID of reference: attributeSet.id
	 */
	public List<AttributeSubSet> findByAttributeSetId(String attributeSetId);
}
