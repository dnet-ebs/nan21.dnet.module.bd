/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Dnet.ns.bd + "CountryMD_Ui" , {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.CountryMD_Ui",
	
	/**
	 * Data-controls definition
	 */
	_defineDcs_: function() {
		this._getBuilder_()	
		.addDc("country", Ext.create(Dnet.ns.bd + "Country_Dc" ,{}))	
		.addDc("region", Ext.create(Dnet.ns.bd + "Region_Dc" ,{multiEdit:true}))
		.linkDc("region", "country",{fields:[
			{childField:"countryId", parentField:"id"}, {childField:"country", parentField:"code", noFilter:true}]}
		);
	},

	/**
	 * Components definition
	 */
	_defineElements_: function() {
		this._getBuilder_()
		.addDcFilterFormView("country", {name:"countryFilter", xtype:"bd_Country_Dc$Filter"})
		.addDcGridView("country", {name:"countryList", xtype:"bd_Country_Dc$List"})
		.addDcFormView("country", {name:"countryEdit", xtype:"bd_Country_Dc$Edit"})
		.addDcEditGridView("region", {name:"regionEditList", xtype:"bd_Region_Dc$EditListContext", frame:true})
		.addPanel({name:"main", layout:"card", activeItem:0})
		.addPanel({name:"canvas1", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
		.addPanel({name:"canvas2", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}});
	},
	
	/**
	 * Combine the components
	 */
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["canvas1", "canvas2"])
		.addChildrenTo("canvas1", ["countryFilter", "countryList"], ["north", "center"])
		.addChildrenTo("canvas2", ["countryEdit", "regionEditList"], ["north", "center"])
		.addToolbarTo("canvas1", "tlbCountryList")
		.addToolbarTo("canvas2", "tlbCountryEdit")
		.addToolbarTo("regionEditList", "tlbRegionList");
	},
	
	/**
	 * Create toolbars
	 */
	_defineToolbars_: function() {
		this._getBuilder_()
		.beginToolbar("tlbCountryList", {dc: "country"})
			.addTitle().addSeparator().addSeparator()
			.addQuery().addEdit().addNew().addCopy().addDeleteSelected()
			.addReports()
		.end()
		.beginToolbar("tlbCountryEdit", {dc: "country"})
			.addTitle().addSeparator().addSeparator()
			.addBack().addSave().addNew().addCopy().addCancel().addPrevRec().addNextRec()
			.addReports()
		.end()
		.beginToolbar("tlbRegionList", {dc: "region"})
			.addTitle().addSeparator().addSeparator()
			.addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addSeparator().addAutoLoad()
			.addReports()
		.end();
	}

});
