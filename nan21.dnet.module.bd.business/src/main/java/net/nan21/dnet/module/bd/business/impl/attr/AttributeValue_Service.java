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
import net.nan21.dnet.module.bd.business.api.attr.IAttributeValueService;
import net.nan21.dnet.module.bd.domain.impl.attr.AttributeSetAttribute;
import net.nan21.dnet.module.bd.domain.impl.attr.AttributeValue;

/**
 * Repository functionality for {@link AttributeValue} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class AttributeValue_Service
		extends
			AbstractEntityService<AttributeValue>
		implements
			IAttributeValueService {

	public AttributeValue_Service() {
		super();
	}

	public AttributeValue_Service(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<AttributeValue> getEntityClass() {
		return AttributeValue.class;
	}
	/**
	 * Find by unique key
	 */
	public AttributeValue findByAttr(String targetRefid,
			AttributeSetAttribute setAttribute) {
		return (AttributeValue) this
				.getEntityManager()
				.createNamedQuery(AttributeValue.NQ_FIND_BY_ATTR)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("targetRefid", targetRefid)
				.setParameter("setAttribute", setAttribute).getSingleResult();
	}
	/**
	 * Find by unique key
	 */
	public AttributeValue findByAttr(String targetRefid, Long setAttributeId) {
		return (AttributeValue) this
				.getEntityManager()
				.createNamedQuery(AttributeValue.NQ_FIND_BY_ATTR_PRIMITIVE)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("targetRefid", targetRefid)
				.setParameter("setAttributeId", setAttributeId)
				.getSingleResult();
	}
	/**
	 * Find by reference: setAttribute
	 */
	public List<AttributeValue> findBySetAttribute(
			AttributeSetAttribute setAttribute) {
		return this.findBySetAttributeId(setAttribute.getId());
	}
	/**
	 * Find by ID of reference: setAttribute.id
	 */
	public List<AttributeValue> findBySetAttributeId(String setAttributeId) {
		return (List<AttributeValue>) this
				.getEntityManager()
				.createQuery(
						"select e from AttributeValue e where e.clientId = :clientId and e.setAttribute.id = :setAttributeId",
						AttributeValue.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("setAttributeId", setAttributeId).getResultList();
	}
}
