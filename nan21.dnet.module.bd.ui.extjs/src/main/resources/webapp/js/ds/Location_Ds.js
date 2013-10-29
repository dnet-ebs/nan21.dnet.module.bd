/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
	
Ext.define(Dnet.ns.bd + "Location_Ds", {
	extend: 'Ext.data.Model',
	
	fields: [
		{name:"regionName", type:"string"},
		{name:"cityName", type:"string"},
		{name:"adress", type:"string"},
		{name:"zip", type:"string"},
		{name:"shipping", type:"boolean"},
		{name:"billing", type:"boolean"},
		{name:"mailing", type:"boolean"},
		{name:"targetRefid", type:"string"},
		{name:"countryId", type:"string"},
		{name:"country", type:"string"},
		{name:"countryIso2", type:"string"},
		{name:"regionId", type:"string"},
		{name:"region", type:"string"},
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
