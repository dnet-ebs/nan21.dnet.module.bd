/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.domain.impl.attr;

import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.QueryHint;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.domain.impl.AbstractAuditable;
import net.nan21.dnet.module.bd.domain.impl.attr.Attribute;
import net.nan21.dnet.module.bd.domain.impl.attr.AttributeSet;
import net.nan21.dnet.module.bd.domain.impl.attr.AttributeSubSet;
import org.eclipse.persistence.annotations.CascadeOnDelete;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;

/** 
 * Attributes which belong to an attribute group and define group specific information.
 */
@NamedQueries({
		@NamedQuery(name = AttributeSetAttribute.NQ_FIND_BY_NAME, query = "SELECT e FROM AttributeSetAttribute e WHERE e.clientId = :clientId and e.attributeSet = :attributeSet and e.attribute = :attribute", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
		@NamedQuery(name = AttributeSetAttribute.NQ_FIND_BY_NAME_PRIMITIVE, query = "SELECT e FROM AttributeSetAttribute e WHERE e.clientId = :clientId and e.attributeSet.id = :attributeSetId and e.attribute.id = :attributeId", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE))})
@Entity
@Table(name = AttributeSetAttribute.TABLE_NAME, uniqueConstraints = {@UniqueConstraint(name = AttributeSetAttribute.TABLE_NAME
		+ "_UK1", columnNames = {"CLIENTID", "ATTRIBUTESET_ID", "ATTRIBUTE_ID"})})
public class AttributeSetAttribute extends AbstractAuditable {

	public static final String TABLE_NAME = "BD_ATTRSET_ATTR";

	private static final long serialVersionUID = -8865917134914502125L;
	/**
	 * Named query find by unique key: Name.
	 */
	public static final String NQ_FIND_BY_NAME = "AttributeSetAttribute.findByName";
	/**
	 * Named query find by unique key: Name using the ID field for references.
	 */
	public static final String NQ_FIND_BY_NAME_PRIMITIVE = "AttributeSetAttribute.findByName_PRIMITIVE";

	@Column(name = "SEQUENCENO", precision = 10)
	private Integer sequenceNo;

	@NotNull
	@Column(name = "INDESCRIPTION", nullable = false)
	private Boolean inDescription;

	@Column(name = "LISTOFVALUES", length = 400)
	private String listOfvalues;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Attribute.class)
	@JoinColumn(name = "ATTRIBUTE_ID", referencedColumnName = "ID")
	private Attribute attribute;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = AttributeSet.class)
	@JoinColumn(name = "ATTRIBUTESET_ID", referencedColumnName = "ID")
	private AttributeSet attributeSet;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = AttributeSubSet.class)
	@JoinColumn(name = "ATTRIBUTESUBSET_ID", referencedColumnName = "ID")
	private AttributeSubSet attributeSubSet;

	@OneToMany(fetch = FetchType.LAZY, targetEntity = AttributeValue.class, mappedBy = "setAttribute", cascade = CascadeType.REMOVE)
	@CascadeOnDelete
	private Collection<AttributeValue> values;

	public Integer getSequenceNo() {
		return this.sequenceNo;
	}

	public void setSequenceNo(Integer sequenceNo) {
		this.sequenceNo = sequenceNo;
	}

	public Boolean getInDescription() {
		return this.inDescription;
	}

	public void setInDescription(Boolean inDescription) {
		this.inDescription = inDescription;
	}

	public String getListOfvalues() {
		return this.listOfvalues;
	}

	public void setListOfvalues(String listOfvalues) {
		this.listOfvalues = listOfvalues;
	}

	public Attribute getAttribute() {
		return this.attribute;
	}

	public void setAttribute(Attribute attribute) {
		if (attribute != null) {
			this.__validate_client_context__(attribute.getClientId());
		}
		this.attribute = attribute;
	}

	public AttributeSet getAttributeSet() {
		return this.attributeSet;
	}

	public void setAttributeSet(AttributeSet attributeSet) {
		if (attributeSet != null) {
			this.__validate_client_context__(attributeSet.getClientId());
		}
		this.attributeSet = attributeSet;
	}

	public AttributeSubSet getAttributeSubSet() {
		return this.attributeSubSet;
	}

	public void setAttributeSubSet(AttributeSubSet attributeSubSet) {
		if (attributeSubSet != null) {
			this.__validate_client_context__(attributeSubSet.getClientId());
		}
		this.attributeSubSet = attributeSubSet;
	}

	public Collection<AttributeValue> getValues() {
		return this.values;
	}

	public void setValues(Collection<AttributeValue> values) {
		this.values = values;
	}

	public void addToValues(AttributeValue e) {
		if (this.values == null) {
			this.values = new ArrayList<AttributeValue>();
		}
		e.setSetAttribute(this);
		this.values.add(e);
	}

	@PrePersist
	public void prePersist() {
		super.prePersist();
		if (this.inDescription == null) {
			this.inDescription = new Boolean(false);
		}
	}
}
