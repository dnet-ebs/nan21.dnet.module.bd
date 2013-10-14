/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.business.api.classification;

import java.util.List;
import net.nan21.dnet.core.api.service.business.IEntityService;
import net.nan21.dnet.module.bd.domain.impl.classification.Classification;
import net.nan21.dnet.module.bd.domain.impl.classification.ClassificationItem;
import net.nan21.dnet.module.bd.domain.impl.classification.ClassificationSystem;

/**
 * Interface to expose business functions specific for {@link Classification} domain
 * entity.
 */
public interface IClassificationService extends IEntityService<Classification> {

	/**
	 * Find by reference: classSystem
	 */
	public List<Classification> findByClassSystem(
			ClassificationSystem classSystem);

	/**
	 * Find by ID of reference: classSystem.id
	 */
	public List<Classification> findByClassSystemId(String classSystemId);

	/**
	 * Find by reference: classItem
	 */
	public List<Classification> findByClassItem(ClassificationItem classItem);

	/**
	 * Find by ID of reference: classItem.id
	 */
	public List<Classification> findByClassItemId(String classItemId);
}
