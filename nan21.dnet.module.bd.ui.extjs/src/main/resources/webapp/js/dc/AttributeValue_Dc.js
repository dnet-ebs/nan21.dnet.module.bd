/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Dnet.ns.bd + "AttributeValue_Dc" , {
	extend: "dnet.core.dc.AbstractDc",
	recordModel: Dnet.ns.bd + "AttributeValue_Ds"
});

/* ================= FILTER: CtxFilter ================= */


Ext.define(Dnet.ns.bd + "AttributeValue_Dc$CtxFilter" , {
	extend: "dnet.core.dc.view.AbstractDcvFilterPropGrid",
	alias: "widget.bd_AttributeValue_Dc$CtxFilter",

	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addLov({xtype:"bd_AttributeSubSets_Lov", name:"subSet", dataIndex:"subSet", caseRestriction:"uppercase",
				editor:{_fqn_:Dnet.ns.bd + "AttributeSubSets_Lov" , selectOnFocus:true, caseRestriction:"uppercase",
					retFieldMapping: [{lovField:"id", dsField: "subSetId"} ]}})
			.addLov({xtype:"bd_Attributes_Lov", name:"attribute", dataIndex:"attribute", caseRestriction:"uppercase",
				editor:{_fqn_:Dnet.ns.bd + "Attributes_Lov" , selectOnFocus:true, caseRestriction:"uppercase",
					retFieldMapping: [{lovField:"id", dsField: "attributeId"} ]}})
		;
	}

});

/* ================= EDIT-GRID: CtxEditList ================= */

Ext.define(Dnet.ns.bd + "AttributeValue_Dc$CtxEditList" , {
	extend: "dnet.core.dc.view.AbstractDcvEditableGrid",
	alias: "widget.bd_AttributeValue_Dc$CtxEditList",

	/**
	 * Columns definition
	 */
	_defineColumns_: function() {
		this._getBuilder_()	
		.addNumberColumn({name:"subSetNo", dataIndex:"subSetNo", hidden:true, align:"right", width:70, format:"0", noEdit: true })
		.addTextColumn({name:"subSet", dataIndex:"subSet", hidden:true, width:120, caseRestriction:"uppercase"})
		.addTextColumn({name:"subSetName", dataIndex:"subSetName", width:200, noEdit: true})
		.addNumberColumn({name:"setAttributeNo", dataIndex:"setAttributeNo", hidden:true, align:"right", width:70, format:"0", noEdit: true })
		.addTextColumn({name:"attribute", dataIndex:"attribute", hidden:true, width:120, caseRestriction:"uppercase", noEdit: true})
		.addTextColumn({name:"attributeName", dataIndex:"attributeName", width:200, noEdit: true})
		.addTextColumn({name:"value", dataIndex:"value", width:250})
		.addTextColumn({name:"targetRefid", dataIndex:"targetRefid", hidden:true, width:100, noEdit: true})
		.addTextColumn({name:"subSetId", dataIndex:"subSetId", hidden:true, width:100, noEdit: true})
		.addTextColumn({name:"attributeId", dataIndex:"attributeId", hidden:true, width:100, noEdit: true})
		.addTextColumn({name:"setAttributeId", dataIndex:"setAttributeId", hidden:true, width:100, noEdit: true})
		.addTextColumn({name:"attributeSetId", dataIndex:"attributeSetId", hidden:true, width:100, noEdit: true})
		.addDefaults();
	},
	/* ==================== Business functions ==================== */
	
	_getCustomCellEditor_: function(record,column) {
		
		var ed = null;
		
		if (!Ext.isEmpty(record.data.setAttributeListOfvalues)) {
			ed = new Ext.form.field.ComboBox({store:record.data.setAttributeListOfvalues.split(",")});
		} else if (!Ext.isEmpty(record.data.attributeListOfvalues)) {
			ed = new Ext.form.field.ComboBox({store:record.data.attributeListOfvalues.split(",")});
		} else if (record.data.attributeDataType == "integer" || record.data.attributeDataType == "decimal") {
			ed = new Ext.form.field.Number({ 
				fieldStyle : "text-align:right;",
				hideTrigger : true,
				keyNavEnabled : false,
				mouseWheelEnabled : false
			});
		} else if (record.data.attributeDataType == "date") {
			ed = new Ext.form.field.Date({});
		} else if (record.data.attributeDataType == "boolean") {
			ed = new dnet.core.lov.LocalCombo({store:["true","false"]});
		}
		if(ed){
		    ed._dcView_ =  this;
		}
		return ed
	}
});
