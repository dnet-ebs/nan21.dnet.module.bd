/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Dnet.ns.bd + "AttributeSetAttributes_Lov" , {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.bd_AttributeSetAttributes_Lov",
	displayField: "attribute",
	listConfig: {
		getInnerTpl: function() {
			return '<span>{attribute}, {attributeName}</span>';
		},
		width:250, maxHeight:350
	},
	_editDialog_: {
		name: "AttributeSet_Ui",
		bundle: Dnet.bundle.bd,
		tocElement: "canvasSetAttr"
	},
	recordModel: Dnet.ns.bd + "AttributeSetAttributeLov_Ds"
});
