/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Dnet.ns.bd + "AttributeSetAttribute_Dc" , {
	extend: "dnet.core.dc.AbstractDc",
	recordModel: Dnet.ns.bd + "AttributeSetAttribute_Ds"
});

/* ================= FILTER FORM: Filter ================= */			

Ext.define(Dnet.ns.bd + "AttributeSetAttribute_Dc$Filter" , {
	extend: "dnet.core.dc.view.AbstractDcvFilterForm",
	alias: "widget.bd_AttributeSetAttribute_Dc$Filter",

	/**
	 * Components definition
	 */	
	_defineElements_: function() {
		this._getBuilder_()
		
		/* =========== controls =========== */
		.addLov({xtype:"bd_AttributeSets_Lov", name:"attributeSet", dataIndex:"attributeSet", caseRestriction:"uppercase",
			retFieldMapping: [{lovField:"id", dsField: "attributeSetId"} ]})
		.addLov({xtype:"bd_AttributeSubSets_Lov", name:"attributeSubSet", dataIndex:"attributeSubSet", caseRestriction:"uppercase",
			retFieldMapping: [{lovField:"id", dsField: "attributeSubSetId"} ]})
		.addLov({xtype:"bd_Attributes_Lov", name:"attribute", dataIndex:"attribute", caseRestriction:"uppercase",
			retFieldMapping: [{lovField:"id", dsField: "attributeId"} ]})
		.addBooleanField({ name:"inDescription", dataIndex:"inDescription"})
		
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
		.addChildrenTo("col1", ["attributeSet", "attributeSubSet"])
		.addChildrenTo("col2", ["attribute"])
		.addChildrenTo("col3", ["inDescription"]);
	}
});

/* ================= EDIT-GRID: CtxEditList ================= */

Ext.define(Dnet.ns.bd + "AttributeSetAttribute_Dc$CtxEditList" , {
	extend: "dnet.core.dc.view.AbstractDcvEditableGrid",
	alias: "widget.bd_AttributeSetAttribute_Dc$CtxEditList",

	/**
	 * Columns definition
	 */
	_defineColumns_: function() {
		this._getBuilder_()	
		.addTextColumn({name:"attributeSet", dataIndex:"attributeSet", hidden:true, width:120, caseRestriction:"uppercase", noEdit: true})
		.addLov({name:"attributeSubSet", dataIndex:"attributeSubSet", xtype:"gridcolumn", width:150, 
			editor:{xtype:"bd_AttributeSubSets_Lov", selectOnFocus:true, caseRestriction:"uppercase",
				retFieldMapping: [{lovField:"id", dsField: "attributeSubSetId"} ,{lovField:"name", dsField: "attributeSubSetName"} ]}})
		.addTextColumn({name:"attributeSubSetName", dataIndex:"attributeSubSetName", width:150, noEdit: true})
		.addNumberColumn({name:"sequenceNo", dataIndex:"sequenceNo", align:"right", width:70, format:"0" })
		.addLov({name:"attribute", dataIndex:"attribute", xtype:"gridcolumn", width:150, 
			editor:{xtype:"bd_Attributes_Lov", selectOnFocus:true, caseRestriction:"uppercase",
				retFieldMapping: [{lovField:"id", dsField: "attributeId"} ,{lovField:"name", dsField: "attributeName"} ]}})
		.addTextColumn({name:"attributeName", dataIndex:"attributeName", width:150, noEdit: true})
		.addBooleanColumn({name:"inDescription", dataIndex:"inDescription"})
		.addBooleanColumn({name:"active", dataIndex:"active"})
		.addTextColumn({name:"attributeId", dataIndex:"attributeId", hidden:true, width:100, noEdit: true})
		.addTextColumn({name:"attributeSubSetId", dataIndex:"attributeSubSetId", hidden:true, width:100, noEdit: true})
		.addDefaults();
	}
});

/* ================= EDIT-GRID: EditList ================= */

Ext.define(Dnet.ns.bd + "AttributeSetAttribute_Dc$EditList" , {
	extend: "dnet.core.dc.view.AbstractDcvEditableGrid",
	alias: "widget.bd_AttributeSetAttribute_Dc$EditList",

	/**
	 * Columns definition
	 */
	_defineColumns_: function() {
		this._getBuilder_()	
		.addNumberColumn({name:"sequenceNo", dataIndex:"sequenceNo", align:"right", width:70, format:"0" })
		.addLov({name:"attributeSet", dataIndex:"attributeSet", xtype:"gridcolumn", width:120, 
			editor:{xtype:"bd_AttributeSets_Lov", selectOnFocus:true, caseRestriction:"uppercase",
				retFieldMapping: [{lovField:"id", dsField: "attributeSetId"} ]}})
		.addLov({name:"attribute", dataIndex:"attribute", xtype:"gridcolumn", width:120, 
			editor:{xtype:"bd_Attributes_Lov", selectOnFocus:true, caseRestriction:"uppercase",
				retFieldMapping: [{lovField:"id", dsField: "attributeId"} ]}})
		.addBooleanColumn({name:"inDescription", dataIndex:"inDescription"})
		.addTextColumn({name:"attributeId", dataIndex:"attributeId", hidden:true, width:100, noEdit: true})
		.addTextColumn({name:"attributeSetId", dataIndex:"attributeSetId", hidden:true, width:100, noEdit: true})
		.addDefaults();
	}
});
