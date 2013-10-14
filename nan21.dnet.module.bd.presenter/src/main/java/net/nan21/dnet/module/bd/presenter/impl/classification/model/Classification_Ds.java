/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.presenter.impl.classification.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.Param;
import net.nan21.dnet.core.api.annotation.RefLookup;
import net.nan21.dnet.core.api.annotation.RefLookups;
import net.nan21.dnet.core.presenter.model.AbstractAuditableDs;
import net.nan21.dnet.module.bd.domain.impl.classification.Classification;
import net.nan21.dnet.module.bd.domain.impl.classification.ClassificationItem;
import net.nan21.dnet.module.bd.domain.impl.classification.ClassificationSystem;

@Ds(entity = Classification.class)
@RefLookups({
		@RefLookup(refId = Classification_Ds.f_systemId, namedQuery = ClassificationSystem.NQ_FIND_BY_CODE, params = {@Param(name = "code", field = Classification_Ds.f_system)}),
		@RefLookup(refId = Classification_Ds.f_itemId, namedQuery = ClassificationItem.NQ_FIND_BY_SYSCODE_PRIMITIVE, params = {
				@Param(name = "classSystemId", field = Classification_Ds.f_systemId),
				@Param(name = "code", field = Classification_Ds.f_item)})})
public class Classification_Ds extends AbstractAuditableDs<Classification> {

	public static final String f_targetRefid = "targetRefid";
	public static final String f_targetAlias = "targetAlias";
	public static final String f_targetType = "targetType";
	public static final String f_systemId = "systemId";
	public static final String f_system = "system";
	public static final String f_systemName = "systemName";
	public static final String f_itemId = "itemId";
	public static final String f_item = "item";
	public static final String f_itemName = "itemName";

	@DsField
	private String targetRefid;

	@DsField
	private String targetAlias;

	@DsField
	private String targetType;

	@DsField(join = "left", path = "classSystem.id")
	private String systemId;

	@DsField(join = "left", path = "classSystem.code")
	private String system;

	@DsField(join = "left", path = "classSystem.name")
	private String systemName;

	@DsField(join = "left", path = "classItem.id")
	private String itemId;

	@DsField(join = "left", path = "classItem.code")
	private String item;

	@DsField(join = "left", path = "classItem.name")
	private String itemName;

	public Classification_Ds() {
		super();
	}

	public Classification_Ds(Classification e) {
		super(e);
	}

	public String getTargetRefid() {
		return this.targetRefid;
	}

	public void setTargetRefid(String targetRefid) {
		this.targetRefid = targetRefid;
	}

	public String getTargetAlias() {
		return this.targetAlias;
	}

	public void setTargetAlias(String targetAlias) {
		this.targetAlias = targetAlias;
	}

	public String getTargetType() {
		return this.targetType;
	}

	public void setTargetType(String targetType) {
		this.targetType = targetType;
	}

	public String getSystemId() {
		return this.systemId;
	}

	public void setSystemId(String systemId) {
		this.systemId = systemId;
	}

	public String getSystem() {
		return this.system;
	}

	public void setSystem(String system) {
		this.system = system;
	}

	public String getSystemName() {
		return this.systemName;
	}

	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}

	public String getItemId() {
		return this.itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getItem() {
		return this.item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getItemName() {
		return this.itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
}
