/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Dnet.ns.bd + "AttributeSubSets_Lov" , {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.bd_AttributeSubSets_Lov",
	displayField: "code",
	listConfig: {
		getInnerTpl: function() {
			return '<span>{code}, {name}</span>';
		},
		width:250, maxHeight:350
	},
	_editDialog_: {
		name: "AttributeSet_Ui",
		bundle: Dnet.bundle.bd
	},
	recordModel: Dnet.ns.bd + "AttributeSubSetLov_Ds"
});
