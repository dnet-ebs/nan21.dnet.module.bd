/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Dnet.ns.bd + "TargetRule_Dc" , {
	extend: "dnet.core.dc.AbstractDc",
	recordModel: Dnet.ns.bd + "TargetRule_Ds"
});

/* ================= EDIT-GRID: EditList ================= */

Ext.define(Dnet.ns.bd + "TargetRule_Dc$EditList" , {
	extend: "dnet.core.dc.view.AbstractDcvEditableGrid",
	alias: "widget.bd_TargetRule_Dc$EditList",

	/**
	 * Columns definition
	 */
	_defineColumns_: function() {
		this._getBuilder_()	
		.addTextColumn({name:"targetAlias", dataIndex:"targetAlias", width:200})
		.addTextColumn({name:"targetType", dataIndex:"targetType", width:200})
		.addTextColumn({name:"sourceRefId", dataIndex:"sourceRefId", hidden:true, width:100, noEdit: true})
		.addDefaults();
	}
});
