/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.business.impl.currency;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.bd.business.api.currency.ICurrencyXRateService;
import net.nan21.dnet.module.bd.domain.impl.currency.Currency;
import net.nan21.dnet.module.bd.domain.impl.currency.CurrencyXRate;
import net.nan21.dnet.module.bd.domain.impl.currency.CurrencyXRateProvider;

/**
 * Repository functionality for {@link CurrencyXRate} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class CurrencyXRate_Service extends AbstractEntityService<CurrencyXRate>
		implements
			ICurrencyXRateService {

	public CurrencyXRate_Service() {
		super();
	}

	public CurrencyXRate_Service(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<CurrencyXRate> getEntityClass() {
		return CurrencyXRate.class;
	}
	/**
	 * Find by unique key
	 */
	public CurrencyXRate findByValid(CurrencyXRateProvider provider,
			Currency source, Currency target, Date validAt) {
		return (CurrencyXRate) this
				.getEntityManager()
				.createNamedQuery(CurrencyXRate.NQ_FIND_BY_VALID)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("provider", provider)
				.setParameter("source", source).setParameter("target", target)
				.setParameter("validAt", validAt).getSingleResult();
	}
	/**
	 * Find by unique key
	 */
	public CurrencyXRate findByValid(Long providerId, Long sourceId,
			Long targetId, Date validAt) {
		return (CurrencyXRate) this
				.getEntityManager()
				.createNamedQuery(CurrencyXRate.NQ_FIND_BY_VALID_PRIMITIVE)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("providerId", providerId)
				.setParameter("sourceId", sourceId)
				.setParameter("targetId", targetId)
				.setParameter("validAt", validAt).getSingleResult();
	}
	/**
	 * Find by reference: provider
	 */
	public List<CurrencyXRate> findByProvider(CurrencyXRateProvider provider) {
		return this.findByProviderId(provider.getId());
	}
	/**
	 * Find by ID of reference: provider.id
	 */
	public List<CurrencyXRate> findByProviderId(String providerId) {
		return (List<CurrencyXRate>) this
				.getEntityManager()
				.createQuery(
						"select e from CurrencyXRate e where e.clientId = :clientId and e.provider.id = :providerId",
						CurrencyXRate.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("providerId", providerId).getResultList();
	}
	/**
	 * Find by reference: source
	 */
	public List<CurrencyXRate> findBySource(Currency source) {
		return this.findBySourceId(source.getId());
	}
	/**
	 * Find by ID of reference: source.id
	 */
	public List<CurrencyXRate> findBySourceId(String sourceId) {
		return (List<CurrencyXRate>) this
				.getEntityManager()
				.createQuery(
						"select e from CurrencyXRate e where e.clientId = :clientId and e.source.id = :sourceId",
						CurrencyXRate.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("sourceId", sourceId).getResultList();
	}
	/**
	 * Find by reference: target
	 */
	public List<CurrencyXRate> findByTarget(Currency target) {
		return this.findByTargetId(target.getId());
	}
	/**
	 * Find by ID of reference: target.id
	 */
	public List<CurrencyXRate> findByTargetId(String targetId) {
		return (List<CurrencyXRate>) this
				.getEntityManager()
				.createQuery(
						"select e from CurrencyXRate e where e.clientId = :clientId and e.target.id = :targetId",
						CurrencyXRate.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("targetId", targetId).getResultList();
	}
}
