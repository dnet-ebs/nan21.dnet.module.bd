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
import net.nan21.dnet.module.bd.business.api.attr.IAttributeSubSetService;
import net.nan21.dnet.module.bd.domain.impl.attr.AttributeSet;
import net.nan21.dnet.module.bd.domain.impl.attr.AttributeSubSet;

/**
 * Repository functionality for {@link AttributeSubSet} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class AttributeSubSet_Service
		extends
			AbstractEntityService<AttributeSubSet>
		implements
			IAttributeSubSetService {

	public AttributeSubSet_Service() {
		super();
	}

	public AttributeSubSet_Service(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<AttributeSubSet> getEntityClass() {
		return AttributeSubSet.class;
	}
	/**
	 * Find by unique key
	 */
	public AttributeSubSet findByCode(AttributeSet attributeSet, String code) {
		return (AttributeSubSet) this
				.getEntityManager()
				.createNamedQuery(AttributeSubSet.NQ_FIND_BY_CODE)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("attributeSet", attributeSet)
				.setParameter("code", code).getSingleResult();
	}
	/**
	 * Find by unique key
	 */
	public AttributeSubSet findByCode(Long attributeSetId, String code) {
		return (AttributeSubSet) this
				.getEntityManager()
				.createNamedQuery(AttributeSubSet.NQ_FIND_BY_CODE_PRIMITIVE)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("attributeSetId", attributeSetId)
				.setParameter("code", code).getSingleResult();
	}
	/**
	 * Find by reference: attributeSet
	 */
	public List<AttributeSubSet> findByAttributeSet(AttributeSet attributeSet) {
		return this.findByAttributeSetId(attributeSet.getId());
	}
	/**
	 * Find by ID of reference: attributeSet.id
	 */
	public List<AttributeSubSet> findByAttributeSetId(String attributeSetId) {
		return (List<AttributeSubSet>) this
				.getEntityManager()
				.createQuery(
						"select e from AttributeSubSet e where e.clientId = :clientId and e.attributeSet.id = :attributeSetId",
						AttributeSubSet.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("attributeSetId", attributeSetId).getResultList();
	}
}
