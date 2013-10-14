/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.business.api.currency;

import java.util.List;
import net.nan21.dnet.core.api.service.business.IEntityService;
import net.nan21.dnet.module.bd.domain.impl.currency.Currency;
import net.nan21.dnet.module.bd.domain.impl.currency.CurrencyXRateAverage;
import net.nan21.dnet.module.bd.domain.impl.currency.CurrencyXRateProvider;

/**
 * Interface to expose business functions specific for {@link CurrencyXRateAverage} domain
 * entity.
 */
public interface ICurrencyXRateAverageService
		extends
			IEntityService<CurrencyXRateAverage> {

	/**
	 * Find by reference: provider
	 */
	public List<CurrencyXRateAverage> findByProvider(
			CurrencyXRateProvider provider);

	/**
	 * Find by ID of reference: provider.id
	 */
	public List<CurrencyXRateAverage> findByProviderId(String providerId);

	/**
	 * Find by reference: source
	 */
	public List<CurrencyXRateAverage> findBySource(Currency source);

	/**
	 * Find by ID of reference: source.id
	 */
	public List<CurrencyXRateAverage> findBySourceId(String sourceId);

	/**
	 * Find by reference: target
	 */
	public List<CurrencyXRateAverage> findByTarget(Currency target);

	/**
	 * Find by ID of reference: target.id
	 */
	public List<CurrencyXRateAverage> findByTargetId(String targetId);
}
