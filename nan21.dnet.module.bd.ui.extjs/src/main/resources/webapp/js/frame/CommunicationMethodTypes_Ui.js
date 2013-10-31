/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Dnet.ns.bd + "CommunicationMethodTypes_Ui" , {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.CommunicationMethodTypes_Ui",
	
	/**
	 * Data-controls definition
	 */
	_defineDcs_: function() {
		this._getBuilder_()	
		.addDc("ctype", Ext.create(Dnet.ns.bd + "CommunicationMethodType_Dc" ,{multiEdit:true}))	
		.addDc("targetRule", Ext.create(Dnet.ns.bd + "TargetRule_Dc" ,{multiEdit:true}))
		.linkDc("targetRule", "ctype",{fields:[
			{childField:"sourceRefId", parentField:"refid"}]}
		);
	},

	/**
	 * Components definition
	 */
	_defineElements_: function() {
		this._getBuilder_()
		.addDcFilterFormView("ctype", {name:"ctypeFilter", xtype:"bd_CommunicationMethodType_Dc$Filter"})
		.addDcEditGridView("ctype", {name:"ctypeEditList", xtype:"bd_CommunicationMethodType_Dc$EditList", frame:true})
		.addDcEditGridView("targetRule", {name:"targetRuleList", height:240, xtype:"bd_TargetRule_Dc$EditList", frame:true})
		.addPanel({name:"main", layout:"border", defaults:{split:true}});
	},
	
	/**
	 * Combine the components
	 */
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["ctypeFilter", "ctypeEditList", "targetRuleList"], ["north", "center", "south"])
		.addToolbarTo("main", "tlbCtypeEditList")
		.addToolbarTo("targetRuleList", "tlbTargetRuleEditList");
	},
	
	/**
	 * Create toolbars
	 */
	_defineToolbars_: function() {
		this._getBuilder_()
		.beginToolbar("tlbCtypeEditList", {dc: "ctype"})
			.addTitle().addSeparator().addSeparator()
			.addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addReports()
		.end()
		.beginToolbar("tlbTargetRuleEditList", {dc: "targetRule"})
			.addTitle().addSeparator().addSeparator()
			.addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addSeparator().addAutoLoad()
			.addReports()
		.end();
	}

});
