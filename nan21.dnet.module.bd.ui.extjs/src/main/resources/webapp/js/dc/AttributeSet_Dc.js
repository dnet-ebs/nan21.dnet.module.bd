/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Dnet.ns.bd + "AttributeSet_Dc" , {
	extend: "dnet.core.dc.AbstractDc",
	paramModel: Dnet.ns.bd + "AttributeSet_DsParam",
	recordModel: Dnet.ns.bd + "AttributeSet_Ds"
});

/* ================= FILTER: Filter ================= */


Ext.define(Dnet.ns.bd + "AttributeSet_Dc$Filter" , {
	extend: "dnet.core.dc.view.AbstractDcvFilterPropGrid",
	alias: "widget.bd_AttributeSet_Dc$Filter",

	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addLov({xtype:"bd_AttributeSets_Lov", name:"code", dataIndex:"code", caseRestriction:"uppercase",
				editor:{_fqn_:Dnet.ns.bd + "AttributeSets_Lov" , selectOnFocus:true, caseRestriction:"uppercase",
					retFieldMapping: [{lovField:"id", dsField: "id"} ]}})
			.addTextField({ name:"name", dataIndex:"name"})
			.addBooleanField({ name:"active", dataIndex:"active"})
		;
	}

});

/* ================= EDIT-GRID: EditList ================= */

Ext.define(Dnet.ns.bd + "AttributeSet_Dc$EditList" , {
	extend: "dnet.core.dc.view.AbstractDcvEditableGrid",
	alias: "widget.bd_AttributeSet_Dc$EditList",

	/**
	 * Columns definition
	 */
	_defineColumns_: function() {
		this._getBuilder_()	
		.addTextColumn({name:"code", dataIndex:"code", width:120, caseRestriction:"uppercase"})
		.addTextColumn({name:"name", dataIndex:"name", width:200})
		.addBooleanColumn({name:"active", dataIndex:"active"})
		.addTextColumn({name:"description", dataIndex:"description", width:200})
		.addDefaults();
	}
});

/* ================= EDIT FORM: InitSubSet ================= */

Ext.define(Dnet.ns.bd + "AttributeSet_Dc$InitSubSet" , {
	extend: "dnet.core.dc.view.AbstractDcvEditForm",
	alias: "widget.bd_AttributeSet_Dc$InitSubSet",

	/**
	 * Components definition
	 */
	_defineElements_: function() {
		this._getBuilder_()
		
		/* =========== controls =========== */
		.addTextField({ name:"subSetCode", paramIndex:"subSetCode", caseRestriction:"uppercase"})
		.addTextField({ name:"subSetName", paramIndex:"subSetName"})
		
		/* =========== containers =========== */
		.addPanel({ name:"main", autoScroll:true, layout:"form"});
	},

	/**
	 * Combine the components
	 */			
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["subSetName", "subSetCode"]);
	}
});
