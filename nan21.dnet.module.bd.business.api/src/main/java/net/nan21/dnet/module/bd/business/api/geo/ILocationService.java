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
import net.nan21.dnet.module.bd.domain.impl.geo.Location;
import net.nan21.dnet.module.bd.domain.impl.geo.Region;

/**
 * Interface to expose business functions specific for {@link Location} domain
 * entity.
 */
public interface ILocationService extends IEntityService<Location> {

	/**
	 * Find by reference: country
	 */
	public List<Location> findByCountry(Country country);

	/**
	 * Find by ID of reference: country.id
	 */
	public List<Location> findByCountryId(String countryId);

	/**
	 * Find by reference: region
	 */
	public List<Location> findByRegion(Region region);

	/**
	 * Find by ID of reference: region.id
	 */
	public List<Location> findByRegionId(String regionId);

	/**
	 * Find by reference: city
	 */
	public List<Location> findByCity(City city);

	/**
	 * Find by ID of reference: city.id
	 */
	public List<Location> findByCityId(String cityId);
}
