/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Dnet.ns.bd + "City_Dc" , {
	extend: "dnet.core.dc.AbstractDc",
	recordModel: Dnet.ns.bd + "City_Ds"
});

/* ================= FILTER FORM: Filter ================= */			

Ext.define(Dnet.ns.bd + "City_Dc$Filter" , {
	extend: "dnet.core.dc.view.AbstractDcvFilterForm",
	alias: "widget.bd_City_Dc$Filter",

	/**
	 * Components definition
	 */	
	_defineElements_: function() {
		this._getBuilder_()
		
		/* =========== controls =========== */
		.addTextField({ name:"name", dataIndex:"name"})
		.addLov({xtype:"bd_Countries_Lov", name:"country", dataIndex:"country", caseRestriction:"uppercase",
			retFieldMapping: [{lovField:"id", dsField: "countryId"} ]})
		
		/* =========== containers =========== */
		.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
		autoScroll:true, padding:"0 30 5 0"})
		.addPanel({ name:"col1", width:210, layout:"form"})
		.addPanel({ name:"col2", width:210, layout:"form"});
	},

	/**
	 * Combine the components
	 */				
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["col1", "col2"])
		.addChildrenTo("col1", ["name"])
		.addChildrenTo("col2", ["country"]);
	}
});

/* ================= GRID: List ================= */

Ext.define(Dnet.ns.bd + "City_Dc$List" , {
	extend: "dnet.core.dc.view.AbstractDcvGrid",
	alias: "widget.bd_City_Dc$List",

	/**
	 * Columns definition
	 */
	_defineColumns_: function() {
		this._getBuilder_()
		.addTextColumn({ name:"name", dataIndex:"name", width:200})
		.addTextColumn({ name:"description", dataIndex:"description", width:200})
		.addTextColumn({ name:"country", dataIndex:"country", width:120})
		.addTextColumn({ name:"region", dataIndex:"region", width:120})
		.addBooleanColumn({ name:"active", dataIndex:"active"})
		.addTextColumn({ name:"countryId", dataIndex:"countryId", hidden:true, width:100})
		.addTextColumn({ name:"regionId", dataIndex:"regionId", hidden:true, width:100})
		.addDefaults();
	}
});

/* ================= EDIT-GRID: CtxEditList ================= */

Ext.define(Dnet.ns.bd + "City_Dc$CtxEditList" , {
	extend: "dnet.core.dc.view.AbstractDcvEditableGrid",
	alias: "widget.bd_City_Dc$CtxEditList",
	_noImport_: true,
	_noExport_: true,

	/**
	 * Columns definition
	 */
	_defineColumns_: function() {
		this._getBuilder_()	
		.addTextColumn({name:"name", dataIndex:"name", width:200})
		.addTextColumn({name:"description", dataIndex:"description", width:200})
		.addBooleanColumn({name:"active", dataIndex:"active"})
		.addTextColumn({name:"countryId", dataIndex:"countryId", hidden:true, width:100, noEdit: true})
		.addTextColumn({name:"regionId", dataIndex:"regionId", hidden:true, width:100, noEdit: true})
		.addDefaults();
	}
});
