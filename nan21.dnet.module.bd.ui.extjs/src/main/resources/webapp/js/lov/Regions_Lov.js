/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Dnet.ns.bd + "Regions_Lov" , {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.bd_Regions_Lov",
	displayField: "code",
	listConfig: {
		getInnerTpl: function() {
			return '<span>{code}, {name}, {country}</span>';
		},
		width:250, maxHeight:350
	},
	_editDialog_: {
		name: "Region_Ui",
		bundle: Dnet.bundle.bd
	},
	recordModel: Dnet.ns.bd + "RegionLov_Ds"
});
