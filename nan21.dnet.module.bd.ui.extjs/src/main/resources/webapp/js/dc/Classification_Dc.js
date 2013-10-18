/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Dnet.ns.bd + "Classification_Dc" , {
	extend: "dnet.core.dc.AbstractDc",
	recordModel: Dnet.ns.bd + "Classification_Ds"
});

/* ================= FILTER FORM: Filter ================= */			

Ext.define(Dnet.ns.bd + "Classification_Dc$Filter" , {
	extend: "dnet.core.dc.view.AbstractDcvFilterForm",
	alias: "widget.bd_Classification_Dc$Filter",

	/**
	 * Components definition
	 */	
	_defineElements_: function() {
		this._getBuilder_()
		
		/* =========== controls =========== */
		.addTextField({ name:"system", dataIndex:"system", caseRestriction:"uppercase"})
		.addTextField({ name:"item", dataIndex:"item", caseRestriction:"uppercase"})
		
		/* =========== containers =========== */
		.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
		autoScroll:true, padding:"0 30 5 0"})
		.addPanel({ name:"col1", width:210, layout:"form"});
	},

	/**
	 * Combine the components
	 */				
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["col1"])
		.addChildrenTo("col1", ["system", "item"]);
	}
});

/* ================= EDIT-GRID: EditList ================= */

Ext.define(Dnet.ns.bd + "Classification_Dc$EditList" , {
	extend: "dnet.core.dc.view.AbstractDcvEditableGrid",
	alias: "widget.bd_Classification_Dc$EditList",
	_noImport_: true,
	_noExport_: true,

	/**
	 * Columns definition
	 */
	_defineColumns_: function() {
		this._getBuilder_()	
		.addLov({name:"system", dataIndex:"system", xtype:"gridcolumn", width:150, 
			editor:{xtype:"bd_ClassificationSystems_Lov", selectOnFocus:true, allowBlank:false, caseRestriction:"uppercase",
				retFieldMapping: [{lovField:"id", dsField: "systemId"} ,{lovField:"name", dsField: "systemName"} ],
				filterFieldMapping: [{lovField:"targetAlias", dsField: "targetAlias"}, {lovField:"targetType", dsField: "targetType"}, {lovField:"active", value: "true"} ]}})
		.addTextColumn({name:"systemName", dataIndex:"systemName", hidden:true, width:300, noEdit: true})
		.addLov({name:"item", dataIndex:"item", xtype:"gridcolumn", width:150, 
			editor:{xtype:"bd_ClassificationItems_Lov", selectOnFocus:true, allowBlank:false, caseRestriction:"uppercase",
				retFieldMapping: [{lovField:"id", dsField: "itemId"} ,{lovField:"name", dsField: "itemName"} ],
				filterFieldMapping: [{lovField:"classSystemId", dsField: "systemId"}, {lovField:"active", value: "true"} ]}})
		.addTextColumn({name:"itemName", dataIndex:"itemName", width:280, noEdit: true})
		.addTextColumn({name:"systemId", dataIndex:"systemId", hidden:true, width:100, noEdit: true})
		.addTextColumn({name:"itemId", dataIndex:"itemId", hidden:true, width:100, noEdit: true})
		.addTextColumn({name:"targetRefid", dataIndex:"targetRefid", hidden:true, width:100, noEdit: true})
		.addTextColumn({name:"targetAlias", dataIndex:"targetAlias", hidden:true, width:100, noEdit: true})
		.addTextColumn({name:"targetType", dataIndex:"targetType", hidden:true, width:200, noEdit: true})
		.addDefaults();
	}
});
