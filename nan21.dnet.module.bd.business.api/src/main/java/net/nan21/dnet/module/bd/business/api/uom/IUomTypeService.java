/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.business.api.uom;

import net.nan21.dnet.core.api.service.business.IEntityService;
import net.nan21.dnet.module.bd.domain.impl.uom.UomType;

/**
 * Interface to expose business functions specific for {@link UomType} domain
 * entity.
 */
public interface IUomTypeService extends IEntityService<UomType> {

	/**
	 * Find by unique key
	 */
	public UomType findByCode(String code);

	/**
	 * Find by unique key
	 */
	public UomType findByName(String name);
}
