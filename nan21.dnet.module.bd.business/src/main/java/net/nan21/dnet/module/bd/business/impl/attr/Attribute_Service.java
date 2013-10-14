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
import net.nan21.dnet.module.bd.business.api.attr.IAttributeService;
import net.nan21.dnet.module.bd.domain.impl.attr.Attribute;
import net.nan21.dnet.module.bd.domain.impl.attr.AttributeCategory;
import net.nan21.dnet.module.bd.domain.impl.uom.Uom;

/**
 * Repository functionality for {@link Attribute} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class Attribute_Service extends AbstractEntityService<Attribute>
		implements
			IAttributeService {

	public Attribute_Service() {
		super();
	}

	public Attribute_Service(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<Attribute> getEntityClass() {
		return Attribute.class;
	}
	/**
	 * Find by unique key
	 */
	public Attribute findByCode(String code) {
		return (Attribute) this
				.getEntityManager()
				.createNamedQuery(Attribute.NQ_FIND_BY_CODE)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("code", code).getSingleResult();
	}
	/**
	 * Find by reference: category
	 */
	public List<Attribute> findByCategory(AttributeCategory category) {
		return this.findByCategoryId(category.getId());
	}
	/**
	 * Find by ID of reference: category.id
	 */
	public List<Attribute> findByCategoryId(String categoryId) {
		return (List<Attribute>) this
				.getEntityManager()
				.createQuery(
						"select e from Attribute e where e.clientId = :clientId and e.category.id = :categoryId",
						Attribute.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("categoryId", categoryId).getResultList();
	}
	/**
	 * Find by reference: uom
	 */
	public List<Attribute> findByUom(Uom uom) {
		return this.findByUomId(uom.getId());
	}
	/**
	 * Find by ID of reference: uom.id
	 */
	public List<Attribute> findByUomId(String uomId) {
		return (List<Attribute>) this
				.getEntityManager()
				.createQuery(
						"select e from Attribute e where e.clientId = :clientId and e.uom.id = :uomId",
						Attribute.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("uomId", uomId).getResultList();
	}
}
