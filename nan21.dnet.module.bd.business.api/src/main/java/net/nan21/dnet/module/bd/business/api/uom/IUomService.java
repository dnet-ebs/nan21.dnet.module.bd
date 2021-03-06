/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.business.api.uom;

import java.util.List;
import net.nan21.dnet.core.api.service.business.IEntityService;
import net.nan21.dnet.module.bd.domain.impl.uom.Uom;
import net.nan21.dnet.module.bd.domain.impl.uom.UomType;

/**
 * Interface to expose business functions specific for {@link Uom} domain
 * entity.
 */
public interface IUomService extends IEntityService<Uom> {

	/**
	 * Find by unique key
	 */
	public Uom findByCode(String code);

	/**
	 * Find by unique key
	 */
	public Uom findByName(String name);

	/**
	 * Find by reference: type
	 */
	public List<Uom> findByType(UomType type);

	/**
	 * Find by ID of reference: type.id
	 */
	public List<Uom> findByTypeId(String typeId);
}
