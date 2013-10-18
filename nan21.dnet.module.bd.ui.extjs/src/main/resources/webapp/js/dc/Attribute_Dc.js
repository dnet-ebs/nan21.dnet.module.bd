/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Dnet.ns.bd + "Attribute_Dc" , {
	extend: "dnet.core.dc.AbstractDc",
	recordModel: Dnet.ns.bd + "Attribute_Ds"
});

/* ================= FILTER FORM: Filter ================= */			

Ext.define(Dnet.ns.bd + "Attribute_Dc$Filter" , {
	extend: "dnet.core.dc.view.AbstractDcvFilterForm",
	alias: "widget.bd_Attribute_Dc$Filter",

	/**
	 * Components definition
	 */	
	_defineElements_: function() {
		this._getBuilder_()
		
		/* =========== controls =========== */
		.addLov({name:"code", dataIndex:"code", xtype:"bd_Attributes_Lov", caseRestriction:"uppercase",
			retFieldMapping: [{lovField:"id", dsField: "id"} ]})
		.addTextField({ name:"name", dataIndex:"name"})
		.addBooleanField({ name:"active", dataIndex:"active"})
		.addLov({name:"category", dataIndex:"category", xtype:"bd_AttributeCategories_Lov", caseRestriction:"uppercase",
			retFieldMapping: [{lovField:"id", dsField: "categoryId"} ]})
		.addLov({name:"uom", dataIndex:"uom", xtype:"bd_Uoms_Lov", caseRestriction:"uppercase",
			retFieldMapping: [{lovField:"id", dsField: "uomId"} ]})
		.addCombo({ xtype:"combo", name:"dataType", dataIndex:"dataType", store:[ "string", "text", "integer", "decimal", "boolean", "date"]})
		
		/* =========== containers =========== */
		.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
		autoScroll:true, padding:"0 30 5 0"})
		.addPanel({ name:"col1", width:250, layout:"form"})
		.addPanel({ name:"col2", width:250, layout:"form"})
		.addPanel({ name:"col3", width:210, layout:"form"});
	},

	/**
	 * Combine the components
	 */				
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["col1", "col2", "col3"])
		.addChildrenTo("col1", ["code", "name"])
		.addChildrenTo("col2", ["category", "uom"])
		.addChildrenTo("col3", ["dataType", "active"]);
	}
});

/* ================= EDIT-GRID: EditList ================= */

Ext.define(Dnet.ns.bd + "Attribute_Dc$EditList" , {
	extend: "dnet.core.dc.view.AbstractDcvEditableGrid",
	alias: "widget.bd_Attribute_Dc$EditList",
	_bulkEditFields_: ["active","category","dataType","uom"],

	/**
	 * Columns definition
	 */
	_defineColumns_: function() {
		this._getBuilder_()	
		.addLov({name:"category", dataIndex:"category", xtype:"gridcolumn", width:120, 
			editor:{xtype:"bd_AttributeCategories_Lov", selectOnFocus:true, caseRestriction:"uppercase",
				retFieldMapping: [{lovField:"id", dsField: "categoryId"} ]}})
		.addTextColumn({name:"code", dataIndex:"code", width:120, caseRestriction:"uppercase"})
		.addTextColumn({name:"name", dataIndex:"name", width:120})
		.addTextColumn({name:"description", dataIndex:"description", width:200})
		.addComboColumn({name:"dataType", dataIndex:"dataType", width:100, 
			editor:{xtype:"combo", mode: 'local', selectOnFocus:true, triggerAction:'all', forceSelection:true, store:[ "string", "text", "integer", "decimal", "boolean", "date"]}})
		.addTextColumn({name:"listOfvalues", dataIndex:"listOfvalues", width:120})
		.addLov({name:"uom", dataIndex:"uom", xtype:"gridcolumn", width:80, 
			editor:{xtype:"bd_Uoms_Lov", selectOnFocus:true, caseRestriction:"uppercase",
				retFieldMapping: [{lovField:"id", dsField: "uomId"} ]}})
		.addBooleanColumn({name:"active", dataIndex:"active", width:60})
		.addTextColumn({name:"categoryId", dataIndex:"categoryId", hidden:true, width:100, noEdit: true})
		.addDefaults();
	}
});
