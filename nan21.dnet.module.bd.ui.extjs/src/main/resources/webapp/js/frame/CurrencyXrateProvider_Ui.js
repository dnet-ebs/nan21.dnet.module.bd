/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Dnet.ns.bd + "CurrencyXrateProvider_Ui" , {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.CurrencyXrateProvider_Ui",
	
	/**
	 * Data-controls definition
	 */
	_defineDcs_: function() {
		this._getBuilder_()	
		.addDc("prvd", Ext.create(Dnet.ns.bd + "CurrencyXRateProvider_Dc" ,{multiEdit:true}))
		;
	},

	/**
	 * Components definition
	 */
	_defineElements_: function() {
		this._getBuilder_()
		.addDcFilterFormView("prvd", {name:"prvdFilter", height:80, xtype:"bd_CurrencyXRateProvider_Dc$Filter"})
		.addDcEditGridView("prvd", {name:"prvdEditList", xtype:"bd_CurrencyXRateProvider_Dc$EditList", frame:true})
		.addPanel({name:"main", layout:"border", defaults:{split:true}});
	},
	
	/**
	 * Combine the components
	 */
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["prvdFilter", "prvdEditList"], ["north", "center"])
		.addToolbarTo("main", "tlbPrvdEditList");
	},
	
	/**
	 * Create toolbars
	 */
	_defineToolbars_: function() {
		this._getBuilder_()
		.beginToolbar("tlbPrvdEditList", {dc: "prvd"})
			.addTitle().addSeparator().addSeparator()
			.addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addReports()
		.end();
	}

});
