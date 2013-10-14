/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.business.impl.geo;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.bd.business.api.geo.ICountryService;
import net.nan21.dnet.module.bd.domain.impl.geo.Country;

/**
 * Repository functionality for {@link Country} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class Country_Service extends AbstractEntityService<Country>
		implements
			ICountryService {

	public Country_Service() {
		super();
	}

	public Country_Service(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<Country> getEntityClass() {
		return Country.class;
	}
	/**
	 * Find by unique key
	 */
	public Country findByCode(String code) {
		return (Country) this
				.getEntityManager()
				.createNamedQuery(Country.NQ_FIND_BY_CODE)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("code", code).getSingleResult();
	}
	/**
	 * Find by unique key
	 */
	public Country findByName(String name) {
		return (Country) this
				.getEntityManager()
				.createNamedQuery(Country.NQ_FIND_BY_NAME)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("name", name).getSingleResult();
	}
}
