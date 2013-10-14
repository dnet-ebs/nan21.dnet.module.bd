/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.domain.impl.attr;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.QueryHint;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import net.nan21.dnet.core.domain.impl.AbstractAuditable;
import net.nan21.dnet.module.bd.domain.impl.attr.AttributeSetAttribute;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.hibernate.validator.constraints.NotBlank;

/**
 *  Attribute values. Attributes are loosely coupled to entities with refid.
 */
@NamedQueries({
		@NamedQuery(name = AttributeValue.NQ_FIND_BY_ATTR, query = "SELECT e FROM AttributeValue e WHERE e.clientId = :clientId and e.targetRefid = :targetRefid and e.setAttribute = :setAttribute", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
		@NamedQuery(name = AttributeValue.NQ_FIND_BY_ATTR_PRIMITIVE, query = "SELECT e FROM AttributeValue e WHERE e.clientId = :clientId and e.targetRefid = :targetRefid and e.setAttribute.id = :setAttributeId", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE))})
@Entity
@Table(name = AttributeValue.TABLE_NAME, uniqueConstraints = {@UniqueConstraint(name = AttributeValue.TABLE_NAME
		+ "_UK1", columnNames = {"CLIENTID", "TARGETREFID", "SETATTRIBUTE_ID"})})
public class AttributeValue extends AbstractAuditable {

	public static final String TABLE_NAME = "BD_ATTR_VAL";

	private static final long serialVersionUID = -8865917134914502125L;
	/**
	 * Named query find by unique key: Attr.
	 */
	public static final String NQ_FIND_BY_ATTR = "AttributeValue.findByAttr";
	/**
	 * Named query find by unique key: Attr using the ID field for references.
	 */
	public static final String NQ_FIND_BY_ATTR_PRIMITIVE = "AttributeValue.findByAttr_PRIMITIVE";

	@Column(name = "VALUE", length = 400)
	private String value;

	/** Reference used to link bank accounts to different entity types. */
	@NotBlank
	@Column(name = "TARGETREFID", nullable = false, length = 64)
	private String targetRefid;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = AttributeSetAttribute.class)
	@JoinColumn(name = "SETATTRIBUTE_ID", referencedColumnName = "ID")
	private AttributeSetAttribute setAttribute;

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getTargetRefid() {
		return this.targetRefid;
	}

	public void setTargetRefid(String targetRefid) {
		this.targetRefid = targetRefid;
	}

	public AttributeSetAttribute getSetAttribute() {
		return this.setAttribute;
	}

	public void setSetAttribute(AttributeSetAttribute setAttribute) {
		if (setAttribute != null) {
			this.__validate_client_context__(setAttribute.getClientId());
		}
		this.setAttribute = setAttribute;
	}

	@PrePersist
	public void prePersist() {
		super.prePersist();
	}
}
