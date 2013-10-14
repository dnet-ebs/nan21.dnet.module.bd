/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.business.api.geo;

import java.util.List;
import net.nan21.dnet.core.api.service.business.IEntityService;
import net.nan21.dnet.module.bd.domain.impl.geo.Country;
import net.nan21.dnet.module.bd.domain.impl.geo.Region;

/**
 * Interface to expose business functions specific for {@link Region} domain
 * entity.
 */
public interface IRegionService extends IEntityService<Region> {

	/**
	 * Find by unique key
	 */
	public Region findByCodeAndCountry(Country country, String code);

	/**
	 * Find by unique key
	 */
	public Region findByCodeAndCountry(Long countryId, String code);

	/**
	 * Find by reference: country
	 */
	public List<Region> findByCountry(Country country);

	/**
	 * Find by ID of reference: country.id
	 */
	public List<Region> findByCountryId(String countryId);
}
