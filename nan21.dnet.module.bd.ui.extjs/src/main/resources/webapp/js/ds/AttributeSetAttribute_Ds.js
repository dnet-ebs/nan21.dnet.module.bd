/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
	
Ext.define(Dnet.ns.bd + "AttributeSetAttribute_Ds", {
	extend: 'Ext.data.Model',
	
	validations: [
		{field: "sequenceNo", type: 'presence'},
		{field: "attributeSet", type: 'presence'},
		{field: "attribute", type: 'presence'}
	],
	
	initRecord: function() {
		this.set("sequenceNo", 10);
		this.set("active", true);
	},
	
	fields: [
		{name:"sequenceNo", type:"int", useNull:true},
		{name:"inDescription", type:"boolean"},
		{name:"attributeId", type:"string"},
		{name:"attribute", type:"string"},
		{name:"attributeName", type:"string"},
		{name:"attributeSetId", type:"string"},
		{name:"attributeSet", type:"string"},
		{name:"attributeSetName", type:"string"},
		{name:"attributeSubSetId", type:"string"},
		{name:"attributeSubSet", type:"string"},
		{name:"attributeSubSetName", type:"string"},
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
