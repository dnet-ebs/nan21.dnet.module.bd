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
		.linkDc("setattr", "set",{fields:[
			{childField:"attributeSetId", parentField:"id"}, {childField:"attributeSet", parentField:"code", noFilter:true}]}
		).linkDc("subset", "set",{fields:[
			{childField:"attributeSetId", parentField:"id"}, {childField:"attributeSet", parentField:"code", noFilter:true}]}
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
		.addDcFilterFormView("set", {name:"setFilter", _hasTitle_:true, width:250, xtype:"bd_AttributeSet_Dc$Filter", collapsible:true
		})
		.addDcEditGridView("set", {name:"setEditList", xtype:"bd_AttributeSet_Dc$EditList", frame:true})
		.addDcEditGridView("subset", {name:"subsetEditList", _hasTitle_:true, xtype:"bd_AttributeSubSet_Dc$CtxEditList", frame:true})
		.addDcEditGridView("setattr", {name:"setAttrEditList", _hasTitle_:true, xtype:"bd_AttributeSetAttribute_Dc$CtxEditList", frame:true})
		.addDcFormView("set", {name:"initSubset", xtype:"bd_AttributeSet_Dc$InitSubSet"})
		.addWindow({name:"wdwInitSubset", _hasTitle_:true, width:350, height:150, closeAction:'hide', resizable:true, layout:"fit", modal:true,
			items:[this._elems_.get("initSubset")], 
					dockedItems:[{xtype:"toolbar", ui:"footer", dock:'bottom', weight:-1,
						items:[ this._elems_.get("btnOk")]}]})
		.addPanel({name:"main", layout:"border", defaults:{split:true}})
		.addPanel({name:"setDetails", height:280, xtype:"tabpanel", activeTab:0, plain:false, deferredRender:false});
	},
	
	/**
	 * Combine the components
	 */
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["setFilter", "setEditList", "setDetails"], ["west", "center", "south"])
		.addChildrenTo("setDetails", ["subsetEditList", "setAttrEditList"])
		.addToolbarTo("main", "tlbSetEditList")
		.addToolbarTo("subsetEditList", "tlbSubsetEditList")
		.addToolbarTo("setAttrEditList", "tlbSetAttrEditList");
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
		.beginToolbar("tlbSubsetEditList", {dc: "subset"})
			.addTitle().addSeparator().addSeparator()
			.addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addSeparator().addAutoLoad()
			.addReports()
		.end()
		.beginToolbar("tlbSetAttrEditList", {dc: "setattr"})
			.addTitle().addSeparator().addSeparator()
			.addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addSeparator().addAutoLoad()
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
