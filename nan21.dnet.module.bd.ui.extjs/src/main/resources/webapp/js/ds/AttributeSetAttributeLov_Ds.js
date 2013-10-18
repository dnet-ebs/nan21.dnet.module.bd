/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
	
Ext.define(Dnet.ns.bd + "AttributeSetAttributeLov_Ds", {
	extend: 'Ext.data.Model',
	
	fields: [
		{name:"id", type:"string"},
		{name:"attributeId", type:"string"},
		{name:"attribute", type:"string"},
		{name:"attributeName", type:"string"},
		{name:"attributeSetId", type:"string"},
		{name:"attributeSubSetId", type:"string"},
		{name:"id", type:"string"},
		{name:"clientId", type:"string"},
		{name:"refid", type:"string"}
	]
});
