/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.business.impl.uom;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.bd.business.api.uom.IUomService;
import net.nan21.dnet.module.bd.domain.impl.uom.Uom;
import net.nan21.dnet.module.bd.domain.impl.uom.UomType;

/**
 * Repository functionality for {@link Uom} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class Uom_Service extends AbstractEntityService<Uom>
		implements
			IUomService {

	public Uom_Service() {
		super();
	}

	public Uom_Service(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<Uom> getEntityClass() {
		return Uom.class;
	}
	/**
	 * Find by unique key
	 */
	public Uom findByCode(String code) {
		return (Uom) this
				.getEntityManager()
				.createNamedQuery(Uom.NQ_FIND_BY_CODE)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("code", code).getSingleResult();
	}
	/**
	 * Find by unique key
	 */
	public Uom findByName(String name) {
		return (Uom) this
				.getEntityManager()
				.createNamedQuery(Uom.NQ_FIND_BY_NAME)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("name", name).getSingleResult();
	}
	/**
	 * Find by reference: type
	 */
	public List<Uom> findByType(UomType type) {
		return this.findByTypeId(type.getId());
	}
	/**
	 * Find by ID of reference: type.id
	 */
	public List<Uom> findByTypeId(String typeId) {
		return (List<Uom>) this
				.getEntityManager()
				.createQuery(
						"select e from Uom e where e.clientId = :clientId and e.type.id = :typeId",
						Uom.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("typeId", typeId).getResultList();
	}
}
