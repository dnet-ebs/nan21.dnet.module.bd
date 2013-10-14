/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.domain.impl.elem;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.domain.impl.AbstractAuditable;
import net.nan21.dnet.module.bd.domain.impl.elem.Element;

/**
 * 
 */
@Entity
@Table(name = ElementFormula.TABLE_NAME)
public class ElementFormula extends AbstractAuditable {

	public static final String TABLE_NAME = "BD_ELEM_FORMULA";

	private static final long serialVersionUID = -8865917134914502125L;

	@NotNull
	@Temporal(TemporalType.DATE)
	@Column(name = "VALIDFROM", nullable = false)
	private Date validFrom;

	@Temporal(TemporalType.DATE)
	@Column(name = "VALIDTO")
	private Date validTo;

	@NotNull
	@Column(name = "STATICVALUE", nullable = false)
	private Boolean staticValue;

	@Column(name = "EXPRESSION", length = 4000)
	private String expression;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Element.class)
	@JoinColumn(name = "ELEMENT_ID", referencedColumnName = "ID")
	private Element element;

	public Date getValidFrom() {
		return this.validFrom;
	}

	public void setValidFrom(Date validFrom) {
		this.validFrom = validFrom;
	}

	public Date getValidTo() {
		return this.validTo;
	}

	public void setValidTo(Date validTo) {
		this.validTo = validTo;
	}

	public Boolean getStaticValue() {
		return this.staticValue;
	}

	public void setStaticValue(Boolean staticValue) {
		this.staticValue = staticValue;
	}

	public String getExpression() {
		return this.expression;
	}

	public void setExpression(String expression) {
		this.expression = expression;
	}

	public Element getElement() {
		return this.element;
	}

	public void setElement(Element element) {
		if (element != null) {
			this.__validate_client_context__(element.getClientId());
		}
		this.element = element;
	}

	@PrePersist
	public void prePersist() {
		super.prePersist();
		if (this.staticValue == null) {
			this.staticValue = new Boolean(false);
		}
	}
}
