/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Dnet.ns.bd + "AttachmentType_Ui" , {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.AttachmentType_Ui",
	
	/**
	 * Data-controls definition
	 */
	_defineDcs_: function() {
		this._getBuilder_()	
		.addDc("attchType", Ext.create(Dnet.ns.bd + "AttachmentType_Dc" ,{multiEdit:true}))	
		.addDc("targetRule", Ext.create(Dnet.ns.bd + "TargetRule_Dc" ,{multiEdit:true}))
		.linkDc("targetRule", "attchType",{fields:[
			{childField:"sourceRefId", parentField:"refid"}]}
		);
	},

	/**
	 * Components definition
	 */
	_defineElements_: function() {
		this._getBuilder_()
		.addDcFilterFormView("attchType", {name:"attchTypeFilter", xtype:"bd_AttachmentType_Dc$Filter"})
		.addDcEditGridView("attchType", {name:"attchTypeEditList", xtype:"bd_AttachmentType_Dc$EditList", frame:true})
		.addDcEditGridView("targetRule", {name:"targetRuleEditList", height:240, xtype:"bd_TargetRule_Dc$EditList", frame:true})
		.addPanel({name:"main", layout:"border", defaults:{split:true}});
	},
	
	/**
	 * Combine the components
	 */
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["attchTypeFilter", "attchTypeEditList", "targetRuleEditList"], ["north", "center", "south"])
		.addToolbarTo("main", "tlbAttchTypeEditList")
		.addToolbarTo("targetRuleEditList", "tlbTargetRuleEditList");
	},
	
	/**
	 * Create toolbars
	 */
	_defineToolbars_: function() {
		this._getBuilder_()
		.beginToolbar("tlbAttchTypeEditList", {dc: "attchType"})
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
