/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Dnet.ns.bd + "TestCountry_Ui" , {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.TestCountry_Ui",
	
	/**
	 * Data-controls definition
	 */
	_defineDcs_: function() {
		this._getBuilder_()	
		.addDc("country", Ext.create(Dnet.ns.bd + "Country_Dc" ,{multiEdit:true}))
		;
	},

	/**
	 * Components definition
	 */
	_defineElements_: function() {
		this._getBuilder_()
		.addDcFilterFormView("country", {name:"countryFilter", height:120, xtype:"bd_Country_Dc$Filter"})
		.addDcFilterFormView("country", {name:"countryFilterPG", width:300, xtype:"bd_Country_Dc$FilterPG"})
		.addDcGridView("country", {name:"countryList", _hasTitle_:true, xtype:"bd_Country_Dc$List"})
		.addDcEditGridView("country", {name:"countryEditList", _hasTitle_:true, xtype:"bd_Country_Dc$EditList", frame:true})
		.addDcFormView("country", {name:"countryEdit", height:120, xtype:"bd_Country_Dc$Edit"})
		.addDcFormView("country", {name:"countryEditPG", width:300, xtype:"bd_Country_Dc$EditPG"})
		.addPanel({name:"main", layout:"border", defaults:{split:true}})
		.addPanel({name:"gridTabs", xtype:"tabpanel", activeTab:0, plain:false, deferredRender:false});
	},
	
	/**
	 * Combine the components
	 */
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["countryFilter", "gridTabs", "countryEdit", "countryEditPG", "countryFilterPG"], ["north", "center", "south", "east", "west"])
		.addChildrenTo("gridTabs", ["countryList", "countryEditList"])
		.addToolbarTo("main", "tlbList")
		.addToolbarTo("countryEdit", "tlbEdit");
	},
	
	/**
	 * Create toolbars
	 */
	_defineToolbars_: function() {
		this._getBuilder_()
		.beginToolbar("tlbList", {dc: "country"})
			.addTitle().addSeparator().addSeparator()
			.addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addReports()
		.end()
		.beginToolbar("tlbEdit", {dc: "country"})
			.addTitle().addSeparator().addSeparator()
			.addBack().addSave().addNew().addCopy().addCancel().addPrevRec().addNextRec()
			.addReports()
		.end();
	}

});
