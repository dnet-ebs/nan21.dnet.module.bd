/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Dnet.ns.bd + "Location_Dc" , {
	extend: "dnet.core.dc.AbstractDc",
	recordModel: Dnet.ns.bd + "Location_Ds"
});

/* ================= FILTER FORM: Filter ================= */			

Ext.define(Dnet.ns.bd + "Location_Dc$Filter" , {
	extend: "dnet.core.dc.view.AbstractDcvFilterForm",
	alias: "widget.bd_Location_Dc$Filter",

	/**
	 * Components definition
	 */	
	_defineElements_: function() {
		this._getBuilder_()
		
		/* =========== controls =========== */
		.addLov({name:"country", dataIndex:"country", xtype:"bd_Countries_Lov", caseRestriction:"uppercase",
			retFieldMapping: [{lovField:"id", dsField: "countryId"} ]})
		.addLov({name:"region", dataIndex:"region", xtype:"bd_Regions_Lov", caseRestriction:"uppercase",
			retFieldMapping: [{lovField:"id", dsField: "regionId"} ],
			filterFieldMapping: [{lovField:"countryId", dsField: "countryId"} ]})
		.addTextField({ name:"cityName", dataIndex:"cityName"})
		.addBooleanField({ name:"billing", dataIndex:"billing"})
		.addBooleanField({ name:"mailing", dataIndex:"mailing"})
		.addBooleanField({ name:"shipping", dataIndex:"shipping"})
		.addBooleanField({ name:"active", dataIndex:"active"})
		
		/* =========== containers =========== */
		.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
		autoScroll:true, padding:"0 30 5 0"})
		.addPanel({ name:"col1", width:250, layout:"form"})
		.addPanel({ name:"col2", width:170, layout:"form"})
		.addPanel({ name:"col3", width:170, layout:"form"});
	},

	/**
	 * Combine the components
	 */				
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["col1", "col2", "col3"])
		.addChildrenTo("col1", ["country", "region", "cityName"])
		.addChildrenTo("col2", ["billing", "mailing"])
		.addChildrenTo("col3", ["shipping", "active"]);
	}
});

/* ================= GRID: List ================= */

Ext.define(Dnet.ns.bd + "Location_Dc$List" , {
	extend: "dnet.core.dc.view.AbstractDcvGrid",
	alias: "widget.bd_Location_Dc$List",
	_noImport_: true,

	/**
	 * Columns definition
	 */
	_defineColumns_: function() {
		this._getBuilder_()
		.addTextColumn({ name:"country", dataIndex:"country", width:120})
		.addTextColumn({ name:"countryId", dataIndex:"countryId", hidden:true, width:100})
		.addTextColumn({ name:"countryIso2", dataIndex:"countryIso2", hidden:true, width:50})
		.addTextColumn({ name:"region", dataIndex:"region", width:120})
		.addTextColumn({ name:"regionId", dataIndex:"regionId", hidden:true, width:100})
		.addTextColumn({ name:"cityName", dataIndex:"cityName", width:120})
		.addTextColumn({ name:"adress", dataIndex:"adress", width:200})
		.addTextColumn({ name:"zip", dataIndex:"zip", width:100})
		.addTextColumn({ name:"notes", dataIndex:"notes", hidden:true, width:200})
		.addBooleanColumn({ name:"billing", dataIndex:"billing", width:60})
		.addBooleanColumn({ name:"mailing", dataIndex:"mailing", width:60})
		.addBooleanColumn({ name:"shipping", dataIndex:"shipping", width:60})
		.addBooleanColumn({ name:"active", dataIndex:"active", width:60})
		.addTextColumn({ name:"targetRefid", dataIndex:"targetRefid", hidden:true, width:100})
		.addDefaults();
	}
});

/* ================= EDIT FORM: Edit ================= */

Ext.define(Dnet.ns.bd + "Location_Dc$Edit" , {
	extend: "dnet.core.dc.view.AbstractDcvEditForm",
	alias: "widget.bd_Location_Dc$Edit",

	/**
	 * Components definition
	 */
	_defineElements_: function() {
		this._getBuilder_()
		
		/* =========== controls =========== */
		.addLov({name:"country", dataIndex:"country", allowBlank:false, xtype:"bd_Countries_Lov", caseRestriction:"uppercase",
			retFieldMapping: [{lovField:"id", dsField: "countryId"} ],
			filterFieldMapping: [{lovField:"active", value: "true"} ]})
		.addLov({name:"region", dataIndex:"region", xtype:"bd_Regions_Lov", caseRestriction:"uppercase",
			retFieldMapping: [{lovField:"id", dsField: "regionId"} ],
			filterFieldMapping: [{lovField:"countryId", dsField: "countryId"} ]})
		.addTextField({ name:"cityName", dataIndex:"cityName"})
		.addTextField({ name:"zip", dataIndex:"zip", maxLength:32})
		.addTextArea({ name:"adress", dataIndex:"adress", allowBlank:false, height:60})
		.addTextArea({ name:"notes", dataIndex:"notes", height:60})
		.addBooleanField({ name:"billing", dataIndex:"billing"})
		.addBooleanField({ name:"mailing", dataIndex:"mailing"})
		.addBooleanField({ name:"shipping", dataIndex:"shipping"})
		.addBooleanField({ name:"active", dataIndex:"active"})
		
		/* =========== containers =========== */
		.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
		autoScroll:true, padding:"0 30 5 0"})
		.addPanel({ name:"col1", width:250, layout:"form"})
		.addPanel({ name:"col2", width:350, layout:"form"})
		.addPanel({ name:"col3", width:200, layout:"form"});
	},

	/**
	 * Combine the components
	 */			
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["col1", "col2", "col3"])
		.addChildrenTo("col1", ["country", "region", "cityName", "zip"])
		.addChildrenTo("col2", ["adress", "notes"])
		.addChildrenTo("col3", ["billing", "mailing", "shipping", "active"]);
	}
});
