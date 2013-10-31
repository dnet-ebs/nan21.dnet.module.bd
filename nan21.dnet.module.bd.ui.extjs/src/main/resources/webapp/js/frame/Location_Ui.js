/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Dnet.ns.bd + "Location_Ui" , {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.Location_Ui",
	
	/**
	 * Data-controls definition
	 */
	_defineDcs_: function() {
		this._getBuilder_()	
		.addDc("location", Ext.create(Dnet.ns.bd + "Location_Dc" ,{}))
		;
	},

	/**
	 * Components definition
	 */
	_defineElements_: function() {
		this._getBuilder_()
		.addDcFilterFormView("location", {name:"locationFilter", xtype:"bd_Location_Dc$Filter"})
		.addDcGridView("location", {name:"locationListCtx", xtype:"bd_Location_Dc$List"})
		.addPanel({name:"main", layout:"border", defaults:{split:true}});
	},
	
	/**
	 * Combine the components
	 */
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["locationFilter", "locationListCtx"], ["north", "center"])
		.addToolbarTo("main", "tlbLocationListCtx");
	},
	
	/**
	 * Create toolbars
	 */
	_defineToolbars_: function() {
		this._getBuilder_()
		.beginToolbar("tlbLocationListCtx", {dc: "location"})
			.addTitle().addSeparator().addSeparator()
			.addQuery()
			.addReports()
		.end();
	}

});
