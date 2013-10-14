/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.business.api.attr;

import java.util.List;
import net.nan21.dnet.core.api.service.business.IEntityService;
import net.nan21.dnet.module.bd.domain.impl.attr.Attribute;
import net.nan21.dnet.module.bd.domain.impl.attr.AttributeCategory;
import net.nan21.dnet.module.bd.domain.impl.uom.Uom;

/**
 * Interface to expose business functions specific for {@link Attribute} domain
 * entity.
 */
public interface IAttributeService extends IEntityService<Attribute> {

	/**
	 * Find by unique key
	 */
	public Attribute findByCode(String code);

	/**
	 * Find by reference: category
	 */
	public List<Attribute> findByCategory(AttributeCategory category);

	/**
	 * Find by ID of reference: category.id
	 */
	public List<Attribute> findByCategoryId(String categoryId);

	/**
	 * Find by reference: uom
	 */
	public List<Attribute> findByUom(Uom uom);

	/**
	 * Find by ID of reference: uom.id
	 */
	public List<Attribute> findByUomId(String uomId);
}
