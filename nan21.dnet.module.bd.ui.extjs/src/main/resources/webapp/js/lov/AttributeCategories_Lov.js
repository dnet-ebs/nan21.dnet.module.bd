/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Dnet.ns.bd + "AttributeCategories_Lov" , {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.bd_AttributeCategories_Lov",
	displayField: "code",
	listConfig: {
		getInnerTpl: function() {
			return '<span>{code}, {name}</span>';
		},
		width:250, maxHeight:350
	},
	_editDialog_: {
		name: "AttributeDefinition_Ui",
		bundle: Dnet.bundle.bd,
		tocElement: "canvasCateg"
	},
	recordModel: Dnet.ns.bd + "AttributeCategoryLov_Ds"
});
