/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.presenter.impl.geo.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.presenter.model.AbstractAuditableLov;
import net.nan21.dnet.module.bd.domain.impl.geo.Location;

@Ds(entity = Location.class)
public class LocationLov_Ds extends AbstractAuditableLov<Location> {

	public static final String f_targetRefid = "targetRefid";
	public static final String f_asString = "asString";
	public static final String f_forBilling = "forBilling";
	public static final String f_forShipping = "forShipping";
	public static final String f_forMailing = "forMailing";
	public static final String f_active = "active";

	@DsField
	private String targetRefid;

	@DsField(fetch = false)
	private String asString;

	@DsField
	private Boolean forBilling;

	@DsField
	private Boolean forShipping;

	@DsField
	private Boolean forMailing;

	@DsField
	private Boolean active;

	public LocationLov_Ds() {
		super();
	}

	public LocationLov_Ds(Location e) {
		super(e);
	}

	public String getTargetRefid() {
		return this.targetRefid;
	}

	public void setTargetRefid(String targetRefid) {
		this.targetRefid = targetRefid;
	}

	public String getAsString() {
		return this.asString;
	}

	public void setAsString(String asString) {
		this.asString = asString;
	}

	public Boolean getForBilling() {
		return this.forBilling;
	}

	public void setForBilling(Boolean forBilling) {
		this.forBilling = forBilling;
	}

	public Boolean getForShipping() {
		return this.forShipping;
	}

	public void setForShipping(Boolean forShipping) {
		this.forShipping = forShipping;
	}

	public Boolean getForMailing() {
		return this.forMailing;
	}

	public void setForMailing(Boolean forMailing) {
		this.forMailing = forMailing;
	}

	public Boolean getActive() {
		return this.active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}
}
