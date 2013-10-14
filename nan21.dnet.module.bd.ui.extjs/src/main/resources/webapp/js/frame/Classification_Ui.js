/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Dnet.ns.bd + "Classification_Ui" , {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.Classification_Ui",
	
	/**
	 * Data-controls definition
	 */
	_defineDcs_: function() {
		this._getBuilder_()	
		.addDc("classsys", Ext.create(Dnet.ns.bd + "ClassificationSystem_Dc" ,{multiEdit:true}))	
		.addDc("classcode", Ext.create(Dnet.ns.bd + "ClassificationCode_Dc" ,{multiEdit:true}))	
		.addDc("targetRule", Ext.create(Dnet.ns.bd + "TargetRule_Dc" ,{multiEdit:true}))
		.linkDc("targetRule", "classsys",{fields:[
			{childField:"sourceRefId", parentField:"refid"}]}
		);
	},

	/**
	 * Components definition
	 */
	_defineElements_: function() {
		this._getBuilder_()
		.addDcFilterFormView("classsys", {name:"classsysFilter", xtype:"bd_ClassificationSystem_Dc$Filter"})
		.addDcEditGridView("classsys", {name:"classsysEditList", xtype:"bd_ClassificationSystem_Dc$EditList", frame:true})
		.addDcFilterFormView("classcode", {name:"classcodeFilter", xtype:"bd_ClassificationCode_Dc$Filter"})
		.addDcEditGridView("classcode", {name:"classcodeEditList", xtype:"bd_ClassificationCode_Dc$EditList", frame:true})
		.addDcEditGridView("targetRule", {name:"targetRuleEditList", height:240, xtype:"bd_TargetRule_Dc$EditList", frame:true})
		.addPanel({name:"main", layout:"card", activeItem:0})
		.addPanel({name:"canvasClasssys", _hasTitle_:true, preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
		.addPanel({name:"canvasClasscode", _hasTitle_:true, preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}}).addPanel({name:"_main_with_toc_", layout:"border", id:Ext.id(), defaults:{split:true}, header:false,
					listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);  } }}
			})
		.addToc(["canvasClasssys","canvasClasscode"]);
		this._mainViewName_  = "_main_with_toc_";
		;
	},
	
	/**
	 * Combine the components
	 */
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["canvasClasssys", "canvasClasscode"])
		.addChildrenTo("canvasClasssys", ["classsysFilter", "classsysEditList", "targetRuleEditList"], ["north", "center", "south"])
		.addChildrenTo("canvasClasscode", ["classcodeFilter", "classcodeEditList"], ["north", "center"])
		.addChildrenTo("_main_with_toc_",["main","_toc_"]).change("main",{region: "center"})
		.addToolbarTo("canvasClasssys", "tlbClasssysEditList")
		.addToolbarTo("targetRuleEditList", "tlbTargetRuleEditList")
		.addToolbarTo("canvasClasscode", "tlbClasscodeEditList");
	},
	
	/**
	 * Create toolbars
	 */
	_defineToolbars_: function() {
		this._getBuilder_()
		.beginToolbar("tlbClasssysEditList", {dc: "classsys"})
			.addTitle().addSeparator().addSeparator()
			.addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addReports()
		.end()
		.beginToolbar("tlbTargetRuleEditList", {dc: "targetRule"})
			.addTitle().addSeparator().addSeparator()
			.addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addSeparator().addAutoLoad()
			.addReports()
		.end()
		.beginToolbar("tlbClasscodeEditList", {dc: "classcode"})
			.addTitle().addSeparator().addSeparator()
			.addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addReports()
		.end();
	}

});
