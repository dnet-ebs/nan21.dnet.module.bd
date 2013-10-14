package net.nan21.dnet.module.bd.presenter.ext.attr.delegate;

import java.util.ArrayList;
import java.util.List;

import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.presenter.service.AbstractPresenterDelegate;
import net.nan21.dnet.module.bd.business.api.attr.IAttributeSubSetService;
import net.nan21.dnet.module.bd.business.api.attr.IAttributeValueService;
import net.nan21.dnet.module.bd.domain.impl.attr.AttributeSet;
import net.nan21.dnet.module.bd.domain.impl.attr.AttributeSetAttribute;
import net.nan21.dnet.module.bd.domain.impl.attr.AttributeSubSet;
import net.nan21.dnet.module.bd.domain.impl.attr.AttributeValue;
import net.nan21.dnet.module.bd.presenter.impl.attr.model.AttributeSet_Ds;
import net.nan21.dnet.module.bd.presenter.impl.attr.model.AttributeSet_DsParam;
import net.nan21.dnet.module.bd.presenter.impl.attr.model.AttributeValue_Ds;

public class Attribute_Pd extends AbstractPresenterDelegate {

	/**
	 * Create a sub-set with the code and name given in the parameters for each
	 * of the sets in list
	 * 
	 * @param list
	 * @param params
	 * @throws Exception
	 */
	public void createDefaultSubSet(List<AttributeSet_Ds> list,
			AttributeSet_DsParam params) throws Exception {

		List<Object> ids = this.collectIds(list);
		IAttributeSubSetService srv = (IAttributeSubSetService) this
				.findEntityService(AttributeSubSet.class);
		List<AttributeSubSet> result = new ArrayList<AttributeSubSet>();

		List<AttributeSet> sets = srv.findByIds(ids, AttributeSet.class);

		for (AttributeSet set : sets) {
			AttributeSubSet e = new AttributeSubSet();
			e.setAttributeSet(set);
			e.setCode(params.getSubSetCode());
			e.setName(params.getSubSetName());
			e.setSequenceNo(10);
			result.add(e);
		}
		srv.insert(result);
	}

	/**
	 * Create missing attribute values for the given target according to the
	 * required attribute-set
	 * 
	 * @param filter
	 * @throws Exception
	 */
	public void synchronizeAttributes(AttributeValue_Ds filter)
			throws Exception {

		IAttributeValueService srv = (IAttributeValueService) this
				.findEntityService(AttributeValue.class);
		List<AttributeValue> result = new ArrayList<AttributeValue>();
		String targetRefId = filter.getTargetRefid();
		String attributeSetId = filter.getAttributeSetId();

		String eql = "select e from "
				+ AttributeSetAttribute.class.getSimpleName()
				+ " e where e.attributeSet.id = :attributeSetId "
				+ " and  e.id not in "
				+ " (select v.setAttribute.id from "
				+ AttributeValue.class.getSimpleName()
				+ " v where v.clientId = :clientId and v.targetRefid = :targetRefid ) ";

		List<AttributeSetAttribute> list = srv.getEntityManager()
				.createQuery(eql, AttributeSetAttribute.class)
				.setParameter("clientId", Session.user.get().getClientId())
				.setParameter("attributeSetId", attributeSetId)
				.setParameter("targetRefid", targetRefId).getResultList();

		for (AttributeSetAttribute asa : list) {
			AttributeValue av = new AttributeValue();
			av.setActive(true);
			av.setSetAttribute(asa);
			av.setTargetRefid(targetRefId);
			result.add(av);
		}

		srv.insert(result);
	}
}
