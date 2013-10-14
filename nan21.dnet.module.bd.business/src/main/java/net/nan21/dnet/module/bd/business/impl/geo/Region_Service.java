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
import net.nan21.dnet.module.bd.business.api.geo.IRegionService;
import net.nan21.dnet.module.bd.domain.impl.geo.Country;
import net.nan21.dnet.module.bd.domain.impl.geo.Region;

/**
 * Repository functionality for {@link Region} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class Region_Service extends AbstractEntityService<Region>
		implements
			IRegionService {

	public Region_Service() {
		super();
	}

	public Region_Service(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<Region> getEntityClass() {
		return Region.class;
	}
	/**
	 * Find by unique key
	 */
	public Region findByCodeAndCountry(Country country, String code) {
		return (Region) this
				.getEntityManager()
				.createNamedQuery(Region.NQ_FIND_BY_CODEANDCOUNTRY)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("country", country).setParameter("code", code)
				.getSingleResult();
	}
	/**
	 * Find by unique key
	 */
	public Region findByCodeAndCountry(Long countryId, String code) {
		return (Region) this
				.getEntityManager()
				.createNamedQuery(Region.NQ_FIND_BY_CODEANDCOUNTRY_PRIMITIVE)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("countryId", countryId)
				.setParameter("code", code).getSingleResult();
	}
	/**
	 * Find by reference: country
	 */
	public List<Region> findByCountry(Country country) {
		return this.findByCountryId(country.getId());
	}
	/**
	 * Find by ID of reference: country.id
	 */
	public List<Region> findByCountryId(String countryId) {
		return (List<Region>) this
				.getEntityManager()
				.createQuery(
						"select e from Region e where e.clientId = :clientId and e.country.id = :countryId",
						Region.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("countryId", countryId).getResultList();
	}
}
