/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.business.impl.geo;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.bd.business.api.geo.ILocationService;
import net.nan21.dnet.module.bd.domain.impl.geo.City;
import net.nan21.dnet.module.bd.domain.impl.geo.Country;
import net.nan21.dnet.module.bd.domain.impl.geo.Location;
import net.nan21.dnet.module.bd.domain.impl.geo.Region;

/**
 * Repository functionality for {@link Location} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class Location_Service extends AbstractEntityService<Location>
		implements
			ILocationService {

	public Location_Service() {
		super();
	}

	public Location_Service(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<Location> getEntityClass() {
		return Location.class;
	}
	/**
	 * Find by reference: country
	 */
	public List<Location> findByCountry(Country country) {
		return this.findByCountryId(country.getId());
	}
	/**
	 * Find by ID of reference: country.id
	 */
	public List<Location> findByCountryId(String countryId) {
		return (List<Location>) this
				.getEntityManager()
				.createQuery(
						"select e from Location e where e.clientId = :clientId and e.country.id = :countryId",
						Location.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("countryId", countryId).getResultList();
	}
	/**
	 * Find by reference: region
	 */
	public List<Location> findByRegion(Region region) {
		return this.findByRegionId(region.getId());
	}
	/**
	 * Find by ID of reference: region.id
	 */
	public List<Location> findByRegionId(String regionId) {
		return (List<Location>) this
				.getEntityManager()
				.createQuery(
						"select e from Location e where e.clientId = :clientId and e.region.id = :regionId",
						Location.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("regionId", regionId).getResultList();
	}
	/**
	 * Find by reference: city
	 */
	public List<Location> findByCity(City city) {
		return this.findByCityId(city.getId());
	}
	/**
	 * Find by ID of reference: city.id
	 */
	public List<Location> findByCityId(String cityId) {
		return (List<Location>) this
				.getEntityManager()
				.createQuery(
						"select e from Location e where e.clientId = :clientId and e.city.id = :cityId",
						Location.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("cityId", cityId).getResultList();
	}
}
