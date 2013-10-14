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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.QueryHint;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.domain.impl.AbstractAuditable;
import net.nan21.dnet.module.bd.domain.impl.elem.Element;
import net.nan21.dnet.module.bd.domain.impl.elem.ElementSet;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;

/**
 * 
 */
@NamedQueries({
		@NamedQuery(name = ElementSetElement.NQ_FIND_BY_SET_ELEM, query = "SELECT e FROM ElementSetElement e WHERE e.clientId = :clientId and e.elementSet = :elementSet and e.element = :element", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
		@NamedQuery(name = ElementSetElement.NQ_FIND_BY_SET_ELEM_PRIMITIVE, query = "SELECT e FROM ElementSetElement e WHERE e.clientId = :clientId and e.elementSet.id = :elementSetId and e.element.id = :elementId", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE))})
@Entity
@Table(name = ElementSetElement.TABLE_NAME, uniqueConstraints = {@UniqueConstraint(name = ElementSetElement.TABLE_NAME
		+ "_UK1", columnNames = {"CLIENTID", "ELEMENTSET_ID", "ELEMENT_ID"})})
public class ElementSetElement extends AbstractAuditable {

	public static final String TABLE_NAME = "BD_ELEMSET_ELEM";

	private static final long serialVersionUID = -8865917134914502125L;
	/**
	 * Named query find by unique key: Set_elem.
	 */
	public static final String NQ_FIND_BY_SET_ELEM = "ElementSetElement.findBySet_elem";
	/**
	 * Named query find by unique key: Set_elem using the ID field for references.
	 */
	public static final String NQ_FIND_BY_SET_ELEM_PRIMITIVE = "ElementSetElement.findBySet_elem_PRIMITIVE";

	@NotNull
	@Column(name = "SEQUENCENO", nullable = false, precision = 4)
	private Integer sequenceNo;

	@Column(name = "PRINTLABEL", length = 255)
	private String printLabel;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = ElementSet.class)
	@JoinColumn(name = "ELEMENTSET_ID", referencedColumnName = "ID")
	private ElementSet elementSet;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Element.class)
	@JoinColumn(name = "ELEMENT_ID", referencedColumnName = "ID")
	private Element element;

	public Integer getSequenceNo() {
		return this.sequenceNo;
	}

	public void setSequenceNo(Integer sequenceNo) {
		this.sequenceNo = sequenceNo;
	}

	public String getPrintLabel() {
		return this.printLabel;
	}

	public void setPrintLabel(String printLabel) {
		this.printLabel = printLabel;
	}

	public ElementSet getElementSet() {
		return this.elementSet;
	}

	public void setElementSet(ElementSet elementSet) {
		if (elementSet != null) {
			this.__validate_client_context__(elementSet.getClientId());
		}
		this.elementSet = elementSet;
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
	}
}
