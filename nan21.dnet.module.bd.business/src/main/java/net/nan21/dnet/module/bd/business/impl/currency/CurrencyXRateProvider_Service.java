/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.business.impl.currency;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.bd.business.api.currency.ICurrencyXRateProviderService;
import net.nan21.dnet.module.bd.domain.impl.currency.CurrencyXRateProvider;

/**
 * Repository functionality for {@link CurrencyXRateProvider} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class CurrencyXRateProvider_Service
		extends
			AbstractEntityService<CurrencyXRateProvider>
		implements
			ICurrencyXRateProviderService {

	public CurrencyXRateProvider_Service() {
		super();
	}

	public CurrencyXRateProvider_Service(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<CurrencyXRateProvider> getEntityClass() {
		return CurrencyXRateProvider.class;
	}
	/**
	 * Find by unique key
	 */
	public CurrencyXRateProvider findByCode(String code) {
		return (CurrencyXRateProvider) this
				.getEntityManager()
				.createNamedQuery(CurrencyXRateProvider.NQ_FIND_BY_CODE)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("code", code).getSingleResult();
	}
	/**
	 * Find by unique key
	 */
	public CurrencyXRateProvider findByName(String name) {
		return (CurrencyXRateProvider) this
				.getEntityManager()
				.createNamedQuery(CurrencyXRateProvider.NQ_FIND_BY_NAME)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("name", name).getSingleResult();
	}
}
