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
import net.nan21.dnet.core.domain.impl.AbstractTypeWithCode;
import net.nan21.dnet.module.bd.domain.impl.attr.AttributeCategory;
import net.nan21.dnet.module.bd.domain.impl.uom.Uom;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.hibernate.validator.constraints.NotBlank;

/** 
 * Attribute definition. 
 * An attribute is a reusable descriptor identified by a data-type and an optional list of possible values.
 * Attributes are grouped in attribute-groups which can be attached to business objects.	 
 */
@NamedQueries({@NamedQuery(name = Attribute.NQ_FIND_BY_CODE, query = "SELECT e FROM Attribute e WHERE e.clientId = :clientId and e.code = :code", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE))})
@Entity
@Table(name = Attribute.TABLE_NAME, uniqueConstraints = {@UniqueConstraint(name = Attribute.TABLE_NAME
		+ "_UK1", columnNames = {"CLIENTID", "CODE"})})
public class Attribute extends AbstractTypeWithCode {

	public static final String TABLE_NAME = "BD_ATTR";

	private static final long serialVersionUID = -8865917134914502125L;
	/**
	 * Named query find by unique key: Code.
	 */
	public static final String NQ_FIND_BY_CODE = "Attribute.findByCode";

	@NotBlank
	@Column(name = "DATATYPE", nullable = false, length = 32)
	private String dataType;

	@Column(name = "LISTOFVALUES", length = 400)
	private String listOfvalues;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = AttributeCategory.class)
	@JoinColumn(name = "CATEGORY_ID", referencedColumnName = "ID")
	private AttributeCategory category;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Uom.class)
	@JoinColumn(name = "UOM_ID", referencedColumnName = "ID")
	private Uom uom;

	public String getDataType() {
		return this.dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public String getListOfvalues() {
		return this.listOfvalues;
	}

	public void setListOfvalues(String listOfvalues) {
		this.listOfvalues = listOfvalues;
	}

	public AttributeCategory getCategory() {
		return this.category;
	}

	public void setCategory(AttributeCategory category) {
		if (category != null) {
			this.__validate_client_context__(category.getClientId());
		}
		this.category = category;
	}

	public Uom getUom() {
		return this.uom;
	}

	public void setUom(Uom uom) {
		if (uom != null) {
			this.__validate_client_context__(uom.getClientId());
		}
		this.uom = uom;
	}

	@PrePersist
	public void prePersist() {
		super.prePersist();
	}
}
