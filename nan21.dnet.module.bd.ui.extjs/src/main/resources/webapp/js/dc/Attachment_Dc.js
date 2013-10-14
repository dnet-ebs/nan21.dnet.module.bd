/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Dnet.ns.bd + "Attachment_Dc" , {
	extend: "dnet.core.dc.AbstractDc",
	recordModel: Dnet.ns.bd + "Attachment_Ds",
			
			/* ================ Business functions ================ */
	
	doNew: function() {
		
		this.commands.doNew.execute();
		if (this._doNewWdw_ == null ) {
			this._doNewWdw_ = Ext.create("Ext.window.Window", {
				width:400, 
				height:200, 
				closable: false,
				closeAction: "hide",
				resizable:true, 
				layout:"fit", 
				modal:true,
				items: {
					_controller_:this,
					xtype:"bd_Attachment_Dc$Create"
				}	
			});
		}
		this._doNewWdw_.show();
	}

});

/* ================= FILTER FORM: Filter ================= */			

Ext.define(Dnet.ns.bd + "Attachment_Dc$Filter" , {
	extend: "dnet.core.dc.view.AbstractDcvFilterForm",
	alias: "widget.bd_Attachment_Dc$Filter",

	/**
	 * Components definition
	 */	
	_defineElements_: function() {
		this._getBuilder_()
		
		/* =========== controls =========== */
		.addTextField({ name:"name", dataIndex:"name"})
		.addLov({xtype:"bd_AttachmentTypes_Lov", name:"type", dataIndex:"type",
			retFieldMapping: [{lovField:"id", dsField: "typeId"} ]})
		.addTextField({ name:"targetType", dataIndex:"targetType"})
		
		/* =========== containers =========== */
		.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
		autoScroll:true, padding:"0 30 5 0"})
		.addPanel({ name:"col1", width:210, layout:"form"})
		.addPanel({ name:"col2", width:250, layout:"form"});
	},

	/**
	 * Combine the components
	 */				
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["col1", "col2"])
		.addChildrenTo("col1", ["name", "type"])
		.addChildrenTo("col2", ["targetType"]);
	}
});

/* ================= GRID: List ================= */

Ext.define(Dnet.ns.bd + "Attachment_Dc$List" , {
	extend: "dnet.core.dc.view.AbstractDcvGrid",
	alias: "widget.bd_Attachment_Dc$List",

	/**
	 * Columns definition
	 */
	_defineColumns_: function() {
		this._getBuilder_()
		.addTextColumn({ name:"type", dataIndex:"type", width:200})
		.addTextColumn({ name:"name", dataIndex:"name", width:200, renderer: function(v, md, rec, ri, ci, store) {return '<a href="javascript:void(0);"  onClick=\'javascript: window.open("'+rec.data.url+'", "Attachment", "location=1,status=1,scrollbars=1,width=660,height=500");\'>'+  rec.data.name  +'</a>';} })
		.addTextColumn({ name:"location", dataIndex:"location", hidden:true, width:200})
		.addTextColumn({ name:"url", dataIndex:"url", hidden:true, width:100})
		.addTextColumn({ name:"targetRefid", dataIndex:"targetRefid", hidden:true, width:100})
		.addTextColumn({ name:"targetAlias", dataIndex:"targetAlias", hidden:true, width:100})
		.addTextColumn({ name:"targetType", dataIndex:"targetType", hidden:true, width:200})
		.addDefaults();
	}
});

/* ================= EDIT FORM: Create ================= */

Ext.define(Dnet.ns.bd + "Attachment_Dc$Create" , {
	extend: "dnet.core.dc.view.AbstractDcvEditForm",
	alias: "widget.bd_Attachment_Dc$Create",

	/**
	 * Components definition
	 */
	_defineElements_: function() {
		this._getBuilder_()
		
		/* =========== controls =========== */
		.addLov({xtype:"bd_AttachmentTypes_Lov", name:"type", dataIndex:"type", allowBlank:false,
			retFieldMapping: [{lovField:"id", dsField: "typeId"} ],
			filterFieldMapping: [{lovField:"targetAlias", dsField: "targetAlias"}, {lovField:"targetType", dsField: "targetType"} ]})
		.addTextField({ name:"name", dataIndex:"name", allowBlank:false})
		.addTextField({ name:"location", dataIndex:"location"})
		.addButton({name:"btnUpload", scope: this, handler: this._createContinue_, text: "Select file"})
		.addButton({name:"btnSave", scope: this, handler: this._save_, text: "Save"})
		.addButton({name:"btnCancel", scope: this, handler: this._cancel_, text: "Cancel"})
		
		/* =========== containers =========== */
		.addPanel({ name:"main", autoScroll:true, layout:"form"});
	},

	/**
	 * Combine the components
	 */			
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["type", "name", "location"]);
		this.buttons = [this._getConfig_("btnUpload"),this._getConfig_("btnSave"),this._getConfig_("btnCancel")];
	},
	/* ==================== Business functions ==================== */
	
	_save_: function() {
		
		if (this.isValid()) {
			this._controller_.doSave();
		}
	},
	
	_cancel_: function() {
		
		this.up("window").hide();
		this._controller_.doCancel();
	},
	
	_createContinue_: function() {
		
		var rd = this._controller_.record.data;
		this._controller_._doNewWdw_.close();
		(new dnet.core.base.FileUploadWindow2(
			{
				_handler_ : "uploadAttachment",
				_fields_ : {							 
					a_id : {
						xtype : "hidden",
						value : rd.id
					},
					a_name : {
						xtype : "hidden",
						value : rd.name
					},
					a_type : {
						xtype : "hidden",
						value : rd.type
					},
					a_typeId : {
						xtype : "hidden",
						value : rd.typeId
					},
					a_targetAlias : {
						xtype : "hidden",
						value : rd.targetAlias
					},
					a_targetRefid : {
						xtype : "hidden",
						value : rd.targetRefid
					},
					a_targetType : {
						xtype : "hidden",
						value : rd.targetType
					}
				},
				_succesCallbackScope_ : this._controller_,
				_succesCallbackFn_ : function() {
					this.doCancel();
					(new Ext.util.DelayedTask(this.doQuery, this)).delay(100);
				}
			})).show();
	}
});
