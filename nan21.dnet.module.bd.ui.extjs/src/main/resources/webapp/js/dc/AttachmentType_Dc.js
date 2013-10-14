/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Dnet.ns.bd + "AttachmentType_Dc" , {
	extend: "dnet.core.dc.AbstractDc",
	recordModel: Dnet.ns.bd + "AttachmentType_Ds"
});

/* ================= FILTER FORM: Filter ================= */			

Ext.define(Dnet.ns.bd + "AttachmentType_Dc$Filter" , {
	extend: "dnet.core.dc.view.AbstractDcvFilterForm",
	alias: "widget.bd_AttachmentType_Dc$Filter",

	/**
	 * Components definition
	 */	
	_defineElements_: function() {
		this._getBuilder_()
		
		/* =========== controls =========== */
		.addTextField({ name:"name", dataIndex:"name"})
		.addBooleanField({ name:"active", dataIndex:"active"})
		.addCombo({ xtype:"combo", name:"category", dataIndex:"category", store:[ "image", "document"]})
		
		/* =========== containers =========== */
		.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
		autoScroll:true, padding:"0 30 5 0"})
		.addPanel({ name:"col1", width:210, layout:"form"})
		.addPanel({ name:"col2", width:170, layout:"form"});
	},

	/**
	 * Combine the components
	 */				
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["col1", "col2"])
		.addChildrenTo("col1", ["name", "category"])
		.addChildrenTo("col2", ["active"]);
	}
});

/* ================= EDIT-GRID: EditList ================= */

Ext.define(Dnet.ns.bd + "AttachmentType_Dc$EditList" , {
	extend: "dnet.core.dc.view.AbstractDcvEditableGrid",
	alias: "widget.bd_AttachmentType_Dc$EditList",
	_bulkEditFields_: ["active","description","category","uploadPath","baseUrl"],

	/**
	 * Columns definition
	 */
	_defineColumns_: function() {
		this._getBuilder_()	
		.addTextColumn({name:"name", dataIndex:"name", width:200})
		.addTextColumn({name:"description", dataIndex:"description", width:200})
		.addComboColumn({name:"category", dataIndex:"category", width:80, 
			editor:{xtype:"combo", mode: 'local', selectOnFocus:true, triggerAction:'all', forceSelection:true, store:[ "image", "document"]}})
		.addTextColumn({name:"uploadPath", dataIndex:"uploadPath", width:200})
		.addTextColumn({name:"baseUrl", dataIndex:"baseUrl", width:100})
		.addBooleanColumn({name:"active", dataIndex:"active"})
		.addDefaults();
	}
});
