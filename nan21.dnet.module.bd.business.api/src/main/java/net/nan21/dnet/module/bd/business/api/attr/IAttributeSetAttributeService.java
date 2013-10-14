/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.business.api.attr;

import java.util.List;
import net.nan21.dnet.core.api.service.business.IEntityService;
import net.nan21.dnet.module.bd.domain.impl.attr.Attribute;
import net.nan21.dnet.module.bd.domain.impl.attr.AttributeSet;
import net.nan21.dnet.module.bd.domain.impl.attr.AttributeSetAttribute;
import net.nan21.dnet.module.bd.domain.impl.attr.AttributeSubSet;
import net.nan21.dnet.module.bd.domain.impl.attr.AttributeValue;

/**
 * Interface to expose business functions specific for {@link AttributeSetAttribute} domain
 * entity.
 */
public interface IAttributeSetAttributeService
		extends
			IEntityService<AttributeSetAttribute> {

	/**
	 * Find by unique key
	 */
	public AttributeSetAttribute findByName(AttributeSet attributeSet,
			Attribute attribute);

	/**
	 * Find by unique key
	 */
	public AttributeSetAttribute findByName(Long attributeSetId,
			Long attributeId);

	/**
	 * Find by reference: attribute
	 */
	public List<AttributeSetAttribute> findByAttribute(Attribute attribute);

	/**
	 * Find by ID of reference: attribute.id
	 */
	public List<AttributeSetAttribute> findByAttributeId(String attributeId);

	/**
	 * Find by reference: attributeSet
	 */
	public List<AttributeSetAttribute> findByAttributeSet(
			AttributeSet attributeSet);

	/**
	 * Find by ID of reference: attributeSet.id
	 */
	public List<AttributeSetAttribute> findByAttributeSetId(
			String attributeSetId);

	/**
	 * Find by reference: attributeSubSet
	 */
	public List<AttributeSetAttribute> findByAttributeSubSet(
			AttributeSubSet attributeSubSet);

	/**
	 * Find by ID of reference: attributeSubSet.id
	 */
	public List<AttributeSetAttribute> findByAttributeSubSetId(
			String attributeSubSetId);

	/**
	 * Find by reference: values
	 */
	public List<AttributeSetAttribute> findByValues(AttributeValue values);

	/**
	 * Find by ID of reference: values.id
	 */
	public List<AttributeSetAttribute> findByValuesId(String valuesId);
}
