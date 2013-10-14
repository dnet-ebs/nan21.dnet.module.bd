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
import net.nan21.dnet.module.bd.business.api.geo.ICityService;
import net.nan21.dnet.module.bd.domain.impl.geo.City;
import net.nan21.dnet.module.bd.domain.impl.geo.Country;
import net.nan21.dnet.module.bd.domain.impl.geo.Region;

/**
 * Repository functionality for {@link City} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class City_Service extends AbstractEntityService<City>
		implements
			ICityService {

	public City_Service() {
		super();
	}

	public City_Service(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<City> getEntityClass() {
		return City.class;
	}
	/**
	 * Find by reference: country
	 */
	public List<City> findByCountry(Country country) {
		return this.findByCountryId(country.getId());
	}
	/**
	 * Find by ID of reference: country.id
	 */
	public List<City> findByCountryId(String countryId) {
		return (List<City>) this
				.getEntityManager()
				.createQuery(
						"select e from City e where e.clientId = :clientId and e.country.id = :countryId",
						City.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("countryId", countryId).getResultList();
	}
	/**
	 * Find by reference: region
	 */
	public List<City> findByRegion(Region region) {
		return this.findByRegionId(region.getId());
	}
	/**
	 * Find by ID of reference: region.id
	 */
	public List<City> findByRegionId(String regionId) {
		return (List<City>) this
				.getEntityManager()
				.createQuery(
						"select e from City e where e.clientId = :clientId and e.region.id = :regionId",
						City.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("regionId", regionId).getResultList();
	}
}
