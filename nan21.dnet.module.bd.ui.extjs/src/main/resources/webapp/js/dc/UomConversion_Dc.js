/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Dnet.ns.bd + "UomConversion_Dc" , {
	extend: "dnet.core.dc.AbstractDc",
	recordModel: Dnet.ns.bd + "UomConversion_Ds"
});

/* ================= FILTER FORM: Filter ================= */			

Ext.define(Dnet.ns.bd + "UomConversion_Dc$Filter" , {
	extend: "dnet.core.dc.view.AbstractDcvFilterForm",
	alias: "widget.bd_UomConversion_Dc$Filter",

	/**
	 * Components definition
	 */	
	_defineElements_: function() {
		this._getBuilder_()
		
		/* =========== controls =========== */
		.addLov({name:"source", dataIndex:"source", xtype:"bd_Uoms_Lov", caseRestriction:"uppercase",
			retFieldMapping: [{lovField:"id", dsField: "sourceId"} ]})
		.addLov({name:"target", dataIndex:"target", xtype:"bd_Uoms_Lov", caseRestriction:"uppercase",
			retFieldMapping: [{lovField:"id", dsField: "targetId"} ]})
		.addBooleanField({ name:"active", dataIndex:"active"})
		
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
		.addChildrenTo("col1", ["source", "target"])
		.addChildrenTo("col2", ["active"]);
	}
});

/* ================= EDIT-GRID: EditList ================= */

Ext.define(Dnet.ns.bd + "UomConversion_Dc$EditList" , {
	extend: "dnet.core.dc.view.AbstractDcvEditableGrid",
	alias: "widget.bd_UomConversion_Dc$EditList",

	/**
	 * Columns definition
	 */
	_defineColumns_: function() {
		this._getBuilder_()	
		.addLov({name:"source", dataIndex:"source", xtype:"gridcolumn", width:100, 
			editor:{xtype:"bd_Uoms_Lov", selectOnFocus:true, caseRestriction:"uppercase",
				retFieldMapping: [{lovField:"id", dsField: "sourceId"} ]}})
		.addLov({name:"target", dataIndex:"target", xtype:"gridcolumn", width:100, 
			editor:{xtype:"bd_Uoms_Lov", selectOnFocus:true, caseRestriction:"uppercase",
				retFieldMapping: [{lovField:"id", dsField: "targetId"} ]}})
		.addNumberColumn({name:"multiplyWith", dataIndex:"multiplyWith", align:"right", decimals:6 })
		.addNumberColumn({name:"divideTo", dataIndex:"divideTo", align:"right", decimals:6 })
		.addBooleanColumn({name:"active", dataIndex:"active"})
		.addDefaults();
	}
});

/* ================= EDIT-GRID: CtxEditList ================= */

Ext.define(Dnet.ns.bd + "UomConversion_Dc$CtxEditList" , {
	extend: "dnet.core.dc.view.AbstractDcvEditableGrid",
	alias: "widget.bd_UomConversion_Dc$CtxEditList",

	/**
	 * Columns definition
	 */
	_defineColumns_: function() {
		this._getBuilder_()	
		.addTextColumn({name:"source", dataIndex:"source", width:100, caseRestriction:"uppercase", noEdit: true})
		.addLov({name:"target", dataIndex:"target", xtype:"gridcolumn", width:100, 
			editor:{xtype:"bd_Uoms_Lov", selectOnFocus:true, caseRestriction:"uppercase",
				retFieldMapping: [{lovField:"id", dsField: "targetId"} ]}})
		.addNumberColumn({name:"multiplyWith", dataIndex:"multiplyWith", align:"right", decimals:6 })
		.addNumberColumn({name:"divideTo", dataIndex:"divideTo", align:"right", decimals:6 })
		.addBooleanColumn({name:"active", dataIndex:"active"})
		.addDefaults();
	}
});
