/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Dnet.ns.bd + "Region_Dc" , {
	extend: "dnet.core.dc.AbstractDc",
	recordModel: Dnet.ns.bd + "Region_Ds"
});

/* ================= FILTER FORM: Filter ================= */			

Ext.define(Dnet.ns.bd + "Region_Dc$Filter" , {
	extend: "dnet.core.dc.view.AbstractDcvFilterForm",
	alias: "widget.bd_Region_Dc$Filter",

	/**
	 * Components definition
	 */	
	_defineElements_: function() {
		this._getBuilder_()
		
		/* =========== controls =========== */
		.addLov({name:"country", dataIndex:"country", xtype:"bd_Countries_Lov", caseRestriction:"uppercase",
			retFieldMapping: [{lovField:"id", dsField: "countryId"} ]})
		.addLov({name:"code", dataIndex:"code", xtype:"bd_Regions_Lov", caseRestriction:"uppercase",
			retFieldMapping: [{lovField:"id", dsField: "id"} ]})
		.addTextField({ name:"name", dataIndex:"name"})
		.addTextField({ name:"iso", dataIndex:"iso", maxLength:32, caseRestriction:"uppercase"})
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
		.addChildrenTo("col1", ["code", "name"])
		.addChildrenTo("col2", ["country"])
		.addChildrenTo("col3", ["iso", "active"]);
	}
});

/* ================= GRID: List ================= */

Ext.define(Dnet.ns.bd + "Region_Dc$List" , {
	extend: "dnet.core.dc.view.AbstractDcvGrid",
	alias: "widget.bd_Region_Dc$List",

	/**
	 * Columns definition
	 */
	_defineColumns_: function() {
		this._getBuilder_()
		.addTextColumn({ name:"code", dataIndex:"code", width:120})
		.addTextColumn({ name:"name", dataIndex:"name", width:200})
		.addTextColumn({ name:"iso", dataIndex:"iso", width:50})
		.addTextColumn({ name:"country", dataIndex:"country", width:120})
		.addBooleanColumn({ name:"active", dataIndex:"active"})
		.addTextColumn({ name:"countryId", dataIndex:"countryId", hidden:true, width:100})
		.addDefaults();
	}
});

/* ================= EDIT-GRID: EditListContext ================= */

Ext.define(Dnet.ns.bd + "Region_Dc$EditListContext" , {
	extend: "dnet.core.dc.view.AbstractDcvEditableGrid",
	alias: "widget.bd_Region_Dc$EditListContext",
	_noImport_: true,
	_noExport_: true,
	_bulkEditFields_: ["active"],

	/**
	 * Columns definition
	 */
	_defineColumns_: function() {
		this._getBuilder_()	
		.addTextColumn({name:"code", dataIndex:"code", width:120, caseRestriction:"uppercase"})
		.addTextColumn({name:"name", dataIndex:"name", width:200})
		.addTextColumn({name:"iso", dataIndex:"iso", width:50, maxLength:32, caseRestriction:"uppercase"})
		.addBooleanColumn({name:"active", dataIndex:"active"})
		.addTextColumn({name:"countryId", dataIndex:"countryId", hidden:true, width:100, noEdit: true})
		.addDefaults();
	}
});

/* ================= EDIT-GRID: EditList ================= */

Ext.define(Dnet.ns.bd + "Region_Dc$EditList" , {
	extend: "dnet.core.dc.view.AbstractDcvEditableGrid",
	alias: "widget.bd_Region_Dc$EditList",
	_bulkEditFields_: ["country","active"],

	/**
	 * Columns definition
	 */
	_defineColumns_: function() {
		this._getBuilder_()	
		.addTextColumn({name:"code", dataIndex:"code", width:120, caseRestriction:"uppercase"})
		.addTextColumn({name:"name", dataIndex:"name", width:200})
		.addTextColumn({name:"iso", dataIndex:"iso", width:50, maxLength:32, caseRestriction:"uppercase"})
		.addLov({name:"country", dataIndex:"country", xtype:"gridcolumn", width:120, 
			editor:{xtype:"bd_Countries_Lov", selectOnFocus:true, caseRestriction:"uppercase",
				retFieldMapping: [{lovField:"id", dsField: "countryId"} ],
				filterFieldMapping: [{lovField:"active", value: "true"} ]}})
		.addBooleanColumn({name:"active", dataIndex:"active"})
		.addTextColumn({name:"countryId", dataIndex:"countryId", hidden:true, width:100, noEdit: true})
		.addDefaults();
	}
});

/* ================= EDIT FORM: Edit ================= */

Ext.define(Dnet.ns.bd + "Region_Dc$Edit" , {
	extend: "dnet.core.dc.view.AbstractDcvEditForm",
	alias: "widget.bd_Region_Dc$Edit",

	/**
	 * Components definition
	 */
	_defineElements_: function() {
		this._getBuilder_()
		
		/* =========== controls =========== */
		.addTextField({ name:"name", dataIndex:"name", allowBlank:false})
		.addTextField({ name:"code", dataIndex:"code", allowBlank:false, caseRestriction:"uppercase"})
		.addTextArea({ name:"notes", dataIndex:"notes", height:60})
		.addTextField({ name:"iso", dataIndex:"iso", maxLength:32, caseRestriction:"uppercase"})
		.addBooleanField({ name:"active", dataIndex:"active"})
		.addLov({name:"country", dataIndex:"country", allowBlank:false, xtype:"bd_Countries_Lov", caseRestriction:"uppercase",
			retFieldMapping: [{lovField:"id", dsField: "countryId"} ]})
		
		/* =========== containers =========== */
		.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
		autoScroll:true, padding:"0 30 5 0"})
		.addPanel({ name:"col1", width:300, layout:"form"})
		.addPanel({ name:"col2", width:250, layout:"form"})
		.addPanel({ name:"col3", width:300, layout:"form"});
	},

	/**
	 * Combine the components
	 */			
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["col1", "col2", "col3"])
		.addChildrenTo("col1", ["name", "code"])
		.addChildrenTo("col2", ["country", "iso", "active"])
		.addChildrenTo("col3", ["notes"]);
	}
});
