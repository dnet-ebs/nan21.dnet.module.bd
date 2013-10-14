/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
	
Ext.define(Dnet.ns.bd + "LocationLov_Ds", {
	extend: 'Ext.data.Model',
	
	fields: [
		{name:"targetRefid", type:"string"},
		{name:"asString", type:"string"},
		{name:"forBilling", type:"boolean"},
		{name:"forShipping", type:"boolean"},
		{name:"forMailing", type:"boolean"},
		{name:"active", type:"boolean"},
		{name:"id", type:"string"},
		{name:"clientId", type:"string"},
		{name:"refid", type:"string"}
	]
});
