/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.business.impl.classification;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.bd.business.api.classification.IClassificationService;
import net.nan21.dnet.module.bd.domain.impl.classification.Classification;
import net.nan21.dnet.module.bd.domain.impl.classification.ClassificationItem;
import net.nan21.dnet.module.bd.domain.impl.classification.ClassificationSystem;

/**
 * Repository functionality for {@link Classification} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class Classification_Service
		extends
			AbstractEntityService<Classification>
		implements
			IClassificationService {

	public Classification_Service() {
		super();
	}

	public Classification_Service(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<Classification> getEntityClass() {
		return Classification.class;
	}
	/**
	 * Find by reference: classSystem
	 */
	public List<Classification> findByClassSystem(
			ClassificationSystem classSystem) {
		return this.findByClassSystemId(classSystem.getId());
	}
	/**
	 * Find by ID of reference: classSystem.id
	 */
	public List<Classification> findByClassSystemId(String classSystemId) {
		return (List<Classification>) this
				.getEntityManager()
				.createQuery(
						"select e from Classification e where e.clientId = :clientId and e.classSystem.id = :classSystemId",
						Classification.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("classSystemId", classSystemId).getResultList();
	}
	/**
	 * Find by reference: classItem
	 */
	public List<Classification> findByClassItem(ClassificationItem classItem) {
		return this.findByClassItemId(classItem.getId());
	}
	/**
	 * Find by ID of reference: classItem.id
	 */
	public List<Classification> findByClassItemId(String classItemId) {
		return (List<Classification>) this
				.getEntityManager()
				.createQuery(
						"select e from Classification e where e.clientId = :clientId and e.classItem.id = :classItemId",
						Classification.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("classItemId", classItemId).getResultList();
	}
}
