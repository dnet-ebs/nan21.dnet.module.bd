/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Dnet.ns.bd + "Locations_Lov" , {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.bd_Locations_Lov",
	displayField: "asString",
	listConfig: {
		getInnerTpl: function() {
			return '<span>{asString}</span>';
		},
		width:250, maxHeight:350
	},
	recordModel: Dnet.ns.bd + "LocationLov_Ds"
});
