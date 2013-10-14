/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.domain.impl.elem;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import net.nan21.dnet.core.domain.impl.AbstractAuditable;
import net.nan21.dnet.module.bd.domain.impl.elem.Element;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 
 */
@Entity
@Table(name = ElementInput.TABLE_NAME)
public class ElementInput extends AbstractAuditable {

	public static final String TABLE_NAME = "BD_ELEM_IN";

	private static final long serialVersionUID = -8865917134914502125L;

	@NotBlank
	@Column(name = "ALIAS", nullable = false, length = 32)
	private String alias;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Element.class)
	@JoinColumn(name = "ELEMENT_ID", referencedColumnName = "ID")
	private Element element;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Element.class)
	@JoinColumn(name = "CROSSREFERENCE_ID", referencedColumnName = "ID")
	private Element crossReference;

	public String getAlias() {
		return this.alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
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

	public Element getCrossReference() {
		return this.crossReference;
	}

	public void setCrossReference(Element crossReference) {
		if (crossReference != null) {
			this.__validate_client_context__(crossReference.getClientId());
		}
		this.crossReference = crossReference;
	}

	@PrePersist
	public void prePersist() {
		super.prePersist();
	}
}
