/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Dnet.ns.bd + "AttributeSet_Ui" , {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.AttributeSet_Ui",
	
	/**
	 * Data-controls definition
	 */
	_defineDcs_: function() {
		this._getBuilder_()	
		.addDc("set", Ext.create(Dnet.ns.bd + "AttributeSet_Dc" ,{multiEdit:true}))	
		.addDc("setattr", Ext.create(Dnet.ns.bd + "AttributeSetAttribute_Dc" ,{multiEdit:true}))	
		.addDc("subset", Ext.create(Dnet.ns.bd + "AttributeSubSet_Dc" ,{multiEdit:true}))	
		.addDc("targetRule", Ext.create(Dnet.ns.bd + "TargetRule_Dc" ,{multiEdit:true}))
		.linkDc("targetRule", "set",{fields:[
			{childField:"sourceRefId", parentField:"refid"}]}
		);
	},

	/**
	 * Components definition
	 */
	_defineElements_: function() {
		this._getBuilder_()
		.addButton({name:"btnInitSubset", disabled:true, handler: this.onBtnInitSubset,
				stateManager:{ name:"selected_not_zero", dc:"set" }, scope:this})
		.addButton({name:"btnOk", disabled:false, handler: this.onBtnOk, scope:this})
		.addDcFilterFormView("set", {name:"setFilter", xtype:"bd_AttributeSet_Dc$Filter"})
		.addDcEditGridView("set", {name:"setEditList", xtype:"bd_AttributeSet_Dc$EditList", frame:true})
		.addDcEditGridView("targetRule", {name:"targetRuleEditList", height:240, xtype:"bd_TargetRule_Dc$EditList", frame:true})
		.addDcFilterFormView("subset", {name:"subsetFilter", xtype:"bd_AttributeSubSet_Dc$Filter"})
		.addDcEditGridView("subset", {name:"subsetEditList", xtype:"bd_AttributeSubSet_Dc$EditList", frame:true})
		.addDcFilterFormView("setattr", {name:"setAttrFilter", xtype:"bd_AttributeSetAttribute_Dc$Filter"})
		.addDcEditGridView("setattr", {name:"setAttrEditList", xtype:"bd_AttributeSetAttribute_Dc$EditList", frame:true})
		.addDcFormView("set", {name:"initSubset", xtype:"bd_AttributeSet_Dc$InitSubSet"})
		.addWindow({name:"wdwInitSubset", _hasTitle_:true, width:350, height:150, closeAction:'hide', resizable:true, layout:"fit", modal:true,
			items:[this._elems_.get("initSubset")], 
					dockedItems:[{xtype:"toolbar", ui:"footer", dock:'bottom', weight:-1,
						items:[ this._elems_.get("btnOk")]}]})
		.addPanel({name:"main", layout:"card", activeItem:0})
		.addPanel({name:"canvasSet", _hasTitle_:true, preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
		.addPanel({name:"canvasSubSet", _hasTitle_:true, preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
		.addPanel({name:"canvasSetAttr", _hasTitle_:true, preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}}).addPanel({name:"_main_with_toc_", layout:"border", id:Ext.id(), defaults:{split:true}, header:false,
					listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);  } }}
			})
		.addToc(["canvasSet","canvasSubSet","canvasSetAttr"]);
		this._mainViewName_  = "_main_with_toc_";
		;
	},
	
	/**
	 * Combine the components
	 */
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["canvasSet", "canvasSubSet", "canvasSetAttr"])
		.addChildrenTo("canvasSet", ["setFilter", "setEditList", "targetRuleEditList"], ["north", "center", "south"])
		.addChildrenTo("canvasSubSet", ["subsetFilter", "subsetEditList"], ["north", "center"])
		.addChildrenTo("canvasSetAttr", ["setAttrFilter", "setAttrEditList"], ["north", "center"])
		.addChildrenTo("_main_with_toc_",["main","_toc_"]).change("main",{region: "center"})
		.addToolbarTo("canvasSet", "tlbSetEditList")
		.addToolbarTo("targetRuleEditList", "tlbTargetRuleEditList")
		.addToolbarTo("canvasSubSet", "tlbSubsetEditList")
		.addToolbarTo("canvasSetAttr", "tlbSetAttrEditList");
	},
	
	/**
	 * Create toolbars
	 */
	_defineToolbars_: function() {
		this._getBuilder_()
		.beginToolbar("tlbSetEditList", {dc: "set"})
			.addTitle().addSeparator().addSeparator()
			.addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addSeparator().addSeparator()
			.addButtons([this._elems_.get("btnInitSubset") ])
			.addReports()
		.end()
		.beginToolbar("tlbTargetRuleEditList", {dc: "targetRule"})
			.addTitle().addSeparator().addSeparator()
			.addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addSeparator().addAutoLoad()
			.addReports()
		.end()
		.beginToolbar("tlbSubsetEditList", {dc: "subset"})
			.addTitle().addSeparator().addSeparator()
			.addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addReports()
		.end()
		.beginToolbar("tlbSetAttrEditList", {dc: "setattr"})
			.addTitle().addSeparator().addSeparator()
			.addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addReports()
		.end();
	}

	
	/**
	 * On-Click handler for button btnInitSubset
	 */
	,onBtnInitSubset: function() {
		this._getWindow_("wdwInitSubset").show();
	}
	
	/**
	 * On-Click handler for button btnOk
	 */
	,onBtnOk: function() {
		var successFn = function(dc,response,serviceName,specs) {
			this._getWindow_("wdwInitSubset").close();
			this._getDc_("subset").doQuery();
		};
		var o={
			name:"createDefaultSubSet",
			callbacks:{
				successFn: successFn,
				successScope: this
			},
			modal:true
		};
		this._getDc_("set").doRpcDataList(o);
	}
});
