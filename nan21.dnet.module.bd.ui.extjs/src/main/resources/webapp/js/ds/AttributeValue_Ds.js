/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
	
Ext.define(Dnet.ns.bd + "AttributeValue_Ds", {
	extend: 'Ext.data.Model',
	
	validations: [
		{field: "attribute", type: 'presence'}
	],
	
	fields: [
		{name:"value", type:"string"},
		{name:"targetRefid", type:"string"},
		{name:"subSetId", type:"string"},
		{name:"subSet", type:"string"},
		{name:"subSetName", type:"string"},
		{name:"subSetNo", type:"int", useNull:true},
		{name:"attributeId", type:"string"},
		{name:"attribute", type:"string"},
		{name:"attributeName", type:"string"},
		{name:"attributeDataType", type:"string"},
		{name:"attributeListOfvalues", type:"string"},
		{name:"setAttributeId", type:"string"},
		{name:"setAttributeNo", type:"int", useNull:true},
		{name:"setAttributeListOfvalues", type:"string"},
		{name:"attributeSetId", type:"string"},
		{name:"attributeSet", type:"string"},
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
