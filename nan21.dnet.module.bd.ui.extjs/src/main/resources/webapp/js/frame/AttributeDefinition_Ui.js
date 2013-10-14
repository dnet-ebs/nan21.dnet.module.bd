/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Dnet.ns.bd + "AttributeDefinition_Ui" , {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.AttributeDefinition_Ui",
	
	/**
	 * Data-controls definition
	 */
	_defineDcs_: function() {
		this._getBuilder_()	
		.addDc("attr", Ext.create(Dnet.ns.bd + "Attribute_Dc" ,{multiEdit:true}))	
		.addDc("categ", Ext.create(Dnet.ns.bd + "AttributeCategory_Dc" ,{multiEdit:true}))
		;
	},

	/**
	 * Components definition
	 */
	_defineElements_: function() {
		this._getBuilder_()
		.addDcFilterFormView("attr", {name:"attrFilter", xtype:"bd_Attribute_Dc$Filter"})
		.addDcEditGridView("attr", {name:"attrEditList", xtype:"bd_Attribute_Dc$EditList", frame:true})
		.addDcFilterFormView("categ", {name:"categFilter", xtype:"bd_AttributeCategory_Dc$Filter"})
		.addDcEditGridView("categ", {name:"categEditList", xtype:"bd_AttributeCategory_Dc$EditList", frame:true})
		.addPanel({name:"main", layout:"card", activeItem:0})
		.addPanel({name:"canvasCateg", _hasTitle_:true, preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
		.addPanel({name:"canvasAttr", _hasTitle_:true, preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}}).addPanel({name:"_main_with_toc_", layout:"border", id:Ext.id(), defaults:{split:true}, header:false,
					listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);  } }}
			})
		.addToc(["canvasAttr","canvasCateg"]);
		this._mainViewName_  = "_main_with_toc_";
		;
	},
	
	/**
	 * Combine the components
	 */
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["canvasAttr", "canvasCateg"])
		.addChildrenTo("canvasCateg", ["categFilter", "categEditList"], ["north", "center"])
		.addChildrenTo("canvasAttr", ["attrFilter", "attrEditList"], ["north", "center"])
		.addChildrenTo("_main_with_toc_",["main","_toc_"]).change("main",{region: "center"})
		.addToolbarTo("canvasAttr", "tlbAttrEditList")
		.addToolbarTo("canvasCateg", "tlbCategEditList");
	},
	
	/**
	 * Create toolbars
	 */
	_defineToolbars_: function() {
		this._getBuilder_()
		.beginToolbar("tlbAttrEditList", {dc: "attr"})
			.addTitle().addSeparator().addSeparator()
			.addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addReports()
		.end()
		.beginToolbar("tlbCategEditList", {dc: "categ"})
			.addTitle().addSeparator().addSeparator()
			.addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addReports()
		.end();
	}

});
