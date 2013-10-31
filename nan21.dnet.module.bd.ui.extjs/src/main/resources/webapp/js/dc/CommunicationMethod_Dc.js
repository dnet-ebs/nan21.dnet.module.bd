/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Dnet.ns.bd + "CommunicationMethod_Dc" , {
	extend: "dnet.core.dc.AbstractDc",
	recordModel: Dnet.ns.bd + "CommunicationMethod_Ds"
});

/* ================= FILTER FORM: Filter ================= */			

Ext.define(Dnet.ns.bd + "CommunicationMethod_Dc$Filter" , {
	extend: "dnet.core.dc.view.AbstractDcvFilterForm",
	alias: "widget.bd_CommunicationMethod_Dc$Filter",

	/**
	 * Components definition
	 */	
	_defineElements_: function() {
		this._getBuilder_()
		
		/* =========== controls =========== */
		.addLov({name:"type", dataIndex:"type", xtype:"bd_CommunicationMethodTypes_Lov",
			retFieldMapping: [{lovField:"id", dsField: "typeId"} ]})
		.addTextField({ name:"value", dataIndex:"value"})
		.addTextField({ name:"targetAlias", dataIndex:"targetAlias"})
		.addTextField({ name:"targetType", dataIndex:"targetType"})
		.addBooleanField({ name:"active", dataIndex:"active"})
		
		/* =========== containers =========== */
		.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
		autoScroll:true, padding:"0 30 5 0"})
		.addPanel({ name:"col1", width:250, layout:"form"})
		.addPanel({ name:"col2", width:250, layout:"form"})
		.addPanel({ name:"col3", width:170, layout:"form"});
	},

	/**
	 * Combine the components
	 */				
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["col1", "col2", "col3"])
		.addChildrenTo("col1", ["type", "value"])
		.addChildrenTo("col2", ["targetAlias", "targetType"])
		.addChildrenTo("col3", ["active"]);
	}
});

/* ================= GRID: List ================= */

Ext.define(Dnet.ns.bd + "CommunicationMethod_Dc$List" , {
	extend: "dnet.core.dc.view.AbstractDcvGrid",
	alias: "widget.bd_CommunicationMethod_Dc$List",
	_noImport_: true,

	/**
	 * Columns definition
	 */
	_defineColumns_: function() {
		this._getBuilder_()
		.addTextColumn({ name:"type", dataIndex:"type", width:200})
		.addTextColumn({ name:"value", dataIndex:"value", width:200})
		.addDateColumn({ name:"validFrom", dataIndex:"validFrom", _mask_: Masks.DATE})
		.addDateColumn({ name:"validTo", dataIndex:"validTo", _mask_: Masks.DATE})
		.addTextColumn({ name:"notes", dataIndex:"notes", width:200})
		.addTextColumn({ name:"targetRefid", dataIndex:"targetRefid", hidden:true, width:100})
		.addTextColumn({ name:"targetAlias", dataIndex:"targetAlias", hidden:true, width:100})
		.addTextColumn({ name:"targetType", dataIndex:"targetType", hidden:true, width:200})
		.addDefaults();
	}
});

/* ================= EDIT-GRID: EditList ================= */

Ext.define(Dnet.ns.bd + "CommunicationMethod_Dc$EditList" , {
	extend: "dnet.core.dc.view.AbstractDcvEditableGrid",
	alias: "widget.bd_CommunicationMethod_Dc$EditList",
	_noImport_: true,

	/**
	 * Columns definition
	 */
	_defineColumns_: function() {
		this._getBuilder_()	
		.addLov({name:"type", dataIndex:"type", xtype:"gridcolumn", width:200, 
			editor:{xtype:"bd_CommunicationMethodTypes_Lov", selectOnFocus:true,
				retFieldMapping: [{lovField:"id", dsField: "typeId"} ],
				filterFieldMapping: [{lovField:"targetAlias", dsField: "targetAlias"}, {lovField:"targetType", dsField: "targetType"} ]}})
		.addTextColumn({name:"value", dataIndex:"value", width:200})
		.addDateColumn({name:"validFrom", dataIndex:"validFrom", _mask_: Masks.DATE })
		.addDateColumn({name:"validTo", dataIndex:"validTo", _mask_: Masks.DATE })
		.addTextColumn({name:"notes", dataIndex:"notes", width:200})
		.addTextColumn({name:"targetRefid", dataIndex:"targetRefid", hidden:true, width:100, noEdit: true})
		.addTextColumn({name:"targetAlias", dataIndex:"targetAlias", hidden:true, width:100, noEdit: true})
		.addTextColumn({name:"targetType", dataIndex:"targetType", hidden:true, width:200, noEdit: true})
		.addDefaults();
	}
});
