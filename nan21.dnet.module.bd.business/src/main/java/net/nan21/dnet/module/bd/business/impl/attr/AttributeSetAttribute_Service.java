/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.business.impl.attr;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.bd.business.api.attr.IAttributeSetAttributeService;
import net.nan21.dnet.module.bd.domain.impl.attr.Attribute;
import net.nan21.dnet.module.bd.domain.impl.attr.AttributeSet;
import net.nan21.dnet.module.bd.domain.impl.attr.AttributeSetAttribute;
import net.nan21.dnet.module.bd.domain.impl.attr.AttributeSubSet;
import net.nan21.dnet.module.bd.domain.impl.attr.AttributeValue;

/**
 * Repository functionality for {@link AttributeSetAttribute} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class AttributeSetAttribute_Service
		extends
			AbstractEntityService<AttributeSetAttribute>
		implements
			IAttributeSetAttributeService {

	public AttributeSetAttribute_Service() {
		super();
	}

	public AttributeSetAttribute_Service(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<AttributeSetAttribute> getEntityClass() {
		return AttributeSetAttribute.class;
	}
	/**
	 * Find by unique key
	 */
	public AttributeSetAttribute findByName(AttributeSet attributeSet,
			Attribute attribute) {
		return (AttributeSetAttribute) this
				.getEntityManager()
				.createNamedQuery(AttributeSetAttribute.NQ_FIND_BY_NAME)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("attributeSet", attributeSet)
				.setParameter("attribute", attribute).getSingleResult();
	}
	/**
	 * Find by unique key
	 */
	public AttributeSetAttribute findByName(Long attributeSetId,
			Long attributeId) {
		return (AttributeSetAttribute) this
				.getEntityManager()
				.createNamedQuery(
						AttributeSetAttribute.NQ_FIND_BY_NAME_PRIMITIVE)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("attributeSetId", attributeSetId)
				.setParameter("attributeId", attributeId).getSingleResult();
	}
	/**
	 * Find by reference: attribute
	 */
	public List<AttributeSetAttribute> findByAttribute(Attribute attribute) {
		return this.findByAttributeId(attribute.getId());
	}
	/**
	 * Find by ID of reference: attribute.id
	 */
	public List<AttributeSetAttribute> findByAttributeId(String attributeId) {
		return (List<AttributeSetAttribute>) this
				.getEntityManager()
				.createQuery(
						"select e from AttributeSetAttribute e where e.clientId = :clientId and e.attribute.id = :attributeId",
						AttributeSetAttribute.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("attributeId", attributeId).getResultList();
	}
	/**
	 * Find by reference: attributeSet
	 */
	public List<AttributeSetAttribute> findByAttributeSet(
			AttributeSet attributeSet) {
		return this.findByAttributeSetId(attributeSet.getId());
	}
	/**
	 * Find by ID of reference: attributeSet.id
	 */
	public List<AttributeSetAttribute> findByAttributeSetId(
			String attributeSetId) {
		return (List<AttributeSetAttribute>) this
				.getEntityManager()
				.createQuery(
						"select e from AttributeSetAttribute e where e.clientId = :clientId and e.attributeSet.id = :attributeSetId",
						AttributeSetAttribute.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("attributeSetId", attributeSetId).getResultList();
	}
	/**
	 * Find by reference: attributeSubSet
	 */
	public List<AttributeSetAttribute> findByAttributeSubSet(
			AttributeSubSet attributeSubSet) {
		return this.findByAttributeSubSetId(attributeSubSet.getId());
	}
	/**
	 * Find by ID of reference: attributeSubSet.id
	 */
	public List<AttributeSetAttribute> findByAttributeSubSetId(
			String attributeSubSetId) {
		return (List<AttributeSetAttribute>) this
				.getEntityManager()
				.createQuery(
						"select e from AttributeSetAttribute e where e.clientId = :clientId and e.attributeSubSet.id = :attributeSubSetId",
						AttributeSetAttribute.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("attributeSubSetId", attributeSubSetId)
				.getResultList();
	}
	/**
	 * Find by reference: values
	 */
	public List<AttributeSetAttribute> findByValues(AttributeValue values) {
		return this.findByValuesId(values.getId());
	}
	/**
	 * Find by ID of reference: values.id
	 */
	public List<AttributeSetAttribute> findByValuesId(String valuesId) {
		return (List<AttributeSetAttribute>) this
				.getEntityManager()
				.createQuery(
						"select distinct e from AttributeSetAttribute e, IN (e.values) c where e.clientId = :clientId and c.id = :valuesId",
						AttributeSetAttribute.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("valuesId", valuesId).getResultList();
	}
}
