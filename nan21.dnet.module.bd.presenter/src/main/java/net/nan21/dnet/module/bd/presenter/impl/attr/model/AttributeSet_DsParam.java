/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.presenter.impl.attr.model;

public class AttributeSet_DsParam {

	public static final String f_subSetCode = "subSetCode";
	public static final String f_subSetName = "subSetName";

	private String subSetCode;

	private String subSetName;

	public String getSubSetCode() {
		return this.subSetCode;
	}

	public void setSubSetCode(String subSetCode) {
		this.subSetCode = subSetCode;
	}

	public String getSubSetName() {
		return this.subSetName;
	}

	public void setSubSetName(String subSetName) {
		this.subSetName = subSetName;
	}
}
