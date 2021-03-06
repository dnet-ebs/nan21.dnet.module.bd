/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Dnet.ns.bd + "AttachmentTypes_Lov" , {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.bd_AttachmentTypes_Lov",
	displayField: "name",
	listConfig: {
		getInnerTpl: function() {
			return '<span>{name}, {description}</span>';
		},
		width:250, maxHeight:350
	},
	_editDialog_: {
		name: "AttachmentType_Ui",
		bundle: Dnet.bundle.bd
	},
	recordModel: Dnet.ns.bd + "AttachmentTypeLov_Ds"
});
