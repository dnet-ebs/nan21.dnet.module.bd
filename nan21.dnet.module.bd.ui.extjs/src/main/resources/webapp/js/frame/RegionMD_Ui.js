/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Dnet.ns.bd + "RegionMD_Ui" , {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.RegionMD_Ui",
	
	/**
	 * Data-controls definition
	 */
	_defineDcs_: function() {
		this._getBuilder_()	
		.addDc("region", Ext.create(Dnet.ns.bd + "Region_Dc" ,{}))	
		.addDc("city", Ext.create(Dnet.ns.bd + "City_Dc" ,{multiEdit:true}))
		.linkDc("city", "region",{fields:[
			{childField:"regionId", parentField:"id"}, {childField:"countryId", parentField:"countryId"}]}
		);
	},

	/**
	 * Components definition
	 */
	_defineElements_: function() {
		this._getBuilder_()
		.addDcFilterFormView("region", {name:"regionFilter", height:80, xtype:"bd_Region_Dc$Filter"})
		.addDcGridView("region", {name:"regionList", xtype:"bd_Region_Dc$List"})
		.addDcFormView("region", {name:"regionEdit", height:120, xtype:"bd_Region_Dc$Edit"})
		.addDcEditGridView("city", {name:"cityEditList", xtype:"bd_City_Dc$CtxEditList", frame:true})
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
		.addChildrenTo("canvas1", ["regionFilter", "regionList"], ["north", "center"])
		.addChildrenTo("canvas2", ["regionEdit", "cityEditList"], ["north", "center"])
		.addToolbarTo("canvas1", "tlbRegionList")
		.addToolbarTo("canvas2", "tlbRegionEdit")
		.addToolbarTo("cityEditList", "tlbCityList");
	},
	
	/**
	 * Create toolbars
	 */
	_defineToolbars_: function() {
		this._getBuilder_()
		.beginToolbar("tlbRegionList", {dc: "region"})
			.addTitle().addSeparator().addSeparator()
			.addQuery().addEdit().addNew().addCopy().addDeleteSelected()
			.addReports()
		.end()
		.beginToolbar("tlbRegionEdit", {dc: "region"})
			.addTitle().addSeparator().addSeparator()
			.addBack().addSave().addNew().addCopy().addCancel().addPrevRec().addNextRec()
			.addReports()
		.end()
		.beginToolbar("tlbCityList", {dc: "city"})
			.addTitle().addSeparator().addSeparator()
			.addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addSeparator().addAutoLoad()
			.addReports()
		.end();
	}

});
