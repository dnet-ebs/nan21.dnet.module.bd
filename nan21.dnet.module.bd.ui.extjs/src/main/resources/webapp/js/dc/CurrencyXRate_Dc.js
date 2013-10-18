/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Dnet.ns.bd + "CurrencyXRate_Dc" , {
	extend: "dnet.core.dc.AbstractDc",
	recordModel: Dnet.ns.bd + "CurrencyXRate_Ds"
});

/* ================= FILTER FORM: Filter ================= */			

Ext.define(Dnet.ns.bd + "CurrencyXRate_Dc$Filter" , {
	extend: "dnet.core.dc.view.AbstractDcvFilterForm",
	alias: "widget.bd_CurrencyXRate_Dc$Filter",

	/**
	 * Components definition
	 */	
	_defineElements_: function() {
		this._getBuilder_()
		
		/* =========== controls =========== */
		.addLov({name:"source", dataIndex:"source", xtype:"bd_Currencies_Lov", caseRestriction:"uppercase",
			retFieldMapping: [{lovField:"id", dsField: "sourceId"} ]})
		.addLov({name:"target", dataIndex:"target", xtype:"bd_Currencies_Lov", caseRestriction:"uppercase",
			retFieldMapping: [{lovField:"id", dsField: "targetId"} ]})
		.addLov({name:"provider", dataIndex:"provider", xtype:"bd_CurrencyXRateProviders_Lov", caseRestriction:"uppercase",
			retFieldMapping: [{lovField:"id", dsField: "providerId"} ]})
		.addDateField({name:"validAt", dataIndex:"validAt"})
		
		/* =========== containers =========== */
		.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
		autoScroll:true, padding:"0 30 5 0"})
		.addPanel({ name:"col1", width:210, layout:"form"})
		.addPanel({ name:"col2", width:250, layout:"form"});
	},

	/**
	 * Combine the components
	 */				
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["col1", "col2"])
		.addChildrenTo("col1", ["source", "target"])
		.addChildrenTo("col2", ["provider", "validAt"]);
	}
});

/* ================= EDIT-GRID: EditList ================= */

Ext.define(Dnet.ns.bd + "CurrencyXRate_Dc$EditList" , {
	extend: "dnet.core.dc.view.AbstractDcvEditableGrid",
	alias: "widget.bd_CurrencyXRate_Dc$EditList",

	/**
	 * Columns definition
	 */
	_defineColumns_: function() {
		this._getBuilder_()	
		.addLov({name:"source", dataIndex:"source", xtype:"gridcolumn", width:120, 
			editor:{xtype:"bd_Currencies_Lov", selectOnFocus:true, caseRestriction:"uppercase",
				retFieldMapping: [{lovField:"id", dsField: "sourceId"} ]}})
		.addLov({name:"target", dataIndex:"target", xtype:"gridcolumn", width:120, 
			editor:{xtype:"bd_Currencies_Lov", selectOnFocus:true, caseRestriction:"uppercase",
				retFieldMapping: [{lovField:"id", dsField: "targetId"} ]}})
		.addDateColumn({name:"validAt", dataIndex:"validAt", _mask_: Masks.DATE })
		.addNumberColumn({name:"value", dataIndex:"value", align:"right", decimals:6 })
		.addTextColumn({name:"providerId", dataIndex:"providerId", hidden:true, width:100, noEdit: true})
		.addLov({name:"provider", dataIndex:"provider", xtype:"gridcolumn", width:120, 
			editor:{xtype:"bd_CurrencyXRateProviders_Lov", selectOnFocus:true, caseRestriction:"uppercase",
				retFieldMapping: [{lovField:"id", dsField: "providerId"} ]}})
		.addDefaults();
	}
});
