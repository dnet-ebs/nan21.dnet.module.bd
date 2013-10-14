/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Dnet.ns.bd + "AttributeSubSet_Dc" , {
	extend: "dnet.core.dc.AbstractDc",
	recordModel: Dnet.ns.bd + "AttributeSubSet_Ds"
});

/* ================= FILTER: Filter ================= */


Ext.define(Dnet.ns.bd + "AttributeSubSet_Dc$Filter" , {
	extend: "dnet.core.dc.view.AbstractDcvFilterPropGrid",
	alias: "widget.bd_AttributeSubSet_Dc$Filter",

	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addLov({xtype:"bd_AttributeSets_Lov", name:"attributeSet", dataIndex:"attributeSet", caseRestriction:"uppercase",
				editor:{_fqn_:Dnet.ns.bd + "AttributeSets_Lov" , selectOnFocus:true, caseRestriction:"uppercase",
					retFieldMapping: [{lovField:"id", dsField: "id"} ]}})
			.addTextField({ name:"name", dataIndex:"name"})
			.addBooleanField({ name:"active", dataIndex:"active"})
		;
	}

});

/* ================= EDIT-GRID: CtxEditList ================= */

Ext.define(Dnet.ns.bd + "AttributeSubSet_Dc$CtxEditList" , {
	extend: "dnet.core.dc.view.AbstractDcvEditableGrid",
	alias: "widget.bd_AttributeSubSet_Dc$CtxEditList",

	/**
	 * Columns definition
	 */
	_defineColumns_: function() {
		this._getBuilder_()	
		.addTextColumn({name:"attributeSet", dataIndex:"attributeSet", hidden:true, width:120, caseRestriction:"uppercase", noEdit: true})
		.addNumberColumn({name:"sequenceNo", dataIndex:"sequenceNo", align:"right", width:70, format:"0" })
		.addTextColumn({name:"code", dataIndex:"code", width:120, caseRestriction:"uppercase"})
		.addTextColumn({name:"name", dataIndex:"name", width:200})
		.addBooleanColumn({name:"active", dataIndex:"active"})
		.addTextColumn({name:"description", dataIndex:"description", width:200})
		.addDefaults();
	}
});
