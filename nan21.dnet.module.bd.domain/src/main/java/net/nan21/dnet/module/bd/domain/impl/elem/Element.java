/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.domain.impl.elem;

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
import net.nan21.dnet.core.domain.impl.AbstractTypeWithCode;
import net.nan21.dnet.module.bd.domain.impl.elem.ElementType;
import net.nan21.dnet.module.bd.domain.impl.elem.Engine;
import org.eclipse.persistence.annotations.CascadeOnDelete;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 
 */
@NamedQueries({
		@NamedQuery(name = Element.NQ_FIND_BY_ENGINE_CODE, query = "SELECT e FROM Element e WHERE e.clientId = :clientId and e.engine = :engine and e.code = :code", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
		@NamedQuery(name = Element.NQ_FIND_BY_ENGINE_CODE_PRIMITIVE, query = "SELECT e FROM Element e WHERE e.clientId = :clientId and e.engine.id = :engineId and e.code = :code", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE))})
@Entity
@Table(name = Element.TABLE_NAME, uniqueConstraints = {@UniqueConstraint(name = Element.TABLE_NAME
		+ "_UK1", columnNames = {"CLIENTID", "ENGINE_ID", "CODE"})})
public class Element extends AbstractTypeWithCode {

	public static final String TABLE_NAME = "BD_ELEM";

	private static final long serialVersionUID = -8865917134914502125L;
	/**
	 * Named query find by unique key: Engine_code.
	 */
	public static final String NQ_FIND_BY_ENGINE_CODE = "Element.findByEngine_code";
	/**
	 * Named query find by unique key: Engine_code using the ID field for references.
	 */
	public static final String NQ_FIND_BY_ENGINE_CODE_PRIMITIVE = "Element.findByEngine_code_PRIMITIVE";

	@Column(name = "ENTITYTYPE", length = 32)
	private String entityType;

	@Column(name = "CALCULATION", length = 32)
	private String calculation;

	@NotBlank
	@Column(name = "DATATYPE", nullable = false, length = 32)
	private String dataType;

	@Column(name = "SEQUENCENO", precision = 4)
	private Integer sequenceNo;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Engine.class)
	@JoinColumn(name = "ENGINE_ID", referencedColumnName = "ID")
	private Engine engine;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = ElementType.class)
	@JoinColumn(name = "TYPE_ID", referencedColumnName = "ID")
	private ElementType type;

	@OneToMany(fetch = FetchType.LAZY, targetEntity = ElementInput.class, mappedBy = "element", cascade = CascadeType.ALL)
	@CascadeOnDelete
	private Collection<ElementInput> variables;

	@OneToMany(fetch = FetchType.LAZY, targetEntity = ElementFormula.class, mappedBy = "element", cascade = CascadeType.ALL)
	@CascadeOnDelete
	private Collection<ElementFormula> formulas;

	public String getEntityType() {
		return this.entityType;
	}

	public void setEntityType(String entityType) {
		this.entityType = entityType;
	}

	public String getCalculation() {
		return this.calculation;
	}

	public void setCalculation(String calculation) {
		this.calculation = calculation;
	}

	public String getDataType() {
		return this.dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public Integer getSequenceNo() {
		return this.sequenceNo;
	}

	public void setSequenceNo(Integer sequenceNo) {
		this.sequenceNo = sequenceNo;
	}

	public Engine getEngine() {
		return this.engine;
	}

	public void setEngine(Engine engine) {
		if (engine != null) {
			this.__validate_client_context__(engine.getClientId());
		}
		this.engine = engine;
	}

	public ElementType getType() {
		return this.type;
	}

	public void setType(ElementType type) {
		if (type != null) {
			this.__validate_client_context__(type.getClientId());
		}
		this.type = type;
	}

	public Collection<ElementInput> getVariables() {
		return this.variables;
	}

	public void setVariables(Collection<ElementInput> variables) {
		this.variables = variables;
	}

	public void addToVariables(ElementInput e) {
		if (this.variables == null) {
			this.variables = new ArrayList<ElementInput>();
		}
		e.setElement(this);
		this.variables.add(e);
	}

	public Collection<ElementFormula> getFormulas() {
		return this.formulas;
	}

	public void setFormulas(Collection<ElementFormula> formulas) {
		this.formulas = formulas;
	}

	public void addToFormulas(ElementFormula e) {
		if (this.formulas == null) {
			this.formulas = new ArrayList<ElementFormula>();
		}
		e.setElement(this);
		this.formulas.add(e);
	}

	@PrePersist
	public void prePersist() {
		super.prePersist();
	}
}
