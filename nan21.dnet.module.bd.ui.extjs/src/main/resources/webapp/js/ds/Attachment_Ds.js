/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
	
Ext.define(Dnet.ns.bd + "Attachment_Ds", {
	extend: 'Ext.data.Model',
	
	validations: [
		{field: "type", type: 'presence'},
		{field: "name", type: 'presence'}
	],
	
	fields: [
		{name:"targetRefid", type:"string"},
		{name:"targetAlias", type:"string"},
		{name:"targetType", type:"string"},
		{name:"name", type:"string"},
		{name:"location", type:"string"},
		{name:"url", type:"string"},
		{name:"typeId", type:"string"},
		{name:"type", type:"string"},
		{name:"category", type:"string"},
		{name:"baseUrl", type:"string"},
		{name:"id", type:"string"},
		{name:"clientId", type:"string"},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"modifiedBy", type:"string"},
		{name:"notes", type:"string"},
		{name:"active", type:"boolean"},
		{name:"version", type:"int", useNull:true},
		{name:"refid", type:"string"},
		{name:"entityAlias", type:"string"},
		{name:"entityFqn", type:"string"}
	]
});
