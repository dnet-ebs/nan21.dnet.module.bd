/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.business.api.classification;

import net.nan21.dnet.core.api.service.business.IEntityService;
import net.nan21.dnet.module.bd.domain.impl.classification.ClassificationSystem;

/**
 * Interface to expose business functions specific for {@link ClassificationSystem} domain
 * entity.
 */
public interface IClassificationSystemService
		extends
			IEntityService<ClassificationSystem> {

	/**
	 * Find by unique key
	 */
	public ClassificationSystem findByCode(String code);

	/**
	 * Find by unique key
	 */
	public ClassificationSystem findByName(String name);
}
