/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.domain.impl.contact;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import net.nan21.dnet.core.domain.impl.AbstractAuditable;
import net.nan21.dnet.module.bd.domain.impl.contact.CommunicationMethodType;
import org.hibernate.validator.constraints.NotBlank;

/** 
 * Communication method values. Set phone number, messenger account, etc 
 * for each method type.  
 */
@Entity
@Table(name = CommunicationMethod.TABLE_NAME)
public class CommunicationMethod extends AbstractAuditable {

	public static final String TABLE_NAME = "BD_CMNC_MTD";

	private static final long serialVersionUID = -8865917134914502125L;

	@NotBlank
	@Column(name = "VALUE", nullable = false, length = 255)
	private String value;

	@Temporal(TemporalType.DATE)
	@Column(name = "VALIDFROM")
	private Date validFrom;

	@Temporal(TemporalType.DATE)
	@Column(name = "VALIDTO")
	private Date validTo;

	@NotBlank
	@Column(name = "TARGETREFID", nullable = false, length = 64)
	private String targetRefid;

	@NotBlank
	@Column(name = "TARGETALIAS", nullable = false, length = 64)
	private String targetAlias;

	@Column(name = "TARGETTYPE", length = 255)
	private String targetType;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = CommunicationMethodType.class)
	@JoinColumn(name = "TYPE_ID", referencedColumnName = "ID")
	private CommunicationMethodType type;

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Date getValidFrom() {
		return this.validFrom;
	}

	public void setValidFrom(Date validFrom) {
		this.validFrom = validFrom;
	}

	public Date getValidTo() {
		return this.validTo;
	}

	public void setValidTo(Date validTo) {
		this.validTo = validTo;
	}

	public String getTargetRefid() {
		return this.targetRefid;
	}

	public void setTargetRefid(String targetRefid) {
		this.targetRefid = targetRefid;
	}

	public String getTargetAlias() {
		return this.targetAlias;
	}

	public void setTargetAlias(String targetAlias) {
		this.targetAlias = targetAlias;
	}

	public String getTargetType() {
		return this.targetType;
	}

	public void setTargetType(String targetType) {
		this.targetType = targetType;
	}

	public CommunicationMethodType getType() {
		return this.type;
	}

	public void setType(CommunicationMethodType type) {
		if (type != null) {
			this.__validate_client_context__(type.getClientId());
		}
		this.type = type;
	}

	@PrePersist
	public void prePersist() {
		super.prePersist();
	}
}
