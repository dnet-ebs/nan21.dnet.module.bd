/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Dnet.ns.bd + "Comment_Dc" , {
	extend: "dnet.core.dc.AbstractDc",
	recordModel: Dnet.ns.bd + "Comment_Ds"
});

/* ================= FILTER FORM: Filter ================= */			

Ext.define(Dnet.ns.bd + "Comment_Dc$Filter" , {
	extend: "dnet.core.dc.view.AbstractDcvFilterForm",
	alias: "widget.bd_Comment_Dc$Filter",

	/**
	 * Components definition
	 */	
	_defineElements_: function() {
		this._getBuilder_()
		
		/* =========== controls =========== */
		.addTextField({ name:"modifiedBy", dataIndex:"modifiedBy", maxLength:32})
		
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
		.addChildrenTo("col1", ["modifiedBy"]);
	}
});

/* ================= GRID: List ================= */

Ext.define(Dnet.ns.bd + "Comment_Dc$List" , {
	extend: "dnet.core.dc.view.AbstractDcvGrid",
	alias: "widget.bd_Comment_Dc$List",
	_noImport_: true,
	_noExport_: true,

	/**
	 * Columns definition
	 */
	_defineColumns_: function() {
		this._getBuilder_()
		.addTextColumn({ name:"text", dataIndex:"text", width:300})
		.addTextColumn({ name:"createdBy", dataIndex:"createdBy", width:100})
		.addDateColumn({ name:"createdAt", dataIndex:"createdAt", _mask_: Masks.DATETIME})
		.addDefaults();
	}
});

/* ================= EDIT FORM: Edit ================= */

Ext.define(Dnet.ns.bd + "Comment_Dc$Edit" , {
	extend: "dnet.core.dc.view.AbstractDcvEditForm",
	alias: "widget.bd_Comment_Dc$Edit",

	/**
	 * Components definition
	 */
	_defineElements_: function() {
		this._getBuilder_()
		
		/* =========== controls =========== */
		.addLov({xtype:"bd_CommentTypes_Lov", name:"type", dataIndex:"type",
			retFieldMapping: [{lovField:"id", dsField: "typeId"} ],
			filterFieldMapping: [{lovField:"targetType", dsField: "targetType"}, {lovField:"targetFqn", dsField: "targetFqn"} ]})
		.addTextArea({ name:"text", dataIndex:"text", _enableFn_: function(dc , rec) { return  rec.phantom || ( rec.data.createdBy == getApplication().getSession().user.code); } , allowBlank:false})
		
		/* =========== containers =========== */
		.addPanel({ name:"main", autoScroll:true, layout:"fit", defaults:{labelAlign:"right"}});
	},

	/**
	 * Combine the components
	 */			
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["text"]);
	}
});
