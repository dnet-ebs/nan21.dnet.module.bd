/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Dnet.ns.bd + "CommunicationMethodTypesAll_Lov" , {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.bd_CommunicationMethodTypesAll_Lov",
	displayField: "name",
	listConfig: {
		getInnerTpl: function() {
			return '<span>{name}, {description}</span>';
		},
		width:250, maxHeight:350
	},
	_editDialog_: {
		name: "CommunicationMethodTypes_Ui",
		bundle: Dnet.bundle.bd
	},
	recordModel: Dnet.ns.bd + "CommunicationMethodTypeAllLov_Ds"
});
