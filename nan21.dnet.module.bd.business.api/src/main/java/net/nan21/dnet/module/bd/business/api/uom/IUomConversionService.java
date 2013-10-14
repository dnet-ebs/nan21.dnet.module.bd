/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.business.api.uom;

import java.util.List;
import net.nan21.dnet.core.api.service.business.IEntityService;
import net.nan21.dnet.module.bd.domain.impl.uom.Uom;
import net.nan21.dnet.module.bd.domain.impl.uom.UomConversion;

/**
 * Interface to expose business functions specific for {@link UomConversion} domain
 * entity.
 */
public interface IUomConversionService extends IEntityService<UomConversion> {

	/**
	 * Find by reference: source
	 */
	public List<UomConversion> findBySource(Uom source);

	/**
	 * Find by ID of reference: source.id
	 */
	public List<UomConversion> findBySourceId(String sourceId);

	/**
	 * Find by reference: target
	 */
	public List<UomConversion> findByTarget(Uom target);

	/**
	 * Find by ID of reference: target.id
	 */
	public List<UomConversion> findByTargetId(String targetId);
}
