/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.presenter.impl.attachment.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.Param;
import net.nan21.dnet.core.api.annotation.RefLookup;
import net.nan21.dnet.core.api.annotation.RefLookups;
import net.nan21.dnet.core.presenter.model.AbstractAuditableDs;
import net.nan21.dnet.module.bd.domain.impl.attachment.Attachment;
import net.nan21.dnet.module.bd.domain.impl.attachment.AttachmentType;

@Ds(entity = Attachment.class)
@RefLookups({@RefLookup(refId = Attachment_Ds.f_typeId, namedQuery = AttachmentType.NQ_FIND_BY_NAME, params = {@Param(name = "name", field = Attachment_Ds.f_type)})})
public class Attachment_Ds extends AbstractAuditableDs<Attachment> {

	public static final String f_targetRefid = "targetRefid";
	public static final String f_targetAlias = "targetAlias";
	public static final String f_targetType = "targetType";
	public static final String f_name = "name";
	public static final String f_location = "location";
	public static final String f_url = "url";
	public static final String f_typeId = "typeId";
	public static final String f_type = "type";
	public static final String f_category = "category";
	public static final String f_baseUrl = "baseUrl";

	@DsField
	private String targetRefid;

	@DsField
	private String targetAlias;

	@DsField
	private String targetType;

	@DsField
	private String name;

	@DsField
	private String location;

	@DsField(fetch = false)
	private String url;

	@DsField(join = "left", path = "type.id")
	private String typeId;

	@DsField(join = "left", path = "type.name")
	private String type;

	@DsField(join = "left", path = "type.category")
	private String category;

	@DsField(join = "left", path = "type.baseUrl")
	private String baseUrl;

	public Attachment_Ds() {
		super();
	}

	public Attachment_Ds(Attachment e) {
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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTypeId() {
		return this.typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getBaseUrl() {
		return this.baseUrl;
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}
}
