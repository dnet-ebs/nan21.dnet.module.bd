/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Dnet.ns.bd + "CommunicationMethod_Dc" , {
	extend: "dnet.core.dc.AbstractDc",
	recordModel: Dnet.ns.bd + "CommunicationMethod_Ds"
});

/* ================= EDIT-GRID: EditList ================= */

Ext.define(Dnet.ns.bd + "CommunicationMethod_Dc$EditList" , {
	extend: "dnet.core.dc.view.AbstractDcvEditableGrid",
	alias: "widget.bd_CommunicationMethod_Dc$EditList",
	_noImport_: true,

	/**
	 * Columns definition
	 */
	_defineColumns_: function() {
		this._getBuilder_()	
		.addLov({name:"type", dataIndex:"type", xtype:"gridcolumn", width:200, 
			editor:{xtype:"bd_CommunicationMethodTypes_Lov", selectOnFocus:true,
				retFieldMapping: [{lovField:"id", dsField: "typeId"} ],
				filterFieldMapping: [{lovField:"targetAlias", dsField: "targetAlias"}, {lovField:"targetType", dsField: "targetType"} ]}})
		.addTextColumn({name:"value", dataIndex:"value", width:200})
		.addDateColumn({name:"validFrom", dataIndex:"validFrom", _mask_: Masks.DATE })
		.addDateColumn({name:"validTo", dataIndex:"validTo", _mask_: Masks.DATE })
		.addTextColumn({name:"notes", dataIndex:"notes", width:200})
		.addTextColumn({name:"targetRefid", dataIndex:"targetRefid", hidden:true, width:100, noEdit: true})
		.addTextColumn({name:"targetAlias", dataIndex:"targetAlias", hidden:true, width:100, noEdit: true})
		.addTextColumn({name:"targetType", dataIndex:"targetType", hidden:true, width:200, noEdit: true})
		.addDefaults();
	}
});
