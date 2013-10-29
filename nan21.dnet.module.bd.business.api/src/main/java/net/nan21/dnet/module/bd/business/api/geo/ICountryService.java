/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.business.api.geo;

import net.nan21.dnet.core.api.service.business.IEntityService;
import net.nan21.dnet.module.bd.domain.impl.geo.Country;

/**
 * Interface to expose business functions specific for {@link Country} domain
 * entity.
 */
public interface ICountryService extends IEntityService<Country> {

	/**
	 * Find by unique key
	 */
	public Country findByCode(String code);

	/**
	 * Find by unique key
	 */
	public Country findByName(String name);

	/**
	 * Find by unique key
	 */
	public Country findByIso2(String iso2);
}
