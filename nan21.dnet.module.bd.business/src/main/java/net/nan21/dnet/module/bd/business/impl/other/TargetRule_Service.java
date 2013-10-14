/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.business.impl.other;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.bd.business.api.other.ITargetRuleService;
import net.nan21.dnet.module.bd.domain.impl.other.TargetRule;

/**
 * Repository functionality for {@link TargetRule} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class TargetRule_Service extends AbstractEntityService<TargetRule>
		implements
			ITargetRuleService {

	public TargetRule_Service() {
		super();
	}

	public TargetRule_Service(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<TargetRule> getEntityClass() {
		return TargetRule.class;
	}
}
