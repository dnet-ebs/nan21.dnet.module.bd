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
import net.nan21.dnet.module.bd.business.api.uom.IUomConversionService;
import net.nan21.dnet.module.bd.domain.impl.uom.Uom;
import net.nan21.dnet.module.bd.domain.impl.uom.UomConversion;

/**
 * Repository functionality for {@link UomConversion} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class UomConversion_Service extends AbstractEntityService<UomConversion>
		implements
			IUomConversionService {

	public UomConversion_Service() {
		super();
	}

	public UomConversion_Service(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<UomConversion> getEntityClass() {
		return UomConversion.class;
	}
	/**
	 * Find by reference: source
	 */
	public List<UomConversion> findBySource(Uom source) {
		return this.findBySourceId(source.getId());
	}
	/**
	 * Find by ID of reference: source.id
	 */
	public List<UomConversion> findBySourceId(String sourceId) {
		return (List<UomConversion>) this
				.getEntityManager()
				.createQuery(
						"select e from UomConversion e where e.clientId = :clientId and e.source.id = :sourceId",
						UomConversion.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("sourceId", sourceId).getResultList();
	}
	/**
	 * Find by reference: target
	 */
	public List<UomConversion> findByTarget(Uom target) {
		return this.findByTargetId(target.getId());
	}
	/**
	 * Find by ID of reference: target.id
	 */
	public List<UomConversion> findByTargetId(String targetId) {
		return (List<UomConversion>) this
				.getEntityManager()
				.createQuery(
						"select e from UomConversion e where e.clientId = :clientId and e.target.id = :targetId",
						UomConversion.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("targetId", targetId).getResultList();
	}
}
