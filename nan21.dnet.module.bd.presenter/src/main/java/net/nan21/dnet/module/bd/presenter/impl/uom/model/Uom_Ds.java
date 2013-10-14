/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.presenter.impl.uom.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.Param;
import net.nan21.dnet.core.api.annotation.RefLookup;
import net.nan21.dnet.core.api.annotation.RefLookups;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.AbstractTypeWithCodeDs;
import net.nan21.dnet.module.bd.domain.impl.uom.Uom;
import net.nan21.dnet.module.bd.domain.impl.uom.UomType;

@Ds(entity = Uom.class, sort = {@SortField(field = Uom_Ds.f_code)})
@RefLookups({@RefLookup(refId = Uom_Ds.f_typeId, namedQuery = UomType.NQ_FIND_BY_CODE, params = {@Param(name = "code", field = Uom_Ds.f_type)})})
public class Uom_Ds extends AbstractTypeWithCodeDs<Uom> {

	public static final String f_typeId = "typeId";
	public static final String f_type = "type";

	@DsField(join = "left", path = "type.id")
	private String typeId;

	@DsField(join = "left", path = "type.code")
	private String type;

	public Uom_Ds() {
		super();
	}

	public Uom_Ds(Uom e) {
		super(e);
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
}
