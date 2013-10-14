/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.business.api.currency;

import net.nan21.dnet.core.api.service.business.IEntityService;
import net.nan21.dnet.module.bd.domain.impl.currency.Currency;

/**
 * Interface to expose business functions specific for {@link Currency} domain
 * entity.
 */
public interface ICurrencyService extends IEntityService<Currency> {

	/**
	 * Find by unique key
	 */
	public Currency findByCode(String code);

	/**
	 * Find by unique key
	 */
	public Currency findByName(String name);
}
