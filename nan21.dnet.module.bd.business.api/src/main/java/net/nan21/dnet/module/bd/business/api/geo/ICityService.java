/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.business.api.geo;

import java.util.List;
import net.nan21.dnet.core.api.service.business.IEntityService;
import net.nan21.dnet.module.bd.domain.impl.geo.City;
import net.nan21.dnet.module.bd.domain.impl.geo.Country;
import net.nan21.dnet.module.bd.domain.impl.geo.Region;

/**
 * Interface to expose business functions specific for {@link City} domain
 * entity.
 */
public interface ICityService extends IEntityService<City> {

	/**
	 * Find by reference: country
	 */
	public List<City> findByCountry(Country country);

	/**
	 * Find by ID of reference: country.id
	 */
	public List<City> findByCountryId(String countryId);

	/**
	 * Find by reference: region
	 */
	public List<City> findByRegion(Region region);

	/**
	 * Find by ID of reference: region.id
	 */
	public List<City> findByRegionId(String regionId);
}
