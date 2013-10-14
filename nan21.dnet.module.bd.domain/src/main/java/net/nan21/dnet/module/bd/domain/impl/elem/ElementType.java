/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.domain.impl.elem;

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
import net.nan21.dnet.core.domain.impl.AbstractType;
import net.nan21.dnet.module.bd.domain.impl.elem.ElementCategory;
import net.nan21.dnet.module.bd.domain.impl.elem.Engine;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;

/**
 * 
 */
@NamedQueries({
		@NamedQuery(name = ElementType.NQ_FIND_BY_ENGINE_NAME, query = "SELECT e FROM ElementType e WHERE e.clientId = :clientId and e.engine = :engine and e.name = :name", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
		@NamedQuery(name = ElementType.NQ_FIND_BY_ENGINE_NAME_PRIMITIVE, query = "SELECT e FROM ElementType e WHERE e.clientId = :clientId and e.engine.id = :engineId and e.name = :name", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE))})
@Entity
@Table(name = ElementType.TABLE_NAME, uniqueConstraints = {@UniqueConstraint(name = ElementType.TABLE_NAME
		+ "_UK1", columnNames = {"CLIENTID", "ENGINE_ID", "NAME"})})
public class ElementType extends AbstractType {

	public static final String TABLE_NAME = "BD_ELEM_TYPE";

	private static final long serialVersionUID = -8865917134914502125L;
	/**
	 * Named query find by unique key: Engine_name.
	 */
	public static final String NQ_FIND_BY_ENGINE_NAME = "ElementType.findByEngine_name";
	/**
	 * Named query find by unique key: Engine_name using the ID field for references.
	 */
	public static final String NQ_FIND_BY_ENGINE_NAME_PRIMITIVE = "ElementType.findByEngine_name_PRIMITIVE";

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Engine.class)
	@JoinColumn(name = "ENGINE_ID", referencedColumnName = "ID")
	private Engine engine;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = ElementCategory.class)
	@JoinColumn(name = "CATEGORY_ID", referencedColumnName = "ID")
	private ElementCategory category;

	public Engine getEngine() {
		return this.engine;
	}

	public void setEngine(Engine engine) {
		if (engine != null) {
			this.__validate_client_context__(engine.getClientId());
		}
		this.engine = engine;
	}

	public ElementCategory getCategory() {
		return this.category;
	}

	public void setCategory(ElementCategory category) {
		if (category != null) {
			this.__validate_client_context__(category.getClientId());
		}
		this.category = category;
	}

	@PrePersist
	public void prePersist() {
		super.prePersist();
	}
}
